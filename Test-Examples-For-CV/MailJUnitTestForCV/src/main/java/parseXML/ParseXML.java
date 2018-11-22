package parseXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseXML {


    public static List<Recepient> recepientAndMessage() throws ParserConfigurationException, IOException, SAXException {

        File file = new File("C:\\Users\\User\\Desktop\\MailJUnitTestForCV\\src\\file.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);


        List<Recepient> recepientList = new ArrayList<Recepient>();


        NodeList recepientNodeList = document.getElementsByTagName("Recipient");
        {
            for (int i = 0; i < recepientNodeList.getLength(); i++) {
                if (recepientNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element recepientElement = (Element) recepientNodeList.item(i);

                    Recepient recepient = new Recepient();
                    recepient.setId(Integer.valueOf(recepientElement.getAttribute("id")));

                    NodeList childNotes = recepientElement.getChildNodes();
                    for (int j = 0; j < childNotes.getLength(); j++) {
                        if (childNotes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element childElement = (Element) childNotes.item(j);

                            String s = childElement.getNodeName();
                            if ("email".equals(s)) {
                                recepient.setEmail(childElement.getTextContent());
                            } else if ("text".equals(s)) {
                                recepient.setText(childElement.getTextContent());
                            }
                        }
                    }
                    recepientList.add(recepient);
                }
            }
        }
        return recepientList;
    }
}
