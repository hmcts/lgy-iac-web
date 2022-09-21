/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.iaft3.page;

import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;

public class AsylumRefusalIAFT3 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(AsylumRefusalIAFT3.class);

	public static final String ASYLUM_REFUSAL_NO_LINK = "No";

	public static final String ASYLUM_REFUSAL_YES_LINK = "Yes";

	public static final String PREVIOUS_LINK = "previous";

	@Override
	public void execute() {
		logger.info("Executing AsylumRefusalIAFT3");
		int fieldLength = fields.length;
		if (fieldLength == 1) {

			String val = fields[0];
			if (val.equals(ASYLUM_REFUSAL_NO_LINK) || val.equals(ASYLUM_REFUSAL_YES_LINK) || val.equals(PREVIOUS_LINK)) {
				findByLinkTextAndClick(val);
			} else {
				System.out.println("Val:" + val + " not understood expected one of:" + ASYLUM_REFUSAL_NO_LINK + " "
						+ ASYLUM_REFUSAL_YES_LINK + " " + PREVIOUS_LINK);
			}
		} else {
			System.out.println("AsylumRefusal Screening not initialised with correct number of fields. Expected 1 was "
					+ fieldLength);
		}

	}
}
