package dsa_problems;

import java.util.ArrayList;
import java.util.Arrays;

// O(n^2) time
public class TripletsWithZeroSum {

	public static void main(String[] args) {
		
		int arr[] = {1,2,4,-1,-2,-3,-1};
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length; i++) {
			ArrayList<ArrayList<Integer>> res = pairWithGivenSum(arr, i+1, arr.length-1, 0-arr[i]);
			if(res.size() > 0) {
				System.out.println(arr[i] + " " + res);
			}
		}

	}
	
	private static  ArrayList<ArrayList<Integer>> pairWithGivenSum(int []arr, int i, int j, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> list;
		
		while(i < j) {
			if((arr[i] + arr[j]) == sum) {
				list = new ArrayList<Integer>();
				list.add(arr[i]);
				list.add(arr[j]);
				res.add(list);
				j--;
			}
			else if(arr[i] + arr[j] < sum) {
				i++;
			}
			else {
				j--;
			}
		}
		
		return res;
	}

}
