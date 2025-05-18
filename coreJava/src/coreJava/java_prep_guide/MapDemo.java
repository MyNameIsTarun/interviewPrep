package coreJava.java_prep_guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapDemo {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(10, "Tarun");
		map.put(34, "Hello");
		map.put(2, "Apple");
		map.put(14, "World");
		map.put(15, "Boat");
		
		// 1. getting stream of map entries
		// 2. using sorted method and passing in-build Entry comparator using comparingByKey() method, which sorts keys acc to natural order
		// 3. collecting to map which takes 4 arguments
		// 4. I: keyMapper function (what will be keys), II: valueMapper function (what will be values)
		// 		III: merge function (if there are duplicate keys then how to merge their values (which will not be case in maps))
		// 		IV: supplier (if we want to transform the result map to some other map, linkedHashMap in this case).
		LinkedHashMap<Integer, String> sortMapByKeysAsc = map.entrySet().stream()
											.sorted(Map.Entry.comparingByKey())
											.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
													(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("sortMapByKeysAsc: " + sortMapByKeysAsc);
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5,2,9,6,1,8,3,5,0,3,2,1,3));
		// In this example we have duplicate keys
		HashMap<Integer, String> intMap = list.stream().collect(Collectors.toMap(Integer::intValue, Object::toString, 
										(v1, v2) -> v1+"+"+v2, HashMap::new));
		
		System.out.println("intMap: " + intMap);
		
		LinkedHashMap<Integer, String> sortMapByKeysDesc = map.entrySet().stream()
											.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
											.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
													(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("sortMapByKeysDesc: " + sortMapByKeysDesc);
		
		LinkedHashMap<Integer, String> sortMapByValuesAsc = map.entrySet().stream()
											.sorted(Map.Entry.comparingByValue())
											.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
													(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("sortMapByValuesAsc: " + sortMapByValuesAsc);
		
		LinkedHashMap<Integer, String> sortMapByValuesDesc = map.entrySet().stream()
											.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
											.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
													(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("sortMapByValuesDesc: " + sortMapByValuesDesc);
		
		TreeMap<String, Integer> tmap = new TreeMap<>();
		tmap.put("Some", 5);
		tmap.put("Value", 1);
		tmap.put("to", 8);
		tmap.put("Tarun", 4);
		tmap.put("Anything", null);
		
		System.out.println(tmap);
		
//		TreeMap<Demo, Integer> tmap1 = new TreeMap<>((a, b) -> a.getEmployeeId()-b.getEmployeeId());
		TreeMap<Demo, Integer> tmap1 = new TreeMap<>();
		tmap1.put(new Demo(5), 5);
		tmap1.put(new Demo(11), 11);
		tmap1.put(new Demo(2), 2);
		tmap1.put(new Demo(54), 54);
		tmap1.put(new Demo(7), 7);
		
		System.out.println(tmap1);

	}

}
