/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import org.apache.log4j.Logger;

public class Confirm extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Confirm.class);

	public static final String MAKE_PAYMENT_LINK = "Make payment";

	@Override
	public void execute() {
		logger.info("Executing Confirm Payment Submission");
		int fieldLength = fields.length;
		if (fieldLength == 0) {
			clickNextButton();
		} else {
			logger.info("Confirm not initialised with correct number of fields. Expected 0 was "
					+ fieldLength);
		}

	}

}
