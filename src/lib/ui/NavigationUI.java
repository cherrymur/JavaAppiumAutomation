package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{
    private static final String
            OPTION_MyLists_BUTTON = "//android.widget.FrameLayout[@content-desc='My lists']",
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


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void OpenMyLists()
    {
        this.waitForElementAndClick(
                By.xpath(OPTION_MyLists_BUTTON),
                "We have a trouble to find the 'My lists' element",
                10);
    }
}
