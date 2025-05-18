package dsa_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Sort the provided List in decreasing order of frequency.
 * 
 * O(nlogn) time, O(n) space
 */
public class SortListByFreq {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4,3,6,8,5,3,1,3,5,7,8,9,6,5,3,2,4,6,0));
		
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		
		for(int i : list) {
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
		}
		
//		LinkedHashMap<Integer, Integer> sortedMap = freqMap.entrySet().stream()
//							.sorted(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder())
//									.thenComparing(Map.Entry.<Integer, Integer>comparingByKey(Comparator.reverseOrder())))
//							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
//
//		list.clear();
//		
//		for(Map.Entry<Integer, Integer> e : sortedMap.entrySet()) {
//			for(int i=0; i<e.getValue(); i++) {
//				list.add(e.getKey());
//			}
//		}
//		
//		System.out.println(list);
		
		list = (ArrayList<Integer>) list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(entry -> {
						ArrayList<Integer> temp = new ArrayList<>();
						for(int i=0; i<entry.getValue(); i++) {
							temp.add(entry.getKey());
						}
						return temp;
					}).flatMap(temp2 -> temp2.stream()).collect(Collectors.toList());
					
//					.forEach(entry -> {
//						for(int i=0; i<entry.getValue(); i++) {
//							System.out.print(entry.getKey()+ " ");
//						}
//					});
		
		System.out.println(list);
	}

}
