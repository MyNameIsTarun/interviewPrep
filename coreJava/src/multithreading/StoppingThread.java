package multithreading;

public class StoppingThread {

	public static void main(String[] args) {
		
		System.out.println("Main thread starts\n");
		
		Thread thread = new Thread(() -> {
			System.out.println("child thread running.");
			
			for(int i=0; i<5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("... child thread");
			}
		});
		
		// because the above thread is set to daemon, the JVM will not wait for this Daemon thread to terminate
		// it will close/terminate the application as soon as the main thread terminates
		/*
		 * Output when not set to Daemon: (waiting for child thread)
		 * 
		 * Main thread starts
		 * Main thread terminates
		 * child thread running.
		 * ... child thread
		 * ... child thread
		 * ... child thread
		 * ... child thread
		 * ... child thread
		 * 
		 * Output when set to Daemon: (not waiting for child thread)
		 * 
		 * Main thread starts
		 * Main thread terminates
		 * child thread running.
		 */
		thread.setDaemon(true);
		thread.start();
		
		// Using join we are stopping the main thread and allowing the child thread to execute and when the child thread terminates
		// then only the main thread will resume its execution
		// this happens also when the child thread is set to Daemon
		// we're calling join on the target thread object (child thread here) for which we want to stop this/current thread (main in this eg)
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		for(int i=0; i<5; i++) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("... main thread");
//		}
		
		Thread thread1 = new Thread(() -> {
			while(!Thread.interrupted()) {
				System.out.println("Inside thread1, interrupt demo");
			}
			
			System.out.println("thread1 terminated, this thread is interrupted.");
		});
		
		thread1.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread1.interrupt();
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nMain thread terminates");
	}

}
