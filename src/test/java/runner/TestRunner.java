package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Account.feature",
                "src/test/resources/features/Login.feature",
                "src/test/resources/features/Registration.feature"},
        glue = {"stepDefinitions", "hooks"},  // Include și hooks
        tags = "@SmokeTest or @Regression",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner {
}