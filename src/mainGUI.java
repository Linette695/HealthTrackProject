
/*IMPORTS:*/
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

public class mainGUI implements ActionListener {
	
	//UserInstance
			//UserInstance userInstance = new UserInstance();

		/*GUI VARIABLES*/
		static String appName = "Health Track";		//Name of the application
		
		//FRAMES
		static JFrame mainFrame;					//Main frame for the welcome screen
		static JFrame logInFrame;					//Frame for the Log in screen
		
		//PANELS
		static JPanel welcomePanel;					//Panel to display the welcome window
		static JPanel welcomeButtonPanel;			//To hold the buttons for the welcome window
		static JPanel logInPanel;					//Panel to display the Log in window 
		
		//LABELS
		static JLabel titleLabel;					//Label to display the title of the application on welcome window
		static JLabel emptySpace = new JLabel("                   ");			//Place holder, an empty label
		static JLabel logOnAsLabel;					//Label for "Log On As" instructions
		static JLabel userNameLabel;				//Label for "User name" instructions
		static JLabel passwordLabel;				//Label for "password" instructions
		
		//MENU BARS
		static JMenuBar logOnAsMenuBar;				//Menu bar to hold the "log on as" info
		static JMenuBar usernameMenuBar;			//Menu bar to hold the "usertype" info
		static JMenuBar passwordMenuBar;			//Menu bar to hold the "password" info
		static JMenuBar enterMenuBar;				//Menu bar to hold the enter button info
		
		
		//MENUS
		static JMenu userTypeMenu;					//Menu to hold all the user types allowed to log in to the system
		
		//BUTTONS
		static JButton logInButton;					//Button to log in on welcome window
		static JButton exitButton;					//Button for exit option on welcome window
		static JButton physicianButton;				//Button for physician user type
		static JButton physicianAssitantButton;		//Button for physician assistant user type
		static JButton enterButton;					//Button for entering log in information		
		
		//TEXT FIELDS
		static JTextField usernameInput;			//Input area to obtain the user name
		
		//FONTS
		static Font buttonFont = new Font("Malgun Gothic", Font.PLAIN, 27);
		static Font instructionFont = new Font("Malgun Gothic", Font.BOLD, 24);
		
		//BORDERS
		static Border buttonBorder = BorderFactory.createLineBorder(Color.white);
		static Border inputBorder = BorderFactory.createLineBorder(Color.white, 1, true); 
		static Border menuBarBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		
		//PASSWORD FIELDS
		static JPasswordField passwordInput; 		//Password input area for log in window
		
	/*DATA VARIABLES*/
		static String userTypeInputed;				//To hold the type of user that was selected
		static String userNameInputed;				//To hold the user name inputed 
		static String passwordInputed;				//To hold the password inputed
		//static Dashboard dashBoard;					//Variable for the dashboard of the GUI 
		static DASH_UI DASHBoard;					//Variable for the dashboard of the GUI 
		
	
	/*Constructor*/
		mainGUI(){
			//CREATE THE MAIN FRAME: used as the initial main window
			mainFrame = new JFrame(appName);	//Create the initial window frame
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	//Sets what happens when window closes
			mainFrame.setSize(700, 600);		//Set the size of the main window frame
			
			
	        
	        //MAKE INITIAL MAIN FRAME VISIBLE
	        mainFrame.setVisible(true);					//Make main window visible
	        mainFrame.setLocationRelativeTo(null);			//Display the main window in the center of screen
	        
			//Display the welcome page
	        welcomeWindow();
			
		}//End of constructor
	
		/*METHODS OF THE CLASS*/

