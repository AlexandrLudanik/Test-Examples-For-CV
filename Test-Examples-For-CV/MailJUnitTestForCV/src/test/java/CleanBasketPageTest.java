import org.junit.Assert;
import org.junit.Test;

public class CleanBasketPageTest extends WebDriverSettings{

    @Test
    public void basketImagePresent() {
        loginPage.register("sysrq08884", "5682777a");
        loginPage.clickEnterButton();
        cleanBasketPage.clickBasketLink();
        try {
            cleanBasketPage.clickButtonClearFolder();
            cleanBasketPage.clickButtonConfirm();

        } catch (Exception e) {
            Assert.assertTrue(cleanBasketPage.basketImagePresent());

        }
        Assert.assertTrue(cleanBasketPage.basketImagePresent());
    }
}
