import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GameWithMaxDiscountPage {

    WebDriver driver;

    public GameWithMaxDiscountPage(WebDriver driver) {
        this.driver = driver;
    }

    By discountThisGame = By.xpath("(//*[@class='discount_pct'])[1]");
    By gameName = By.xpath("//div[@class='btn_addtocart']");

    public void waitGameName(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(gameName)));

    }


    public int getDiscountGame(){

        return Integer.parseInt(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(discountThisGame))).getText().substring(1, driver.findElement(discountThisGame).getText().length() - 1));
    }
}
