package org.simon.zhao.java.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhou01.zhao on 2017/1/5.
 */
public class Book {
	private int id;
	private String name;

	private static final Map<String, Operation> stringToEnum = new HashMap<>();
	public Book(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Book(Book book) {
		id = book.id;
		name = book.name;
		stringToEnum.put("", Operation.DIVIDE);
	}
}
