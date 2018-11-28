package package_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//*[@id=\"genre_tab\"]/span/a[1]")
	static WebElement GamesButton;
	
	@FindBy(xpath = "//a[@href='https://store.steampowered.com/vr/?snr=1_4_4__12']")
	static WebElement VRButton;
	
	
	public static void PressGamesButton(WebDriver driver) {
		Actions action = new Actions(driver);
 	    action.moveToElement(GamesButton).build().perform();
 	}
	
	public static void PressVRButton(WebDriver driver) {
		VRButton.click();
    }

}