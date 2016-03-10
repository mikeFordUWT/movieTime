package data;

import java.util.ArrayList;

public class User {
	private String userID;
	private String firstName;
	private String lastName;
	private String eMail;
	private ArrayList<Movie> favorites;
	private ArrayList<Movie> watchList;
	
	
	public User(String id, String first, String last, String mail) {
		userID = id;
		firstName = first;
		lastName = last;
		eMail = mail;
		
		favorites = new ArrayList<Movie>();
		watchList = new ArrayList<Movie>();
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
	
	public void addToFavorites(Movie theMovie){
		favorites.add(theMovie);
	}
	
	public void addToWatchList(Movie theMovie){
		watchList.add(theMovie);
	}
	
	public ArrayList<Movie> getFavorites(){
		return favorites;
	}
	
	public ArrayList<Movie> getWatchList(){
		return watchList;
	}
	
}
