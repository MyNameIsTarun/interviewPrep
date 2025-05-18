package datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TarunMap<K, V> {
	
	private int size;
	private int capacity;
	
	/*
	 * The load factor is the measure that decides when to increase the capacity of the Map.
	 * The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased.
	 * As a general rule, the default load factor (.75) offers a good tradeoff between time and space costs. 
	 * Higher values decrease the space overhead but increase the lookup cost.
	 * Lower load factor value can cause frequent rehashing.
	 */
	private float loadFactor;
	private Node<K, V>[] buckets;
	
	@SuppressWarnings("unchecked")
	public TarunMap() {
		size = 0;
		capacity = 16;
		loadFactor = 0.75f;
		buckets = new Node[capacity];
	}
	
	// best, average = O(1), worst = O(n)
	/*
	 * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key}.)
     * This can be particularly useful in situations where you want to update a value in the map and also perform some action 
     * based on the previous value.
	 */
	public V put(K key, V value) {
		
		V oldValue = get(key);
		
		if(addToBuckets(new Node<K, V>(key, value))) {
			if(++size > (int)capacity*loadFactor) {
				rehash();
			}
		}
		
		return oldValue;
	}
	
	// best, average = O(1), worst = O(max(bucket length))
	public V get(K key) {
		int index = index(key);
		
		Node<K, V> head = buckets[index];
		while(head != null) {
			if((key == null && head.key == null) || head.key.equals(key)) {
				return head.value;
			}
			
			head = head.next;
		}
		
		return null;
	}
	
	public boolean containsKey(K key) {
		int index = index(key);
		
		Node<K, V> head = buckets[index];
		while(head != null) {
			if(head.key.equals(key)) {
				return true;
			}
			
			head = head.next;
		}
		
		return false;
	}
	
	private int index(K key) {
		if(key == null) {
			return 0;
		}
		
		return Math.abs(key.hashCode()) % this.capacity;
	}

	// best, average = O(1), worst = O(max(bucket length))
	public boolean remove(K key) {
		int index = index(key);
		
		if(buckets[index] == null) {
			return false;
		}
		
		if(buckets[index].key.equals(key)) {
			buckets[index] = buckets[index].next;
			size--;
			return true;
		}
		
		Node<K, V> head = buckets[index];
		while(head != null && head.next != null) {
			if(head.next.key.equals(key)) {
				head.next = head.next.next;
				size--;
				return true;
			}
			
			head = head.next;
		}
		
		return false;
	}
	
	// O(n)
	public Set<K> keySet(){
		Set<K> set = new HashSet<K>();
		Node<K, V> head;
		
		for(int i=0; i<capacity; i++) {
			head = buckets[i];
			while(head != null) {
				set.add(head.key);
				head = head.next;
			}
		}
		
		return set;
	}
	
	public Set<Node<K, V>> entrySet(){
		Set<Node<K, V>> set = new HashSet<>();
		
		for(Node<K, V> node : buckets) {
			while(node != null) {
				set.add(node);
				node = node.next;
			}
		}
		
		return set;
	}
	
	/*
	 * Rehashing is the process of re-calculating the hash code of already stored entries.
	 */
	private void rehash() {
		Node<K, V>[] temp = Arrays.copyOf(buckets, capacity);
		capacity = capacity*2;
		buckets = new Node[capacity];
		
		for(Node<K, V> node : temp) {
			while(node != null) {
				addToBuckets(node);
				node = node.next;
			}
		}
		
	}

	private boolean addToBuckets(Node<K, V> node) {
		int index = index(node.key);
		
		if(buckets[index] == null) {
			buckets[index] = node;
		}
		else {
			Node<K, V> head = buckets[index];
			while(head.next != null) {
				if(head.key.equals(node.key)) {
					head.value = node.value;
					return false;
				}
				head = head.next;
			}
			
			if((node.key == null && head.key == null) || head.key.equals(node.key)) {
				head.value = node.value;
				return false;
			}
			else {
				head.next = node;
			}
		}
		return true;
		
	}
	
	public int size() {
		return this.size;
	}
	
	public int capacity() {
		return this.capacity;
	}


	public static class Node<K, V>{
		private K key;
		private V value;
		private Node<K, V> next;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Entry [key=" + key + ", value=" + value + "]";
		}
	}
	
	// key 16 32 48, cap = 16, index = 0
	// key 16 32 48, cap = 32, 16, 0, 16
	
	/*
	 * what is generics?
	 * => Generics provide compile-time type checking, reducing the chances of runtime errors related to type mismatches.
	 * => You can write classes and methods that work with any data type, promoting code reuse.
	 * => Generics make code more readable by expressing the intent of the code in a generic way.
	 * 
	 * What is HashMap? its application?
	 * => Data Retrieval: HashMap is efficient for retrieving values based on their keys. The hash table allows for constant-time average 
	 * 		complexity for lookups.
	 * => Caching: HashMap is used in caching mechanisms where the result of expensive operations is stored in the map with an associated key 
	 * 		for quick retrieval.
	 * => Implementation of Databases: Some databases use hash-based indexes for quick access to records.
	 * => Frequency Counting: HashMap is often used to count the frequency of elements in a collection.
	 * => Implementation of other Collection Classes: HashMap is used internally in the implementation of other collection classes like HashSet.
	 * 
	 * what is loadfactor?
	 * => In Java's HashMap, the "load factor" is a parameter that determines when to increase the capacity of the hash table. 
	 * 
	 * what is the use of hashcode and equals method in hashmap?
	 * => In a HashMap, when you try to retrieve a value associated with a key, the hash code of the key is used to determine the bucket, 
	 * => and then the equals method is used to locate the exact key within the bucket.
	 * 
	 * what happen if we dont override one of them?
	 * 
	 * what is the contract between them?
	 * => If two objects are equal (according to the equals method), their hash codes must be equal. 
	 * => However, the opposite is not required — objects with equal hash codes are not necessarily equal.
	 */

}

//fact: The smallest factor of a number (greater than 1) can not be greater than the square root of the number.
//
//n = 74 : factors (2 * 37, smallest factor of 74, 2 in this case is <= square root of 74)
//n = 125 : factors (5 * 25, smallest factor of 125, 5 is <= the square root of 125)
//n = 121 : factors (11*11, smallest factor 11 <= square root of 121)
//
//and to check if a number is prime we look for its factor (either smaller or bigger, but we prefer smaller one as it will appear
//before the bigger one in the loop)
//That is why to check if a number is prime we only iterate till the square root of a number.
