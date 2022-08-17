package com.MOJICT.IACFee.Util;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * Class that handles all aspects of security for the CPI application. Warning:
 * Unauthorised access to this file constitutes a breach of Ministry of Justice
 * Data and as such may be considered a criminal offence.
 * 
 * The security model is as follows: The /config directory must have a manual
 * file created called DestroyOnRead.txt This file must contain 3 values in the
 * following format and order:
 * P4SSPHR4SE="<a string used just once while generating the secret key>"
 * S4LT="<your salt used just once while generating the secret key>"
 * ITER4TIONS=5 REAL="<actual value you want to encrypt>"
 * REALSALT="<a salt that will be used thereafter>" REALITERATIONS=2 The
 * application will - on first run create a keystore with the password set to
 * the MD5 hash of the current server Mac address. This password will never be
 * permanantly stored but will be regenerated on each run of the application.
 * The application will encrypt PASSPHARSE with the SALT by the number of
 * ITERATIONS and will then store the MD5 hash of this value in the keystore.
 * The alias to this secret key is 'Key' The application will delete the file
 * DestroyOnRead.txt - this file must never be stored on production environments
 * except during the deployment phase. This key is used to encrypt/decrypt all
 * secret values within the application.
 * 
 * If the system is hacked and the code is stolen then the generated password
 * will not match the keystore password when the code is run on a different
 * machine so hiding the secret key and rendering decryption of the secret
 * values prohibitive allowing enough time to detect an intrusion and alter
 * store passwords/passphrases etc. A new DestroyOnRead.txt must then be
 * generated and the secret values regenerated using the new secret key.
 * 
 * @author WEBTEAM4: turnerdv
 * 
 */
