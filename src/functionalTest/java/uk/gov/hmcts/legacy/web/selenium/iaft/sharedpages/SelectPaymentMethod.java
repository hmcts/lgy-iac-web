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

public class SelectPaymentMethod extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(SelectPaymentMethod.class);

	public static final String SELECT_PAYMENT_METHOD = "/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[3]/input[3]";

	@Override
	public void execute() {
		logger.info("Executing Select Payment Method");
		int fieldLength = fields.length;
		if (fieldLength == 0) {
			findByXPathAndClick(SELECT_PAYMENT_METHOD);
		} else {
			logger.info("SelectPaymentMethod not initialised with correct number of fields. Expected 0 was "
					+ fieldLength);
		}

	}

}
