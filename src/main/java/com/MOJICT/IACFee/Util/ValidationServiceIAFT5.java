// TODO - Differences between master and production.

package com.MOJICT.IACFee.Util;

import com.MOJICT.IACFee.Beans.IAFT5Bean;
import org.apache.log4j.Logger;

public class ValidationServiceIAFT5 {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(ValidationServiceIAFT5.class);

	public static String lsc = "";
	public static boolean triggerValidation = false;

	public static String IsIAFT5Page1(IAFT5Bean frm) {

		String errMsg = "";


		if (Helper.isValidMandatoryRadio(frm.getAppeal_type()) == false)
			errMsg = errMsg + "<br/>Section 1 A";

		else if (frm.getAppeal_type().equals("Oral")) {
			if (frm.getQa_rep() == null && frm.getQa_sponsor() == null && frm.getQa_witness() == null)
				errMsg = errMsg + "<br/>Section 1 B";
		}

		lsc = frm.getQb_lsc();
		if (Helper.isValidMandatoryRadio(frm.getQb_lsc()) == false)
			errMsg = errMsg + "<br/>Legal Aid funding or Asylum Support funding";

		if (Helper.isValidMandatoryRadio(frm.getFamily_member()) == false)
			errMsg = errMsg + "<br/>Are you Applying for any family member";
		if (frm.getFamily_member().equals("Yes")) {
			if (Helper.isValidMandatoryString(frm.getName1()) && Helper.isValidMandatoryString(frm.getRelationship1())
					&& Helper.isValidMandatoryString(frm.getPrn1())) {

			} else {
				errMsg = errMsg + "<br/>Family member, Section 1 D";
			}

		}

		return errMsg;
	}

	public static String IsIAFT5Page2(IAFT5Bean frm) {

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

		if (!Helper.isValidPostCodeIAFT5(frm.getS1f_postcode().toUpperCase()))
			errMsg = errMsg + "<br/> Invalid Post code";

		if (frm.getS1h().equals("0"))
			errMsg = errMsg + "<br/> Section 1 H";

		if (!Helper.isValidMandatoryRadio(frm.getS1j()))
			errMsg = errMsg + "<br/> Section 1 J";
		else {

			if (frm.getS1j().equals("Yes")) {
				if (!Helper.isValidMandatoryString(frm.getS1j_who()))
					errMsg = errMsg + "<br/> Section 1 J - Who";

				if (!Helper.isValidMandatoryString(frm.getS1j_language()))
					errMsg = errMsg + "<br/> Section 1 J - Language";

			}

		}

		if (!Helper.isValidMaxLen(frm.getS1k(), 500))
			errMsg = errMsg + "<br/> Section 1 K - Maximum 500 characters allowed";

// Dependant on G
		if (!Helper.isValidMandatoryRadio(frm.getS1l()))
			errMsg = errMsg + "<br/> Section 1 L";
		else {
			if (frm.getS1l().equals("Yes")) {
				if (!Helper.isValidTime(frm.getS1m_hour(), frm.getS1m_minutes()))
					errMsg = errMsg + "<br/> Section 1 M";

				if (frm.getS1n_removal_day() != 0 && frm.getS1n_removal_month() != 0 && frm.getS1n_removal_year() != 0) {
					if (!Helper.isValidDate(frm.getS1n_removal_day() + "/" + frm.getS1n_removal_month() + "/"
							+ frm.getS1n_removal_year()))
						errMsg = errMsg + "<br/> Invalid Date of Removal";
				} else
					errMsg = errMsg + "<br/> Section 1 N";
			}
		}

		if (!Helper.isValidMandatoryRadio(frm.getS1o()))
			errMsg = errMsg + "<br/> Section 1 O";

// Dependant on O

		else {
			if (frm.getS1o().equals("Yes")) {
				if (frm.getS1p_sentence_day() != 0 && frm.getS1p_sentence_month() != 0
						&& frm.getS1p_sentence_year() != 0) {
					if (!Helper.isValidDate(frm.getS1p_sentence_day() + "/" + frm.getS1p_sentence_month() + "/"
							+ frm.getS1p_sentence_year()))
						errMsg = errMsg + "<br/> Invalid Date of Sentence";
				} else
					errMsg = errMsg + "<br/> Section 1 P";

				if (!Helper.isValidMandatoryRadio(frm.getS1q()))
					errMsg = errMsg + "<br/> Section 1 Q";
			}
		}

		return errMsg;

	}

