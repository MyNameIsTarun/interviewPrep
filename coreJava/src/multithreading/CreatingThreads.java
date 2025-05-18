package multithreading;

/*
 * There are four ways to create threads:
 * 		- Extending thread class
 * 		- Implementing Runnable Interface
 * 		- Creating anonymous class of Runnable
 * 		- Using lambda for Runnable
 * 
 * Using Runnable is preferred
 * If we have multiple threads than it is not guranteed that in which order they will be executed
 * 
 * Threads in Java are managed by the underlying OS, and such threads are often referred to as OS level threads
 * OS level threads are often more heavy as OS assigns 1-2MB of stack space to each thread
 * 
 */
public class CreatingThreads {

	public static void main(String[] args) {
		Thread thread1 = new MyThread1();
		thread1.start();
		
		Runnable runnable = new MyThread2();
		Thread thread2 = new Thread(runnable, "MyThread");
		thread2.start();
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("\n----------------- Method 3 ------------------");
				System.out.println("Anonymous class Runnable");
				System.out.println("Thread Running");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Method 3 Thread Terminated");
			}
		});
		thread3.start();
		
		Thread thread4 = new Thread(() -> {
				System.out.println("\n----------------- Method 4 ------------------");
				System.out.println("Lambda implementation of Runnable");
				System.out.println("Thread Running");
				System.out.println("Thread Terminated");
		});
		thread4.start();

	}

}

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		System.out.println("----------------- Method 1 ------------------");
		System.out.println("Extending Thread class");
		System.out.println("Thread Running");
		System.out.println("Thread Terminated");
	}
}

class MyThread2 implements Runnable {
	
	@Override
	public void run() {
		System.out.println("\n----------------- Method 2 ------------------");
		System.out.println("Implementing Runnable interface");
		System.out.println(Thread.currentThread().getName() + " Thread Running of Method 2");
		System.out.println("Thread Terminated of Method 2");
	}
}
