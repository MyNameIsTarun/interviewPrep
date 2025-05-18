package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Java ExecutorService is a thread pool where we can submit task for concurrent execution
 */
public class ExecutorServiceDemo {

	public static void main(String[] args) {
		
		System.out.println("=============== Executors.newFixedThreadPool ================");
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		/*
		 * There is no guarantee in what sequence this tasks will be executed by threads
		 */
		executorService.execute(newRunnable("newFixedThreadPool Task 1"));
		executorService.execute(newRunnable("newFixedThreadPool Task 2"));
		executorService.execute(newRunnable("newFixedThreadPool Task 3"));
		executorService.execute(newRunnable("newFixedThreadPool Task 4"));
		
		executorService.shutdown();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n=============== ThreadPoolExecutor ================");
		
		int corePoolSize = 3; // initial number of threads
		int maximumPoolSize = 10; // max number of threads (dynamically increases threads (makes threads active) to handle high tasks traffic)
		long keepAliveTime = 3000; // after this time unused threads will become un-active (corePoolSize number of threads will always remain active)
		TimeUnit unit = TimeUnit.MILLISECONDS; 
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100); // queue that holds tasks to be run by threads, at most can have 100 tasks
		
		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		
//		threadPoolExecutor.execute(newRunnable("ThreadPoolExecutor Task 1"));
//		threadPoolExecutor.execute(newRunnable("ThreadPoolExecutor Task 2"));
//		threadPoolExecutor.execute(newRunnable("ThreadPoolExecutor Task 3"));
//		threadPoolExecutor.execute(newRunnable("ThreadPoolExecutor Task 4"));
		
		for(int i=0; i<100; i++) {
			threadPoolExecutor.execute(newRunnable("ThreadPoolExecutor Task " + i));
		}
		
		threadPoolExecutor.shutdown();
		
	}
	
	private static Runnable newRunnable(String msg) {
		return () -> {
			String taskMsg = Thread.currentThread().getName() + ": " + msg;
			System.out.println(taskMsg);
		};
	}

}
