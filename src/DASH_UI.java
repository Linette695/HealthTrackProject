  
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.SwingConstants;


public class DASH_UI {

	private JFrame DASHframe;
	private ER_UI erSubsystem;
	private SCHED schedSubsystem;
	private LT ltSubsystem;
	private PT ptSubsystem;
	private IB ibSubsystem;
	private EQ eqSubsystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DASH_UI window = new DASH_UI();
					window.DASHframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DASH_UI() {
		mainGUI.mainFrame.setVisible(false);			//Make sure the mainFrame is not open, so the only frame visible will now be the dashboard frame
		mainGUI.logInFrame.setVisible(false);			//Make sure the log in Frame is not open, so the only frame visible will now be the dashboard frame
		
		initialize();
		DASHframe.setVisible(true);				//MAke sure Dashboard frame is visible
		
		erSubsystem = new ER_UI();			//Initialize the ER subsystem
		schedSubsystem = new SCHED();		//Initialize the SCHED subsystem
		ltSubsystem = new LT();				//Initialize the LT subsystem
		ptSubsystem = new PT();				//Initialize the PT subsystem
		ibSubsystem = new IB();				//Initialize the IB subsystem
		eqSubsystem = new EQ();				//Initialize the EQ subsystem
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DASHframe = new JFrame();
		DASHframe.setTitle("Health Track");
		DASHframe.setBounds(100, 100, 450, 300);
		DASHframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DASHframe.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JTabbedPane ERtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		DASHframe.getContentPane().add(ERtabbedPane, "name_2453419553316400");
		
		JPanel ERPanel = new JPanel();
		ERtabbedPane.addTab("Electronic Patient Record ( ER )", null, ERPanel, null);
		GridBagLayout gbl_ERPanel = new GridBagLayout();
		gbl_ERPanel.columnWidths = new int[]{155, 121, 0};
		gbl_ERPanel.rowHeights = new int[]{21, 0, 0, 0};
		gbl_ERPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_ERPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		ERPanel.setLayout(gbl_ERPanel);
		
		JButton btnCreateNewPatient = new JButton("Create New Patient");
		btnCreateNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erSubsystem.ERCreateNewPatient();
			}
		});
		GridBagConstraints gbc_btnCreateNewPatient = new GridBagConstraints();
		gbc_btnCreateNewPatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateNewPatient.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCreateNewPatient.gridx = 0;
		gbc_btnCreateNewPatient.gridy = 0;
		ERPanel.add(btnCreateNewPatient, gbc_btnCreateNewPatient);
		
		JButton btnEnterNewMedical = new JButton("Enter New Medical Encounter");
		btnEnterNewMedical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			erSubsystem.ERCreateNewMedicalEncounter();
			
			
			}
		});
		GridBagConstraints gbc_btnEnterNewMedical = new GridBagConstraints();
		gbc_btnEnterNewMedical.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterNewMedical.gridx = 0;
		gbc_btnEnterNewMedical.gridy = 1;
		ERPanel.add(btnEnterNewMedical, gbc_btnEnterNewMedical);
		
		JButton btnGeneratePatientReport = new JButton("Generate Patient Report");
		btnGeneratePatientReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erSubsystem.ERCreateNewPatientReport();
			}
		});
		GridBagConstraints gbc_btnGeneratePatientReport = new GridBagConstraints();
		gbc_btnGeneratePatientReport.anchor = GridBagConstraints.WEST;
		gbc_btnGeneratePatientReport.insets = new Insets(0, 0, 0, 5);
		gbc_btnGeneratePatientReport.gridx = 0;
		gbc_btnGeneratePatientReport.gridy = 2;
		ERPanel.add(btnGeneratePatientReport, gbc_btnGeneratePatientReport);
		
		final JTabbedPane SCHEDtabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		DASHframe.getContentPane().add(SCHEDtabbedPane_1, "name_2453437677515500");
		
		JPanel SCHEDPanel = new JPanel();
		SCHEDtabbedPane_1.addTab("Physician Scheduler ( SCHED )", null, SCHEDPanel, null);
		GridBagLayout gbl_SCHEDPanel = new GridBagLayout();
		gbl_SCHEDPanel.columnWidths = new int[]{186, 59, 0};
		gbl_SCHEDPanel.rowHeights = new int[]{13, 0, 0, 0};
		gbl_SCHEDPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_SCHEDPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		SCHEDPanel.setLayout(gbl_SCHEDPanel);
		
		JButton btnSchedulePhysicianAppointment = new JButton("Schedule New Physician Appointment");
		btnSchedulePhysicianAppointment.setHorizontalAlignment(SwingConstants.LEFT);
		btnSchedulePhysicianAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedSubsystem.SCHEDScheduleNewPhysicianApp();
			
			}
		});
		GridBagConstraints gbc_btnSchedulePhysicianAppointment = new GridBagConstraints();
		gbc_btnSchedulePhysicianAppointment.insets = new Insets(0, 0, 5, 5);
		gbc_btnSchedulePhysicianAppointment.gridx = 0;
		gbc_btnSchedulePhysicianAppointment.gridy = 0;
		SCHEDPanel.add(btnSchedulePhysicianAppointment, gbc_btnSchedulePhysicianAppointment);
		
		JButton btnScheduleNewPatient = new JButton("Schedule New Patient Appointment");
		btnScheduleNewPatient.setHorizontalAlignment(SwingConstants.LEFT);
		btnScheduleNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedSubsystem.SCHEDScheduleNewPatientApp();
			}
		});
		GridBagConstraints gbc_btnScheduleNewPatient = new GridBagConstraints();
		gbc_btnScheduleNewPatient.anchor = GridBagConstraints.WEST;
		gbc_btnScheduleNewPatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnScheduleNewPatient.gridx = 0;
		gbc_btnScheduleNewPatient.gridy = 1;
		SCHEDPanel.add(btnScheduleNewPatient, gbc_btnScheduleNewPatient);
		
		JButton btnGenerateNewReport = new JButton("Generate New Report");
		btnGenerateNewReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedSubsystem.SCHEDGenerateNewReport();
			}
		});
		GridBagConstraints gbc_btnGenerateNewReport = new GridBagConstraints();
		gbc_btnGenerateNewReport.anchor = GridBagConstraints.WEST;
		gbc_btnGenerateNewReport.insets = new Insets(0, 0, 0, 5);
		gbc_btnGenerateNewReport.gridx = 0;
		gbc_btnGenerateNewReport.gridy = 2;
		SCHEDPanel.add(btnGenerateNewReport, gbc_btnGenerateNewReport);
		
		JTabbedPane LTtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		DASHframe.getContentPane().add(LTtabbedPane, "name_132104797100000");
		
		JPanel LTPanel = new JPanel();
		LTtabbedPane.addTab("Lab Order Tracking ( LT )", null, LTPanel, null);
		LTPanel.setLayout(null);
		
		JButton btnRequestNewLab = new JButton("Request New Lab Order");
		btnRequestNewLab.setHorizontalAlignment(SwingConstants.LEFT);
		btnRequestNewLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ltSubsystem.LTRequestNewOrder();
			}
		});
		btnRequestNewLab.setBounds(0, 10, 209, 21);
		LTPanel.add(btnRequestNewLab);
		
		JButton btnUpdateALab = new JButton("Update A Lab Order");
		btnUpdateALab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ltSubsystem.LTupdateAOrder();
			}
		});
		btnUpdateALab.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateALab.setBounds(0, 41, 209, 21);
		LTPanel.add(btnUpdateALab);
		
		JButton btnGenerateAReport = new JButton("Generate A New Report");
		btnGenerateAReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ltSubsystem.LTcreateNewReport();
			}
		});
		btnGenerateAReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnGenerateAReport.setBounds(0, 72, 209, 21);
		LTPanel.add(btnGenerateAReport);
		
		JTabbedPane PTtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		DASHframe.getContentPane().add(PTtabbedPane, "name_930605227919300");
		
		JPanel PTPanel = new JPanel();
		PTtabbedPane.addTab("Pharmacy Order Tracking ( PT )", null, PTPanel, null);
		PTPanel.setLayout(null);
		
		JButton btnOrderNewPrescription = new JButton("Order New Prescription");
		btnOrderNewPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ptSubsystem.PTOrderNewPrescription();
			}
		});
		btnOrderNewPrescription.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrderNewPrescription.setBounds(0, 10, 209, 21);
		PTPanel.add(btnOrderNewPrescription);
		
		JButton btnRetriveAPrescription = new JButton("Retrieve A Prescription");
		btnRetriveAPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ptSubsystem.PTRetrieveAPrescription();
			}
		});
		btnRetriveAPrescription.setHorizontalAlignment(SwingConstants.LEFT);
		btnRetriveAPrescription.setBounds(0, 72, 209, 21);
		PTPanel.add(btnRetriveAPrescription);
		
		JButton btnFillAnExistent = new JButton("Fill An Existent Prescription");
		btnFillAnExistent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ptSubsystem.PTFillAnExistentPrescription();
			}
		});
		btnFillAnExistent.setHorizontalAlignment(SwingConstants.LEFT);
		btnFillAnExistent.setBounds(0, 41, 209, 21);
		PTPanel.add(btnFillAnExistent);
		
		JButton btnGenerateANew = new JButton("Generate A New Report");
		btnGenerateANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ptSubsystem.PTGenerateNewReport();
			}
		});
		btnGenerateANew.setHorizontalAlignment(SwingConstants.LEFT);
		btnGenerateANew.setBounds(0, 103, 209, 21);
		PTPanel.add(btnGenerateANew);
		
		JTabbedPane IBtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		DASHframe.getContentPane().add(IBtabbedPane, "name_940132906759600");
		
		JPanel IBpanel = new JPanel();
		IBtabbedPane.addTab("Insurance Billing ( IB )", null, IBpanel, null);
		IBpanel.setLayout(null);
		
		JButton btnBillForA = new JButton("Bill A Service");
		btnBillForA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ibSubsystem.IBNewBill();
			}
		});
		btnBillForA.setHorizontalAlignment(SwingConstants.LEFT);
		btnBillForA.setBounds(0, 10, 330, 21);
		IBpanel.add(btnBillForA);
		
		JButton btnGenerateAReport_1 = new JButton("Generate A New Report");
		btnGenerateAReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ibSubsystem.IBGenerateNewReport();
			}
		});
		btnGenerateAReport_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnGenerateAReport_1.setBounds(0, 105, 330, 21);
		IBpanel.add(btnGenerateAReport_1);
		
		JButton btnGenerateAMonthly = new JButton("Generate A Monthly Invoice");
		btnGenerateAMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ibSubsystem.IBNewMonthlyInvoice();
			}
		});
		btnGenerateAMonthly.setHorizontalAlignment(SwingConstants.LEADING);
		btnGenerateAMonthly.setBounds(0, 74, 330, 21);
		IBpanel.add(btnGenerateAMonthly);
		
		JButton btnInformationOnThe = new JButton("Information On The Available Clinic Services ");
		btnInformationOnThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ibSubsystem.IBAvailableServices();
			}
		});
		btnInformationOnThe.setHorizontalAlignment(SwingConstants.LEADING);
		btnInformationOnThe.setBounds(0, 41, 330, 21);
		IBpanel.add(btnInformationOnThe);
		
		JTabbedPane EQtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		DASHframe.getContentPane().add(EQtabbedPane, "name_1005764266522800");
		
		JPanel EQpanel = new JPanel();
		EQtabbedPane.addTab("Equiptment Inventory & Maintenance ( EQ )", null, EQpanel, null);
		EQpanel.setLayout(null);
		
		JButton btnReportAnEquiptment = new JButton("Report An Equiptment Problem");
		btnReportAnEquiptment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eqSubsystem.EQNewProblem();
			}
		});
		btnReportAnEquiptment.setHorizontalAlignment(SwingConstants.LEFT);
		btnReportAnEquiptment.setBounds(0, 10, 330, 21);
		EQpanel.add(btnReportAnEquiptment);
		
		JButton btnVendorMaintenance = new JButton("Vendor List Maintenance");
		btnVendorMaintenance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eqSubsystem.EQVendorListMaintenance();
			}
		});
		btnVendorMaintenance.setHorizontalAlignment(SwingConstants.LEADING);
		btnVendorMaintenance.setBounds(0, 101, 330, 21);
		EQpanel.add(btnVendorMaintenance);
		
		JButton btnQueryTheEquiptment = new JButton("Query The Equiptment Invenotry Database");
		btnQueryTheEquiptment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eqSubsystem.EQQueryEquipment();
			}
		});
		btnQueryTheEquiptment.setHorizontalAlignment(SwingConstants.LEADING);
		btnQueryTheEquiptment.setBounds(0, 70, 330, 21);
		EQpanel.add(btnQueryTheEquiptment);
		
		JButton btnGenerateAReport_1_1 = new JButton("Generate A New Report");
		btnGenerateAReport_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eqSubsystem.EQGenerateNewReport();
			}
		});
		btnGenerateAReport_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnGenerateAReport_1_1.setBounds(0, 132, 330, 21);
		EQpanel.add(btnGenerateAReport_1_1);
		
		JButton btnUpdateAnEquiptment = new JButton("Update An Equiptment Problem");
		btnUpdateAnEquiptment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eqSubsystem.EQUpdateProblem();
			}
		});
		btnUpdateAnEquiptment.setHorizontalAlignment(SwingConstants.LEADING);
		btnUpdateAnEquiptment.setBounds(0, 41, 330, 21);
		EQpanel.add(btnUpdateAnEquiptment);
		
		JMenuBar menuBar = new JMenuBar();
		DASHframe.setJMenuBar(menuBar);
		
		JButton btnEr = new JButton("ER");
		btnEr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ERtabbedPane.setVisible(true);
				SCHEDtabbedPane_1.setVisible(false);
				LTtabbedPane.setVisible(false);
				PTtabbedPane.setVisible(false);
				IBtabbedPane.setVisible(false);
				EQtabbedPane.setVisible(false);
			}
		});
		menuBar.add(btnEr);
		
		JButton btnNewButton = new JButton("SCHED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ERtabbedPane.setVisible(false);
				LTtabbedPane.setVisible(false);
				PTtabbedPane.setVisible(false);
				IBtabbedPane.setVisible(false);
				EQtabbedPane.setVisible(false);
				SCHEDtabbedPane_1.setVisible(true);
			}
		});
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LTtabbedPane.setVisible(true);
				ERtabbedPane.setVisible(false);
				SCHEDtabbedPane_1.setVisible(false);
				PTtabbedPane.setVisible(false);
				IBtabbedPane.setVisible(false);
				EQtabbedPane.setVisible(false);
			}
		});
		menuBar.add(btnNewButton_1);
		
		JButton btnPt = new JButton("PT");
		btnPt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PTtabbedPane.setVisible(true);
				LTtabbedPane.setVisible(false);
				ERtabbedPane.setVisible(false);
				SCHEDtabbedPane_1.setVisible(false);
				IBtabbedPane.setVisible(false);
				EQtabbedPane.setVisible(false);
				
			}
		});
		menuBar.add(btnPt);
		
		JButton btnIb = new JButton("IB");
		btnIb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IBtabbedPane.setVisible(true);
				LTtabbedPane.setVisible(false);
				ERtabbedPane.setVisible(false);
				SCHEDtabbedPane_1.setVisible(false);
				PTtabbedPane.setVisible(false);	
				EQtabbedPane.setVisible(false);
			}
		});
		menuBar.add(btnIb);
		
		JButton btnEq = new JButton("EQ");
		btnEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EQtabbedPane.setVisible(true);
				LTtabbedPane.setVisible(false);
				ERtabbedPane.setVisible(false);
				SCHEDtabbedPane_1.setVisible(false);
				PTtabbedPane.setVisible(false);	
				IBtabbedPane.setVisible(false);
				
				
			}
		});
		menuBar.add(btnEq);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Log Out button has been clicked");		//For debug 
				
				DASHframe.setVisible(false);				//Close the dashboard window
				mainGUI.mainFrame.setVisible(true);		//Return to the welcome screen of the system
			}
		});
		menuBar.add(btnLogOut);
	}
}
