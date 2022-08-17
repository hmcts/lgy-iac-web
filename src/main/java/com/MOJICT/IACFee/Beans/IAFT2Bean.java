package com.MOJICT.IACFee.Beans;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

public class IAFT2Bean extends ActionForm implements IAFTBean {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(IAFT2Bean.class);
	int ID;
	private String submissionURN;
	private String paymentURN;
	private String AggregatedpaymentURN;
	private String formtype;
	private String formtitle;
	private int paymentvalue;
	private String type;

	// Page 1
	private String appeal_type = null;
	private String qa_sponsor; // checkbox
	private String qa_rep; // checkbox
	private String qa_witness; // checkbox
	private String qb_lsc = "No"; // Radio
	private String qb_LAR;

	// Relations
	private String family_member = "No";
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String relationship1;
	private String relationship2;
	private String relationship3;
	private String relationship4;
	private String prn1;
	private String prn2;
	private String prn3;
	private String prn4;

	// Page 2
	private String s1a;
	private String s1b;
	private String s1c;
	private Date s1d;
	private int s1d_dob_day;
	private int s1d_dob_month;
	private int s1d_dob_year;

	private String s1e;
	private String s1f_addr1 = "";
	private String s1f_addr2 = "";
	private String s1f_addr3 = "";
	private String s1f_addr4 = "";
	private String s1f_postcode = "";
	private String s1f_email = "";
	public String getS1f_email() {
		return s1f_email;
	}

	public void setS1f_email(String s1f_email) {
		this.s1f_email = s1f_email;
	}

	private String s1g;
	private String s1_tod = "";

	// page3
	private String s2a; // checkbox
	private String s2b;
	private String s2c;
	private String s2d;
	private String s2d_post;
	private String s2d_fax;
	private String s2d_courier;
	private String s2d_other;
	private Date s2e;
	private int s2e_day;
	private int s2e_month;
	private int s2e_year;

	private Date s2i;
	private int s2i_day;
	private int s2i_month;
	private int s2i_year;
	
	// page 4
	private String s3a;
	private String s3b;
	private String s3c;

	// page 5
	private String s3d;
	private String s3d_1;
	private String s3d_2;
	private String s3d_3;
	private String s3e; // checkbox
	private Date s3e_date1;
	private String s3e_appealno1;
	private Date s3e_date2;
	private String s3e_appealno2;
	private Date s3e_date3;
	private String s3e_appealno3;
	private int s3e_date1_day;
	private int s3e_date1_month;
	private int s3e_date1_year;
	private int s3e_date2_day;
	private int s3e_date2_month;
	private int s3e_date2_year;
	private int s3e_date3_day;
	private int s3e_date3_month;
	private int s3e_date3_year;
	private String s3f = "No";
	private String s3f_who;
	private String s3f_language;
	private String s3f_dialect;
	private String s3g;
	private String s5_rep_signature;

	// page 6
	private String s4_decalaration; // checkbox
	private String have_rep = "Yes";
	private String have_sponsor = "Yes";

	// page7
	private String s5a;
	private String s5b;
	private String s5b_organisation;
	private String s5b_other;
	private String s5c_addr1 = "";
	private String s5c_addr2 = "";
	private String s5c_addr3 = "";
	private String s5c_addr4 = "";
	private String s5c_postcode = "";
	private String s5d;
	private String s5e;
	private String s5f;
	private String s5g;
	private String s5h;
	private String s5i = "0";
	private String s5j;
	private String s5_rep_agreed;
	private String rep_sign;

	// Section 6

