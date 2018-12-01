package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    @FindBy(xpath = "//*[@id='hotellist_inner']")
    private WebElement searchResult;

    @FindBy(xpath = "//span[@class='sr-rt-size']")
    private WebElement apartmentSquare;

    @FindBy(xpath = "//strong/b")
    private WebElement price;

    @FindBy(xpath = "//span[@data-x-left-count]")
    private WebElement countNumbers;

    @FindBy(xpath = "//span[@class='no_cc_02']")
    private WebElement reservationWithoutCreditCard;



    public int getCountNumberRooms(){
        List<WebElement> getAllNumbers = driver.findElements(By.xpath("//span[@data-x-left-count]"));

        int numbers = 0;

        for(int i = 0; i < getAllNumbers.size(); i++){
            int j = Integer.parseInt(getAllNumbers.get(i).getAttribute("data-x-left-count"));
            if (j > numbers) {
                numbers = j;
            }
        }
        return numbers;
    }

    public double getMarkHotel(){
        List<WebElement> getAllMarks = driver.findElements(By.xpath("//div[@class='bui-review-score__badge']"));

        double mark = 0;

        for(int i = 0; i < getAllMarks.size(); i++){
            double j = Double.parseDouble(getAllMarks.get(i).getAttribute("aria-label"));
            if (j > mark) {
                mark = j;
            }
        }
        return mark;
    }

    public int getMaxSquare(){
        List<WebElement> getAllSquares = driver.findElements(By.xpath("//span[@class='sr-rt-size']"));
        int square = 0;

        for(int i = 0; i < getAllSquares.size(); i++) {
//            getDiscount.get(i).getText().substring(1, getDiscount.get(i).getText().length() - 1)
            int j = Integer.parseInt(getAllSquares.get(i).getText().substring(2, getAllSquares.get(i).getText().length() - 3));
//            System.out.println(j);
            if (j > square) {
                square = j;
//                System.out.println(square);
            }
        }
        return square;
    }

    public String getHotelWithMaxSquare(){
        String hotel = "(//span[@class='sr-rt-size'])";
        List<WebElement> getAllSquares = driver.findElements(By.xpath("//span[@class='sr-rt-size']"));
        int index = 0;
        int square = 0;

        for(int i = 0; i < getAllSquares.size(); i++){
            int j = Integer.parseInt(driver.findElement(By.xpath("//span[@class='sr-rt-size']")).getText().substring(2,getAllSquares.get(i).getText().length() - 4));
            if (j > square) {
                square = j;
                index = i + 1;
            }
        }
        return hotel + "[" + index + "]";
    }


    public void clickHotelWithMaxSquare(){

        driver.findElement(By.xpath(getHotelWithMaxSquare())).click();

        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }

    }

    public boolean threeMoreNumbersFree(){
        return getCountNumberRooms()>=3;
    }

    public boolean getReservationWithoutCreditCard(){
        return reservationWithoutCreditCard.isDisplayed();
    }

    public boolean markHotelNotLessThen9(){
        return getMarkHotel()>=9;
    }

    public boolean squreNumberNotLessThen50(){
        return getMaxSquare()>=50;
    }
}