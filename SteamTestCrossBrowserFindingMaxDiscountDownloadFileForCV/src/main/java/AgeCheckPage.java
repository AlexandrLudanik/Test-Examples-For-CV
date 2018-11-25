import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgeCheckPage {

    WebDriver driver;

    public AgeCheckPage(WebDriver driver) {
        this.driver = driver;
    }

    By attention = By.xpath("(//h2)[1]");
    By year = By.xpath("//*[@id='ageYear']");
    By setYear = By.xpath("//option[@value='1984']");
    By buttonOpenGamePage = By.xpath("(//a[@class='btnv6_blue_hoverfade btn_medium'])[1]");


    public void setYearAndPressOkButton (){

        try {
            if (new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(attention))).isDisplayed())
            {
                new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(year))).click();
                new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(setYear))).click();
                new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(buttonOpenGamePage))).click();
            }
        } catch (Exception e) {

        }
    }
}
