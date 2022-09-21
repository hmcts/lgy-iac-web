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

public class LeftUKAppeal extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(LeftUKAppeal.class);

	public static final String DECISION_APPEAL_OUTSIDE_UK_NO_LINK = "No";

	public static final String DECISION_APPEAL_OUTSIDE_UK_YES_LINK = "Yes";

	@Override
	public void execute() {
		logger.info("Executing LeftUKAppeal");
		int fieldLength = fields.length;
		if (fieldLength == 1) {
			String val = fields[0];

			if (val.equals(DECISION_APPEAL_OUTSIDE_UK_YES_LINK ) || val.equals(DECISION_APPEAL_OUTSIDE_UK_NO_LINK)) {
				findByLinkTextAndClick(val);
			} else if (null != val) {
				logger.info("Val:" + val + " not understood expected one of:" + DECISION_APPEAL_OUTSIDE_UK_NO_LINK + " "
						+ DECISION_APPEAL_OUTSIDE_UK_YES_LINK );
			}
		} else {
			logger.info("Appeal within/without not initialised with correct number of fields. Expected 1 was "
					+ fieldLength);
		}
	}

}
