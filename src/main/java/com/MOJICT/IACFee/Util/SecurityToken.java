package com.MOJICT.IACFee.Util;

import java.util.UUID;
import java.util.Random;

import org.apache.log4j.Logger;

public class SecurityToken {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(SecurityToken.class);
	static int count;
	static int  randomInt=10000000;
	    
	public static synchronized String generateCode() throws Exception{  
		String uuid;
			uuid = UUID.randomUUID().toString();
			return (String)uuid.substring(0,8);
		}
	
	public static String generatePaymentURN() throws Exception{  
		 Random randomGenerator = new Random();
		 int randomInt;
		   
		       randomInt = randomGenerator.nextInt(100000000);
		    if(randomInt>10000000&&randomInt<100000000)
		    {
		   
			return randomInt+"";
		    }else
		    {
		    	   randomInt = randomGenerator.nextInt(100000000);
		    }
		    return randomInt+"";
		}
	public static int generateAggregatedPaymentURN() throws Exception{  
		 Random randomGenerator = new Random();
		 int randomInt;
		   
		       randomInt = randomGenerator.nextInt(100000000);
		    if(randomInt>10000000&&randomInt<100000000)
		    {
		   
			return randomInt;
		    }else
		    {
		    	   randomInt = randomGenerator.nextInt(100000000);
		    }
		    return randomInt;
		}
	public static synchronized int generateSubmissionURN(String urn) throws Exception{  
		 
		 Random randomGenerator = new Random();
		 //final int  randomInt=10000000;
		   
		      count=Integer.parseInt(urn)+1;
		      //randomInt=count;

			return count;
		}
	
	public static int retrieveamount(String urn) throws Exception{ 
		
		String amount=urn.substring(urn.length()-5, urn.length()-1);
		 	return Integer.parseInt(amount);
	}
	
    public static String retrievesecuritytoken(String urn) throws Exception{ 
		
		String securitytoken=urn.substring(urn.length()-9, urn.length());
		 	return securitytoken;
	}
      
	
}  
