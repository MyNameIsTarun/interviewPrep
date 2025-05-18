package coreJava.java_prep_guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(3);
		list.add(9);
		list.add(7);
		list.add(6);
		list.add(100);
		
		System.out.println("------------------ sorting -------------------");
		Collections.sort(list, (i1, i2) -> i2 - i1);
		System.out.println(list);
		System.out.println("------------------ sorting ends -------------------\n");
		
		Iterator<Integer> it = list.iterator();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 100);
		map.put(3, 300);
		map.put(2, 200);
		
		ConcurrentHashMap<Integer, Integer> cmap = new ConcurrentHashMap<>(map);
		
		while(it.hasNext()) {
			int i = it.next();
			
//			list.add(0);
//			list.remove((Integer) 9);
			if(i == 3) {
				System.out.println("Hello");
				it.remove();
			}
			System.out.println(i);
//			it.remove();
//			list.add(200);
		}
		
		for(int i: list) {
			System.out.println(i);
			
//			list.remove((Integer) i);
		}
		
		System.out.println("-------------- set -------------------");
		
		HashSet<Integer> set = new HashSet<>(list);
		System.out.println("set: " + set);
		Iterator<Integer> ith = set.iterator();
		
		while(ith.hasNext()) {
			System.out.println(ith.next());
//			ith.remove();
//			set.remove(7);
		}
		
		System.out.println("set: " + set);
		
		System.out.println("---------------- map --------------------");
		
		for(Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println("key: " + e.getKey() + ", value: " + e.getValue());
//			map.remove(2); // ConcurrentModificationException
		}
		
		for(Integer i : map.keySet()) {
			System.out.println("key: " + i + ", value: " + map.get(i));
//			map.remove(2); // ConcurrentModificationException
		}
		
		System.out.println("---------------- cmap --------------------");
		
//		for(Map.Entry<Integer, Integer> e : cmap.entrySet()) {
//			System.out.println("key: " + e.getKey() + ", value: " + e.getValue());
//		}
		
		for(Integer i : cmap.keySet()) {
			System.out.println("key: " + i + ", value: " + cmap.get(i));
			cmap.remove(2);
		}
		
		System.out.println(cmap);
		
	}

}
