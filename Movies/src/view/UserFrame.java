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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import data.Movie;
import data.User;

public class UserFrame extends JFrame {
	private User currentUser;

	private final int LOGO_SIZE = 25;
	
	private final int WELCOME_SIZE = 20;
	private int height;
	private int width;
	
	private ArrayList<Movie> favorites;
	private ArrayList<Movie> watchList;
	
	
	private JLabel reelLogo;
	
	private JLabel logOut;
	
	private JPanel upperPanel;
	private JPanel centerPanel;
	
	private JLabel welcome;
	
	private JTextField searchText;
	private JComboBox<String> searchType;
	private JButton searchButton;
	
	private JTable favTable;
	private JTable watchTable;
	
	private Dimension screenSize;
	
	public UserFrame(User inputUser) {
		
		super("Reel Log");
		currentUser = inputUser;
		
		
		setUp();
		pack();
		
	}


	
	private void setUp(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100,100, screenSize.width/2, screenSize.height/2);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildFrame();
		this.setVisible(true);
	}
	
	private void buildFrame() {	
		buildUpper();
		buildCenter();
	}
	
	private void buildUpper(){
		Box upperBox = Box.createVerticalBox();
		
		Color back = new Color(164,194,244);
		upperPanel = new JPanel();
		
		reelLogo = new JLabel("Reel Log");
		reelLogo.setFont(new Font("Courier", Font.PLAIN, LOGO_SIZE));
		reelLogo.setOpaque(true);
		reelLogo.setAlignmentX(.5f);
		reelLogo.setBackground(back);
		
		logOut = new JLabel("<HTML><U>LOG OUT</U></HTML>");
		logOut.setAlignmentX(.5f);
		
		upperBox.add(reelLogo);
		upperBox.add(logOut);
		upperPanel.add(upperBox);
		
		upperPanel.setBackground(back);
		add(upperPanel, BorderLayout.NORTH);
	}
	
	private void buildCenter(){
		addFavorites();
		addWatchList();
		welcome = new JLabel("Welcome, " + currentUser.getFirstName());
		welcome.setFont(new Font("San Serif", Font.PLAIN, WELCOME_SIZE));
		centerPanel = new JPanel();
		Box mainBox = Box.createVerticalBox();
		Box searchBox = Box.createHorizontalBox();
		
		searchText = new JTextField("", 15);
		searchButton = new JButton("Search");
		String[] choices = {"actor", "director", "movie"};
		searchType = new JComboBox<String>(choices);
		searchBox.add(searchType);
		searchBox.add(searchText);
		searchBox.add(searchButton);
		
		Box listBox = Box.createHorizontalBox();
		
		mainBox.add(welcome);
		
		
		JScrollPane favScroll = new JScrollPane(favTable);
		JScrollPane watchScroll = new JScrollPane(watchTable);
		listBox.add(favScroll);
		listBox.add(watchScroll);
		listBox.setBackground(Color.WHITE);
		mainBox.add(searchBox);
		mainBox.add(listBox);
		centerPanel.add(mainBox);
		
		
		add(centerPanel, BorderLayout.CENTER);
		
	}

	private void addFavorites(){
		DefaultTableModel model = new DefaultTableModel();
		favTable = new JTable(model);
		favorites = currentUser.getFavorites();
		model.addColumn("Favorites");
		for(int i = 0; i<favorites.size(); i++){
			model.addRow(new String[]{favorites.get(i).getTitle()});
		}
		
	}
	
	private void addWatchList(){
		DefaultTableModel model = new DefaultTableModel();
		watchTable = new JTable(model);
		watchList = currentUser.getWatchList();
		model.addColumn("Watch List");
		for(int i =0; i< watchList.size(); i++){
			model.addRow(new String[]{watchList.get(i).getTitle()});
		}
		
	}
	
	public void setUser(User inputUser){
		currentUser = inputUser;
	}
	
	public JLabel getLogOut() {
		return logOut;
	}
	
	public JButton getSearchButton(){
		return searchButton;
	}
	
	public String getSearchText(){
		return searchText.getText();
	}
	
	public JComboBox<String> getSearchType(){
		return searchType;
	}

	
	
}
