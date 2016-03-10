package data;

import java.util.ArrayList;

public class Actor {
	private String firstName;
	private String middleName;
	private String lastName;
	private String actorID;
	
	
	public Actor(String id, String first, String middle, String last) {
		actorID = id;
		firstName = first;
		middleName = middle;
		lastName = last;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getID(){
		return actorID;
	}
	
	
	
	@Override
	public String toString(){
		String str;
		if(middleName == null){
			str = firstName + " " + lastName;
		} else {
			str = firstName + " " + middleName + " " + lastName; 
		}
		return str;
	}
	
}
