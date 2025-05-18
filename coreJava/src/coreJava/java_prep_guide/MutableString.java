package coreJava.java_prep_guide;

public class MutableString {

	public static void main(String[] args) {

		StringBuilder strBlder = new StringBuilder("Tarun");
		
		StringBuffer strBfr = new StringBuffer("Tarun");
		
		StringBuilder strBlder1 = strBlder.append(" Kanade");
		
		System.out.println("strBlder == strBlder1 : " + (strBlder == strBlder1));
		
		strBfr.insert(2, " Hello ");
		
		StringBuilder strBlder2 = strBlder.delete(0, 1);
		
		System.out.println("strBlder == strBlder2 : " + (strBlder == strBlder2));
		System.out.println("strBlder1 == strBlder2 : " + (strBlder1 == strBlder2));
		
		System.out.println(strBlder.toString());
		System.out.println(strBfr);
		
	}

}
