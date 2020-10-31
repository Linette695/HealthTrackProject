//This code is based off of https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm

//STEP 1. Import required packages
import java.sql.*;

public class UserInstance {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/cs532"; //change depending on database

   //  Database credentials
   //static final String USER = "root";
   //static final String PASS = "root";
   static String USER;
   static String PASS;
   
   public UserInstance() {
	   USER = "root";
	   PASS = "root";
   }
   public UserInstance(String username, String password) {
	   USER = username;
	   PASS = password;
   }

   public void changeLogin(String username, String password) {
	   USER = username;
	   PASS = password;
   }

   public boolean checkLogin() {
	   Connection conn = null;
	   try{
	//STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 6: Clean-up environment
	      conn.close();
	      return true;
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      //se.printStackTrace();
	      return false;
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      //e.printStackTrace();
	      return false;
	   }finally{
	      //finally block used to close resources
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         //se.printStackTrace();
	      }//end finally try
	   }//end try
	   //System.out.println("Goodbye!"); 
   }

   public static void showPatients() {
   Connection conn = null;
   Statement stmt = null;
   try{
//STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      //sql = "SELECT id, first, last, age FROM Employees";
      sql = "SELECT pid, pfirstname, plastname FROM Patients";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("pid");
         String first = rs.getString("pfirstname");
         String last = rs.getString("plastname");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
      }
      //STEP 6: Clean-up environment
      rs.close();
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
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end FirstExample