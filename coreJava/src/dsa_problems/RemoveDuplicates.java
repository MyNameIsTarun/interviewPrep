package dsa_problems;

import java.util.HashSet;

/*
 * Remove duplicates from a string in linear time
 * 
 * O(n) time, O(n) space
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "adflhalrieifdnfhesjirdsnflskdjlksjfk";
//		"abcdefghijklmnopqrstuvwxyz"
//		"aaaaaaaaaaaaaaaaa"
		
		// for testing
		{
		HashSet<Character> set = new HashSet<>();
		for(char c : str.toCharArray()) {
			set.add(c);
		}
		System.out.println("Expected: " + set);
		}
		
		String res = "";
		int []chars = new int[128];
		
		for(int i=0; i<str.length(); i++) {
			if(chars[str.charAt(i)] == 0) {
				res += str.charAt(i); // 1 String object will be created
			}
//			if(chars[str.charAt(i)] > 0) {
//				str = str.substring(0, i) + str.substring(i+1); // 3 String objects will be created
//				i--;
//			}
//			else {
				chars[str.charAt(i)]++;
//			}
		}
		
//		System.out.println(str);
		System.out.println(res);
	}

}
