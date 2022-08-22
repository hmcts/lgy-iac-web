package uk.gov.hmcts.legacy.web.controllers;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.identity.ManagedIdentityCredential;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class BlobStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    private static final String TEST_FILE_NAME = "229910219260.xml";
    private static final String URN = "TestXML01";

    public void uploadToBlobStorage2() {

        try {

            //DefaultAzureCredential defaultAzureCredential = new DefaultAzureCredentialBuilder()
            //    .authorityHost(AzureAuthorityHosts.AZURE_GOVERNMENT)
            //    .build();

            //ManagedIdentityCredential managedIdentityCredential = new ManagedIdentityCredentialBuilder()
            //    .clientId("26df1e24-a1d1-4317-b583-1e8af8a03ee1")
            //    .build();

            String endpoint = "https://lgyiacwebstg.blob.core.windows.net";
            //String endpoint = "https://fksa.blob.core.windows.net";
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint)
                //.credential(managedIdentityCredential)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();


            LOGGER.info("Successfully setup client using the Azure Identity, please check the service version: "
                            + blobServiceClient.getProperties().getDefaultServiceVersion());

            BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient("xml");

            //ManagedIdentityCredential managedIdentityCredential = new ManagedIdentityCredentialBuilder()
            //    .build();

            BlobClient blobClient = blobContainerClient.getBlobClient("testblob");
            LOGGER.info("\nUploading to Blob storage as blob:\n\t" + blobClient.getBlobUrl());
            // Upload the blob
            blobClient.uploadFromFile(TEST_FILE_NAME);
        } catch (Exception ex) {
            LOGGER.error("Blob storage file upload error", ex);
        }


    }

    public void uploadToBlobStorage(ByteArrayEntity data, String fileName, String containerName) throws IOException {

        try {

            ManagedIdentityCredential managedIdentityCredential =
                new ManagedIdentityCredentialBuilder()
                    .clientId("74dacd4f-a248-45bb-a2f0-af700dc4cf68")
                    .retryTimeout(duration -> Duration.ofSeconds(1))
                    .build();

            String endpoint = "https://lgyiacwebstg.blob.core.windows.net";
            //String endpoint = "https://fksa.blob.core.windows.net";
            /*BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint)
                .credential(new DefaultAzureCredentialBuilder()
                                .managedIdentityClientId("74dacd4f-a248-45bb-a2f0-af700dc4cf68")
                                .build())
                .buildClient();*/
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint)
                .credential(managedIdentityCredential)
                .buildClient();

            LOGGER.info("Successfully setup client using the Azure Identity, please check the service version: "
                            + blobServiceClient.getProperties().getDefaultServiceVersion());

            BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(containerName);

            BlobClient blobClient = blobContainerClient.getBlobClient(fileName);
            LOGGER.info("\nUploading to Blob storage as blob:\n\t" + blobClient.getBlobUrl());
            // Upload the blob
            try (InputStream dataToUpload = data.getContent()) {
                blobClient.upload(new BufferedInputStream(dataToUpload), data.getContentLength(), true);
            } catch (Exception ex) {
                LOGGER.error("Blob storage file upload error - 1", ex);
            }

        } catch (Exception ex) {
            LOGGER.error("Blob storage file upload error - 2", ex);
        }


    }

    public boolean uploadToBlobStorage1(HttpEntity data, String fileName, String containerName) throws IOException {

        //CloseableHttpClient httpclient = HttpClients.createDefault();
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            //String fileType = getFileTypeFromName(fileName);

            //HttpClient httpclient = new DefaultHttpClient();
            //String restAPIURL = CPIBean.getREST_API_URL() + bucketName + "/"
            // + getPathRouting(fileType, bucketName) + fileName;
            //String restApiUrl = "https://teststoragu.blob.core.windows.net/container-fk-1/" + fileName + "?sp=racwdli&st=2022-08-12T13:49:13Z&se=2022-08-19T21:49:13Z&spr=https&sv=2021-06-08&sr=c&sig=2fFH9CuWoO7WHLzAzj8GjlJQUz56Hwr2g4vk1FFBx0Y%3D";
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
    public void writetofile(Document doc, String urn) {

        String fileName = urn + ".xml";

        try {
            XMLOutputter outputter = new XMLOutputter();
            //outputter.setEncoding("UTF-8");

            Format format = Format.getPrettyFormat().setEncoding("utf-8").setLineSeparator("\n");
            outputter.setFormat(format);


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            outputter.output(doc, baos);

            uploadToBlobStorage(new ByteArrayEntity(baos.toByteArray()), fileName, "xml");

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
        /*FilePrint fp = new FilePrint();
        File root = new File("/opt");
        if (root != null) {
            fp.printAllJavaFiles(root);
        }*/

        Document existingXml = convertXmlToDoc(TEST_FILE_NAME);
        if (existingXml != null) {
            writetofile(existingXml, URN);
        }
    }

    public Document convertXmlToDoc(String file) {

        try {
            ClassPathResource res = new ClassPathResource(file);
            File inputFile = new File(res.getPath());
            //File inputFile = new File(file);
            if (inputFile != null) {
                SAXBuilder saxBuilder = new SAXBuilder();
                return saxBuilder.build(inputFile);
            } /*else {
                LOGGER.error("Error opening existingXml");
                return null;
            }*/
            LOGGER.error("Error opening existingXml");
            return null;
        } catch (Exception e) {
            //logger.error("Error converting XML to doc", e);
            LOGGER.error("Exception while opening existingXml" + e);
            return null;
        }
    }
}
