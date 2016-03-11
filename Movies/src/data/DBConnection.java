package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
	
	private static String USER = "root";
	
	private static String PASS = "mikeServer";
	
	private Connection connect;
	private String serverURL = "jdbc:mysql://fordm13.vergil.u.washington.edu:1138/movies";
	
	
	public DBConnection(String dbURL){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(dbURL, USER, PASS);
			System.out.println("Connected");
		} catch (Exception ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
	} //end initialization
	
	
	//Select query
	public String SelectQuery(String query) {
		Statement state;
		String result = "";
		try{
			state = connect.createStatement();
			String queryString;
			if(query.equals("")){
				queryString = "";//TODO
			}else{
				queryString = query;
			}
			
			ResultSet rSet = state.executeQuery(queryString);
			while(rSet.next()){
				result = rSet.getString(1);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	//update Query
	public int Update(String query){
		Statement state;
		int result = 0;
		try {
			state = connect.createStatement();
			state.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Movie> getMovieDetails(String movieTitle) throws SQLException{
		ArrayList<Movie> toReturn = new ArrayList<Movie>();
		Statement state = connect.createStatement();
		String queryString = "SELECT movie.title, movie.run_time,"
				+ "movie.release_date,movie.box_office"
				+ "FROM "
				+ "movie"
				+ "WHERE"
				+ "movie.movie_ID = \'%" + movieTitle + "%\';";
		ResultSet rset = state.executeQuery(queryString);
		while(rset.next()) {
			
			String title = rset.getString("title");
			int runTime = rset.getInt("run_time");
			int release = rset.getInt("release_date");
			int boxOffice = rset.getInt("box_office");
			String mpaa = "";
			String toExecute = "SELECT `rating` FROM `mpaa` WHERE mpaa.rating = "+ rset.getString("mpaa_ID")+";";
			ResultSet mset = state.executeQuery(toExecute);
			while(mset.next()){
				mpaa = mset.getString("rating");
			}
			Movie m = new Movie(title, runTime, release, boxOffice, mpaa);
			//TODO get actors and director
			
			
			
			toReturn.add(m);
		}
		return toReturn;
		
	}
	
}