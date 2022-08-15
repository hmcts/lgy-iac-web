package com.MOJICT.IACFee.Util;

import com.MOJICT.IACFee.Beans.CPIBean;

public class SHAUtil {

	public static boolean validateresponse(String acceptance,String amount,String brand,String cardno,String cn,String currency,String ed,String ip,String ncerror,String orderid,String payid,String pm,String status,String trxdate,String SHASIGN)
	{
		try{
		String tohash="ACCEPTANCE="+acceptance+ CPIBean.getSHAOut()+"AMOUNT="+amount+CPIBean.getSHAOut()+"BRAND="+brand+CPIBean.getSHAOut()+"CARDNO="+cardno+CPIBean.getSHAOut()+"CN="+cn+CPIBean.getSHAOut()+"CURRENCY="+currency+CPIBean.getSHAOut()+"ED="+ed+CPIBean.getSHAOut()+"IP="+ip+CPIBean.getSHAOut()+"NCERROR="+ncerror+CPIBean.getSHAOut()+"ORDERID="+orderid+CPIBean.getSHAOut()+"PAYID="+payid+CPIBean.getSHAOut()+"PM="+pm+CPIBean.getSHAOut()+"STATUS="+status+CPIBean.getSHAOut()+"TRXDATE="+trxdate+CPIBean.getSHAOut();
		String result=SHA1.sha1(tohash);
		System.out.println(result);
		
		System.out.println("two string are Equal?"+SHASIGN.equals(result));
		
		return SHASIGN.equals(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
