package com.MOJICT.IACFee.Util;


 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {
 
    /**
     * @param args
     * @throws NoSuchAlgorithmException 
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(sha1("UBIAdmin"));
    }
     
   public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
       
         
        return sb.toString().toUpperCase();
    }
    
    
    static boolean compareSHA(String Encrypted ,String input) throws NoSuchAlgorithmException
    {
    	boolean flag=false;
    	if(Encrypted.equals(SHA1.sha1(input)))
    	{
    		flag=true;
    	}
    	
    	
    	return flag;
    	
    }
    
    
    
    
}
