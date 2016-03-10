package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Actor;
import data.Director;
import data.Movie;

@SuppressWarnings("serial")
public class SearchResultFrame<E> extends JFrame{
	private static final int LOGO_SIZE = 0;
	private JComboBox<String> resultBox;
	private ArrayList<E> searchList;
	
	private JLabel reelLogo;
	private JPanel upperPanel;
	private JLabel logOut;
	
	public SearchResultFrame(ArrayList<E> inputList) {
		super("Reel Log");
		searchList = inputList;
		resultBox = new JComboBox<String>();
		addResults();
		setUp();
		
	}
	
	private void addResults(){
		if(searchList.getClass().equals(Movie.class)){
			for(int i = 0; i<searchList.size(); i++){
				resultBox.addItem(((Movie) searchList.get(i)).getTitle());
			}
		}else if(searchList.getClass().equals(Actor.class)){
			for(int i = 0; i<searchList.size(); i++){
				String name = ((Actor) searchList.get(i)).getFirstName() + " " + ((Actor) searchList.get(i)).getLastName();
				resultBox.addItem(name);
			}
		} else if(searchList.getClass().equals(Director.class)){
			for(int i = 0; i<searchList.size(); i++){
				String name = ((Director) searchList.get(i)).getFirstName() + " " + ((Director) searchList.get(i)).getLastName();
				resultBox.addItem(name);
			}
		}
		
	}
	
	private void setUp(){
		buildUpper();
		buildCenter();
	}
	
	private void buildCenter(){
		
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
	
	public JComboBox<String> getResultBox(){
		return resultBox;
	}
}
