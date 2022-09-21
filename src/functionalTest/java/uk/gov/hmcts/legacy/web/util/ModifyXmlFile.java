package uk.gov.hmcts.legacy.web.util;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

import static uk.gov.hmcts.legacy.web.util.AbstractDataUtility.userDir;

public class ModifyXmlFile {

    private static Document loadDocumentFromInputFile(String filepath) throws ParserConfigurationException, IOException, SAXException {
        try {
            File inputFile = new File(filepath);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            return docBuilder.parse(inputFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Node findItemValueFromElement(Document doc, String Element, String Item) {
        try {
            Node urn = doc.getElementsByTagName(Element).item(0);
            NamedNodeMap attr = urn.getAttributes();
            return attr.getNamedItem(Item);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeDocumentToXMLFile(Document doc, String dataSetToLoad) throws TransformerException {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(userDir + "/src/functionalTest/java/com/data/" + dataSetToLoad));
            transformer.transform(source, result);
        } catch (TransformerFactoryConfigurationError | TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void incrementURNId(String dataSetToLoad) {
        try {
            Document doc = loadDocumentFromInputFile(userDir + "/src/functionalTest/java/com/data/" + dataSetToLoad);
            Node idNode = findItemValueFromElement(doc, "URN", "Id");

            int id = Integer.parseInt(idNode.getNodeValue()) + 1;
            idNode.setTextContent(Integer.toString(id));

            writeDocumentToXMLFile(doc, dataSetToLoad);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
