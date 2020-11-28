import org.junit.Test;
import org.openqa.selenium.By;

public class saveDeleteFirstArticleToListTest extends TestClass {

    @Test
    public void testSwipeArticleTitle() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Appium",
                "Cannot find search field",
                5);

        String name_of_article = "Appium";

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']" +
                        "[@text='" + name_of_article + "']"),
                "Cannot find search input",
                5);

        this.assertElementHasText(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                        "android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
                        "android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/" +
                        "android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/" +
                        "android.view.View[1]/android.view.View[1]"),
                name_of_article,
                "The article '" + name_of_article + "' is not opened");

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/article_menu_bookmark'][@text='Save']"),
                "We have a trouble to find the element Save",
                5);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/snackbar_action'][@text='ADD TO LIST']"),
                "We have a trouble to find the element 'Add to list'",
                5);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/onboarding_button'][@text='GOT IT']"),
                "We have a trouble to find the element 'GOT IT'",
                5);

        this.waitForElementAndSendKeys(
                By.xpath("//*[@resource-id='org.wikipedia:id/text_input'][@text='Name of this list']"),
                      "My_list",
                "We have a trouble to fill the Name of list",
                5);

        this.waitForElementAndSendKeys(
                By.xpath("//*[@resource-id='org.wikipedia:id/secondary_text_input']" +
                        "[@text='Description (optional)']"),
                "Training_list",
                "We have a trouble to fill the Description of list",
                5);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='android:id/button1'][@text='OK']"),
                        "We have a trouble to find 'OK' button",
                        5);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/snackbar_action']" +
                        "[@text='VIEW LIST']"),
                "We have a trouble to find 'VIEW LIST' button",
                5);

       this.swipeToTheLeftElement(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']" +
                        "[@text='" + name_of_article + "']"),
                "We have a trouble to find '" + name_of_article + "' article in 'My list'");

       this.waitForElementNotPresent(
               By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']" +
                       "[@text='" + name_of_article + "']"),
               "There is the article '" + name_of_article + "' in list",
               5);


    }
}