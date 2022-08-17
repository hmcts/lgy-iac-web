package com.MOJICT.IACFee.Beans;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

public class IAFT7Bean extends ActionForm implements IAFTBean {
	

	public Date getS2j() {
		return s2j;
	}

	public void setS2j(Date s2j) {
		this.s2j = s2j;
	}

	public String getS2k() {
		return s2k;
	}

	public void setS2k(String s2k) {
		this.s2k = s2k;
	}

	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(IAFT7Bean.class);
	int ID;
	private String submissionURN;
	private String paymentURN;
	private String AggregatedpaymentURN;
	private String formtype;
	private String formtitle;
	private String type;
	private String status;
	private String email="No email address specified";
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	    	
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private int paymentvalue;

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

	Date s1d;
	private int s1d_dob_day;
	private int s1d_dob_month;
	private int s1d_dob_year;

	public void setS1d_dob_day(int s1d_dob_day) {
		this.s1d_dob_day = s1d_dob_day;
	}

	public void setS1d_dob_month(int s1d_dob_month) {
		this.s1d_dob_month = s1d_dob_month;
	}

	public void setS1d_dob_year(int s1d_dob_year) {
		this.s1d_dob_year = s1d_dob_year;
	}

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
	private String s1h;
	private String s1i_yourself;
	private String s1i_witness;
	private String s1i_representative;
	private String s1j;
	private String s1j_who;
	private String s1j_language;
	private String s1j_dialect;
	private String s1k;
	private String s1l;
	private String s1m;
	private String s1m_hour;
	private String s1m_minutes;
	private String s1m_ampm;
	private Date s1n;
	private int s1n_removal_day;
	private int s1n_removal_month;
	private int s1n_removal_year;
	private String s1o;
	private Date s1p;
	private int s1p_sentence_day;
	private int s1p_sentence_month;
	private int s1p_sentence_year;

	private String s1q;
	// page3
	private String s2a;
	private String s2b;
	private String s2c;
	private String s2hoan;
	
	public String getS2hoan() {
		return s2hoan;
	}

	public void setS2hoan(String s2hoan) {
		this.s2hoan = s2hoan;
	}

	private String s2d;
	private String s2d_post;
	private String s2d_fax;
	private String s2d_courier;
	private String s2d_other;
	private Date s2e;
	private int s2e_service_day;
	private int s2e_service_month;
	private int s2e_service_year;
	private Date s2i;
	private int s2i_service_day;
	private int s2i_service_month;
	private int s2i_service_year;
	private Date s2j;
	private int s2j_service_day;
	private int s2j_service_month;
	private int s2j_service_year;
	

	public int getS2j_service_day() {
		return s2j_service_day;
	}

	public void setS2j_service_day(int s2j_service_day) {
		this.s2j_service_day = s2j_service_day;
	}

	public int getS2j_service_month() {
		return s2j_service_month;
	}

	public void setS2j_service_month(int s2j_service_month) {
		this.s2j_service_month = s2j_service_month;
	}

	public int getS2j_service_year() {
		return s2j_service_year;
	}

	public void setS2j_service_year(int s2j_service_year) {
		this.s2j_service_year = s2j_service_year;
	}

	private String s2k;
	
	private Date s2f;
	private int s2f_service_day;
	private int s2f_service_month;
	private int s2f_service_year;

	public int getS2f_service_day() {
		return s2f_service_day;
	}

	public void setS2f_service_day(int s2f_service_day) {
		this.s2f_service_day = s2f_service_day;
	}

	public int getS2f_service_month() {
		return s2f_service_month;
	}

	public void setS2f_service_month(int s2f_service_month) {
		this.s2f_service_month = s2f_service_month;
	}

	public int getS2f_service_year() {
		return s2f_service_year;
	}

	public void setS2f_service_year(int s2f_service_year) {
		this.s2f_service_year = s2f_service_year;
	}

	// page 4
	private String s3a;
	private String s3b;
	private String s3c;
	
	// page 5
	private String s3d_1;
	private String s3d_2;
	private String s3d_3;
	// page 6
	private String s3d_4;
	private String s3d_5;
	private String s3d_6;
	private String s3d_7;
	// page 7
	private String s3d_8;
	private String s3d_additional;
	// page 8
	private String s3e;
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
	String s3f;
	String s3g;
	public String getS3g() {
		return s3g;
	}

	public void setS3g(String s3g) {
		this.s3g = s3g;
	}

