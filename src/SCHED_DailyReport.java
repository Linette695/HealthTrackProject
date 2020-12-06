import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class SCHED_DailyReport {

	private JFrame frmGeneratingDailyReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCHED_DailyReport window = new SCHED_DailyReport();
					window.frmGeneratingDailyReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		static final String DB_URL = "jdbc:mysql://localhost/cs532";

		//  Database credentials
		static final String USER = "root";
		static final String PASS = "root";
		
	/**
	 * Create the application.
	 */
	static ArrayList<String> physicians = new ArrayList<String>();
	public SCHED_DailyReport() {
		Scanner scnr = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//STEP 4: Execute a query
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT efirstname, elastname FROM Physicians";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				String first = rs.getString("efirstname");
				String last = rs.getString("elastname");
				physicians.add(first + " " + last);  
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
			}
		}
		initialize();
		frmGeneratingDailyReport.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingDailyReport = new JFrame();
		frmGeneratingDailyReport.setTitle("Generating Daily Report");
		frmGeneratingDailyReport.setBounds(100, 100, 450, 300);
		frmGeneratingDailyReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingDailyReport.getContentPane().setLayout(null);
		
		JLabel lblPickMonthAnd = new JLabel("Pick month & day:");
		lblPickMonthAnd.setBounds(10, 13, 118, 13);
		frmGeneratingDailyReport.getContentPane().add(lblPickMonthAnd);
		
		final JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_2_1.setBounds(138, 10, 75, 19);
		frmGeneratingDailyReport.getContentPane().add(comboBox_2_1);
		
		final JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_4.setBounds(223, 10, 41, 20);
		frmGeneratingDailyReport.getContentPane().add(spinner_4);
		
		JLabel lblSpecifyPhysician = new JLabel("Pick a Physician:");
		lblSpecifyPhysician.setBounds(20, 43, 106, 13);
		frmGeneratingDailyReport.getContentPane().add(lblSpecifyPhysician);
		
		final JComboBox comboBox_5 = new JComboBox(physicians.toArray());
		comboBox_5.setBounds(145, 40, 88, 19);
		frmGeneratingDailyReport.getContentPane().add(comboBox_5);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DayReport r = new DayReport(comboBox_2_1.getSelectedIndex()+1, (((SpinnerNumberModel)spinner_4.getModel()).getNumber()), comboBox_5.getSelectedIndex(), physicians.get(comboBox_5.getSelectedIndex()));
				r.getfromDB();
			}
		});
		btnGenerateReport.setBounds(290, 39, 136, 21);
		frmGeneratingDailyReport.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 416, 183);
		frmGeneratingDailyReport.getContentPane().add(scrollPane);
	}

}
