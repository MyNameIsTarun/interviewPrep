package dsa_problems;

public class ReverseStringWithoutLoop {

	public static void main(String[] args) {
		
		System.out.println(reverseString("Hello World!"));
		
		String str = "The quick brown fox jumps over a lazy dog";
		System.out.println(revesePosOfWords(str));

	}
	
	private static String revesePosOfWords(String str) {
		String []words = str.split(" ");
		StringBuilder sb = new StringBuilder();
		
		return recursiveReverse(words, sb, words.length-1);
	}

	private static String recursiveReverse(String[] words, StringBuilder reverse, int length) {
		if(length < 0) {
			return reverse.toString();
		}
		
		reverse.append(words[length] + " ");
		return recursiveReverse(words, reverse, length-1);
	}

	private static String reverseString(String str) {
		if(str.length() == 0) {
			return str;
		}
		
		return str.charAt(str.length()-1) + reverseString(str.substring(0, str.length()-1));
	}

}
