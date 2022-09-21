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
import org.apache.log4j.Logger;
import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;

public class Page3 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page3.class);

	public static final String SERVICE_DECSION_METHOD_POST_XPATH = "//input[@name='s2d' and @value='Post']";

	public static final String SERVICE_DECSION_METHOD_FAX_XPATH = "//input[@name='s2d' and @value='Fax']";

	public static final String SERVICE_DECSION_METHOD_COURIER_XPATH = "//input[@name='s2d' and @value='Courier']";

	public static final String SERVICE_DECSION_METHOD_OTHER_XPATH = "//input[@name='s2d' and @value='Other']";

	public static final String HOME_OFFICE_REFERENCE_NAME = "s2a";

	public static final String PORT_REFERENCE_NAME = "s2b";

	public static final String COHID_REFERENCE_NAME = "s2c";

	public static final String SPECIFY_OTHER_NAME = "s2d_other";

	public static final String REFUSAL_DAY_NAME = "s2e_service_day";

	public static final String REFUSAL_MONTH_NAME = "s2e_service_month";

	public static final String REFUSAL_YEAR_NAME = "s2e_service_year";

	public static final String SERVICE_DAY_NAME = "s2i_service_day";

	public static final String SERVICE_MONTH_NAME = "s2i_service_month";

	public static final String SERVICE_YEAR_NAME = "s2i_service_year";

	@Override
	public void execute() {
		logger.info("Executing IAFT1 Step 3");
		int fieldLength = fields.length;
		if (fieldLength == 12) {
			String val = fields[0];
			if (null != val) {
				findByNameAndEnterText(HOME_OFFICE_REFERENCE_NAME, val);
			} else {
				logger.info("Null value not allowed");
			}

			val = fields[1];
			if (null != val) {
				findByNameAndEnterText(PORT_REFERENCE_NAME, val);
			}

			val = fields[2];
			if (null != val) {
				findByNameAndEnterText(COHID_REFERENCE_NAME, val);
			}

			val = fields[3];
			if (val.equals(SERVICE_DECSION_METHOD_POST_XPATH)) {
				findByXPathAndClick(SERVICE_DECSION_METHOD_POST_XPATH);
			} else if (val.equals(SERVICE_DECSION_METHOD_FAX_XPATH)) {
				findByXPathAndClick(SERVICE_DECSION_METHOD_FAX_XPATH);
			} else if (val.equals(SERVICE_DECSION_METHOD_COURIER_XPATH)) {
				findByXPathAndClick(SERVICE_DECSION_METHOD_COURIER_XPATH);
			} else if (val.equals(SERVICE_DECSION_METHOD_OTHER_XPATH)) {
				findByXPathAndClick(SERVICE_DECSION_METHOD_OTHER_XPATH);
			}

			val = fields[4];
			if (null != val) {
				findByNameAndEnterText(SPECIFY_OTHER_NAME, val);
			}

			val = fields[5];
			if (val != null) {
				findSelectByNameAndSelectByValue(REFUSAL_DAY_NAME, val);
			} else {
				for (String day : DAYS) {
					findSelectByNameAndSelectByValue(REFUSAL_DAY_NAME, day);
				}
			}

			val = fields[6];
			if (val != null) {
				findSelectByNameAndSelectByValue(REFUSAL_MONTH_NAME, val);
			} else {
				for (String month : MONTHS) {
					findSelectByNameAndSelectByValue(REFUSAL_MONTH_NAME, month);
				}
			}

			val = fields[7];
			if (val != null) {
				findSelectByNameAndSelectByValue(REFUSAL_YEAR_NAME, val);
			} else {
				for (String year : TWOMINUS_YEARS) {
					findSelectByNameAndSelectByValue(REFUSAL_YEAR_NAME, year);
				}
			}

			val = fields[8];
			if (val != null) {
				findSelectByNameAndSelectByValue(SERVICE_DAY_NAME, val);
			} else {
				for (String day : DAYS) {
					findSelectByNameAndSelectByValue(SERVICE_DAY_NAME, day);
				}
			}

			val = fields[9];
			if (val != null) {
				findSelectByNameAndSelectByValue(SERVICE_MONTH_NAME, val);
			} else {
				for (String month : MONTHS) {
					findSelectByNameAndSelectByValue(SERVICE_MONTH_NAME, month);
				}
			}

			val = fields[10];
			if (val != null) {
				findSelectByNameAndSelectByValue(SERVICE_YEAR_NAME, val);
			} else {
				for (String year : TWOMINUS_YEARS) {
					findSelectByNameAndSelectByValue(SERVICE_YEAR_NAME, year);
				}
			}

			val = fields[11];
			if (val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		} else {
			logger.info("Page 3 not initialised with correct number of fields. Expected 12 was " + fieldLength);

		}
	}

}
