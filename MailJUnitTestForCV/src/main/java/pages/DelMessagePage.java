package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DelMessagePage {

    private WebDriver driver;

    public DelMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//span[text()='Удалить'])[1]")
    private WebElement deleteButton;

    @FindBy(xpath = "(//*[@class='b-checkbox__box'])[3]")
    private WebElement checkboxMessage;

    @FindBy(xpath = "(//div[@class='notify'])[1]")
    private WebElement infoLink;


    public void clickCheckboxMessage() {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(checkboxMessage)).click();
    }

    public void ClickButtonDelete(){
        deleteButton.click();

    }

    public boolean infoLinkPresents()
    {
        return (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(infoLink)).isDisplayed();
    }
}
