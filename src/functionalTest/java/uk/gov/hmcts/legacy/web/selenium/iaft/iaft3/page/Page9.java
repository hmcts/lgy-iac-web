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
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;

public class Page9 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page9.class);

	public static final String REPRESENTATIVE_NO_XPATH = "//input[@name='have_rep' and @value='No']";

	public static final String REPRESENTATIVE_YES_XPATH = "//input[@name='have_rep' and @value='Yes']";

	public static final String DIGITAL_SIGNATURE = "s4_decalaration";

	@Override
	public void execute() {
		logger.info("Executing IAFT3 Step 9");
		int fieldLength = fields.length;
		if (fieldLength == 3) {

			String val = fields[0];
			if (val.equals(REPRESENTATIVE_NO_XPATH)) {
				findByXPathAndClick(REPRESENTATIVE_NO_XPATH);
			} else if (val.equals(REPRESENTATIVE_YES_XPATH)) {
				findByXPathAndClick(REPRESENTATIVE_YES_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + REPRESENTATIVE_NO_XPATH + " "
						+ REPRESENTATIVE_YES_XPATH);
			}

			val = fields[1];
			if (val.equals(DIGITAL_SIGNATURE)) {
				findByNameAndClick(DIGITAL_SIGNATURE);
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
			logger.info("Page9 not initialised with correct number of fields. Expected 3 was "
					+ fieldLength);
		}

	}

}
