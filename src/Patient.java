import java.sql.*;

public class Patient {
	int pid;
	String pfirstname;
	String plastname;
	int tnumber;
	String address;
	int iid;
	Date dob;
	String gender;
	int pcp;
	
	public void printInfo() {
		System.out.print("pid: "+pid);
		System.out.print(", pfirstname: "+pfirstname);
		System.out.print(", plastname: "+plastname);
		System.out.print(", tnumber: "+tnumber);
		System.out.print(", address: "+address);
		System.out.print(", iid: "+iid);
		System.out.print(", dob: "+dob);
		System.out.print(", gender: "+gender);
		System.out.println(", pcp: "+pcp);
		
	}
}