	private String s5_rep_signature;

	// page 9
	String s4_signature;
	Date s4_date;
	int s4_signature_day;
	int s4_signature_month;
	int s4_signature_year;
	private String s4_decalaration; // checkbox
	private String have_rep = "Yes";

	// page10
	String s5a;
	String s5b;
	String s5b_other;
	String s5c_addr1 = "";
	String s5c_addr2 = "";
	String s5c_addr3 = "";
	String s5c_addr4 = "";
	String s5c_postcode = "";
	String s5d;
	String s5e;
	String s5f;
	String s5g = "";
	String s5h = "";
	String s5i;
	String s5j = "0";
	String s5_rep_agreed;
	String rep_sign;
	
	private Boolean err = false;

	public Boolean getErr() {
		return err;
	}

	public void setErr(Boolean err) {
		this.err = err;
	}

	public String getFormtype() {
		return formtype;
	}

	public void setFormtype(String formtype) {
		this.formtype = formtype;
	}

	public String getFormtitle() {
		return formtitle;
	}

	public void setFormtitle(String formtitle) {
		this.formtitle = formtitle;
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

	public int getS1d_dob_day() {
		return s1d_dob_day;
	}

	public int getS1d_dob_month() {
		return s1d_dob_month;
	}

	public int getS1d_dob_year() {
		return s1d_dob_year;
	}

	public void setS1n_removal_day(int s1n_removal_day) {
		this.s1n_removal_day = s1n_removal_day;
	}

	public void setS1n_removal_month(int s1n_removal_month) {
		this.s1n_removal_month = s1n_removal_month;
	}

	public void setS1n_removal_year(int s1n_removal_year) {
		this.s1n_removal_year = s1n_removal_year;
	}

	public void setS1p_sentence_day(int s1p_sentence_day) {
		this.s1p_sentence_day = s1p_sentence_day;
	}

	public void setS1p_sentence_month(int s1p_sentence_month) {
		this.s1p_sentence_month = s1p_sentence_month;
	}

	public void setS1p_sentence_year(int s1p_sentence_year) {
		this.s1p_sentence_year = s1p_sentence_year;
	}

	public void setS2e_service_day(int s2e_service_day) {
		this.s2e_service_day = s2e_service_day;
	}

	public void setS2e_service_month(int s2e_service_month) {
		this.s2e_service_month = s2e_service_month;
	}

	public void setS2e_service_year(int s2e_service_year) {
		this.s2e_service_year = s2e_service_year;
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

	public void setS4_signature_day(int s4_signature_day) {
		this.s4_signature_day = s4_signature_day;
	}

	public void setS4_signature_month(int s4_signature_month) {
		this.s4_signature_month = s4_signature_month;
	}

	public void setS4_signature_year(int s4_signature_year) {
		this.s4_signature_year = s4_signature_year;
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

	public String getS3d_4() {
		return s3d_4;
	}

	public void setS3d_4(String s3d_4) {
		this.s3d_4 = s3d_4;
	}

	public String getS3d_5() {
		return s3d_5;
	}

	public void setS3d_5(String s3d_5) {
		this.s3d_5 = s3d_5;
	}

	public String getS3d_6() {
		return s3d_6;
	}

	public void setS3d_6(String s3d_6) {
		this.s3d_6 = s3d_6;
	}

	public String getS3d_7() {
		return s3d_7;
	}

	public void setS3d_7(String s3d_7) {
		this.s3d_7 = s3d_7;
	}

	public String getS3d_8() {
		return s3d_8;
	}

	public void setS3d_8(String s3d_8) {
		this.s3d_8 = s3d_8;
	}

	public String getS3d_additional() {
		return s3d_additional;
	}

	public void setS3d_additional(String s3d_additional) {
		this.s3d_additional = s3d_additional;
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

	public String getS4_signature() {
		return s4_signature;
	}

	public void setS4_signature(String s4_signature) {
		this.s4_signature = s4_signature;
	}

	public Date getS4_date() {
		return s4_date;
	}

	public void setS4_date(Date s4_date) {
		this.s4_date = s4_date;
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

	public Date getS2f() {
		return s2f;
	}

	public void setS2f(Date s2f) {
		this.s2f = s2f;
	}

	public Date getS1p() {
		return s1p;
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

	public String getS1h() {
		return s1h;
	}

	public void setS1h(String s1h) {
		this.s1h = s1h;
	}

	public String getS1j_who() {
		return s1j_who;
	}

	public void setS1j_who(String s1j_who) {
		this.s1j_who = s1j_who;
	}

	public String getS1j_language() {
		return s1j_language;
	}

	public void setS1j_language(String s1j_language) {
		this.s1j_language = s1j_language;
	}

	public String getS1j_dialect() {
		return s1j_dialect;
	}

	public void setS1j_dialect(String s1j_dialect) {
		this.s1j_dialect = s1j_dialect;
	}

	public String getS1k() {
		return s1k;
	}

	public void setS1k(String s1k) {
		this.s1k = s1k;
	}

	public String getS1l() {
		return s1l;
	}

	public void setS1l(String s1l) {
		this.s1l = s1l;
	}

	public String getS1m() {
		return s1m;
	}

	public void setS1m(String s1m) {
		this.s1m = s1m;
	}

	public Date getS1n() {
		return s1n;
	}

	public void setS1n(Date s1n) {
		this.s1n = s1n;
	}

	public String getS1o() {
		return s1o;
	}

	public void setS1o(String s1o) {
		this.s1o = s1o;
	}

	public String getS1q() {
		return s1q;
	}

	public void setS1q(String s1q) {
		this.s1q = s1q;
	}

	public String getS1f_postcode() {
		return s1f_postcode;
	}

	public void setS1f_postcode(String s1f_postcode) {
		this.s1f_postcode = s1f_postcode;
	}

	public String getS1i_yourself() {
		return s1i_yourself;
	}

	public void setS1i_yourself(String s1i_yourself) {
		this.s1i_yourself = s1i_yourself;
	}

	public String getS1i_witness() {
		return s1i_witness;
	}

	public void setS1i_witness(String s1i_witness) {
		this.s1i_witness = s1i_witness;
	}

	public String getS1i_representative() {
		return s1i_representative;
	}

	public void setS1i_representative(String s1i_representative) {
		this.s1i_representative = s1i_representative;
	}

	public String getS1m_hour() {
		return s1m_hour;
	}

	public void setS1m_hour(String s1m_hour) {
		this.s1m_hour = s1m_hour;
	}

	public String getS1m_minutes() {
		return s1m_minutes;
	}

	public void setS1m_minutes(String s1m_minutes) {
		this.s1m_minutes = s1m_minutes;
	}

	public String getS1m_ampm() {
		return s1m_ampm;
	}

	public void setS1m_ampm(String s1m_ampm) {
		this.s1m_ampm = s1m_ampm;
	}

	public int getS1n_removal_day() {
		return s1n_removal_day;
	}

	public int getS1n_removal_month() {
		return s1n_removal_month;
	}

	public int getS1n_removal_year() {
		return s1n_removal_year;
	}

	public int getS1p_sentence_day() {
		return s1p_sentence_day;
	}

	public int getS1p_sentence_month() {
		return s1p_sentence_month;
	}

	public int getS1p_sentence_year() {
		return s1p_sentence_year;
	}

	public int getS2e_service_day() {
		return s2e_service_day;
	}

	public int getS2e_service_month() {
		return s2e_service_month;
	}

	public int getS2e_service_year() {
		return s2e_service_year;
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

	public int getS4_signature_day() {
		return s4_signature_day;
	}

	public int getS4_signature_month() {
		return s4_signature_month;
	}

	public int getS4_signature_year() {
		return s4_signature_year;
	}

	public void setS1p(Date s1p) {
		this.s1p = s1p;
	}

	public String getS1j() {
		return s1j;
	}

	public void setS1j(String s1j) {
		this.s1j = s1j;
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

	public String getHave_rep() {
		return have_rep;
	}

	public void setHave_rep(String haveRep) {
		have_rep = haveRep;
	}

	@Override
	public String getType() {
		return this.formtype;
	}

	public int getS2i_service_day() {
		return s2i_service_day;
	}

	public void setS2i_service_day(int s2iServiceDay) {
		s2i_service_day = s2iServiceDay;
	}

	public int getS2i_service_month() {
		return s2i_service_month;
	}

	public void setS2i_service_month(int s2iServiceMonth) {
		s2i_service_month = s2iServiceMonth;
	}

	public int getS2i_service_year() {
		return s2i_service_year;
	}

	public void setS2i_service_year(int s2iServiceYear) {
		s2i_service_year = s2iServiceYear;
	}

	public Date getS2i() {
		return s2i;
	}

	public void setS2i(Date s2i) {
		this.s2i = s2i;
	}

}
