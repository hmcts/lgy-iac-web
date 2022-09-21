/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.data;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageEnum;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageFactory;
import uk.gov.hmcts.legacy.web.selenium.iaft.IAFTFlowEnum;
import uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages.*;

public interface IAFT2_Pages {

	public static IaftPageFactory pageFac = IAFTFlowEnum.IAFT2_FLOW.GetPageFactory();

	public static IaftPage page1 = new WelcomeActions();

	public static IaftPage page2 = new FormOptions();

	public static IaftPage page3 = new NewLodgement();

	public static IaftPage page4 = new EcoDecisionAppeal();

	public static IaftPage page5 = new Reference();

	public static IaftPage page6 = pageFac.getPage(IaftPageEnum.IPE_PAGE_ONE);

	public static IaftPage page7 = pageFac.getPage(IaftPageEnum.IPE_PAGE_TWO);

	public static IaftPage page8 = pageFac.getPage(IaftPageEnum.IPE_PAGE_THREE);

	public static IaftPage page9 = pageFac.getPage(IaftPageEnum.IPE_PAGE_FOUR);

	public static IaftPage page10 = pageFac.getPage(IaftPageEnum.IPE_PAGE_FIVE);

	public static IaftPage page11 = pageFac.getPage(IaftPageEnum.IPE_PAGE_SIX);

	public static IaftPage page12= pageFac.getPage(IaftPageEnum.IPE_PAGE_SEVEN);

	public static IaftPage page13 = pageFac.getPage(IaftPageEnum.IPE_PAGE_EIGHT);

	public static IaftPage page14 = new SubmissionOptions();

	public static IaftPage page15 = new Confirm();

	public static IaftPage page16 = new SelectPaymentMethod();

	public static IaftPage page17 = new MakeTestPayment();

}
