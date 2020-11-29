import org.junit.Test;
import org.openqa.selenium.By;

public class testSwipeUpArticle extends TestClass {

    @Test
    public void testSwipeArticleTitle() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Appium",
                "Cannot find search field",
                5);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']" +
                        "[@text='Appium']"),
                "Cannot find search input",
                15);

        this.swipeUpToFindElement(
                By.xpath("//*[@text='View article in browser']"),
                "Can't find final element",
                20
        );

        this.tearDown();
    }
}