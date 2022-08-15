/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package com.MOJICT.IACFee.Util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Properties;

import org.junit.Test;
import org.junit.Ignore;

//import sun.jkernel.ByteArrayToFromHexDigits;
import sun.misc.BASE64Encoder;



// TODO: Auto-generated Javadoc
/**
 * The Class TestSecurityLite.
 */
@Ignore
public class TestSecurityLite {

	/**
	 * Test encrypt string.
	 */
	@Test
	public void testEncryptString() {
		try {
			String expectedResult = "Lat1tude638";
			String salt = "IACReportStore";
			String expectedEncrypted = SecurityLite.encryptString(expectedResult, salt);
			String actualEncrypted = "owE8tZuoNwKeSyNdvqDVhkXZt84btiEHjPfo7bJGaKwphgPLsxxgusRZ17oeTItV4JcI46WJjI0FH/+I2NEw1w==";
			System.out.println(">>>>>"+expectedEncrypted);
			assertEquals(expectedEncrypted, actualEncrypted);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Test decrypt string.
	 */
	@Test
	public void testDecryptString() {
		try {
			String expectedResult = "Lat1tude638";
			String salt = "IACReportStore";
			System.out.println("actual :"+SecurityLite.encryptString(expectedResult, salt));			
			String encrypt = "owE8tZuoNwKeSyNdvqDVhkXZt84btiEHjPfo7bJGaKwM0nfupY0hv2ZtVXjDXDt+lSPdwI9glkyvk3QCDI7FwA==";
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			String text="IACReportStore";
			byte[] data = text.getBytes("UTF-8");
			byte[] hash = sha1.digest(data);
			
		
			System.out.println(byteArrayToHexString(hash));
		
			String decrypted = SecurityLite.decryptString(encrypt, salt);
			System.out.println(decrypted);
			assertEquals(decrypted, expectedResult);
		} catch (Exception e) {
			fail();
		}
	}

	public static String byteArrayToHexString(byte[] b) {
		  String result = "";
		  for (int i=0; i < b.length; i++) {
		    result +=
		          Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
		  }
		  return result;
		}
}
