import org.junit.Test;
import org.openqa.selenium.By;

public class SwipeArticleTest extends TestClass {

    @Test
    public void testSwipeArticleTitle() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot find search field",
                5);

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']" +
                        "[@text='Object-oriented programming language']"),
                "Cannot find search input",
                15);

        this.swipeUp(20);
        this.swipeUp(20);
        this.swipeUp(20);
        this.swipeUp(20);
        this.swipeUp(20);
        this.swipeUp(20);
        this.swipeUp(20);



    }
}