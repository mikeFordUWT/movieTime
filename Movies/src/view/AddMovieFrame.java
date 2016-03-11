package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class AddMovieFrame extends JFrame{
	
	private static final int LOGO_SIZE = 25;
	private static final int FONT = 12;

	private final Color upperColor = new Color(164,194,244);
	private JPanel upperPanel;
	
	
	private JTextField titleField;
	private JTextField runTime;
	private JTextField releaseDate;
	private JFormattedTextField boxOffice;
	private JTextField directorFirst;
	private JTextField directorLast;
	private JTextField actor1First;
	private JTextField actor1Last;
	private JTextField actor2First;
	private JTextField actor2Last;
	private JTextField actor3First;
	private JTextField actor3Last;
	
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
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numFormat = new NumberFormatter(longFormat);
		numFormat.setValueClass(Long.class);
		numFormat.setAllowsInvalid(false);
		numFormat.setMinimum(0l);
		
		Box titleBox = Box.createHorizontalBox();
		JLabel titleLabel = new JLabel("Title: ");
		titleField = new JTextField("", 15);
		titleBox.add(titleLabel);
		titleBox.add(titleField);
		wholeBox.add(titleBox);
		
		
		
		Box runBox = Box.createHorizontalBox();
		JLabel runTimeL = new JLabel("Run Time(numbers only, in mins): ");
		runTime = new JFormattedTextField(numFormat);
		runBox.add(runTimeL);
		runBox.add(runTime);
		wholeBox.add(runBox);
		
		Box releaseBox = Box.createHorizontalBox();
		JLabel rLabel = new JLabel("Release Year: ");
		releaseDate = new JFormattedTextField(numFormat);
		releaseBox.add(rLabel);
		releaseBox.add(releaseDate);
		wholeBox.add(releaseBox);
		
		Box boxBox = Box.createHorizontalBox();
		JLabel bLabel = new JLabel("Box Office(only numbers!): ");
		
		boxOffice = new JFormattedTextField(numFormat);
		boxBox.add(bLabel);
		boxBox.add(boxOffice);
		wholeBox.add(boxBox);
		
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
		
		Box dBox = Box.createHorizontalBox();
		JLabel dLabel = new JLabel("Director |  First: ");
		JLabel dLabel2 = new JLabel("   Last: ");
		directorFirst = new JTextField("", 15);
		directorLast = new JTextField("", 15);
		dBox.add(dLabel);
		dBox.add(directorFirst);
		dBox.add(dLabel2);
		dBox.add(directorLast);
		wholeBox.add(dBox);
		
		Box a1Box = Box.createHorizontalBox();
		JLabel a1Label = new JLabel("Actor 1 |  First: ");
		JLabel a1Label2 = new JLabel("   Last: ");
		actor1First = new JTextField("", 15);
		actor1Last = new JTextField("", 15);
		a1Box.add(a1Label);
		a1Box.add(actor1First);
		a1Box.add(a1Label2);
		a1Box.add(actor1Last);
		wholeBox.add(a1Box);
		
		Box a2Box = Box.createHorizontalBox();
		JLabel a2Label = new JLabel("Actor 2 |  First: ");
		JLabel a2Label2 = new JLabel("  Last: ");
		actor2First = new JTextField("", 15);
		actor2Last = new JTextField("", 15);
		a2Box.add(a2Label);
		a2Box.add(actor2First);
		a2Box.add(a2Label2);
		a2Box.add(actor2Last);
		wholeBox.add(a2Box);
		
		Box a3Box = Box.createHorizontalBox();
		JLabel a3Label = new JLabel("Actor 3 |  First: ");
		JLabel a3Label2 = new JLabel("  Last: ");
		actor3First = new JTextField("", 15);
		actor3Last = new JTextField("", 15);
		a3Box.add(a3Label);
		a3Box.add(actor3First);
		a3Box.add(a3Label2);
		a3Box.add(actor3Last);
		wholeBox.add(a3Box);
		
		
		
		
		
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
		upperBox.add(logOut);
		upperPanel.add(upperBox);
		upperPanel.setBackground(upperColor);
		add(upperPanel, BorderLayout.NORTH);
		
	}

	public String getMovieTitle() {
		return titleField.getText();
	}
	
	public String getRunTime() {
		return runTime.getText();
	}
	
	
	
	
	
	public String getReleaseDate() {
		return releaseDate.getText();
	}
	
	public String getBoxOffice() {
		return boxOffice.getText();
		
	}
	
	public String getDirectorFirst() {
		return directorFirst.getText();
	}
	
	public String getDirectorLast(){
		return directorLast.getText();
	}
	
	public String getActor1First() {
		return actor1First.getText();
	}
	
	public String getActor1Last(){
		return actor1Last.getText();
	}
	public String getActor2First() {
		return actor2First.getText();
	}
	
	public String getActor2Last(){
		return actor2Last.getText();
	}
	
	public String getActor3First() {
		return actor3First.getText();
	}
	
	public String getActor3Last(){
		return actor3Last.getText();
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