		/*runLogInWindow: creates and runs the Log In screen*/
			public void runLogInWindow() {
				
				//MAKE MAIN/WELCOME FRAME NOT VISIBLE
				mainFrame.setVisible(false);		
				
				//CREATE THE LOG IN FRAME
				logInFrame = new JFrame("Log In to Health Track");	//Create the log in window frame
				logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	//Sets what happens when window closes
				logInFrame.setSize(700, 600);		//Set the size of the log in window frame
				      
				//MAKE LOG IN WINDOW VISIBLE
				logInFrame.setVisible(true);					//Make main window visible
				logInFrame.setLocationRelativeTo(null);			//Display the main window in the center of screen
				   
				
				//CREATE THE MAIN PANEL FOR THE LOG IN WINDOW
				logInPanel = new JPanel();
				logInPanel.setLayout(new GridLayout(7,2));
				logInPanel.setBackground(Color.LIGHT_GRAY);
				
				//CREATE THE "LOG ON AS" SECTION
				makeLogOnAsBar();
				
				//CREATE THE "USER NAME" AREA
				makeUserNameBar();
				
				//CREATE THE "PASSWORD" AREA
				makePasswordBar();
				
				//CREATE THE ENTER BUTTON AREA
				makeEnterBar();
				
				
				//MAKE THE LOG IN PANEL VISIBLE
				logInFrame.getContentPane().add(logInPanel);
				logInFrame.setVisible(true);
				
			}//End of runLogInWindow method
			

			
		/*logInProcess: is a method that gets implemented when the "Enter" button is clicked in the log in window. 
		* It obtains user's inputed information and verifies it*/
			public void logInProcess() {
				/*TODO what happens when user clicks "Enter": system collects user inputs and then we must connect to database to execute 
				 * verification of the inputed log in info (this validation should be done inside the "userVerify()" method, which returns if it was a 
				 * successful connection or not
				*/
				System.out.printf("Will check login info once databse is connected \n");
				//OBTAIN THE INPUTED INFORMATION
				userTypeInputed = userTypeMenu.getText();			//Obtain the user type selected
				userNameInputed = usernameInput.getText();			//Obtain the user name inputed
				passwordInputed = new String(passwordInput.getPassword());		//Obtain the password inputed
				
				System.out.printf(userTypeInputed + "\n");			//For Debug
				System.out.printf(userNameInputed + "\n");			//For Debug
				System.out.printf(passwordInputed + "\n");			//For Debug
				
				boolean userVerify = userVerify(userNameInputed, passwordInputed);		//Calls method that will check if the inputed user info (user name and password) is correct
				if(userVerify) {
					//TODO advance to the specific dash-board of the user, according to their user type 
					System.out.println("UI is automatically 'loging in' to a default dashboard");			//For Debug
					runDashBoard();	//Run the general dashboard for now, since I still need to implement user restrictions on dashboard
				}
				else {
					//TODO display error message window and let user input log in information again
					
				} 
				
			}//End of logInProcess method
			
			
			
			
		/*userVerify: checks if inputed information in the log in screen is valid according to the database. Can the user log in?*/
			public boolean userVerify(String userName, String password) {
				//TODO try to connect to database here (check if inputed userName and password is in the database )
				
//				System.out.println("Checking username and password: "+userName+" "+password);
//				userInstance.changeLogin(userName, password);
//				return userInstance.checkLogin();
//				
				
				return true;		//IT is currently automatically returning true as if the user has successfully connected to the database
				
				
				
				
			}//End of userVerify method
			
			
			
			
		/*runDashBoard: initiates the corresponding dashboard according to the logged in user*/
			public void runDashBoard() {
				DASHBoard = new DASH_UI();
			}//End of runDashBoard
			
		/*ACTION LISTENER*/
		/*actionPerformed: catches all the action events for buttons */
			public void actionPerformed(ActionEvent e) {
				
				if("Exit".equals(e.getActionCommand())) {
					mainFrame.dispose();				//Closes the welcome window because the exit button was clicked
				}//end of "Exit" trigger from the Exit button in the welcome window
				
				else if ("Log In".equals(e.getActionCommand())){
					runLogInWindow();	//call method to run the log in Window 
				}//end of "Log in" trigger from the Log in button in the welcome window
				
				else if ("Physician".contentEquals(e.getActionCommand())) {
					userTypeMenu.setText("Physician");						//Displays the option selected on the drop down menu
					userTypeMenu.setPopupMenuVisible(false);				//Minimize/close the drop down options 
				}//End of "Physician" trigger from when user selects physician as their user type
				
				else if("Physician Assistant".contentEquals(e.getActionCommand())) {
					userTypeMenu.setText("Physician Assistant");
					userTypeMenu.setPopupMenuVisible(false);				//Minimize/close the drop down options 
				}//End of "Physician Assistant" trigger from when user selects Physician Assistant as their user type
				
				else if("Enter".contentEquals(e.getActionCommand())) {
					/*TODO what happens when user clicks "Enter". logInMethod is still under implementation, must connect to database*/
					logInProcess();
			
				}//End of "Enter" trigger from the Enter button on the log in window 
				
			}//End of actionPerformed method
			
			
			
