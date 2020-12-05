import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PT {

	private JFrame frmPharmacyOrderTracking;
	private JTextField txtEnterId;
	private JTextField txtEnterId_1;
	private JTextField txtEnterId_2;
	private JTextField txtEnterDosage;
	private JTextField txtEnterFrequency;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	/*GUI Variables*/
	JTabbedPane tabbedPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PT window = new PT();
					window.frmPharmacyOrderTracking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PT() {
		initialize();
	}

	
	/*METHODS*/
	/*NOTES: The index for each tab are  
	 *		Order New Prescription  == 0
	 *		Fill A Prescription == 1
	 *		Available Medications  == 2
	 *		Search For A Prescription == 3
	 *		Generate New Report == 4
	 */

	//Method invoked when user wants to Order a new prescription
	public void PTOrderNewPrescription() {
		frmPharmacyOrderTracking.setVisible(true);					
		
		tabbedPane.setEnabledAt(0, true);			//Make sure the order new prescription tab is enabled
		tabbedPane.setSelectedIndex(0);				//Make sure the create new prescription tab is the one being displayed
		tabbedPane.setEnabledAt(1, false);			//Make sure the fill a prescription tab is not enabled
		tabbedPane.setEnabledAt(2, true);			//Make sure the available medications tab is  enabled to be used as a helper 
		tabbedPane.setEnabledAt(3, false);			//Make sure the search for a prescription tab is not enabled
		tabbedPane.setEnabledAt(4, false);			//Make sure the generate new report tab is not enabled
	}//end of PTOrderNewPrescription
	
	//Method invoked when user wants to fill a prescription
	public void PTFillAnExistentPrescription() {
		frmPharmacyOrderTracking.setVisible(true);					
		
		tabbedPane.setEnabledAt(1, true);			//Make sure the fill an existent prescription tab is enabled
		tabbedPane.setSelectedIndex(1);				//Make sure the fill an existent prescription tab is the one being displayed
		tabbedPane.setEnabledAt(0, false);			//Make sure the create a new prescription tab is not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the available medications tab is  not enabled
		tabbedPane.setEnabledAt(3, false);			//Make sure the search for a prescription tab is not enabled
		tabbedPane.setEnabledAt(4, false);			//Make sure the generate new report tab is not enabled
	}//end of PTFillAnExistentPrescription
	
	//Method invoked when user wants to retrieve a prescription
	public void PTRetrieveAPrescription() {
		frmPharmacyOrderTracking.setVisible(true);					
		
		tabbedPane.setEnabledAt(3, true);			//Make sure the search for a prescription tab is enabled
		tabbedPane.setSelectedIndex(3);				//Make sure the search for a prescription tab is the one being displayed
		tabbedPane.setEnabledAt(0, false);			//Make sure the create a new prescription tab is not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the available medications tab is  not enabled
		tabbedPane.setEnabledAt(1, false);			//Make sure the fill an existent prescription tab is not enabled
		tabbedPane.setEnabledAt(4, false);			//Make sure the generate new report tab is not enabled
	}//end of PTRetrieveAPrescription
	
	//Method invoked when user wants to generate a new report
	public void PTGenerateNewReport() {
		frmPharmacyOrderTracking.setVisible(true);					
		
		tabbedPane.setEnabledAt(4, true);			//Make sure the generate new report tab is enabled
		tabbedPane.setSelectedIndex(4);				//Make sure the generate new report tab is the one being displayed
		tabbedPane.setEnabledAt(0, false);			//Make sure the create a new prescription tab is not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the available medications tab is  not enabled
		tabbedPane.setEnabledAt(1, false);			//Make sure the fill an existent prescription tab is not enabled
		tabbedPane.setEnabledAt(3, false);			//Make sure the search for a prescription tab is not enabled
	}//end of PTGenerateNewReport
		
		
	
		
	
	
	
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPharmacyOrderTracking = new JFrame();
		frmPharmacyOrderTracking.setTitle("Pharmacy Order Tracking");
		frmPharmacyOrderTracking.setBounds(100, 100, 471, 300);
		frmPharmacyOrderTracking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPharmacyOrderTracking.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 10, 457, 253);
		frmPharmacyOrderTracking.getContentPane().add(tabbedPane);
		
		JPanel CreateNewPrescriptionPanel = new JPanel();
		tabbedPane.addTab("Order New Prescription", null, CreateNewPrescriptionPanel, null);
		CreateNewPrescriptionPanel.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setBounds(0, 0, 71, 13);
		CreateNewPrescriptionPanel.add(lblPatientId);
		
		txtEnterId = new JTextField();
		txtEnterId.setText("Enter ID #");
		txtEnterId.setBounds(71, -3, 96, 19);
		CreateNewPrescriptionPanel.add(txtEnterId);
		txtEnterId.setColumns(10);
		
		JLabel lblPhysicianId = new JLabel("Physician ID:");
		lblPhysicianId.setBounds(0, 23, 84, 13);
		CreateNewPrescriptionPanel.add(lblPhysicianId);
		
		txtEnterId_1 = new JTextField();
		txtEnterId_1.setText("Enter ID #");
		txtEnterId_1.setBounds(92, 20, 96, 19);
		CreateNewPrescriptionPanel.add(txtEnterId_1);
		txtEnterId_1.setColumns(10);
		
		JLabel lblMedicationId = new JLabel("Medication Information:");
		lblMedicationId.setBounds(0, 45, 236, 13);
		CreateNewPrescriptionPanel.add(lblMedicationId);
		
		txtEnterId_2 = new JTextField();
		txtEnterId_2.setText("Enter ID #");
		txtEnterId_2.setBounds(92, 65, 96, 19);
		CreateNewPrescriptionPanel.add(txtEnterId_2);
		txtEnterId_2.setColumns(10);
		
		JLabel lblDosage = new JLabel("Dosage:");
		lblDosage.setForeground(Color.DARK_GRAY);
		lblDosage.setBounds(236, 68, 62, 13);
		CreateNewPrescriptionPanel.add(lblDosage);
		
		txtEnterDosage = new JTextField();
		txtEnterDosage.setText("Enter Dosage");
		txtEnterDosage.setColumns(10);
		txtEnterDosage.setBounds(286, 65, 96, 19);
		CreateNewPrescriptionPanel.add(txtEnterDosage);
		
		JLabel lblMedicationId_1 = new JLabel("Medication ID:");
		lblMedicationId_1.setForeground(Color.DARK_GRAY);
		lblMedicationId_1.setBounds(10, 68, 84, 13);
		CreateNewPrescriptionPanel.add(lblMedicationId_1);
		
		JLabel lblMedicationId_1_1 = new JLabel("Frequency:");
		lblMedicationId_1_1.setForeground(Color.DARK_GRAY);
		lblMedicationId_1_1.setBounds(20, 94, 84, 13);
		CreateNewPrescriptionPanel.add(lblMedicationId_1_1);
		
		txtEnterFrequency = new JTextField();
		txtEnterFrequency.setText("Enter Frequency ");
		txtEnterFrequency.setColumns(10);
		txtEnterFrequency.setBounds(92, 94, 278, 19);
		CreateNewPrescriptionPanel.add(txtEnterFrequency);
		
		JButton btnOrderNewPrescription = new JButton("Order New Prescription");
		btnOrderNewPrescription.setBounds(121, 132, 192, 21);
		CreateNewPrescriptionPanel.add(btnOrderNewPrescription);
		
		JPanel UpdateAPrescriptionPanel = new JPanel();
		tabbedPane.addTab("Fill A Prescription", null, UpdateAPrescriptionPanel, null);
		UpdateAPrescriptionPanel.setLayout(null);
		
		JButton btnSelectOrder = new JButton("Update Prescription");
		btnSelectOrder.setBounds(132, 130, 170, 21);
		UpdateAPrescriptionPanel.add(btnSelectOrder);
		
		JLabel lblPrescriptionId = new JLabel("Prescription  ID:");
		lblPrescriptionId.setBounds(0, 3, 104, 13);
		UpdateAPrescriptionPanel.add(lblPrescriptionId);
		
		textField = new JTextField();
		textField.setText("Enter ID #");
		textField.setColumns(10);
		textField.setBounds(114, 0, 96, 19);
		UpdateAPrescriptionPanel.add(textField);
		
		JLabel lblNewLabel_10 = new JLabel("Today's Date:");
		lblNewLabel_10.setBounds(0, 26, 100, 13);
		UpdateAPrescriptionPanel.add(lblNewLabel_10);
		
		JSpinner spinnerYearIn = new JSpinner();
		spinnerYearIn.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerYearIn.setBounds(90, 49, 50, 20);
		UpdateAPrescriptionPanel.add(spinnerYearIn);
		
		JComboBox cbMonthIn = new JComboBox();
		cbMonthIn.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonthIn.setBounds(10, 49, 70, 21);
		UpdateAPrescriptionPanel.add(cbMonthIn);
		
		JSpinner spinnerDayIn = new JSpinner();
		spinnerDayIn.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinnerDayIn.setBounds(149, 49, 61, 20);
		UpdateAPrescriptionPanel.add(spinnerDayIn);
		
		JLabel lblNewLabel_10_1 = new JLabel("Pharmacist ID:");
		lblNewLabel_10_1.setBounds(0, 88, 100, 13);
		UpdateAPrescriptionPanel.add(lblNewLabel_10_1);
		
		textField_1 = new JTextField();
		textField_1.setText("Enter ID #");
		textField_1.setColumns(10);
		textField_1.setBounds(100, 85, 96, 19);
		UpdateAPrescriptionPanel.add(textField_1);
		
		JPanel AvailableMedicationsPanel = new JPanel();
		tabbedPane.addTab("Available Medications", null, AvailableMedicationsPanel, null);
		AvailableMedicationsPanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 380, 180);
		AvailableMedicationsPanel.add(scrollPane_1);
		
		JButton btnRefresh = new JButton("Refresh List");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRefresh.setBounds(102, 184, 200, 21);
		AvailableMedicationsPanel.add(btnRefresh);
		
		JPanel SearchPresctionsPanel = new JPanel();
		tabbedPane.addTab("Search For A Prescription", null, SearchPresctionsPanel, null);
		SearchPresctionsPanel.setLayout(null);
		
		JLabel lblEnterPrescriptionId = new JLabel("Prescription ID:");
		lblEnterPrescriptionId.setBounds(0, 13, 102, 13);
		SearchPresctionsPanel.add(lblEnterPrescriptionId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 10, 96, 19);
		SearchPresctionsPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(211, 12, 16, 13);
		SearchPresctionsPanel.add(lblOr);
		
		JLabel lblPatientId_1 = new JLabel("Patient name:");
		lblPatientId_1.setBounds(250, 13, 88, 13);
		SearchPresctionsPanel.add(lblPatientId_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(336, 10, 106, 19);
		SearchPresctionsPanel.add(textField_3);
		
		JButton btnRetrivePrescription = new JButton("Retrive Prescription");
		btnRetrivePrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRetrivePrescription.setBounds(148, 39, 155, 19);
		SearchPresctionsPanel.add(btnRetrivePrescription);
		
		JScrollPane scrollPaneForResults = new JScrollPane();
		scrollPaneForResults.setBounds(6, 65, 436, 133);
		SearchPresctionsPanel.add(scrollPaneForResults);
		
		JPanel GenerateReportPanel = new JPanel();
		tabbedPane.addTab("Generate New Report", null, GenerateReportPanel, null);
		GenerateReportPanel.setLayout(null);
		
		JButton btnGenerateNewPatient = new JButton("Crearte A New Report For A Specific Patient");
		btnGenerateNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PT_SpecificPatientReport newPatientReport = new PT_SpecificPatientReport();
				
			}
		});
		btnGenerateNewPatient.setHorizontalAlignment(SwingConstants.LEADING);
		btnGenerateNewPatient.setBounds(0, 10, 381, 21);
		GenerateReportPanel.add(btnGenerateNewPatient);
		
		JButton btnNewButton = new JButton("Create A New Report Based On A Specified Physician ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PT_PhysicianSpecificReport newPhysicianBasedReport = new PT_PhysicianSpecificReport();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setBounds(0, 41, 381, 21);
		GenerateReportPanel.add(btnNewButton);
		
		JButton btnCreateASummary = new JButton("Create A Summary Report For A Specific Medication");
		btnCreateASummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PT_MedSpecificSummaryReport newMedSummaryReport = new PT_MedSpecificSummaryReport();
			}
		});
		btnCreateASummary.setHorizontalAlignment(SwingConstants.LEADING);
		btnCreateASummary.setBounds(0, 72, 381, 21);
		GenerateReportPanel.add(btnCreateASummary);
	}
}
