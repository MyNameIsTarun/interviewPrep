package coreJava;

import java.util.ArrayList;
import java.util.List;

public class MutableMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		List<List<String>> nestedList = new ArrayList<>();
		
		MutableChild mutableChild = new MutableChild("id", null, list, nestedList, new Employee(), null, 1, "1");
		Immutable imm = mutableChild;
		
		changeAndPrintImmutable(imm);
		mutableChild.setItemId("something");
		changeAndPrintImmutable(imm);
		
		// returns child's item id
		// as we can see above parent (Immutable) class item id is set to "id" (first para)
		System.out.println(imm.getItemId());
		
//		Immutable immutable = new MutableChild(10);
		mutableChild = new MutableChild("id2", null, list, nestedList, new Employee(), null, 1, "20");
		new MutableMain().changeAndPrintMutable(mutableChild);
	}
	
	public static void changeAndPrintImmutable(Immutable immutable) {
		// setters of the child class are not visible to immutable object reference
		System.out.println(immutable.getItemId() + " in changeAndPrintImmutable using immutable object ref");
	}
	
	public void changeAndPrintMutable(MutableChild mutableChild) {
		System.out.println(mutableChild.getItemId() + " child");
		
		Immutable imm = mutableChild;
		System.out.println(imm.getItemId() + " parent ref");
		
		mutableChild.setItemId("40");
		System.out.println(imm.getItemId() + " parent ref");
		
		System.out.println(mutableChild.getItemId());
	}

}
