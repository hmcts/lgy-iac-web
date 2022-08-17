package com.MOJICT.IACFee.Util;

import java.security.*;
import javax.crypto.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

class RSA {

	public static void main(String[] args) throws NoSuchAlgorithmException,

	InvalidKeyException, IllegalBlockSizeException, NoSuchProviderException,

	BadPaddingException, NoSuchPaddingException {

		/* Generate a RSA key pair */

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");

		keyGen.initialize(1024, random);

		KeyPair pair = keyGen.generateKeyPair();
		PrivateKey priv = pair.getPrivate();
		PublicKey pub = pair.getPublic();

		/* Create the cipher */
		Cipher rsaCipher = Cipher.getInstance("RSA");

		// Initialize the cipher for encryption
		rsaCipher.init(Cipher.ENCRYPT_MODE, pub);

		// Cleartext
		byte[] cleartext = null;
		cleartext = "hi".getBytes();
		System.out.println(cleartext.toString()); // This will print the

													// address
		String theString = new String(cleartext);
		System.out.println(theString); // This will print

		// logger.debug("the original cleartext is: " + cleartext);

		// Encrypt the cleartext
		byte[] ciphertext = null;
		ciphertext = rsaCipher.doFinal(cleartext);
		String theEncText = new String(cleartext);
		// byte[] ciphertext = rsaCipher.doFinal(cleartext);
		// String ciphertext = rsaCipher.doFinal(cleartext);
		  StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < ciphertext.length; i++) {
	            sb.append(Integer.toString((ciphertext[i] & 0xff) + 0x100, 16).substring(1));
	        }
	      System.out.println(sb.toString()); 
		//logger.debug("the encrypted text is: " + new String(Hex.encodeHex(ciphertext)));
		//String encryptMe = Base64.encodeBase64String(ciphertext);
		//logger.debug(encryptMe);

		// Initialize the same cipher for decryption
		rsaCipher.init(Cipher.DECRYPT_MODE, priv);

		// Decrypt the ciphertext
		byte[] cleartext1 = rsaCipher.doFinal(ciphertext);
		String theText = new String(cleartext1);
		// String cleartext1 = rsaCipher.doFinal(ciphertext);
		System.out.println("the final cleartext is: " + theText);
		// logger.debug("the final cleartext is: " + cleartext1);
	}

}
