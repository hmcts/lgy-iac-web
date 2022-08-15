package com.MOJICT.IACFee.Util;

import com.MOJICT.IACFee.Beans.IAFT2Bean;
import org.apache.log4j.Logger;

public class ValidationServiceIAFT2 {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(ValidationServiceIAFT2.class);
	public static String lsc = "";

	public static String IsIAFT2Page1(IAFT2Bean frm) {

		String errMsg = "";

		if (Helper.isValidMandatoryRadio(frm.getAppeal_type()) == false)
			errMsg = errMsg + "<br/>Appeal Type";

		else if (frm.getAppeal_type().equals("Oral")) {
			if (frm.getQa_rep() == null && frm.getQa_sponsor() == null && frm.getQa_witness() == null)
				errMsg = errMsg + "<br/>Section 1 B";
		}
		lsc = frm.getQb_lsc();
		if (Helper.isValidMandatoryRadio(frm.getQb_lsc()) == false)
			errMsg = errMsg + "<br/>Legal Aid funding ";
		if (!frm.getQb_lsc().equals("No") && (frm.getQb_LAR() == null || frm.getQb_LAR().equals("")))
			errMsg = errMsg + "<br/>Section 1 C reference number required";

		if (Helper.isValidMandatoryRadio(frm.getFamily_member()) == false)
			errMsg = errMsg + "<br/>Are you Applying for any family member";
		if (frm.getFamily_member().equals("Yes")) {
			if (Helper.isValidMandatoryString(frm.getName1()) && Helper.isValidMandatoryString(frm.getRelationship1())
					&& Helper.isValidMandatoryString(frm.getPrn1())) {

			} else {
				errMsg = errMsg + "<br/>Family member, Section 1 D";
			}

		}

		if (!Helper.isValidMandatoryRadio(frm.getS1_tod()))
			errMsg = errMsg + "<br/>Type of decision";

		return errMsg;
	}

	public static String IsIAFT2Page2(IAFT2Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMandatoryString(frm.getS1a()))
			errMsg = errMsg + "<br/> Section 1 A";

		if (!Helper.isValidMandatoryString(frm.getS1b()))
			errMsg = errMsg + "<br/> Section 1 B";

		if (!Helper.isValidMandatoryString(frm.getS1c()))
			errMsg = errMsg + "<br/> Section 1 C";

		if (frm.getS1d_dob_day() != 0 && frm.getS1d_dob_month() != 0 && frm.getS1d_dob_year() != 0) {
			if (!Helper.isValidPastDate(frm.getS1d_dob_day() + "/" + frm.getS1d_dob_month() + "/" + frm.getS1d_dob_year()))
				errMsg = errMsg + "<br/> Invalid Date of Birth";
		}

		else
			errMsg = errMsg + "<br/> Section 1 D";

		if (!Helper.isValidMandatoryString(frm.getS1e()))
			errMsg = errMsg + "<br/> Section 1 E";

		if (!Helper.isValidMandatoryString(frm.getS1f_addr1()))
			errMsg = errMsg + "<br/> Section 1 F";

		if (!Helper.isValidMandatoryRadio(frm.getS1f_addr4()))
			errMsg = errMsg + "<br/> Country";

		if (!Helper.isValidPostCodeIAFT2(frm.getS1f_postcode().toUpperCase()))
			errMsg = errMsg + "<br/> Invalid Post code";

		if (frm.getS1g().equals("0"))
			errMsg = errMsg + "<br/> Section 1 G";

