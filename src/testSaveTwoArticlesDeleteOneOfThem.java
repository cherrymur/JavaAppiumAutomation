import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class testSaveTwoArticlesDeleteOneOfThem extends TestClass {

    @Test
    public void saveTwoArticlesDeleteOneOfThemTest() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        String name_of_first_article = "Appium";
        String name_of_second_article = "Java";
        String name_of_list ="My list";

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                name_of_first_article,
                "Cannot find 'Search...' field",
                5);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']" +
                        "[@text='" + name_of_first_article + "']"),
                "Cannot find article '" + name_of_first_article + "'",
                5);

        this.waitForElementAndClick(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                        "android.widget.FrameLayout/android.widget.FrameLayout/" +
                        "android.widget.FrameLayout/android.widget.FrameLayout/" +
                        "android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/" +
                        "android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/" +
                        "android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]"),
                "We have a trouble to find the element Save",
                5);

        this.waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "We have a trouble to find the element 'GOT IT'",
                5);

        this.waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "We have a trouble to find the element 'My reading list'",
                5);

        this.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_list,
                "We have a trouble to fill the Name of list",
                5);

        this.waitForElementAndClick(
                By.id("android:id/button1"),
                        "We have a trouble to find 'OK' button",
                        5);

        this.waitForElementAndClick(
                By.id("org.wikipedia:id/menu_page_search"),
                "We have a trouble to find 'Search' button",
                5);

        this.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                name_of_second_article,
                "Cannot find 'Search...' field",
                5);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']" +
                        "[@text='Object-oriented programming language']"),
                "Cannot find article '" + name_of_second_article +
                        "' with description 'Object-oriented programming language'",
                5);

        this.waitForElementAndClick(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                        "android.widget.FrameLayout/android.widget.FrameLayout/" +
                        "android.widget.FrameLayout/android.widget.FrameLayout/" +
                        "android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/" +
                        "android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/" +
                        "android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]"),
                "We have a trouble to find the element Save",
                5);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id = 'org.wikipedia:id/item_title']" +
                        "[@text='" + name_of_list + "']"),
                "We have a trouble to find the '" + name_of_list + "'",
                5);

        this.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "We have a trouble to find the 'X' element",
                10);

        this.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "We have a trouble to find the 'My lists' element",
                10);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_title'][@text='" + name_of_list + "']"),
                "We have a trouble to find the '" + name_of_list + "' in 'My lists'",
                10);

        String articles_in_list_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";

        this.swipeToTheLeftElement(
                By.xpath(articles_in_list_locator +
                        "[@text='" + name_of_first_article + "']"),
                "We have a trouble to find '" + name_of_first_article + "' article in '" +
                        name_of_list + "'");

        int amount_of_search_results = getAmountOfElements(By.xpath(articles_in_list_locator));

        Assert.assertTrue(
                "We found not one results",
                amount_of_search_results == 1
        );

       this.waitForElementAndClick(
               By.xpath(articles_in_list_locator +
                       "[@text='" + name_of_second_article + "']"),
               "There is no article '" + name_of_second_article + "' in list",
               5);

       this.assertElementHasText(
               By.id("org.wikipedia:id/view_page_title_text"),
               name_of_second_article,
               "The article '" + name_of_second_article + "' is not opened");

        this.tearDown();
    }
}