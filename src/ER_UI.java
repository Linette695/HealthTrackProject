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
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ER_UI {
	//COMMENTED OUT FOR UI DISPLAY ONLY
	//private ER_Backend ER_BE = new ER_Backend();


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
			CreateNewPatienttabbedPane.setEnabledAt(1, false);			//Make sure the new medical encounter tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(2, false);			//Make sure the Generate patient report tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(3, false);			//Make sure the patient list tab is disabled
		
		}//End of ERCreateNEwPatient 
		
		//Method invoked when user wants to create a new medical encounter
		public void ERCreateNewMedicalEncounter() {
			frmCreateNewPatient.setVisible(true);
			CreateNewPatienttabbedPane.setEnabledAt(1, true);			//Make sure the new medical encounter is enabled
			CreateNewPatienttabbedPane.setSelectedIndex(1);				//MAke sure the new medical encounter is the visible tab
			CreateNewPatienttabbedPane.setEnabledAt(0, false);			//Make sure the new patient tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(2, false);			//Make sure the Generate patient report tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(3, true);			//Make sure the patient list tab is enabled (to help user if needed)
			
		}//End of ERCreateNewMedicalEncounter
	
		//Method invoked when user wants to Generate a specific patient report
		public void ERCreateNewPatientReport() {
			frmCreateNewPatient.setVisible(true);
			CreateNewPatienttabbedPane.setEnabledAt(2, true);			//Make sure the generate patient report tab is enabled
			CreateNewPatienttabbedPane.setSelectedIndex(2);				//Make sure the generate patient report is the visible tab
			CreateNewPatienttabbedPane.setEnabledAt(0, false);			//Make sure the new patient tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(1, false);			//Make sure the create new medical encounter tab is disabled
			CreateNewPatienttabbedPane.setEnabledAt(3, true);			//Make sure the patient list tab is enabled (to help user if needed)
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

		JLabel lblNewLabel = new JLabel("Enter patient's first name:");

		txtEnterName = new JTextField();
		txtEnterName.setText("Enter first name");
		txtEnterName.setColumns(10);

		JLabel lblEnterPatientsLast = new JLabel("Enter patient's last name:");

		txtEnterLastName = new JTextField();
		txtEnterLastName.setText("Enter last name");
		txtEnterLastName.setColumns(10);

		JLabel lblEnterPatientsPhone = new JLabel("Enter patient's phone number (with no spaces/symbols, ex: 6192661486):");

		textTNumber = new JTextField();
		textTNumber.setText("##########");
		textTNumber.setColumns(10);

		JLabel lblEnterPatientsAddress = new JLabel("Enter patient's address:");

		txtEnterAddress = new JTextField();
		txtEnterAddress.setText("Enter address");
		txtEnterAddress.setColumns(10);

		JLabel lblEnterPatientsDate = new JLabel("Enter patient's date of birith:");

		JLabel lblMonth = new JLabel("Month:");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setMaximumRowCount(12);

		JLabel lblDay = new JLabel("Day:");

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));

		JLabel lblYear = new JLabel("Year:");

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));

		JLabel lblPatientsGender = new JLabel("Patient's gender:");

		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setMaximumRowCount(3);
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male", "Other"}));

		JLabel lblInsuranceCarrierid = new JLabel("Insurance carrier (ID of carrier):");

		txtEnterCarrierId = new JTextField();
		txtEnterCarrierId.setText("Enter carrier ID");
		txtEnterCarrierId.setColumns(10);

		JLabel lblPrimaryCarePhysician = new JLabel("Primary care physician (ID of physician):");

		txtEnterPhysicianId = new JTextField();
		txtEnterPhysicianId.setText("Enter physician ID");
		txtEnterPhysicianId.setColumns(10);

		JButton btnSaveNewPatient = new JButton("SAVE NEW PATIENT");
		btnSaveNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COMMENTED OUT FOR UI DISPLAY ONLY
