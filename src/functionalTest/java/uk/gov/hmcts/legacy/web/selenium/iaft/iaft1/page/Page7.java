/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.iaft1.page;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;
import uk.gov.hmcts.legacy.web.util.TextGenerator;
import org.apache.log4j.Logger;

public class Page7 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page7.class);

	public static final String NON_ASYLUM_TEXT_DISAGREE = "s3d_8";

	public static final String ADDITIONAL_NON_ASYLUM_TEXT_DISAGREE = "s3d_additional";

	@Override
	public void execute() {
		logger.info("Executing IAFT1 Step 7");
		int fieldLength = fields.length;
		if (fieldLength == 3) {

			String val = fields[0];
			if (null != val) {
				findByNameAndEnterText(NON_ASYLUM_TEXT_DISAGREE  , val);
			} else {
				findByNameAndEnterText(NON_ASYLUM_TEXT_DISAGREE  , TextGenerator.getText(1000));
			}

			val = fields[1];
			if (null != val) {
				findByNameAndEnterText(ADDITIONAL_NON_ASYLUM_TEXT_DISAGREE , val);
			} else {
				findByNameAndEnterText(ADDITIONAL_NON_ASYLUM_TEXT_DISAGREE , TextGenerator.getText(1000));
			}

			val = fields[2];
			if (val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		} else {
			logger.info("Page6 not initialised with correct number of fields. Expected 3 was "
					+ fieldLength);
		}

	}

}
