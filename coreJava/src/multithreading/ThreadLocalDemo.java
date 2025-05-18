package multithreading;

/*
 * Thread local is a memory where threads can store data and this data is not shared with other threads, or it is not visible to other threads
 * Multiple threads can share same ThreadLocal instance but they can't see each others data
 */
public class ThreadLocalDemo {

	public static void main(String[] args) {
		
//		threadLocalDemo();
		
		// InheritableThreadLocal class allows child threads to access data set by the parent thread.
		// whereas ThreadLocal class doesn't allow child or any other threads to access data
		inheritableThreadLocal();

	}

	private static void inheritableThreadLocal() {
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		
		Thread thread1 = new Thread(() -> {
			inheritableThreadLocal.set("Parent thread inheritableThreadLocal");
			threadLocal.set("Parnet thread threadLocal");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Thread chiledThread = new Thread(() -> {
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println();
				System.out.println("In child: " + inheritableThreadLocal.get());
				System.out.println("In child: " + threadLocal.get());
			});
			
			chiledThread.start();
			
			System.out.println();
			System.out.println(inheritableThreadLocal.get());
			System.out.println(threadLocal.get());
		});
		
		thread1.start();
	}

	private static void threadLocalDemo() {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		
		Thread thread1 = new Thread(() -> {
			threadLocal.set("thread 1");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(threadLocal.get());
		});
		
		Thread thread2 = new Thread(() -> {
			threadLocal.set("thread 2");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(threadLocal.get());
		});
		
		thread1.start();
		thread2.start();
	}

}
