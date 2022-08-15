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
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

// TODO: Auto-generated Javadoc
/**
 * The Class TestSecurity.
 */
@Ignore
public class TestSecurity {

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		File f = new File("WEB-INF/classes/com/MOJICT/IACFee/config/DestroyOnRead.properties");
		File f1 = new File("WEB-INF/classes/com/MOJICT/IACFee/config/cpi.properties");
		if (!f.exists()) {
			try {
				FileUtils.copyFile(
						new File("neverdeploythis/DestroyOnRead.properties"),
						new File("WEB-INF/classes/com/MOJICT/IACFee/config/DestroyOnRead.properties"));
			} catch (IOException e) {
				e.printStackTrace();
				fail();
			}
		}
		if (!f1.exists()) {
			try {
				FileUtils.copyFile(
						new File("src/com/MOJICT/IACFee/config/cpi.properties"),
						new File("WEB-INF/classes/com/MOJICT/IACFee/config/cpi.properties"));
			} catch (IOException e) {
				e.printStackTrace();
				fail();
			}
		}
		f = new File("TestStore");
		if (f.exists()) {
			f.delete();
		}
	}
	
	/**
	 * Test decrypt phrase.
	 */
	@Test
	public void testDecryptPhrase(){
		String expectedResult = "password2";
		Security sec = new Security();
		sec.initialise("TestStore");
		FileInputStream fis = null;
		Properties p = new Properties();
		try {
			fis = new FileInputStream(new File("WEB-INF/classes/com/MOJICT/IACFee/config/cpi.properties"));
			p.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} finally {
			if(null != fis){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
					fail();
				}
			}
		}
		String encrypt = p.getProperty("PASSPHRASE");
		String salt = p.getProperty("SALT");
		int iterations = Integer.parseInt(p.getProperty("ITERATIONS"));
		String decrypted = sec.decryptString(encrypt, salt, iterations);
		assertEquals(decrypted, expectedResult);
	}

	/**
	 * Test encrypt decrypt string.
	 */
	@Test
	public void testEncryptDecryptString() {
		Security sec = new Security();
		sec.initialise("TestStore");
		String encryptMe = "PLEASEe;ncrypMe123456789";
		String salt = "123456789x";
		int iterations = 2;
		String expectedEncrypted = sec.encryptString(encryptMe, salt,
				iterations, false);
		String actualEncrypted = sec.encryptString(encryptMe, salt, iterations,
				false);
		assertEquals(expectedEncrypted, actualEncrypted);// should be same both
															// times
		assertEquals(encryptMe,
				sec.decryptString(actualEncrypted, salt, iterations));
		// check that re-initialising doesn't destroy this;
		sec.initialise("TestStore");
		actualEncrypted = sec.encryptString(encryptMe, salt, iterations, false);
		assertEquals(expectedEncrypted, actualEncrypted);// should be same both
															// times
		assertEquals(encryptMe,
				sec.decryptString(actualEncrypted, salt, iterations));
		File f = new File("WEB-INF/classes/com/MOJICT/IACFee/config/cpi.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			Properties props = new Properties();
			props.load(fis);
			String pass = props.getProperty("PASSPHRASE");
			assertTrue(null != pass && pass.length() > 0);
			salt = props.getProperty("SALT");
			assertTrue(null != salt && salt.length() > 0);
			iterations = Integer.parseInt(props.getProperty("ITERATIONS"));
			assertTrue(iterations > 0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Test initialise.
	 */
	@Test
	public void testInitialise() {
		Security sec = new Security();
		sec.initialise("TestStore");
		File f = new File("IAC_CPI_KEYSTORE");
		assertTrue(f.exists());
		f = new File("WEB-INF/classes/com/MOJICT/IACFee/config/DestroyOnRead.properties");
		assertTrue(!f.exists());
		f = new File("WEB-INF/classes/com/MOJICT/IACFee/config/cpi.properties");
		assertTrue(f.exists());
		f.delete();
	}
	
	/**
	 * Test get passphrase.
	 */
	@Test
	public void testGetPassphrase() {
		String expectedResult = "password2";
		assertEquals(expectedResult, Security.getPassPhrase());
	}
}
