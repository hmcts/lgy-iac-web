package uk.gov.hmcts.legacy.web.controllers;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import org.aspectj.bridge.MessageUtil;
import org.jdom2.Namespace;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.jdom2.output.Format;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.File;

public class BlobStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    static String referenceXMLName = "229910219260.xml";
    static String URN = "TestXML01";
    public boolean uploadToBlobStorage(HttpEntity data, String fileName, String containerName) {

        try {
            //String fileType = getFileTypeFromName(fileName);

            HttpClient httpclient = new DefaultHttpClient();
            //String restAPIURL = CPIBean.getREST_API_URL() + bucketName + "/" + getPathRouting(fileType, bucketName) + fileName;
            //String restAPIURL = "https://teststoragu.blob.core.windows.net/container-fk-1/" + fileName + "?sp=racwdli&st=2022-08-12T13:49:13Z&se=2022-08-19T21:49:13Z&spr=https&sv=2021-06-08&sr=c&sig=2fFH9CuWoO7WHLzAzj8GjlJQUz56Hwr2g4vk1FFBx0Y%3D";
            String restAPIURL = "https://lgyiacwebstg.blob.core.windows.net/xml/" + fileName;

            //logger.info("restAPIURL is: " + restAPIURL);
            HttpPut put = new HttpPut(restAPIURL);

            put.addHeader("Accept", "*/*");
            put.addHeader("Content-type", "multipart/form-data");
            put.addHeader("x-ms-blob-type", "BlockBlob");
            //put.addHeader("x-ms-blob-content-disposition", "attachment; filename=\"test01.doc\"");

            put.setEntity(data);

            HttpResponse postResponse = httpclient.execute(put);

            //logger.info(postResponse);
            //logger.info("Status Code is: " + post Response.getStatusLine().getStatusCode());

            //System.out.println("************* blob storage response" + postResponse.getStatusLine().getStatusCode() + postResponse.getStatusLine().getReasonPhrase());
            LOGGER.info("blob storage response: " + postResponse.getStatusLine().getStatusCode() + "---" + postResponse.getStatusLine().getReasonPhrase());

            if (postResponse.getStatusLine().getStatusCode() != 200) {
                throw new Exception("S3Storage.uploadToS3 - Filename: " + fileName);
            } else {
                return true;
            }

        } catch (Exception ex) {
            // TO-DO - add notification system to team to alert of failed upload eg. Slack or Email etc
            //logger.error("S3Storage.uploadToS3", ex);
            return false;
        }

    }

   // public static void writetofile(Document doc, HttpServletRequest req, String urn) {
    public  void writetofile(Document doc, String urn) {

        String fileName = urn + ".xml";

        try {
            XMLOutputter outputter = new XMLOutputter();
            //outputter.setEncoding("UTF-8");

            Format format = Format.getPrettyFormat().setEncoding("utf-8").setLineSeparator("\n");
            outputter.setFormat(format);


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            outputter.output(doc, baos);

            uploadToBlobStorage(new ByteArrayEntity(baos.toByteArray()), fileName, "upload-pdf-test");

            //if (CPIBean.getSTORAGE_METHOD().equals("S3")) {
                //try {
                    //S3Storage S3Storage = new S3Storage();
                    //S3Storage.uploadToS3(new ByteArrayEntity(baos.toByteArray()), fileName, "upload-pdf-test");
                //} catch (Exception ex) {
                    //logger.error("DocWriteDOM.writetofile - S3 Upload", ex);
                //}
            //} else {
                //LocalFileStorage localFileStorage = new LocalFileStorage();
                //localFileStorage.saveXMLToLocalStorage(baos, req, urn);
            //}
        } catch (IOException e) {
            //logger.error("DocWriteDOM.writetofile", e);
        }

    }

    public void test(){

        //Document existingXML = convertXMLToDoc("/home/ubuntu/source/repos/hmcts/lgy-iac-web/src/main/java/uk/gov/hmcts/legacy/web/controllers/229910219260.xml");
        Document existingXML = convertXMLToDoc("229910219260.xml");

        writetofile(existingXML, URN);
    }

    public Document convertXMLToDoc(String file) {
        try {
            File inputFile = new File(file);
            SAXBuilder saxBuilder = new SAXBuilder();
            return saxBuilder.build(inputFile);
        } catch (Exception e) {
            //logger.error("Error converting XML to doc", e);
            return null;
        }
    }
}
