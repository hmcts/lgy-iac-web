package com.MOJICT.IACFee.Beans;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.MOJICT.IACFee.Util.SecurityLite;


public class CPIBean {

	public static void main(String args[])
	{
		CPIBean cpi=new CPIBean();
		logger.debug(cpi.getPassPhrase());
	}

	public CPIBean() {
		initialiseEpdq();
	}

	private void initialiseEpdq() {
		SHAIn = System.getenv("EPDQ_SHAIN");
		if (SHAIn == null) {
			SHAIn = "IACReportStore2013";
		}
		SHAOut = System.getenv("EPDQ_SHAOUT");
		if (SHAOut == null) {
			SHAOut = "IACReportStore2013";
		}
		EPDQ_URL = System.getenv("EPDQ_URL");
		if (EPDQ_URL == null) {
			EPDQ_URL = "https://payments.epdq.co.uk/ncol/prod/orderstandard_utf8.asp";
		}
		PSPID = System.getenv("EPDQ_PSPID");
		if (PSPID == null) {
			PSPID = "epdq64743";
		}
		STORAGE_METHOD = System.getenv("STORAGE_METHOD");
		if (STORAGE_METHOD == null) {
			STORAGE_METHOD = "local";
		}
		BUCKET_NAME = System.getenv("BUCKET_NAME");
		logger.info("After getting env, BUCKET_NAME is " + BUCKET_NAME);
		REST_API_URL = System.getenv("REST_API_URL");
		logger.info("After getting env, REST_API_URL is " + REST_API_URL);
	}

	private static String SHAIn;
	private static String SHAOut;
	private static String EPDQ_URL;
	private static String PSPID;
	private static String STORAGE_METHOD;
	private static String BUCKET_NAME;
	private static String REST_API_URL;

	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(CPIBean.class);

	public String cardprefix;
	public String ecistatus;
	public String epdqdata;
	public String oid;
	public String securitytoken;
	public String total = "180";
	public static String transactionstatus;

	public String urn;
	public Date date = new Date();
	public static DateFormat dateFormat = new SimpleDateFormat("kkmmssddMMyy");

	private String ordertime;

	public static String CHARGE_TYPE = "Auth";

	public static final String Encrypted = "7iguHGJ21Xvp5718BUzYo/zGtI6JGi+rSnFuDnF/NAvAmMODUnMlD5BEttYpo//ZR3i/E1fbb6kp/zsWpradDA==";
	public static String STORE_ID = "64743"; //LIVE
	public static String STORE_URL = "https://secure2.epdq.co.uk/cgi-bin/CcxBarclaysEpdq.e";

	/* == Getter definitions ================================================ */

	public String getCardPrefix() {
		return cardprefix;
	}

	public String getChargeType() {
		return CHARGE_TYPE;
	}

	public static String getPSPID() {
		return PSPID;
	}

	public static String getEPDQ_URL() {
		return EPDQ_URL;
	}

	public static String getSTORAGE_METHOD() {
		return STORAGE_METHOD;
	}

	public static String getBUCKET_NAME() {
		return BUCKET_NAME;
	}

	public static String getREST_API_URL() {
		return REST_API_URL;
	}

	public String getECIstatus() {
		return ecistatus;
	}

	public String getEpdqData() {
		return epdqdata;
	}

	public String getOrderTime() {
		return ordertime;
	}

	public String getPassPhrase() {
		return SecurityLite.decryptString(Encrypted, "MoJIACFees");
	}

	public String getSecurityToken() {
		return securitytoken;
	}

	public String getStore_ID() {
		return STORE_ID;
	}

	public String getTotal() {
		return total;
	}

	public String getURN() {
		return urn;
	}

	public String getStoreURL() {
		return STORE_URL;
	}

	/* == Setter definitions ================================================ */

	public void setCardPrefix(String cardprefix) {
		this.cardprefix = cardprefix;
	}

	public void setECIstatus(String ecistatus) {
		this.ecistatus = ecistatus;
	}

	public void setEpdqData(String epdqdata) {
		this.epdqdata = epdqdata;
	}

	public static String setOid(String urn) {
		String oid = urn;
		return oid;
	}

	public static String setOid_submission(String securitytoken, String urn, String type) {
		String timeDate = dateFormat.format(new Date());
		String ordertime = timeDate.toString();
		String oid = urn;
		oid = oid.concat(ordertime);

		oid = oid.concat(securitytoken);
		oid = oid.concat(type);
		logger.debug("oid value is: " + oid);

		return oid;
	}

	public void setSecurityToken(String securitytoken) {
		this.securitytoken = securitytoken;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public static String getTransactionstatus() {
		return transactionstatus;
	}

	public static void setTransactionstatus(String transactionstatus) {
		CPIBean.transactionstatus = transactionstatus;
	}

	public void setUrn(String urn) {
		this.urn = urn;
	}
	public static String getSHAIn() {
		return SHAIn;
	}

	public static void setSHAIn(String sHAIn) {
		SHAIn = sHAIn;
	}

	public static String getSHAOut() {
		return SHAOut;
	}

	public static void setSHAOut(String sHAOut) {
		SHAOut = sHAOut;
	}

	public static void setSTORAGE_METHOD(String STORAGE_METHOD) {
		STORAGE_METHOD = STORAGE_METHOD;
	}

	public static void setBUCKET_NAME(String BUCKET_NAME) {
		BUCKET_NAME = BUCKET_NAME;
	}

	public static void setREST_API_URL(String REST_API_URL) {
		REST_API_URL = REST_API_URL;
	}

}
