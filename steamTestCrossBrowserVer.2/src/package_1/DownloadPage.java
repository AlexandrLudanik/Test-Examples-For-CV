package package_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadPage {
    
	@FindBy(xpath = "//*[@class=\"btn_medium btn_green_white_innerfade\"]")
	private static WebElement DownloadButton;
	
	
	public static void pressDownloadButton(WebDriver driver) {
		DownloadButton.click();
    }
		
}