		return errMsg;

	}

	public static String IsIAFT2Page3(IAFT2Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMandatoryRadio(frm.getS2a()))
			errMsg = errMsg + "<br/> Section 2 A";

		if (!Helper.isValidMandatoryString(frm.getS2b()))
			errMsg = errMsg + "<br/> Section 2 B";

		if (!Helper.isValidMandatoryString(frm.getS2c()) || frm.getS2c().equals("0"))
			errMsg = errMsg + "<br/> Section 2 C";

		try {
			frm.setS2e(dateconverter.convertdate(frm.getS2e_day(), frm.getS2e_month(), frm.getS2e_year()));

			if (frm.getS2e_day() != 0 && frm.getS2e_month() != 0 && frm.getS2e_year() != 0) {
				if (!Helper.isValidPastDate(frm.getS2e_day() + "/" + frm.getS2e_month() + "/" + frm.getS2e_year()))
					errMsg = errMsg + "<br/> Invalid Date of Refusal Decision";
			} else
				errMsg = errMsg + "<br/> Section 2 E";
		} catch (Exception e) {
			errMsg = errMsg + "<br/> Invalid Date of Refusal Decision";
			return errMsg;

		}

		try {
			frm.setS2i(dateconverter.convertdate(frm.getS2i_day(), frm.getS2i_month(), frm.getS2i_year()));

			if (frm.getS2i_day() != 0 && frm.getS2i_month() != 0 && frm.getS2i_year() != 0) {
				if (!Helper.isValidPastDate(frm.getS2i_day() + "/" + frm.getS2i_month() + "/" + frm.getS2i_year()))
					errMsg = errMsg + "<br/> Invalid Date you received your Notice of Decision";
			} else
				errMsg = errMsg + "<br/> Section 2 F";
		} catch (Exception e) {
			errMsg = errMsg + "<br/> Invalid Date you received your Notice of Decision";
			return errMsg;

		}
		return errMsg;
	}

	public static String IsIAFT2Page4(IAFT2Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMaxLen(frm.getS3a(), 1000))
			errMsg = errMsg + "<br/> Section 3 A - 1000 characters allowed. You have entered " + frm.getS3a().length();

		if (!Helper.isValidMaxLen(frm.getS3b(), 1000))
			errMsg = errMsg + "<br/> Section 3 B - 1000 characters allowed. You have entered " + frm.getS3b().length();

		if (!Helper.isValidMaxLen(frm.getS3b(), 1000))
			errMsg = errMsg + "<br/> Section 3 C - 1000 characters allowed. You have entered " + frm.getS3c().length();

		return errMsg;
	}

	public static String IsIAFT2Page5(IAFT2Bean frm) {

		String errMsg = "";

		if (Helper.isValidMandatoryString(frm.getS3d_1())) {
			if (!Helper.isValidMaxLen(frm.getS3d_1(), 4000))
				errMsg = errMsg + "<br/> Section 3 D - 4000 characters allowed. You have entered "
						+ frm.getS3d_1().length();
		} else
			errMsg = errMsg + "<br/> Section 3 D";

		if (!Helper.isValidMandatoryRadio(frm.getS3e()))
			errMsg = errMsg + "<br/> Section 3 E";

		if (!Helper.isValidMandatoryRadio(frm.getS3f()))
			errMsg = errMsg + "<br/> Section 3 F";
		else {

			if (frm.getS3f().equals("Yes")) {
				if (!Helper.isValidMandatoryString(frm.getS3f_who()))
					errMsg = errMsg + "<br/> Section 3 F - Who";

				if (!Helper.isValidMandatoryString(frm.getS3f_language()))
					errMsg = errMsg + "<br/> Section 3 F - Language";

			}

		}

		return errMsg;
	}

	public static String IsIAFT2Page6(IAFT2Bean frm) {

		String errMsg = "";

		if (frm.getHave_rep().equals("No")) {
			if (!Helper.isValidMandatoryRadio(frm.getS4_decalaration()))
				errMsg = errMsg + "<br/> Declaration";
		}

		return errMsg;

	}

	// In progress
	public static String IsIAFT2Page7(IAFT2Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMandatoryString(frm.getS5a()))
			errMsg = errMsg + "<br/> Section 5 A";
		else {
			if (!Helper.isValidMaxLen(frm.getS5a(), 50))
				errMsg = errMsg + "<br/> Section 5 A - (50) characters allowed";
		}

		/*if (frm.getS5b().equals("0"))
			errMsg = errMsg + "<br/> Section 5 B";
		else {
			if (!Helper.isValidMaxLen(frm.getS5b(), 50))
				errMsg = errMsg + "<br/> Section 5 B - (50) characters allowed";
		}*/
		if (frm.getS5b().equals("00")) {
			if (!Helper.isValidMandatoryString(frm.getS5b_other())) {
				errMsg = errMsg + "<br/> Section 5 B1 - If other please specify";
			}
		}

		if (!Helper.isValidMandatoryString(frm.getS5c_addr1()))
			errMsg = errMsg + "<br/> Section 5 C";

		if (!Helper.isValidPostCodeIAFT2(frm.getS5c_postcode().toUpperCase()))
			errMsg = errMsg + "<br/> Invalid Post code";

		if (frm.getS5e().length() > 1) {
			if (!Helper.isValidphonefax(frm.getS5e()))
				errMsg = errMsg + "<br/> Section 5 E - invalid phone/mobile format";
		}

		if (frm.getS5f().length() > 1) {
			if (!Helper.isValidphonefax(frm.getS5f()))
				errMsg = errMsg + "<br/> Section 5 F - invalid fax format";
		}

		if (frm.getS5g().length() > 1) {

			if (!Helper.isValidEmail(frm.getS5g()))
				errMsg = errMsg + "<br/> Section 5 G - invalid email format";
		}

		boolean flag = false;

		if (Helper.isValidMandatoryRadio(frm.getS5_rep_agreed()))
			flag = true;

		if (Helper.isValidMandatoryRadio(frm.getS4_decalaration()))
			flag = true;

		if (!flag == true)
			errMsg = errMsg + "<br/> You must select one of the declaration";

		if (lsc.equals("Yes")) {
			if (!Helper.isValidMandatoryString(frm.getRep_sign()))
				errMsg = errMsg + "<br/> Declaration for Legal Aid";
		}

		return errMsg;
	}

	public static String IsIAFT2Page8(IAFT2Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMandatoryString(frm.getS6a()))
			errMsg = errMsg + "<br/> Section 6 A";

		if (!Helper.isValidMandatoryString(frm.getS6b()))
			errMsg = errMsg + "<br/> Section 6 B";

		if (!Helper.isValidMandatoryString(frm.getS6c()))
			errMsg = errMsg + "<br/> Section 6 C";

		if (!Helper.isValidMandatoryString(frm.getS6d_addr1()))
			errMsg = errMsg + "<br/> Section 6 D";

		if (!Helper.isValidMandatoryRadio(frm.getS6d_addr4()))
			errMsg = errMsg + "<br/> Country";

		if (!Helper.isValidPostCodeIAFT2(frm.getS6d_postcode().toUpperCase()))
			errMsg = errMsg + "<br/> Invalid Post code";

		if (frm.getS6e().length() > 1) {
			if (!Helper.isValidphonefax(frm.getS6e()))
				errMsg = errMsg + "<br/> Section 6 E - invalid phone/mobile format";
		}

		if (frm.getS6f().length() > 1) {
			if (!Helper.isValidEmail(frm.getS6f()))
				errMsg = errMsg + "<br/> Section 6 F - invalid email format";
		}

		if (!Helper.isValidMandatoryRadio(frm.getS6_auth()))
			errMsg = errMsg + "<br/> Section 6 - Authorisation";

		return errMsg;
	}

}
