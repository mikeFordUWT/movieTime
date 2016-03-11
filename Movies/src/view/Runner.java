package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import data.Actor;
import data.Director;
import data.Movie;
import data.User;

public class Runner {
	private static MovieFrame movieFr;
	private static UserFrame userFr;
	private static LogInFrame logFr;
	private static SearchResultFrame<Movie> searchMovieFr;
	private static SearchResultFrame<Actor> searchActorFr;
	private static SearchResultFrame<Director> searchDirectorFr;

	private static Movie currentMovie;
	private static AddMovieFrame addFr;
	private static User currentUser;
	public static void main(String[] args) {
		logFr = new LogInFrame();
		

		currentUser = new User("Michael", "Ford", "fordm13@uw.edu");

		

		Actor a1 = new Actor("Jack", null, "Nicholson");
		Actor a2 = new Actor("Shelley", null, "Duvall");
		Actor a3 = new Actor("Danny", null, "Lloyd");
		currentMovie= new Movie("The Shining", 146, 1980, 44017374, "R");

		Movie Jaws = new Movie("Jaws", 115, 1976, 3737733, "PG");
		currentMovie.addActor(a1);
		currentMovie.addActor(a2);
		currentMovie.addActor(a3);
		currentUser.addToFavorites(currentMovie);
		currentUser.addToWatchList(Jaws);
		userFr = new UserFrame(currentUser);
		userFr.setVisible(false);


		movieFr = new MovieFrame(currentMovie, currentUser, 4.5);
		
		ArrayList<String> genres = new ArrayList<String>();
		genres.add("Action");
		genres.add("Sci-Fi");
		
		ArrayList<String> ratings = new ArrayList<String>();
		ratings.add("G");
		ratings.add("PG");
		
		addFr = new AddMovieFrame(genres, ratings);
		
//		movieFr.setVisible(false);
		listeners();
		
	}

	private static void listeners(){
		movieFrameListeners();
		logInListeners();
		userFrameListeners();
		getSearchResultsListeners();
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

					//					user.setUser(inputUser);
					//TODO set it up so that the user will be based on username, finding a user that matches email
					userFr.setVisible(true);
					
					logFr.setVisible(false);
					logFr.getUserField().setText("");
					logFr.getPassField().setText("");

				}
			}
		});
	}

	private static void userFrameListeners(){
		userSearchButton();
		logOutListen();
	}

	private static void logOutListen(){
		userFr.getLogOut().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				userFr.setVisible(false);
				logFr.setVisible(true);

			}
		});
	}

	private static void userSearchButton(){
		userFr.getSearchButton().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){

				//				System.out.println("Searching");
				String table = (String) userFr.getSearchType().getSelectedItem();
				if(table.equals("actor")){
					//					searchFr = new SearchResultFrame<Actor>(currentMovie.getActorList());
				}else if (table.equals("director")){

				} else if (table.equals("movie")){

				}
				System.out.println(table);

				//				Movie newMovie = from title in database
				//				movie = new MovieFrame();
				//TODO if movie search returns more than one 
				movieFr.setVisible(true);
				userFr.setVisible(false);
			}
		});
	}

	private static void movieFrameListeners(){
		movieHomeListen();
		movieAddWatchListen();
		movieAddFav();
		movieLogOut();
		movieRate();
		addMovieListeners();
		
	}

	private static void movieRate(){
		movieFr.getRateButton().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				int rating = (int) movieFr.getRatingBox().getSelectedItem();
				System.out.println(rating);
				//TODO add rating to user-movie rating
			}
		});
	}
	private static void movieLogOut(){
		movieFr.getLogOut().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				movieFr.setVisible(false);
				logFr.setVisible(true);
			}
		});
	}

	//Listener for movie Frame home button, sends user back to home frame.
	private static void movieHomeListen(){
		movieFr.getHomeButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Going home!");
				movieFr.setVisible(false);
				userFr.setVisible(true);
			}
		});
	}

	private static void movieAddWatchListen(){
		movieFr.getWatchAdd().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//								currentUser.addToWatchList(currentMovie.getMovie());
				//TODO add it in database
			}
		});
	}

	private static void movieAddFav(){
		movieFr.getFavAdd().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				//				currentUser.addToFavorites(movie.getMovie());
				//TODO add in database
			}
		});
	}


	private static void getSearchResultsListeners(){

	}
	
	private static void addMovieListeners(){
		getAddMovie();
		getLogOutButton();
	}
	private static void getAddMovie(){
		addFr.getAddButton().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				
			
				
				if(!addFr.getMovieTitle().equals("") && !addFr.getRunTime().equals("") && !addFr.getReleaseDate().equals("")
						&& !addFr.getBoxOffice().equals("") && !addFr.getDirectorFirst().equals("") && !addFr.getDirectorLast().equals("")
						&& !addFr.getActor1First().equals("") && !addFr.getActor1Last().equals("") && !addFr.getActor2First().equals("") 
						&& !addFr.getActor2Last().equals("") && !addFr.getActor3First().equals("") && !addFr.getActor3Last().equals("")){
					String title = addFr.getMovieTitle();
					String run = addFr.getRunTime();
					int runTime = Integer.parseInt(run.replaceAll(",", ""));
					String box = addFr.getBoxOffice();
					int boxOffice = Integer.parseInt(box.replaceAll(",", ""));
					String release = addFr.getReleaseDate();
					int releaseDate = Integer.parseInt(release.replaceAll(",", ""));
					String directorFirst = addFr.getDirectorFirst();
					String directorLast = addFr.getDirectorLast();
					String actor1First = addFr.getActor1First();
					String actor1Last = addFr.getActor1Last();
					String actor2First = addFr.getActor2First();
					String actor2Last = addFr.getActor2Last();
					String actor3First = addFr.getActor3First();
					String actor3Last = addFr.getActor3Last();
					String genre = (String) addFr.getGenreBox().getSelectedItem();
					String mpaa = (String) addFr.getMpaaRatingBox().getSelectedItem();
				}else{
					System.out.println("That didn't work");
				}

				
				
				//TODO
			}
		});
	}
	
	private static void getLogOutButton(){
		addFr.getLogOut().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				addFr.setVisible(false);
				logFr.setVisible(true);
			}
		});
	}
	

}
