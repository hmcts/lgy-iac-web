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

public class Page1 extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(Page1.class);

	public static final String ORAL_CHECK_XPATH = "//input[@value='Oral']";

	public static final String PAPER_CHECK_XPATH = "//input[@value='Paper']";

	public static final String NO_FUNDING_XPATH = "//input[@name='qb_lsc' and @value='No']";

	public static final String LEGAL_AID_FUNDING_XPATH = "//input[@name='qb_lsc' and @value='Yes']";

	public static final String ASYLUM_SUPPORT_FUNDING_XPATH = "//input[@name='qb_lsc' and @value='Asylum Support']";

	public static final String CHILDRENS_ACT_SUPPORT_S17_XPATH = "//input[@name='qb_lsc' and @value='Section 17']";

	public static final String FAMILY_MEMBER_YES_XPATH = "//input[@name='family_member' and @value='Yes']";

	public static final String FAMILY_MEMBER_NO_XPATH = "//input[@name='family_member' and @value='No']";

	public static final String TYPE_SETTLEMENT_XPATH = "//input[@name='s1_tod' and @value='Settlement']";

	public static final String TYPE_NON_SETTLEMENT_XPATH = "//input[@name='s1_tod' and @value='Non Settlement']";

	public static final String TYPE_FAMILY_VISIT_XPATH = "//input[@name='family_member' and @value='Family Visit']";

	public static final String SPONSOR_NAME = "qa_sponsor";

	public static final String REPRESENTATIVE_NAME = "qa_rep";

	public static final String WITNESS_NAME = "qa_witness";
	public static final String LEGAL_AID_REF_NAME = "qb_LAR";

	public static final String FAMILY_NAME_1 = "name1";

	public static final String FAMILY_NAME_2 = "name2";

	public static final String FAMILY_NAME_3 = "name3";

	public static final String FAMILY_NAME_4 = "name4";

	public static final String FAMILY_RELATIONSHIP_1 = "relationship1";

	public static final String FAMILY_RELATIONSHIP_2 = "relationship2";

	public static final String FAMILY_RELATIONSHIP_3 = "relationship3";

	public static final String FAMILY_RELATIONSHIP_4 = "relationship4";

	public static final String FAMILY_MEMEBER_REF_1 = "prn1";

	public static final String FAMILY_MEMEBER_REF_2 = "prn2";

	public static final String FAMILY_MEMEBER_REF_3 = "prn3";

	public static final String FAMILY_MEMEBER_REF_4 = "prn4";

	@Override
	public void execute() {
		logger.info("Executing IAFT2 Step 1");
		int fieldLength = fields.length;
		if (fieldLength == 21) {

			String val = fields[0];
			if (val.equals(ORAL_CHECK_XPATH)) {
				findByXPathAndClick(ORAL_CHECK_XPATH);
			} else if (val.equals(PAPER_CHECK_XPATH)) {
				findByXPathAndClick(PAPER_CHECK_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + ORAL_CHECK_XPATH + " "
						+ PAPER_CHECK_XPATH);
			}

			val = fields[1];
			if (null != val && val.equals(SPONSOR_NAME)) {
				findByNameAndClick(SPONSOR_NAME);
			}

			val = fields[2];
			if (null != val && val.equals(REPRESENTATIVE_NAME)) {
				findByNameAndClick(REPRESENTATIVE_NAME);
			}

			val = fields[3];
			if (null != val && val.equals(WITNESS_NAME)) {
				findByNameAndClick(WITNESS_NAME);
			} else if (null != val) {
				logger.info("Val:" + val + " not understood expected one of:" + WITNESS_NAME);
			}

			val = fields[4];
			if (null != val && val.equals(NO_FUNDING_XPATH)) {
				findByXPathAndClick(NO_FUNDING_XPATH);
			} else if (val.equals(LEGAL_AID_FUNDING_XPATH)) {
				findByXPathAndClick(LEGAL_AID_FUNDING_XPATH);
			} else if (val.equals(ASYLUM_SUPPORT_FUNDING_XPATH)) {
				findByXPathAndClick(ASYLUM_SUPPORT_FUNDING_XPATH);
			} else if (val.equals(CHILDRENS_ACT_SUPPORT_S17_XPATH)) {
				findByXPathAndClick(CHILDRENS_ACT_SUPPORT_S17_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + CHILDRENS_ACT_SUPPORT_S17_XPATH
						+ " " + NO_FUNDING_XPATH + " " + LEGAL_AID_FUNDING_XPATH + " "
						+ CHILDRENS_ACT_SUPPORT_S17_XPATH);
			}

			val = fields[5];
			if (null != val) {
				findByNameAndEnterText(LEGAL_AID_REF_NAME, val);
			}

			val = fields[6];
			if (null != val && val.equals(FAMILY_MEMBER_YES_XPATH)) {
				findByXPathAndClick(FAMILY_MEMBER_YES_XPATH);
			} else if (val.equals(FAMILY_MEMBER_NO_XPATH)) {
				findByXPathAndClick(FAMILY_MEMBER_NO_XPATH);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + FAMILY_MEMBER_YES_XPATH + " "
						+ FAMILY_MEMBER_NO_XPATH);
			}

			val = fields[7];
			if (null != val && null != val) {
				findByNameAndEnterText(FAMILY_NAME_1, val);
			}

			val = fields[8];
			//
			if (null != val) {
				findByNameAndEnterText(FAMILY_RELATIONSHIP_1, val);
			}

			// FAMILY_MEMEBER_REF_1
			val = fields[9];
			if (null != val) {
				findByNameAndEnterText(FAMILY_MEMEBER_REF_1, val);
			}

			val = fields[10];
			if (null != val) {
				findByNameAndEnterText(FAMILY_NAME_2, val);
			}

			val = fields[11];
			if (null != val) {
				findByNameAndEnterText(FAMILY_RELATIONSHIP_2, val);
			}

			val = fields[12];
			if (null != val) {
				findByNameAndEnterText(FAMILY_MEMEBER_REF_2, val);
			}

			val = fields[13];
			if (null != val) {
				findByNameAndEnterText(FAMILY_NAME_3, val);
			}

			val = fields[14];
			if (null != val) {
				findByNameAndEnterText(FAMILY_RELATIONSHIP_3, val);
			}

			val = fields[15];
			if (null != val) {
				findByNameAndEnterText(FAMILY_MEMEBER_REF_3, val);
			}

			val = fields[16];
			if (null != val) {
				findByNameAndEnterText(FAMILY_NAME_4, val);
			}

			val = fields[17];
			if (null != val) {
				findByNameAndEnterText(FAMILY_RELATIONSHIP_4, val);
			}

			val = fields[18];
			if (null != val) {
				findByNameAndEnterText(FAMILY_MEMEBER_REF_4, val);
			}

			val =fields[19];
			if(null != val && val.equals(TYPE_SETTLEMENT_XPATH)||val.equals(TYPE_NON_SETTLEMENT_XPATH)||val.equals(TYPE_FAMILY_VISIT_XPATH)){
				findByXPathAndClick(val);
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + TYPE_SETTLEMENT_XPATH
						+ " " + TYPE_NON_SETTLEMENT_XPATH+ " " + TYPE_FAMILY_VISIT_XPATH);
			}

			val = fields[20];
			if (null != val && val.equals(NavigateEnum.NEXT.getValue())) {
				clickNextButton();
			} else if (null != val && val.equals(NavigateEnum.PREVIOUS.getValue())) {
				clickPreviousButton();
			} else {
				logger.info("Val:" + val + " not understood expected one of:" + NavigateEnum.NEXT.getValue()
						+ " " + NavigateEnum.PREVIOUS.getValue());
			}
		} else {
			logger.info("Page1 not initialised with correct number of fields. Expected 21 was " + fieldLength);
		}
	}

}
