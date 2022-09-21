package uk.gov.hmcts.legacy.web;

import org.junit.Test;
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.BaseTest;
import uk.gov.hmcts.legacy.web.selenium.WelcomeActions_Scenarios;

public class SampleSeleniumTest extends BaseTest {

    static Logger logger = Logger.getLogger(SampleSeleniumTest.class);

    @Test
    public void WelcomeActionTest() {
        try {
            logger.info("Initiating WelcomeActionTest");
            init();
            WelcomeActions_Scenarios.loadScenarios_WelcomeActionSubmitAppeal();
            WelcomeActions_Scenarios.runTest_WelcomeAction();
        } catch (Exception e) {
            logger.error("SampleSeleniumTest.WelcomeActionTest - ", e);
        }
    }

}
