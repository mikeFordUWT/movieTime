package data;

public class Director {
	private String firstName;
	private String middleName;
	private String lastName;
	private String directorID;
	
	public Director(String id, String first, String middle, String last) {
		directorID = id;
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
		return directorID;
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
