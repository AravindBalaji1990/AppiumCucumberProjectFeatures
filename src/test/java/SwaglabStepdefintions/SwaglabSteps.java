package SwaglabStepdefintions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SwaglabSteps {
    AndroidDriver driver;

    @Given("User opens the swaglab app")
    public void user_opens_the_swaglab_app() throws InterruptedException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppWaitForLaunch(true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(5000);

    }

    @Given("User enters the {} and {}")
    public void user_enters_the_problem_user_and_secret_sauce(String username, String password) {
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys(username);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys(password);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]")).click();

    }

    @Then("User validates the dashbaord of the app")
    public void user_validates_the_dashbaord_of_the_app() {
        Assert.assertTrue(waitForElmentSizeMinimum(driver,60,AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]"),1)>1);
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).isDisplayed());

    }

    public static int waitForElmentSizeMinimum(AndroidDriver driver, long seconds, By locator, int num){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, num)).size();
    }

    @Then("User close the swaglab app")
    public void user_close_the_swaglab_app() {
        driver.quit();
    }

}
