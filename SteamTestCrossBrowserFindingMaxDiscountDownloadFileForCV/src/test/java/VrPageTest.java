import org.junit.Test;
import org.testng.Assert;

public class VrPageTest extends WebDriverSettings{


    @Test
    public void choseMaxDiscountOnVrPage() {
        homePage.clickLinkGames();
        homePage.clickLinkVr();
        vrPage.waitLogo();
        int discFind = vrPage.discount();

        vrPage.clickOnGameWithMaxDiscount();
        ageCheckPage.setYearAndPressOkButton();

        gameWithMaxDiscountPage.waitGameName();
        int discGame = gameWithMaxDiscountPage.getDiscountGame();
        Assert.assertEquals(discFind, discGame);
    }
}