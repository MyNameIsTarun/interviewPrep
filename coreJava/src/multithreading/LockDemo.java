package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Java Lock interface represents a lock which can guard a critical section so that only one thread can enter this critical section
 * at a time.
 */
public class LockDemo {

	public static void main(String[] args) {
		
		Counter count = new Counter();
		
		Thread thread1 = new Thread(getRunnable(count));
		Thread thread2 = new Thread(getRunnable(count));
		
		thread1.start();
		thread2.start();

	}
	
	public static Runnable getRunnable(Counter counter) {
		return () -> {
			for(int i=0; i<1_000_000; i++) {
				counter.incCounter();
			}
			
			System.out.println(counter.getCounter());
		};
	}
	
	private static class Counter {
		private int counter = 0;
		
		/*
		 * ReentrantLock is a lock which allows a thread to re lock the same critical section multiple number of times
		 * to unlock the lock the thread has to unlock it as many number of times as the number of locks.
		 * 
		 * For other locks if a thread tries to lock the same critical section again the lock will not allow the thread to relock
		 * and will go in deadlock
		 * 
		 * Passing true in the parameter ensures fairness in allowing waiting threads to acquire the lock, it works on first come first serve basis
		 * helps in ensuring no starvation for any thread, default value is false which does not guarantee fairness in threads acquiring locks. 
		 * fairness in threads execution causes extra overhead.
		 */
		Lock lock = new ReentrantLock(true);
		
		public void incCounter() {
			try {
				lock.lock();
				counter++;
			}
			finally {
				lock.unlock();
			}
		}
		
		public int getCounter() {
			try {
				lock.lock();
				return counter;
			}
			finally {
				lock.unlock();
			}
		}
	}

}

/*
 * Difference between lock and synchronized block?
 * => Synchronized blocks must be contained within a single method.
 * 		lock.lock() and lock.unlock() can be called from different methods.
 * => lock.lock() and lock.unlock() provides the same visibility and happens before guarantees as entering
 * 		and exiting a synchronized block.
 * => Synchronized blocks are always reentrant. Lock could decide not to be.
 * => Synchronized blocks do not guarantee fairness. Locks can.
 * 
 * When there are 100 synchronized methods in a class, only one thread can be executed of these 100 methods at any given point in time. 
 * Only one thread is allowed to access only one method at any given point of time using a synchronized block. This is a very expensive operation. 
 * Locks avoid this by allowing the configuration of various locks for different purpose. One can have couple of methods synchronized under one 
 * lock and other methods under a different lock. This allows more concurrency and also increases overall performance.
 * 
 * https://www.geeksforgeeks.org/lock-framework-vs-thread-synchronization-in-java/
 */


