package data;

import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseAccess {
	
	static DBConnection db = new DBConnection(""
			+ "jdbc:mysql://fordm13.vergil.u.washington.edu:1138/movies");
	
	public ArrayList<Movie> getMovies(String title){
		try{
			db.getMovieDetails(title);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
