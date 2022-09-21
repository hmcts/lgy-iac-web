package uk.gov.hmcts.legacy.web.selenium.iaft.iaft1;

import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageEnum;
import uk.gov.hmcts.legacy.web.selenium.iaft.IaftPageFactory;
import uk.gov.hmcts.legacy.web.selenium.iaft.iaft1.page.*;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;

public class Iaft1PageFactory implements IaftPageFactory {

	@Override
	public IaftPage getPage(IaftPageEnum currentPage) {
		switch(currentPage){
			case IPE_PAGE_ONE: return new Page1();
			case IPE_PAGE_TWO: return new Page2();
			case IPE_PAGE_THREE: return new Page3();
			case IPE_PAGE_FOUR: return new Page4();
			case IPE_PAGE_FIVE: return new Page5();
			case IPE_PAGE_SIX: return new Page6();
			case IPE_PAGE_SEVEN: return new Page7();
			case IPE_PAGE_EIGHT: return new Page8();
			case IPE_PAGE_NINE: return new Page9();
			case IPE_PAGE_TEN: return new Page10();
			default: return null;
		}
	}
}