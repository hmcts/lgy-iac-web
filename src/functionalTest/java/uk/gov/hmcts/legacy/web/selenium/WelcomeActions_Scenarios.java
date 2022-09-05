package uk.gov.hmcts.legacy.web.selenium;

import uk.gov.hmcts.legacy.web.selenium.data.IAFT1_Flows;
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.data.WelcomeActions_Pages;
import uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages.WelcomeActions;

public class WelcomeActions_Scenarios extends BaseTest  implements IAFT1_Flows, WelcomeActions_Pages {

    static Logger logger = Logger.getLogger(WelcomeActions_Scenarios.class);

    public static String [] welcomeActionsSubmitAppeal = {WelcomeActions.SUBMIT_APPEAL, WelcomeActions.SUBMIT_APPEAL_VALIDATE};

    public static void loadScenarios_WelcomeActionSubmitAppeal() {
        page1.initialise(welcomeActionsSubmitAppeal);
    }

    public static void runTest_WelcomeAction() {
        page1.execute();
    }
}
