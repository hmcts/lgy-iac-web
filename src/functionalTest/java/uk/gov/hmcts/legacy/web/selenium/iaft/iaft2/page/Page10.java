/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.iaft2.page;

import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;

public class Page10 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page10.class);

	@Override
	public void execute() {
		logger.info("Executing IAFT2 Step 10");
		int fieldLength = fields.length;
		if (fieldLength == 0) {

		} else {
			logger.info("ConfirmRepayment not initialised with correct number of fields. Expected 1 was "
					+ fieldLength);
		}

	}

}
