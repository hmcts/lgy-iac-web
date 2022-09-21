package uk.gov.hmcts.legacy.web.selenium;

import org.springframework.beans.factory.annotation.Value;
import uk.gov.hmcts.legacy.web.selenium.data.IAFT1_Flows;
import uk.gov.hmcts.legacy.web.selenium.data.IAFT1_Pages;
import uk.gov.hmcts.legacy.web.util.DataLoader;
import uk.gov.hmcts.legacy.web.util.ModifyXmlFile;
import org.apache.log4j.Logger;

public class IAFT1_Tests extends BaseTest implements IAFT1_Flows, IAFT1_Pages, ExpectedResults{

	static Logger logger = Logger.getLogger(IAFT1_Tests.class);
    @Value("${test-url}")
    private static String testUrl;

	public static void loadScenarios_IAFT1() {
		page1.initialise(welcomeActionsSubmitAppeal);
		page2.initialise(formOptions);
		page3.initialise(lodgementOptions);
		page4.initialise(asylumOptions);
		page5.initialise(feeOptions);
		page6.initialise(quick_stage1Options);
		page7.initialise(quick_stage2Options);
		page8.initialise(quick_stage3Options);
		page9.initialise(quick_stage4Options);
		page10.initialise(quick_stage5Options);
		page11.initialise(quick_stage6Options);
		page12.initialise(quick_stage7Options);
		page13.initialise(quick_stage8Options);
		page14.initialise(quick_stage9Options);
		page15.initialise(quick_stage10Options);
		page16.initialise(remission_FinaliseOptions);
	}

	public static void runPages() {
//		ModifyXmlFile.incrementURNId("partial.xml");
//		DataLoader.load("partial.xml");
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
//		redirect(System.getenv(testUrl));
        redirect(System.getenv("https://lgy-iac-web-pr-86.dev.platform.hmcts.net/IACFees/"));
	}


}
