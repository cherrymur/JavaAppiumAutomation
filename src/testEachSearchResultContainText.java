import org.junit.Test;
import org.openqa.selenium.By;

public class testEachSearchResultContainText extends TestClass {

    @Test
    public void testEachSearchResult() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                "Java",
                "Cannot find search field",
                5);

        this.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_display']"),
                "There is no list with results",
                5);

        this.assertElementsHaveText(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"),
                "Java",
                "JAVA is not in each element");

        this.tearDown();
    }
}