package dsa_problems;

import java.util.ArrayDeque;

/*
 * Parantheses balancing
 * 
 * O(n) time, O(n) space
 */
public class ParanthesisBalancing {

	public static void main(String[] args) {
		
		String str = "{[(){}]}[]{}((()))}";
		
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			else {
				// If current character is not opening
	            // bracket, then it must be closing. So stack
	            // cannot be empty at this point.
				if(stack.size() == 0) {
					System.out.println("Not Balanced");
					return;
				}
				else if(matching(c, stack.peek())) {
					stack.pop();
				}
				else {
					System.out.println("Not Balanced");
					return;
				}
			}
		}
		
		if(stack.size() > 0) {
			System.out.println("Not Balanced");
		}
		else {
			System.out.println("Balanced");
		}

	}
	
	private static boolean matching(char a, char b) {
		return ((a == ')' && b == '(') || (a == '}' && b == '{') || (a == ']' && b == '['));
	}

}
