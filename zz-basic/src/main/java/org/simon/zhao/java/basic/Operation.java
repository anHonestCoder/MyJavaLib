package org.simon.zhao.java.basic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhou01.zhao on 2017/1/5.
 */
public enum Operation {
	PLUS("+"),
	MINUS("-"),
	TIMES("*"),
	DIVIDE("/");
	private final String symbol;
	private static final int a = 1;
	private static final Date date = new Date();

	static {
		System.out.printf("static block");
	}

	private static final Map<String, Operation> stringToEnum = new HashMap<>();

	Operation(String symbol) {
		this.symbol = symbol;
		System.out.println("constructor, " + symbol + ", " + a);
//		System.out.printf(date);
//		stringToEnum.put(this.toString(), this);
	}
}
