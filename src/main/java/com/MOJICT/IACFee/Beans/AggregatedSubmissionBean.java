package com.MOJICT.IACFee.Beans;

import org.apache.log4j.Logger;

public class AggregatedSubmissionBean {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(AggregatedSubmissionBean.class);

	private String urn, type, paymenturn;

	private int amount;
	private String securitytoken,name,status;
   

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int count;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPaymenturn() {
		return paymenturn;
	}

	public void setPaymenturn(String paymenturn) {
		this.paymenturn = paymenturn;
	}

	public String getSecuritytoken() {
		return securitytoken;
	}

	public void setSecuritytoken(String securitytoken) {
		this.securitytoken = securitytoken;
	}

	public String getUrn() {
		return urn;
	}

	public void setUrn(String urn) {
		this.urn = urn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
