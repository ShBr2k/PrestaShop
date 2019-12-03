package main.java.test.roman;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLConverter {

    /* MainRunner. Convert XMLFile to String
     */
    protected static String convertXMLFileToString (String xmlFileCust) {
        Document xmlDocument = convertXMLFileToXMLDocument(xmlFileCust);
        String stringValuesCust = convertXmlDocumentToString (xmlDocument);
        return stringValuesCust;
    }

    /* MainRunner. Get values from XMLFile
     */
    protected static String[] getCustValuesFromXMLFile(String xmlFileCust) {
        Document xmlDocument = convertXMLFileToXMLDocument(xmlFileCust);
        String stringArrayValuesCust [] = getCustValuesFromXMLDocument (xmlDocument);
        return stringArrayValuesCust;
    }

    /* Convert XMLFile to XMLDocument
     */
    protected static Document convertXMLFileToXMLDocument(String filePathIn) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();
            //Parse the content to Document object
            Document xmlDocument = builder.parse(new File(filePathIn));
            return xmlDocument;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Convert XMLDocument to String
     */
    protected static String convertXmlDocumentToString(Document xmlDocument)  //writeXmlDocumentToString
    {
        String xmlString = null;
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();

            // Uncomment if you do not require XML declaration
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            //Print XML or Logs or Console
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer));
            xmlString = writer.getBuffer().toString();
            //System.out.println(xmlString);

            //Write XML to file
            //FileOutputStream outStream = new FileOutputStream(new File(filePathOut));
            //transformer.transform(new DOMSource(xmlDocument), new StreamResult(outStream));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xmlString;
    }

    /* Get values from XMLDocument
     */
    public static String[] getCustValuesFromXMLDocument(Document xmlDocument) {
        //DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        xmlDocument.getDocumentElement().normalize();
        NodeList nList = xmlDocument.getElementsByTagName("prestashop");
        Node node = nList.item(0);
        Element eElement = (Element) node;
        String firstname = eElement.getElementsByTagName("firstname").item(0).getTextContent();
        String lastname = eElement.getElementsByTagName("lastname").item(0).getTextContent();
        String email = eElement.getElementsByTagName("email").item(0).getTextContent();
        String birthDay = eElement.getElementsByTagName("birthday").item(0).getTextContent();
        return new String[]{firstname, lastname, email, birthDay};
    }

}
