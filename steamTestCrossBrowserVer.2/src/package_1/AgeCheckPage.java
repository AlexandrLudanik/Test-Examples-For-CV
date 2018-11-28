package package_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgeCheckPage {

	@FindBy(xpath = "//*[@id=\"ageYear\"]/option[99]")
	private static WebElement AgeYear;
	
	@FindBy(xpath = "//*[@id=\"app_agegate\"]/div[1]/div[4]/a[1]/span")
	private static WebElement OpenGamePageButton;
	
	
	public static void ageYear(WebDriver driver) {
		AgeYear.click();
    }
    
	public static void openGamePageButton(WebDriver driver) {
		OpenGamePageButton.click();
    }
}
