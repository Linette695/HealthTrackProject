import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.util.*;
public class ER_UI {
	private ER_Backend ER_BE = new ER_Backend();


	/*GUI Variables*/
	static JPanel EnterNewMedicalEncouterpanel;
	static JTabbedPane CreateNewPatienttabbedPane;

	private JFrame frmCreateNewPatient;
	private JTextField txtEnterName;
	private JTextField txtEnterLastName;
	private JTextField textTNumber; //fix when called textField
	private JTextField txtEnterAddress;
	private JTextField txtEnterCarrierId;
	private JTextField txtEnterPhysicianId;
	private JTextField txtEnterId;
	private JTextField tfHeartrate;
	private JTextField tfBloodPressure;
	private JTextField tfTemperature;
	private JTextField tfTreatment;
	private JTextField tfNotes;
	private JTextField tfComplaints;
	private JTextField tfPid;
	private JTextField tfEid;
	private JTextField tfDiagnosis;
	private JTextField tfReferral;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ER_UI window = new ER_UI();
					window.frmCreateNewPatient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ER_UI() {
		initialize();
	}
	
	/*METHODS*/
	/*NOTES: The index for each tab are  
	 *		Create New Patient tab   == 0
	 *		Create New Medical Encounter == 1
	 *		Generate Patient Report  == 2
	 *		Patient List   == 3
	 */
	//Method invoked when user wants to create new Patient
		public void ERCreateNewPatient() {
			frmCreateNewPatient.setVisible(true);
			CreateNewPatienttabbedPane.setEnabledAt(0,true);			//Make sure the new patient tab is enabled
			CreateNewPatienttabbedPane.setSelectedIndex(0); 			//Make sure the new patient tab is the visible tab
			CreateNewPatienttabbedPane.setEnabledAt(1, true);			//Make sure the new medical encounter tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(2, true);			//Make sure the Generate patient report tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(3, true);			//Make sure the patient list tab is disabled
			
		}//End of ERCreateNEwPatient 
		
		//Method invoked when user wants to create a new medical encounter
		public void ERCreateNewMedicalEncounter() {
			frmCreateNewPatient.setVisible(true);
			CreateNewPatienttabbedPane.setEnabledAt(1, true);			//Make sure the new medical encounter is enabled
			CreateNewPatienttabbedPane.setSelectedIndex(1);				//MAke sure the new medical encounter is the visible tab
			CreateNewPatienttabbedPane.setEnabledAt(0, true);			//Make sure the new patient tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(2, true);			//Make sure the Generate patient report tab is disabled
			
		}//End of ERCreateNewMedicalEncounter
	
		//Method invoked when user wants to Generate a specific patient report
		public void ERCreateNewPatientReport() {
			frmCreateNewPatient.setVisible(true);
			CreateNewPatienttabbedPane.setEnabledAt(2, true);			//Make sure the generate patient report tab is enabled
			CreateNewPatienttabbedPane.setSelectedIndex(2);				//Make sure the generate patient report is the visible tab
			CreateNewPatienttabbedPane.setEnabledAt(0, true);			//Make sure the new patient tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(1, true);			//Make sure the create new medical encounter tab is disabled
		}//End of ERCreateNewPatientReport
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateNewPatient = new JFrame();
		frmCreateNewPatient.setTitle("Electronic Patient Record");
		frmCreateNewPatient.setBounds(100, 100, 509, 394);
		frmCreateNewPatient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		frmCreateNewPatient.getContentPane().setLayout(gridBagLayout);
		CreateNewPatienttabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_CreateNewPatienttabbedPane = new GridBagConstraints();
		gbc_CreateNewPatienttabbedPane.gridheight = 2;
		gbc_CreateNewPatienttabbedPane.fill = GridBagConstraints.BOTH;
		gbc_CreateNewPatienttabbedPane.gridx = 0;
		gbc_CreateNewPatienttabbedPane.gridy = 0;
		frmCreateNewPatient.getContentPane().add(CreateNewPatienttabbedPane, gbc_CreateNewPatienttabbedPane);

