package com.MOJICT.IACFee.Beans;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

public class AggregatedBean extends ActionForm {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(AggregatedBean.class);

	/**
	 * Not used
	 */
	private static final long serialVersionUID = 1L;
	
	
	

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public int getPaymentvalue() {
		return paymentvalue;
	}

	public void setPaymentvalue(int paymentvalue) {
		this.paymentvalue = paymentvalue;
	}

	public String getFamily_member() {
		return family_member;
	}

	public void setFamily_member(String family_member) {
		this.family_member = family_member;
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

	public String getName5() {
		return name5;
	}

	public void setName5(String name5) {
		this.name5 = name5;
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

	public String getRelationship5() {
		return relationship5;
	}

	public void setRelationship5(String relationship5) {
		this.relationship5 = relationship5;
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

	public String getPrn5() {
		return prn5;
	}

	public void setPrn5(String prn5) {
		this.prn5 = prn5;
	}

	public String getSecurity_token() {
		return security_token;
	}

	public void setSecurity_token(String security_token) {
		this.security_token = security_token;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	int ID;
	private String submissionURN;
	private String paymentURN;
	private String AggregatedpaymentURN;
	private int paymentvalue;
	private int count;

	private String family_member;
	private String name1 = "";
	private String name2 = "";
	private String name3 = "";
	private String name4 = "";
	private String name5 = "";
	private String relationship1 = "";
	private String relationship2 = "";
	private String relationship3 = "";
	private String relationship4 = "";
	private String relationship5 = "";
	private String prn1 = "";
	private String prn2 = "";
	private String prn3 = "";
	private String prn4 = "";
	private String prn5 = "";
	private String security_token;
	private String oid = "";
	private String type = "";
	private String email="No email address specified";
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	    	
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

}
