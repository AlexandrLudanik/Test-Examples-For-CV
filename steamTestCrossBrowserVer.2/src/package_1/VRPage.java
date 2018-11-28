package package_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VRPage {

	@FindBy(xpath = "//*[@id=\"tab_select_TopSellers\"]/div")
	private static WebElement TopSellersButton;
	
	
	public static void TopSellersButton(WebDriver driver) {
		TopSellersButton.click();
	}
    
}