		JPanel CreateNewPatientPanel = new JPanel();
		CreateNewPatienttabbedPane.addTab("Create New Patient", null, CreateNewPatientPanel, null);
		CreateNewPatienttabbedPane.setEnabledAt(0, true);

		JLabel lblNewLabel_1 = new JLabel("You are now creating a new patient, please enter their information below.");
		lblNewLabel_1.setBounds(46, 5, 339, 13);

		JLabel lblNewLabel = new JLabel("Enter patient's first name:");
		lblNewLabel.setBounds(10, 26, 119, 13);

		txtEnterName = new JTextField();
		txtEnterName.setBounds(142, 23, 114, 19);
		txtEnterName.setText("Enter first name");
		txtEnterName.setColumns(10);

		JLabel lblEnterPatientsLast = new JLabel("Enter patient's last name:");
		lblEnterPatientsLast.setBounds(10, 51, 128, 13);

		txtEnterLastName = new JTextField();
		txtEnterLastName.setBounds(142, 48, 114, 19);
		txtEnterLastName.setText("Enter last name");
		txtEnterLastName.setColumns(10);

		JLabel lblEnterPatientsPhone = new JLabel("Enter patient's phone number (with no spaces/symbols, ex: 6192661486):");
		lblEnterPatientsPhone.setBounds(10, 73, 339, 13);

		textTNumber = new JTextField();
		textTNumber.setBounds(142, 92, 117, 19);
		textTNumber.setText("##########");
		textTNumber.setColumns(10);

		JLabel lblEnterPatientsAddress = new JLabel("Enter patient's address:");
		lblEnterPatientsAddress.setBounds(10, 120, 157, 13);

		txtEnterAddress = new JTextField();
		txtEnterAddress.setBounds(171, 117, 306, 19);
		txtEnterAddress.setText("Enter address");
		txtEnterAddress.setColumns(10);

		JLabel lblEnterPatientsDate = new JLabel("Enter patient's date of birith:");
		lblEnterPatientsDate.setBounds(10, 142, 131, 13);

		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(45, 168, 43, 13);

		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(199, 168, 37, 13);

		JSpinner spinnerDay = new JSpinner();
		spinnerDay.setBounds(240, 161, 41, 28);
		spinnerDay.setModel(new SpinnerNumberModel(1, 1, 31, 1));

		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(291, 168, 31, 13);

		JSpinner spinnerYear = new JSpinner();
		spinnerYear.setBounds(326, 162, 55, 26);
		spinnerYear.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		
		JSpinner spinnerMonth = new JSpinner();
		spinnerMonth.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMonth.setBounds(118, 161, 41, 28);


		JLabel lblPatientsGender = new JLabel("Patient's gender:");
		lblPatientsGender.setBounds(10, 198, 78, 13);

		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setBounds(92, 195, 97, 19);
		comboBoxGender.setMaximumRowCount(3);
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male", "Other"}));

		JLabel lblInsuranceCarrierid = new JLabel("Insurance carrier (ID of carrier):");
		lblInsuranceCarrierid.setBounds(10, 223, 179, 13);

		txtEnterCarrierId = new JTextField();
		txtEnterCarrierId.setBounds(193, 220, 96, 19);
		txtEnterCarrierId.setText("Enter carrier ID");
		txtEnterCarrierId.setColumns(10);

		JLabel lblPrimaryCarePhysician = new JLabel("Primary care physician (ID of physician):");
		lblPrimaryCarePhysician.setBounds(10, 248, 235, 13);

		txtEnterPhysicianId = new JTextField();
		txtEnterPhysicianId.setBounds(249, 245, 111, 19);
		txtEnterPhysicianId.setText("Enter physician ID");
		txtEnterPhysicianId.setColumns(10);

