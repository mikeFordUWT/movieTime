package data;

import java.util.List;
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
				+ "movie.movie_ID = '%" + movieTitle + "%';";
		ResultSet rset = state.executeQuery(queryString);
		while(rset.next()) {
			String id = rset.getString("movie_ID");
			String title = rset.getString("title");
			int runTime = rset.getInt("run_time");
			int release = rset.getInt("release_date");
			int boxOffice = rset.getInt("box_office");
			String mpaa = "";
			String toExecute = "select distinct rating"
					+ "from mpaa M, (select mpaa_ID from movie where title = '"+ title + "') Mo"
					+ "where Mo.mpaa_ID = M.mpaa_ID order by rating;";
			Statement state2 = connect.createStatement();
			ResultSet mset = state2.executeQuery(toExecute);
			while(mset.next()){
				mpaa = mset.getString("rating");
			}
			Movie m = new Movie(id, title, runTime, release, boxOffice, mpaa);
			
			
			String actorQuery = "select A.fname, A.mname, A.lname "
					+ "from actor A natural join actor_movie AM "
					+ "natural join (select movie_ID "
					+ "from movie "
					+ "where title = '"+title+"') A;";
			Statement state3 = connect.createStatement();
			ResultSet aSet = state3.executeQuery(actorQuery);
			while(aSet.next()){
				String aId = aSet.getString("actor_ID");
				String firstName = aSet.getString("fname");
				String midName = aSet.getString("mname");
				String lastName = aSet.getString("lname");
				Actor a = new Actor(aId, firstName, midName, lastName);
				m.addActor(a);
				
			}
			String dQuery = "select distinct D.fname, D.mname, D.lname "
					+ "from director D, (select director_ID from movie"
					+ "where title like '"+title+"') A "
							+ "where D.director_ID = A.director_ID;";
			
			Statement state4 = connect.createStatement();
			ResultSet dSet = state4.executeQuery(dQuery);
			while(dSet.next()){
				String firstName = dSet.getString("fname");
				String midName = dSet.getString("mname");
				String lastName = dSet.getString("lname");
				Director d = new Director(firstName, midName, lastName);
				m.setDirector(d);
			}
			toReturn.add(m);
		}
		return toReturn;
		
	}
	
	public ArrayList<Movie> getWatchList(String email){
		return null;
		
	}
	
	public ArrayList<Movie> getFavorites(String email){
		return null;
		
	}
	
	public User getUser(String email) throws SQLException{
		User u = null;
		Statement state = connect.createStatement();
		String query = "SELECT `user_ID`,`fName`,`lName`,`email` "
				+ "FROM user where email = '"+email+"';";
		
		ResultSet  uSet = state.executeQuery(query);
		while (uSet.next()) {
			String id = uSet.getString("user_ID");
			String fName = uSet.getString("fname");
			String lName = uSet.getString("lname");
			String eMail = uSet.getString("email");
			u = new User(id,fName, lName, eMail);
			
		}
		
		return u;
		
	}
	
	public List<String> getFavFromUser(String userID) throws SQLException {
		Statement state = connect.createStatement();
		ArrayList<String> movieTitle = new ArrayList<String>();
		String query = "Select M.title From movie M, "
				+ "(Select UM.movie_ID FROM user_movie UM "
				+ "WHERE (UM.user_ID = '" +userID+"' AND UM.favorite_list "
				+ "= 1)) U Where M.movie_ID = U.movie_ID;";
		
		ResultSet rSet= state.executeQuery(query);
		while (rSet.next()) {
			movieTitle.add(rSet.getString("title"));
		}
		return movieTitle;
	}
	
	public List<String> getWatchFromUser(String userID) throws SQLException {
		Statement state = connect.createStatement();
		ArrayList<String> movieTitle = new ArrayList<String>();
		String query = "Select M.title From movie M, "
				+ "(Select UM.movie_ID FROM user_movie UM "
				+ "WHERE (UM.user_ID = '" +userID+"' AND UM.watch_list "
				+ "= 1)) U Where M.movie_ID = U.movie_ID;";
		
		ResultSet rSet= state.executeQuery(query);
		while (rSet.next()) {
			movieTitle.add(rSet.getString("title"));
		}
		return movieTitle;
	}
	
	
	
	
	
	
	
}