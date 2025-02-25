package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//src/test/resources/features/Registration.feature",
        glue = {"stepDefinitions", "hooks"},  // Include și hooks
        tags = "@Sanity or @SmokeTest",
        plugin = {"pretty", "html:reports/myreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class TestRunner {
}