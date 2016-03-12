package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.DatabaseAccess;
import data.Movie;

/**
 * 	Frame for holding moving info
 * 
 *  @author Michael Ford and Andy Bleich
 *
 */

public class MovieFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static final int LOGO_SIZE = 25;

	//The movie a page will be based on
	private Movie myMovie;


	//Labels for diplaying info about the movie.
	private JLabel title;
	private JLabel rating;
	private JLabel runTime;
	private JLabel releaseYear;
	private JLabel myActors;
	private JLabel reelLogo;
	private JLabel avgRating;
	
	
	
	private JPanel northPanel;
	private JPanel centerPanel;
	
	private JButton homeButton;
	private JButton favAdd;
	private JButton watchAdd;
	private JButton logOut;
	private JButton rateButton;
	
	
	private LogInFrame logFr;
	private UserFrame userFr;
	
	private JComboBox<Integer> movieRatingBox;
	
	
	private Color upperBarColor;
	private Box upperBox;
	
	private Box movieInfoBox;
	private Box movieBox;

	//A Movie Frame for is a user is logged in.
	public MovieFrame(Movie inputMovie, LogInFrame log, UserFrame user) {
		super("Reel Log");
		logFr =log;
		myMovie = inputMovie;
		userFr = user;

		buildFrame();
	
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		movieRate(this);
		movieLogOut(this);
		movieHomeListen(this);
		movieAddWatchListen(this);
		movieAddFav(this);
	}


	private void buildFrame(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, screenSize.width/2, screenSize.height/2);
		buildUpper();
		buildCenter();
		add(northPanel,BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	
	private void buildCenter(){
		Integer[] ratings = {1,2,3,4,5};
		
		JLabel ratingLabel = new JLabel("Rate: ");
		movieRatingBox = new JComboBox<Integer>(ratings);
		centerPanel = new JPanel();
		watchAdd = new JButton("Add to WatchList");
		favAdd = new JButton("Add to Favorites");
		movieBox = Box.createHorizontalBox();
		movieInfoBox = Box.createVerticalBox();
		movieBox.add(movieInfoBox);
		
		title = new JLabel(myMovie.getTitle());
		title.setFont(new Font("Sans Serif", Font.BOLD, 16));
		rating = new JLabel(myMovie.getMPAA());
		int hours = myMovie.getRunTime()/60;
		int minutes = myMovie.getRunTime()%60;
		String hrMin = String.valueOf(hours) + "hrs "+ String.valueOf(minutes)+"mins";
		runTime = new JLabel(hrMin);
		releaseYear = new JLabel(String.valueOf(myMovie.getYear()));
		String actors = myMovie.getActors(myMovie.getActorList());
		myActors = new JLabel(actors);
		
		movieInfoBox.add(title);
		String ratingTime = rating + " | " + runTime;
		movieInfoBox.add(rating);
		movieInfoBox.add(runTime);
		movieInfoBox.add(releaseYear);
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(favAdd);
		buttonBox.add(watchAdd);
		Box avgRateBox = Box.createHorizontalBox();
//		JLabel aR = new JLabel("Average Rating:  ");
//		avgRateBox.add(aR);
//		avgRateBox.add(avgRating);
		
		Box ratingBox = Box.createHorizontalBox();
		rateButton = new JButton("Rate");
//		ratingBox.add(ratingLabel);
//		ratingBox.add(movieRatingBox);
//		ratingBox.add(rateButton);
		movieInfoBox.add(buttonBox);
		movieInfoBox.add(avgRateBox);
		movieInfoBox.add(ratingBox);
		
		
		centerPanel.add(movieBox);
	}
	
	private void buildUpper(){
		
		
		northPanel = new JPanel();
		Box mainUpper = Box.createVerticalBox();
		upperBox = Box.createHorizontalBox();
		upperBarColor = new Color(164,194,244);
		
		reelLogo = new JLabel("Reel Log");
		reelLogo.setFont(new Font("Courier", Font.PLAIN, LOGO_SIZE));
		reelLogo.setOpaque(true);
		reelLogo.setAlignmentX(.5f);
		reelLogo.setForeground(Color.BLACK);
		reelLogo.setBackground(upperBarColor);
		
		
		homeButton = new JButton("Home");
		homeButton.setBackground(upperBarColor);
		
		logOut = new JButton("LOG OUT");
		mainUpper.add(reelLogo);
		
		northPanel.setBackground(upperBarColor);
		upperBox.add(homeButton);
		upperBox.add(logOut);
		upperBox.setBackground(upperBarColor);
		mainUpper.add(upperBox);
		northPanel.add(mainUpper);

	}
	
	public JButton getHomeButton(){
		return homeButton;
	}
	
	public JButton getFavAdd(){
		return favAdd;
	}
	
	public JButton getWatchAdd(){
		return watchAdd;
	}

	public Movie getMovie(){
		return myMovie;
	}
	
	public JButton getLogOut(){
		return logOut;
	}

	public JComboBox<Integer> getRatingBox(){
		return movieRatingBox;
	}
	
	public JButton getRateButton(){
		return rateButton;
	}

	private void movieRate(MovieFrame movieFr){
		movieFr.getRateButton().addMouseListener(new MouseAdapter(){
			private String userID;
			private String movieID;

			@Override
			public void mouseClicked(MouseEvent e){
				int rating = (int) movieFr.getRatingBox().getSelectedItem();
				try {
					DatabaseAccess.InsertRating(userID, movieID, rating);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//TODO add rating to user-movie rating
			}
		});
	}
	
	private void movieLogOut(MovieFrame movieFr){
		movieFr.getLogOut().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				movieFr.setVisible(false);
				logFr.setVisible(true);
			}
		});
	}
	
	private void movieHomeListen(MovieFrame movieFr){
		movieFr.getHomeButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				movieFr.setVisible(false);
				userFr.setVisible(true);
			}
		});
	}
	
	private  void movieAddWatchListen(MovieFrame movieFr){
		movieFr.getWatchAdd().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			try {
				DatabaseAccess.AddToWatchInsert(userFr.getUser().getID(), myMovie.getID());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
	}
	
	private  void movieAddFav(MovieFrame movieFr){
		movieFr.getFavAdd().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				try {
					DatabaseAccess.addToFavoritesUpdate(userFr.getUser().getID(), myMovie.getID());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
