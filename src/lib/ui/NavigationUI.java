package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{
    private static final String
            OPTION_MyLists_BUTTON = "//android.widget.FrameLayout[@content-desc='My lists']";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void openMyLists()
    {
        this.waitForElementAndClick(
                By.xpath(OPTION_MyLists_BUTTON),
                "We have a trouble to find the 'My lists' element",
                10);
    }
}
