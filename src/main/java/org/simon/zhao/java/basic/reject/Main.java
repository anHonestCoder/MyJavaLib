package org.simon.zhao.java.basic.reject;

/**
 * Created by zhou01.zhao on 2017/1/16.
 */
public class Main {
	public static void main(String[] args) {
		RejectHandler handler = new DefaultRejectHandler();
		handler.handle();
		RejectHandler handler1 = (CustomRejectHandler)handler;
		handler1.handle();
	}
}
