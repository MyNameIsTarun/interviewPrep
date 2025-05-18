package multithreading;

/*
 * Happens Before Guarantee
 * 		- A set of restrictions on instruction reordering to avoid instruction reordering breaking the java visibility guarantees
 * 
 * => Volatile instance/variables directly flush the changes/updates to the main memory, they dont just keep this changes to their local memory
 * Similarly as they are volatile their values are read from the main memory directly not just from the thread local copies
 * it is not required to make all variables volatile, make only those which are changed/frequently as when the write operation happen
 * on this volatile variable it will flush itself and also the non volatile variables to the main memory
 * similarly when the read happens for volatile variables the thread will also read the values of other non volatile variables from the main memory
 * 
 * By declaring a variable volatile you tell JVM that this variable should be read directly from the main memory, and when changed should be
 * immediately updated on the main memory 
 * 
 * Position of operation involving volatile variable matters, as as soon as statement involving volatile variable executes for write operation
 * JVM immediately updates all the visible variables (volatile and non-volatile) values to the main memory, so it is recommended to have 
 * volatile variable operation at the end so that it flushes the updated values of all the variables to the main memory.
 * similarly for read operation it is recommended to have the statement involving volatile variable at the top so it reads values of all the visible
 * variables directly from the main memory and then processes further.
 * 
 * when we follow above recommendations: (here we are talking about internal cpu/compiler reordering operations for optimization) 
 * It is guaranteed that the write on the volatile variable will happen after the write to all other non-volatile variables
 * although cpu/compiler may reorder the write operation of other non-volatile variables themselves but it is guaranteed that the write to volatile
 * variable will happen in the end and eventually the updated values of all volatile and non-volatile variables will be updated in the main memory
 * for read operation it is guaranteed that the volatile variable is read first, before all non-volatile variables so that all the volatile and 
 * non-volatile variables values are read from the main memory directly before they used
 * 
 * Synchronized block:
 * When the thread enters the synchronized block it first refreshes all the values of variables involved in the synchronized block
 * and then it does the operations on those variables inside the block and when the thread exists the block it flushes all the updated
 * values to the main memory, here all the variables are required to be inside the synchronized block otherwise for the variables outside
 * the synchronized block things can not be guaranteed
 * 
 * => Synchronized blocks/methods are blocks/methods of code which can only be executed by one thread at a time
 * synchronized keyword can be used with methods and blocks (it makes code atomic in terms of threads)
 * 
 * synchronized methods implicitly synchronize the instance of the class in which they are defined
 * But synchronized blocks can be synchronized on any object specified in the brackets
 * 
 * if synchronized is used with static methods then it will synchronize the whole class (means all the objects of that class)
 * not just a particular instance
 * for synchronized blocks which are created inside the static methods we can achieve the same synchronization by having classname.class
 * as monitor obj
 * 
 * => Limitations of synchronized block
 * 		- Only one thread can enter a synchronized block at a time.
 * 		- There is no guarantee about the sequence in which waiting threads gets access to the synchronized block. (starvation)
 * 
 * => Java synchronized blocks are reentrant, that means the thread which is already inside a synchronized block/method can execute other
 * 		synchronized block/method on the same instance/monitor,as the same thread will execute another synchronized block on the same monitor object.
 * 
 * => sometimes using volatile keyword is just not enough we have to do more
 * 		- for implementing counter, using synchronized keyword is a better/safe/recommended approach
 * 		- because incrementing an int counter is not a atomic operation as it involves 1. read of counter value, 2. update value, 3. write value to
 * 			memory.
 */
public class VolatileSnchronizedKeyword {
	
	private int x;
	
	private int counter = 0;

	public static void main(String[] args) {
		
		VolatileSnchronizedKeyword obj = new VolatileSnchronizedKeyword();
		
		Thread thread1 = new Thread(() -> {
			for(int i=1; i<=100; i++) {
				System.out.println("setObject");
				obj.setObject(i);
			}
		});
		
		Thread thread2 = new Thread(() -> {
			for(int i=1; i<=100; i++) {
				System.out.println(obj.getObject());
			}
		});
		
//		thread1.start();
//		thread2.start();
		
		Thread thread3 = new Thread(() -> {
			obj.reentrance();
		});
		
//		thread3.start();
		
		System.out.println("\n-------------- synchronized block eg ------------------");
		Thread thread4 = new Thread(() -> {
			for(int i=0; i<1_000_000; i++) {
				obj.incCounter();
			}
			System.out.println(obj.getCounter());
		});
		Thread thread5 = new Thread(() -> {
			for(int i=0; i<1_000_000; i++) {
				obj.incCounter();
			}
			System.out.println(obj.getCounter());
		});
		
		thread4.start();
		thread5.start();
		
		/*
		 * Without synchronized block the result is 305461, 1129077, none of the threads reaches 2_000_000
		 * 		as the values are not immediately reflected in the main memory, neither they are immediately updated from the main memory
		 * 		some iterations of the loop are just overriding values that is wasted.
		 * With synchronized block the result is 1568206, 2000000, at least 2nd thread always reaches 2_000_000
		 * 		values are immediately reflected in the main memory
		 */

	}
	
	/*
	 * In the below example all these synchronized methods and blocks are on the same *monitor* i.e. "this" (instance) in this case
	 * therefore if one method enters any of the synchronized block or method then no other method can enter any of the other synchronized
	 * blocks and methods *for the same" object
	 * But on diff object/instance other threads can execute any synchronized block or method
	 */
	
	public synchronized int getObject() {
		return x;
	}
	
	public synchronized void getObj() {
		
	}
	
	public void setObject(int i) {
		synchronized(this) {
			x = i;
		}
		
	}

	public void setObj() {
		synchronized(this) {
			System.out.println("do something");
		}
		
	}
	
	/*
	 * Reentrance block example
	 */
	
	public synchronized void inc() {
		System.out.println("do something");
	}
	
	public synchronized void reentrance() {
		inc();
		System.out.println("do somemore");
	}
	
	/*
	 * synchronized demo
	 */
	
	public synchronized int getCounter() {
		return counter;
	}
	
	public synchronized void incCounter() {
		counter++;
	}
}

/*
 * In some cases, we may only desire visibility and not atomicity. The use of synchronized in such a situation is overkill and may cause 
 * scalability problems. Here volatile comes to the rescue. Volatile variables have the visibility features of synchronized but not the 
 * atomicity features. The values of the volatile variable will never be cached and all writes and reads will be done to and from the main memory. 
 * However, the use of volatile is limited to a very restricted set of cases as most of the times atomicity is desired. For example, a simple 
 * increment statement such as x = x + 1; or x++ seems to be a single operation but is really a compound read-modify-write sequence of operations 
 * that must execute atomically. 
 */
