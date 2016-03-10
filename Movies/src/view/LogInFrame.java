package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Where every app starts and allows user to log in.
 * @author michaelford
 *
 */
public class LogInFrame extends JFrame {
	
	private HashMap<String, String> users;
	private static final int LOGO_SIZE = 18;
	private JTextField userName;
	private JTextField passField;
	private JLabel userLabel;
	private JLabel passLabel;
	private JButton logButton;
	private JPanel upPanel;
	private JPanel centerPanel;
	private JLabel reelLogo;
	
	
	private Color upperBarColor;
	private Box upperBox;
	private Box nameBox;
	private Box passBox;
	private Box logBox;
	
	public LogInFrame() {
		
		
		super("Reel Log");
		addUsers();
		userName = new JTextField("", 15);
		passField = new JTextField("", 15);
		userLabel = new JLabel("Username: ");
		passLabel = new JLabel("Password: ");
		logButton = new JButton("Log In");
		upperBarColor = new Color(164,194,244);
		centerPanel = new JPanel();
		reelLogo = new JLabel("Reel Log");
		reelLogo.setFont(new Font("Courier", Font.PLAIN, LOGO_SIZE));
		buildFrame();
		
		
	
	}
	
	private void buildFrame(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100,100, screenSize.width/2, screenSize.height/2);
		buildUpper();
		buildCenter();
		add(upPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	private void buildUpper(){
		
		
		upperBox = Box.createHorizontalBox();
		upperBox.add(reelLogo);
		upperBox.setBackground(upperBarColor);
		upPanel = new JPanel();
		upPanel.add(upperBox);
		upPanel.setBackground(upperBarColor);
	}
	
	private void addUsers(){
		users = new HashMap<String,String>();
		users.put("jilarson@uw.edu", "husky123");
		users.put("fordm13@uw.edu", "password");
		users.put("andybleich@gmail.com", "league19");
	}
	
	private void buildCenter(){
		
		logListen();
		nameBox = Box.createHorizontalBox();
		
		nameBox.add(userLabel);
		nameBox.add(userName);
		passBox = Box.createHorizontalBox();
		passBox.add(passLabel);
		passBox.add(passField);
		logBox = Box.createVerticalBox();
		logBox.add(nameBox);
		logBox.add(passBox);
		logBox.add(logButton);
		centerPanel.add(logBox);
		centerPanel.setBackground(Color.WHITE);
	}
	
	private void logListen(){
		logButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(users.containsKey(userName.getText())&& users.containsValue(passField.getText())){
					System.out.println("LOGIN SUCCESS!");
				} else {
					userName.setText("Invalid input");
					passField.setText("TRY AGAIN!");
				}
				
			}
		});
	}
	
	public HashMap<String,String> getUserMap(){
		return users;
	}
	
	public JButton getLogButton(){
		return logButton;
	}
	
	public String getUserName(){
		return userName.getText();
	}
	public String getPassword(){
		return passField.getText();
	}
	
	public JTextField getUserField(){
		return userName;
	}
	
	public JTextField getPassField(){
		return passField;
	}
}
