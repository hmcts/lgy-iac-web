package com.MOJICT.IACFee.Util;

public interface GenericQueryBuilderProperties {
	public final String getSingleFormDataBySecurityToken = "select formname, securitytoken from formsdata where securitytoken=?";
	public final String getSingleFormDataByOrderId = "select  securitytoken,formname,transactionstatus,count from formsdata where paymentURN=? or AggregatedURN=?";
	public final String getTransactioncountbyorderid = "select count from formsdata where paymentURN=? or AggregatedURN=?";
	public final String setTransactionstatusbyorderid = "update formsdata set transactionstatus=?,count=? where paymentURN=? or AggregatedURN=?";
	public final String setTransactionstatusbyorderidtopup = "update transaction_details set transactionstatus=? where orderid=? or Aggr_URN=?";
	public final String getSingletopupstatus = "select transactionstatus from transaction_details where orderid=? or Aggr_URN=?";
}
