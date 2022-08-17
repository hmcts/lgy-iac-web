package com.MOJICT.IACFee.Util;

import com.MOJICT.IACFee.Beans.CPIBean;
import org.apache.log4j.Logger;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestSavePDF {

    static Logger logger = Logger.getLogger(TestSavePDF.class);
    static String saveFilePath = "./test-output/";
    static String saveFilePDFName = "TestPDF";
    static String referencePDFName = "229910219260.pdf";
    static String saveFileAggregatedName = "Aggregated";
    static String bucketName = "upload-pdf-test";
    static String apiURL = "https://j7ouh6nm42.execute-api.eu-west-2.amazonaws.com/Test/";

    @Mock
    public static MockedStatic<CPIBean> bean;
    @Mock
    public static MockedStatic<Helper> helper;

    @BeforeClass
    public static void setup() {
        bean = Mockito.mockStatic(CPIBean.class);
        helper = Mockito.mockStatic(Helper.class);
    }

    @AfterClass
    public static void close() {
        bean.close();
        helper.close();
    }

    @Ignore
    public void testAggregatedSavePDFToS3() {
        bean.when(CPIBean::getSTORAGE_METHOD).thenReturn("S3");
        bean.when(CPIBean::getBUCKET_NAME).thenReturn(bucketName);
        bean.when(CPIBean::getREST_API_URL).thenReturn(apiURL);

        helper.when(() -> Helper.savePDF(Mockito.any(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenCallRealMethod();

        ByteArrayOutputStream referencePDF = readPDFtoBaos(referencePDFName);

        Boolean uploadResult = Helper.savePDF(referencePDF, saveFilePDFName, saveFileAggregatedName, "/");
        assertTrue(uploadResult);
    }

    @Ignore
    public void testSingleSavePDFToS3() {
        bean.when(CPIBean::getSTORAGE_METHOD).thenReturn("S3");
        bean.when(CPIBean::getBUCKET_NAME).thenReturn(bucketName);
        bean.when(CPIBean::getREST_API_URL).thenReturn(apiURL);

        helper.when(() -> Helper.savePDF(Mockito.any(), Mockito.anyString(), Mockito.anyString())).thenCallRealMethod();

        ByteArrayOutputStream referencePDF = readPDFtoBaos(referencePDFName);

        Boolean uploadResult = Helper.savePDF(referencePDF, saveFilePDFName, "/");
        assertEquals(true, uploadResult);
    }

    @Test
    public void testAggregatedSavePDFLocally() {
        String createdPDFName = saveFilePath + saveFileAggregatedName + "_" + saveFilePDFName + ".pdf";

        bean.when(CPIBean::getSTORAGE_METHOD).thenReturn("local");

        helper.when(() -> Helper.getKeyValue(Mockito.anyString(), Mockito.anyString())).thenReturn(saveFilePath);
        helper.when(() -> Helper.savePDF(Mockito.any(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenCallRealMethod();

        ByteArrayOutputStream referencePDF = readPDFtoBaos(referencePDFName);

        Helper.savePDF(referencePDF, saveFilePDFName, saveFileAggregatedName, "/");

        ByteArrayOutputStream savedPDF = readPDFtoBaos(createdPDFName);

        assertEquals(referencePDF.toString(), savedPDF.toString());

        try {
            Files.deleteIfExists(Paths.get(createdPDFName));
        } catch (IOException e) {
            logger.error("TestSavePDF.testAggregatedSavePDFLocally", e);
        }
    }

    @Test
    public void testSingleSavePDFLocally() {
        String createdPDFName = saveFilePath + saveFilePDFName + ".pdf";

        bean.when(CPIBean::getSTORAGE_METHOD).thenReturn("local");

        helper.when(() -> Helper.getKeyValue(Mockito.anyString(), Mockito.anyString())).thenReturn(saveFilePath);
        helper.when(() -> Helper.savePDF(Mockito.any(), Mockito.anyString(), Mockito.anyString())).thenCallRealMethod();

        ByteArrayOutputStream referencePDF = readPDFtoBaos(referencePDFName);

        Helper.savePDF(referencePDF, saveFilePDFName, "/");

        ByteArrayOutputStream savedPDF = readPDFtoBaos(createdPDFName);

        assertEquals(referencePDF.toString(), savedPDF.toString());

        try {
            Files.deleteIfExists(Paths.get(createdPDFName));
        } catch (IOException e) {
            logger.error("TestSavePDF.testSingleSavePDFLocally", e);
        }
    }

    public ByteArrayOutputStream readPDFtoBaos(String filePath) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            byte[] buffer = new byte[8192];

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1){
                baos.write(buffer, 0, bytesRead);
            }

        } catch (Exception e) {
            logger.error("TestSavePDF.readPDFtoBaos", e);
        }

        logger.info("TestSavePDF.readPDFtoBaos - Successfully read in file " + filePath);

        return baos;
    }
}
