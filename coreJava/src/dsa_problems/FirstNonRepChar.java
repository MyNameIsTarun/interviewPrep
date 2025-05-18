package dsa_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Que: Given a string, find the 1st non-repeating character?
 * 
 * O(n) time, O(1) space
 */
public class FirstNonRepChar {

	public static void main(String[] args) {
		
		String str = "adfuaeyrobfksdhkjfh";

		int []indexArr = new int[128];
		Arrays.fill(indexArr, -1);
		
		HashMap<Character, Integer> map = new HashMap<>(); // freq map
		
		for(int i=0; i<str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1); // freq map
			if(indexArr[str.charAt(i)] >= 0) { // appeared before
				indexArr[str.charAt(i)] = -2;
			}
			if(indexArr[str.charAt(i)] == -1) { // appearing for first time
				indexArr[str.charAt(i)] = i;
			}
		}
		System.out.println(map); // Ans : frequency of a char in a given string. O(n) time, O(1) space
		
		int smallestIndex = Integer.MAX_VALUE;
		
		for(int i : indexArr) {
			if(i >= 0) {
				smallestIndex = (smallestIndex > i) ? i : smallestIndex;
			}
		}
		
		if(smallestIndex == Integer.MAX_VALUE) {
			System.out.println("Every character appears twice.");
			return;
		}
		
		System.out.println("First non repeating character: " + str.charAt(smallestIndex));
		
		System.out.println("\n");
		int maxFreq = -1;
		char ans = '-';
		
		for(Map.Entry<Character, Integer> e : map.entrySet()) {
			if(e.getValue() > maxFreq) {
				maxFreq = e.getValue();
				ans = e.getKey();
			}
		}
		
		System.out.println("Character having max frequency: " + ans); // Ans: Find maximum repeated character from a string? O(n) time, O(n) space
	}

}
