package dsa_problems;

import java.util.Arrays;

public class SortArraysWithOnly3Elements {

	public static void main(String[] args) {
		
		int []arr = {0,1,2,0,2,1,2,1,2,1,2,1,0,0,01,2,0,1,1,2,1,1,2,1,2,2,2,2,2,1,2,0,0,2,2,0,0};
		
//		sortArrIn2Traversal(arr);
//		System.out.println(Arrays.toString(arr));
		
		sortArrIn1Traversal(arr);
		System.out.println(Arrays.toString(arr));

	}

	private static void sortArrIn1Traversal(int[] arr) {
		
		int l = 0, r = arr.length-1, mid = 0;
		int temp = 0;
		
		while(mid <= r) {
			if(arr[mid] == 0) {
				temp = arr[mid];
				arr[mid] = arr[l];
				arr[l] = temp;
				mid++;
				l++;
			}
			else if(arr[mid] == 2) {
				temp = arr[mid];
				arr[mid] = arr[r];
				arr[r] = temp;
				r--;
			}
			else {
				 mid++;
			}
		}
		
	}

	private static void sortArrIn2Traversal(int[] arr) {
		
		int temp[] = new int[3];
		for(int i : arr) {
			temp[i]++;
		}
		
		int count = 0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<temp[i]; j++) {
				arr[count++] = i;
			}
		}
	}

}
