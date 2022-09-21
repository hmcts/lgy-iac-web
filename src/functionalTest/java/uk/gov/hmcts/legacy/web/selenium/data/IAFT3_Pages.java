/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.data;

import uk.gov.hmcts.legacy.web.selenium.iaft.iaft3.page.*;
import uk.gov.hmcts.legacy.web.selenium.iaft.IAFTFlowEnum;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageEnum;
//import uk.gov.hmcts.legacy.web.selenium.iaft.iaft3.page.AsylumRefusalIAFT3;
import uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages.*;
import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageFactory;

public interface IAFT3_Pages {

	public static IaftPageFactory pageFac = IAFTFlowEnum.IAFT3_FLOW.GetPageFactory();

	public static IaftPage page1 = new WelcomeActions();

	public static IaftPage page2 = new FormOptions();

	public static IaftPage page3 = new NewLodgement();

	public static IaftPage page4 = new EcoDecisionAppeal();

	public static IaftPage page5 = new LeftUKAppeal();

	public static IaftPage page6 = new AsylumRefusalIAFT3();

	public static IaftPage page7 = new Reference();

	public static IaftPage page8 = pageFac.getPage(IaftPageEnum.IPE_PAGE_ONE);

	public static IaftPage page9 = pageFac.getPage(IaftPageEnum.IPE_PAGE_TWO);

	public static IaftPage page10 = pageFac.getPage(IaftPageEnum.IPE_PAGE_THREE);

	public static IaftPage page11 = pageFac.getPage(IaftPageEnum.IPE_PAGE_FOUR);

	public static IaftPage page12 = pageFac.getPage(IaftPageEnum.IPE_PAGE_FIVE);

	public static IaftPage page13 = pageFac.getPage(IaftPageEnum.IPE_PAGE_SIX);

	public static IaftPage page14= pageFac.getPage(IaftPageEnum.IPE_PAGE_SEVEN);

	public static IaftPage page15 = pageFac.getPage(IaftPageEnum.IPE_PAGE_EIGHT);

	public static IaftPage page16 = pageFac.getPage(IaftPageEnum.IPE_PAGE_NINE);

	public static IaftPage page17 = pageFac.getPage(IaftPageEnum.IPE_PAGE_TEN);

	public static IaftPage page18 = new SubmissionOptions();

	public static IaftPage page19 = new Confirm();

	public static IaftPage page20 = new SelectPaymentMethod();

	public static IaftPage page21 = new MakeTestPayment();


}
