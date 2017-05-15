package husacct.maven.plugin;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.util.ArrayList;

public class Game31Test extends AbstractMojoTestCase{
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testValidGame31Project() throws Exception {
        File pom = getTestFile("src/test/resources/game31-validarchitecture/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        SaccChecker saccChecker = (SaccChecker) lookupMojo("husacct", pom);
        saccChecker.execute();
    }

    public void testInvallidGame31Project() throws Exception {
        File pom = getTestFile("src/test/resources/game31-invallidarchitecture/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        SaccChecker saccChecker = (SaccChecker) lookupMojo("husacct", pom);
        try {
            saccChecker.execute(); // Code should throw exception here
            fail("Execution should have thrown a MojoFailureException but did not.");
        } catch (MojoFailureException e) {
            if (!e.getMessage().contains("Too many SACC violations found")) {
                fail("The expected exception was TOo many SACC violations found, actual message was" + e.getMessage());
            }
        }

    }

}