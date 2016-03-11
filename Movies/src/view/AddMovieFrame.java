package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMovieFrame extends JFrame{
	
	private static final int LOGO_SIZE = 25;

	private final Color upperColor = new Color(164,194,244);
	private JPanel upperPanel;
	
	
	private JTextField titleField;
	private JTextField runTime;
	private JTextField releaseDate;
	private JTextField boxOffice;
	private JTextField director;
	private JTextField actor1;
	private JTextField actor2;
	private JTextField actor3;
	
	private JComboBox<String> mpaaRatingBox;
	private JComboBox<String> genreBox;
	
	private JButton logOut;
	private JButton addMovie;
	
	public AddMovieFrame(ArrayList<String> genreList, ArrayList<String> mpaaList) {
		super("Reel Log");
		String[] mpaas = new String[mpaaList.size()];
		mpaas = mpaaList.toArray(mpaas);
		mpaaRatingBox = new JComboBox<String>(mpaas);
		
		String[] genres = new String[genreList.size()];
		genres = genreList.toArray(genres);
		genreBox = new JComboBox<String>(genres);
		
		setUp();
		
	
	}
	
	private void setUp(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, screenSize.width/2, screenSize.height/2);
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buildUpper();
		buildCenter();
		this.setVisible(true);
	}
	
	
	
	private void buildCenter() {
		JPanel centerPanel = new JPanel();
		Box wholeBox = Box.createVerticalBox();
		
		Box titleBox = Box.createHorizontalBox();
		JLabel titleLabel = new JLabel("Title: ");
		titleField = new JTextField("", 15);
		titleBox.add(titleLabel);
		titleBox.add(titleField);
		wholeBox.add(titleBox);
		
		Box runBox = Box.createHorizontalBox();
		JLabel runTimeL = new JLabel("Run Time: ");
		runTime = new JTextField("", 15);
		runBox.add(runTimeL);
		runBox.add(runTime);
		wholeBox.add(runBox);
		
		Box releaseBox = Box.createHorizontalBox();
		JLabel rLabel = new JLabel("Box Office: ");
		releaseDate = new JTextField("", 15);
		releaseBox.add(rLabel);
		releaseBox.add(releaseDate);
		wholeBox.add(releaseBox);
		
		Box boxBox = Box.createHorizontalBox();
		JLabel bLabel = new JLabel("Box Office(only numbers!): ");
		boxOffice = new JTextField("", 15);
		boxBox.add(bLabel);
		boxBox.add(boxOffice);
		wholeBox.add(boxBox);
		
		Box dBox = Box.createHorizontalBox();
		JLabel dLabel = new JLabel("Director: ");
		director = new JTextField("", 15);
		dBox.add(dLabel);
		dBox.add(director);
		wholeBox.add(dBox);
		
		Box a1Box = Box.createHorizontalBox();
		JLabel a1Label = new JLabel("Actor 1: ");
		actor1 = new JTextField("", 15);
		a1Box.add(a1Label);
		a1Box.add(actor1);
		wholeBox.add(a1Box);
		
		Box a2Box = Box.createHorizontalBox();
		JLabel a2Label = new JLabel("Actor 2: ");
		actor2 = new JTextField("", 15);
		a2Box.add(a2Label);
		a2Box.add(actor2);
		wholeBox.add(a2Box);
		
		Box a3Box = Box.createHorizontalBox();
		JLabel a3Label = new JLabel("Actor 3: ");
		actor3 = new JTextField("", 15);
		a3Box.add(a3Label);
		a3Box.add(actor3);
		wholeBox.add(a3Box);
		
		
		
		Box ratingBox = Box.createHorizontalBox();
		JLabel mppaL = new JLabel("MPAA: ");
		ratingBox.add(mppaL);
		ratingBox.add(mpaaRatingBox);
		wholeBox.add(ratingBox);
		
		Box gBox = Box.createHorizontalBox();
		JLabel genreL = new JLabel("Genre: ");
		gBox.add(genreL);
		gBox.add(genreBox);
		wholeBox.add(gBox);
		
		addMovie = new JButton("Add Movie");
		wholeBox.add(addMovie);
		
		
		centerPanel.add(wholeBox);
		add(centerPanel, BorderLayout.CENTER);
		
	}

	private void buildUpper() {
		
		upperPanel = new JPanel();
		JLabel reelLogo = new JLabel("Reel Log");
		reelLogo.setFont(new Font("Courier", Font.PLAIN, LOGO_SIZE));
		reelLogo.setOpaque(true);
		reelLogo.setAlignmentX(.5f);
		reelLogo.setBackground(upperColor);
		
		logOut = new JButton("Log Out");
		logOut.setAlignmentX(.5f);
		
		Box upperBox = Box.createVerticalBox();
		upperBox.add(reelLogo);
		upperPanel.add(upperBox);
		upperPanel.setBackground(upperColor);
		add(upperPanel, BorderLayout.NORTH);
		
	}

	public JTextField getRunTime() {
		return runTime;
	}
	
	public JTextField getMovieTitle() {
		return titleField;
	}
	
	
	
	public JTextField getReleaseDate() {
		return releaseDate;
	}
	
	public JTextField getBoxOffice() {
		return boxOffice;
	}
	
	public JTextField getDirector() {
		return director;
	}
	
	public JTextField getActor1() {
		return actor1;
	}
	
	public JTextField getActor2() {
		return actor2;
	}
	
	public JTextField getActor3() {
		return actor3;
	}
	
	public JComboBox<String> getMpaaRatingBox() {
		return mpaaRatingBox;
	}
	
	public JComboBox<String> getGenreBox() {
		return genreBox;
	}
	
	public JButton getLogOut(){
		return logOut;
	}
	
	public JButton getAddButton(){
		return addMovie;
	}
	
	
}
