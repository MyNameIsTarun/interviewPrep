package dsa_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * String Anagrams
 */
public class StringAnagram {
	
	// characters are stored in 8 bits (1 byte) that means there are 256 possible characters

	public static void main(String[] args) {
		String txt = "abdbacdadabca", str = "dba";
		String []strings = {"abcd", "cabb", "cdba", "geeksforgeeks", "foxquick", "forgeeksgeeks"};

		System.out.println("areAnagrams(\"abcd\", \"dcba\"): " + areAnagrams("abcd", "dcba"));
		System.out.println("areAnagrams(\"asjdgh\", \"kjsfh\"): " + areAnagrams("asjdgh", "kjsfh"));
		
		System.out.println("Anagrams for: " + str + ": " + findAllAnagrams(txt, str));
		
		System.out.println(findAnagramPairs(strings));
	}

	// O(n) time, O(1) space
	private static boolean areAnagrams(String string1, String string2) {
		
		if(string1.length() != string2.length()){
			return false;
		}
		
		int []count = new int[256];
		
		for(int i=0; i<string1.length(); i++) {
			count[string1.charAt(i)]++;
			count[string2.charAt(i)]--;
		}
		
		for(int i=0; i<256; i++) {
			if(count[i] != 0) {
				return false;
			}
		}
		
		return true;
	}

	// O(t*s) time, O(1) space, t = length of txt, s = length of str
	private static List<String> findAllAnagrams(String txt, String str) {
		
//		int th = 0, sh = 0;
		int tl = txt.length(), sl = str.length();
		List<String> res = new ArrayList<String>();
		
		int []chars1 = new int[26];
		int []chars2 = new int[26];
		
		for(int i=0; i<sl; i++) {
			chars1[str.charAt(i)-'a']++;
			chars2[txt.charAt(i)-'a']++;
		}
		
		if(Arrays.equals(chars1, chars2)) {
			res.add(txt.substring(0, sl));
		}
		
		int start = 0, end = sl;
		while(end < tl) {
			chars2[txt.charAt(start) - 'a']--;
			chars2[txt.charAt(end) - 'a']++;
			
			if(Arrays.equals(chars1, chars2)) {
				res.add(txt.substring(start+1, end+1));
			}
			
			start++; end++;
		}
		
//		if(tl < sl) {
//			return res;
//		}
//		
//		for(int i=0; i<sl; i++) {
//			sh += str.charAt(i);
//			th += txt.charAt(i);
//		}
//		
//		if(sh == th) {
//			if(areAnagrams(str, txt.substring(0, sl))) {
//				res.add("0 " + txt.substring(0, sl));
//			}
//		}
//		
//		for(int i=sl; i<tl; i++) {
//			th -= txt.charAt(i-sl);
//			th += txt.charAt(i);
//			
//			if(sh == th) {
//				if(areAnagrams(str, txt.substring(i-sl+1, i+1))) {
//					res.add(i-sl+1 + " " + txt.substring(i-sl+1, i+1));
//				}
//			}
//		}
		
		return res;
	}

	// O(n*n*m) time, O(n) space, n = length of strings array, m = longest string in the array
	// hash array is used just for optimization, it can be skipped
	private static List<List<String>> findAnagramPairs(String[] strings) {
		int n = strings.length;
		int []hash = new int[n];
		
		List<List<String>> res = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<strings[i].length(); j++) {
				hash[i] += strings[i].charAt(j);
			}
		}
		
		for(int i=0; i<n-1; i++) {
			for(int j = i+1; j<n; j++) {
				if(hash[i] == hash[j]) {
					if(areAnagrams(strings[i], strings[j])) {
						res.add(Arrays.asList(strings[i], strings[j]));
					}
				}
			}
		}
		
		return res;
	}

}
