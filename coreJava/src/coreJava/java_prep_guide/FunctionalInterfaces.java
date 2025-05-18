package coreJava.java_prep_guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(new Integer[] {50, 100}));
		
		list.forEach(e -> System.out.print(e + " "));
		System.out.println();
		
		Consumer<Integer> consume = (e) -> {
			for(int i=1; i<=e; i+=10) {
				System.out.print(i + " ");
			}
		};
		consume.accept(100);
		System.out.println();
		
		testConsume(list, consume);
		System.out.println();
		System.out.println();
		
		testPredicate(15, (n) -> (n > 10 && n < 20));
		testPredicate(null, (obj) -> obj != null);
		System.out.println();
		
		testFunction((s) -> s.length(), "Hello World!");
		testFunction((s) -> {
			int sum = 0;
			for(int i=0; i<s.length(); i++) {
				sum += s.charAt(i);
			}
			return sum;
		}, "something");
		System.out.println();
		
		testSupplier(() -> Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9,10}));

	}

	public static void testConsume(ArrayList<Integer> list, Consumer<Integer> consume) {
		list.forEach(e -> consume.accept(e));
	}
	
	public static void testPredicate(int n, Predicate<Integer> predicate) {
		System.out.println(predicate.test(n));
	}
	
	private static void testPredicate(Object object, Predicate<Object> predicate) {
		System.out.println(predicate.test(object));
	}
	
	public static void testFunction(Function<String, Integer> function, String str) {
		System.out.println(function.apply(str));
	}
	
	public static void testSupplier(Supplier<List<Integer>> supp) {
		System.out.println(supp.get());
	}

}

@FunctionalInterface
interface Consumer<T>{
	public void accept(T t);
}

interface Predicate<T>{
	public boolean test(T t);
}

@FunctionalInterface
interface Function<T, R>{
	public R apply(T t);
}

interface Supplier<R>{
	R get();
}
