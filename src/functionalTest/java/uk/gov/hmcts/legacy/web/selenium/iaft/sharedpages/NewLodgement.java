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

public class NewLodgement extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(NewLodgement.class);

	public static final String APPEAL_WITHIN_UK_NO_LINK  = "No";

	public static final String APPEAL_WITHIN_UK_YES_LINK  = "Yes";

	public static final String PREVIOUS_LINK  = "previous";

	@Override
	public void execute() {
		logger.info("Executing NewLodgement");
		int fieldLength = fields.length;
		if (fieldLength == 1) {
			String action = fields[0];
			if (action.equals(APPEAL_WITHIN_UK_NO_LINK)|| action.equals(APPEAL_WITHIN_UK_YES_LINK)||action.equals(PREVIOUS_LINK)) {
				findByLinkTextAndClick(action);
			}  else {
				logger.info("Val:" + action + " not understood expected one of:" + APPEAL_WITHIN_UK_NO_LINK + " "
						+ APPEAL_WITHIN_UK_YES_LINK + " " + PREVIOUS_LINK);
			}

		} else {
			logger.info("NewLodgement not initialised with correct number of fields. Expected 1 was "
					+ fieldLength);
		}

	}
}
