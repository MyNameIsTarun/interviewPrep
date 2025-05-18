package coreJava;

import java.time.Instant;
import java.util.List;

public class MutableChild extends Immutable {
	
	private int score;
	
	private String itemId;

	public MutableChild(String itemId, String itemName, List<String> tags, List<List<String>> groups,
			Employee employee, Instant date, int score, String childItemId) {
		super(itemId, itemName, tags, groups, employee, date);
		this.score = score;
		this.itemId = childItemId;
	}
	
	public MutableChild(int score) {
		this(null, null, null, null, null, null, score, "0");
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}

//	public String getChildItemId() {
//		return itemId;
//	}
	
	public String getItemId() {
		return this.itemId;
	} 

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
//	// this.getEmployee() is the method of Immutable which will return copy of the Employee object
//	public Employee getEmployee() {
//		return this.getEmployee();
//	}
//	
	

}
