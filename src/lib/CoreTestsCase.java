package lib;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;

public class CoreTestsCase extends TestCase {

    protected AppiumDriver driver;
    protected Platform Platform;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.Platform = new Platform();
        driver = this.Platform.getDriver();
        this.screenRotatePORTRAIT();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void screenRotateLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void screenRotatePORTRAIT() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void runAppInBackground(int seconds) {
        driver.runAppInBackground(seconds);
    }

}
