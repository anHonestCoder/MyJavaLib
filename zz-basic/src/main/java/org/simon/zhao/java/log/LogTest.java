package org.simon.zhao.java.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhou01.zhao on 2016/12/29.
 */
public class LogTest {

	private static final Logger LOG = LoggerFactory.getLogger(LogTest.class);
	public static void main(String[] args) {
		try {
			ttt();
		} catch (ArithmeticException e) {
			System.out.println(e);

			LOG.error("", new NullPointerException());
		}
	}

	private static void ttt() {
		int a = 8 / 0;
	}
}
