package com.MOJICT.IACFee.Util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public final class base64encoder
{
  private static PasswordService instance;
  public static void main(String args[]) throws Exception
  {
	  base64encoder instance = new base64encoder();
	  System.out.println(instance.encrypt("Password1"));
	  System.out.println(instance.decrypt("YHNxVUxsZKXSSOOitbUqHmcMLNU="));
	  
  }
  public synchronized String encrypt(String plaintext)
    throws Exception
  {
    MessageDigest md = null;
    try
    {
      md = MessageDigest.getInstance("SHA");
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new Exception(e.getMessage());
    }
    try
    {
      md.update(plaintext.getBytes("UTF-8"));
    }
    catch (UnsupportedEncodingException e)
    {
      throw new Exception(e.getMessage());
    }
    byte[] raw = md.digest();
    String hash = new BASE64Encoder().encode(raw);
    return hash;
  }
  public synchronized String decrypt(String str)
		    throws Exception
		  {
		    MessageDigest md = null;
		    try
		    {
		      md = MessageDigest.getInstance("SHA");
		    }
		    catch (NoSuchAlgorithmException e)
		    {
		      throw new Exception(e.getMessage());
		    }
		    try
		    {
		      md.update(str.getBytes("UTF-8"));
		    }
		    catch (UnsupportedEncodingException e)
		    {
		      throw new Exception(e.getMessage());
		    }
		    byte[] raw = md.digest();
		    byte[] hash = new BASE64Decoder().decodeBuffer(str);
		    return hash.toString();
		  }
  
  public static synchronized PasswordService getInstance()
  {
    if (instance == null) {
      //instance = new base64encoder();
    }
    return instance;
  }
}
