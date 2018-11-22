import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;
import parseXML.ParseXML;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SendLetterPageGroupTest extends WebDriverSettings{

    @Test
    public void sendLetterGroup() throws IOException, SAXException, ParserConfigurationException {
        loginPage.register("sysrq08884", "5682777a");
        loginPage.clickEnterButton();
        sendLetterPage.clickButtonWriteLetter();
        sendLetterGroupPage.clickFieldReceiver();
        sendLetterGroupPage.setEmail(ParseXML.recepientAndMessage().get(0).getEmail());
        sendLetterGroupPage.clickFieldReceiver();
        sendLetterGroupPage.setEmail(ParseXML.recepientAndMessage().get(1).getEmail());
        sendLetterGroupPage.writeMessage("Hello, How are you?");
        sendLetterPage.clickButtonSendLetter();
        Assert.assertTrue(sendLetterPage.sendMessage());
    }
}