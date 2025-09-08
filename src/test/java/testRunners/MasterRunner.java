package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",   // path to your feature files
        glue = {"stepDefinitions", "hooks"}, // step defs + hooks
        
        plugin = {
                "pretty",                                      // readable console output
                "html:target/cucumber-reports/cucumber.html",  // HTML report
                "json:target/cucumber-reports/cucumber.json",  // JSON report
                "junit:target/cucumber-reports/cucumber.xml",   // JUnit report
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" //extent report
                
           
                
        },
        monochrome = true  // cleaner console output
          // Cucumber cloud reporting (optional)
        
)
public class MasterRunner extends AbstractTestNGCucumberTests {
}
