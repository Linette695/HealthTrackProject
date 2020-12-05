import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.util.Date;


public class Report {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/cs532";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "password";

	static int month = 0;
	static Number day = 0;
	static int physID = 0;
	static String physName;
	
	public Report(int selmonth, Number selday, int selphys, String physN) {
		this.month = selmonth;
		this.day = selday;
		this.physID = selphys+1;
		this.physName = physN;
	}

	//stmt.executeUpdate(x)
	public static void getfromDB() {

		Scanner scnr = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			
			String sql = "SELECT * from events where doctorid = " + physID + " and start BETWEEN '2020-" + month + "-" + day + " 00:00:00' AND '2020-" + month + "-" + day + " 23:59:59';";

			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("Generated Report from 2020-" + month + "-" + day + ", Physician: " + physName);
			System.out.print(System.lineSeparator());
			
			
			while(rs.next()){
		         //Retrieve by column name
		         int rsEID  = rs.getInt("eventid");
		         int rsPID  = rs.getInt("patientid");
		         int rsDID  = rs.getInt("doctorid");
		         String rsType = rs.getString("eventtype");
		         Date rsStart = rs.getDate("start");
		         Date rsEnd = rs.getDate("end");

		         //Display values
		         System.out.print("Patient ID: " + rsPID);
		         System.out.print(", Event Type: " + rsType);
		         System.out.print(", Start Time: " + rsStart);
		         System.out.println(", End Time: " + rsEnd);
		      }
			rs.close();

			//STEP 6: Clean-up environment
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}

		return;
	}

}
