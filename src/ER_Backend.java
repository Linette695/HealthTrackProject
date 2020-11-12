//This code is based off of https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm

//STEP 1. Import required packages
import java.sql.*;
import java.util.*;

public class ER_Backend {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/cs532"; //change depending on database

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	//Using main only for isolated testing, comment out when using with UI
	public static void main (String[] args) {
		List<Patient> patientList = returnPatientInfoAll();
		for (int i=0; i<patientList.size(); i++) {
			patientList.get(i).printInfo();
		}
	}

	public ER_Backend() {

	}

	public static List<Patient> returnPatientInfoAll() {
		Connection conn = null;
		Statement stmt = null;
		List<Patient> patientList = new ArrayList<Patient>();
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM Patients";
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				Patient patient = new Patient();
				//Retrieve by column name
				patient.pid = rs.getInt("pid");
				patient.pfirstname = rs.getString("pfirstname");
				patient.plastname = rs.getString("plastname");
				patient.tnumber = rs.getInt("tnumber");
				patient.address = rs.getString("address");
				patient.iid = rs.getInt("iid");
				patient.dob = rs.getDate("dob");
				patient.gender = rs.getString("gender");
				patient.pcp = rs.getInt("pcp");
				
				patientList.add(patient);
			}
			rs.close();
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
					conn.close();
			}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
		return patientList;
	}
}//end ER_Backend
