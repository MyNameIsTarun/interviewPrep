package dsa_problems;

/*
 * Reverse the words in a sentence.
 */
public class ReverseWords {

	public static void main(String[] args) {
		String str = "A quick brown fox jumps over a lazy dog";
		
		System.out.println(reverseOnlyWords(str));
		System.out.println(reversePosOfWords(str));
		System.out.println(reversePosOfWords1(str));

	}

	// O(n) time, O(n) space, (each character will be traversed twice)
	private static String reverseOnlyWords(String str) {
		char []chars = str.toCharArray();
		int s = 0;
		
		for(int e=0; e<chars.length; e++) {
			if(chars[e] == ' ') {
				reverse(chars, s, e-1);
				s = e+1;
			}
		}
		
		reverse(chars, s, chars.length-1);
		
		return new String(chars);
	}

	// O(n) time, O(n) space, (each character will be traversed thrice)
	private static String reversePosOfWords(String str) {
		char []chars = str.toCharArray();
		int s = 0;
		
		for(int e=0; e<chars.length; e++) {
			if(chars[e] == ' ') {
				reverse(chars, s, e-1);
				s = e+1;
			}
		}
		
		reverse(chars, s, chars.length-1);
		reverse(chars, 0, chars.length-1);
		
		return new String(chars);
	}

	// O(n) time, O(n) space
	private static String reversePosOfWords1(String str) {
		String []strings = str.split(" ");
		int l = 0, r = strings.length-1;
		String temp;
		
		while(l < r) {
			temp = strings[l];
			strings[l] = strings[r];
			strings[r] = temp;
			
			l++; r--;
		}
		
		return String.join(" ", strings);
	}

	private static void reverse(char[] chars, int l, int r) {
		while(l<r) {
			char temp = chars[l];
			chars[l] = chars[r];
			chars[r] = temp;
			l++; r--;
		}
		
	}

}
