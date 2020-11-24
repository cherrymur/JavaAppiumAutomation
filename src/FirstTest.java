import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

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
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'SKIP')]"),
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
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search field",
//                5);
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Java",
//                "Cannot find search field",
//                5);
//
//        waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']" +
//                                "[@text='Object-oriented programming language']"),
//                "Cannot find search input",
//                15);
//    }
//
//    @Test
//    public void testCancelSearch() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search field",
//                5);
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Java",
//                "Cannot find search field",
//                5);
//
//        waitForElementAndClear(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search field",
//                5);
//
////        Caused by: org.openqa.selenium.InvalidSelectorException: Locator Strategy 'css selector' is not supported for this session
////        waitForElementAndClick(
////                By.id("org.wikipedia:id/search_close_btn"),
////                "Cannot find X element to cancel search",
////                7);
//
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/search_close_btn']"),
//                "Cannot find X element to cancel search",
//                5);
//
//        waitForElementNotPresent(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "X element is still on page",
//                5);
//    }
//
//    @Test
//    public void testCompareArticleTitle()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search field",
//                5);
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Java",
//                "Cannot find search field",
//                5);
//
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']" +
//                        "[@text='Object-oriented programming language']"),
//                "Cannot find search input",
//                15);
//
//        assertElementHasText(
//                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]"),
//                "Java (programming language)",
//                "We see unexpected title"
//        );
//    }
//
//    @Test
//    public void testSearchFieldContainsText() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find search field",
//                5);
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Java",
//                "Cannot find search field",
//                5);
//
//        assertElementHasText(
////                By.id("org.wikipedia:id/search_src_text"),
//                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText\n"),
//                "Java",
//                "We see unexpected search word"
//        );
//    }


    @Test
    public void SearchResultsFieldContainText() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search field",
                5);

        waitForElementsPresent(
              By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]"),
                "Can't find elements",
                5);

        assertElementsHaveText(
//                By.id("org.wikipedia:id/search_src_text"),
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText\n"),
                "Java*",
                "We see unexpected search word"
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    private void assertElementHasText(By by, String expected, String error_message)
    {
        WebElement title_element = waitForElementPresent(by, "Cannot find an element", 15);
        String article_title=title_element.getText();
        Assert.assertEquals(error_message, expected, article_title);
    }

    private List<WebElement> waitForElementsPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(by)
        );
    }

    private void assertElementsHaveText(By by, String expected, String error_message)
    {
        List<WebElement> list_elements = waitForElementsPresent(by, "Cannot find elements", 15);

        for (int i = 0; i < list_elements.size(); i = i+1) {
            String article_title = list_elements.get(i).getText();
            Assert.
                (error_message, expected, article_title);
        }
    }
}