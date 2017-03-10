package org.simon.zhao.java.basic.reject;

/**
 * Created by zhou01.zhao on 2017/1/16.
 */
public class CustomRejectHandler implements RejectHandler {
	@Override
	public void priHandle() {
		System.out.println("CustomRejectHandler preHandle");
	}

	@Override
	public void handle() {
		System.out.println("CustomRejectHandler handle");
	}

	@Override
	public void postHandle() {
		System.out.println("CustomRejectHandler postHandle");
	}
}
