package datastructure;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Collections.synchronizedMap() and ConcurrentHashMap both provide thread-safe operations on collections of data.
 */
public class SynchronizedConcurrentMap {
	
	public void test() {
		
		/*
		 * In ConcurrentHashMap, read operations are non-blocking, whereas write operations take a lock on a particular segment or bucket. 
		 * The default bucket or concurrency level is 16, which means 16 threads can write at any instant after taking a lock on a segment or bucket.
		 */
		ConcurrentHashMap<Integer, String> cmap = new ConcurrentHashMap<>();
		
		HashMap<Integer, String> map = new HashMap<>();
		/*
		 * SnchronizedMap() returns a synchronized Map backed by the Map that we provide in the parameter. 
		 * To provide thread-safety, synchronizedMap() allows all accesses to the backing Map via the returned Map.
		 */
		map = (HashMap<Integer, String>) Collections.synchronizedMap(map);
	}
	
	/*
	 * ConcurrentHashMap vs Collections.synchronizedMap()
	 * 
	 * => ConcurrentModificationException
	 * -> If we try to update a synchronizedMap() while iterating over it, we will receive a ConcurrentModificationException.
	 * 		(because it internally using the passed map only, and synchronizedMap() makes all the methods of the passed map synchronized
	 * 		but the iterator can still throw ConcurrentModificationException)
	 * -> However, this is not the case with ConcurrentHashMap.
	 * 
	 * => Null Support
	 * -> Collections.synchronizedMap(), null support depends on the input Map. We can have one null as a key and any number of null values 
	 * 		when Collections.synchronizedMap() is backed by HashMap or LinkedHashMap, whereas if we’re using TreeMap, 
	 * 		we can have null values but not null keys.
	 * -> ConcurrentHashMap doesn’t allow null in keys or values.
	 * 		Because:
	 * 		1. Null values are often used to represent the absence of a value. In a concurrent data structure like ConcurrentHashMap, 
	 * 			distinguishing between a null value and the absence of a value becomes ambiguous. If a null value were allowed, 
	 * 			it would be unclear whether a key associated with a null value is absent from the map or explicitly mapped to null.
	 * 		2. By disallowing null keys and values, the implementation can help prevent unintentional null pointer exceptions. 
	 * 			For example, if a developer mistakenly tries to use null as a key or value, the ConcurrentHashMap will throw a NullPointerException, 
	 * 			making the issue more apparent and easier to debug.
	 * 		3. Allowing nulls would introduce special cases in the implementation to handle null keys or values differently from non-null ones. 
	 * 			This could complicate the code and potentially lead to inconsistencies.
	 * 
	 * => ConcurrentHashMap performs better than Collections.synchronizedMap(). (Because of no lock for reading, and segment locking for write) 
	 * 
	 * When to use?
	 * => We should favor Collections.synchronizedMap() when data consistency is of utmost importance, 
	 * 		and we should choose ConcurrentHashMap for performance-critical applications where there are far more write operations 
	 * 		than there are read operations.
	 * 	This is because the Collections.synchronizedMap() requires each thread to acquire a lock on the entire object for both read/write operations. 
	 * 		By comparison, the ConcurrentHashMap allows threads to acquire locks on separate segments of the collection, 
	 * 		and make modifications at the same time.
	 * 
	 */

}
