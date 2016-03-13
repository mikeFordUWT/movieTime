package data;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 	Class to access database.
 * 
 *  @author Michael Ford and Andy Bleich
 */
public class DatabaseAccess {

	static DBConnection db = new DBConnection(""
			+ "jdbc:mysql://fordm13.vergil.u.washington.edu:1138/movies");

	//
	public static ArrayList<Movie> getMovies(String title){
		try{
			return db.getMovieDetails(title);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static User getUser(String eMail) throws SQLException{
		return db.getUser(eMail);
	}

	/*
	 * Retrieves user's favorites.
	 */
	public static ArrayList<String> getFavs(String userID) throws SQLException {
		return db.getFavFromUser(userID);
	}

	/*
	 * Retrives a user's watch list.
	 */
	public static ArrayList<String> getWatch(String userID) throws SQLException{
		return db.getWatchFromUser(userID);
	}
	
	/*
	 * Inserts rating from user.
	 */
	public static void InsertRating(String userID, String movieID, int rating) throws SQLException{
		db.addNewRating(userID, movieID, rating);
	}

	/*
	 * Add movie to user's watch list.
	 */
	public static void AddToWatchInsert(String userID, String movieID) throws SQLException{
		db.addToWatchList(userID, movieID);
	}
	
	/*
	 * Adds a movie to user's favorite list.
	 */
	public static void addToFavoritesUpdate(String userID, String movieID) throws SQLException{
		db.addToFavorites(userID, movieID);
	}

}
