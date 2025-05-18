package datastructure;

import java.util.Iterator;

public class MainMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TarunMap<Integer, String> map = new TarunMap<>();
		
		map.put(0, "Hello");
		map.put(56, "World");
		map.put(78, "My");
		map.put(3, "Name");
		map.put(6, "is");
		map.put(16, "Tarun");
		map.put(7, "what");
		map.put(121, "is");
		map.put(89, "Your");
		map.put(32, "name");
		map.put(null, "Null");
		map.put(101, null);
		
		System.out.println("key: 78, value: " + map.get(78));
		System.out.println("key: 16, value: " + map.get(16));
		System.out.println("key: 100, value: " + map.get(100));
		System.out.println("key: null, value: " + map.get(null));
		
		System.out.println("size: " + map.size());
		System.out.println("removing 121 key");
		map.remove(121);
		System.out.println("new size: " + map.size());
		
		System.out.println("key: 121, value: " + map.get(121));
		
		System.out.println(map.keySet());
		
		System.out.println("size: " + map.size());
		System.out.println("capacity: " + map.capacity());
		
		map.put(55, "How");
		map.put(44, "are");
		map.put(33, "you");
		map.put(11, "?");
		
		System.out.println("size: " + map.size());
		System.out.println("capacity: " + map.capacity());
		
		System.out.println("\nEntries...");
		for(TarunMap.Node<Integer, String> e : map.entrySet()) {
			System.out.println(e);
		}
		

	}

}
