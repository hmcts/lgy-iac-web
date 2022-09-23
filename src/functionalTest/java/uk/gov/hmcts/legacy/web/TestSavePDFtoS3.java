package uk.gov.hmcts.legacy.web;

import com.MOJICT.IACFee.Beans.CPIBean;
import com.MOJICT.IACFee.Util.Helper;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class TestSavePDFtoS3 {

    static Logger logger = Logger.getLogger(TestSavePDFtoS3.class);
    static String saveFilePDFName = "TestPDF";
    static String referencePDFName = "reference.pdf";
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
    public void testSingleSavePDFToS3() {
        bean.when(CPIBean::getSTORAGE_METHOD).thenReturn("S3");
        bean.when(CPIBean::getBUCKET_NAME).thenReturn(bucketName);
        bean.when(CPIBean::getREST_API_URL).thenReturn(apiURL);

        helper.when(() -> Helper.savePDF(Mockito.any(), Mockito.anyString(), Mockito.anyString())).thenCallRealMethod();

        ByteArrayOutputStream referencePDF = readPDFtoBaos(referencePDFName);

        Boolean uploadResult = Helper.savePDF(referencePDF, saveFilePDFName, "/");
        assertEquals(true, uploadResult);
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
