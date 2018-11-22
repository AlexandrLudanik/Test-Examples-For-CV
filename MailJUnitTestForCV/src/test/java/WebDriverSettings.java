import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {

    public WebDriver driver;
    public LoginPage loginPage;
    public SendLetterPage sendLetterPage;
    public SendLetterGroupPage sendLetterGroupPage;
    public DelMessagePage delMessagePage;
    public CleanBasketPage cleanBasketPage;
    public LetterOutOfSpamPage letterOutOfSpamPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\driverSelenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://mail.ru");
        letterOutOfSpamPage = new LetterOutOfSpamPage(driver);
        cleanBasketPage = new CleanBasketPage(driver);
        loginPage = new LoginPage(driver);
        sendLetterPage = new SendLetterPage(driver);
        sendLetterGroupPage = new SendLetterGroupPage(driver);
        delMessagePage = new DelMessagePage(driver);
    }

    @After
    public void tearDown(){
        driver.close();
    }
}