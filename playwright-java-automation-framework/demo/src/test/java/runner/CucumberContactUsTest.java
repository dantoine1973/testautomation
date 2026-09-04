package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/ContactUs.feature", glue = {
        "step_definitions.positive", "step_definitions.hooks" }, plugin = {
        "pretty", "html:target/cucumber-reports/contactussteps.html",
    "json:target/cucumber-reports/contactussteps.json" })
public class CucumberContactUsTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}