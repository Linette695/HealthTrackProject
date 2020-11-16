  
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
		erSubsystem = new ER_UI();
		schedSubsystem = new SCHED();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DASHframe = new JFrame();
		DASHframe.setBounds(100, 100, 450, 300);
		DASHframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DASHframe.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JTabbedPane ERtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		DASHframe.getContentPane().add(ERtabbedPane, "name_2453419553316400");
		
		JPanel panel = new JPanel();
		ERtabbedPane.addTab("ER", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{155, 121, 0};
		gbl_panel.rowHeights = new int[]{21, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
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
		panel.add(btnCreateNewPatient, gbc_btnCreateNewPatient);
		
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
		panel.add(btnEnterNewMedical, gbc_btnEnterNewMedical);
		
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
		panel.add(btnGeneratePatientReport, gbc_btnGeneratePatientReport);
		
		final JTabbedPane SCHEDtabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		DASHframe.getContentPane().add(SCHEDtabbedPane_1, "name_2453437677515500");
		
		JPanel panel_1 = new JPanel();
		SCHEDtabbedPane_1.addTab("SCHED", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{186, 59, 0};
		gbl_panel_1.rowHeights = new int[]{13, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
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
		panel_1.add(btnSchedulePhysicianAppointment, gbc_btnSchedulePhysicianAppointment);
		
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
		panel_1.add(btnScheduleNewPatient, gbc_btnScheduleNewPatient);
		
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
		panel_1.add(btnGenerateNewReport, gbc_btnGenerateNewReport);
		
		JTabbedPane LTtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		DASHframe.getContentPane().add(LTtabbedPane, "name_132104797100000");
		
		JPanel LTPanel = new JPanel();
		LTtabbedPane.addTab("New tab", null, LTPanel, null);
		
		JMenuBar menuBar = new JMenuBar();
		DASHframe.setJMenuBar(menuBar);
		
		JButton btnEr = new JButton("ER");
		btnEr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ERtabbedPane.setVisible(true);
				SCHEDtabbedPane_1.setVisible(false);
			}
		});
		menuBar.add(btnEr);
		
		JButton btnNewButton = new JButton("SCHED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ERtabbedPane.setVisible(false);
				SCHEDtabbedPane_1.setVisible(true);
			}
		});
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(btnNewButton_1);
		
		JButton btnPt = new JButton("PT");
		menuBar.add(btnPt);
		
		JButton btnIb = new JButton("IB");
		menuBar.add(btnIb);
		
		JButton btnEq = new JButton("EQ");
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
