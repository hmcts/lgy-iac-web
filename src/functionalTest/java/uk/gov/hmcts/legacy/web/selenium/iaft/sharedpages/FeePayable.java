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
import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;

public class FeePayable extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(FeePayable.class);

	public static final String FEE_2A_XPATH = "//input[@value='section2a']";

	public static final String FEE_S5_XPATH = "//input[@value='section5']";

	public static final String FEE_S2_XPATH = "//input[@value='schedule2']";

	public static final String FEE_S40_XPATH = "//input[@value='section40']";

	public static final String FEE_S10_XPATH = "//input[@value='section10']";

	public static final String FEE_S76_XPATH = "//input[@value='section76']";

	public static final String FEE_S47_XPATH = "//input[@value='section47']";

	public static final String FEE_R19_XPATH = "//input[@value='regulation19']";

	public static final String FEE_P2_XPATH = "//input[@value='part2']";

	@Override
	public void execute() {
		logger.info("Executing FeePayable");
		int fieldLength = fields.length;
		if (fieldLength == 2) {
			String action = fields[0];
			if (action != null) {
				findByXPathAndClick(action);
			}

			String val = fields[1];
			if (val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
				String source = getPageSource();
				if (source.contains("Where possible, please ensure you have all of the information you need to complete the appeal to hand before making a start.")) {
					logger.info("FeePayable validated");
					clickContinueButton();
				} else {
					logger.info("FeePayable Validation Failed");
				}
			} else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		} else {
			logger.info("FeePayable not initialised with correct number of fields. Expected 2 was "
					+ fieldLength);
		}

	}
}
