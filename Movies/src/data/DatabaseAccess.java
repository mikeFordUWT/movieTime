package data;

import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
}
