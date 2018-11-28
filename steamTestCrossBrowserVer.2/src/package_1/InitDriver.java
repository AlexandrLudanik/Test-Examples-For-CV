package package_1;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InitDriver implements WebDriver {
      
	private static WebDriver driver = null;
	InitDriver() {}
	
	public static WebDriver initialize(String name) {
        if (driver == null)
        {
        	if (name.equalsIgnoreCase("Chrome")) {
        		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\driverSelenium\\chromedriver.exe");
        		
        		String downloadFilepath = "D://";
        		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", downloadFilepath);
                chromePrefs.put("safebrowsing.enabled", "true"); 
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                cap.setCapability(ChromeOptions.CAPABILITY, options);
        		
                driver = new ChromeDriver(options);
            	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            	driver.manage().window().maximize();
        	} else
            if (name.equalsIgnoreCase("Firefox")) {
            	System.setProperty("webdriver.gecko.driver", "D:\\New folder\\geckodriver.exe");
            	
            	FirefoxProfile profile = new FirefoxProfile();
            	String downloadFilepath = "D:\\";
            	profile.setPreference("browser.download.folderList", 2);
            	profile.setPreference("browser.download.dir", downloadFilepath);
            	profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
            	profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/download, application/octet-stream");
            	profile.setPreference("browser.download.useDownloadDir", true);
               	profile.setPreference("browser.download.manager.closeWhenDone", true);
            	FirefoxOptions options = new FirefoxOptions();
            	options.setProfile(profile);

            	driver = new FirefoxDriver(options);
                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
                driver.manage().window().maximize();
            } else
        	if (name.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "D:\\Selenium Web Driver\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }
        } else System.out.println("No such browser.");
		return driver;
    }
	
	public void get(String link) {
	    driver.get(link);
	}

	public void close() {
	    driver.close();
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator); 
	}

	public List<WebElement> findElements(By arg0) {
		return null;
	}

	public String getCurrentUrl() {
		return null;
	}

	public String getPageSource() {
		return null;
	}

	public String getTitle() {
		return null;
	}

	public String getWindowHandle() {
		return null;
	}

	public Set<String> getWindowHandles() {
		return null;
	}

	public Options manage() {
		return null;
	}

	public Navigation navigate() {
		return null;
	}

	public void quit() {
	}

	public TargetLocator switchTo() {
		return null;
	}

}