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
import java.security.KeyStore;
import java.security.MessageDigest;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

// TODO: Auto-generated Javadoc
/**
 * The Class TestKeyStoreHandler.
 */
public class TestKeyStoreHandler {
	
	/** The key store handler. */
	private KeyStoreHandler keyStoreHandler = null;
	
	/** The key. */
	private byte[] key = {(byte)0xfe, (byte)0xff, 0x00, 0x49, 0x00, 0x41, 0x00, 0x43, 0x00, 0x52, 0x00, 0x65, 0x00, 0x70,0x00,0x6f,0x00,0x72,0x00,0x74,0x00,0x4b,0x00,0x65,0x00,0x79 };
	
	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		File iacKeyStore = new File("iackeyStore");
		if(iacKeyStore.exists()){
			iacKeyStore.delete();
		}
		File aTestKeyStore = new File("ATestKeyStore");		
		if(aTestKeyStore.exists()){
			aTestKeyStore.delete();
		}
		keyStoreHandler = new KeyStoreHandler();
	}

	/**
	 * Test get key store.
	 */
	@Test
	public void testGetKeyStore() {
		KeyStore ks = keyStoreHandler.getKeyStore("ATestKeyStore");
		assertTrue(ks != null);		
	}

	/**
	 * Test get password chars.
	 */
	@Test
	public void testGetPasswordChars() {
		String pwd = "TestPwd123";
		keyStoreHandler.getKeyStore("ATestKeyStore");
		keyStoreHandler.setPassword(pwd);
		assertArrayEquals(pwd.toCharArray(), keyStoreHandler.getPasswordChars());
	}

	/**
	 * Test set password.
	 */
	@Test
	public void testSetPassword() {
		String pwd = "TestPwd123";
		keyStoreHandler.setPassword(pwd);
		assertEquals(pwd, String.valueOf(keyStoreHandler.getPasswordChars()));
	}

	/**
	 * Test get secret key.
	 */
	@Test
	public void testGetSecretKey() {
		SecretKeySpec sKey = new SecretKeySpec(getMD5(key), "AES");
		keyStoreHandler.getKeyStore(null);
		String defaultKeyStoreName = "iacKeyStore";
		String kspassword = "KeyStorePassword";
		String alias = "TestAlias";
		keyStoreHandler.storeSecretKey(sKey, defaultKeyStoreName, alias, kspassword);
		SecretKey sk = keyStoreHandler.getSecretKey(defaultKeyStoreName, alias, kspassword);
		assertTrue(null != sk);
	}

	/**
	 * Test store private key.
	 */
	@Test
	public void testStorePrivateKey() {
		SecretKeySpec sKey = new SecretKeySpec(getMD5(key), "AES");
		keyStoreHandler.getKeyStore("ATestKeyStore");
		String defaultKeyStoreName = "iacKeyStore";
		String kspassword = "KeyStorePassword";
		String alias = "TestAlias";
		keyStoreHandler.storeSecretKey(sKey, defaultKeyStoreName, alias, kspassword);
		SecretKey sk = keyStoreHandler.getSecretKey(defaultKeyStoreName, alias, kspassword);
		assertTrue(null != sk);
		assertEquals(sKey.getAlgorithm(), sk.getAlgorithm());
		assertEquals(sKey.hashCode(), sk.hashCode());
		assertEquals(sKey, (SecretKeySpec)sk);
	}
	
	/**
	 * Test get loaded key store name.
	 */
	@Test
	public void testGetLoadedKeyStoreName(){
		String loadedKeyStoreName = keyStoreHandler.getLoadedKeyStoreName();
		assertEquals(null, loadedKeyStoreName);
		keyStoreHandler.getKeyStore(null);
		String defaultKeyStoreName = "iacKeyStore";
		loadedKeyStoreName = keyStoreHandler.getLoadedKeyStoreName();
		assertEquals(defaultKeyStoreName, loadedKeyStoreName);
		String keyStoreName = "ATestKeyStore";
		keyStoreHandler.getKeyStore(keyStoreName);
		loadedKeyStoreName = keyStoreHandler.getLoadedKeyStoreName();
		assertEquals(keyStoreName, loadedKeyStoreName);
		
		
	}
	
	/**
	 * Utility method to get an MD5 hash generated from the incoming byte array.
	 * 
	 * @param bytesOfMessage
	 *            a byte array that you want to hash
	 * @return MD5 hash
	 */
	private byte[] getMD5(byte[] bytesOfMessage){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return md.digest(bytesOfMessage);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
			return null;
		}		
	}

}