		JButton btnSaveNewPatient = new JButton("SAVE NEW PATIENT");
		btnSaveNewPatient.setBounds(197, 282, 150, 21);
		btnSaveNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient p = new Patient();
				p.pid = ER_BE.getMaxID() + 1;
				p.pfirstname = txtEnterName.getText();
				p.plastname = txtEnterLastName.getText();
				p.tnumber = Integer.parseInt(textTNumber.getText());
				p.address = txtEnterAddress.getText();
				p.iid = Integer.parseInt(txtEnterCarrierId.getText());
				p.dob = ER_BE.createDate((int)spinnerYear.getValue(), (int)spinnerMonth.getValue(), (int)spinnerDay.getValue());
				p.gender = (String) comboBoxGender.getSelectedItem();
				p.pcp = Integer.parseInt(txtEnterPhysicianId.getText());
				
				ER_BE.createPatient(p);
			}
		});
		CreateNewPatientPanel.setLayout(null);
		CreateNewPatientPanel.add(lblNewLabel_1);
		CreateNewPatientPanel.add(lblNewLabel);
		CreateNewPatientPanel.add(lblEnterPatientsLast);
		CreateNewPatientPanel.add(txtEnterName);
		CreateNewPatientPanel.add(txtEnterLastName);
		CreateNewPatientPanel.add(lblEnterPatientsPhone);
		CreateNewPatientPanel.add(textTNumber);
		CreateNewPatientPanel.add(lblEnterPatientsAddress);
		CreateNewPatientPanel.add(txtEnterAddress);
		CreateNewPatientPanel.add(lblEnterPatientsDate);
		CreateNewPatientPanel.add(lblPatientsGender);
		CreateNewPatientPanel.add(lblMonth);
		CreateNewPatientPanel.add(comboBoxGender);
		CreateNewPatientPanel.add(lblDay);
		CreateNewPatientPanel.add(spinnerDay);
		CreateNewPatientPanel.add(lblYear);
		CreateNewPatientPanel.add(spinnerYear);
		CreateNewPatientPanel.add(spinnerMonth);
		CreateNewPatientPanel.add(lblPrimaryCarePhysician);
		CreateNewPatientPanel.add(txtEnterPhysicianId);
		CreateNewPatientPanel.add(lblInsuranceCarrierid);
		CreateNewPatientPanel.add(txtEnterCarrierId);
		CreateNewPatientPanel.add(btnSaveNewPatient);
		
		

		EnterNewMedicalEncouterpanel = new JPanel();
		CreateNewPatienttabbedPane.addTab("Enter New Medical Encounter", null, EnterNewMedicalEncouterpanel, null);
		EnterNewMedicalEncouterpanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Heartrate");
		lblNewLabel_2.setBounds(350, 10, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Temperature");
		lblNewLabel_3.setBounds(350, 80, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Blood Pressure");
		lblNewLabel_4.setBounds(350, 45, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_4);
		
		tfHeartrate = new JTextField();
		tfHeartrate.setBounds(350, 25, 50, 19);
		EnterNewMedicalEncouterpanel.add(tfHeartrate);
		tfHeartrate.setColumns(10);
		
		tfBloodPressure = new JTextField();
		tfBloodPressure.setBounds(350, 60, 50, 19);
		EnterNewMedicalEncouterpanel.add(tfBloodPressure);
		tfBloodPressure.setColumns(10);
		
		tfTemperature = new JTextField();
		tfTemperature.setBounds(350, 95, 50, 19);
		EnterNewMedicalEncouterpanel.add(tfTemperature);
		tfTemperature.setColumns(10);
		
		tfTreatment = new JTextField();
		tfTreatment.setBounds(10, 275, 450, 20);
		EnterNewMedicalEncouterpanel.add(tfTreatment);
		tfTreatment.setColumns(10);
		
		tfNotes = new JTextField();
		tfNotes.setBounds(10, 240, 450, 19);
		EnterNewMedicalEncouterpanel.add(tfNotes);
		tfNotes.setColumns(10);
		
		tfComplaints = new JTextField();
		tfComplaints.setBounds(10, 205, 450, 19);
		EnterNewMedicalEncouterpanel.add(tfComplaints);
		tfComplaints.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Patient Complaints");
		lblNewLabel_5.setBounds(10, 190, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Practicioner Notes");
		lblNewLabel_6.setBounds(10, 225, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Treatment Plan");
		lblNewLabel_7.setBounds(10, 260, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Patient ID");
		lblNewLabel_8.setBounds(10, 10, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_8);
		
		tfPid = new JTextField();
		tfPid.setBounds(10, 25, 96, 19);
		EnterNewMedicalEncouterpanel.add(tfPid);
		tfPid.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Practicitioner ID");
		lblNewLabel_9.setBounds(10, 45, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_9);
		
		tfEid = new JTextField();
		tfEid.setBounds(10, 60, 96, 19);
		EnterNewMedicalEncouterpanel.add(tfEid);
		tfEid.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Date");
		lblNewLabel_10.setBounds(120, 8, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_10);
		
		JSpinner spinnerYearIn = new JSpinner();
		spinnerYearIn.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinnerYearIn.setBounds(120, 23, 50, 20);
		EnterNewMedicalEncouterpanel.add(spinnerYearIn);
		
		JSpinner spinnerDayIn = new JSpinner();
		spinnerDayIn.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDayIn.setBounds(240, 23, 40, 20);
		EnterNewMedicalEncouterpanel.add(spinnerDayIn);
		
		JLabel lblNewLabel_10_1 = new JLabel("Follow Up Date");
		lblNewLabel_10_1.setBounds(120, 43, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_10_1);
		
		JSpinner spinnerYearFollow = new JSpinner();
		spinnerYearFollow.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinnerYearFollow.setBounds(120, 58, 50, 20);
		EnterNewMedicalEncouterpanel.add(spinnerYearFollow);
		
		JSpinner spinnerDayFollow = new JSpinner();
		spinnerDayFollow.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDayFollow.setBounds(240, 58, 40, 20);
		EnterNewMedicalEncouterpanel.add(spinnerDayFollow);
		
		tfDiagnosis = new JTextField();
		tfDiagnosis.setBounds(10, 170, 450, 19);
		EnterNewMedicalEncouterpanel.add(tfDiagnosis);
		tfDiagnosis.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Diagnosis");
		lblNewLabel_11.setBounds(10, 155, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_11);
		
		tfReferral = new JTextField();
		tfReferral.setColumns(10);
		tfReferral.setBounds(10, 135, 450, 19);
		EnterNewMedicalEncouterpanel.add(tfReferral);
		
		JLabel lblNewLabel_11_1 = new JLabel("Specialist Referral");
		lblNewLabel_11_1.setBounds(10, 120, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_11_1);
		
		JSpinner spinnerMonthIn = new JSpinner();
		spinnerMonthIn.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMonthIn.setBounds(185, 25, 40, 20);
		EnterNewMedicalEncouterpanel.add(spinnerMonthIn);
		
		JSpinner spinnerMonthFollow = new JSpinner();
		spinnerMonthFollow.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMonthFollow.setBounds(185, 58, 40, 20);
		EnterNewMedicalEncouterpanel.add(spinnerMonthFollow);
		
		JButton btnNewButton = new JButton("Create Medical Encounter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedicalEncounter me = new MedicalEncounter();
				me.dateinput = ER_BE.createDate((int)spinnerYearIn.getValue(), (int)spinnerMonthIn.getValue(), (int)spinnerDayIn.getValue());
				me.eid = Integer.parseInt(tfEid.getText());
				me.pid = Integer.parseInt(tfPid.getText());
				me.complaints = tfComplaints.getText();
				me.heartrate = Integer.parseInt(tfHeartrate.getText());
				me.bloodpressure = tfBloodPressure.getText();
				me.temperature = Float.parseFloat(tfTemperature.getText());
				me.notes = tfNotes.getText();;
				me.diagnosis = tfDiagnosis.getText();;
				me.treatment = tfTreatment.getText();;
				me.referral = tfReferral.getText();;
				me.datefollowup = ER_BE.createDate((int)spinnerYearFollow.getValue(), (int)spinnerMonthFollow.getValue(), (int)spinnerDayFollow.getValue());
				
				ER_BE.createMedicalEncounter(me);
			}
		});
		btnNewButton.setBounds(150, 300, 200, 21);
		EnterNewMedicalEncouterpanel.add(btnNewButton);
		
		JPanel patientReportPanel = new JPanel();
		CreateNewPatienttabbedPane.addTab("Generate Patient Report", null, patientReportPanel, null);
		patientReportPanel.setLayout(null);
		
		JLabel lblEnterPatientsId_1 = new JLabel("Enter patient's ID # :");
		lblEnterPatientsId_1.setBounds(0, 3, 126, 13);
		patientReportPanel.add(lblEnterPatientsId_1);
		
		txtEnterId = new JTextField();
		txtEnterId.setBounds(123, 0, 96, 19);
		txtEnterId.setText("Enter ID");
		txtEnterId.setHorizontalAlignment(SwingConstants.LEFT);
		patientReportPanel.add(txtEnterId);
		txtEnterId.setColumns(10);
		
		JScrollPane patientInfoScrollPane_1 = new JScrollPane();
		patientInfoScrollPane_1.setBounds(28, 29, 452, 234);
		patientReportPanel.add(patientInfoScrollPane_1);
		
		DefaultListModel listModelPatientReport = new DefaultListModel();
		JList listPatientReport = new JList(listModelPatientReport);
		patientInfoScrollPane_1.setViewportView(listPatientReport);
		
		JButton btnGeneratePatientReport = new JButton("Generate Patient Report");
		btnGeneratePatientReport.setBounds(143, 273, 227, 21);
		btnGeneratePatientReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModelPatientReport.clear();

				int pid = Integer.parseInt(txtEnterId.getText());
				
				java.util.List<MedicalEncounter> meList = ER_BE.returnMedicalEncounter(pid);
				
				for (int i=0; i<meList.size(); i++) {
					listModelPatientReport.addElement(meList.get(i).returnInfoString());
				}
			//TODO Display the information of the patient indicated by the given ID #
				/*use txtEnterID to obtain the inputed ID #, and display information on the patientInfoScrollPane_1 */
			
			}
		});
		patientReportPanel.add(btnGeneratePatientReport);
		
		JPanel ReportPanel = new JPanel();
		CreateNewPatienttabbedPane.addTab("Patient List", null, ReportPanel, null);
		CreateNewPatienttabbedPane.setEnabledAt(3, true);
		ReportPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 400, 200);

		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		//list.setBounds(0, 0, 400, 200);

		scrollPane.setViewportView(list);
		ReportPanel.add(scrollPane);



		JButton btnDeletePatient = new JButton("Delete patient");
		btnDeletePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list.getSelectedIndex();
				int id = ER_BE.returnPatientInfoAll().get(i).pid;
				ER_BE.deletePatient(id);

				listModel.clear();

				java.util.List<Patient> patientList = ER_BE.returnPatientInfoAll();
				for (i=0; i<patientList.size(); i++) {
					listModel.addElement(patientList.get(i).returnInfoString());
				}
			}
		});
		btnDeletePatient.setBounds(20, 250, 200, 21);
		ReportPanel.add(btnDeletePatient);

		JButton btnRefresh = new JButton("Refresh List");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();

				java.util.List<Patient> patientList = ER_BE.returnPatientInfoAll();
				for (int i=0; i<patientList.size(); i++) {
					listModel.addElement(patientList.get(i).returnInfoString());
				}
			}
		});
		btnRefresh.setBounds(20, 210, 200, 21);
		ReportPanel.add(btnRefresh);

	}//End of initialize method
}//End of ER_UI class

