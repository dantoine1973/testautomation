package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/ContactUsNeg.feature", glue = {
		"step_definitions/negative", "step_definitions/hooks" }, plugin = { "pretty",
				"html:target/cucumber-reports/contactussteps.html" })
public class CucumberContactUsNegTest extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}