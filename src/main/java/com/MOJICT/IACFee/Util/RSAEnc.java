package com.MOJICT.IACFee.Util;

import java.security.*;
import javax.crypto.*;

class RSAEnc {

	public static void main(String[] args) throws NoSuchAlgorithmException,

	InvalidKeyException, IllegalBlockSizeException, NoSuchProviderException,

	BadPaddingException, NoSuchPaddingException {

		/* Generate a RSA key pair */

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");

		keyGen.initialize(1536, random);

		KeyPair pair = keyGen.generateKeyPair();
		PrivateKey priv = pair.getPrivate();
		PublicKey pub = pair.getPublic();
		
		System.out.println("Public key"+pub);
		System.out.println("private key"+priv);

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


		// Encrypt the cleartext
		byte[] ciphertext = null;
		ciphertext = rsaCipher.doFinal(cleartext);
		String theEncText = new String(cleartext);
		// byte[] ciphertext = rsaCipher.doFinal(cleartext);
		// String ciphertext = rsaCipher.doFinal(cleartext);
		System.out.println("the encrypted text is: " + ciphertext);

		// Initialize the same cipher for decryption
		rsaCipher.init(Cipher.DECRYPT_MODE, priv);

		// Decrypt the ciphertext
		byte[] cleartext1 = rsaCipher.doFinal(ciphertext);
		String theText = new String(cleartext1);
		// String cleartext1 = rsaCipher.doFinal(ciphertext);
		System.out.println("the final cleartext is: " + theText);
		// System.out.println("the final cleartext is: " + cleartext1);
	}

}
