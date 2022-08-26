package com.MOJICT.IACFee.Util;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * 
 * @author WEBTEAM4: turnerdv
 * 
 */
public class SecurityLite {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(SecurityLite.class);
	private static final byte[] key = { (byte) 0xfe, (byte) 0xff, 0x00, 0x49, 0x00,
			0x41, 0x00, 0x43, 0x00, 0x52, 0x00, 0x65, 0x00, 0x70, 0x00, 0x6f,
			0x00, 0x72, 0x00, 0x74, 0x00, 0x4b, 0x00, 0x65, 0x00, 0x79 };
	public static final String ALGORITHM = "AES";
	private static final int ITERATIONS = 2;
	
	
	private static void main(String args[]) {
		logger.debug(encryptString(args[0], args[1]));
	}

	/**
	 * Utility method to get an MD5 hash generated from the incoming byte array
	 * 
	 * @param bytesOfMessage
	 *            a byte array that you want to hash
	 * @return MD5 hash
	 */
	private static byte[] getMD5(byte[] bytesOfMessage) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return md.digest(bytesOfMessage);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Encrypt the supplied string with the supplied salt by the number of
	 * supplied iterations
	 * 
	 * @param encryptMe
	 * @param salt
	 * @param iterations
	 * @return
	 */
	public static String encryptString(String encryptMe, String salt) {
		Cipher cipher = getCipher();
		byte[] encValue = null;
		try {
			SecretKeySpec skey = generateSKey();
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			String valueToEncode = null;
			for (int i = 0; i < ITERATIONS; i++) {
				valueToEncode = salt + encryptMe;
				encValue = cipher.doFinal(valueToEncode.getBytes());
				encryptMe = Base64.encodeBase64String(encValue);
			}
		} catch (InvalidKeyException e) {
			logger.error("SecurityLite.encryptString - ", e);
		} catch (IllegalBlockSizeException e) {
			logger.error("SecurityLite.encryptString - ", e);
		} catch (BadPaddingException e) {
			logger.error("SecurityLite.encryptString - ", e);
		}
		encryptMe = encryptMe.replaceAll("\r\n", "");
		return encryptMe;
	}

	/**
	 * Decrypt the supplied String encrypted with AES and the given salt
	 * 
	 * @param decryptMe
	 * @param salt
	 * @param iterations
	 * @return
	 */
	public static String decryptString(String decryptMe, String salt) {
		Cipher cipher = getCipher();
		try {
			SecretKeySpec skey = generateSKey();
			cipher.init(Cipher.DECRYPT_MODE, skey);
			for (int i = 0; i < ITERATIONS; i++) {
				byte[] decodedValue = Base64.decodeBase64(decryptMe);
				byte[] decValue = cipher.doFinal(decodedValue);
				decryptMe = new String(decValue).substring(salt.length());
			}
		} catch (InvalidKeyException e) {
			logger.error("SecurityLite.decryptString - ", e);
		} catch (IllegalBlockSizeException e) {
			logger.error("SecurityLite.decryptString - ", e);
		} catch (BadPaddingException e) {
			logger.error("SecurityLite.decryptString - ", e);
		}
		return decryptMe;
	}

	/**
	 * Generate a Secret Key or get the secret key from the KeyStore
	 * 
	 * @return
	 */
	private static SecretKeySpec generateSKey() {
		SecretKeySpec skey = new SecretKeySpec(getMD5(key), ALGORITHM);
		return skey;
	}

	/**
	 * Get a Cipher that implements AES
	 * 
	 * @return
	 */
	private static Cipher getCipher() {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			logger.error("SecurityLite.getCipher - ", e);
		} catch (NoSuchPaddingException e) {
			logger.error("SecurityLite.getCipher - ", e);
		}
		return cipher;
	}	

}