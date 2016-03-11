package data;

import java.util.ArrayList;

public class User {
	private String userID;
	private String firstName;
	private String lastName;
	private String eMail;
	private ArrayList<String> favorites;
	private ArrayList<String> watchList;
	
	
	public User(String id,String first, String last, String mail) {
		userID = id;
		firstName = first;
		lastName = last;
		eMail = mail;
		
		favorites = new ArrayList<String>();
		watchList = new ArrayList<String>();
	}

	public String getID(){
		return userID;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEMail(){
		return eMail;
	}

	
	public void addToFavorites(String theMovie){
		favorites.add(theMovie);
	}
	
	public void addToWatchList(String theMovie){
		watchList.add(theMovie);
	}
	
	public ArrayList<String> getFavorites(){
		return favorites;
	}
	
	public ArrayList<String> getWatchList(){
		return watchList;
	}
	
}
