package org.simon.zhao.java.security.encryption;

/**
 * Created by zhou01.zhao on 2016/8/1.
 *
 * 解析PEM格式的秘钥
 */

import org.simon.zhao.utils.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class PemRSAParser {

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "SHA1WITHRSA";

	private static final Logger LOG = LoggerFactory.getLogger(PemRSAParser.class);
	public static String readKeyFromFile(String filename) {
		// Read key from file
		String strKeyPEM = "";
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				strKeyPEM += line + "\n";
			}
		} catch (IOException e) {
			System.out.println("can not find key file.");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		strKeyPEM = strKeyPEM.replace("-----BEGIN RSA PRIVATE KEY-----\n", "");
		strKeyPEM = strKeyPEM.replace("-----BEGIN PRIVATE KEY-----\n", "");
		strKeyPEM = strKeyPEM.replace("-----END RSA PRIVATE KEY-----", "");
		strKeyPEM = strKeyPEM.replace("-----END PRIVATE KEY-----", "");
		strKeyPEM = strKeyPEM.replace("-----BEGIN PUBLIC KEY-----\n", "");
		strKeyPEM = strKeyPEM.replace("-----END PUBLIC KEY-----", "");
		return strKeyPEM;
	}


	public static RSAPrivateKey getPrivateKey(String filename) {
		String privateKeyPEM = readKeyFromFile(filename);
		return getPrivateKeyFromString(privateKeyPEM);
	}

	public static RSAPrivateKey getPrivateKeyFromString(String key) {
		String privateKeyPEM = key;
		privateKeyPEM = privateKeyPEM.replace("-----BEGIN RSA PRIVATE KEY-----\n", "");
		privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----\n", "");
		privateKeyPEM = privateKeyPEM.replace("-----END RSA PRIVATE KEY-----", "");
		privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
		privateKeyPEM = privateKeyPEM.replace("\n", "");
		byte[] decoded = new byte[0];

		RSAPrivateKey privKey = null;
		try {
			decoded = Base64Util.base64ToByteArray(privateKeyPEM);
			KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
			privKey = (RSAPrivateKey) kf.generatePrivate(keySpec);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return privKey;
	}


	public static RSAPublicKey getPublicKey(String filename) {
		String publicKeyPEM = readKeyFromFile(filename);
		return getPublicKeyFromString(publicKeyPEM);
	}

	public static RSAPublicKey getPublicKeyFromString(String key) {
		String publicKeyPEM = key;
		publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----\n", "");
		publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");
		publicKeyPEM = publicKeyPEM.replace("\n", "");
		byte[] decoded = new byte[0];
		KeyFactory kf = null;
		RSAPublicKey pubKey = null;
		try {
			decoded = Base64Util.base64ToByteArray(publicKeyPEM);
			kf = KeyFactory.getInstance(KEY_ALGORITHM);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
			pubKey = (RSAPublicKey) kf.generatePublic(new X509EncodedKeySpec(decoded));
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return pubKey;
	}


	public static String sign(PrivateKey privateKey, String message) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
		Signature sign = Signature.getInstance(SIGNATURE_ALGORITHM);
		sign.initSign(privateKey);
		sign.update(message.getBytes("UTF-8"));
		return Base64Util.byteArrayToBase64(sign.sign());
	}


	public static boolean verify(PublicKey publicKey, String message, String signature) throws SignatureException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		Signature sign = Signature.getInstance(SIGNATURE_ALGORITHM);
		sign.initVerify(publicKey);
		sign.update(message.getBytes("UTF-8"));
		return sign.verify((signature.getBytes("UTF-8")));
	}


	public static String encrypt(String rawText, PublicKey publicKey) throws IOException, GeneralSecurityException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return Base64Util.byteArrayToBase64(cipher.doFinal(rawText.getBytes("UTF-8")));
	}


	public static String decrypt(String cipherText, PrivateKey privateKey) throws IOException, GeneralSecurityException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return new String(cipher.doFinal(Base64Util.base64ToByteArray(cipherText)), "UTF-8");
	}

	public static boolean generageKeyPair() throws NoSuchAlgorithmException {

		KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyGenerator.initialize(2048);
		KeyPair keyPair = keyGenerator.generateKeyPair();

		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();


		return false;
	}
}

