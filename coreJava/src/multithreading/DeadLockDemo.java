package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Deadlock is a situation where two threads are waiting for each other to execute a task
 * there are many scenarios where deadlock can happen
 * eg. there are 2 locks acquired by 2 diff threads and now they are trying to acquire each others locks, this is a situation of deadlock as
 * both the threads are waiting for each other to acquire a lock (see the impl below)
 * the problem here is threads are trying to acquire locks in cyclic order
 * This problem can be solved by acquiring the locks in same order, this is also called lock reordering
 * 
 * other examples of deadlock:
 * 	- Situation of Starvation
 * 
 * Ways to prevent/solve deadlocks
 * 		- Lock reordering (avoid acquiring locks in cyclic order, acquire in the same order)
 * 		- Timeout backoff (after some time being in deadlock the thread will backoff from acquiring the lock and it will also release all the 
 * 							locks it already acquired before or held before, then it will go on sleep for some randomizied amount of time and
 * 							then again tries to acquire the locks)
 */
public class DeadLockDemo {

	public static void main(String[] args) {
		
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
		
		Runnable runnable1 = new CustomRunnable1(lock1, lock2);
		Runnable runnable2 = new CustomRunnable2(lock1, lock2);
		
		Thread thread1 = new Thread(runnable1, "thread 1");
		Thread thread2 = new Thread(runnable2, "thread 2");
		
		thread1.start();
		thread2.start();

	}

}

class CustomRunnable1 implements Runnable{
	
	private Lock lock1;
	private Lock lock2;
	
	public CustomRunnable1(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + ": acquring lock 1");
		lock1.lock();
		System.out.println(Thread.currentThread().getName() + ": acquired lock 1\n");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + ": acquring lock 2");
		lock2.lock();
		System.out.println(Thread.currentThread().getName() + ": acquired lock 2\n");
		
		// execution will never reach here
		System.out.println("Unlock lock 1");
		lock1.unlock();
		System.out.println("Unlock lock 2");
		lock2.unlock();
		
	}
}

class CustomRunnable2 implements Runnable{
	
	private Lock lock1;
	private Lock lock2;
	
	public CustomRunnable2(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + ": acquring lock 2");
		lock2.lock();
		System.out.println(Thread.currentThread().getName() + ": acquired lock 2\n");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + ": acquring lock 1");
		lock1.lock();
		System.out.println(Thread.currentThread().getName() + ": acquired lock 1\n");

		// execution will never reach here
		System.out.println("Unlock lock 2");
		lock2.unlock();
		System.out.println("Unlock lock 1");
		lock1.unlock();
		
	}
}
