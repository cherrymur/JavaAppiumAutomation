package lib;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestsCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumUrl = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\olga.avramenko\\Desktop\\Mobile_testing\\" +
                "JavaAppiumAutomatiom\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL(AppiumUrl), capabilities);
        this.screenRotatePORTRAIT();
    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown();
    }

    protected void screenRotateLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void screenRotatePORTRAIT()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void runAppInBackground(int seconds)
    {
        driver.runAppInBackground(seconds);
    }
}
