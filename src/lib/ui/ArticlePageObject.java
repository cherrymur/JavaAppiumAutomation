package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            TITLE = "id:org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
            OPTION_SAVE_BUTTON = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/" +
                    "android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/" +
                    "android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]",
            OPTION_GOTIT_BUTTON = "id:org.wikipedia:id/onboarding_button",
            OPTION_NAMEtitle_INPUT = "id:org.wikipedia:id/text_input",
            OPTION_OK_BUTTON = "id:android:id/button1",
            OPTION_CLOSE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";


    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(
                TITLE,
                "Cannot find article title on page!",
                15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTION_SAVE_BUTTON,
                "We have a trouble to find the element Save",
                5);

        this.waitForElementAndClick(
                OPTION_GOTIT_BUTTON,
                "We have a trouble to find the element 'GOT IT'",
                5);

        this.waitForElementAndClear(
                OPTION_NAMEtitle_INPUT,
                "We have a trouble to find and clear the element 'My reading list'",
                5);

        this.waitForElementAndSendKeys(
                OPTION_NAMEtitle_INPUT,
                name_of_folder,
                "We have a trouble to fill the Name of list",
                5);

        this.waitForElementAndClick(
                OPTION_OK_BUTTON,
                "We have a trouble to find or press 'OK' button",
                5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                OPTION_CLOSE_BUTTON,
                "We have a trouble to find the 'X' element",
                5);
    }

    public void assertTitleHasText(String article_title)
    {
        assertElementHasText(
                TITLE,
                article_title,
                "The article '" + article_title + "' is not opened");
    }

    public void assertArticleTitlePresent()
    {
        this.assertElementPresent(
                TITLE,
                "The article has no title");
    }
}
