package com.MOJICT.IACFee.Util;

import com.MOJICT.IACFee.Beans.CPIBean;
import org.apache.log4j.Logger;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.jdom.Document;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class TestWriteToFile {

    static Logger logger = Logger.getLogger(TestWriteToFile.class);

    static String saveFilePath = "./test-output/";
    static String saveFileXMLName = "TestXML.xml";
    static String referenceXMLName = "reference.xml";
    static String URN = "TestXML";
    static String mockedURL = "mockedUrl";
    static String mockedStorageMethod = "local";

    @Mock
    public static MockedStatic<CPIBean> bean;
    @Mock
    public static MockedStatic<Helper> helper;
    @Mock
    public static MockedStatic<DocWriteDOM> docWriteDOM;

    @BeforeClass
    public static void setup() {
        bean = Mockito.mockStatic(CPIBean.class);
        helper = Mockito.mockStatic(Helper.class);
        docWriteDOM = Mockito.mockStatic(DocWriteDOM.class);
    }

    @AfterClass
    public static void close() {
        bean.close();
        helper.close();
        docWriteDOM.close();
    }

    @Ignore
    public void testWriteToFileLocally(){

        bean.when(CPIBean::getSTORAGE_METHOD).thenReturn(mockedStorageMethod);
        helper.when(() -> Helper.getKeyValue(Mockito.anyString(), Mockito.anyString())).thenReturn(saveFilePath);
        docWriteDOM.when(() -> DocWriteDOM.writetofile(Mockito.any(), Mockito.any(), Mockito.anyString())).thenCallRealMethod();

        HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
        Mockito.when(mockedRequest.getRealPath(Mockito.any())).thenReturn(mockedURL);

        Document existingXML = convertXMLToDoc(referenceXMLName);

        DocWriteDOM.writetofile(existingXML, mockedRequest, URN);
        Document createdXML = convertXMLToDoc(saveFilePath + saveFileXMLName);

        String existingXMLAsString = new XMLOutputter().outputString(existingXML);
        String createdXMLAsString = new XMLOutputter().outputString(createdXML);

        assertEquals(existingXMLAsString, createdXMLAsString);

        try {
            Files.deleteIfExists(Paths.get(saveFilePath + saveFileXMLName));

        } catch (IOException e) {
            logger.error("TestWriteToFile.testWriteToFileLocally", e);
        }
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
