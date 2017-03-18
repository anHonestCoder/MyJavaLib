package org.simon.zhao.java.security.certificate;

import sun.misc.BASE64Encoder;
import sun.security.provider.X509Factory;

import java.io.*;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

/**
 * 解析证书，并提取公钥
 * Created by zhou01.zhao on 2017/2/16.
 */
public class CertificateParser {

	/**
	 * 从二进制证书文件中抽取公钥
	 * @param certFile 二进制证书文件
	 * @return
	 * @throws Exception
	 */
	public static PublicKey extractPubKeyFromBinaryFile(String certFile) throws Exception {
		CertificateFactory certificatefactory= CertificateFactory.getInstance("X.509");
		FileInputStream bais=new FileInputStream(certFile);
		X509Certificate Cert = (X509Certificate)certificatefactory.generateCertificate(bais);
		PublicKey pk = Cert.getPublicKey();
		BASE64Encoder bse=new BASE64Encoder();
		System.out.println("pk:"+bse.encode(pk.getEncoded()));
		return pk;
	}

	/**
	 * 从Base64编码的证书文件中提取公钥
	 * @param certFile Base64编码证书文件
	 * @return
	 * @throws Exception
	 */
	public static PublicKey extractPubKeyFromBase64File(String certFile) throws Exception {


		//证书Base64编码原文
		String certStr = readFromFile(certFile);
		certStr = certStr.replace(X509Factory.BEGIN_CERT, "");
		certStr = certStr.replace(X509Factory.END_CERT, "");
		return extractPubKeyFromBase64(certStr);
	}

	/**
	 * 从base64编码证书中提取公钥
	 * @param base64Cert base64编码证书
	 * @return
	 */
	public static PublicKey extractPubKeyFromBase64(String base64Cert) throws CertificateException {

		byte[] certBytes = Base64.getDecoder().decode(base64Cert);
		ByteArrayInputStream bis=new ByteArrayInputStream(certBytes);

		CertificateFactory certificatefactory= CertificateFactory.getInstance("X.509");
		X509Certificate Cert = (X509Certificate)certificatefactory.generateCertificate(bis);

		PublicKey pk = Cert.getPublicKey();

		BASE64Encoder bse=new BASE64Encoder();
		System.out.println("pk:"+bse.encode(pk.getEncoded()));
		return pk;
	}

	public static String readFromFile(String filename)  {
		String str = "";
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				str += line;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		return str;
	}
}
