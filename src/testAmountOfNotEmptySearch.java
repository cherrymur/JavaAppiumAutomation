import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class testAmountOfNotEmptySearch {

    @Test
    public void testSwipeArticleTitle() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        String name_of_article = "Appium";

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                name_of_article,
                "Cannot find search field",
                5);

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        this.waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find anything by request " + name_of_article,
                15);

        int amount_of_search_results = getAmountOfElements(By.xpath(search_result_locator));

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );

        this.tearDown();
    }
}