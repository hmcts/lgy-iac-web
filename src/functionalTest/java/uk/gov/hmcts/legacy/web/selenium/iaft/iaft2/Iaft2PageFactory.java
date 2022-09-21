/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.iaft2;


import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageEnum;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageFactory;
import uk.gov.hmcts.legacy.web.selenium.iaft.iaft2.page.*;

public class Iaft2PageFactory implements IaftPageFactory {

	@Override
	public IaftPage getPage(IaftPageEnum currentPage) {
		switch (currentPage) {
		case IPE_PAGE_ONE:
			return new Page1();
		case IPE_PAGE_TWO:
			return new Page2();
		case IPE_PAGE_THREE:
			return new Page3();
		case IPE_PAGE_FOUR:
			return new Page4();
		case IPE_PAGE_FIVE:
			return new Page5();
		case IPE_PAGE_SIX:
			return new Page6();
		case IPE_PAGE_SEVEN:
			return new Page7();
		case IPE_PAGE_EIGHT:
			return new Page8();
		default:
			return null;
		}
	}

}
