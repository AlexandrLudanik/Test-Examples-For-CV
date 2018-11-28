package package_1;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModel {
	    
	    static WebDriver driver = null;
        static Game game = new Game();
	    
	    public static boolean initializeDriver() throws IOException {
            driver = InitDriver.initialize(GetBrowserName.getBrowserName());
            return driver != null;
	    }
	    
	    public static boolean PageFactoryInit() {
	    	PageFactory.initElements(driver, HomePage.class);
            PageFactory.initElements(driver, VRPage.class);
            PageFactory.initElements(driver, GamePage.class);
            PageFactory.initElements(driver, AgeCheckPage.class);
            PageFactory.initElements(driver, DownloadPage.class);
			return true;
        }
	    	    
	    public static boolean homePage() {
	    	driver.get("https://store.steampowered.com/");
            HomePage.PressGamesButton(driver);
            HomePage.PressVRButton(driver);
	    	return driver.findElement(By.xpath("//*[@id=\"tab_select_TopSellers\"]")).isDisplayed();
	    }
   
        public static boolean vrPage() {
        	VRPage.TopSellersButton(driver);
	    	return driver.findElement(By.xpath("//*[@class=\"tab  tab_filler active\"]")).isDisplayed();
	    }

        public static boolean topSellersPage() {
        	game = TopSellersPage.GetGame(driver);
        	TopSellersPage.GoToGamePage(driver, game).click();
            return (game.discount != 0 & !driver.getCurrentUrl().startsWith("https://store.steampowered.com/vr"));
        }
        
        public static boolean gamePageCheckDiscountPrice() {
            if (driver.getCurrentUrl().startsWith("https://store.steampowered.com/agecheck")) {
                AgeCheckPage.ageYear(driver);
                AgeCheckPage.openGamePageButton(driver);
            }
            
            return (game.discount == GamePage.getDiscountToCompare(driver));
//            		& game.price == GamePage.getPriceToCompare(driver));
        }
        
        public static boolean gamePagePressInstallSteamButton() {
            GamePage.pressInstallSteamButton(driver);
			return driver.findElement(By.xpath("//*[@class=\"btn_medium btn_green_white_innerfade\"]")).isDisplayed();
        }

        public static boolean downloadPage() {
            DownloadPage.pressDownloadButton(driver);
            File f = new File("D:/SteamSetup.exe");
            return f.exists();
        }
       
}