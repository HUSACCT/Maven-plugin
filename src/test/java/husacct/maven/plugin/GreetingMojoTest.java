package husacct.maven.plugin;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.After;
import org.junit.Before;

import java.io.File;

import static org.junit.Assert.*;

public class GreetingMojoTest extends AbstractMojoTestCase {
    @Before
    public void setUp() throws Exception {
        super.setUp();

    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGreetingMessage() throws Exception {
        File pom = getTestFile("src/test/resources/greeting-project/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        GreetingMojo greetingMojo = (GreetingMojo) lookupMojo("sayhi", pom);
        assertNotNull(greetingMojo);
        assertEquals("Hello, world.", greetingMojo.getMessage());




    }

}