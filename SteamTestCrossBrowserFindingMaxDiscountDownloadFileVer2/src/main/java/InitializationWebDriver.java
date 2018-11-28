import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class InitializationWebDriver {

    public InitializationWebDriver() {
    }

    private static WebDriver driver = null;

    public static WebDriver initialize(String name) {

        File folder;
        folder = new File("D:\\downloadTest");
        folder.mkdir();
        if (driver == null) {
            if (name.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\driverSelenium\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("download.default_directory", folder.getAbsolutePath());
                prefs.put("safebrowsing.enabled", "true");
                options.setExperimentalOption("prefs", prefs);
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(cap);
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();

            } else if (name.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "D:\\New folder\\geckodriver.exe");
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.folderList", 2);
                profile.setPreference("browser.download.dir", folder.getAbsolutePath());
                profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/download, application/octet-stream");
                profile.setPreference("browser.download.useDownloadDir", true);
                profile.setPreference("browser.download.manager.closeWhenDone", true);
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);
                driver = new FirefoxDriver(options);
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();

            } else if (name.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "C:\\Program Files\\driverSelenium\\IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                driver = new InternetExplorerDriver(capabilities);
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();

//                Robot robot = new Robot();
//// simulate the "Alt + S" to save file on IE11 when Download Prompt appears
//                robot.keyPress(KeyEvent.VK_ALT);
//                robot.keyPress(KeyEvent.VK_S);
//                robot.keyRelease(KeyEvent.VK_ALT);
//                robot.keyRelease(KeyEvent.VK_S);
            }
        } else System.out.println("No such browser.");
        return driver;
    }
}
