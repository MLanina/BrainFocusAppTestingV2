import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by mlanina on 04/05/17.
 */
public class DriverInstance {
    protected AndroidDriver driver;

    public static Logger LOG = Logger.getLogger(DriverInstance.class.getName());

    public DriverInstance() {
    }

    public AndroidDriver getDriver() {
        AndroidDriver driver = null;
        try {
            File appDir = new File("src/main/resources");
            File app = new File(appDir, "BrainFocusProductivityTimer.apk");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            LOG.info("Something is wrong with provided URL");
        }
        return driver;
    }
}
