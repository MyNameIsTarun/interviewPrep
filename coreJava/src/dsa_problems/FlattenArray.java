package dsa_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class FlattenArray
{
	public static void main(String[] args) throws Exception{
	    Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };
	    
        Integer[] flattenedArray = flatten(array);
        
        System.out.println(Arrays.toString(flattenedArray));
	}
	
	public static Integer[] flatten(Object[] inputArray) throws Exception {
	    if(inputArray.length == 0){
	        return new Integer[]{};
	    }
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    for(Object o : inputArray){
	        if(o.getClass().isArray()){
	            for(Integer i: flatten((Object[])o)){
	                list.add(i);
	            }
	        }
	        else{
	            list.add((Integer) o);
	        }
	    }
	    
	    return list.toArray(new Integer[]{});
	}
	
	// Using streams
//	public static List<Object> flattenArray(Object[] nestedArray) {
//        return Arrays.stream(nestedArray)
//                .flatMap(obj -> obj instanceof Object[] ?
//                        Arrays.stream(flattenArray((Object[]) obj)) :
//                        Arrays.stream(new Object[]{obj}))
//                .collect(Collectors.toList());
//    }
	
}
