package org.simon.zhao.java.main;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * @author Zhaozhou
 * @date 2017/6/7
 */
public class MainTest {

	public void testSubString() {
		/*String s = "0123456789a";
		int length = s.length();

		int start = length - 6;
		System.out.println(StringUtils.substring(s, -15, 100));
		System.out.println(StringUtils.substring(s, -15, 100).length());


		for (int i = 0; i < 10; i++) {
			System.out.println(Math.random());
		}*/

		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, Calendar.JUNE, 21);
		System.out.println(calendar.getTimeInMillis());

	}

	public static void main(String[] args) {
		float   f   =  19.00f;
		DecimalFormat decimalFormat=new DecimalFormat("0.00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
		String p=decimalFormat.format(f);//format 返回的是字符串
		System.out.print(p);
	}
}
