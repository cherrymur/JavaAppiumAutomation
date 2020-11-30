import org.junit.Test;
import org.openqa.selenium.By;

public class testAssertElementPresent {

    @Test
    public void AssertElementPresentTest() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        String name_of_article = "Java";

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search…')]"),
                name_of_article,
                "Cannot find search field",
                5);

        String article_description = "Object-oriented programming language";

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']" +
                        "[@text='" + article_description + "']"),
                "Cannot find '" + article_description + "' topic searching by " + name_of_article,
                30);

        this.assertElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "The article '" + name_of_article + "' is not opened immediatly");

        this.tearDown();
    }
}