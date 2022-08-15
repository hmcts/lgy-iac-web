package com.MOJICT.IACFee.Util;

import com.MOJICT.IACFee.Beans.IAFT3Bean;
import org.apache.log4j.Logger;

public class ValidationServiceIAFT3 {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(ValidationServiceIAFT3.class);

	public static String lsc = "";
	public static boolean triggerValidation=false;

	public static String IsIAFT3Page1(IAFT3Bean frm) {

		String errMsg = "";

		if (Helper.isValidMandatoryRadio(frm.getAppeal_type()) == false)
			errMsg = errMsg + "<br/>Section 1 A";

		else if (frm.getAppeal_type().equals("Oral")) {
			if (frm.getQa_rep() == null && frm.getQa_sponsor() == null && frm.getQa_witness() == null)
				errMsg = errMsg + "<br/>Section 1 B";
		}

		lsc = frm.getQb_lsc();
		
		//logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+frm.getQb_lsc());
		
		if (Helper.isValidMandatoryRadio(frm.getQb_lsc()) == false)
			errMsg = errMsg + "<br/>Legal Aid funding or Asylum Support funding";

		if (!frm.getQb_lsc().equals("No") && (frm.getQb_LAR() == null || frm.getQb_LAR().equals("")))
			errMsg = errMsg + "<br/>Section 1 C reference number required";

		if (Helper.isValidMandatoryRadio(frm.getFamily_member()) == false)
			errMsg = errMsg + "<br/>Are you Applying for any family member";
		if (frm.getFamily_member().equals("Yes")) {
			if (Helper.isValidMandatoryString(frm.getName1()) && Helper.isValidMandatoryString(frm.getRelationship1())
					&& Helper.isValidMandatoryString(frm.getPrn1())) {

			} else {
				errMsg = errMsg + "<br/>Please enter information for family member, Section 1 D";
			}

		}

		return errMsg;
	}

	public static String IsIAFT3Page2(IAFT3Bean frm) {

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

		if (!Helper.isValidPostCodeIAFT1(frm.getS1f_postcode().toUpperCase()))
			errMsg = errMsg + "<br/> Invalid Post code";

		if (frm.getS1g().equals("0"))
			errMsg = errMsg + "<br/> Section 1 G";

		if (!Helper.isValidMandatoryRadio(frm.getS1j()))
			errMsg = errMsg + "<br/> Section 1 I";
		else {

			if (frm.getS1j().equals("Yes")) {
				if (!Helper.isValidMandatoryString(frm.getS1j_who()))
					errMsg = errMsg + "<br/> Section 1 I - Who";

				if (!Helper.isValidMandatoryString(frm.getS1j_language()))
					errMsg = errMsg + "<br/> Section 1 I - Language";

			}

		}

		
		return errMsg;

	}

	public static String IsIAFT3Page3(IAFT3Bean frm) {

		String errMsg = "";
		boolean flag=false;



		if(Helper.isValidMinLen(frm.getS2a(),2))
			 {
			
			if(!Helper.isValidMaxLen(frm.getS2a(), 16) || (!frm.getS2a().matches("[A-Z]([\\d]{5,10}|[\\d]{5,10}/[\\d]{1})") && !frm.getS2a().matches("([\\d]{16})")))
				errMsg = errMsg + "<br/> On your decision from UKBA you will have been given a reference number.<br/>If this starts with a capital letter or a 16 digit number then complete Section 2 A, for any other reference number complete Section 2 C";
			flag=true;
			 }


			else if(Helper.isValidMinLen(frm.getS2c(),2))
			flag=true;


		if(!flag)
			errMsg = errMsg + "<br/> On your decision from UKBA you will have been given a reference number.<br/>If this starts with a capital letter or a 16 digit number then complete Section 2 A, for any other reference number complete Section 2 C";

			

		if (frm.getS2g_service_day() != 0 && frm.getS2g_service_month() != 0 && frm.getS2g_service_year() != 0) {
			if (!Helper.isValidPastDate(frm.getS2g_service_day() + "/" + frm.getS2g_service_month() + "/"
					+ frm.getS2g_service_year()))
				errMsg = errMsg + "<br/> Invalid Date - you left the UK following refusal";
		} else
			errMsg = errMsg + "<br/> Section 2 E";
	
		if (frm.getS2e_service_day() != 0 && frm.getS2e_service_month() != 0 && frm.getS2e_service_year() != 0) {
			if (!Helper.isValidPastDate(frm.getS2e_service_day() + "/" + frm.getS2e_service_month() + "/"
					+ frm.getS2e_service_year()))
				errMsg = errMsg + "<br/> Invalid Date - Refusal Decision";
				
		} else
			errMsg = errMsg + "<br/> Section 2 F";


		if (frm.getS2i_service_day() != 0 && frm.getS2i_service_month() != 0 && frm.getS2i_service_year() != 0) {
			if (!Helper.isValidPastDate(frm.getS2i_service_day() + "/" + frm.getS2i_service_month() + "/"
					+ frm.getS2i_service_year()))
				errMsg = errMsg + "<br/> Invalid Date - Service of Decision";
		} else
			errMsg = errMsg + "<br/> Section 2 G";

		return errMsg;
	}

	public static String IsIAFT3Page4(IAFT3Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMaxLen(frm.getS3a(), 1000))
			errMsg = errMsg + "<br/> Section 3 A - 1000 characters allowed. You have entered " + frm.getS3a().length();

