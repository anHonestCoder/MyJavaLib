package org.simon.zhao.java.security.keys;

import org.simon.zhao.utils.Base64Util;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author Zhaozhou
 * @date 2017/3/6
 */
public class KeyPairCreator {

	private static final String ALGORITHM_RSA = "RSA";
	private static final String ALGORITHM_DSA = "DSA";

		public static void generateRsaKeys(int length) throws Exception {
			System.out.println("--------------------------generate rsa key pair--------------------------");
			java.security.KeyPairGenerator keyGen = java.security.KeyPairGenerator.getInstance(ALGORITHM_RSA);
			keyGen.initialize(length);
			KeyPair keypair = keyGen.genKeyPair();
			PrivateKey privateKey = keypair.getPrivate();
			System.out.println("rsa private key : \n" + Base64Util.byteArrayToBase64(privateKey.getEncoded()));
			PublicKey publicKey = keypair.getPublic();
			System.out.println();
			System.out.println("rsa public key : \n" + Base64Util.byteArrayToBase64(publicKey.getEncoded()));
		}
}
