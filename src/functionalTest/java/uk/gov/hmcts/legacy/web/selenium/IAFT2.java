/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium;

public interface IAFT2 {
	//xpaths

	public static final String DECISION_TYPE_SETTLEMENT_CHECK_XPATH = "//input[@name='s1_tod' and @value='Settlement']";

	public static final String APPEAL_PBS_BASED_NO =  "//input[@name='s2a' and @value='No']";

	//names

	public static final String POST_OFFICE_REF_NAME = "s2b";

	public static final String POST_MAKING_DECISION_NAME = "s2c";

	public static final String SERVICE_DEC_DAY_NAME = "s2e_day";

	public static final String SERVICE_DEC_MONTH_NAME = "s2e_month";

	public static final String SERVICE_DEC_YEAR_NAME = "s2e_year";

	public static final String GROUNDS_FOR_APPEAL_NAME = "s3d_1";

	public static final String NATIONALITY_NAME = "s1g";

	//entry text

	public static final String POST_OFFICE_REF_TEXT = "12345";

	public static final String GROUNDS_FOR_APPEAL_TEXT ="The UK is ace";

	//select values

	public static final String POST_MAKING_DECISION = "355:Victoria";

}
