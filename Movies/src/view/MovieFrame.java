package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Movie;
import data.User;

public class MovieFrame extends JFrame {
	private static final int LOGO_SIZE = 0;

	//The movie a page will be based on
	private Movie myMovie;

	//A User for if a user is logged in.
	private User myUser;

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
	
	private JComboBox<Integer> movieRatingBox;
	
	
	private Color upperBarColor;
	private Box upperBox;
	
	private Box movieInfoBox;
	private Box movieBox;
	



//	//A Movie Frame for when a user is not logged in.
//	public MovieFrame(Movie inputMovie){
//		super("Reel Log");
//		myMovie = inputMovie;
//		buildNotLoggedFrame();
//	}

	//A Movie Frame for is a user is logged in.
	public MovieFrame(Movie inputMovie, User inputUser, double rating) {
		super("Reel Log");
		myMovie = inputMovie;
		myUser = inputUser;
		String rate = Double.toString(rating);
		avgRating = new JLabel(rate);
//		myUser = inputUser;
		buildFrame();
	
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
		JLabel aR = new JLabel("Average Rating:  ");
		avgRateBox.add(aR);
		avgRateBox.add(avgRating);
		
		Box ratingBox = Box.createHorizontalBox();
		rateButton = new JButton("Rate");
		ratingBox.add(ratingLabel);
		ratingBox.add(movieRatingBox);
		ratingBox.add(rateButton);
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
		upperBox.add(reelLogo);
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


}
