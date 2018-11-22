package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetterOutOfSpamPage {

    private WebDriver driver;

    public LetterOutOfSpamPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//span[text()='Спам'])[3]")
    private WebElement spamLink;

    @FindBy(xpath = "(//*[@class='b-checkbox__box'])[30]")
    private WebElement checkboxMessage;

    @FindBy(xpath = "//span[text()='Не спам']")
    private WebElement noSpamButton;

    @FindBy(xpath = "(//div[@class='b-datalist__empty__icon b-datalist__empty__icon_spam'])[1]")
    private WebElement spamImage;

    @FindBy(xpath = "(//div[@class='notify'])[1]")
    private WebElement infoLink;


    public void clickSpamLink(){
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(spamLink)).click();
    }

    public void clickCheckBoxSpam(){
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(checkboxMessage)).click();
    }

    public void clickNoSpamButton(){
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(noSpamButton)).click();
    }


    public boolean infoLinkPresents()
    {
        return (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(infoLink)).isDisplayed();
    }
    public boolean basketImagePresent(){
        return new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(spamImage)).isDisplayed();
    }
}
