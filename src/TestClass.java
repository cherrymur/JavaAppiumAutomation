import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class TestClass {

    private AppiumDriver driver;

    public void setUp() throws Exception {
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
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'SKIP')]"),
                "Cannot find Skip element",
                5);
    }

    public void tearDown()
    {
        driver.quit();
    }

    WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    protected WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    void assertElementHasText(By by, String expected, String error_message) {
        WebElement title_element = waitForElementPresent(by, "Cannot find an element", 15);
        String article_title = title_element.getText();
        Assert.assertEquals(error_message, expected, article_title);
    }

    private List<WebElement> waitForElementsPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(by)
        );
    }

    void assertElementsHaveText(By by, String expected, String error_message) {
        List<WebElement> list_element = waitForElementsPresent(by, error_message, 5);

        for (WebElement title_element : list_element) {
            String article_title = title_element.getText();
            Assert.assertThat(article_title, CoreMatchers.containsString(expected));
        }
    }

    protected void swipeUp (int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int)(size.height * 0.8);
        int end_y = (int)(size.height * 0.2);

        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();
    }

    protected void swipeUpQuick () {
        swipeUp(200);
    }

    protected void swipeUpToFindElement(By by, String error_message, int max_swipe){

        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swipe > max_swipe) {
                waitForElementPresent(by, "Cannot find element by swiping uo. \n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swipe;
        }
    }

    protected void swipeToTheLeftElement(By by, String error_message){
       WebElement element = waitForElementPresent(by, "Cannot find element by swipe the element. \n"
               + error_message, 5);
       int left_x = element.getLocation().getX();
       int right_x = left_x + element.getSize().getWidth();
       int upper_y = element.getLocation().getY();
       int lower_y = upper_y + element.getSize().getHeight();
       int middle_y = (upper_y + lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action.press(right_x, middle_y)
               .waitAction(300)
               .moveTo(left_x, middle_y)
               .release()
               .perform();
    }

    public int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }

    protected void assertElementNotPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + by.toString() + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }

    protected void RotateLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void RotatePORTRAIT()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
}