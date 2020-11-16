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
	private JTextField textField;
	private JTextField txtEnterAddress;
	private JTextField txtEnterCarrierId;
	private JTextField txtEnterPhysicianId;
	private JTextField txtEnterPatientId;
	private JTextField txtEnterEmployeeId;
	private JTextField txtEnterServiceId;
	private JTextField txtEnterPhysicianId_1;


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
	//Method invoked when user wants to create new Patient
	public void ERCreateNewPatient() {
		frmCreateNewPatient.setVisible(true);
		CreateNewPatienttabbedPane.setEnabledAt(0,true);			//Make sure the new patient tab is enabled
		CreateNewPatienttabbedPane.setSelectedIndex(0); 			//Make sure the new patient tab is the visible tab
		CreateNewPatienttabbedPane.setEnabledAt(1, false);			//Make sure the new medical encounter tab is disabled
	}//End of ERCreateNEwPatient 

	//Method invoked when user want to create a new medical encounter
	public void ERCreateNewMedicalEncounter() {
		frmCreateNewPatient.setVisible(true);
		CreateNewPatienttabbedPane.setEnabledAt(1, true);			//Make sure the new medical encounter is enabled
		CreateNewPatienttabbedPane.setSelectedIndex(1);				//MAke sure the new medical encounter is the visible tab
		CreateNewPatienttabbedPane.setEnabledAt(0, false);			//Make sure the new patient tab is disabled

	}//End of ERCreateNewMedicalEncounter




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

		textField = new JTextField();
		textField.setText("##########");
		textField.setColumns(10);

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

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(3);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male", "Other"}));

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
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
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
																.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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


		JLabel lblYouAteNow = new JLabel("You are now entering a new medical encounter.");
		lblYouAteNow.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblEnterPatientsId = new JLabel("Enter patient's ID:");

		txtEnterPatientId = new JTextField();
		txtEnterPatientId.setText("Enter patient ID");
		txtEnterPatientId.setColumns(10);

		JLabel lblDateOfEncounter = new JLabel("Date of encounter:");

		JLabel lblMonth_1 = new JLabel("Month:");

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));

		JLabel lblDay_1 = new JLabel("Day:");

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));

		JLabel lblYeat = new JLabel("Year:");

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));

		JLabel lblEmployee = new JLabel("Employee ID ( who is inputting encounter): ");

		txtEnterEmployeeId = new JTextField();
		txtEnterEmployeeId.setText("Enter employee ID");
		txtEnterEmployeeId.setColumns(10);

		JLabel lblEnterCurrentTime = new JLabel("Enter current time:");

		JLabel label = new JLabel(":");

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 5, 1));

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(1, 1, 12, 1));

		JSpinner spinner_6 = new JSpinner();
		spinner_6.setModel(new SpinnerNumberModel(0, 0, 9, 1));

		JLabel lblEnterServiceId = new JLabel("Enter service ID:");

		txtEnterServiceId = new JTextField();
		txtEnterServiceId.setText("Enter service ID");
		txtEnterServiceId.setColumns(10);

		JLabel lblEnter = new JLabel("Enter physician ID:");

		txtEnterPhysicianId_1 = new JTextField();
		txtEnterPhysicianId_1.setText("Enter physician ID");
		txtEnterPhysicianId_1.setColumns(10);

		JButton btnSubmitMedicalEncounter = new JButton("Submit Medical Encounter");

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		GroupLayout gl_EnterNewMedicalEncouterpanel = new GroupLayout(EnterNewMedicalEncouterpanel);
		gl_EnterNewMedicalEncouterpanel.setHorizontalGroup(
				gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
						.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
										.addContainerGap()
										.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblYouAteNow, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
														.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblEnterPatientsId, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblDateOfEncounter, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtEnterPatientId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
										.addGap(58)
										.addComponent(lblMonth_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblDay_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addGap(24)
										.addComponent(lblYeat, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
										.addGap(164)
										.addComponent(btnSubmitMedicalEncounter))
								.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
										.addContainerGap()
										.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
														.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
																		.addComponent(lblEnterCurrentTime, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
																		.addComponent(lblEmployee, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(txtEnterEmployeeId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
														.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
														.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(lblEnter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(lblEnterServiceId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
														.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.LEADING, false)
																.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(txtEnterServiceId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
																		.addGap(2)
																		.addComponent(txtEnterPhysicianId_1)))))))
						.addContainerGap(43, Short.MAX_VALUE))
				);
		gl_EnterNewMedicalEncouterpanel.setVerticalGroup(
				gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EnterNewMedicalEncouterpanel.createSequentialGroup()
						.addComponent(lblYouAteNow)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterPatientsId)
								.addComponent(txtEnterPatientId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblDateOfEncounter)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMonth_1)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDay_1)
								.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYeat))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmployee)
								.addComponent(txtEnterEmployeeId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterCurrentTime)
								.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterServiceId)
								.addComponent(txtEnterServiceId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_EnterNewMedicalEncouterpanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnter)
								.addComponent(txtEnterPhysicianId_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
						.addComponent(btnSubmitMedicalEncounter)
						.addGap(38))
				);
		EnterNewMedicalEncouterpanel.setLayout(gl_EnterNewMedicalEncouterpanel);

		JPanel ReportPanel = new JPanel();
		CreateNewPatienttabbedPane.addTab("Patient List", null, ReportPanel, null);
		CreateNewPatienttabbedPane.setEnabledAt(2, true);
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

