import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.SendLetterInSpamPage;

public class SendLetterPageInSpamTest extends WebDriverSettings{

    @Test
    public void letterSpam(){
        SendLetterInSpamPage sendLetterInSpamPage = PageFactory.initElements(driver, SendLetterInSpamPage.class);
        loginPage.register("sysrq08884", "5682777a");
        loginPage.clickEnterButton();
        delMessagePage.clickCheckboxMessage();
        sendLetterInSpamPage.clickSpamButton();
        Assert.assertTrue(sendLetterInSpamPage.infoLinkPresents());
    }
}