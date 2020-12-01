package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "//*[@text='View page in browser']",
            OPTION_SAVE_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/" +
                    "android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/" +
                    "android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]",
            OPTION_GOTIT_BUTTON = "org.wikipedia:id/onboarding_button",
            OPTION_NAMEtitle_INPUT = "org.wikipedia:id/text_input",
            OPTION_OK_BUTTON = "android:id/button1",
            OPTION_CLOSE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";


    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page!", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(OPTION_SAVE_BUTTON),
                "We have a trouble to find the element Save",
                5);

        this.waitForElementAndClick(
                By.id(OPTION_GOTIT_BUTTON),
                "We have a trouble to find the element 'GOT IT'",
                5);

        this.waitForElementAndClear(
                By.id(OPTION_NAMEtitle_INPUT),
                "We have a trouble to find and clear the element 'My reading list'",
                5);

        this.waitForElementAndSendKeys(
                By.id(OPTION_NAMEtitle_INPUT),
                name_of_folder,
                "We have a trouble to fill the Name of list",
                5);

        this.waitForElementAndClick(
                By.id(OPTION_OK_BUTTON),
                "We have a trouble to find or press 'OK' button",
                5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                By.xpath(OPTION_CLOSE_BUTTON),
                "We have a trouble to find the 'X' element",
                5);
    }

}
