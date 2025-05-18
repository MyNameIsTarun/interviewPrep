package dsa_problems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingIntInArray {

	public static void main(String[] args) {
		
		int []arr = {1,1,4,3,2,5,6,7,8,9,-1,-1};
		
		// O(n) time, O(n) space
		Map<Integer, Integer> map = new LinkedHashMap<>();
		
		for(int i: arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int min = -1;
		
		for(Map.Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getValue() == 1) {
				min = e.getKey();
				break;
			}
		}
		
		System.out.println("first non repeating int: " + min);
		
		
		// for finding only non repeating element, sorting is also a better approach O(nlogn) time, O(1) space
//		Arrays.sort(arr);
//		
//		int temp = arr[0], count = 1;
//		
//		for(int i=1; i<arr.length; i++) {
//			if(arr[i] == temp) {
//				count++;
//			}
//			else {
//				if(count == 1) {
//					System.out.println("first non repeating int: " + temp);
//					return;
//				}
//				
//				temp = arr[i];
//				count = 1;
//			}
//		}
//		
//		if(count == 1) {
//			System.out.println("first non repeating int: " + arr[arr.length - 1]);
//		}
//		
//		System.out.println("-1");

	}

}