	public static String IsIAFT5Page3(IAFT5Bean frm) {

		String errMsg = "";
		boolean flag = false;


	
		if (Helper.isValidMinLen(frm.getS2a(), 2))
		{
			if (!Helper.isValidMaxLen(frm.getS2a(), 16))
				errMsg = errMsg + "<br/> On your decision from UKBA you will have been given a reference number.<br/>If this starts with a capital letter or a 16 digit number then complete Section 2 A, for any other reference number complete Section 2 C";
			flag = true;
		 }


		else if(Helper.isValidMinLen(frm.getS2c(),2))
			flag = true;


		if (!flag)
			errMsg = errMsg + "<br/> On your decision from UKBA you will have been given a reference number.<br/>If this starts with a capital letter or a 16 digit number then complete Section 2 A, for any other reference number complete Section 2 C";

		
	
	

		if (!Helper.isValidMaxLen(frm.getS2b(), 14))
			errMsg = errMsg + "<br/> Section 2 B - Maximum 14 characters allowed";

		if (!Helper.isValidMaxLen(frm.getS2c(), 20))
			errMsg = errMsg + "<br/> Section 2 C - Maximum 20 characters allowed";

		try {
			frm.setS2e(dateconverter.convertdate(frm.getS2e_service_day(), frm.getS2e_service_month(),
					frm.getS2e_service_year()));
			if (frm.getS2e_service_day() != 0 && frm.getS2e_service_month() != 0 && frm.getS2e_service_year() != 0) {
				if (!Helper.isValidPastDate(frm.getS2e_service_day() + "/" + frm.getS2e_service_month() + "/"
						+ frm.getS2e_service_year()))
					errMsg = errMsg + "<br/> Invalid Date of Home Office Decision";
			} else
				errMsg = errMsg + "<br/> Section 2 F";
		} catch (Exception e) {
			errMsg = errMsg + "<br/> Invalid Date of Home Office Decision";
			return errMsg;
		}
		try {
			frm.setS2j(dateconverter.convertdate(frm.getS2j_service_day(), frm.getS2j_service_month(),
					frm.getS2j_service_year()));
			if (frm.getS2j_service_day() != 0 && frm.getS2j_service_month() != 0 && frm.getS2j_service_year() != 0) {
				if (!Helper.isValidPastDate(frm.getS2j_service_day() + "/" + frm.getS2j_service_month() + "/"
						+ frm.getS2j_service_year()))
					errMsg = errMsg + "<br/> Invalid Date of Application to Home Office ";
			} else
				errMsg = errMsg + "<br/> Section 2 E";
		} catch (Exception e) {
			errMsg = errMsg + "<br/> Invalid Date of Application to Home Office ";
			return errMsg;
		}

		try {
			frm.setS2i(dateconverter.convertdate(frm.getS2i_service_day(), frm.getS2i_service_month(),
					frm.getS2i_service_year()));
			if (frm.getS2i_service_day() != 0 && frm.getS2i_service_month() != 0 && frm.getS2i_service_year() != 0) {
				if (!Helper.isValidPastDate(frm.getS2i_service_day() + "/" + frm.getS2i_service_month() + "/"
						+ frm.getS2i_service_year()))
					errMsg = errMsg + "<br/> Invalid Date of Notice of Decision sent by Home Office";
			} else
				errMsg = errMsg + "<br/> Section 2 H";
		} catch (Exception e) {
			errMsg = errMsg + "<br/> Invalid Date of Notice of Decision sent by Home Office";
			return errMsg;
		}


	
	
	
	
		return errMsg;
	}

	public static String IsIAFT5Page4(IAFT5Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMaxLen(frm.getS3a(), 1000))
			errMsg = errMsg + "<br/> Section 3 A - 1000 characters allowed. You have entered " + frm.getS3a().length();

		if (!Helper.isValidMaxLen(frm.getS3b(), 1000))
			errMsg = errMsg + "<br/> Section 3 B - 1000 characters allowed. You have entered " + frm.getS3b().length();

		if (!Helper.isValidMaxLen(frm.getS3b(), 1000))
			errMsg = errMsg + "<br/> Section 3 C - 1000 characters allowed. You have entered " + frm.getS3c().length();

