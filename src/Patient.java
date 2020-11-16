import java.sql.*;

public class Patient {
	public int pid;
	public String pfirstname;
	public String plastname;
	public int tnumber;
	public String address;
	public int iid;
	public Date dob;
	public String gender;
	public int pcp;
	
	public void printInfo() {
		System.out.println(returnInfoString());
		
	}
	
	public String returnInfoString() {
		String patientInfo = "pid: "+pid+
				", pfirstname: "+pfirstname+
				", plastname: "+plastname+
				", tnumber: "+tnumber+
				", address: "+address+
				", iid: "+iid+
				", dob: "+dob+
				", gender: "+gender+
				", pcp: "+pcp;
		
		return patientInfo;
	}
}
