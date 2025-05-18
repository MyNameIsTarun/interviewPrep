package dsa_problems;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,2,5};
		System.out.println("expected ans: " + 4 + ", actual ans: " + findMissing(arr));
		
		int[] arr1 = {1,3,2,5,4,6,8,7};
		System.out.println("expected ans: " + 9 + ", actual ans: " + findMissing(arr1));
		
		int[] arr2 = {4,3,2,5,6};
		System.out.println("expected ans: " + 1 + ", actual ans: " + findMissing(arr2));

	}
	
	private static int findMissing(int[] arr) {
		int n = arr.length + 1;
		int expectedSum = (n * (n+1))/2;
		int originalSum = 0;
		
		for(int i : arr) {
			originalSum += i;
		}
		
		return expectedSum - originalSum;
				
	}

}

/**
 * Problem:
 * Given array of first (n+1) unsorted natural numbers with one missing number; find the missing number.
    Ex. {5,2,3,1} - missing number = 4
 */
