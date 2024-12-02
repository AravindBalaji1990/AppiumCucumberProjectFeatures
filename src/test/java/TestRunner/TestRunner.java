package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"ApiDemosstepDefintions","SwaglabStepdefintions"},
        dryRun = false,
        plugin = {"pretty","html:cucumber-report.html"},
        monochrome = true,
        tags = "@swaglab"
)
public class TestRunner {


}
