package org.simon.zhao.java.security.certificate;

import org.junit.Test;

import java.security.PublicKey;

/**
 * Created by zhou01.zhao on 2017/2/16.
 */
public class CertificateParasTest {

	@Test
	public void testExtractPubKeyFromBinary() {
		try {
			PublicKey pubKey = CertificateParser.extractPubKeyFromBinaryFile("E:\\work\\openssl\\test\\domain.crt");
			assert pubKey != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testExtractPubKeyFromBase64File() {
		try {
			PublicKey pubKey = CertificateParser.extractPubKeyFromBase64File("cert/alipay.cer");
			assert pubKey != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
