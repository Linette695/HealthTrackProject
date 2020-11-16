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
