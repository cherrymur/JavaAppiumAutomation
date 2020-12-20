package Tests.IOS;

import lib.iOSTestsCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;


public class GetStartedTest extends iOSTestsCase{

    @Test
    public void testPassThroughWelcome()
    {
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWaysToExploreText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditPrefferedLangText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutDataCollectingText();
        WelcomePage.clickGetStartedButton();
    }
}
