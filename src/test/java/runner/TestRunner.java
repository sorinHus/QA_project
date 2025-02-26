package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".//src/test/resources/features/Registration.feature",
                ".//src/test/resources/features/Login.feature",
                ".//src/test/resources/features/Account.feature"},
        glue = {"stepDefinitions", "hooks"},  // Include și hooks
        tags = "@RegPoz or @RegNeg or @logNeg or @logPoz or @newAcc or @newLoan or @logOut",
        plugin = {"pretty", "html:reports/myreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class TestRunner {
}