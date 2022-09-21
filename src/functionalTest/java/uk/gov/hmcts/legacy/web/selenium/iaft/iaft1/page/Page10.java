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

public class Page10 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page10.class);

	public static final String APPELLANT_DECLARATION_XPATH = "//input[@name='s5_rep_agreed' and @value='Appellant_agreed']";

	public static final String REPRESENTATIVE_DECLARATION_XPATH = "//input[@name='s5_rep_agreed' and @value='Rep_agreed']";

	public static final String REPRESENTATIVE_NAME_NAME = "s5a";

	public static final String REPRESENTATIVE_ORGANISATION_NAME = "s5b";

	public static final String OTHER_NAME = "s5b_other";

	public static final String ADDRESS_LINE1_NAME = "s5c_addr1";

	public static final String ADDRESS_LINE2_NAME = "s5c_addr2";

	public static final String ADDRESS_LINE3_NAME = "s5c_addr3";

	public static final String ADDRESS_LINE4_NAME = "s5c_addr4";

	public static final String POSTCODE_NAME = "s5c_postcode";

	public static final String CORRESPONDENCE_REFERENCE_NAME = "s5d";

	public static final String TELEPHONE_NUMBER_NAME = "s5e";

	public static final String MOBILE_NAME = "s5f";

	public static final String FAX_NAME = "s5g";

	public static final String EMAIL_NAME = "s5h";

	public static final String LEGAL_REFERENCE_NUMBER_NAME = "s5i";

	public static final String AREA_NAME = "s5j";

	public static final String REPRESENTATIVE_NAME = "rep_sign";

	@Override
	public void execute() {
		logger.info("Executing IAFT1 Step 10");
		int fieldLength = fields.length;
		if (fieldLength == 18) {
			String val = fields[0];
			if (null != val) {
				findByNameAndEnterText(REPRESENTATIVE_NAME_NAME, val);
			} else {
				logger.info("Null value not allowed for :" + REPRESENTATIVE_NAME_NAME);
			}

			val = fields[1];
			if (val != null) {
				findSelectByNameAndSelectByValue(REPRESENTATIVE_ORGANISATION_NAME, val);
			} else {
				for (String representative : REPRESENTATIVES) {
					findSelectByNameAndSelectByValue(REPRESENTATIVE_ORGANISATION_NAME, representative);
				}
			}

			val = fields[2];
			if (null != val) {
				findByNameAndEnterText(OTHER_NAME, val);
			}

			val = fields[3];
			if (null != val) {
				findByNameAndEnterText(ADDRESS_LINE1_NAME, val);
			} else {
				logger.info("Null value not allowed for :" + REPRESENTATIVE_NAME_NAME);
			}

			val = fields[4];
			if (null != val) {
				findByNameAndEnterText(ADDRESS_LINE2_NAME, val);
			}

			val = fields[5];
			if (null != val) {
				findByNameAndEnterText(ADDRESS_LINE3_NAME, val);
			}

			val = fields[6];
			if (val != null) {
				findSelectByNameAndSelectByValue(ADDRESS_LINE4_NAME, val);
			} else {
				for (String country : COUNTRIES) {
					findSelectByNameAndSelectByValue(ADDRESS_LINE4_NAME, country);
				}
			}

			val = fields[7];
			if (null != val) {
				findByNameAndEnterText(POSTCODE_NAME, val);
			} else {
				logger.info("Null value not allowed for :" + REPRESENTATIVE_NAME_NAME);
			}

			val = fields[8];
			if (null != val) {
				findByNameAndEnterText(CORRESPONDENCE_REFERENCE_NAME, val);
			}

			val = fields[9];
			if (null != val) {
				findByNameAndEnterText(TELEPHONE_NUMBER_NAME, val);
			}

			val = fields[10];
			if (null != val) {
				findByNameAndEnterText(MOBILE_NAME, val);
			}

			val = fields[11];
			if (null != val) {
				findByNameAndEnterText(FAX_NAME, val);
			}

			val = fields[12];
			if (null != val) {
				findByNameAndEnterText(EMAIL_NAME, val);
			}

			val = fields[13];
			if (null != val) {
				findByNameAndEnterText(LEGAL_REFERENCE_NUMBER_NAME, val);
			}

			val = fields[14];
			if (val != null) {
				findSelectByNameAndSelectByValue(AREA_NAME, val);
			} else {
				for (String area : AREAS) {
					findSelectByNameAndSelectByValue(AREA_NAME, val);
				}
			}

			val = fields[15];
			if (val.equals(APPELLANT_DECLARATION_XPATH)) {
				findByXPathAndClick(APPELLANT_DECLARATION_XPATH);
			} else if (val.equals(REPRESENTATIVE_DECLARATION_XPATH)) {
				findByXPathAndClick(REPRESENTATIVE_DECLARATION_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + APPELLANT_DECLARATION_XPATH + " "
						+ REPRESENTATIVE_DECLARATION_XPATH);
			}

			val = fields[16];
			if (val.equals(REPRESENTATIVE_NAME)) {
				findByNameAndClick(REPRESENTATIVE_NAME);
			} else if (null != val) {
				logger.info("Val:" + val + " not understood expected one of:" + REPRESENTATIVE_NAME);
			}

			val = fields[17];
			if (val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		} else {
			logger.info("Page10 not initialised with correct number of fields. Expected 18 was " + fieldLength);
		}

	}
}
