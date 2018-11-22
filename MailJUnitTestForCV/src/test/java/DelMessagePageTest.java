import org.junit.Assert;
import org.junit.Test;

public class DelMessagePageTest extends WebDriverSettings{

    @Test
    public void delMessage(){
        loginPage.register("sysrq08884","5682777a");
        delMessagePage.clickCheckboxMessage();
        delMessagePage.ClickButtonDelete();
        delMessagePage.infoLinkPresents();
        Assert.assertTrue(delMessagePage.infoLinkPresents());
    }
}
