import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class testAmountOfEmptySearch extends TestClass {

    @Test
    public void testSwipeArticleTitle() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        String name_of_article = "zxcvasdfqwer";

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                name_of_article,
                "Cannot find search field",
                5);

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_text']/*[@resource-id='org.wikipedia:id/results_text']";
        String empty_result_label = "//*[@text='No results']";

        this.waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find empty result label by the request " + name_of_article,
                15);

        assertElementNotPresent(
                By.xpath(search_result_locator),
                "We've find some results by the request '" + name_of_article + "'"
        );

        this.tearDown();
    }
}