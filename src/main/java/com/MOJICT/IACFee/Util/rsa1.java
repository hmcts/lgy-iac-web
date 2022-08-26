package com.MOJICT.IACFee.Util;

import java.security.*;
import javax.crypto.*;

class rsa1 {

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
		Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

		// Initialize the cipher for encryption
		rsaCipher.init(Cipher.ENCRYPT_MODE, pub);

		// Cleartext
		String plaintext;
		plaintext = "This is Rohan";
		byte[] cleartext = plaintext.getBytes();
		System.out.println("the original cleartext is: " + plaintext);

		// Encrypt the cleartext
		byte[] ciphertext = null;
		ciphertext = rsaCipher.doFinal(cleartext);
		System.out.println("the encrypted text is: " + new String(ciphertext));

		// Initialize the same cipher for decryption
		rsaCipher.init(Cipher.DECRYPT_MODE, priv);

		// Decrypt the ciphertext
		byte[] cleartext1 = rsaCipher.doFinal(ciphertext);
		System.out.println("the final cleartext is: " + new String(cleartext1));

	}
}