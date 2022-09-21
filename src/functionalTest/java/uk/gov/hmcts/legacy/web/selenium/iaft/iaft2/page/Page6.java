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

public class Page6 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page6.class);

	public static final String REPRESENTATIVE_NO_XPATH = "//input[@name='have_rep' and @value='No']";

	public static final String REPRESENTATIVE_YES_XPATH = "//input[@name='have_rep' and @value='Yes']";

	public static final String SPONSOR_NO_XPATH = "//input[@name='have_sponsor' and @value='No']";

	public static final String SPONSOR_YES_XPATH = "//input[@name='have_sponsor' and @value='Yes']";

	public static final String DIGITAL_SIGNATURE = "s4_decalaration";

	@Override
	public void execute() {
		logger.info("Executing IAFT2 Step 6");
		int fieldLength = fields.length;
		if (fieldLength == 4) {

			String val = fields[0];
			if (null != val && val.equals(REPRESENTATIVE_NO_XPATH)) {
				findByXPathAndClick(REPRESENTATIVE_NO_XPATH);
			} else if (null != val && val.equals(REPRESENTATIVE_YES_XPATH)) {
				findByXPathAndClick(REPRESENTATIVE_YES_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + REPRESENTATIVE_NO_XPATH + " "
						+ REPRESENTATIVE_YES_XPATH);
			}

			val = fields[1];
			if (null != val && val.equals(SPONSOR_NO_XPATH)) {
				findByXPathAndClick(SPONSOR_NO_XPATH);
			} else if (null != val && val.equals(SPONSOR_YES_XPATH)) {
				findByXPathAndClick(SPONSOR_YES_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + SPONSOR_NO_XPATH + " "
						+ SPONSOR_YES_XPATH);
			}

			val = fields[2];
			if (null != val && val.equals(DIGITAL_SIGNATURE)) {
				findByNameAndClick(DIGITAL_SIGNATURE);
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

		} else {
			logger.info("Page 6 not initialised with correct number of fields. Expected 4 was "
					+ fieldLength);
		}

	}

}
