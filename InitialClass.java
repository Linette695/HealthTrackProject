/*IMPORTS:*/
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class InitialClass implements ActionListener {

	/*GUI Variables*/
	static String appName = "Health Track";		//Name of the application
	static JFrame mainFrame;					//Main frame for the UI
	static JPanel welcomePanel;					//Panel to display the welcome window
	
	
	
	
	/*CONSTRUCTORS*/
	InitialClass(){
		//CREATE THE MAIN FRAME: used as the initial main window
		mainFrame = new JFrame(appName);	//Create the initial window frame
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	//Sets what happens when window closes
		mainFrame.setSize(800, 700);		//Set the size of the main window frame
		
		
		//CREATE THE MAIN PANEL: will hold the initial display information
        welcomePanel = new JPanel(); 		//Create the main/welcome panel
        welcomePanel.setLayout(new BorderLayout());				//Setup the layout of the main panel
        welcomePanel.setBackground(Color.WHITE);				//Setup the color of the main panel
        
        
        //MAKE INITIAL WELCOME WINDOW VISIBLE
        mainFrame.setVisible(true);					//Make main window visible
        mainFrame.setLocationRelativeTo(null);			//Display the main window in the center of screen
        
		
	}//End of InitialClass constructor
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}//End of actionPerformed method
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		//Start the app
		InitialClass runningApp = new InitialClass();
		
	}//End of main method

}//End of InitialClass 
