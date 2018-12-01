package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class MainPageTest {
    MainPage mainPage;
    WebDriver driver;
    SearchPage searchPage;
    HotelPage hotelPage;


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\driverSelenium\\chromedriver.exe");
        driver = new ChromeDriver();

        //remoteWebDriver
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.booking.com");
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        hotelPage = new HotelPage(driver);
    }

    @Test
    public void findThreeMoreNumbersInCityInTheNearestWeekend() throws InterruptedException {
        mainPage.typeCity("minsk");
        mainPage.clickDate();
        mainPage.chooseWeekend();
        mainPage.clickSearchButton();
        Assert.assertTrue(searchPage.threeMoreNumbersFree());
    }

    @Test
    public void findReservationWithoutCreditCardInCityInTheNearestWeekend() {
        mainPage.typeCity("minsk");
        mainPage.clickDate();
        mainPage.chooseWeekend();
        mainPage.clickSearchButton();
        Assert.assertTrue(searchPage.getReservationWithoutCreditCard());
    }

    @Test
    public void findHotelWithMarkNotLessThen9() {
        mainPage.typeCity("minsk");
        mainPage.clickDate();
        mainPage.chooseWeekend();
        mainPage.clickSearchButton();
        Assert.assertTrue(searchPage.markHotelNotLessThen9());
    }

    @Test
    public void findNumberWithMaxSquare() {
        mainPage.typeCity("minsk");
        mainPage.clickDate();
        mainPage.chooseWeekend();
        mainPage.clickSearchButton();
        System.out.println(searchPage.getMaxSquare());
        Assert.assertTrue(searchPage.squreNumberNotLessThen50());
    }

    @Test
    public void numberWithMaxSquareWithWifi() {
        mainPage.typeCity("minsk");
        mainPage.clickDate();
        mainPage.chooseWeekend();
        mainPage.clickSearchButton();
        searchPage.clickHotelWithMaxSquare();
        Assert.assertTrue(hotelPage.includingWithWifi());
    }

    @Test
    public void numberWithMaxSquareWithAirportShuttle() {
        mainPage.typeCity("minsk");
        mainPage.clickDate();
        mainPage.chooseWeekend();
        mainPage.clickSearchButton();
        searchPage.clickHotelWithMaxSquare();
        Assert.assertTrue(hotelPage.includingAirportShuttle());
    }

    @Test
    public void errorMessage() {
        mainPage.clickDate();
        mainPage.chooseWeekend();
        mainPage.clickSearchButton();
        Assert.assertTrue(mainPage.getError());
    }

    @Test
    public void numberWithMaxSquareWithFreeParking() {
        mainPage.typeCity("minsk");
        mainPage.clickDate();
        mainPage.chooseWeekend();
        mainPage.clickSearchButton();
        searchPage.clickHotelWithMaxSquare();
        Assert.assertTrue(hotelPage.includingFreeParking());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}