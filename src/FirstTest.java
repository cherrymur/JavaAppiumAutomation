import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\olga.avramenko\\Desktop\\Mobile_testing\\" +
                "JavaAppiumAutomatiom\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        WebElement element = driver.findElementByXPath("//*[contains(@text, 'SKIP')]");
        element.click();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void firstTest() {
        WebElement element_search;
        element_search = waitForElementPresentByXpath(
                "//*[contains(@text, 'Search Wikipedia')]",
                "Cannot find search input");
        element_search.click();

        WebElement element_enter_search = waitForElementPresentByXpath(
                "//*[contains(@text, 'Search Wikipedia')]",
                "Cannot find search input");
        element_enter_search.sendKeys("Airport");
    }

    private WebElement waitForElementPresentByXpath(String xpath, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.xpath(xpath);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresentByXpath(String xpath, String error_message)
    {
        return waitForElementPresentByXpath(xpath, error_message, 5);
    }
}