		return errMsg;
	}

	public static String IsIAFT5Page5(IAFT5Bean frm) {

		String errMsg = "";

	if(frm.getFormtitle().equals("Protection"))
	{
		if(!Helper.isValidMinLen(frm.getS3d_1(), 2)&&!Helper.isValidMinLen(frm.getS3d_1(), 2))
		{
				errMsg = errMsg + "<br/> complete Section 3 D1 and/or Section 3 D2 that apply to you. ";

			}

		}
	if(frm.getFormtitle().equals("Human Rights"))
	{
		if(!Helper.isValidMinLen(frm.getS3d_3(), 2))
		{
				errMsg = errMsg + "<br/> complete Section 3 D3. ";

			}

		}

		if (!Helper.isValidMaxLen(frm.getS3d_1(), 2000))
			errMsg = errMsg + "<br/> Section 3 D1 - (2000) characters allowed. You have entered " + frm.getS3d_1().length();

		if (!Helper.isValidMaxLen(frm.getS3d_2(), 2000))
			errMsg = errMsg + "<br/> Section 3 D2 - (2000) characters allowed. You have entered " + frm.getS3d_2().length();

		if (!Helper.isValidMaxLen(frm.getS3d_3(), 2000))
			errMsg = errMsg + "<br/> Section 3 D3 - (2000) characters allowed. You have entered " + frm.getS3d_3().length();

//For triggering validation
//logger.debug("frm s3d_1 value is "+frm.getS3d_1());
		if (frm.getS3d_1().length() > 2)
			triggerValidation = true;
		else if (frm.getS3d_2().length() > 2)
			triggerValidation = true;
		else if (frm.getS3d_3().length() > 2)
			triggerValidation = true;
		else
			triggerValidation = false;

//logger.debug("frm s3d_1 value is "+frm.getS3d_1()+"trigger value is "+triggerValidation);
		return errMsg;
	}

	public static String IsIAFT5Page6(IAFT5Bean frm) {

		String errMsg = "";

	if(frm.getFormtitle().equals("Protection Revoke"))
	{
		if(!Helper.isValidMinLen(frm.getS3d_4(), 2)||!Helper.isValidMinLen(frm.getS3d_5(), 2))
		{
				errMsg = errMsg + "<br/> complete Section 3 D4 and Section 3 D5. ";

			}

		}
	if(frm.getFormtitle().equals("EEA"))
	{
		if(!Helper.isValidMinLen(frm.getS3d_6(), 2))
		{
				errMsg = errMsg + "<br/> complete Section 3 D6. ";

			}

		}
	if(frm.getFormtitle().equals("Citizenship"))
	{
		if(!Helper.isValidMinLen(frm.getS3d_7(), 2))
		{
				errMsg = errMsg + "<br/> complete Section 3 D7. ";

			}

		}

		if (!Helper.isValidMaxLen(frm.getS3d_4(), 2000))
			errMsg = errMsg + "<br/> Section 3 D4 - (2000) characters allowed";

		if (!Helper.isValidMaxLen(frm.getS3d_5(), 2000))
			errMsg = errMsg + "<br/> Section 3 D5 - (2000) characters allowed";

		if (!Helper.isValidMaxLen(frm.getS3d_6(), 2000))
			errMsg = errMsg + "<br/> Section 3 D6 - (2000) characters allowed";

		if (!Helper.isValidMaxLen(frm.getS3d_7(), 2000))
			errMsg = errMsg + "<br/> Section 3 D7 - (2000) characters allowed";


		logger.debug("Page 6 before if ---------------- " + triggerValidation);

	if(!triggerValidation)
	{
//For triggering validation
			if (frm.getS3d_4().length() > 2)
				triggerValidation = true;
			else if (frm.getS3d_5().length() > 2)
				triggerValidation = true;
			else if (frm.getS3d_6().length() > 2)
				triggerValidation = true;
			else if (frm.getS3d_7().length() > 2)
				triggerValidation = true;
			else
				triggerValidation = false;
		}

		logger.debug("Page 6 after if ---------------- " + triggerValidation);

//If your case is Asylum
		if (frm.getFormtitle().equals("Asylum"))
			if (!triggerValidation)
				errMsg = " Complete boxes 1 to 6 as applicable. You should also complete box 7 if you are not sure which boxes apply to you or there are other points in the refusal letter that you disagree with";

		triggerValidation = false;
		return errMsg;
	}

	public static String IsIAFT5Page7(IAFT5Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMaxLen(frm.getS3d_8(), 3000))
			errMsg = errMsg + "<br/> Section 3 D8 - (3000) characters allowed";

		if (!Helper.isValidMaxLen(frm.getS3d_additional(), 2000))
			errMsg = errMsg + "<br/> Section 3 D-Additional - (2000) characters allowed";

