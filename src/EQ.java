import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EQ {

	private JFrame frmEquiptmentInventory;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/*GUI Variables*/
	private JTabbedPane tabbedPane;
	private EQ_QueryVendorInfo VendorListSubsystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EQ window = new EQ();
					window.frmEquiptmentInventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EQ() {
		initialize();
	}
	
	
	
	/*METHODS*/
	/*NOTES: The index for each tab are  
	 *		Report Equipment problem == 0
	 *		Update an equipment problem == 1
	 *		Query Equipment  == 2
	 *		Vendor List Maintenance == 3
	 *		Generate new report == 4
	 *		
	 */

	//Method invoked when user wants to report a new equipment problem
	public void EQNewProblem() {
		frmEquiptmentInventory.setVisible(true);					
		
		tabbedPane.setEnabledAt(0, true);			//Make sure the Report Equipment problem tab is enabled
		tabbedPane.setSelectedIndex(0);				//Make sure the Report Equipment problem tab is the one being displayed
		tabbedPane.setEnabledAt(1, false);			//Make sure the Update an equipment problem tab is not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the query equipment tab is  not enabled
		tabbedPane.setEnabledAt(3, false);			//Make sure the vendor list maintenance tab is not enabled
		tabbedPane.setEnabledAt(4, false);			//Make sure the generate new report tab is not enabled
	}//end of EQNewProblem
	
	//Method invoked when user wants to update an equipment problem
	public void EQUpdateProblem() {
		frmEquiptmentInventory.setVisible(true);					
		
		tabbedPane.setEnabledAt(1, true);			//Make sure the update an equipment problem tab is enabled
		tabbedPane.setSelectedIndex(1);				//Make sure the update an equipment problem tab is the one being displayed
		tabbedPane.setEnabledAt(0, false);			//Make sure the report equipment problem tab is not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the query equipment tab is  not enabled
		tabbedPane.setEnabledAt(3, false);			//Make sure the vendor list maintenance tab is not enabled
		tabbedPane.setEnabledAt(4, false);			//Make sure the generate new report tab is not enabled
	}//end of EQUpdateProblem	
	
	//Method invoked when user wants to query the equipment database
		public void EQQueryEquipment() {
			frmEquiptmentInventory.setVisible(true);					
			
			tabbedPane.setEnabledAt(2, true);			//Make sure the query equipment tab is enabled
			tabbedPane.setSelectedIndex(2);				//Make sure the query equipment tab is the one being displayed
			tabbedPane.setEnabledAt(0, false);			//Make sure the report equipment problem tab is not enabled
			tabbedPane.setEnabledAt(1, false);			//Make sure the update an equipment problem tab is  not enabled
			tabbedPane.setEnabledAt(3, false);			//Make sure the vendor list maintenance tab is not enabled
			tabbedPane.setEnabledAt(4, false);			//Make sure the generate new report tab is not enabled
		}//end of EQQueryEquipment

		//Method invoked when user wants to access the vendor list maintenance functionalities 
		public void EQVendorListMaintenance() {
			frmEquiptmentInventory.setVisible(true);					
			
			tabbedPane.setEnabledAt(3, true);			//Make sure the vendor list maintenance tab is enabled
			tabbedPane.setSelectedIndex(3);				//Make sure the vendor list maintenance tab is the one being displayed
			tabbedPane.setEnabledAt(0, false);			//Make sure the report equipment problem tab is not enabled
			tabbedPane.setEnabledAt(1, false);			//Make sure the update an equipment problem tab is  not enabled
			tabbedPane.setEnabledAt(2, false);			//Make sure the query equipment tab is not enabled
			tabbedPane.setEnabledAt(4, false);			//Make sure the generate new report tab is not enabled
		}//end of EQVendorListMaintenance

		//Method invoked when user wants to generate a new report
		public void EQGenerateNewReport() {
			frmEquiptmentInventory.setVisible(true);					
			
			tabbedPane.setEnabledAt(4, true);			//Make sure the generate new report tab is enabled
			tabbedPane.setSelectedIndex(4);				//Make sure the generate new report tab is the one being displayed
			tabbedPane.setEnabledAt(0, false);			//Make sure the report equipment problem tab is not enabled
			tabbedPane.setEnabledAt(1, false);			//Make sure the update an equipment problem tab is  not enabled
			tabbedPane.setEnabledAt(2, false);			//Make sure the query equipment tab is not enabled
			tabbedPane.setEnabledAt(3, false);			//Make sure the vendor list maintenance tab is not enabled
		}//end of EQGenerateNewReport

		
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEquiptmentInventory = new JFrame();
		frmEquiptmentInventory.setTitle("Equiptment Inventory & Maintenance ");
		frmEquiptmentInventory.setBounds(100, 100, 481, 329);
		frmEquiptmentInventory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEquiptmentInventory.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 467, 292);
		frmEquiptmentInventory.getContentPane().add(tabbedPane);
		
		VendorListSubsystem = new EQ_QueryVendorInfo();
		
		JPanel ReportEquiptmentProblemPanel = new JPanel();
		tabbedPane.addTab("Report An Equiptment Problem", null, ReportEquiptmentProblemPanel, null);
		ReportEquiptmentProblemPanel.setLayout(null);
		
		JLabel lblEquiptmentId = new JLabel("Equiptment ID:");
		lblEquiptmentId.setBounds(10, 13, 107, 13);
		ReportEquiptmentProblemPanel.add(lblEquiptmentId);
		
		textField = new JTextField();
		textField.setText("Enter ID #");
		textField.setColumns(10);
		textField.setBounds(120, 10, 96, 19);
		ReportEquiptmentProblemPanel.add(textField);
		
		JLabel lblTypeOfProblem = new JLabel("Type of problem:");
		lblTypeOfProblem.setBounds(10, 36, 125, 13);
		ReportEquiptmentProblemPanel.add(lblTypeOfProblem);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Problem type #1", "Problem type #2", "...", "Other"}));
		comboBox_5.setBounds(120, 36, 136, 19);
		ReportEquiptmentProblemPanel.add(comboBox_5);
		
		JLabel lblDescribeTheProblem = new JLabel("Describe the problem:");
		lblDescribeTheProblem.setBounds(10, 59, 158, 13);
		ReportEquiptmentProblemPanel.add(lblDescribeTheProblem);
		
		JTextArea txtrEnterDescription = new JTextArea();
		txtrEnterDescription.setText("Enter Description");
		txtrEnterDescription.setBounds(120, 76, 311, 71);
		ReportEquiptmentProblemPanel.add(txtrEnterDescription);
		
		JButton btnReportProblem = new JButton("Report Problem");
		btnReportProblem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReportProblem.setBounds(140, 163, 181, 21);
		ReportEquiptmentProblemPanel.add(btnReportProblem);
		
		JPanel UpdateAnEquiptmentProblemPanel = new JPanel();
		tabbedPane.addTab("Updating An Equiptment Problem", null, UpdateAnEquiptmentProblemPanel, null);
		UpdateAnEquiptmentProblemPanel.setLayout(null);
		
		JLabel lblEquiptmentProblemId = new JLabel("Equiptment problem ID:");
		lblEquiptmentProblemId.setBounds(10, 13, 154, 13);
		UpdateAnEquiptmentProblemPanel.add(lblEquiptmentProblemId);
		
		textField_1 = new JTextField();
		textField_1.setText("Enter ID #");
		textField_1.setColumns(10);
		textField_1.setBounds(174, 10, 112, 19);
		UpdateAnEquiptmentProblemPanel.add(textField_1);
		
		JLabel lblTypeOfUpdate = new JLabel("Type of update:");
		lblTypeOfUpdate.setHorizontalAlignment(SwingConstants.LEADING);
		lblTypeOfUpdate.setForeground(Color.BLACK);
		lblTypeOfUpdate.setBounds(10, 39, 106, 13);
		UpdateAnEquiptmentProblemPanel.add(lblTypeOfUpdate);
		
		JComboBox comboBox_5_1 = new JComboBox();
		comboBox_5_1.setModel(new DefaultComboBoxModel(new String[] {"Close/Resolve problem", "Description update"}));
		comboBox_5_1.setBounds(126, 36, 160, 19);
		UpdateAnEquiptmentProblemPanel.add(comboBox_5_1);
		
		JLabel lblUpdateDescription = new JLabel("Update description:");
		lblUpdateDescription.setBounds(10, 62, 158, 13);
		UpdateAnEquiptmentProblemPanel.add(lblUpdateDescription);
		
		JTextArea txtrEnterDescription_1 = new JTextArea();
		txtrEnterDescription_1.setText("Enter Description");
		txtrEnterDescription_1.setBounds(110, 77, 321, 71);
		UpdateAnEquiptmentProblemPanel.add(txtrEnterDescription_1);
		
		JButton btnUpdateProblem = new JButton("Update Problem");
		btnUpdateProblem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateProblem.setBounds(138, 168, 166, 21);
		UpdateAnEquiptmentProblemPanel.add(btnUpdateProblem);
		
		JPanel QueryEquiptmentPanel = new JPanel();
		tabbedPane.addTab("Query Equiptment Database", null, QueryEquiptmentPanel, null);
		QueryEquiptmentPanel.setLayout(null);
		
		JLabel lblEquiptmentId_1 = new JLabel("Equiptment ID:");
		lblEquiptmentId_1.setForeground(Color.DARK_GRAY);
		lblEquiptmentId_1.setBounds(13, 31, 95, 13);
		QueryEquiptmentPanel.add(lblEquiptmentId_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(80, 45, 88, 19);
		QueryEquiptmentPanel.add(textField_2);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOr.setBounds(205, 47, 23, 17);
		QueryEquiptmentPanel.add(lblOr);
		
		JLabel lblPatientId_1 = new JLabel("Equitpment type:");
		lblPatientId_1.setForeground(Color.DARK_GRAY);
		lblPatientId_1.setBounds(248, 31, 102, 13);
		QueryEquiptmentPanel.add(lblPatientId_1);
		
		JComboBox comboBox_5_2 = new JComboBox();
		comboBox_5_2.setModel(new DefaultComboBoxModel(new String[] {"Type #1", "Type #2", "..."}));
		comboBox_5_2.setBounds(332, 45, 106, 19);
		QueryEquiptmentPanel.add(comboBox_5_2);
		
		JLabel lblSearchForEquiptment = new JLabel("Search for equiptment by specifying an equiptment ID or an equiptment type.");
		lblSearchForEquiptment.setBounds(10, 6, 452, 13);
		QueryEquiptmentPanel.add(lblSearchForEquiptment);
		
		JButton btnQueryDatabase = new JButton("Query Database");
		btnQueryDatabase.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQueryDatabase.setBounds(156, 87, 138, 21);
		QueryEquiptmentPanel.add(btnQueryDatabase);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 112, 460, 138);
		QueryEquiptmentPanel.add(scrollPane);
		
		JPanel VendorListMaintenancePanel = new JPanel();
		tabbedPane.addTab("Vendor List Maintenance ", null, VendorListMaintenancePanel, null);
		VendorListMaintenancePanel.setLayout(null);
		
		JButton btnQueryVendorInformation = new JButton("Query Vendor Information");
		btnQueryVendorInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEquiptmentInventory.setVisible(false);
				VendorListSubsystem.eqQueryVendorList();
				
			}
		});
		btnQueryVendorInformation.setHorizontalAlignment(SwingConstants.LEADING);
		btnQueryVendorInformation.setBounds(10, 10, 188, 21);
		VendorListMaintenancePanel.add(btnQueryVendorInformation);
		
		JButton btnAddANew = new JButton("Add A New Vendor");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEquiptmentInventory.setVisible(false);
				VendorListSubsystem.eqNewVendor();
			}
		});
		btnAddANew.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddANew.setBounds(10, 41, 188, 21);
		VendorListMaintenancePanel.add(btnAddANew);
		
		JPanel GenerateReportPanel = new JPanel();
		tabbedPane.addTab("Generate A New Report", null, GenerateReportPanel, null);
		GenerateReportPanel.setLayout(null);
		
		JButton btnCreateAComplete = new JButton("Create A Complete Inventory Report");
		btnCreateAComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EQ_CompleteInventoryReport newCompleteReport = new EQ_CompleteInventoryReport();
			}
		});
		btnCreateAComplete.setHorizontalAlignment(SwingConstants.LEADING);
		btnCreateAComplete.setBounds(10, 10, 362, 21);
		GenerateReportPanel.add(btnCreateAComplete);
		
		JButton btnCreateAReport = new JButton("Generate A Report Of All Defective Equiptment");
		btnCreateAReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EQ_DefectiveEquipmentReport newDefectiveEquipmentReport = new EQ_DefectiveEquipmentReport();
			}
		});
		btnCreateAReport.setHorizontalAlignment(SwingConstants.LEADING);
		btnCreateAReport.setBounds(10, 41, 362, 21);
		GenerateReportPanel.add(btnCreateAReport);
		
		JButton btnStatisticalReportOf = new JButton("Create A Statistical Report Of Equiptment Problems");
		btnStatisticalReportOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EQ_StatisticalReport newStatisticalReport = new EQ_StatisticalReport();
			}
		});
		btnStatisticalReportOf.setHorizontalAlignment(SwingConstants.LEADING);
		btnStatisticalReportOf.setBounds(10, 72, 362, 21);
		GenerateReportPanel.add(btnStatisticalReportOf);
	}
}
