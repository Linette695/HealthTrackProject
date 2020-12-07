import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PS_Test {

    //setup variables to access database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/cs532"; //change depending on database
    static final String USER = "root";
    static final String PASS = "root";

    static boolean updateDatabase(String sql){

        boolean success = false;
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            success = true;

        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            }
            catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException se) {
                //se.printStackTrace();
            }
        }
        return success;
    }


    static String queryDatabaseString(String sql, Integer position){

        String resultString = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            resultString = rs.getString(position);
            rs.close();

        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            }
            catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (rs!= null)
                    rs.close();
            }
            catch (SQLException se) {
                //se.printStackTrace();
            }
        }
        return resultString;
    }


    static Integer queryDatabaseInt(String sql, Integer position){

        Integer resultInt = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            resultInt = rs.getInt(position);
            rs.close();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            }
            catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (rs!= null)
                    rs.close();
            }
            catch (SQLException se) {
                //se.printStackTrace();
            }
        }
        return resultInt;
    }

    @BeforeAll
    static void setupDatabase(){
        boolean success = false;

        final String setupFilePath = "C:\\Users\\Allison\\Desktop\\HealthTrackProject-ER_backend_curr\\HealthTrackProject-ER_backend\\cs532.sql";
        String databaseSetup = "";

        try {
            databaseSetup = Files.readString(Path.of(setupFilePath));
            success = updateDatabase(databaseSetup);
        }
        catch (Exception e){
            //e.printStackTrace();
        }
        if (success == true){
            System.out.println("Database setup complete");
        }
        else{
            System.out.println("Database setup failed, consider manual update");
        }

    }

    @Test
    void startTimeTest() {
        Appointment app = new Appointment(0, 1, "Vacation", 11, 2, 12,00, 11,2, 1, 00);
        Assertions.assertEquals("'2020-12-2 12:0:00'", app.startTime());
    }

    @Test
    void endTimeTest() {
        Appointment app = new Appointment(0, 1, "Vacation", 11, 2, 12,00, 11,2, 1, 00);
        Assertions.assertEquals("'2020-12-2 1:0:00'", app.endTime());
    }

    @Test
    void insertintoDBTest() {
        Appointment app = new Appointment(0, 1, "Vacation", 11, 2, 12,00, 11,2, 1, 00);
        app.insertintoDB();

        String getMaxIDSQL = "SELECT MAX(eventid) FROM Events";
        Integer maxID = queryDatabaseInt(getMaxIDSQL, 1);

        String getAppointmentSQL = "SELECT * FROM Events WHERE eventid = " + Integer.toString(maxID);

        Integer patientID = queryDatabaseInt(getAppointmentSQL, 2);
        Integer drID = queryDatabaseInt(getAppointmentSQL, 3);
        String type = queryDatabaseString(getAppointmentSQL, 4);

        Assertions.assertEquals(patientID, 0);
        Assertions.assertEquals(drID, 2);
        Assertions.assertEquals(type, "Vacation");
    }

    @Test
    void getPhysiciansSCHED_DailyTest(){
        SCHED_DailyReport dr;
        //check with empty database
        updateDatabase("TRUNCATE TABLE Physicians");
        dr = new SCHED_DailyReport();
        Assertions.assertTrue(dr.physicians.isEmpty());


        updateDatabase("INSERT INTO Physicians (eid, efirstname, elastname, cnumber) VALUES ('1', 'Jack', 'ONeill', '111111')");
        updateDatabase("INSERT INTO Physicians (eid, efirstname, elastname, cnumber) VALUES ('2', 'Sam', 'Carter', '222222')");
        updateDatabase("INSERT INTO Physicians (eid, efirstname, elastname, cnumber) VALUES ('3', 'Daniel', 'Jackson', '333333')");
        List<String> drNames = new ArrayList<String>();
        drNames.add("Jack ONeill");
        drNames.add("Sam Carter");
        drNames.add("Daniel Jackson");
        dr = new SCHED_DailyReport();
        Assertions.assertEquals(drNames.toString(), dr.physicians.toString());

    }

    @Test
    void getPhysiciansSCHED_WeeklyTest(){
        SCHED_WeeklyReport dr;
        //check with empty database
        updateDatabase("TRUNCATE TABLE Physicians");
        dr = new SCHED_WeeklyReport();
        Assertions.assertTrue(dr.physicians.isEmpty());


        updateDatabase("INSERT INTO Physicians (eid, efirstname, elastname, cnumber) VALUES ('1', 'Jack', 'ONeill', '111111')");
        updateDatabase("INSERT INTO Physicians (eid, efirstname, elastname, cnumber) VALUES ('2', 'Sam', 'Carter', '222222')");
        updateDatabase("INSERT INTO Physicians (eid, efirstname, elastname, cnumber) VALUES ('3', 'Daniel', 'Jackson', '333333')");
        List<String> drNames = new ArrayList<String>();
        drNames.add("Jack ONeill");
        drNames.add("Sam Carter");
        drNames.add("Daniel Jackson");
        dr = new SCHED_WeeklyReport();
        Assertions.assertEquals(drNames.toString(), dr.physicians.toString());
    }

    @Test
    void getWeekReportTest(){
        //because this is displayed to console, needs to be manually evaluated
        updateDatabase("INSERT INTO Physicians (eid, efirstname, elastname, cnumber) VALUES ('0', 'George', 'Hammond', '0000000')");
        updateDatabase("DELETE from Events WHERE doctorid = 0");
        WeekReport wr= new WeekReport(11,2,0,"George Hammond");

        //check when no appts present
        wr.getfromDB();


        Appointment app = new Appointment(0, 0, "Vacation", 6, 6, 1,00, 6,6, 2, 00);
        app.insertintoDB();
        app = new Appointment(0,0, "Conference", 6, 10, 1,00, 6,10, 2, 00);
        app.insertintoDB();
        wr = new WeekReport(7,6,0,"George Hammond");
        wr.getfromDB();
    }

    @Test
    void getDayReportTest(){
        //because this is displayed to console, needs to be manually evaluated
        updateDatabase("DELETE from Physicians WHERE eid = 0");
        DayReport dr = new DayReport(11,2,0,"George Hammond");

        //check when no appts present
        dr.getfromDB();

        updateDatabase("INSERT INTO Physicians (eid, efirstname, elastname, cnumber) VALUES ('0', 'George', 'Hammond', '0000000')");
        Appointment app = new Appointment(0,0, "Vacation", 6, 6, 1,00, 6,6, 2, 00);
        app.insertintoDB();
        dr = new DayReport(7,6,0,"George Hammond");
        dr.getfromDB();
    }

}