//If your case is non Asylum
		if (frm.getFormtitle().equals("Immigration"))
			if (frm.getS3d_8().length() < 2)
				errMsg = " Box 8 is mandatory for immigration cases ";


	
	
		return errMsg;
	}

	public static String IsIAFT5Page8(IAFT5Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMandatoryRadio(frm.getS3e()))
			errMsg = errMsg + "<br/> Section 3 F";

		else if (frm.getS3e().equals("Yes")) {

			if (frm.getS3e_date1_day() != 0 && frm.getS3e_date1_month() != 0 && frm.getS3e_date1_year() != 0) {
				if (!Helper.isValidPastDate(frm.getS3e_date1_day() + "/" + frm.getS3e_date1_month() + "/"
						+ frm.getS3e_date1_year()))
					errMsg = errMsg + "<br/> Invalid Date 1";
			} else
				errMsg = errMsg + "<br/> Section 3 F date 1";


	if(frm.getS3e_date2_day()!=0 && frm.getS3e_date2_month()!=0 && frm.getS3e_date2_year()!=0)
	{
				if (!Helper.isValidPastDate(frm.getS3e_date2_day() + "/" + frm.getS3e_date2_month() + "/" + frm.getS3e_date2_year()))
					errMsg = errMsg + "<br/> Invalid Date 2";
			}


	if(frm.getS3e_date3_day()!=0 && frm.getS3e_date3_month()!=0 && frm.getS3e_date3_year()!=0)
	{
				if (!Helper.isValidPastDate(frm.getS3e_date3_day() + "/" + frm.getS3e_date3_month() + "/" + frm.getS3e_date3_year()))
					errMsg = errMsg + "<br/> Invalid Date 3";
			}

		}

		return errMsg;
	}

	public static String IsIAFT5Page9(IAFT5Bean frm) {

		String errMsg = "";

		if (frm.getHave_rep().equals("No")) {
			if (!Helper.isValidMandatoryRadio(frm.getS4_decalaration()))
				errMsg = errMsg + "<br/> Declaration";
		}

		return errMsg;
	}

	public static String IsIAFT5Page10(IAFT5Bean frm) {

		String errMsg = "";

	if (frm.getHave_rep().equals("Yes"))
	
	{
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

			if (!Helper.isValidMandatoryRadio(frm.getS5c_addr4()))
				errMsg = errMsg + "<br/> Country";

			if (!Helper.isValidPostCodeIAFT5(frm.getS5c_postcode().toUpperCase()))
				errMsg = errMsg + "<br/> Invalid Post code";

		}

		if (!Helper.isValidMaxLen(frm.getS5d(), 20))
			errMsg = errMsg + "<br/> Section 5 D - (20) characters allowed";

		if (frm.getS5e().length() > 1) {
			if (!Helper.isValidphonefax(frm.getS5e()))
				errMsg = errMsg + "<br/> Section 5 E - invalid phone format";
		}

		if (frm.getS5f().length() > 1) {
			if (!Helper.isValidphonefax(frm.getS5f()))
				errMsg = errMsg + "<br/> Section 5 F - invalid mobile format";
		}

		if (frm.getS5g().length() > 1) {
			if (!Helper.isValidphonefax(frm.getS5g()))
				errMsg = errMsg + "<br/> Section 5 G - invalid fax format";
		}

		if (frm.getS5h().length() > 1) {

			if (!Helper.isValidEmail(frm.getS5h()))
				errMsg = errMsg + "<br/> Section 5 H - invalid email format";
		}

		if (frm.getHave_rep().equals("Yes")) {

			boolean flag = false;

			if (Helper.isValidMandatoryRadio(frm.getS5_rep_agreed()))
				flag = true;

			if (Helper.isValidMandatoryRadio(frm.getS4_decalaration()))
				flag = true;

			if (!flag == true)
				errMsg = errMsg + "<br/> You must select one of the declaration";

		}

		if (lsc.equals("LSC")) {

			if (!Helper.isValidMandatoryString(frm.getRep_sign()))
				errMsg = errMsg + "<br/> Declaration for Legal Aid";
		}

		return errMsg;
	}

}
