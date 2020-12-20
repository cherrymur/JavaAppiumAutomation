package lib;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;

public class iOSTestsCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumUrl = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.3");
        capabilities.setCapability("deviceName", "IPhone SE");
        capabilities.setCapability("app", "C:\\Users\\olga.avramenko\\Desktop\\Mobile_testing\\" +
                "JavaAppiumAutomatiom\\apks\\Wikipedia.app");

        capabilities.setCapability("orientation", "PORTRAIT");
        driver = new IOSDriver(new URL(AppiumUrl), capabilities);
//        this.screenRotatePORTRAIT();
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
