package package_1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopSellersPage {
   
	static Game game = new Game();
	
	public static Game GetGame(WebDriver driver){
		
		String allDiscount = "(//*[@class='discount_pct'])";
        String maxDiscount;
        By discount = By.xpath(allDiscount);

        List<WebElement> getDiscount = driver.findElements(discount);

        for(int i = 0; i < getDiscount.size(); i++){
            if(getDiscount.get(i).getText().endsWith("%")) {
                int j = Integer.parseInt(getDiscount.get(i).getText().substring(1, getDiscount.get(i).getText().length() - 1));
                if (j > game.discount) {
                	game.discount = j;
                    game.gameNum = i + 1;
                }
            }
        }
//        System.out.println(index);
//        System.out.println(maxDisc);

//        return maxDiscount = allDiscount + "[" + index + "]";
      return game;

		
		
		
		
		
		
		
		
//		for (int i = 1; i < 21; i++) {
//	    	if (driver.findElement(By.xpath("//*[@id=\"TopSellersRows\"]/a["+i+"]/div[2]")).getText().startsWith("-")) {
//	    		if (game.discount < Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"TopSellersRows\"]/a["+i+"]/div[2]")).getText().substring(1, 3)))
//         	       {
//	    			game.discount = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"TopSellersRows\"]/a["+i+"]/div[2]")).getText().substring(1, 3));
//	    			game.gameNum = i;
//	    		   }
//	    	}
//		}
//		
//		String price = driver.findElement(By.xpath("//*[@id=\"TopSellersRows\"]/a["+game.gameNum+"]/div[2]")).getText().substring(driver.findElement(By.xpath("//*[@id=\"TopSellersRows\"]/a[" + game.gameNum + "]/div[2]")).getText().indexOf("$", 6) + 1, driver.findElement(By.xpath("//*[@id=\"TopSellersRows\"]/a[" + game.gameNum + "]/div[2]")).getText().length());
//        Pattern p = Pattern.compile("[0-9]{1,2}\\.[0-9]{1,2}");
//        Matcher m = p.matcher(price);
//        if (m.find()) {game.price = Double.parseDouble(price.substring(m.start(), m.end())); }
//        return game;
	}

   public static WebElement GoToGamePage(WebDriver driver, Game game){
	   return driver.findElement(By.xpath("(//*[@class='discount_pct'])"+"["+game.gameNum+"]"));
   }

}