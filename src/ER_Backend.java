//This code is based off of https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm

//STEP 1. Import required packages
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ER_Backend {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/cs532"; //change depending on database

	//  Database credentials
	static Credentials c = new Credentials();
	static final String USER = c.user;
	static final String PASS = c.passwd;

	//Using main only for isolated testing, comment out when using with UI
	public static void main (String[] args) {

		System.out.println("First test: Print all patients");
		List<Patient> patientList = returnPatientInfoAll();
		for (int i=0; i<patientList.size(); i++) {
			patientList.get(i).printInfo();
		}

		System.out.println("Second test: Print patient with id=10");
		Patient p = returnPatient(10);
		p.printInfo();

		System.out.println("Third test: Create a new patient and return it from database");
		Patient p2 = new Patient();
		p2.pid = 21;
		p2.pfirstname = "tfirstname";
		p2.plastname = "tlastname";
		p2.tnumber = 0;
		p2.address = "testaddress";
		p2.iid = 0;
		p2.dob = "2020-01-01";
		p2.gender = "tgender";
		p2.pcp = 0;
		createPatient(p2);
		patientList = returnPatientInfoAll();
		for (int i=0; i<patientList.size(); i++) {
			patientList.get(i).printInfo();
		}

		System.out.println("Fourth test: Delete a patient and show all patients");
		deletePatient(21);
		patientList = returnPatientInfoAll();
		for (int i=0; i<patientList.size(); i++) {
			patientList.get(i).printInfo();
		}
	}

	public ER_Backend() {

	}

	public static boolean createPatient(Patient p) {
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			//STEP 4: Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();

			//TODO: fix date input
			String sql = "INSERT INTO Patients " +
					"VALUES ("+
					p.pid+", "+
					"'"+p.pfirstname+"'"+", "+
					"'"+p.plastname+"'"+", "+
					p.tnumber+", "+
					"'"+p.address+"'"+", "+
					p.iid+", "+
					"'"+p.dob+"'"+", "+
					"'"+p.gender+"'"+", "+
					p.pcp+
					")";
			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			return false;
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
			return false;
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
		return true;
	}

	public static boolean deletePatient(int id) {
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "DELETE FROM Patients " +
					"WHERE pid = "+id;
			stmt.executeUpdate(sql);
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			return false;
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
			return false;
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
		return true;
	}

	public boolean createMedicalEncounter(MedicalEncounter me) {
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			//STEP 4: Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();

			//TODO: fix date input
			String sql = "INSERT INTO MedicalEncounter " +
					"VALUES ("+
					"'"+me.dateinput+"'"+", "+
					me.eid+", "+
					me.pid+", "+
					"'"+me.complaints+"'"+", "+
					me.heartrate+", "+
					"'"+me.bloodpressure+"'"+", "+
					me.temperature+", "+
					"'"+me.notes+"'"+", "+
					"'"+me.diagnosis+"'"+", "+
					"'"+me.treatment+"'"+", "+
					"'"+me.referral+"'"+", "+
					"'"+me.datefollowup+"'"+
					")";
			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			return false;
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
			return false;
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
		return true;
	}

	public List<MedicalEncounter> returnMedicalEncounter(int pid) {
		Connection conn = null;
		Statement stmt = null;
		List<MedicalEncounter> meList = new ArrayList<MedicalEncounter>();
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM MedicalEncounter WHERE pid="+pid;
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				MedicalEncounter me = new MedicalEncounter();
				//Retrieve by column name

				me.dateinput = rs.getString("dateinput");
				me.eid = rs.getInt("eid");
				me.pid = rs.getInt("pid");
				me.complaints = rs.getString("complaints");
				me.heartrate = rs.getInt("heartrate");
				me.bloodpressure = rs.getString("bloodpressure");
				me.temperature = rs.getFloat("temperature");
				me.notes = rs.getString("notes");
				me.diagnosis = rs.getString("diagnosis");
				me.treatment = rs.getString("treatment");
				me.referral = rs.getString("referral");
				me.datefollowup = rs.getString("datefollowup");
				
				meList.add(me);
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
		return meList;
	}
	
	public boolean createLabOrder(LabOrder lo) {
		return false;
	}

	public static Patient returnPatient(int id) {
		Connection conn = null;
		Statement stmt = null;
		Patient patient = new Patient();
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM Patients WHERE pid="+id;
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				patient.pid = rs.getInt("pid");
				patient.pfirstname = rs.getString("pfirstname");
				patient.plastname = rs.getString("plastname");
				patient.tnumber = rs.getInt("tnumber");
				patient.address = rs.getString("address");
				patient.iid = rs.getInt("iid");
				patient.dob = rs.getString("dob");
				patient.gender = rs.getString("gender");
				patient.pcp = rs.getInt("pcp");
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
		return patient;
	}

	public static List<Patient> returnPatientInfoAll() {
		Connection conn = null;
		Statement stmt = null;
		List<Patient> patientList = new ArrayList<Patient>();
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

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
				patient.dob = rs.getString("dob");
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

	public int getMaxID() {
		List<Patient> patientList = returnPatientInfoAll();
		int id = 0;
		for (int i=0; i<patientList.size(); i++)
		{
			if (patientList.get(i).pid > id) {
				id = patientList.get(i).pid;
			}
		}
		return id;
	}

	public String createDate(int year, int month, int day) {
		return year+"-"+month+"-"+day;
	}

}//end ER_Backend
