package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelPage {

    private WebDriver driver;

    public HotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//span[@class='ph-item-copy-wifi']")
    private WebElement wifi;

    @FindBy(xpath = "//i[@class='ph-icon ph-icon-parking bicon-']")
    private WebElement freeParking;

    @FindBy(xpath = "//span[@class='facility-badge__tooltip-title']")
    private WebElement airportShuttle;

    public boolean includingWithWifi() {
        try {
            return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(wifi)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean includingAirportShuttle() {
        try {
            return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(airportShuttle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean includingFreeParking() {
        try {
            return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(freeParking)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
