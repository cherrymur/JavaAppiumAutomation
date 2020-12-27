package Tests.IOS;

import lib.CoreTestsCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;


public class GetStartedTest extends CoreTestsCase{

    @Test
    public void testPassThroughWelcome()
    {
        if (Platform.getInstance().isAndroid()){
            return;
        }
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
