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

public class EcoDecisionAppeal extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(EcoDecisionAppeal.class);

	public static final String ECO_APPEAL_NO_LINK  = "No";

	public static final String ECO_APPEAL_YES_LINK  = "Yes";

	public static final String PREVIOUS_LINK  = "previous";

	@Override
	public void execute() {
		logger.info("Executing EcoDecisionAppeal");
		int fieldLength = fields.length;
		if (fieldLength == 1) {
			String val = fields[0];
			if (val.equals(ECO_APPEAL_NO_LINK)|| val.equals(ECO_APPEAL_YES_LINK)||val.equals(PREVIOUS_LINK)) {
				findByLinkTextAndClick(val);
			}  else {
				logger.info("Val:" + val + " not understood expected one of:" + ECO_APPEAL_NO_LINK + " "
						+ ECO_APPEAL_YES_LINK + " " + PREVIOUS_LINK);
			}
		} else {
			logger.info("ECO Decision Appeal not initialised with correct number of fields. Expected 1 was "
					+ fieldLength);
		}

	}
}
