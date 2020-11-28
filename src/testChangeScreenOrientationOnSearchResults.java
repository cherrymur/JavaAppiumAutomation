import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class testChangeScreenOrientationOnSearchResults extends TestClass {

    @Test
    public void ChangeScreenOrientationOnSearchResultsTest() throws Exception {
        this.setUp();

        this.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find search field",
                5);

        String name_of_article = "Java";

        this.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                name_of_article,
                "Cannot find search field",
                5);

        String article_description = "Object-oriented programming language";
        this.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']" +
                        "[@text='" + article_description + "']"),
                "Cannot find '" + article_description + "' topic searching by " + name_of_article,
                15);

        String title_before_landscape_rotation;
        title_before_landscape_rotation = waitForElementAndGetAttribute(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]"),
                "text",
                "Cannot find title of article",
                15);

        this.RotateLandscape();

        String title_after_landscape_rotation = waitForElementAndGetAttribute(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]"),
                "text",
                "Cannot find title of article",
                15);

        Assert.assertEquals(
                "Article title have been chahged after screen rotation",
                title_before_landscape_rotation,
                title_after_landscape_rotation
        );

        this.RotatePORTRAIT();


        String title_after_portrait_rotation = waitForElementAndGetAttribute(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]"),
                "text",
                "Cannot find title of article",
                15);

        Assert.assertEquals(
                "Article title have been chahged after screen rotation",
                title_before_landscape_rotation,
                title_after_portrait_rotation);

//        this.tearDown();
    }
}