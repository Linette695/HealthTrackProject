import java.sql.*; 

public class MedicalEncounter {
	public String dateinput;
	public int eid;
	public int pid;
	public String complaints;
	public int heartrate;
	public String bloodpressure;
	public float temperature;
	public String notes;
	public String diagnosis;
	public String treatment;
	public String referral;
	public String datefollowup;
	
	public String returnInfoString() {
		String meInfo = "dateinput: "+dateinput+
				", eid: "+eid+
				", pid: "+pid+
				", complaints: "+complaints+
				", heartrate: "+heartrate+
				", bloodpressure: "+bloodpressure+
				", temperature: "+temperature+
				", notes: "+notes+
				", diagnosis: "+diagnosis+
				", treatment: "+treatment+
				", referral: "+referral+
				", datefollowup: "+datefollowup;
		
		return meInfo;
	}
}
	