public class Security {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Security.class);
	private byte[] oneusekee = { (byte) 0xfe, (byte) 0xff, 0x00, 0x49, 0x00,
			0x41, 0x00, 0x43, 0x00, 0x52, 0x00, 0x65, 0x00, 0x70, 0x00, 0x6f,
			0x00, 0x72, 0x00, 0x74, 0x00, 0x4b, 0x00, 0x65, 0x00, 0x79 };
	private String keyStoreName = "IAC_CPI_KEYSTORE";
	private String config = "../config/";
	String alias = "KEY";

	/**
	 * Utility method to get an MD5 hash generated from the incoming byte array
	 * 
	 * @param bytesOfMessage
	 *            a byte array that you want to hash
	 * @return MD5 hash
	 */
	private byte[] getMD5(byte[] bytesOfMessage) {
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
	public String encryptString(String encryptMe, String salt, int iterations,
			boolean newstore) {
		Cipher cipher = getCipher();
		byte[] encValue = null;
		try {
			SecretKeySpec skey = generateSKey(newstore);
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			String valueToEncode = null;
			for (int i = 0; i < iterations; i++) {
				valueToEncode = salt + encryptMe;
				encValue = cipher.doFinal(valueToEncode.getBytes());
				encryptMe = Base64.encodeBase64String(encValue);
			}
		} catch (InvalidKeyException e) {
			logger.error("Security.encryptString", e);
		} catch (IllegalBlockSizeException e) {
			logger.error("Security.encryptString", e);
		} catch (BadPaddingException e) {
			logger.error("Security.encryptString", e);
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
	public String decryptString(String decryptMe, String salt, int iterations) {
		Cipher cipher = getCipher();
		try {
			SecretKeySpec skey = generateSKey(false);
			cipher.init(Cipher.DECRYPT_MODE, skey);
			for (int i = 0; i < iterations; i++) {
				byte[] decodedValue = Base64.decodeBase64(decryptMe);
				byte[] decValue = cipher.doFinal(decodedValue);
				decryptMe = new String(decValue).substring(salt.length());
			}
		} catch (InvalidKeyException e) {
			logger.error("Security.decryptString", e);
		} catch (IllegalBlockSizeException e) {
			logger.error("Security.decryptString", e);
		} catch (BadPaddingException e) {
			logger.error("Security.decryptString", e);
		}
		return decryptMe;
	}

	/**
	 * Generate a Secret Key or get the secret key from the KeyStore
	 * 
	 * @return
	 */
	private SecretKeySpec generateSKey(boolean newstore) {
		SecretKeySpec skey = null;
		if (newstore) {
			skey = new SecretKeySpec(getMD5(oneusekee), "AES");
		} else {
			KeyStoreHandler keyStoreHandler = new KeyStoreHandler();
			keyStoreHandler.setPassword(getP());
			keyStoreHandler.getKeyStore(keyStoreName);
			skey = (SecretKeySpec) keyStoreHandler.getSecretKey(keyStoreName,
					alias, getP());
		}
		return skey;
	}

	/**
	 * Get a Cipher that implements AES
	 * 
	 * @return
	 */
	private Cipher getCipher() {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			logger.error("Security.getCipher", e);
		} catch (NoSuchPaddingException e) {
			logger.error("Security.getCipher", e);
		}
		return cipher;
	}

	/**
	 * Gets P as a hex from the hash of the loc
	 * 
	 * @return p
	 */
	private String getP() {
		return asHex(getMD5(getMac()));
	}

	/**
	 * Generate the keystore
	 */
	public void initialise(String keyStoreNewName) {
		logger.debug("******************************");
		if (null != keyStoreNewName) {
			keyStoreName = keyStoreNewName;
			// this should only be used for testing
		}
		File f = null;
		try {
			URL url = getClass().getResource(
					"../config/DestroyOnRead.properties");
			if (null != url) {
				f = new File(url.toURI());
			}
		} catch (URISyntaxException e2) {
			logger.error("Security.initialise", e2);
		}
		FileInputStream is = null;
		try {
			if (null != f && f.exists()) {
				is = new FileInputStream(f);
				File s = new File(keyStoreName);
				if (s.exists()) {
					s.delete();
				}
				Properties props = new Properties();
				props.load(is);
				is.close();
				String a = props.getProperty("P4SSPHR4SE");
				String b = props.getProperty("S4LT");
				int c = Integer.parseInt(props.getProperty("ITER4TIONS"));
				String sEncryptKey = encryptString(a, b, c, true);
				int length = sEncryptKey.length();
				if (length > 31) {
					length = 32;
				} else if (length > 23) {
					length = 24;
				} else {
					if (length < 16) {// right pad encrypyKey to right length -
										// stunned if this is ever needed
						sEncryptKey = String.format(
								"%/1$-" + sEncryptKey + "X", 17 - length);
					}
					length = 16;
				}
				byte[] raw = new byte[length];
				byte[] key = sEncryptKey.getBytes();
				for (int i = 0; i < length; i++) {
					raw[i] = key[i];
				}
				SecretKeySpec sKey = new SecretKeySpec(raw, "AES");
				KeyStoreHandler keyStoreHandler = new KeyStoreHandler();
				keyStoreHandler.setPassword(getP());
				keyStoreHandler.getKeyStore(keyStoreName);
				keyStoreHandler.storeSecretKey(sKey, keyStoreName, alias,
						getP());
				a = props.getProperty("REAL");
				b = props.getProperty("REALSALT");
				c = Integer.parseInt(props.getProperty("REALITERATIONS"));
				props = null;
				f.delete();
				a = encryptString(a, b, c, false);				
				generatePropertyFile(a, b, c);
				
			}
		} catch (FileNotFoundException e) {
			logger.error("Security.initialise", e);
		} catch (IOException e) {
			logger.error("Security.initialise", e);
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error("Security.initialise", e);
				}
			}
			if (null != f && f.exists()) {
				f.delete();
			}
		}
	}

	/**
	 * If the application does not have its store properties file this will
	 * generate one containing the encrypted passphrase
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param filename
	 */
	private void generatePropertyFile(String a, String b, int c) {
		logger.debug("Generating property file");
		URL url = getClass().getResource("../config/cpi.properties");
		
			try {
				File f = new File(url.toURI());
				Properties props = new Properties();
				props.load(new FileInputStream(f));
				props.setProperty("PASSPHRASE", a);
				props.setProperty("SALT", b);
				props.setProperty("ITERATIONS", String.valueOf(c));
				props.store(new FileOutputStream(f), "Properties Updated");
			} catch (IOException e) {
				logger.error("Security.generatePropertyFile", e);
			} catch (URISyntaxException e) {
				logger.error("Security.generatePropertyFile", e);
			}
	}

	/**
	 * Retrieves the mac address of the current machine
	 * 
	 * @return
	 */
	private byte[] getMac() {
		NetworkInterface niN = null;
		try {
			niN = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			return niN.getHardwareAddress();
		} catch (SocketException e) {
			logger.error("Security.getMac", e);
		} catch (UnknownHostException e) {
			logger.error("Security.getMac", e);
		}
		return null;
	}

	/**
	 * Displays a byte[] as a hex value
	 * 
	 * @param buff
	 * @return
	 */
	private String asHex(byte[] buff) {
		StringBuffer strBuf = new StringBuffer(buff.length * 2);
		for (byte b : buff) {
			b = (byte) (b & 0xff);
			if (b < 0x10) {
				strBuf.append("0");
			}
			strBuf.append(Long.toString(b, 16));
		}
		return strBuf.toString();
	}

	/**
	 * Retrieve the passphrase from -currently - a properties file
	 * 
	 * @return
	 */
	private String getPass() {

		initialise(null);
		FileInputStream is = null;
		Properties p = new Properties();
		File f = null;
		try {

			try {
				URL url = getClass().getResource("../config/cpi.properties");
				if (null != url) {
					f = new File(url.toURI());
				}
			} catch (URISyntaxException e2) {
				logger.error("Security.getPass", e2);
			}
			is = new FileInputStream(f);
			p.load(is);
			is.close();
		} catch (IOException e) {
			logger.error("Security.getPass", e);
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error("Security.getPass", e);
				}
			}
		}
		String encrypt = p.getProperty("PASSPHRASE");
		String salt = p.getProperty("SALT");
		int iterations = Integer.parseInt(p.getProperty("ITERATIONS"));
		return decryptString(encrypt, salt, iterations);
	}

	public static String getPassPhrase() {
		Security sec = new Security();
		sec.initialise(null);
		return sec.getPass();
	}
}