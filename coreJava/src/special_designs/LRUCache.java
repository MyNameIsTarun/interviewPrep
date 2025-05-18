package special_designs;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * The Least Recently Used (LRU) Cache operates on the principle that the data most recently accessed is likely to be accessed again 
 * in the near future. By evicting the least recently accessed items first, LRU Cache ensures that the most relevant data remains available 
 * in the cache.
 * 
 * A cache is just fast storage. Reading data from a cache takes less time than reading it from something else (like a hard disk).
 * 
 * A cache is required to serve data faster than the time it will take to read from its actual source.
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private final static int DEFAULT_CAPACITY = 10;
	
	private int capacity;
	
	public LRUCache(int capacity) {
		// here 3rd para true means follow "access" order
		// by default it is false that means follow "insertion" order by default
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}
	
	public LRUCache() {
		this(LRUCache.DEFAULT_CAPACITY);
	}
	
	// this method is called from put and putAll methods after inserting the entry in the map
	// so after insertion if the size becomes greater than the this.capacity then it will return true
	// and the last entry will be removed 
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		System.out.println("Eldest: Key="+eldest.getKey()+", Value="+eldest.getValue());
		return size() > capacity;
	}
	
	/*
	 * // Callbacks to allow LinkedHashMap post-actions
    void afterNodeAccess(Node<K,V> p) { }
    void afterNodeInsertion(boolean evict) { }
    void afterNodeRemoval(Node<K,V> p) { }
	 * 
	 * HashMap have these methods defined to be used by LinkedHashMap to do post insertion process 
	 * majorly for the scenario when the access order is used
	 * 
	 * 
	 * LinkedHashMap uses HashMap and doubly linked list both
	 * it uses the Hashmap put() method to store the values as usual in hashmap but it also stores the same entry nodes
	 * in the form of a doubly linked list to maintain insertion/access order
	 * so we can say it requires double memory space than HashMap
	 * 
	 * Applications?
	 * => Used in DB
	 * => In many softwares that requires frequent read operation.
	 * 
	 * Why use linkedhashmap?
	 * => Ease of implementation.
	 * => To promote code reusability.
	 * => To leverage already written optimized code from the java standard library.
	 * => to get access of all the methods provided by the Map interface.
	 * 
	 */

}
