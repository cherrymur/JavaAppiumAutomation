package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
        STEP_LEARN_MORE_LINK = "Learn more about Wikipedia",
        STEP_NEW_WAYS_TO_EXPLORE_TEXT = "New ways to explore",
        STEP_ADD_OR_EDIT_PREFFERED_LANG_TEXT = "Add or edit preffered language",
        STEP_LEARN_MORE_ABOUT_DATA_COLLECTING_TEXT = "Learn more about data collected",
        NEXT_BUTTON = "Next",
        GET_STARTED_BUTTON = "Get started";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(
                By.id(STEP_LEARN_MORE_LINK),
                "Cannot find '" + STEP_LEARN_MORE_LINK + "' link",
                10);
    }

    public void waitForNewWaysToExploreText()
    {
        this.waitForElementPresent(
                By.id(STEP_NEW_WAYS_TO_EXPLORE_TEXT),
                "Cannot find '" + STEP_NEW_WAYS_TO_EXPLORE_TEXT + "' link",
                10);
    }

    public void waitForAddOrEditPrefferedLangText()
    {
        this.waitForElementPresent(
                By.id(STEP_ADD_OR_EDIT_PREFFERED_LANG_TEXT),
                "Cannot find 'A" + STEP_ADD_OR_EDIT_PREFFERED_LANG_TEXT + "' link",
                10);
    }

    public void waitForLearnMoreAboutDataCollectingText()
    {
        this.waitForElementPresent(
                By.id(STEP_LEARN_MORE_ABOUT_DATA_COLLECTING_TEXT),
                "Cannot find '" + STEP_LEARN_MORE_ABOUT_DATA_COLLECTING_TEXT + "' link",
                10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(
                By.id(NEXT_BUTTON),
                "Cannot find and click '" + NEXT_BUTTON + "' link",
                10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(
                By.id(GET_STARTED_BUTTON),
                "Cannot find and click '" + GET_STARTED_BUTTON + "' link",
                10);
    }

}
