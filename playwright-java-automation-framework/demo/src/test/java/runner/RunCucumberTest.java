package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Logger;

@CucumberOptions(features = "src/test/resources/features", glue = {
        "step_definitions" }, tags = "", plugin = { "pretty",
                "html:target/cucumber-reports/runcucumbertest.html" })

public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    private static final Logger logger = Logger.getLogger(RunCucumberTest.class.getName());
    private static final Properties properties = new Properties();

    static {
        Path configPath = Paths.get(System.getProperty("config.path",
                Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "config.properties").toString()));
        try (InputStream input = Files.newInputStream(configPath)) {
            properties.load(input);
        } catch (IOException e) {
            logger.severe("Error loading configuration file: " + e.getMessage());
        }
    }

    private static int getThreadCount() {
        String threadCountStr = properties.getProperty("threadCount", "1");
        try {
            return Integer.parseInt(threadCountStr);
        } catch (NumberFormatException e) {
            logger.warning("Invalid threadCount value in config.properties: " + threadCountStr + ". Defaulting to 1.");
            return 1;
        }
    }

    public static void main(String[] args) {

        // initialize TestNG and XmlSuite
        TestNG testNG = new TestNG();
        XmlSuite xmlSuite = new XmlSuite();

        // Get the browser name and headless mode from the properties file
        String browserNameString = properties.getProperty("browser", "chromium");
        boolean headless = Boolean.parseBoolean(
                properties.getProperty("headless", "false"));

        System.setProperty("browser", browserNameString);
        System.setProperty("headless", Boolean.toString(headless));

        int threadCount = getThreadCount();

        // Set the suite name and thread count
        xmlSuite.setName("RunCucumberTestSuite");
        xmlSuite.setParallel(XmlSuite.ParallelMode.CLASSES);
        xmlSuite.setThreadCount(threadCount);
        xmlSuite.setDataProviderThreadCount(threadCount);

        // Add the suite to TestNG
        testNG.setXmlSuites(java.util.Arrays.asList(xmlSuite));

        // Create a new TestNG test and add it to the suite
        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("Cucumber Tests");
        xmlTest.setXmlClasses(Collections.singletonList(new XmlClass(RunCucumberTest.class)));

        // Run the tests
        testNG.setUseDefaultListeners(false);
        testNG.setXmlSuites(Collections.singletonList(xmlSuite));
        try {
            testNG.run();
        } finally {
            System.exit(testNG.getStatus());
        }
    }
}
