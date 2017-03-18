package org.simon.zhao.java.basic.reject;

/**
 * Created by zhou01.zhao on 2017/1/16.
 */
public class DefaultRejectHandler implements RejectHandler {
	@Override
	public void priHandle() {
		System.out.println("DefaultRejectHandler priHandle");
	}

	@Override
	public void handle() {
		System.out.println("DefaultRejectHandler handle");
	}

	@Override
	public void postHandle() {
		System.out.println("DefaultRejectHandler postHandle");
	}
}
