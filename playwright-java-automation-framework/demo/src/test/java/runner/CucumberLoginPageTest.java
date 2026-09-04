package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/LoginPage.feature", glue = {
                "step_definitions.other", "step_definitions.hooks" }, tags = "@regression", plugin = { "pretty",
                                "json:target/cucumber-reports/loginportal.json",
                                "html:target/cucumber-reports/loginportal.html" })

public class CucumberLoginPageTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
