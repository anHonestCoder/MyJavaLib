package org.simon.zhao.java.mybatis.entity;

/**
 * Created by zhou01.zhao on 2016/11/25.
 */
public class Student {
	private String id;
	private String name;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "id:" + id + "  name:" + name;
	}
}
