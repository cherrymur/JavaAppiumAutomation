import org.junit.Test;
import org.openqa.selenium.By;

public class testCompareArticleTitleContainText extends TestClass {

    @Test
    public void testCompareArticleTitle() throws Exception {
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

        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']" +
                        "[@text='Object-oriented programming language']"),
                "Cannot find search input",
                15);

        this.assertElementHasText(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Java (programming language)",
                "We see unexpected title"
        );

        this.tearDown();
    }
}