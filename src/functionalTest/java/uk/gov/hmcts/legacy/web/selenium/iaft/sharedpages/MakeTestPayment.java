/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package uk.gov.hmcts.legacy.web.selenium.iaft.sharedpages;

import uk.gov.hmcts.legacy.web.selenium.iaft.AbstractIAFTPage;
import uk.gov.hmcts.legacy.web.selenium.iaft.NavigateEnum;
import uk.gov.hmcts.legacy.web.util.TextGenerator;
import org.apache.log4j.Logger;

import uk.gov.hmcts.legacy.web.selenium.IaftPage;

public class MakeTestPayment extends AbstractIAFTPage implements IaftPage {

	static Logger logger = Logger.getLogger(MakeTestPayment.class);

	public static final String CARDHOLDER_NAME = "Ecom_Payment_Card_Name";

	public static final String CARD_NUMBER = "Ecom_Payment_Card_Number";

	public static final String CARD_VERIFICATION_CODE = "Ecom_Payment_Card_Verification";

	public static final String EXPIRY_DATE_MONTH_NAME = "Ecom_Payment_Card_ExpDate_Month";

	public static final String EXPIRY_DATE_YEAR_NAME = "Ecom_Payment_Card_ExpDate_Year";

	@Override
	public void execute() {
		logger.info("Executing Make Test Payment");
		int fieldLength = fields.length;
		if (fieldLength == 6) {

			String val = fields[0];
			if (null != val) {
				if(!val.equals("NA"))
				findByNameAndEnterText(CARDHOLDER_NAME, val);
			} else {
				findByNameAndEnterText(CARDHOLDER_NAME, TextGenerator.getText(1000));
			}

			val = fields[1];
			if (null != val) {
				if(!val.equals("NA"))
				findByNameAndEnterText(CARD_NUMBER, val);
			} else {
				findByNameAndEnterText(CARD_NUMBER, TextGenerator.getText(1000));
			}

			val = fields[2];
			if (val != null) {
				if(!val.equals("NA"))
					findSelectByNameAndSelectByValue(EXPIRY_DATE_MONTH_NAME, val);
			} else {
				for (String month : PAYMENT_EXPIRY_DATE_MONTHS) {
					findSelectByNameAndSelectByValue(EXPIRY_DATE_MONTH_NAME, month);
				}
			}

			val = fields[3];
			if (val != null) {
				if(!val.equals("NA"))
					findSelectByNameAndSelectByValue(EXPIRY_DATE_YEAR_NAME, val);
			} else {
				for (String year : TEST_PAYMENT_YEARS) {
					findSelectByNameAndSelectByValue(EXPIRY_DATE_YEAR_NAME, year);
				}
			}

			val = fields[4];
			if (null != val) {
				if(!val.equals("NA"))
					findByNameAndEnterText(CARD_VERIFICATION_CODE, val);
			} else {
				findByNameAndEnterText(CARD_VERIFICATION_CODE, TextGenerator.getText(1000));
			}

			val = fields[5];
			if (null != val && val.equals(NavigateEnum.CONFIRM_PAYMENT.getValue())) {
				clickConfirmPaymentButton();
			} else {
				logger.info("Val:" + val + " not understood expected:" + NavigateEnum.CONFIRM_PAYMENT.getValue());
			}
		}

	}

}
