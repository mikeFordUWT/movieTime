package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Actor;
import data.DatabaseAccess;
import data.Director;
import data.Movie;
import data.User;

/**
 * The class to run the code.
 * 
 * @author Michael Ford & Andy Bleich
 *
 */
public class Runner {
	private static MovieFrame movieFr;
	private static UserFrame userFr;
	private static LogInFrame logFr;

	private static Movie currentMovie;
	private static User currentUser;
	public static void main(String[] args) {
		logFr = new LogInFrame();
		
		listeners();
		
	}

	private static void listeners(){
		logInListeners();
	}
	
	private static void logInListeners(){
		logInButtonListen();
	}



	private static void logInButtonListen(){
		logFr.getLogButton().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
			
				if(logFr.getUserMap().containsKey(logFr.getUserName())
						&& logFr.getUserMap().containsValue(logFr.getPassword())){
					try {
						currentUser = DatabaseAccess.getUser(logFr.getUserName());
						ArrayList<String> toAdd = DatabaseAccess.getFavs(currentUser.getID());
						for(int i =0 ; i<toAdd.size(); i++){
							currentUser.addToFavorites(toAdd.get(i));
						}
						
						ArrayList<String> watch = DatabaseAccess.getWatch(currentUser.getID());
						for(int i = 0; i<watch.size(); i++){
							currentUser.addToWatchList(watch.get(i));
							
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					//					user.setUser(inputUser);
					//
					userFr= new UserFrame(currentUser, logFr, movieFr, currentMovie);
					userFr.setVisible(true);
					
					
					logFr.setVisible(false);
					logFr.getUserField().setText("");
					logFr.getPassField().setText("");

				}
			}
		});
	}
}
