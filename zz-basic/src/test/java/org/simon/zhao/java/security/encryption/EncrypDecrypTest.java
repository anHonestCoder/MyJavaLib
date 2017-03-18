package org.simon.zhao.java.security.encryption;

import org.junit.Test;
import org.simon.zhao.utils.Base64Util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * Created by zhou01.zhao on 2016/12/26.
 */
public class EncrypDecrypTest {


	@Test
	public void testEncryption() throws IOException, GeneralSecurityException {
		String plainText = "赵洲";
		PublicKey publicKey = PemRSAParser.getPublicKey("keys/pair_02/public.pem");
		String cipherText = PemRSAParser.encrypt(plainText, publicKey);
		System.out.println(cipherText);
	}

	@Test
	public void testDecryption() throws IOException, GeneralSecurityException {
		String plainText = "赵洲";
		PublicKey publicKey = PemRSAParser.getPublicKey("keys/pair_02/public.pem");
		String cipherText = PemRSAParser.encrypt(plainText, publicKey);
		PrivateKey privateKey = PemRSAParser.getPrivateKey("keys/pair_02/priv8.pem");
		System.out.println(PemRSAParser.decrypt(cipherText, privateKey));
	}


	@Test
	public void testBase64() throws UnsupportedEncodingException {
		String plainText = "abcd";
		String base64Util = Base64Util.byteArrayToBase64(plainText.getBytes("utf-8"));
		String javaBase64 = Base64.getEncoder().encodeToString(plainText.getBytes("utf-8"));
		System.out.println(base64Util.equals(javaBase64));
	}
}
