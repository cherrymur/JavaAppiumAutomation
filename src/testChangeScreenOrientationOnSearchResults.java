import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class testChangeScreenOrientationOnSearchResults {

    @Test
    public void ChangeScreenOrientationOnSearchResultsTest() throws Exception {
        this.setUp();

        this.RotateResetBeforeTest(
                By.xpath("//*[@resource-id='org.wikipedia:id/view_card_header_title']" +
                        "[@text='Featured article']")
        );

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

        String title_before_landscape_rotation;

        title_before_landscape_rotation = this.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                30);

        this.RotateLandscape();


        String title_after_landscape_rotation = this.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                30);

        Assert.assertEquals(
                "Article title have been changed after landscape screen rotation",
                title_before_landscape_rotation,
                title_after_landscape_rotation
        );

        this.RotatePORTRAIT();

        String title_after_portrait_rotation = this.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                30);

        Assert.assertEquals(
                "Article title have been changed after portrait screen rotation",
                title_before_landscape_rotation,
                title_after_portrait_rotation);

        this.tearDown();
    }
}