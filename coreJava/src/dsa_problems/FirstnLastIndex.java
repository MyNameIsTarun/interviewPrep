package dsa_problems;

public class FirstnLastIndex {

	public static void main(String[] args) {
		int []arr = {6,1,8,2,0,3,7,1,6,1}; // for 1

		printFirstAndLastIndex(arr, 6);
		printFirstAndLastIndex(arr, 1);
		printFirstAndLastIndex(arr, 0);
		printFirstAndLastIndex(arr, 9);
	}

	// O(n) time, O(1) space
	private static void printFirstAndLastIndex(int[] arr, int n) {
		int fi = -1, li = -1;
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == n) {
				if(fi == -1) {
					fi = i;
				}
				else {
					li = i;
				}
			}
		}
		
		if(fi != -1 && li != -1) {
			System.out.println("First and Last index of " + n + ": " + fi + ", " + li);
		}
		else if(fi != -1) {
			System.out.println(n + " appears only once at: " + fi);
		}
		else {
			System.out.println(n + " does not appear.");
		}
	}

}
