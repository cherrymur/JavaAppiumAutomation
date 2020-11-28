import org.junit.Test;
import org.openqa.selenium.By;

public class testCancelSearch extends TestClass {

    @Test
    public void testCancelSearch() throws Exception {
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
                By.xpath("//*[@resource-id='org.wikipedia:id/search_close_btn']"),
                "Cannot find X element to cancel search",
                5);

        this.waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "X element is still on page",
                5);

        this.tearDown();
    }
}