package dsa_problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Get distinct values from arraylist using java 8.
 */
public class DistinctValuesInList {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,6,3,5,7,9,0,7,6,4,2,1,3,5,6,7,8,8,6,5,4,2);
		
		List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
		
		System.out.println(distinctList);

	}

}
