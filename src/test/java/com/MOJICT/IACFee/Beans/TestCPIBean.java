package com.MOJICT.IACFee.Beans;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestCPIBean {

    static Logger logger = Logger.getLogger(TestCPIBean.class);

    @Test
    public void testMockStaticMethod() {

        // If mocking static methods, use this structure
        MockedStatic<CPIBean> bean = Mockito.mockStatic(CPIBean.class);
        bean.when(CPIBean::getPSPID).thenReturn("mockedPSPID");
        String pspid = CPIBean.getPSPID();
        bean.close();
        logger.info("PSPID " + pspid);
        assertEquals("mockedPSPID", pspid);
    }

    @Test
    public void testMockNonStaticMethod() {

        // If mocking non-static methods, use this structure
        CPIBean bean = Mockito.mock(CPIBean.class);
        Mockito.when(bean.getStoreURL()).thenReturn("mockedUrl");
        String url = bean.getStoreURL();

        logger.info("URL " + url);
        assertEquals("mockedUrl", url);
    }
}
