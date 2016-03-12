package data;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * 	Class to access database.
 * 
 *  @author Michael Ford and Andy Bleich
 */
public class DatabaseAccess {

	static DBConnection db = new DBConnection(""
			+ "jdbc:mysql://fordm13.vergil.u.washington.edu:1138/movies");

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

	public static ArrayList<String> getFavs(String userID) throws SQLException {
		return db.getFavFromUser(userID);
	}

	public static ArrayList<String> getWatch(String userID) throws SQLException{
		return db.getWatchFromUser(userID);
	}
	
	public static void InsertRating(String userID, String movieID, int rating) throws SQLException{
		db.addNewRating(userID, movieID, rating);
	}

	public static void AddToWatchInsert(String userID, String movieID) throws SQLException{
		db.addToWatchList(userID, movieID);
	}
	
	public static void addToFavoritesUpdate(String userID, String movieID) throws SQLException{
		db.addToFavorites(userID, movieID);
	}

}
