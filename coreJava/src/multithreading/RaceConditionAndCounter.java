package multithreading;

/*
 * Race Condition is a situation where two or more threads access the same variable(s) (or data) in a way where the final result
 * stored in the variable depends on how thread access to the variables is scheduled.
 * 
 * Race Conditions occur when
 * 		- Two or more threads read and write the same variable(s) or data concurrently.
 * 		- The threads access the variables(s) using either of these patterns:
 * 			- Check then act. (doing something after an if statement eg. singleton pattern checking (instance == null) two threads can enter this if)
 * 			- Read modify write.
 * 				- Where the modified value depends on the previously read value (Counter eg).
 * 		- The thread access to the variable(s) or data is not atomic.
 *
 */
public class RaceConditionAndCounter {

	public static void main(String[] args) {
		
		Counter count = new Counter();
		
		Thread thread1 = new Thread(getRunnable(count));
		Thread thread2 = new Thread(getRunnable(count));
		
		
		thread1.start();
		thread2.start();

	}
	
	private static Runnable getRunnable(Counter count) {
		return () -> {
			for(int i=0; i<1_000_000; i++) {
				count.inc();
			}
			
			System.out.println(count.get());
		};
	}

}

class Counter {
	private long counter = 0;
	
	/*
	 * if inc() is not synchronized then this will cause Race condition as two threads can interfere in each others operation
	 * therefore the counter never reaches 2M
	 * The code where race condition happens is called critical section
	 * 
	 * but if synchronize this critical section means making this whole inc operation atomic we can save it from race condition
	 */
	
	public synchronized void inc() {
		counter++;
	}
	
	public long get() {
		return counter;
	}
}
