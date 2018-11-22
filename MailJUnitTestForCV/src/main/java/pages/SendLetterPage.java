package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendLetterPage {

    private WebDriver driver;
    private WebElement emailBodyField;


    public SendLetterPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='b-toolbar__left']/div/div/div[2]/div/a/span")
    private WebElement buttonWriteLetter;

    @FindBy(xpath = "//textarea[@tabindex='4']")
    private WebElement receiveField;

    @FindBy(xpath = "//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[1]/div/span")
    private WebElement buttonSendLetter;

    @FindBy(xpath = "//*[@id='b-compose__sent']/div/div[1]/div")
    private WebElement infoLetterSend;

    @FindBy(xpath = "//td[@class='mceIframeContainer mceFirst mceLast']")
    private WebElement iframe;


    public void clickButtonWriteLetter() {
        (new WebDriverWait(driver,15)).until(ExpectedConditions.visibilityOf(buttonWriteLetter)).click();

    }

    public void writeEmailAndMessage(String address, String textMessage) {

        receiveField.sendKeys(address);
        driver.switchTo().frame(driver.findElement(By.xpath(".//tr[@class='mceFirst mceLast']//iframe")));
        emailBodyField = driver.findElement(By.xpath("//*[@id='tinymce']"));
        emailBodyField.sendKeys(textMessage);
        driver.switchTo().defaultContent();

    }

    public void clickButtonSendLetter() {
        (new WebDriverWait(driver,15)).until(ExpectedConditions.visibilityOf(buttonSendLetter)).click();

    }

    public boolean sendMessage() {

        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(infoLetterSend)).isDisplayed();
    }
}
