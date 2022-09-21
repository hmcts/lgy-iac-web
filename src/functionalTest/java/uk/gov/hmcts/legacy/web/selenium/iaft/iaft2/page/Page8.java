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

public class Page8 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page8.class);

	public static final String REPRESENTATIVE_DECLARATION_NO_XPATH = "//input[@name='s6_auth' and @value='No']";

	public static final String REPRESENTATIVE_DECLARATION_YES_XPATH = "//input[@name='s6_auth' and @value='Yes']";

	public static final String FAMILY_SURNAME_NAME = "s6a";

	public static final String FIRST_NAME_NAME = "s6b";

	public static final String TITLE_NAME = "s6c";

	public static final String ADDRESS_LINE1_NAME = "s6d_addr1";

	public static final String ADDRESS_LINE2_NAME = "s6d_addr2";

	public static final String ADDRESS_LINE3_NAME = "s6d_addr3";

	public static final String ADDRESS_COUNTRY_NAME = "s6d_addr4";

	public static final String POSTCODE_NAME = "s6d_postcode";

	public static final String TELEPHONE_NUMBER_NAME = "s6e";

	public static final String EMAIL_NAME = "s6f";

	public static final String REPRESENTATIVE_NAME = "rep_sign";

	@Override
	public void execute() {
		logger.info("Executing IAFT2 Step 8");
		int fieldLength = fields.length;
		if (fieldLength == 12) {

			String val = fields[0];
			if (null != val) {
				findByNameAndEnterText(FAMILY_SURNAME_NAME, val);
			}

			val = fields[1];
			if (null != val) {
				findByNameAndEnterText(FIRST_NAME_NAME, val);
			}

			val = fields[2];
			if (null != val) {
				findByNameAndEnterText(TITLE_NAME, val);
			}

			val = fields[3];
			if (val != null) {
				findByNameAndEnterText(ADDRESS_LINE1_NAME, val);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + ADDRESS_LINE1_NAME);
			}

			val = fields[4];
			if (val != null) {
				findByNameAndEnterText(ADDRESS_LINE2_NAME, val);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + ADDRESS_LINE2_NAME);
			}

			val = fields[5];
			if (val != null) {
				findByNameAndEnterText(ADDRESS_LINE3_NAME, val);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + ADDRESS_LINE3_NAME);
			}

			val = fields[6];
			if (val != null) {
				if(!val.equals("NA"))
				findSelectByNameAndSelectByValue(ADDRESS_COUNTRY_NAME, val);
			} else {
				for (String country : COUNTRIES) {
					findSelectByNameAndSelectByValue(ADDRESS_COUNTRY_NAME, country);
				}
			}

			val = fields[7];
			if (val != null) {
				findByNameAndEnterText(POSTCODE_NAME, val);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + POSTCODE_NAME);

			}

			val = fields[8];
			if (null != val) {
				findByNameAndEnterText(TELEPHONE_NUMBER_NAME, val);
			}

			val = fields[9];
			if (null != val) {
				findByNameAndEnterText(EMAIL_NAME, val);
			}

			val = fields[10];
			if (null != val && val.equals(REPRESENTATIVE_DECLARATION_YES_XPATH) || null != val && val.equals(REPRESENTATIVE_DECLARATION_NO_XPATH)) {
				findByXPathAndClick(val);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + REPRESENTATIVE_DECLARATION_YES_XPATH + " "
						+ REPRESENTATIVE_DECLARATION_NO_XPATH);
			}

			val = fields[11];
			if (null != val && val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (null != val && val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		} else {
			logger.info("Page 8 not initialised with correct number of fields. Expected 12 was "
					+ fieldLength);
		}

	}

}
