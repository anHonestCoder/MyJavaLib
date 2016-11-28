package org.simon.zhao.java.review.concurrency.cookbook.chapter1;

/**
 * Created by zhou01.zhao on 2016/11/3.
 */
public class Calculator implements Runnable{
	private int number;

	public Calculator(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		for(int i = 1; i < 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i*number);
		}
	}
}
