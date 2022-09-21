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

public class IsAsylum extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(IsAsylum.class);

	public static final String FEE_S40_XPATH = "/html/body/div/div/div[2]/div/div/div[2]/div/form/div[1]/p[5]/input";

	public static final String FEE_R338A_XPATH = "/html/body/div/div/div[2]/div/div/div[2]/div/form/div[1]/p[6]/input";

	public static final String FEE_R23_XPATH = "/html/body/div/div/div[2]/div/div/div[2]/div/form/div[1]/p[7]/input";

	public static final String FEE_NONE_XPATH = "/html/body/div/div/div[2]/div/div/div[2]/div/form/div[1]/p[8]/input";


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
