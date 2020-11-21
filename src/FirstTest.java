import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
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

//        for skipping first page
        waitForElementByXpathAndClick(
                "//*[contains(@text, 'SKIP')]",
                "Cannot find Skip element",
                5);
    }

//    @After
//    public void tearDown()
//    {
//        driver.quit();
//    }
//
//    @Test
//    public void firstTest() {
//        waitForElementByXpathAndClick(
//                "//*[contains(@text, 'Search Wikipedia')]",
//                "Cannot find search field",
//                5
//        );
//
//        waitForElementByXpathAndSendKeys(
//                "//*[contains(@text, 'Search Wikipedia')]",
//                "Java",
//                "Cannot find search field",
//                5
//        );
//
//        waitForElementPresentByXpath(
//                "//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='Object-oriented programming language']",
//                "Cannot find search input",
//                15);
//    }

    @Test
    public void testCancelSearch() {
        waitForElementByXpathAndClick(
                "//*[contains(@text, 'Search Wikipedia')]",
                "Cannot find search field",
                5
        );

        waitForElementByXpathAndSendKeys(
                "//*[contains(@text, 'Search Wikipedia')]",
                "J",
                "Cannot find search field",
                5
        );

//        Caused by: org.openqa.selenium.InvalidSelectorException: Locator Strategy 'css selector' is not supported for this session
//        waitForElementByIdAndClick(
//                "org.wikipedia:id/search_close_btn",
//                "Cannot find X element to cancel search",
//                7
//        );

        waitForElementByXpathAndClick(
                "//*[@resource-id='org.wikipedia:id/search_close_btn']",
                "Cannot find X element to cancel search",
                7
        );

        waitForElementNotPresent(
                "org.wikipedia:id/search_close_btn",
                "X element is still on page",
                5
        );
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

    private WebElement waitForElementByXpathAndClick(String xpath, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresentByXpath(xpath, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementByXpathAndSendKeys(String xpath, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresentByXpath(xpath, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private WebElement waitForElementPresentById(String id, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.id(id);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementByIdAndClick(String id, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresentById(id, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private boolean waitForElementNotPresent(String id, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.id(id);
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
}
