package dsa_problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Que: Find All Maximum frequency word from a sentence.
 * 
 * O(n) time, O(n) space
 */
public class MaxFreqWords {

	public static void main(String[] args) {
		String str = "Hello Hello hi hi hi I am the one two three three three";
		int s = 0;
		
		HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
		
		for(int e=0; e<str.length(); e++) {
			if(str.charAt(e) == ' ') {
				freqMap.put(str.substring(s, e), freqMap.getOrDefault(str.subSequence(s, e), 0) + 1);
				s = e+1;
			}
		}
		freqMap.put(str.substring(s, str.length()), freqMap.getOrDefault(str.subSequence(s, str.length()), 0) + 1);

		System.out.println(
				freqMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
						.thenComparing(Map.Entry.<String, Integer>comparingByKey()))
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new))
		);
	}

}
