package com.MOJICT.IACFee.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

import javax.crypto.SecretKey;

import org.apache.log4j.Logger;

/**
 * Keystore class. Please note although this is written to meet a password store
 * requirement it is unlikely to be able to fulfil that functionality. Instead
 * this will store secret keys which should at least make it more difficult for
 * any hacker
 * 
 * @author WEBTEAM4:turnerdv
 * 
 */
public class KeyStoreHandler {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(KeyStoreHandler.class);

	private String kspassword = "";
	private String keyStoreType = "JCEKS"; // we will use this as the default
											// keystore type - allows secret
											// keys to be stored
	private KeyStore loadedKeyStore = null;
	private String defaultKeyStoreName = "iacKeyStore";
	private String loadedKeyStoreName = null;

	/**
	 * Retrieve an instance of a KeyStore
	 * 
	 * @param keyStoreName
	 * @return if a null argument is supplied then a new KeyStore will be
	 *         generated using the defaultKeyStoreName
	 */
	public KeyStore getKeyStore(String keyStoreName) {
		KeyStore ks = null;
		try {
			ks = KeyStore.getInstance(keyStoreType);
		} catch (KeyStoreException e2) {
			logger.error("KeyStoreHandler.getKeyStore", e2);
		}
		FileInputStream fis = null;
		FileOutputStream fod = null;
		try {
			if ("".equals(keyStoreName) || null == keyStoreName) {
				keyStoreName = defaultKeyStoreName;
			}
			fis = new FileInputStream(keyStoreName);
			try {
				ks.load(fis, getPasswordChars());
				this.loadedKeyStoreName = keyStoreName;
				this.loadedKeyStore = ks;
			} catch (NoSuchAlgorithmException e) {
				logger.error("KeyStoreHandler.getKeyStore", e);
			} catch (CertificateException e) {
				logger.error("KeyStoreHandler.getKeyStore", e);
			} catch (IOException e) {
				logger.error("KeyStoreHandler.getKeyStore", e);
			}
		} catch (FileNotFoundException e) {
			try {
				ks.load(null, getPasswordChars());
				fod = new FileOutputStream(keyStoreName);
				ks.store(fod, getPasswordChars());
				this.loadedKeyStoreName = keyStoreName;
				this.loadedKeyStore = ks;
			} catch (FileNotFoundException e1) {
				logger.error("KeyStoreHandler.getKeyStore", e1);
				return null;
			} catch (KeyStoreException ke) {
				logger.error("KeyStoreHandler.getKeyStore", ke);
			} catch (NoSuchAlgorithmException ne) {
				logger.error("KeyStoreHandler.getKeyStore", ne);
			} catch (CertificateException ce) {
				logger.error("KeyStoreHandler.getKeyStore", ce);
			} catch (IOException ie) {
				logger.error("KeyStoreHandler.getKeyStore", ie);
			}
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error("KeyStoreHandler.getKeyStore", e);
				}
			}
			if (null != fod) {
				try {
					fod.close();
				} catch (IOException e) {
					logger.error("KeyStoreHandler.getKeyStore", e);
				}
			}
		}
		return ks;
	}

	/**
	 * Retrieve the KeyStore password as a char array. If the password has not
	 * been explicitly set by the calling code then the default password decided
	 * by the development team will be used.
	 * 
	 * @return the result of calling toChar() on the KeyStore password
	 */
	public char[] getPasswordChars() {
		return kspassword.toCharArray();
	}

	/**
	 * Set the KeyStore password
	 */
	public void setPassword(String newKSPassword) {
		this.kspassword = newKSPassword;
	}

	/**
	 * Retrieve the private key
	 * 
	 * @param keyStoreName
	 * @param alias
	 * @param optionalKeystorePassword
	 * @return
	 */
	public SecretKey getSecretKey(String keyStoreName, String alias, String optionalKeystorePassword) {
		initKeyStore(keyStoreName, optionalKeystorePassword);
		SecretKey mySecretKey = null;
		try {
			mySecretKey = (SecretKey) loadedKeyStore.getKey(alias, this.getPasswordChars());
		} catch (NoSuchAlgorithmException e) {
			logger.error("KeyStoreHandler.getKeyStore", e);
		} catch (UnrecoverableEntryException e) {
			logger.error("KeyStoreHandler.getKeyStore", e);
		} catch (KeyStoreException e) {
			logger.error("KeyStoreHandler.getKeyStore", e);
		}
		return mySecretKey;
	}

	/**
	 * Store a given secret key
	 * 
	 */
	public void storeSecretKey(SecretKey sKey, String keyStoreName, String alias, String optionalKeystorePassword) {
		initKeyStore(keyStoreName, optionalKeystorePassword);
		KeyStore.SecretKeyEntry skEntry = new KeyStore.SecretKeyEntry(sKey);
		FileOutputStream fod = null;
		try {
			fod = new FileOutputStream(loadedKeyStoreName);
			loadedKeyStore.setEntry(alias, skEntry, getPP());
			loadedKeyStore.store(fod, getPasswordChars());
			fod.close();
		} catch (KeyStoreException e) {
			logger.error("KeyStoreHandler.storeSecretKey", e);
		} catch (FileNotFoundException e) {
			logger.error("KeyStoreHandler.storeSecretKey", e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("KeyStoreHandler.storeSecretKey", e);
		} catch (CertificateException e) {
			logger.error("KeyStoreHandler.storeSecretKey", e);
		} catch (IOException e) {
			logger.error("KeyStoreHandler.storeSecretKey", e);
		} finally {
			if (null != fod) {
				try {
					fod.close();
				} catch (IOException e) {
					logger.error("KeyStoreHandler.storeSecretKey", e);
				}
			}
		}
	}

	/**
	 * Load the KeyStore
	 * 
	 * @param keyStoreName
	 * @param optionalKeystorePassword
	 */
	private void initKeyStore(String keyStoreName, String optionalKeystorePassword) {
		if (null == loadedKeyStore) {
			if (null != optionalKeystorePassword) {
				setPassword(optionalKeystorePassword);
			}
			loadedKeyStore = getKeyStore(keyStoreName);
		}
	}

	/**
	 * Retrieve a PasswordProtection element generated from the KeyStore
	 * password
	 * 
	 * @return
	 */
	private KeyStore.PasswordProtection getPP() {
		return new KeyStore.PasswordProtection(getPasswordChars());
	}

	/**
	 * Retrieve the name of the currently loaded KeyStore
	 */
	public String getLoadedKeyStoreName() {
		return loadedKeyStoreName;
	}
}
