package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CleanBasketPage {

    private WebDriver driver;

    public CleanBasketPage(WebDriver driver) {
        PageFactory.initElements(driver , this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@data-id='500002']")
    private WebElement basketLink;

    @FindBy(xpath = "//button[@data-name='clearFolder']")
    private WebElement buttonClearFolder;

    @FindBy(xpath = "//span[text()='Да']")
    private WebElement buttonConfirm;

    @FindBy(xpath = "(//div[@class='b-datalist__empty__icon b-datalist__empty__icon_trash'])[1]")
    private WebElement basketImage;


    public void clickBasketLink()
    {
        basketLink.click();
    }

    public void clickButtonClearFolder(){
        buttonClearFolder.click();
    }

    public void clickButtonConfirm(){
        buttonConfirm.click();
    }

    public boolean basketImagePresent(){
        return new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(basketImage)).isDisplayed();
    }

}
