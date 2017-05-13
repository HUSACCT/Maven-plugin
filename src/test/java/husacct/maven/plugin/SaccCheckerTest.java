package husacct.maven.plugin;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SaccCheckerTest extends AbstractMojoTestCase{
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testInvalidWorkSpace() throws Exception {
        File pom = getTestFile("src/test/resources/sacc-project/invallidworkspace-pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        SaccChecker saccChecker = (SaccChecker) lookupMojo("husacct", pom);
        try {
            saccChecker.execute();
        } catch (MojoFailureException e) {
            if (e.getMessage().equals("Workspace path is not a file or does not exist.")) {
                return; // Valid result
            } else {
                fail("Other exception message was given: " + e.getMessage());
                System.out.println("Expected message: Workspace path is not a file or does not exist.");
            }
        }
        fail("Invallid workspace path is accepted");
    }

    public void testInvalidSourcePaths() throws Exception {
        File pom = getTestFile("src/test/resources/sacc-project/invalidsourcepaths-pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        SaccChecker saccChecker = (SaccChecker) lookupMojo("husacct", pom);

        ArrayList<String> validSourcePaths = saccChecker.validateSourcePaths();
        System.out.println(validSourcePaths);
        System.out.println(getRelativeFilePath("src/"));
        assertTrue(validSourcePaths.contains(getRelativeFilePath("src")));
        assertFalse(validSourcePaths.contains(getRelativeFilePath("NonExistant")));
    }

    private String combinePaths(String path1, String path2) {
        String concatted = FilenameUtils.concat(path1, path2);
        return FilenameUtils.normalize(concatted);
    }

    private String getRelativeFilePath(String FilePath) {
        return combinePaths(System.getProperty("user.dir"), FilePath);
    }



}