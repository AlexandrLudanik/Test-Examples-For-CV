package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendLetterGroupPage {

    private WebDriver driver;
    private WebElement emailBodyField;

    public SendLetterGroupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "(//div[@class='b-correspondent__name'])[1]")
    private WebElement receiver1;

    @FindBy(xpath = "(//div[@class='b-correspondent__name'])[2]")
    private WebElement receiver2;

    @FindBy(xpath = "//textarea[@tabindex='4']")
    private WebElement receiveField;


    public void clickFieldReceiver() {
        (new WebDriverWait(driver,15)).until(ExpectedConditions.visibilityOf(receiveField)).click();

    }

    public void setEmail(String email){
        receiveField.sendKeys(email);
        receiveField.sendKeys(Keys.ENTER);
    }

    public void writeMessage(String textMessage) {
        driver.switchTo().frame(driver.findElement(By.xpath(".//tr[@class='mceFirst mceLast']//iframe")));
        emailBodyField = driver.findElement(By.xpath("//*[@id='tinymce']"));
        emailBodyField.sendKeys(textMessage);
        driver.switchTo().defaultContent();
    }
}
