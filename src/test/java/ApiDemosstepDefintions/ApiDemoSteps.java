package ApiDemosstepDefintions;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ApiDemoSteps {

    AndroidDriver driver;

    @Given("User opens the api demo application")
    public void user_opens_the_api_demo_application() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);

        // calling the andorid driver to run the app
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }
    @When("User lands on the dashboard od the app")
    public void user_lands_on_the_dashboard_od_the_app() {

        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Access'ibility\"]")).isDisplayed());

    }

    @Then("User checks Text field is available")
    public void user_checks_text_field_is_available() {
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).isDisplayed());

    }


    @Then("User validate the field to be verified {string}")
    public void user_validate_the_field_to_be_verified(String data) {
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='"+data+"']")).isDisplayed());

    }

    @Then("User close the app")
    public void user_close_the_app() {

        driver.quit();
    }

    @Then("User validate the field to be verified with below table")
    public void user_validate_the_field_to_be_verified_with_below_table_field(DataTable datatable) {

        List<Map<String,String>> data = datatable.asMaps(String.class,String.class);
        for(Map<String, String> dataoptions: data) {
            WebElement element = driver.findElement
                    (AppiumBy.xpath("//android.widget.TextView[@content-desc='"+dataoptions.get("field")+"']"));
            Assert.assertTrue(element.isDisplayed());
        }

    }

}
