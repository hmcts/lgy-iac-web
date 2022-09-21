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

public class Page2 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page2.class);

	public static final String GENDER_MALE_XPATH = "//input[@name='s1e' and @value='Male']";

	public static final String GENDER_FEMALE_XPATH = "//input[@name='s1e' and @value='Female']";

	public static final String FAMILY_SURNAME_NAME = "s1a";

	public static final String FIRST_NAME_NAME = "s1b";

	public static final String TITLE_NAME = "s1c";

	public static final String DOB_DAY_NAME = "s1d_dob_day";

	public static final String DOB_MONTH_NAME = "s1d_dob_month";

	public static final String DOB_YEAR_NAME = "s1d_dob_year";

	public static final String ADDRESS_LINE1_NAME = "s1f_addr1";

	public static final String ADDRESS_LINE2_NAME = "s1f_addr2";

	public static final String ADDRESS_LINE3_NAME = "s1f_addr3";

	public static final String ADDRESS_COUNTRY_NAME = "s1f_addr4";

	public static final String POSTCODE_NAME = "s1f_postcode";

	public static final String NATIONALITY_NAME = "s1g";

	@Override
	public void execute() {
		logger.info("Executing IAFT2 Step 2");
		int fieldLength = fields.length;
		if (fieldLength == 14) {

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
				if(!val.equals("NA"))
				findSelectByNameAndSelectByValue(DOB_DAY_NAME, val);
			} else {
				for (String day : DAYS) {
					findSelectByNameAndSelectByValue(DOB_DAY_NAME, day);
				}
			}

			val = fields[4];
			if (val != null) {
				if(!val.equals("NA"))
				findSelectByNameAndSelectByValue(DOB_MONTH_NAME, val);
			} else {
				for (String month : MONTHS) {
					findSelectByNameAndSelectByValue(DOB_MONTH_NAME, month);
				}
			}

			val = fields[5];
			if (val != null) {
				if(!val.equals("NA"))
				findSelectByNameAndSelectByValue(DOB_YEAR_NAME, val);
			} else {
				for (String year : DOB_YEARS) {
					findSelectByNameAndSelectByValue(DOB_YEAR_NAME, year);
				}
			}

			val = fields[6];
			if (null != val && val.equals(GENDER_MALE_XPATH)) {
				findByXPathAndClick(GENDER_MALE_XPATH);
			} else if (null != val && val.equals(GENDER_FEMALE_XPATH)) {
				findByXPathAndClick(GENDER_FEMALE_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + GENDER_MALE_XPATH + " "
						+ GENDER_FEMALE_XPATH);
			}

			val = fields[7];
			if (val != null) {
				findByNameAndEnterText(ADDRESS_LINE1_NAME, val);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + ADDRESS_LINE1_NAME);
			}

			val = fields[8];
			if (val != null) {
				findByNameAndEnterText(ADDRESS_LINE2_NAME, val);
			}

			val = fields[9];
			if (val != null) {
				findByNameAndEnterText(ADDRESS_LINE3_NAME, val);
			}

			val = fields[10];
			if (val != null) {
				if(!val.equals("NA"))
				findSelectByNameAndSelectByValue(ADDRESS_COUNTRY_NAME, val);
			} else {
				for (String country : COUNTRIES) {
					findSelectByNameAndSelectByValue(ADDRESS_COUNTRY_NAME, country);
				}
			}

			val = fields[11];
			if (val != null) {
				findByNameAndEnterText(POSTCODE_NAME, val);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + POSTCODE_NAME);

			}

			val = fields[12];

			if (val != null) {
				if(!val.equals("NA"))
				findSelectByNameAndSelectByValue(NATIONALITY_NAME, val);
			} else {
				for (String nationality : NATIONALITIES) {
					findSelectByNameAndSelectByValue(NATIONALITY_NAME, nationality);
				}
			}

			val = fields[13];
			if (null != val && val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (null != val && val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		} else {
			logger.info("Page2 not initialised with correct number of fields. Expected 14 was "
					+ fieldLength);
		}

	}

}
