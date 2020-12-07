import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

class ER_PS_IntegrationTest {

    //setup variables to access database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/cs532"; //change depending on database
    static final String USER = "root";
    static final String PASS = "root";

    static boolean updateDatabase(String sql) {

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
            } catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                //se.printStackTrace();
            }
        }
        return success;
    }


    static String queryDatabaseString(String sql, Integer position) {

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
            } catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException se) {
                //se.printStackTrace();
            }
        }
        return resultString;
    }


    static Integer queryDatabaseInt(String sql, Integer position) {

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
            } catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                //se.printStackTrace();
            }
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException se) {
                //se.printStackTrace();
            }
        }
        return resultInt;
    }

    @BeforeAll
    static void setupDatabase() {
        boolean success = false;

        final String setupFilePath = "C:\\Users\\Allison\\Desktop\\HealthTrackProject-ER_backend_curr\\HealthTrackProject-ER_backend\\cs532.sql";
        String databaseSetup = "";

        try {
            databaseSetup = Files.readString(Path.of(setupFilePath));
            success = updateDatabase(databaseSetup);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        if (success == true) {
            System.out.println("Database setup complete");
        } else {
            System.out.println("Database setup failed, consider manual update");
        }

    }

    @Test
    void createPatient_scheduleAppt(){
        //confirm that patient does not exist and appointment with this patient does not exist
        ER_Backend.deletePatient(21);
        Assertions.assertEquals(null, ER_Backend.returnPatient(21).pfirstname);
        updateDatabase("DELETE FROM events WHERE patientid=21");
        String appointmentType = queryDatabaseString("SELECT * FROM events WHERE patientid=21", 4);
        Assertions.assertEquals(null, appointmentType);

        Patient np = new Patient();
        np.pid = 21;
        np.pfirstname = "Ron";
        np.plastname = "Swanson";
        np.tnumber = 12445;
        np.address = "123 Main Street";
        np.iid = 1;
        np.dob = "1970-1-1";
        np.gender = "M";
        np.pcp = 1;
        ER_Backend.createPatient(np);
        Assertions.assertEquals("Ron", ER_Backend.returnPatient(21).pfirstname);


        //use this patient to schedule appointment
        Appointment app = new Appointment(np.pid, 2, "Vacation", 11, 2, 12,00, 11,2, 1, 00);
        app.insertintoDB();
        appointmentType = queryDatabaseString("SELECT * FROM events WHERE patientid=21", 4);
        Assertions.assertEquals("Vacation", appointmentType);
    }

    @Test
    void enforcePatientExistsTest(){
        ER_Backend.deletePatient(21);
        Assertions.assertEquals(null, ER_Backend.returnPatient(21).pfirstname);
        updateDatabase("DELETE FROM events WHERE patientid=21");
        String appointmentType = queryDatabaseString("SELECT * FROM events WHERE patientid=21", 4);
        Assertions.assertEquals(null, appointmentType);

        //should not be able to make new appt with non-existant patient
        Appointment app = new Appointment(21, 2, "Vacation", 11, 2, 12,00, 11,2, 1, 00);
        app.insertintoDB();
        appointmentType = queryDatabaseString("SELECT * FROM events WHERE patientid=21", 4);
        Assertions.assertEquals(null, appointmentType);


    }

}