package dsa_problems;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(mergeArray(new int[]{1,2,3,4,5}, new int[]{6,7,8,9})));
		System.out.println(Arrays.toString(mergeArray(new int[]{}, 			new int[]{6,7,8,9})));
		System.out.println(Arrays.toString(mergeArray(new int[]{1,2,3,4,5}, new int[]{})));
		System.out.println(Arrays.toString(mergeArray(new int[]{10}, 		new int[]{6,7,8,9})));
		System.out.println(Arrays.toString(mergeArray(new int[]{6,7,8,9}, 	new int[]{1})));
		System.out.println(Arrays.toString(mergeArray(new int[]{}, 			new int[]{})));
		System.out.println(Arrays.toString(mergeArray(new int[]{1,2,3,3,5}, new int[]{6,7,8,9})));
		System.out.println(Arrays.toString(mergeArray(new int[]{1,2,3,4,5}, new int[]{5,6,7,8,9})));
		System.out.println(Arrays.toString(mergeArray(new int[]{1,3,5,7,9}, new int[]{2,4,6,8})));
	}

	// O(s1+s2) time, O(1) space
	private static int[] mergeArray(int[] arr1, int[] arr2) {
		
		int s1 = arr1.length, s2 = arr2.length;
		int []resArr = new int[s1+s2];
		int i1 = 0, i2 = 0;
		int resi = 0;
		
		while(i1 < s1 && i2 < s2) {
			if(arr1[i1] < arr2[i2]) {
				resArr[resi] = arr1[i1];
				i1++;
			}
			else {
				resArr[resi] = arr2[i2];
				i2++;
			}
			
			resi++; 
		}
		
		while(i1 < s1) {
			resArr[resi] = arr1[i1];
			resi++; i1++;
		}
		
		while(i2 < s2) {
			resArr[resi] = arr2[i2];
			resi++; i2++;
		}
		
		return resArr;
	}

}
