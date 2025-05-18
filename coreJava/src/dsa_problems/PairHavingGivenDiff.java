package dsa_problems;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/*
 * Que: Given an array, find one pair from the array whose difference is equal to target(given target = 5) OR 
 * 		Given an array and a number find the pairs of number from the array whose difference is equal to the given number
 */
public class PairHavingGivenDiff {

	public static void main(String[] args) {
		
		int []arr = {9,1,8,2,7,3,6,4,5};
		int diff = 5;
		
		usingExtraSpace(arr, diff);
		
		System.out.println("---------------------------------");
		
		withoutExtraSpaceUsingSorting(arr, diff);
		
	}
	
	// O(n) time, O(n) exta space
	private static void usingExtraSpace(int []arr, int diff) {

		// a - b = diff
		// a = diff + b;
		
		HashSet<Integer> set = new HashSet<>();
		for(int i: arr) {
			set.add(i);
		}
		

		for(int i: arr) {
			if(set.contains(diff + i)) {
				System.out.println("True: " + i + ", " + (diff + i));
//				return; // with this we will have first pair, without this we will have all the pair
			}
		}
	}
	
	// O(nlogn) time, O(1) space
	private static void withoutExtraSpaceUsingSorting(int []arr, int diff) {
		Arrays.sort(arr);
		
		int l = 0, r = 1;
		
		while(l <= r && r < arr.length) {
			
			if(arr[r] - arr[l] == diff) {
				System.out.println("True: " + arr[l] + ", " + arr[r]);
//				return; // with this we will have first pair, without this we will have all the pair
				r++;
			}
			else if(arr[r] - arr[l] < diff) {
				r++;
			}
			else {
				l++;
			}
		}
	}

}

