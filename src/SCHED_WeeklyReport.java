import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;

public class SCHED_WeeklyReport {

	private JFrame frmGeneratingWeeklyReport;
	private SpringLayout springLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCHED_WeeklyReport window = new SCHED_WeeklyReport();
					window.frmGeneratingWeeklyReport.setVisible(true);
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
	public SCHED_WeeklyReport() {
		//Scanner scnr = new Scanner(System.in);
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
		frmGeneratingWeeklyReport.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingWeeklyReport = new JFrame();
		frmGeneratingWeeklyReport.setTitle("Generating Weekly Report");
		frmGeneratingWeeklyReport.setBounds(100, 100, 450, 300);
		frmGeneratingWeeklyReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingWeeklyReport.getContentPane().setLayout(null);
		
		JLabel lblSpecifyPhysician = new JLabel("Pick a Physician:");
		lblSpecifyPhysician.setBounds(10, 13, 106, 13);
		frmGeneratingWeeklyReport.getContentPane().add(lblSpecifyPhysician);
		
		final JComboBox comboBox_5 =  new JComboBox(physicians.toArray());
		comboBox_5.setBounds(135, 10, 88, 19);
		frmGeneratingWeeklyReport.getContentPane().add(comboBox_5);
		
		JLabel lblNewLabel_10 = new JLabel("Week of :");
		lblNewLabel_10.setBounds(10, 36, 100, 17);
		frmGeneratingWeeklyReport.getContentPane().add(lblNewLabel_10);
		
		final JSpinner spinnerDayIn = new JSpinner();
		spinnerDayIn.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDayIn.setBounds(86, 55, 50, 20);
		frmGeneratingWeeklyReport.getContentPane().add(spinnerDayIn);
		
		final JComboBox cbMonthIn = new JComboBox();
		cbMonthIn.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonthIn.setBounds(10, 55, 70, 21);
		frmGeneratingWeeklyReport.getContentPane().add(cbMonthIn);
		
		final JSpinner spinnerYearIn = new JSpinner();
		spinnerYearIn.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinnerYearIn.setBounds(146, 55, 57, 20);
		frmGeneratingWeeklyReport.getContentPane().add(spinnerYearIn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 416, 175);
		frmGeneratingWeeklyReport.getContentPane().add(scrollPane);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WeekReport r = new WeekReport(cbMonthIn.getSelectedIndex()+1, (((SpinnerNumberModel)spinnerDayIn.getModel()).getNumber()), comboBox_5.getSelectedIndex(), physicians.get(comboBox_5.getSelectedIndex()));
				r.getfromDB();
			}
		});
		btnGenerateReport.setBounds(290, 34, 136, 21);
		frmGeneratingWeeklyReport.getContentPane().add(btnGenerateReport);
		
	
	}

}
