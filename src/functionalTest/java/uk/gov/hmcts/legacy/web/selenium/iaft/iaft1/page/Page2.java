package uk.gov.hmcts.legacy.web.selenium.iaft.iaft1.page;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;
import uk.gov.hmcts.legacy.web.util.TextGenerator;
import org.apache.log4j.Logger;

public class Page2 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page2.class);

	public static final String GENDER_MALE_XPATH = "//input[@name='s1e' and @value='Male']";

	public static final String GENDER_FEMALE_XPATH = "//input[@name='s1e' and @value='Female']";

	public static final String INTERPRETOR_NEEDED_NO_XPATH = "//input[@name='s1j' and @value='No']";

	public static final String INTERPRETOR_NEEDED_YES_XPATH = "//input[@name='s1j' and @value='Yes']";

	public static final String REMOVAL_DIRECTIONS_SET_NO_XPATH = "//input[@name='s1l' and @value='No']";

	public static final String REMOVAL_DIRECTIONS_SET_YES_XPATH = "//input[@name='s1l' and @value='Yes']";

	public static final String CRIMINAL_SENTENCE_NO_XPATH = "//input[@name='s1o' and @value='No']";

	public static final String CRIMINAL_SENTENCE_YES_XPATH = "//input[@name='s1o' and @value='Yes']";

	public static final String CRIMINAL_A_TYPE_XPATH = "//input[@name='s1q' and @value='AA']";

	public static final String CRIMINAL_B_TYPE_XPATH = "//input[@name='s1q' and @value='BB']";

	public static final String CRIMINAL_C_TYPE_XPATH = "//input[@name='s1q' and @value='CC']";

	public static final String CRIMINAL_D_TYPE_XPATH = "//input[@name='s1q' and @value='DD']";

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

	public static final String PRISON_REFERENCE_NAME = "s1g";

	public static final String NATIONALITY_NAME = "s1h";

	public static final String REPRESENTING_YOURSELF_NAME = "s1i_yourself";

	public static final String REPRESENTING_REPRESENTATIVE_NAME = "s1i_representative";

	public static final String REPRESENTING_WITNESS_NAME = "s1i_witness";

	public static final String INTERPRETOR_WHO_NAME = "s1j_who";

	public static final String INTERPRETOR_LANGUAGE_NAME = "s1j_language";

	public static final String INTERPRETOR_DIALECT_NAME = "s1j_dialect";

	public static final String DISABILITY_REQUIREMENT_NAME = "s1k";

	public static final String HOUR_OF_REMOVAL = "s1m_hour";

	public static final String MINUTE_OF_REMOVAL = "s1m_minutes";

	public static final String MERIDIEM_OF_REMOVAL = "s1m_ampm";

	public static final String REMOVAL_DAY_NAME = "s1n_removal_day";

	public static final String REMOVAL_MONTH_NAME = "s1n_removal_month";

	public static final String REMOVAL_YEAR_NAME = "s1n_removal_year";

	public static final String SENTENCE_DAY_NAME = "s1p_sentence_day";

	public static final String SENTENCE_MONTH_NAME = "s1p_sentence_month";

	public static final String SENTENCE_YEAR_NAME = "s1p_sentence_year";

	@Override
	public void execute() {
		logger.info("Executing IAFT1 Step 2");
		int fieldLength = fields.length;
		if (fieldLength == 35) {
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
				findSelectByNameAndSelectByValue(DOB_DAY_NAME, val);
			} else {
				for (String day : DAYS) {
					findSelectByNameAndSelectByValue(DOB_DAY_NAME, day);
				}
			}

			val = fields[4];
			if (val != null) {
				findSelectByNameAndSelectByValue(DOB_MONTH_NAME, val);
			} else {
				for (String month : MONTHS) {
					findSelectByNameAndSelectByValue(DOB_MONTH_NAME, month);
				}
			}

			val = fields[5];
			if (val != null) {
				findSelectByNameAndSelectByValue(DOB_YEAR_NAME, val);
			} else {
				for (String year : DOB_YEARS) {
					findSelectByNameAndSelectByValue(DOB_YEAR_NAME, year);
				}
			}

			val = fields[6];
			if (val.equals(GENDER_MALE_XPATH)) {
				findByXPathAndClick(GENDER_MALE_XPATH);
			} else if (val.equals(GENDER_FEMALE_XPATH)) {
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
				findByNameAndEnterText(PRISON_REFERENCE_NAME, val);
			}

			val = fields[13];

			if (val != null) {
				findSelectByNameAndSelectByValue(NATIONALITY_NAME, val);
			} else {
				for (String nationality : NATIONALITIES) {
					findSelectByNameAndSelectByValue(NATIONALITY_NAME, nationality);
				}
			}

			val = fields[14];
			if (val.equals(REPRESENTING_YOURSELF_NAME)) {
				findByNameAndClick(REPRESENTING_YOURSELF_NAME);
			}

			val = fields[15];
			if (val.equals(REPRESENTING_REPRESENTATIVE_NAME)) {
				findByNameAndClick(REPRESENTING_REPRESENTATIVE_NAME);
			}

			val = fields[16];
			if (val.equals(REPRESENTING_WITNESS_NAME)) {
				findByNameAndClick(REPRESENTING_WITNESS_NAME);
			}

			val = fields[17];

			if (val.equals(INTERPRETOR_NEEDED_NO_XPATH)) {
				findByXPathAndClick(INTERPRETOR_NEEDED_NO_XPATH);
			} else if (val.equals(INTERPRETOR_NEEDED_YES_XPATH)) {
				findByXPathAndClick(INTERPRETOR_NEEDED_YES_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + INTERPRETOR_NEEDED_NO_XPATH
						+ " " + INTERPRETOR_NEEDED_YES_XPATH);
			}

			val = fields[18];
			if (val != null) {
				findByNameAndEnterText(INTERPRETOR_WHO_NAME, val);
			}

			val = fields[19];
			if (val != null) {
				findByNameAndEnterText(INTERPRETOR_LANGUAGE_NAME, val);
			}

			val = fields[20];
			if (val != null) {
				findByNameAndEnterText(INTERPRETOR_DIALECT_NAME, val);
			}

			val = fields[21];
			if (val != null) {
				findByNameAndEnterText(DISABILITY_REQUIREMENT_NAME, val);
			} else {
				findByNameAndEnterText(DISABILITY_REQUIREMENT_NAME, TextGenerator.getText(500));
			}

			val = fields[22];
			if (val.equals(REMOVAL_DIRECTIONS_SET_NO_XPATH)) {
				findByXPathAndClick(REMOVAL_DIRECTIONS_SET_NO_XPATH);
			} else if (val.equals(REMOVAL_DIRECTIONS_SET_YES_XPATH)) {
				findByXPathAndClick(REMOVAL_DIRECTIONS_SET_YES_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + REMOVAL_DIRECTIONS_SET_NO_XPATH
						+ " " + REMOVAL_DIRECTIONS_SET_YES_XPATH);
			}

			val = fields[23];
			if (val != null) {
				findSelectByNameAndSelectByValue(HOUR_OF_REMOVAL, val);
			} else {
				for (String hour : HOURS) {
					findSelectByNameAndSelectByValue(HOUR_OF_REMOVAL, hour);
				}
			}

			val = fields[24];
			if (val != null) {
				findSelectByNameAndSelectByValue(MINUTE_OF_REMOVAL, val);
			} else {
				for (String minute : MINUTES) {
					findSelectByNameAndSelectByValue(MINUTE_OF_REMOVAL, minute);
				}
			}

			val = fields[25];
			if (val != null) {
				findSelectByNameAndSelectByValue(MERIDIEM_OF_REMOVAL, val);
			} else {
				for (String meridiem : MERIDIEM) {
					findSelectByNameAndSelectByValue(MERIDIEM_OF_REMOVAL, meridiem);
				}
			}

			val = fields[26];
			if (val != null) {
				findSelectByNameAndSelectByValue(REMOVAL_DAY_NAME, val);
			} else {
				for (String day : DAYS) {
					findSelectByNameAndSelectByValue(REMOVAL_DAY_NAME, day);
				}
			}

			val = fields[27];
			if (val != null) {
				findSelectByNameAndSelectByValue(REMOVAL_MONTH_NAME, val);
			} else {
				for (String month : MONTHS) {
					findSelectByNameAndSelectByValue(REMOVAL_MONTH_NAME, month);
				}
			}

			val = fields[28];

			if (val != null) {
				findSelectByNameAndSelectByValue(REMOVAL_YEAR_NAME, val);
			} else {
				for (String year : TWOPLUSMINUS_YEARS) {
					findSelectByNameAndSelectByValue(REMOVAL_YEAR_NAME, year);
				}
			}

			val = fields[29];
			if (val.equals(CRIMINAL_SENTENCE_NO_XPATH)) {
				findByXPathAndClick(CRIMINAL_SENTENCE_NO_XPATH);
			} else if (val.equals(CRIMINAL_SENTENCE_YES_XPATH)) {
				findByXPathAndClick(CRIMINAL_SENTENCE_YES_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + CRIMINAL_SENTENCE_NO_XPATH + " "
						+ CRIMINAL_SENTENCE_YES_XPATH);
			}

			val = fields[30];

			if (val != null) {
				findSelectByNameAndSelectByValue(SENTENCE_DAY_NAME, val);
			} else {
				for (String day : DAYS) {
					findSelectByNameAndSelectByValue(SENTENCE_DAY_NAME, day);
				}
			}

			val = fields[31];
			if (val != null) {
				findSelectByNameAndSelectByValue(SENTENCE_MONTH_NAME, val);
			} else {
				for (String month : MONTHS) {
					findSelectByNameAndSelectByValue(SENTENCE_MONTH_NAME, month);
				}
			}

			val = fields[32];
			if (val != null) {
				findSelectByNameAndSelectByValue(SENTENCE_YEAR_NAME, val);
			} else {
				for (String year : SENTENCE_YEARS) {
					findSelectByNameAndSelectByValue(SENTENCE_YEAR_NAME, year);
				}
			}

			val = fields[33];

			if (val.equals(CRIMINAL_A_TYPE_XPATH)) {
				findByXPathAndClick(CRIMINAL_A_TYPE_XPATH);
			} else if (val.equals(CRIMINAL_B_TYPE_XPATH)) {
				findByXPathAndClick(CRIMINAL_B_TYPE_XPATH);
			} else if (val.equals(CRIMINAL_C_TYPE_XPATH)) {
				findByXPathAndClick(CRIMINAL_C_TYPE_XPATH);
			} else if (val.equals(CRIMINAL_D_TYPE_XPATH)) {
				findByXPathAndClick(CRIMINAL_D_TYPE_XPATH);
			}

			val = fields[34];
			if (val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		} else {
			logger.info("Page 2 not initialised with correct number of fields. Expected 35 was "
					+ fieldLength);
		}
	}

}