//				Patient p = new Patient();
//				p.pid = ER_BE.getMaxID() + 1;
//				p.pfirstname = txtEnterName.getText();
//				p.plastname = txtEnterLastName.getText();
//				p.tnumber = Integer.parseInt(textTNumber.getText());
//				p.address = txtEnterAddress.getText();
//				p.iid = Integer.parseInt(txtEnterCarrierId.getText());
//				p.dob = null;
//				p.gender = (String) comboBoxGender.getSelectedItem();
//				p.pcp = Integer.parseInt(txtEnterPhysicianId.getText());
				
				//COMMENTED OUT FOR UI DISPLAY ONLY
				//ER_BE.createPatient(p);
			}
		});
		GroupLayout gl_CreateNewPatientPanel = new GroupLayout(CreateNewPatientPanel);
		gl_CreateNewPatientPanel.setHorizontalGroup(
				gl_CreateNewPatientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
						.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
										.addGap(46)
										.addComponent(lblNewLabel_1))
								.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
										.addContainerGap()
										.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel)
												.addComponent(lblEnterPatientsLast, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtEnterName)
												.addComponent(txtEnterLastName, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
								.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblEnterPatientsPhone))
								.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
										.addGap(142)
										.addComponent(textTNumber, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_CreateNewPatientPanel.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblEnterPatientsAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtEnterAddress, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
										.addGap(24))
								.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
										.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
														.addContainerGap()
														.addComponent(lblEnterPatientsDate))
												.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
														.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.LEADING, false)
																.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(lblPatientsGender, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
																		.addGap(45)
																		.addComponent(lblMonth, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(comboBoxGender, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
																.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
										.addContainerGap()
										.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
														.addComponent(lblPrimaryCarePhysician, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtEnterPhysicianId, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
														.addComponent(lblInsuranceCarrierid, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtEnterCarrierId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGap(141))
								.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
										.addGap(197)
										.addComponent(btnSaveNewPatient)))
						.addContainerGap())
				);
		gl_CreateNewPatientPanel.setVerticalGroup(
				gl_CreateNewPatientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CreateNewPatientPanel.createSequentialGroup()
						.addGap(5)
						.addComponent(lblNewLabel_1)
						.addGap(5)
						.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEnterName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterPatientsLast)
								.addComponent(txtEnterLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblEnterPatientsPhone)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textTNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterPatientsAddress)
								.addComponent(txtEnterAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblEnterPatientsDate)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMonth, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDay)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYear)
								.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPatientsGender)
								.addComponent(comboBoxGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInsuranceCarrierid)
								.addComponent(txtEnterCarrierId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_CreateNewPatientPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrimaryCarePhysician)
								.addComponent(txtEnterPhysicianId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(btnSaveNewPatient)
						.addContainerGap(26, Short.MAX_VALUE))
				);
		CreateNewPatientPanel.setLayout(gl_CreateNewPatientPanel);

		EnterNewMedicalEncouterpanel = new JPanel();
		CreateNewPatienttabbedPane.addTab("Enter New Medical Encounter", null, EnterNewMedicalEncouterpanel, null);
		EnterNewMedicalEncouterpanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Heartrate");
		lblNewLabel_2.setBounds(400, 10, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_2);
		
		tfHeartrate = new JTextField();
		tfHeartrate.setBounds(400, 20, 50, 19);
		EnterNewMedicalEncouterpanel.add(tfHeartrate);
		tfHeartrate.setColumns(10);
		
		tfBloodPressure = new JTextField();
		tfBloodPressure.setBounds(400, 50, 50, 19);
		EnterNewMedicalEncouterpanel.add(tfBloodPressure);
		tfBloodPressure.setColumns(10);
		
		tfTemperature = new JTextField();
		tfTemperature.setBounds(400, 80, 50, 19);
		EnterNewMedicalEncouterpanel.add(tfTemperature);
		tfTemperature.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Temperature");
		lblNewLabel_3.setBounds(400, 70, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Blood Pressure");
		lblNewLabel_4.setBounds(400, 40, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_4);
		
		tfTreatment = new JTextField();
		tfTreatment.setBounds(10, 300, 450, 20);
		EnterNewMedicalEncouterpanel.add(tfTreatment);
		tfTreatment.setColumns(10);
		
		tfNotes = new JTextField();
		tfNotes.setBounds(10, 270, 450, 19);
		EnterNewMedicalEncouterpanel.add(tfNotes);
		tfNotes.setColumns(10);
		
		tfComplaints = new JTextField();
		tfComplaints.setBounds(10, 240, 450, 19);
		EnterNewMedicalEncouterpanel.add(tfComplaints);
		tfComplaints.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Patient Complaints");
		lblNewLabel_5.setBounds(10, 230, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Practicioner Notes");
		lblNewLabel_6.setBounds(10, 260, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Treatment Plan");
		lblNewLabel_7.setBounds(10, 290, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Patient ID");
		lblNewLabel_8.setBounds(10, 10, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_8);
		
		tfPid = new JTextField();
		tfPid.setBounds(10, 20, 96, 19);
		EnterNewMedicalEncouterpanel.add(tfPid);
		tfPid.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Practicitioner ID");
		lblNewLabel_9.setBounds(10, 40, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_9);
		
		tfEid = new JTextField();
		tfEid.setBounds(10, 50, 96, 19);
		EnterNewMedicalEncouterpanel.add(tfEid);
		tfEid.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Date");
		lblNewLabel_10.setBounds(10, 70, 100, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_10);
		
		JComboBox cbMonthIn = new JComboBox();
		cbMonthIn.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonthIn.setBounds(60, 80, 70, 21);
		EnterNewMedicalEncouterpanel.add(cbMonthIn);
		
		JSpinner spinnerYearIn = new JSpinner();
		spinnerYearIn.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinnerYearIn.setBounds(10, 80, 50, 20);
		EnterNewMedicalEncouterpanel.add(spinnerYearIn);
		
		JSpinner spinnerDayIn = new JSpinner();
		spinnerDayIn.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDayIn.setBounds(130, 80, 40, 20);
		EnterNewMedicalEncouterpanel.add(spinnerDayIn);
		
		JLabel lblNewLabel_10_1 = new JLabel("Follow Up Date");
		lblNewLabel_10_1.setBounds(10, 111, 200, 13);
		EnterNewMedicalEncouterpanel.add(lblNewLabel_10_1);
		
		JComboBox cbMonthIn_1 = new JComboBox();
		cbMonthIn_1.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonthIn_1.setBounds(60, 121, 70, 21);
		EnterNewMedicalEncouterpanel.add(cbMonthIn_1);
		
		JSpinner spinnerYearIn_1 = new JSpinner();
		spinnerYearIn_1.setBounds(10, 121, 50, 20);
		EnterNewMedicalEncouterpanel.add(spinnerYearIn_1);
		
		JSpinner spinnerDayIn_1 = new JSpinner();
		spinnerDayIn_1.setBounds(130, 121, 40, 20);
		EnterNewMedicalEncouterpanel.add(spinnerDayIn_1);
		
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
		
		JButton btnGeneratePatientReport = new JButton("Generate Patient Report");
		btnGeneratePatientReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//TODO Display the information of the patient indicated by the given ID #
				/*use txtEnterID to obtain the inputed ID #, and display information on the patientInfoScrollPane_1 */
			
			}
		});
		btnGeneratePatientReport.setBounds(143, 273, 227, 21);
		patientReportPanel.add(btnGeneratePatientReport);
		
		JScrollPane patientInfoScrollPane_1 = new JScrollPane();
		patientInfoScrollPane_1.setBounds(28, 29, 452, 234);
		patientReportPanel.add(patientInfoScrollPane_1);
		
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
				//COMMENTED OUT FOR UI DISPLAY ONLY
//				int i = list.getSelectedIndex();
//				int id = ER_BE.returnPatientInfoAll().get(i).pid;
//				ER_BE.deletePatient(id);
//
//				listModel.clear();
//
//				java.util.List<Patient> patientList = ER_BE.returnPatientInfoAll();
//				for (i=0; i<patientList.size(); i++) {
//					listModel.addElement(patientList.get(i).returnInfoString());
//				}
			}
		});
		btnDeletePatient.setBounds(20, 250, 200, 21);
		ReportPanel.add(btnDeletePatient);

		JButton btnRefresh = new JButton("Refresh List");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();

				//COMMENTED OUT FOR UI DISPLAY ONLY
//				java.util.List<Patient> patientList = ER_BE.returnPatientInfoAll();
//				for (int i=0; i<patientList.size(); i++) {
//					listModel.addElement(patientList.get(i).returnInfoString());
//				}
			}
		});
		btnRefresh.setBounds(20, 210, 200, 21);
		ReportPanel.add(btnRefresh);

	}//End of initialize method
}//End of ER_UI class

