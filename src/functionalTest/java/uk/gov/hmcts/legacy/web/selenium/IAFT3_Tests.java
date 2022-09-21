/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium;

import uk.gov.hmcts.legacy.web.util.DataLoader;
import uk.gov.hmcts.legacy.web.util.ModifyXmlFile;
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.data.IAFT3_Flows;
import uk.gov.hmcts.legacy.web.selenium.data.IAFT3_Pages;

public class IAFT3_Tests extends BaseTest implements IAFT3_Flows, IAFT3_Pages, ExpectedResults {

    static Logger logger = Logger.getLogger(IAFT3_Tests.class);

    public static void loadScenarios_IAFT3() {
        page1.initialise(welcomeActionsSubmitAppeal);
        page2.initialise(formOptions);
        page3.initialise(lodgementOptions);
        page4.initialise(ecoOptions);
        page5.initialise(LeftUKOptions);
        page6.initialise(AsylumRefusalOptions);
        page7.initialise(referenceOptions);
        page8.initialise(quick_stage1Options);
        page9.initialise(quick_stage2Options);
        page10.initialise(quick_stage3Options);
        page11.initialise(quick_stage4Options);
        page12.initialise(quick_stage5Options);
        page13.initialise(quick_stage6Options);
        page14.initialise(quick_stage7Options);
        page15.initialise(quick_stage8Options);
        page16.initialise(quick_stage9Options);
        page17.initialise(quick_stage10Options);
        page18.initialise(paymentSubmission_FinaliseOptions);
        page19.initialise(empty);
        page20.initialise(empty);
        page21.initialise(test_payment_options);
    }

    public static void runPages() {
//        ModifyXmlFile.incrementURNId("partial.xml");
//        DataLoader.load("partial.xml");
        page1.execute();
        page2.execute();
        page3.execute();
        page4.execute();
        page5.execute();
        page6.execute();
        page7.execute();
        page8.execute();
        page9.execute();
        page10.execute();
        page11.execute();
        page12.execute();
        page13.execute();
        page14.execute();
        page15.execute();
        page16.execute();
        page17.execute();
        page18.execute();
        page19.execute();
        page20.execute();
        page21.execute();
        redirect(System.getenv("https://lgy-iac-web-pr-86.dev.platform.hmcts.net/IACFees/"));
    }
}
