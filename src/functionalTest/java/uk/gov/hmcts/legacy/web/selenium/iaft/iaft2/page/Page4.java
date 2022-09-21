/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.iaft2.page;

import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import uk.gov.hmcts.legacy.web.util.TextGenerator;

public class Page4 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page4.class);

	public static final String LATE_APPEAL_REASON_NAME = "s3a";

	public static final String ADDITIONALDOCS_REASON_NAME = "s3b";

	public static final String FUTUREDOCS_REASON_NAME = "s3c";

	@Override
	public void execute() {
		logger.info("Executing IAFT2 Step 4");
		int fieldLength = fields.length;
		if (fieldLength == 4) {

			String val = fields[0];
			if (null != val) {
				if(!val.equals("NA"))
				findByNameAndEnterText(LATE_APPEAL_REASON_NAME, val);
			} else {
				findByNameAndEnterText(LATE_APPEAL_REASON_NAME, TextGenerator.getText(1000));
			}

			val = fields[1];
			if (null != val) {
				if(!val.equals("NA"))
				findByNameAndEnterText(ADDITIONALDOCS_REASON_NAME, val);
			} else {
				findByNameAndEnterText(ADDITIONALDOCS_REASON_NAME, TextGenerator.getText(1000));
			}

			val = fields[2];
			if (null != val) {
				if(!val.equals("NA"))
				findByNameAndEnterText(FUTUREDOCS_REASON_NAME, val);
			} else {
				findByNameAndEnterText(FUTUREDOCS_REASON_NAME, TextGenerator.getText(1000));
			}

			val = fields[3];
			if (null != val && val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (null != val && val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		}

	}

}
