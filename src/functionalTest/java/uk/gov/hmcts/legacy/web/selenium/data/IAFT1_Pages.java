package uk.gov.hmcts.legacy.web.selenium.data;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageEnum;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageFactory;
import uk.gov.hmcts.legacy.web.selenium.iaft.IAFTFlowEnum;
import uk.gov.hmcts.legacy.web.selenium.iaft.iaft1.page.*;
import uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages.*;

public interface IAFT1_Pages {

	public static IaftPageFactory iaftPageFactory = IAFTFlowEnum.IAFT1_FLOW.GetPageFactory();

	public static IaftPage page1 = new WelcomeActions();

	public static IaftPage page2 = new FormOptions();

	public static IaftPage page3 = new NewLodgement();

	public static IaftPage page4 = new AsylumRefusalIAFT1();

	public static IaftPage page5 = new FeePayable();

	public static IaftPage page6 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_ONE);

	public static IaftPage page7 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_TWO);

	public static IaftPage page8 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_THREE);

	public static IaftPage page9 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_FOUR);

	public static IaftPage page10 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_FIVE);

	public static IaftPage page11 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_SIX);

	public static IaftPage page12 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_SEVEN);

	public static IaftPage page13 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_EIGHT);

	public static IaftPage page14 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_NINE);

	public static IaftPage page15 = iaftPageFactory.getPage(IaftPageEnum.IPE_PAGE_TEN);

	public static IaftPage page16 = new SubmissionOptions();

}
