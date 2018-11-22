package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendLetterInSpamPage {

    WebDriver driver;

    public SendLetterInSpamPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "(//span[text()='Спам'])[1]")
    private WebElement spamButton;

    @FindBy(xpath = "(//div[@class='notify'])[1]")
    private WebElement infoLink;


    public void clickSpamButton(){
        spamButton.click();
    }

    public boolean infoLinkPresents()
    {
        return (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(infoLink)).isDisplayed();
    }
}
