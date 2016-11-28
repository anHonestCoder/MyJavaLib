package org.simon.zhao.java.review.concurrency.cookbook.chapter1;

/**
 * Created by zhou01.zhao on 2016/11/8.
 */
public class ExceptionHandlerDemo {

	public  static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}

}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("An Exception has been captured.");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s \n", e.getClass().getName(), e.getMessage());
		System.out.println("Stack Trace:");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s \n", t.getState());
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		int numero = Integer.parseInt("ttt");
	}
}
