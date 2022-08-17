package com.MOJICT.IACFee.Util;

import java.io.*;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.MOJICT.IACFee.Beans.*;
import com.MOJICT.IACFee.Util.*;
import java.util.Date;

public class LocalFileStorage {

    /**
     * log4j logging solution
     */
    static Logger logger = Logger.getLogger(LocalFileStorage.class);

    public boolean savePDFToLocalStorage(ByteArrayOutputStream baos, String path, String fileName) {

        try {
            path = Helper.getKeyValue(path, "PDFs");
            logger.debug("PDF Path = " + path);
            OutputStream outputstream = new FileOutputStream(path + fileName);
            baos.writeTo(outputstream);
            outputstream.close();

            //Extra logging to pinpoint missing xml and pdf issue
            logger.debug(fileName + " is successfully created at " + new Date());

            return true;

        } catch (Exception ex) {
            logger.error("LocalFileStorage.savePDFToLocalStorage", ex);
            return false;
        }

    }

    public void saveXMLToLocalStorage(ByteArrayOutputStream baos, HttpServletRequest req, String urn){
        OutputStream out = null;
        String path = req.getRealPath("/").toString();
        final String FILE_PATH = Helper.getKeyValue(path,"XMLs");
        logger.debug("XML path = "+ FILE_PATH );

        try {
            out = new FileOutputStream(FILE_PATH + urn + ".xml");
            baos.writeTo(out);
            out.flush();
            out.close();
            baos.close();

            //Extra logging to pinpoint missing xml and pdf issue
            logger.debug(urn + ".xml is successfully created at "+ new Date());

        } catch (Exception e) {
            logger.error("LocalFileStorage.saveXMLToLocalStorage", e);
        }
    }

}
