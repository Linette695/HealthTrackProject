import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Appointment {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/cs532";

	//  Database credentials
	static Credentials c = new Credentials();
	static final String USER = c.user;
	static final String PASS = c.passwd;

	public static int patientID;
	public static int selectedPhysician;
	public static String selectedType;

	public static int selectedstartmonth;
	public static int selectedstartday;
	public static int selectedstartyear = 2020;
	public static int selectedstarthour;
	public static int selectedstartminute = 22;

	public static int selectedendmonth;
	public static int selectedendday;
	public static int selectedendyear = 2020;
	public static int selectedendhour;
	public static int selectedendminute = 22;

	public Appointment(int pid, int physIndex, String stype, int smonth, int sday, int shour, int sminute, int emonth, int eday, int ehour, int eminute) {
		patientID = pid;
		selectedPhysician = physIndex + 1;
		selectedType = stype;
		selectedstartmonth = smonth + 1;
		selectedstartday = sday;
		selectedstarthour = shour;
		if (sminute == 0) {
			selectedstartminute = 0;
		} else {
			selectedstartminute = 30;
		}
		selectedendmonth = emonth + 1;
		selectedendday = eday;
		selectedendhour = ehour;
		if (eminute == 0) {
			selectedendminute = 0;
		} else {
			selectedendminute = 30;
		}
		System.out.println(patientID);
	}


	public static String startTime() {
		return "'"+selectedstartyear+"-"+selectedstartmonth+"-"+selectedstartday+" "+selectedstarthour+":"+selectedstartminute+":00'";
	}

	public static String endTime() {
		return "'"+selectedendyear+"-"+selectedendmonth+"-"+selectedendday+" "+selectedendhour+":"+selectedendminute+":00'";
	}

	//stmt.executeUpdate(x)
	public static String insertintoDB() {

		//Scanner scnr = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		String returnStatement = "Error in event DB insertion";
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();

			String sql = "INSERT INTO Events(patientid, doctorid, eventtype, start, end) VALUES (" + patientID + "," + selectedPhysician + ", '" + selectedType + "', " + startTime() + ", " + endTime() + ");";

			stmt.executeUpdate(sql);

			//STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			returnStatement = "Inserted Values (" + patientID + "," + selectedPhysician + ", '" + selectedType + "', " + startTime() + ", " + endTime() + ")";
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

		return returnStatement;
	}
}
