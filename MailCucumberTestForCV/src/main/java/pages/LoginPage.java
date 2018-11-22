package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(xpath = "//*[@id = 'mailbox:login']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id = 'mailbox:password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logOutLink;

    @FindBy(xpath = "//*[@id='mailbox:error']")
    public WebElement logoutLinkError;


    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }


    public void clickEnterButton(){
        buttonEnter.click();
    }

    public LoginPage typeUserName(String username){
        loginField.sendKeys(username);
        return this;
    }

    public LoginPage TypePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public void register(String login, String password){
        this.typeUserName(login);
        this.TypePassword(password);
        this.clickEnterButton();
    }
    public boolean logoutLinkPresents(WebDriver driver){
        return new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(logOutLink)).isDisplayed();
    }

    public boolean logoutLinkErrorPresents(WebDriver driver)
    {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(logoutLinkError)).isDisplayed();
    }
}
