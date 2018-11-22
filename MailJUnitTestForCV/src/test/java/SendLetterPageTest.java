import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;
import parseXML.ParseXML;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SendLetterPageTest extends WebDriverSettings{

    @Test
    public void sendLetter() throws IOException, SAXException, ParserConfigurationException {
        loginPage.register("sysrq08884", "5682777a");
        loginPage.clickEnterButton();
        sendLetterPage.clickButtonWriteLetter();
        sendLetterPage.writeEmailAndMessage(ParseXML.recepientAndMessage().get(0).getEmail(), ParseXML.recepientAndMessage().get(0).getText());
        sendLetterPage.clickButtonSendLetter();
        Assert.assertTrue(sendLetterPage.sendMessage());
    }
}