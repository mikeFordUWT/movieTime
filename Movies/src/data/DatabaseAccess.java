package data;

public class DatabaseAccess {
	
	public static DBConnection db = new DBConnection(""
			+ "jdbc:mysql://fordm13.vergil.u.washington.edu:1138/movies");
	
	public DatabaseAccess() {
		
	}
}
