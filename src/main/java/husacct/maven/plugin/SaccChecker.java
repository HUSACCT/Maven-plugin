package husacct.maven.plugin;

import husacct.externalinterface.ExternalServiceProvider;
import husacct.externalinterface.SaccCommandDTO;
import husacct.externalinterface.ViolationImExportDTO;
import husacct.externalinterface.ViolationReportDTO;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.jdom2.Document;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

@Mojo(name="husacct")
public class SaccChecker extends AbstractMojo {
    @Parameter
    private File workspacePath;

    @Parameter
    private String[] sourcePaths;

    @Parameter
    private File previousViolationsPath;


    @Parameter
    private boolean failOnNewViolations;

    @Parameter
    private Integer maxViolations;


    private Log logger = getLog();

    private SaccCommandDTO saccCommandDTO;
    private ViolationReportDTO violationReport = null;

    public void execute() throws MojoExecutionException, MojoFailureException {
        logger.info("Starting SACC with HUSACCT on workspace: " + workspacePath);
//        System.setProperty("java.awt.headless", "true");
        printStartupConfiguration();
        validateConfiguration();

        saccCommandDTO = new SaccCommandDTO();
        saccCommandDTO.setHusacctWorkspaceFile(workspacePath.getAbsolutePath());

        ArrayList<String> validSourcePaths = validateSourcePaths();

        if (validSourcePaths.isEmpty()) {
            throw new MojoExecutionException("No valid sourcepaths found!");
        }

        saccCommandDTO.setSourceCodePaths(validSourcePaths);

        if (previousViolationsPath != null && previousViolationsPath.isFile()) {
            saccCommandDTO.setImportFilePreviousViolations(previousViolationsPath.getAbsolutePath());
        } else {
            logger.info("No valid previous violations specified, skipping.");
        }
        saccCommandDTO.setExportAllViolations(true);

        executeComplianceCheck();
        if (!isSourceCodeAnalysedSuccessfully()) {
            throw new MojoFailureException("Source code was not analyzed successfully!");
        }
        logger.info("Finished HUSACCT check.");

        if (areNewViolations()) {
            throw new MojoFailureException("New SACC violations found");
        }

        if (areTooManyViolations()) {
            String maxViolations = this.maxViolations.toString();
            String foundViolations = String.valueOf(this.violationReport.getNrOfAllCurrentViolations());
            throw new MojoFailureException(MessageFormat.format("Too many SACC violations found (max {0}, found {1}", maxViolations, foundViolations));
        }

    }


    public boolean isSourceCodeAnalysedSuccessfully() {
        return violationReport != null && (violationReport.getNrOfAllCurrentDependencies() > 0);
    }

    protected void validateConfiguration() throws MojoFailureException, MojoExecutionException {
        if (workspacePath == null || !workspacePath.isFile()) {
            throw new MojoFailureException("Workspace path is not a file or does not exist.");
        }
        if (sourcePaths == null || sourcePaths.length < 0 ) {
            throw new MojoExecutionException("No sourcepaths set");
        }
    }

    protected void printStartupConfiguration() {
        logger.info("Running HUSACCT check in " + System.getProperty("user.dir"));
        logger.info("Workspace Path " + workspacePath);
        logger.info("Sourcepaths " + Arrays.toString(sourcePaths));
        logger.info("Previous Violations " + previousViolationsPath);
        logger.info("Fail on new violations " + failOnNewViolations);
        logger.info("Max violations " + maxViolations);

    }


    protected ArrayList<String> validateSourcePaths() {
        ArrayList<String> validSourcePaths = new ArrayList<>();
        for (String sourcePath : sourcePaths) {
            File f = new File(sourcePath);
            if (f.isDirectory()) {
                String filePath = f.getAbsolutePath();
                String normalized = FilenameUtils.normalize(filePath);
                validSourcePaths.add(normalized);
            } else {
                logger.info("Ignoring path " + f + " because the path is not valid");
            }
        }
        return validSourcePaths;
    }

    private void executeComplianceCheck() {
        ExternalServiceProvider externalServiceProvider = ExternalServiceProvider.getInstance();
        violationReport = externalServiceProvider.performSoftwareArchitectureComplianceCheck(saccCommandDTO);
    }

    private boolean areNewViolations() {
        assert isSourceCodeAnalysedSuccessfully();
        return violationReport.getNrOfNewViolations() > 0;
    }

    private boolean areTooManyViolations() {
        assert isSourceCodeAnalysedSuccessfully();
        return maxViolations != null && violationReport.getNrOfAllCurrentViolations() > maxViolations;
    }


}
