import org.junit.Assert;
import org.junit.Test;

public class LetterOutOfSpamPageTest extends WebDriverSettings{

    @Test
    public void letterOutOfSpam(){
        loginPage.register("sysrq08884", "5682777a");
        loginPage.clickEnterButton();
        letterOutOfSpamPage.clickSpamLink();
        letterOutOfSpamPage.clickCheckBoxSpam();
        letterOutOfSpamPage.clickNoSpamButton();
        Assert.assertTrue(letterOutOfSpamPage.infoLinkPresents());
    }
}