		/*HELPER METHODS TO CREATE THE LOG IN SCREEN*/
			public void makeLogOnAsBar() {
				//CREATE "LOG ON AS" MENU BAR
						logOnAsMenuBar = new JMenuBar();
						logOnAsMenuBar.setSize(700,100);
						logOnAsMenuBar.setBackground(Color.LIGHT_GRAY);
						logOnAsMenuBar.setBorder(menuBarBorder);
						
							//CREATE THE "LOG ON AS " LABEL
							logOnAsLabel = new JLabel("Log on as: ");
							logOnAsLabel.setFont(instructionFont);
							//CREATE THE INPUT/DROP DOWN MENU FOR "LOG ON AS:"
							userTypeMenu = new JMenu("Choose user type");		//Create the drop down menu
							userTypeMenu.setSize(350, 100);
							userTypeMenu.setFont(buttonFont);
							userTypeMenu.setBorder(buttonBorder);
							userTypeMenu.setBackground(Color.LIGHT_GRAY);
							
							
							
							physicianButton = new JButton("Physician");			//Creates the physician option button
							physicianButton.setFont(buttonFont);
							physicianButton.setActionCommand("Physician");
							physicianButton.addActionListener(this);
							
							physicianAssitantButton = new JButton("Physician Assistant"); //Creates the physician assistant option button
							physicianAssitantButton.setFont(buttonFont);
							physicianAssitantButton.setActionCommand("Physician Assistant");
							physicianAssitantButton.addActionListener(this);
							
							
							userTypeMenu.add(physicianButton);		//Adds the physician option to drop down menu
							userTypeMenu.add(physicianAssitantButton);		//Adds the physician assistant option to drop down menu
							
							
						logOnAsMenuBar.add( new JLabel("                   "));				//Add empty space for looks
						logOnAsMenuBar.add(logOnAsLabel);			//Add the "Log on as: " label
						logOnAsMenuBar.add(userTypeMenu);			//Add the user type menu to the "Log on as" bar
						logInPanel.add(logOnAsMenuBar);				//Add the Log on as menu bar to the log in main panel
						
				
			}//End of makeLogOnBar method
			
			public void makeUserNameBar() {
				
				//CREATE THE "USER NAME" BAR
				usernameMenuBar = new JMenuBar();
				usernameMenuBar.setSize(700,100);
				usernameMenuBar.setBackground(Color.LIGHT_GRAY);
				usernameMenuBar.setBorder(menuBarBorder);
				
					//CREATE THE "User Name: " LABEL
					userNameLabel = new JLabel("User name: ");
					userNameLabel.setFont(instructionFont);
					
				
					//CREATE THE INPUT BOX TO OBTAIN THE USER TYPE
					usernameInput = new JTextField();
					usernameInput.setBackground(Color.LIGHT_GRAY);
					usernameInput.setCaretColor(Color.GREEN);
					usernameInput.setFont(buttonFont);
					usernameInput.setBorder(inputBorder);
					usernameInput.setDisabledTextColor(Color.DARK_GRAY);
					
					
				usernameMenuBar.add( new JLabel("                   "));	//Add empty space for looks
				usernameMenuBar.add(userNameLabel);							//Add the description of where the user name is inputed
				usernameMenuBar.add(usernameInput);							//Add the input box for where the user name is inputed
				
				logInPanel.add(usernameMenuBar);				//Add the user name bar to the log in panel
				
			}//End of makeUserNameBar method

