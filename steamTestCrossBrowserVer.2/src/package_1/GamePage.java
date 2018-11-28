package package_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamePage {
	
	@FindBy(xpath = "//*[@class=\"discount_pct\"]")
	private static WebElement DiscountPct;
	
	@FindBy(xpath = "//*[@class=\"discount_final_price\"]")
	private static WebElement DiscountFinalPrice;
	
	@FindBy(xpath = "//*[@class=\"header_installsteam_btn_content\"]")
	private static WebElement InstallsteamButton;
	
	
	public static int getDiscountToCompare(WebDriver driver) {
		return Integer.parseInt(DiscountPct.getText().substring(1, 3));
	}
  
	public static double getPriceToCompare(WebDriver driver) {
		return Double.parseDouble(DiscountFinalPrice.getText().substring(1, 6).trim());
	}
	
	public static void pressInstallSteamButton(WebDriver driver) {
		InstallsteamButton.click();
	}
}