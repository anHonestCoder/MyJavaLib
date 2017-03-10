package org.simon.zhao.java.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhou01.zhao on 2017/1/5.
 */
public class Test {
	public static void main(String[] args) {
//		Operation operation = Operation.DIVIDE;
//		Operation operation2 = Operation.DIVIDE;
//		Operation operation3 = Operation.MINUS;

		Date date = new Date(1483587380748l);
		Date date2 = new Date(1483587381748l);
		DateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String str = format.format(date);
		System.out.println(str);


		System.out.println(format.format(date2));

		String strNum = "0123456789";
		System.out.println(strNum.substring(0, 1));
		System.out.println(strNum.substring(2));

		String ts = System.currentTimeMillis() + "";
		System.out.println(ts);


	}
}
