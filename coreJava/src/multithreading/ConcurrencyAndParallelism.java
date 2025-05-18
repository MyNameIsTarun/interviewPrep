package multithreading;

/*
 * Concurrent Execution:  (----- = task, same cpu)
 * CPU1 = thread 1: -----     -----     
 * CPU1 = thread 2:      -----     -----
 * 		=> Making progress on more than one task - seemingly at the same time.
 * 		=> Switching execution from one thread to another is also called context switch.
 * 
 * Parallel Execution: (diff cpu)
 * 		=> making progress on more than one task at the exact same time.
 * CPU1 = thread 1: ---------------
 * CPU2 = thread 2: --------------- 
 * 
 * Parallel Concurrent Execution: (diff cpu)
 * 		=> Making progress on more than one task - seemingly at the same time, on more than one CPU.
 * CPU1 = thread 1: -----     -----     
 * CPU1 = thread 2:      -----     -----
 * 
 * CPU2 = thread 3: -----     -----     
 * CPU2 = thread 4:      -----     -----
 * 
 * Parallelism:
 * 		=> Splitting a single task into subtasks which can be executed in parallel.
 * 
 */
public class ConcurrencyAndParallelism {

	public static void main(String[] args) {

	}

}
