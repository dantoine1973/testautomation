package step_definitions.hooks;

import com.example.PlaywrightBase2;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends PlaywrightBase2 {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("\nExecuting test suite...");
    }

    @Before
    public void setUpScenario() {
        startPlaywright();
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(
                takeScreenShot(),
                "image/png",
                "Failure Screenshot"
            );
        }

        stopPlaywright();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("\nFinished executing test suite");
    }
}