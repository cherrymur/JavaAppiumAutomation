package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject
{
    private static final String
        STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
        STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
        STEP_ADD_OR_EDIT_PREFFERED_LANG_TEXT = "id:Add or edit preffered language",
        STEP_LEARN_MORE_ABOUT_DATA_COLLECTING_TEXT = "id:Learn more about data collected",
        NEXT_BUTTON = "id:Next",
        GET_STARTED_BUTTON = "id:Get started",
        SKIP = "id:Skip";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(
                STEP_LEARN_MORE_LINK,
                "Cannot find '" + STEP_LEARN_MORE_LINK + "' link",
                10);
    }

    public void waitForNewWaysToExploreText()
    {
        this.waitForElementPresent(
                STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find '" + STEP_NEW_WAYS_TO_EXPLORE_TEXT + "' link",
                10);
    }

    public void waitForAddOrEditPrefferedLangText()
    {
        this.waitForElementPresent(
                STEP_ADD_OR_EDIT_PREFFERED_LANG_TEXT,
                "Cannot find 'A" + STEP_ADD_OR_EDIT_PREFFERED_LANG_TEXT + "' link",
                10);
    }

    public void waitForLearnMoreAboutDataCollectingText()
    {
        this.waitForElementPresent(
                STEP_LEARN_MORE_ABOUT_DATA_COLLECTING_TEXT,
                "Cannot find '" + STEP_LEARN_MORE_ABOUT_DATA_COLLECTING_TEXT + "' link",
                10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(
                NEXT_BUTTON,
                "Cannot find and click '" + NEXT_BUTTON + "' link",
                10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(
                GET_STARTED_BUTTON,
                "Cannot find and click '" + GET_STARTED_BUTTON + "' link",
                10);
    }

    public void clickSkip()
    {
        this.waitForElementAndClick(SKIP, "Cannot find and click skip button", 5);
    }
}