			public void makePasswordBar() {
				//CREATE THE "Password" BAR
				passwordMenuBar = new JMenuBar();
				passwordMenuBar.setSize(700,100);
				passwordMenuBar.setBackground(Color.LIGHT_GRAY);
				passwordMenuBar.setBorder(menuBarBorder);
				
					//CREATE THE "Password: " LABEL
					passwordLabel = new JLabel("Password: ");
					passwordLabel.setFont(instructionFont);
				
					//CREATE THE PASSWORD INPUT BOX TO OBTAIN THE USER PASSWORD
					passwordInput = new JPasswordField();
					passwordInput.setBackground(Color.LIGHT_GRAY);
					passwordInput.setCaretColor(Color.GREEN);
					passwordInput.setFont(buttonFont);
					passwordInput.setBorder(inputBorder);
					passwordInput.setDisabledTextColor(Color.DARK_GRAY);
					
					
				passwordMenuBar.add(new JLabel("                   "));			//Add empty space for looks
				passwordMenuBar.add(passwordLabel);								//Add the description to let user know this is where the password is inputed
				passwordMenuBar.add(passwordInput);								//Add the password input box 
				
				logInPanel.add(passwordMenuBar);								//Add the password bar to the log in panel
				
			}//End of makePasswordBar method
			
			public void welcomeWindow() {
				
				//CREATE THE MAIN PANEL: will hold the initial display information
		        welcomePanel = new JPanel(); 		//Create the main/welcome panel
		        welcomePanel.setLayout(new BorderLayout());				//Setup the layout of the main panel
		        welcomePanel.setBackground(Color.LIGHT_GRAY);				//Setup the color of the main panel
		       
		        
		        
		        //CREATE THE TITLE LABEL ON WELCOME WINDOW
				titleLabel = new JLabel("Welcome to Health Track:");
				titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 28));
				welcomePanel.add(titleLabel, BorderLayout.PAGE_START);
				
				//CREATE LOGIN BUTTON 
				logInButton = new JButton("Log In");
				logInButton.setFont(buttonFont);
				logInButton.setActionCommand("Log In");
				logInButton.addActionListener(this);
				//welcomePanel.add(logInButton, BorderLayout.CENTER);
				
				//CREATE THE EXIT BUTTON
				exitButton = new JButton("Exit");
				exitButton.setFont(buttonFont);
				exitButton.setActionCommand("Exit");
				exitButton.addActionListener(this);
		        
				//ADD PANEL FOR BUTTONS
				welcomeButtonPanel = new JPanel();
				welcomePanel.add(welcomeButtonPanel, BorderLayout.CENTER);
				
				//ADD THE BUTTONS TO THE BUTTON PANEL
				welcomeButtonPanel.add(logInButton);
				welcomeButtonPanel.add(exitButton);
				
				
		        //ADD THE WELCOME PANEL TO THE MAIN WINDOW FRAME
				mainFrame.getContentPane().add(welcomePanel);
				mainFrame.setVisible(true);

			}//End of welcomWindow method
			
			public void makeEnterBar() {
				
				//CREATE "Enter" MENU BAR
				enterMenuBar = new JMenuBar();
				enterMenuBar.setSize(700,100);
				enterMenuBar.setBackground(Color.LIGHT_GRAY);
				enterMenuBar.setBorder(menuBarBorder);
				
				//CREATE "Enter" BUTTON
				enterButton = new JButton("Enter");			//Creates the enter button
				enterButton.setFont(buttonFont);			//Sets the font of the enter button label
				enterButton.setActionCommand("Enter");		//Sets the trigger word "Enter" for when the eneter button is clicked
				enterButton.addActionListener(this);		//Sets the action listener of this class to listen for the "Enter" key word
				
				
				enterMenuBar.add(enterButton);				//Add "Enter" button to the enter bar
				
				
				logInPanel.add(enterMenuBar);				//Add the enter bar to the log in panel
				
			}//End of makeEnterBar method
			
		
	
	
	
	
	

	public static void main(String[] args) {
		//Start the app
		mainGUI runningApp = new mainGUI();
		
		
	}//End of main method

}//End of mainGUI class
