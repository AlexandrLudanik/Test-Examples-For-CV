import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class WebDriverSettings {

    String browser = "firefox";
    WebDriver driver;
    HomePage homePage;
    DownloadPage downloadPage;
    VrPage vrPage;
    GameWithMaxDiscountPage gameWithMaxDiscountPage;
    AgeCheckPage ageCheckPage;

    File folder = new File("D:\\downloadTest");


    @Before
    public void setUp(){
        driver = InitializationWebDriver.initialize(browser);
        driver.get("https://store.steampowered.com/");
        homePage = new HomePage(driver);
        downloadPage = new DownloadPage(driver);
        vrPage = new VrPage(driver);
        gameWithMaxDiscountPage = new GameWithMaxDiscountPage(driver);
        ageCheckPage = new AgeCheckPage(driver);

    }
    
}