		if (!Helper.isValidMaxLen(frm.getS3b(), 1000))
			errMsg = errMsg + "<br/> Section 3 B - 1000 characters allowed. You have entered " + frm.getS3b().length();

		if (!Helper.isValidMaxLen(frm.getS3b(), 1000))
			errMsg = errMsg + "<br/> Section 3 C - 1000 characters allowed. You have entered " + frm.getS3c().length();

		return errMsg;
	}

	public static String IsIAFT3Page5(IAFT3Bean frm) {

		String errMsg = "";
		triggerValidation=false;

		if (!Helper.isValidMaxLen(frm.getS3d_1(), 8000))
			errMsg = errMsg + "<br/> Section 3 D1 - (8000) characters allowed";

		if (!Helper.isValidMaxLen(frm.getS3d_2(), 8000))
			errMsg = errMsg + "<br/> Section 3 D2 - (8000) characters allowed";

		if (!Helper.isValidMaxLen(frm.getS3d_3(), 8000))
			errMsg = errMsg + "<br/> Section 3 D3 - (8000) characters allowed";

		return errMsg;

	}

	public static String IsIAFT3Page6(IAFT3Bean frm) {

		String errMsg = "";
		//triggerValidation=false;
		
		
		if (!Helper.isValidMaxLen(frm.getS3d_4(), 8000))
			errMsg = errMsg + "<br/> Section 3 D4 - (8000) characters allowed";

		if (!Helper.isValidMaxLen(frm.getS3d_5(), 8000))
			errMsg = errMsg + "<br/> Section 3 D5 - (8000) characters allowed";

		if (!Helper.isValidMaxLen(frm.getS3d_6(), 8000))
			errMsg = errMsg + "<br/> Section 3 D6 - (8000) characters allowed";

		if (!Helper.isValidMaxLen(frm.getS3d_7(), 8000))
			errMsg = errMsg + "<br/> Section 3 D7 - (8000) characters allowed";

		//For triggering validation
		if(frm.getS3d_4().length()>2)
			triggerValidation=true;
			if(frm.getS3d_5().length()>2)
				triggerValidation=true;
				if(frm.getS3d_6().length()>2)
					triggerValidation=true;
					if(frm.getS3d_7().length()>2)
					triggerValidation=true;
		

					//If your case is Asylum
					if(frm.getFormtitle().equals("Asylum"))
						if(!triggerValidation)
							errMsg=" Complete boxes 1 to 6 as applicable. You should also complete box 7 if you are not sure which boxes apply to you or there are other points in the refusal letter that you disagree with";

		
		return errMsg;
	}

	public static String IsIAFT3Page7(IAFT3Bean frm) {
		
		String errMsg = "";

		if (!Helper.isValidMaxLen(frm.getS3d_8(), 8000))
			errMsg = errMsg + "<br/> Section 3 D8 - (8000) characters allowed";
		
		logger.debug(">>>>>> "+frm.getFormtitle());

		//If your case is non Asylum
		if(frm.getFormtitle().equals("Immigration"))
				if (frm.getS3d_8().length()<2)
				errMsg=" Box 8 is mandatory for immigration cases ";
		
		logger.debug(errMsg);
		return errMsg;
	}

	public static String IsIAFT3Page8(IAFT3Bean frm) {

		String errMsg = "";

		if (!Helper.isValidMandatoryRadio(frm.getS3e()))
			errMsg = errMsg + "<br/> Section 3 E";

		else if (frm.getS3e().equals("Yes")) {

			if (frm.getS3e_date1_day() != 0 && frm.getS3e_date1_month() != 0 && frm.getS3e_date1_year() != 0) {
				if (!Helper.isValidPastDate(frm.getS3e_date1_day() + "/" + frm.getS3e_date1_month() + "/"
						+ frm.getS3e_date1_year()))
					errMsg = errMsg + "<br/> Invalid Date 1";
			} else
				errMsg = errMsg + "<br/> Section 3 E date 1";

			
			  if(frm.getS3e_date2_day()!=0 && frm.getS3e_date2_month()!=0 && frm.getS3e_date2_year()!=0) 
			  {
			  if(!Helper.isValidPastDate(frm.getS3e_date2_day()+"/"+frm.getS3e_date2_month()+"/"+frm.getS3e_date2_year()))
				  errMsg=errMsg+"<br/> Invalid Date 2"; 
			  } 
			  
			  if(frm.getS3e_date3_day()!=0 && frm.getS3e_date3_month()!=0 && frm.getS3e_date3_year()!=0) 
			  {
				  if(!Helper.isValidPastDate(frm.getS3e_date3_day()+"/"+frm.getS3e_date3_month()+"/"+frm.getS3e_date3_year()))
					  errMsg=errMsg+"<br/> Invalid Date 3";
			  } 
		}

		return errMsg;
	}

	public static String IsIAFT3Page9(IAFT3Bean frm) {

		String errMsg = "";

		if (frm.getHave_rep().equals("No")) {
			if (!Helper.isValidMandatoryRadio(frm.getS4_decalaration()))
				errMsg = errMsg + "<br/> Declaration";
		}

		return errMsg;
	}

	public static String IsIAFT3Page10(IAFT3Bean frm) {

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

			if (!Helper.isValidPostCodeIAFT1(frm.getS5c_postcode().toUpperCase()))
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
		

		if (lsc.equals("Yes")) {
			if (!Helper.isValidMandatoryString(frm.getRep_sign()))
				errMsg = errMsg + "<br/> Declaration for Legal Aid";
		}

		return errMsg;
	}

}
