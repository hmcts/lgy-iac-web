package uk.gov.hmcts.legacy.web;

import org.junit.Test;
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.BaseTest;

public class SampleSeleniumTest extends BaseTest {

    static Logger logger = Logger.getLogger(SampleSeleniumTest.class);

    @Test
    public void WelcomeActionTest() {
        try {
            init();
            logger.info("Test: IAFT1 User Journey");
        } catch (Exception e) {
            logger.error("SampleSeleniumTest.WelcomeActionTest - ", e);
        }
    }

}
