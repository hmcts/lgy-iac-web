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

public class Page5 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page5.class);

	public static final String COUNTRY_SITUATION_TEXT_NAME = "s3d_1";

	public static final String NOT_SAFE_TEXT_NAME = "s3d_2";

	public static final String NOT_CREDIBLE_TEXT_NAME = "s3d_3";

	@Override
	public void execute() {
		logger.info("Executing IAFT3 Step 5");
		int fieldLength = fields.length;
		if (fieldLength == 4) {

			String val = fields[0];
			if (null != val) {
				findByNameAndEnterText(COUNTRY_SITUATION_TEXT_NAME, val);
			} else {
				findByNameAndEnterText(COUNTRY_SITUATION_TEXT_NAME, TextGenerator.getText(8000));
			}

			val = fields[1];
			if (null != val) {
				findByNameAndEnterText(NOT_SAFE_TEXT_NAME, val);
			} else {
				findByNameAndEnterText(NOT_SAFE_TEXT_NAME, TextGenerator.getText(8000));
			}

			val = fields[2];
			if (null != val) {
				findByNameAndEnterText(NOT_CREDIBLE_TEXT_NAME, val);
			} else {
				findByNameAndEnterText(NOT_CREDIBLE_TEXT_NAME, TextGenerator.getText(8000));
			}

			val = fields[3];
			if (val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}

		} else {
			logger.info("Page5 not initialised with correct number of fields. Expected 4 was "
					+ fieldLength);
		}

	}

}
