package com.MOJICT.IACFee.Health;

import com.MOJICT.IACFee.Util.Helper;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PdfLiveness extends Action {
    static Logger logger = Logger.getLogger(PdfLiveness.class);
    static String referencePDFName = "/opt/reference.pdf";
    static String saveFilePDFName = "TestPDFtoS3";

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException, Exception {
        logger.info("In PdfLiveness....");
        logger.info("STORAGE_METHOD is: " + System.getenv("STORAGE_METHOD"));
        logger.info("BUCKET_NAME is: " + System.getenv("BUCKET_NAME"));
        logger.info("REST_API_URL is: " + System.getenv("REST_API_URL"));

        ByteArrayOutputStream referencePDF = readPDFtoBaos(referencePDFName);

        Boolean uploadResult = Helper.savePDF(referencePDF, saveFilePDFName, "/");

        response.setStatus(200);
        return null;
    }

    public ByteArrayOutputStream readPDFtoBaos(String filePath) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            logger.info("opening file: " + filePath);
            InputStream inputStream = new FileInputStream(filePath);
            byte[] buffer = new byte[8192];

            logger.info("reading data from filestream");
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1){
                baos.write(buffer, 0, bytesRead);
            }

        } catch (Exception e) {
            logger.error("PdfLiveness.readPDFtoBaos", e);
        }

        logger.info("PdfLiveness.readPDFtoBaos - Successfully read in file " + filePath);

        return baos;
    }
}
