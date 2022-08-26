package com.MOJICT.IACFee.Util;

import com.MOJICT.IACFee.Beans.CPIBean;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class S3Storage {

    /**
     * log4j logging solution
     */
    static Logger logger = Logger.getLogger(S3Storage.class);

    public boolean uploadToS3(HttpEntity data, String fileName, String bucketName) {

        try {
            String fileType = getFileTypeFromName(fileName);

            HttpClient httpclient = new DefaultHttpClient();
            String restAPIURL = CPIBean.getREST_API_URL() + bucketName + "/" + getPathRouting(fileType, bucketName) + fileName;
            logger.info("restAPIURL is: " + restAPIURL);
            HttpPut put = new HttpPut(restAPIURL);

            put.addHeader("Accept", "*/*");
            put.addHeader("Content-type", "multipart/form-data");

            put.setEntity(data);

            HttpResponse postResponse = httpclient.execute(put);

            logger.info(postResponse);
            logger.info("Status Code is: " + postResponse.getStatusLine().getStatusCode());

            if (postResponse.getStatusLine().getStatusCode() != 200) {
                throw new Exception("S3Storage.uploadToS3 - Filename: " + fileName + "\n\n***** You must run these tests on MoJ VPN *****");
			} else {
                return true;
            }

        } catch (Exception ex) {
            // TO-DO - add notification system to team to alert of failed upload eg. Slack or Email etc
            logger.error("S3Storage.uploadToS3", ex);
            return false;
        }

    }

    private String getFileTypeFromName(String fileName) {
        return fileName.substring(fileName.length() - 3).toUpperCase();
    }

    private String getPathRouting(String fileType, String bucketName) {
        String bucketPath = "";
        String fileTypeFolder = "";

        if (bucketName.contains("backup") || bucketName.contains("test")) {
            bucketPath = "IACFees_backup/";
        } else {
            bucketPath = "IACFees.files/";
        }

        if (fileType.equals("PDF")) {
            fileTypeFolder = "PDF_Files/";
        } else if (fileType.equals("XML")) {
            fileTypeFolder = "XML_Files/";
        }

        return bucketPath + fileTypeFolder;
    }

}
