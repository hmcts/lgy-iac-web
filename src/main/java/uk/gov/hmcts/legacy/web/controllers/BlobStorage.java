package uk.gov.hmcts.legacy.web.controllers;

import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class BlobStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    private static final String  TEST_FILE_NAME = "229910219260.xml";
    private static final String URN = "TestXML01";

    public boolean uploadToBlobStorage(HttpEntity data, String fileName, String containerName) throws IOException {

        //CloseableHttpClient httpclient = HttpClients.createDefault();
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            //String fileType = getFileTypeFromName(fileName);

            //HttpClient httpclient = new DefaultHttpClient();
            //String restAPIURL = CPIBean.getREST_API_URL() + bucketName + "/"
            // + getPathRouting(fileType, bucketName) + fileName;
            //String restAPIURL = "https://teststoragu.blob.core.windows.net/container-fk-1/" + fileName + "?sp=racwdli&st=2022-08-12T13:49:13Z&se=2022-08-19T21:49:13Z&spr=https&sv=2021-06-08&sr=c&sig=2fFH9CuWoO7WHLzAzj8GjlJQUz56Hwr2g4vk1FFBx0Y%3D";
            String restApiUrl = "https://lgyiacwebstg.blob.core.windows.net/xml/" + fileName;

            //logger.info("restAPIURL is: " + restAPIURL);
            HttpPut put = new HttpPut(restApiUrl);

            put.addHeader("Accept", "*/*");
            put.addHeader("Content-type", "multipart/form-data");
            put.addHeader("x-ms-blob-type", "BlockBlob");

            put.setEntity(data);

            //HttpResponse postResponse = httpclient.execute(put);
            try (CloseableHttpResponse postResponse = httpclient.execute(put)) {
                //logger.info(postResponse);
                //logger.info("Status Code is: " + post Response.getStatusLine().getStatusCode());

                LOGGER.info("blob storage response: " + postResponse.getStatusLine().getStatusCode() + "---"
                                + postResponse.getStatusLine().getReasonPhrase());

                /*if (postResponse.getStatusLine().getStatusCode() != 200) {
                    //throw new Exception("S3Storage.uploadToS3 - Filename: " + fileName);
                    LOGGER.error("BlobStorage.uploadToContainer - Filename: " + fileName);
                } else {
                    return true;
                }*/
                return true;
            }


        } catch (Exception ex) {
            // TO-DO - add notification system to team to alert of failed upload eg. Slack or Email etc
            //logger.error("S3Storage.uploadToS3", ex);
            LOGGER.error("S3Storage.uploadToS3", ex);
            return false;
        }

    }

    //public static void writetofile(Document doc, HttpServletRequest req, String urn) {
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
            //    try {
            //        S3Storage S3Storage = new S3Storage();
            //        S3Storage.uploadToS3(new ByteArrayEntity(baos.toByteArray()), fileName, "upload-pdf-test");
            //   } catch (Exception ex) {
            //        logger.error("DocWriteDOM.writetofile - S3 Upload", ex);
            //    }
            //} else {
            //     LocalFileStorage localFileStorage = new LocalFileStorage();
            //     localFileStorage.saveXMLToLocalStorage(baos, req, urn);
            //}
        } catch (IOException e) {
            //logger.error("DocWriteDOM.writetofile", e);
            LOGGER.error("DocWriteDOM.writetofile", e);
        }

    }

    public void test() {
        Document existingXml = convertXmlToDoc(TEST_FILE_NAME);
        writetofile(existingXml, URN);
    }

    public Document convertXmlToDoc(String file) {
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
