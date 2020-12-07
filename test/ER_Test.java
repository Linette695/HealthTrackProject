
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.List;

public class ER_Test {


    //setup variables to access database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/cs532"; //change depending on database
    static final String USER = "root";
    static final String PASS = "root";

    static boolean updateDatabase(String sql){

        boolean success = false;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

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
            try {
                if (rs!= null)
                    rs.close();
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
    void createPatientTest() {
        ER_Backend.deletePatient(21);
        Assertions.assertEquals(null, ER_Backend.returnPatient(21).pfirstname);

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
    }

    @Test
    void medicalEncounterTest(){
        ER_Backend backend = new ER_Backend();
        //delete any ME and check that no such ME exists
        updateDatabase("DELETE from MedicalEncounter WHERE pid = 21");
        String checkDeletion = queryDatabaseString("SELECT * from MedicalEncounter WHERE pid = 21", 1);
        System.out.println(checkDeletion);
        Assertions.assertEquals(null, checkDeletion);

        //create new ME
        MedicalEncounter me = new MedicalEncounter();
        me.dateinput = "2020-11-20";
        me.eid = 1;
        me.pid = 21;
        me.complaints = "Patient describes ~ 2 weeks of thin nasal discharge";
        me.heartrate = 110;
        me.bloodpressure = "120/80";
        me.temperature = 99;
        me.notes = "Mild erythema and swelling both nostrils.  Otherwise WNL";
        me.diagnosis = "r/o allergic rhinitis";
        me.treatment = "try antihistamines";
        me.referral = "none indicated";
        me.datefollowup = "2020-2-12";

        backend.createMedicalEncounter(me);
        List<MedicalEncounter> meList = backend.returnMedicalEncounter(21);

        Assertions.assertEquals(110, meList.get(0).heartrate);
    }

    @Test
    void getMaxIDFullTableTest(){
        ER_Backend backend = new ER_Backend();
        Integer maxID = queryDatabaseInt("SELECT MAX(pid) FROM Patients", 1);
        Assertions.assertEquals((int)maxID, backend.getMaxID());

        Patient np = new Patient();
        np.pid = 25;
        np.pfirstname = "Leslie";
        np.plastname = "Knope";
        np.tnumber = 12445;
        np.address = "123 Main Street";
        np.iid = 1;
        np.dob = "1970-1-1";
        np.gender = "F";
        np.pcp = 1;
        ER_Backend.createPatient(np);

        Assertions.assertEquals(25, backend.getMaxID());
    }

    @Test
    void deletePatientTest(){
        ER_Backend backend = new ER_Backend();
        int nextMaxID = backend.getMaxID() + 1;
        Patient np = new Patient();
        np.pid = nextMaxID;
        np.pfirstname = "Ron";
        np.plastname = "Swanson";
        np.tnumber = 12445;
        np.address = "123 Main Street";
        np.iid = 1;
        np.dob = "1970-1-1";
        np.gender = "M";
        np.pcp = 1;
        ER_Backend.createPatient(np);

        Assertions.assertEquals("Ron", ER_Backend.returnPatient(nextMaxID).pfirstname);
        ER_Backend.deletePatient(nextMaxID);
        Assertions.assertEquals(null, ER_Backend.returnPatient(21).pfirstname);
    }

    @Test
    void createDate(){
        ER_Backend backend = new ER_Backend();
        Assertions.assertEquals("2000-1-1", backend.createDate(2000,1,1));
    }


    @Test
    void getMaxIDEmptyTableTest(){
        ER_Backend backend = new ER_Backend();
        int newMaxID = backend.getMaxID() + 1;
        Patient np = new Patient();
        np.pid = newMaxID;
        np.pfirstname = "April";
        np.plastname = "Ludgate";
        np.tnumber = 12445;
        np.address = "123 Main Street";
        np.iid = 1;
        np.dob = "1970-1-1";
        np.gender = "F";
        np.pcp = 1;
        ER_Backend.createPatient(np);

        Assertions.assertEquals(newMaxID, backend.getMaxID());

        updateDatabase("TRUNCATE TABLE Patients");

        Assertions.assertEquals(0, backend.getMaxID());
    }

    @Test
    void medicalEncounterClassTest(){
        //create new ME
        MedicalEncounter me = new MedicalEncounter();
        me.dateinput = "2020-11-20";
        me.eid = 1;
        me.pid = 21;
        me.complaints = "Patient describes ~ 2 weeks of thin nasal discharge";
        me.heartrate = 110;
        me.bloodpressure = "120/80";
        me.temperature = 99;
        me.notes = "Mild erythema and swelling both nostrils.  Otherwise WNL";
        me.diagnosis = "r/o allergic rhinitis";
        me.treatment = "try antihistamines";
        me.referral = "none indicated";
        me.datefollowup = "2020-2-12";

        String expectedOutput = "dateinput: 2020-11-20, eid: 1, pid: 21, complaints: Patient describes ~ 2 weeks of thin nasal discharge, heartrate: 110, bloodpressure: 120/80, temperature: 99.0, notes: Mild erythema and swelling both nostrils.  Otherwise WNL, diagnosis: r/o allergic rhinitis, treatment: try antihistamines, referral: none indicated, datefollowup: 2020-2-12";

        Assertions.assertEquals(expectedOutput, me.returnInfoString());
    }

    @Test
    void patientClassTest(){
        Patient np = new Patient();
        np.pid = 2;
        np.pfirstname = "Tom";
        np.plastname = "Haverford";
        np.tnumber = 12445;
        np.address = "123 Main Street";
        np.iid = 1;
        np.dob = "1970-1-1";
        np.gender = "M";
        np.pcp = 1;

        String expectedOutput = "pid: 2, pfirstname: Tom, plastname: Haverford, tnumber: 12445, address: 123 Main Street, iid: 1, dob: 1970-1-1, gender: M, pcp: 1";
        Assertions.assertEquals(expectedOutput, np.returnInfoString());

        np.printInfo();
    }
}
