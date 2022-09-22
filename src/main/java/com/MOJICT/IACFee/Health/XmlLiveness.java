package com.MOJICT.IACFee.Health;

import com.MOJICT.IACFee.Util.DocWriteDOM;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class XmlLiveness extends Action {
    static Logger logger = Logger.getLogger(XmlLiveness.class);
    static String referenceXMLName = "/opt/reference.xml";
    static String saveFileXMLName = "TestXmltoS3";

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException, Exception {
        logger.info("In XmlLiveness....");
        logger.info("STORAGE_METHOD is: " + System.getenv("STORAGE_METHOD"));
        logger.info("BUCKET_NAME is: " + System.getenv("BUCKET_NAME"));
        logger.info("REST_API_URL is: " + System.getenv("REST_API_URL"));

        Document existingXML = convertXMLToDoc(referenceXMLName);
        logger.info("opened document baseUri <" + existingXML.getBaseURI() + ">");
        DocWriteDOM.writetofile(existingXML, null, saveFileXMLName);

        response.setStatus(200);
        return null;
    }

    public Document convertXMLToDoc(String file) {
        try {
            File inputFile = new File(file);
            SAXBuilder saxBuilder = new SAXBuilder();
            return saxBuilder.build(inputFile);
        } catch (Exception e) {
            logger.error("Error converting XML to doc", e);
            return null;
        }
    }
}
