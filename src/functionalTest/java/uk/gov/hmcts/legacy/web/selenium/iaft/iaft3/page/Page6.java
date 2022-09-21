/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.iaft3.page;

import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;
import uk.gov.hmcts.legacy.web.util.TextGenerator;
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;

public class Page6 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page6.class);

	public static final String GENEVA_QUALIFY_TEXT_NAME = "s3d_4";

	public static final String EHR_QUALIFY_TEXT_NAME = "s3d_5";

	public static final String REGS2006_QUALIFY_TEXT_NAME = "s3d_6";

	public static final String DISAGREE_QUALIFY_TEXT_NAME = "s3d_7";

	@Override
	public void execute() {
		logger.info("Executing IAFT3 Step 6");
		int fieldLength = fields.length;
		if (fieldLength == 5) {

			String val = fields[0];
			if (null != val) {
				findByNameAndEnterText(GENEVA_QUALIFY_TEXT_NAME, val);
			} else {
				findByNameAndEnterText(GENEVA_QUALIFY_TEXT_NAME, TextGenerator.getText(1000));
			}

			val = fields[1];
			if (null != val) {
				findByNameAndEnterText(EHR_QUALIFY_TEXT_NAME, val);
			} else {
				findByNameAndEnterText(EHR_QUALIFY_TEXT_NAME, TextGenerator.getText(1000));
			}

			val = fields[2];
			if (null != val) {
				findByNameAndEnterText(REGS2006_QUALIFY_TEXT_NAME, val);
			} else {
				findByNameAndEnterText(REGS2006_QUALIFY_TEXT_NAME, TextGenerator.getText(1000));
			}

			val = fields[3];
			if (null != val) {
				findByNameAndEnterText(DISAGREE_QUALIFY_TEXT_NAME, val);
			} else {
				findByNameAndEnterText(DISAGREE_QUALIFY_TEXT_NAME, TextGenerator.getText(1000));
			}

			val = fields[4];
			if (val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		} else {
			logger.info("Page6 not initialised with correct number of fields. Expected 5 was "
					+ fieldLength);
		}

	}

}
