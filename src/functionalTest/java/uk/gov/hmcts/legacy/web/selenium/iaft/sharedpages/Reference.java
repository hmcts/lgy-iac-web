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
import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;

public class Reference extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Reference.class);

	@Override
	public void execute() {
		logger.info("Executing Reference");
		int fieldLength = fields.length;
		if (fieldLength == 1) {
			String val = fields[0];
			if (val.equals(NavigateEnum.CONTINUE.getValue())) {
				clickContinueButton();
			} else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.CONTINUE.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}

		} else {
			logger.info("Reference not initialised with correct number of fields. Expected 1 was "
					+ fieldLength);
		}

	}
}
