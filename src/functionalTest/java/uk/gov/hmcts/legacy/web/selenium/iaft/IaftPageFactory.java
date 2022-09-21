package uk.gov.hmcts.legacy.web.selenium.iaft;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;

public interface IaftPageFactory {

	/**
     * Gets the page.
     *
     * @param currentPage the current page
     * @return the page
     */
	public IaftPage getPage(IaftPageEnum currentPage);
}
