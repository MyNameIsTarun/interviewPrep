package special_designs;

import java.util.Iterator;

public class MainLRUCache {
	
	public static void main(String[] args) {
		
		LRUCache<Integer, Integer> cache = new LRUCache<>(3);
		
		cache.put(1, 100);
		cache.put(2, 200);
		cache.put(3, 300);
		System.out.println(cache);
		
		cache.get(2);
		System.out.println(cache);
		
		cache.put(3, 400);
		System.out.println(cache);
		
		cache.put(4, 4000);
		System.out.println(cache);
		
		cache.remove(3);
		System.out.println(cache);
		
		cache.put(5, 5000);
		System.out.println(cache);
		
		Iterator it = cache.keySet().iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
