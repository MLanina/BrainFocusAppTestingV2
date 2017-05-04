import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;


/**
 * Created by mlanina on 21/04/17.
 */

public class AppiumConfiguration {

    public static Logger LOG = Logger.getLogger(AppiumConfiguration.class.getName());
    public AppiumServer appiumServer;


    public void startAppiumServer() {
        ServerArguments serverArguments = new ServerArguments();
        serverArguments.setArgument("--address", "127.0.0.1");
        serverArguments.setArgument("--no-reset", true);
        serverArguments.setArgument("--local-timezone", true);
        appiumServer = new AppiumServer(new File("/Applications/Appium.app/Contents/Resources/node/bin/node"), new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js"), serverArguments);
        appiumServer.startServer();
        LOG.info("Appium server was started");
    }

    public void stopAppiumServer() {
        appiumServer.stopServer();
        LOG.info("Appium server was stopped");
    }

}
