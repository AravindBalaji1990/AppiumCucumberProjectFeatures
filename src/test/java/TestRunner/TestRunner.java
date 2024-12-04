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
//        tags = "@swaglab and  @apidemo" // this will fail as no scenario has both tags
//        tags = "@swaglab or  @apidemo" // this will run as we have seprate scenario for the tags
        tags = "@swaglab and not  @apidemo" // this will runonly swag lab
)
public class TestRunner {


}
