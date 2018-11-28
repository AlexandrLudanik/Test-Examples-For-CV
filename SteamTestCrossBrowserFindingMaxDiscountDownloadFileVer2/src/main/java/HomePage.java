import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {


    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By buttonSetup = By.xpath("//a[@class='header_installsteam_btn_content']");
    By linkGames = By.xpath("(//span[@class='pulldown'])[2]/span");
    By linkVr = By.xpath("//a[@href='https://store.steampowered.com/vr/?snr=1_4_4__12']");

    public void clickButtonSetup()
    {
        driver.findElement(buttonSetup).click();
    }

    public void clickLinkGames(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(linkGames))).click();
    }

    public void clickLinkVr(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(linkVr))).click();

    }
}

