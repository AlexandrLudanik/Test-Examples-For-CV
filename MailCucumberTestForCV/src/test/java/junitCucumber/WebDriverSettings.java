package junitCucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class WebDriverSettings {

    public static final String MAIN_URL = "http://mail.ru";
    private static final String CHROMEDRIVER_EXE = "C:\\Program Files\\driverSelenium\\chromedriver.exe";
    public static final String LOGIN = "sysrq08884";
    public static final String PASSWORD = "5682777a";
    public LoginPage loginPage;
    public WebDriver driver;
    public CleanBasketPage cleanBasketPage;
    public DelMessagePage delMessagePage;
    public LetterOutOfSpamPage letterOutOfSpamPage;
    public SendLetterGroupPage sendLetterGroupPage;
    public SendLetterInSpamPage sendLetterInSpamPage;
    public SendLetterPage sendLetterPage;


    public WebDriverSettings()

    {
        String exePath = CHROMEDRIVER_EXE;
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        cleanBasketPage = new CleanBasketPage(driver);
        delMessagePage = new DelMessagePage(driver);
        letterOutOfSpamPage = new LetterOutOfSpamPage(driver);
        sendLetterInSpamPage = new SendLetterInSpamPage(driver);
        sendLetterPage = new SendLetterPage(driver);
        sendLetterGroupPage = new SendLetterGroupPage(driver);
    }
}
