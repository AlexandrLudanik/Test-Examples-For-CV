import org.junit.Assert;
import org.junit.Test;

public class LoginPageTest extends WebDriverSettings{

    @Test
    public void loginWithValidCreds() {
        loginPage.register("sysrq08884", "5682777a");
        System.out.println(loginPage.logoutLinkPresents(driver));
        Assert.assertTrue(loginPage.logoutLinkPresents(driver));
    }
}
