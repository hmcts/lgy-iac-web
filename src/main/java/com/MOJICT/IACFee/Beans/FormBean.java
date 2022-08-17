package com.MOJICT.IACFee.Beans;

import org.apache.log4j.Logger;

public class FormBean {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(FormBean.class);
	private String securityToken;
	private String formName;
	private String transactionstatus;
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTransactionstatus() {
		return transactionstatus;
	}

	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}
}
