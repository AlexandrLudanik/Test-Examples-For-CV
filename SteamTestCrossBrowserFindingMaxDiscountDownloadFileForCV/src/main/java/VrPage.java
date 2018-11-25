import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VrPage {

    private WebDriver driver;

    By logo = By.xpath("//h2[@class='pageheader']");



    public VrPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitLogo(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(logo)));

    }

    public String gameWithMaxDiscount(){
        String allDiscount = "(//*[@class='discount_pct'])";
        String maxDiscount;
        By discount = By.xpath(allDiscount);

        List<WebElement> getDiscount = driver.findElements(discount);

        int index = 0;
        int maxDisc = 0;

        for(int i = 0; i < getDiscount.size(); i++){
            if(getDiscount.get(i).getText().endsWith("%")) {
                int j = Integer.parseInt(getDiscount.get(i).getText().substring(1, getDiscount.get(i).getText().length() - 1));
                if (j > maxDisc) {
                    maxDisc = j;
                    index = i + 1;
                }
            }
        }
//        System.out.println(index);
//        System.out.println(maxDisc);

        return maxDiscount = allDiscount + "[" + index + "]";
    }

    public int discount(){
        return Integer.parseInt(driver.findElement(By.xpath(this.gameWithMaxDiscount())).getText().substring(1, driver.findElement(By.xpath(this.gameWithMaxDiscount())).getText().length() - 1));

    }

    public void clickOnGameWithMaxDiscount (){

        driver.findElement(By.xpath(gameWithMaxDiscount())).click();

    }
}
