import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadPage {

    private WebDriver driver;

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
    }


    By logo = By.xpath("//div[@class='main_title']");
    By downloadButton = By.xpath("//a/span");


    public void downloadFile(){

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(logo)));
        driver.findElement(downloadButton).click();
    }
}