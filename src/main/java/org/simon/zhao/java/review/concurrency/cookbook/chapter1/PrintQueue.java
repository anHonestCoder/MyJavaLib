package org.simon.zhao.java.review.concurrency.cookbook.chapter1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhou01.zhao on 2016/11/11.
 */
public class PrintQueue {
	private boolean freePrinters[];
	private Lock printerLock;
	private Semaphore semaphore;

	public PrintQueue() {
		freePrinters = new boolean[3];
		for (int i = 0; i < freePrinters.length; i++)
		{
			freePrinters[i] = true;
		}
		this.printerLock = new ReentrantLock();
		this.semaphore = new Semaphore(3);
	}

	public void print(Object document) {
		try {
			semaphore.acquire();
			int i = getPrinter();
			long duration = (long) (Math.random()*10);
			System.out.printf("%s: PrintQueue: Printing a jog in Printer %d during % %d seconds", Thread.currentThread().getName(), i, duration);
			TimeUnit.SECONDS.sleep(duration);
			freePrinters[i] = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private int getPrinter() {
		int r = -1;
		printerLock.lock();
		for (int i = 0; i < freePrinters.length; i++) {
			if (freePrinters[i]) {
				r = i;
				freePrinters[i] = false;
				break;
			}
		}
		printerLock.unlock();
		return r;
	}

}