	private String s6a;
	private String s6b;
	private String s6c;
	private String s6d_addr1 = "";
	private String s6d_addr2 = "";
	private String s6d_addr3 = "";
	private String s6d_addr4 = "";
	private String s6d_postcode = "";
	private String s6e = "";
	private String s6f = "";
	private String s6_auth;
	private String email="No email address specified";
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	    	
	}
	public String getS1_tod() {
		return s1_tod;
	}

	public void setS1_tod(String s1_tod) {
		this.s1_tod = s1_tod;
	}

	public String getFormtype() {
		return formtype;
	}

	public void setFormtype(String formtype) {
		this.formtype = formtype;
	}

	public String getRep_sign() {
		return rep_sign;
	}

	public void setRep_sign(String rep_sign) {
		this.rep_sign = rep_sign;
	}

	public int getPaymentvalue() {
		return paymentvalue;
	}

	public void setPaymentvalue(int paymentvalue) {
		this.paymentvalue = paymentvalue;
	}

	public String getS5b_other() {
		return s5b_other;
	}

	public void setS5b_other(String s5b_other) {
		this.s5b_other = s5b_other;
	}

	public String getS4_decalaration() {
		return s4_decalaration;
	}

	public void setS4_decalaration(String s4_decalaration) {
		this.s4_decalaration = s4_decalaration;
	}

	public String getS5_rep_agreed() {
		return s5_rep_agreed;
	}

	public void setS5_rep_agreed(String s5_rep_agreed) {
		this.s5_rep_agreed = s5_rep_agreed;
	}

	String securitytoken;

	// Navigation
	private String next;
	private String previous;

	public String getFormtitle() {
		return formtitle;
	}

	public void setFormtitle(String formtitle) {
		this.formtitle = formtitle;
	}

	public int getS1d_dob_day() {
		return s1d_dob_day;
	}

	public int getS1d_dob_month() {
		return s1d_dob_month;
	}

	public int getS1d_dob_year() {
		return s1d_dob_year;
	}

	public void setS3e_date1_day(int s3e_date1_day) {
		this.s3e_date1_day = s3e_date1_day;
	}

	public void setS3e_date1_month(int s3e_date1_month) {
		this.s3e_date1_month = s3e_date1_month;
	}

	public void setS3e_date1_year(int s3e_date1_year) {
		this.s3e_date1_year = s3e_date1_year;
	}

	public void setS3e_date2_day(int s3e_date2_day) {
		this.s3e_date2_day = s3e_date2_day;
	}

	public void setS3e_date2_month(int s3e_date2_month) {
		this.s3e_date2_month = s3e_date2_month;
	}

	public void setS3e_date2_year(int s3e_date2_year) {
		this.s3e_date2_year = s3e_date2_year;
	}

	public void setS3e_date3_day(int s3e_date3_day) {
		this.s3e_date3_day = s3e_date3_day;
	}

	public void setS3e_date3_month(int s3e_date3_month) {
		this.s3e_date3_month = s3e_date3_month;
	}

	public void setS3e_date3_year(int s3e_date3_year) {
		this.s3e_date3_year = s3e_date3_year;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getS3a() {
		return s3a;
	}

	public void setS3a(String s3a) {
		this.s3a = s3a;
	}

	public String getS3b() {
		return s3b;
	}

	public void setS3b(String s3b) {
		this.s3b = s3b;
	}

	public String getS3c() {
		return s3c;
	}

	public void setS3c(String s3c) {
		this.s3c = s3c;
	}

	public String getS3d_1() {
		return s3d_1;
	}

	public void setS3d_1(String s3d_1) {
		this.s3d_1 = s3d_1;
	}

	public String getS3d_2() {
		return s3d_2;
	}

	public void setS3d_2(String s3d_2) {
		this.s3d_2 = s3d_2;
	}

	public String getS3d_3() {
		return s3d_3;
	}

	public void setS3d_3(String s3d_3) {
		this.s3d_3 = s3d_3;
	}

	public String getS3e() {
		return s3e;
	}

	public void setS3e(String s3e) {
		this.s3e = s3e;
	}

	public Date getS3e_date1() {
		return s3e_date1;
	}

	public void setS3e_date1(Date s3e_date1) {
		this.s3e_date1 = s3e_date1;
	}

	public String getS3e_appealno1() {
		return s3e_appealno1;
	}

	public void setS3e_appealno1(String s3e_appealno1) {
		this.s3e_appealno1 = s3e_appealno1;
	}

	public Date getS3e_date2() {
		return s3e_date2;
	}

	public void setS3e_date2(Date s3e_date2) {
		this.s3e_date2 = s3e_date2;
	}

	public String getS3e_appealno2() {
		return s3e_appealno2;
	}

	public void setS3e_appealno2(String s3e_appealno2) {
		this.s3e_appealno2 = s3e_appealno2;
	}

	public Date getS3e_date3() {
		return s3e_date3;
	}

	public void setS3e_date3(Date s3e_date3) {
		this.s3e_date3 = s3e_date3;
	}

	public String getS3e_appealno3() {
		return s3e_appealno3;
	}

	public void setS3e_appealno3(String s3e_appealno3) {
		this.s3e_appealno3 = s3e_appealno3;
	}

	public String getS3f() {
		return s3f;
	}

	public void setS3f(String s3f) {
		this.s3f = s3f;
	}

	public String getS5a() {
		return s5a;
	}

	public void setS5a(String s5a) {
		this.s5a = s5a;
	}

	public String getS5b() {
		return s5b;
	}

	public void setS5b(String s5b) {
		this.s5b = s5b;
	}

	public String getS5c_addr1() {
		return s5c_addr1;
	}

	public void setS5c_addr1(String s5c_addr1) {
		this.s5c_addr1 = s5c_addr1;
	}

	public String getS5c_addr2() {
		return s5c_addr2;
	}

	public void setS5c_addr2(String s5c_addr2) {
		this.s5c_addr2 = s5c_addr2;
	}

	public String getS5c_addr3() {
		return s5c_addr3;
	}

	public void setS5c_addr3(String s5c_addr3) {
		this.s5c_addr3 = s5c_addr3;
	}

	public String getS5c_addr4() {
		return s5c_addr4;
	}

	public void setS5c_addr4(String s5c_addr4) {
		this.s5c_addr4 = s5c_addr4;
	}

	public String getS5c_postcode() {
		return s5c_postcode;
	}

	public void setS5c_postcode(String s5c_postcode) {
		this.s5c_postcode = s5c_postcode;
	}

	public String getS5d() {
		return s5d;
	}

	public void setS5d(String s5d) {
		this.s5d = s5d;
	}

	public String getS5e() {
		return s5e;
	}

	public void setS5e(String s5e) {
		this.s5e = s5e;
	}

	public String getS5f() {
		return s5f;
	}

	public void setS5f(String s5f) {
		this.s5f = s5f;
	}

	public String getS5g() {
		return s5g;
	}

	public void setS5g(String s5g) {
		this.s5g = s5g;
	}

	public String getS5h() {
		return s5h;
	}

	public void setS5h(String s5h) {
		this.s5h = s5h;
	}

	public String getS5i() {
		return s5i;
	}

	public void setS5i(String s5i) {
		this.s5i = s5i;
	}

	public String getS5j() {
		return s5j;
	}

	public void setS5j(String s5j) {
		this.s5j = s5j;
	}

	public String getS2a() {
		return s2a;
	}

	public void setS2a(String s2a) {
		this.s2a = s2a;
	}

	public String getS2b() {
		return s2b;
	}

	public void setS2b(String s2b) {
		this.s2b = s2b;
	}

	public String getS2c() {
		return s2c;
	}

	public void setS2c(String s2c) {
		this.s2c = s2c;
	}

	public String getS2d_post() {
		return s2d_post;
	}

	public void setS2d_post(String s2d_post) {
		this.s2d_post = s2d_post;
	}

	public String getS2d_fax() {
		return s2d_fax;
	}

	public void setS2d_fax(String s2d_fax) {
		this.s2d_fax = s2d_fax;
	}

	public String getS2d_courier() {
		return s2d_courier;
	}

	public void setS2d_courier(String s2d_courier) {
		this.s2d_courier = s2d_courier;
	}

	public String getS2d_other() {
		return s2d_other;
	}

	public void setS2d_other(String s2d_other) {
		this.s2d_other = s2d_other;
	}

	public Date getS2e() {
		return s2e;
	}

	public void setS2e(Date s2e) {
		this.s2e = s2e;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAppeal_type() {
		return appeal_type;
	}

	public void setAppeal_type(String appealType) {
		appeal_type = appealType;
	}

	public String getQa_sponsor() {
		return qa_sponsor;
	}

	public void setQa_sponsor(String qaSponsor) {
		qa_sponsor = qaSponsor;
	}

	public String getQa_rep() {
		return qa_rep;
	}

	public void setQa_rep(String qaRep) {
		qa_rep = qaRep;
	}

	public String getQa_witness() {
		return qa_witness;
	}

	public void setQa_witness(String qaWitness) {
		qa_witness = qaWitness;
	}

	public String getQb_lsc() {
		return qb_lsc;
	}

	public void setQb_lsc(String qbLsc) {
		qb_lsc = qbLsc;
	}

	public String getQb_LAR() {
		return qb_LAR;
	}

	public void setQb_LAR(String qbLAR) {
		qb_LAR = qbLAR;
	}

	public String getSecuritytoken() {
		return securitytoken;
	}

	public void setSecuritytoken(String securitytoken) {
		this.securitytoken = securitytoken;
	}

	public String getFamily_member() {
		return family_member;
	}

	public void setFamily_member(String familyMember) {
		family_member = familyMember;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getRelationship1() {
		return relationship1;
	}

	public void setRelationship1(String relationship1) {
		this.relationship1 = relationship1;
	}

	public String getRelationship2() {
		return relationship2;
	}

	public void setRelationship2(String relationship2) {
		this.relationship2 = relationship2;
	}

	public String getRelationship3() {
		return relationship3;
	}

	public void setRelationship3(String relationship3) {
		this.relationship3 = relationship3;
	}

	public String getRelationship4() {
		return relationship4;
	}

	public void setRelationship4(String relationship4) {
		this.relationship4 = relationship4;
	}

	public String getPrn1() {
		return prn1;
	}

	public void setPrn1(String prn1) {
		this.prn1 = prn1;
	}

	public String getPrn2() {
		return prn2;
	}

	public void setPrn2(String prn2) {
		this.prn2 = prn2;
	}

	public String getPrn3() {
		return prn3;
	}

	public void setPrn3(String prn3) {
		this.prn3 = prn3;
	}

	public String getPrn4() {
		return prn4;
	}

	public void setPrn4(String prn4) {
		this.prn4 = prn4;
	}

	public String getS1a() {
		return s1a;
	}

	public void setS1a(String s1a) {
		this.s1a = s1a;
	}

	public String getS1b() {
		return s1b;
	}

	public void setS1b(String s1b) {
		this.s1b = s1b;
	}

	public String getS1c() {
		return s1c;
	}

	public void setS1c(String s1c) {
		this.s1c = s1c;
	}

	public Date getS1d() {
		return s1d;
	}

	public void setS1d(Date s1d) {
		this.s1d = s1d;
	}

	public String getS1e() {
		return s1e;
	}

	public void setS1e(String s1e) {
		this.s1e = s1e;
	}

	public String getS1f_addr1() {
		return s1f_addr1;
	}

	public void setS1f_addr1(String s1f_addr1) {
		this.s1f_addr1 = s1f_addr1;
	}

	public String getS1f_addr2() {
		return s1f_addr2;
	}

	public void setS1f_addr2(String s1f_addr2) {
		this.s1f_addr2 = s1f_addr2;
	}

	public String getS1f_addr3() {
		return s1f_addr3;
	}

	public void setS1f_addr3(String s1f_addr3) {
		this.s1f_addr3 = s1f_addr3;
	}

	public String getS1f_addr4() {
		return s1f_addr4;
	}

	public void setS1f_addr4(String s1f_addr4) {
		this.s1f_addr4 = s1f_addr4;
	}

	public String getS1g() {
		return s1g;
	}

	public void setS1g(String s1g) {
		this.s1g = s1g;
	}

	public String getS1f_postcode() {
		return s1f_postcode;
	}

	public void setS1f_postcode(String s1f_postcode) {
		this.s1f_postcode = s1f_postcode;
	}

	public int getS3e_date1_day() {
		return s3e_date1_day;
	}

	public int getS3e_date1_month() {
		return s3e_date1_month;
	}

	public int getS3e_date1_year() {
		return s3e_date1_year;
	}

	public int getS3e_date2_day() {
		return s3e_date2_day;
	}

	public int getS3e_date2_month() {
		return s3e_date2_month;
	}

	public int getS3e_date2_year() {
		return s3e_date2_year;
	}

	public int getS3e_date3_day() {
		return s3e_date3_day;
	}

	public int getS3e_date3_month() {
		return s3e_date3_month;
	}

	public int getS3e_date3_year() {
		return s3e_date3_year;
	}

	public String getS2d() {
		return s2d;
	}

	public void setS2d(String s2d) {
		this.s2d = s2d;
	}

	public String getS5_rep_signature() {
		return s5_rep_signature;
	}

	public void setS5_rep_signature(String s5RepSignature) {
		s5_rep_signature = s5RepSignature;
	}

	public String getS3d() {
		return s3d;
	}

	public void setS3d(String s3d) {
		this.s3d = s3d;
	}

	public String getS3g() {
		return s3g;
	}

	public void setS3g(String s3g) {
		this.s3g = s3g;
	}

	public String getS5b_organisation() {
		return s5b_organisation;
	}

	public void setS5b_organisation(String s5bOrganisation) {
		s5b_organisation = s5bOrganisation;
	}

	public String getS6a() {
		return s6a;
	}

	public void setS6a(String s6a) {
		this.s6a = s6a;
	}

	public String getS6b() {
		return s6b;
	}

	public void setS6b(String s6b) {
		this.s6b = s6b;
	}

	public String getS6c() {
		return s6c;
	}

	public void setS6c(String s6c) {
		this.s6c = s6c;
	}

	public String getS6d_addr1() {
		return s6d_addr1;
	}

	public void setS6d_addr1(String s6dAddr1) {
		s6d_addr1 = s6dAddr1;
	}

	public String getS6d_addr2() {
		return s6d_addr2;
	}

	public void setS6d_addr2(String s6dAddr2) {
		s6d_addr2 = s6dAddr2;
	}

	public String getS6d_addr3() {
		return s6d_addr3;
	}

	public void setS6d_addr3(String s6dAddr3) {
		s6d_addr3 = s6dAddr3;
	}

	public String getS6d_addr4() {
		return s6d_addr4;
	}

	public void setS6d_addr4(String s6dAddr4) {
		s6d_addr4 = s6dAddr4;
	}

	public String getS6d_postcode() {
		return s6d_postcode;
	}

	public void setS6d_postcode(String s6dPostcode) {
		s6d_postcode = s6dPostcode;
	}

	public String getS6e() {
		return s6e;
	}

	public void setS6e(String s6e) {
		this.s6e = s6e;
	}

	public String getS6f() {
		return s6f;
	}

	public void setS6f(String s6f) {
		this.s6f = s6f;
	}

	public String getS6_auth() {
		return s6_auth;
	}

	public void setS6_auth(String s6Auth) {
		s6_auth = s6Auth;
	}

	public String getSubmissionURN() {
		return submissionURN;
	}

	public void setSubmissionURN(String submissionURN) {
		this.submissionURN = submissionURN;
	}

	public String getPaymentURN() {
		return paymentURN;
	}

	public void setPaymentURN(String paymentURN) {
		this.paymentURN = paymentURN;
	}

	public String getAggregatedpaymentURN() {
		return AggregatedpaymentURN;
	}

	public void setAggregatedpaymentURN(String aggregatedpaymentURN) {
		AggregatedpaymentURN = aggregatedpaymentURN;
	}

	public void setS1d_dob_day(int s1d_dob_day) {
		this.s1d_dob_day = s1d_dob_day;
	}

	public void setS1d_dob_month(int s1d_dob_month) {
		this.s1d_dob_month = s1d_dob_month;
	}

	public void setS1d_dob_year(int s1d_dob_year) {
		this.s1d_dob_year = s1d_dob_year;
	}

	public int getS2e_day() {
		return s2e_day;
	}

	public void setS2e_day(int s2eDay) {
		s2e_day = s2eDay;
	}

	public int getS2e_month() {
		return s2e_month;
	}

	public void setS2e_month(int s2eMonth) {
		s2e_month = s2eMonth;
	}

	public int getS2e_year() {
		return s2e_year;
	}

	public void setS2e_year(int s2eYear) {
		s2e_year = s2eYear;
	}

	public String getS3f_who() {
		return s3f_who;
	}

	public void setS3f_who(String s3fWho) {
		s3f_who = s3fWho;
	}

	public String getS3f_language() {
		return s3f_language;
	}

	public void setS3f_language(String s3fLanguage) {
		s3f_language = s3fLanguage;
	}

	public String getS3f_dialect() {
		return s3f_dialect;
	}

	public void setS3f_dialect(String s3fDialect) {
		s3f_dialect = s3fDialect;
	}

	public String getHave_rep() {
		return have_rep;
	}

	public void setHave_rep(String have_rep) {
		this.have_rep = have_rep;
	}

	public String getHave_sponsor() {
		return have_sponsor;
	}

	public void setHave_sponsor(String have_sponsor) {
		this.have_sponsor = have_sponsor;
	}

	@Override
	public String getType() {
		return formtype;
	}

	public Date getS2i() {
		return s2i;
	}

	public void setS2i(Date s2i) {
		this.s2i = s2i;
	}

	public int getS2i_day() {
		return s2i_day;
	}

	public void setS2i_day(int s2iDay) {
		s2i_day = s2iDay;
	}

	public int getS2i_month() {
		return s2i_month;
	}

	public void setS2i_month(int s2iMonth) {
		s2i_month = s2iMonth;
	}

	public int getS2i_year() {
		return s2i_year;
	}

	public void setS2i_year(int s2iYear) {
		s2i_year = s2iYear;
	}

}
