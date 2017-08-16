package org.simon.zhao.webService.com.demo.client;

import org.dom4j.DocumentException;
import org.junit.Test;

import javax.xml.ws.WebServiceFeature;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author Zhaozhou
 * @date 2017/7/29
 */
public class Client {

	@Test
	public void testClient() throws MalformedURLException, DocumentException {

		String payURL = "classpath:TokenPay.wsdl";
		URL wsUrl = this.getClass().getResource(payURL);
//		URL wsUrl = new URL(payURL);

		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("https.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "8888");
		System.setProperty("https.proxyPort", "8888");

		TokenPayService tokenPayService = new TokenPayService(wsUrl);
		WebServiceFeature wsFeature = null;
//		tokenPayService.getPort(Token.class, )
		TokenPay tokenPay = tokenPayService.getPort(TokenPay.class);

		System.out.println(tokenPay.getClass().getSimpleName());

		String transRequest = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iR0JLIj8+PENGWD48SEVBRD48TVNHSUQ+T2FhczAwMDAwMTAwMTIwMTMxMTI1MTY1OTA0MDAwMDkyPC9NU0dJRD48VVNFUklEPjIwMzk8L1VTRVJJRD48UEFTU1dPUkQ+ZTEwYWRjMzk0OWJhNTlhYmJlNTZlMDU3ZjIwZjg4M2U8L1BBU1NXT1JEPjxUUkFOU1RZUEU+QmluZFRva2VuPC9UUkFOU1RZUEU+PC9IRUFEPjxNU0c+PFJlcXVlc3Q+PENhcmRObz42MjI1NzUwMDA3MTUwMTM1PC9DYXJkTm8+PEV4cGlyeURhdGU+NDIwNzwvRXhwaXJ5RGF0ZT48VG9rZW5NZXJJRD4yMDM5MDE8L1Rva2VuTWVySUQ+PE5hbWU+0say+tK7PC9OYW1lPjxQaG9uZU5vPjE4NzAwMDAwMDAxPC9QaG9uZU5vPjwvUmVxdWVzdD48L01TRz48L0NGWD4=";
		String resp = tokenPay.tokenTrans(transRequest);
		System.out.println(resp);
	}

	@Test
	public void testWebService() throws MalformedURLException{
		String payURL = "http://99.12.68.126/OAASWSDP/services/TokenPay";
		URL wsUrl = new URL(payURL);

		//创建TokenPayService   ws对象
		TokenPayService tokenPayService = new TokenPayService(wsUrl);

		//创建tokenPay对象
		TokenPay tokenPay = tokenPayService.getPort(TokenPay.class);
		System.out.println(tokenPay.getClass());
	}

	public static void main(String[] args) {

	}

	public static void mimicGet(String strUrl) {

		//使程序通过代理服务器（ proxy server ）访问Web
		//代理服务器接收到从本地客户端到远程服务器的请求。代理服务器向远程服务器发出请求，再将结果转发回本地客户端。
		//此处代理服务器就是fiddler

		//在Java代码中调用System.setProperty （）
		//使用纯粹的HTTP代理，将http.proxyHost设置为代理服务器的域名或IP地址

		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("https.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "8888");
		System.setProperty("https.proxyPort", "8888");

		try {
			URL u = new URL(encodeUrl(strUrl));
			try {
				try (InputStream in = new BufferedInputStream(u.openStream())) {
					InputStreamReader theHTML = new InputStreamReader(in);
					int c;
					while ((c = theHTML.read()) != -1) {
						System.out.print((char) c);
					}
				}
			} catch (MalformedURLException ex) {
				System.err.println(ex);
			} catch (IOException ex) {
				System.err.println(ex);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将queryString转换为utf-8编码的16位ASCII字符串
	 * https://www.baidu.com/search?wd=木&rsv_spt=1
	 * @param queryString 为wd=木&rsv_spt=1
	 * @return
	 */
	public static String encodeQueryString(String queryString) {
		StringBuilder sb = new StringBuilder();
		String[] split = queryString.split("&");
		for (String str : split) {
			String[] split1 = str.split("=");
			try {
				sb.append(URLEncoder.encode(split1[0], "utf-8"));
				sb.append("=");
				sb.append(URLEncoder.encode(split1[1], "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			sb.append("&");
		}
		String s = sb.toString();
		return s.substring(0,s.length() - 1);
	}

	/**
	 * 将url字符串转换为utf-8编码的16位ASCII字符串
	 * @param urlStr
	 * @return
	 */
	public static String encodeUrl(String urlStr) {
		int index = urlStr.lastIndexOf("?")+1;
		return urlStr.substring(0, index) + encodeQueryString(urlStr.substring(index));
	}

	@Test
	public void testMimicGet() {
		String str = "http://www.baidu.com/s?wd=木";
		mimicGet(str);
	}
}
