package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id='ss']")
    private WebElement cityField;

    @FindBy(xpath = "//*[@aria-label='Open calendar']")
    private WebElement dateField;

    @FindBy(xpath = "//span[@class='xp__guests__count']")
    private WebElement guestField;

    @FindBy(xpath = "//*[@class='sb-searchbox__button  ']")
    private WebElement searchButton;

    @FindBy(xpath = "(//table[@class='bui-calendar__dates'])[1]")
    public WebElement tableElement;

    @FindBy(xpath = "//div[@class='fe_banner__message ']")
    public WebElement error;


    public void chooseWeekend() {
        Table table = new Table(tableElement, driver);

        String firstWeek = table.getValueFromCell(1, 5).getText();
        if (!(firstWeek.length() == 0)) {
            table.getValueFromCell(1, 6).click();
            table.getValueFromCell(1, 7).click();
        } else {
            String secondWeek = table.getValueFromCell(2, 6).getText();
            if (!(secondWeek.length() == 0)) {
                table.getValueFromCell(2, 6).click();
                table.getValueFromCell(2, 7).click();
            } else {
                String thirdWeek = table.getValueFromCell(3, 6).getText();
                if (!(thirdWeek.length() == 0)) {
                    table.getValueFromCell(3, 6).click();
                    table.getValueFromCell(3, 7).click();
                } else {
                    String fothWeek = table.getValueFromCell(4, 6).getText();
                    if (!(fothWeek.length() == 0)) {
                        table.getValueFromCell(4, 6).click();
                        table.getValueFromCell(4, 7).click();
                    } else {
                        String fifthWeek = table.getValueFromCell(5, 6).getText();
                        if (!(fifthWeek.length() == 0)) {
                            table.getValueFromCell(5, 6).click();
                            table.getValueFromCell(5, 7).click();
                        }
                    }
                }
            }
        }
    }


    public void clickDate() {
        dateField.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void typeCity(String city) {
        cityField.sendKeys(city);
    }

    public boolean getError() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(error)).isDisplayed();
    }
}
