import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SCHED {
	
	/*GUI Variables*/
	static JTabbedPane tabbedPane;

	private JFrame frmPhysicianScheduler;
	private JTextField txtNone;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCHED window = new SCHED();
					window.frmPhysicianScheduler.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SCHED() {
		initialize();
	}

	/*METHODS*/
	//Method invoked when user wants to Schedule physician appointment
		public void SCHEDScheduleNewPhysicianApp() {
			frmPhysicianScheduler.setVisible(true);
			tabbedPane.setEnabledAt(0,true);			//Make sure the Schedule physician appointment tab is enabled
			tabbedPane.setSelectedIndex(0); 			//Make sure the Schedule physician appointment tab is the visible tab
			tabbedPane.setEnabledAt(1, false);			//Make sure the Schedule patient appointment  tab is disabled
			tabbedPane.setEnabledAt(2, false);			//Make sure the Generate Report tab is disabled
		}//End of SCHEDScheduleNewPhysicianApp 
		
		//Method invoked when user wants to schedule a new patient appointment 
		public void SCHEDScheduleNewPatientApp() {
			frmPhysicianScheduler.setVisible(true);
			tabbedPane.setEnabledAt(1, true);			//Make sure the Schedule patient appointment tab is enabled
			tabbedPane.setSelectedIndex(1);				//Make sure the Schedule patient appointment tab is the visible tab
			tabbedPane.setEnabledAt(0, false);			//Make sure the Schedule physician appointment tab is disabled
			tabbedPane.setEnabledAt(2, false);			//Make sure the Generate Report tab is disabled
		}//End of SCHEDScheduleNewPatientApp
	
		//Method invoked when user wants to Generate a new report
		public void SCHEDGenerateNewReport() {
			frmPhysicianScheduler.setVisible(true);
			tabbedPane.setEnabledAt(2, true);			//Make sure the new report tab is enabled
			tabbedPane.setSelectedIndex(2);				//Make sure the Generate Report tab is the visible tab
			tabbedPane.setEnabledAt(0, false);			//Make sure the Schedule physician appointment tab is disabled
			tabbedPane.setEnabledAt(1, false);			//Make sure the Schedule patient appointment tab is disabled
		}//End of SCHEDGenerateNewReport
		
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPhysicianScheduler = new JFrame();
		frmPhysicianScheduler.setTitle("Physician Scheduler");
		frmPhysicianScheduler.setBounds(100, 100, 450, 300);
		frmPhysicianScheduler.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPhysicianScheduler.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 426, 253);
		frmPhysicianScheduler.getContentPane().add(tabbedPane);
		
		JPanel panelPhysicianSchedule = new JPanel();
		tabbedPane.addTab("Schedule physician appointment", null, panelPhysicianSchedule, null);
		panelPhysicianSchedule.setLayout(null);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(0, 150, 450, 5);
		panelPhysicianSchedule.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 50, 450, 5);
		panelPhysicianSchedule.add(separator_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 100, 450, 5);
		panelPhysicianSchedule.add(separator_1);
		
		JPanel panelStartDate = new JPanel();
		panelStartDate.setBounds(0, 0, 200, 50);
		panelPhysicianSchedule.add(panelStartDate);
		panelStartDate.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pick start month and day:");
		lblNewLabel.setBounds(0, 0, 170, 20);
		panelStartDate.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(0, 20, 100, 20);
		panelStartDate.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(110, 20, 50, 20);
		panelStartDate.add(spinner);
		
		JPanel panelStartTime = new JPanel();
		panelStartTime.setBounds(0, 50, 200, 50);
		panelPhysicianSchedule.add(panelStartTime);
		panelStartTime.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pick start time:");
		lblNewLabel_1.setBounds(0, 0, 170, 20);
		panelStartTime.add(lblNewLabel_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner_1.setBounds(0, 20, 50, 20);
		panelStartTime.add(spinner_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {":00", ":30"}));
		comboBox_1.setBounds(50, 20, 50, 20);
		panelStartTime.add(comboBox_1);
		
		JPanel panelEndTime = new JPanel();
		panelEndTime.setLayout(null);
		panelEndTime.setBounds(210, 50, 200, 50);
		panelPhysicianSchedule.add(panelEndTime);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pick end time:");
		lblNewLabel_1_1.setBounds(0, 0, 170, 20);
		panelEndTime.add(lblNewLabel_1_1);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner_1_1.setBounds(0, 20, 50, 20);
		panelEndTime.add(spinner_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {":00", ":30"}));
		comboBox_1_1.setBounds(50, 20, 50, 20);
		panelEndTime.add(comboBox_1_1);
		
		JPanel panelPhysician = new JPanel();
		panelPhysician.setBounds(0, 100, 200, 50);
		panelPhysicianSchedule.add(panelPhysician);
		panelPhysician.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Pick a physician:");
		lblNewLabel_2.setBounds(0, 0, 200, 20);
		panelPhysician.add(lblNewLabel_2);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(0, 20, 150, 20);
		panelPhysician.add(comboBox_4);
		
		JPanel panelButton = new JPanel();
		panelButton.setBounds(210, 150, 200, 50);
		panelPhysicianSchedule.add(panelButton);
		panelButton.setLayout(null);
		
		JButton btnNewButton = new JButton("Book appointment");
		btnNewButton.setBounds(0, 0, 200, 20);
		panelButton.add(btnNewButton);
		
		txtNone = new JTextField();
		txtNone.setText("none");
		txtNone.setBounds(100, 20, 100, 20);
		panelButton.add(txtNone);
		txtNone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Result:");
		lblNewLabel_3.setBounds(0, 20, 100, 20);
		panelButton.add(lblNewLabel_3);
		
		JPanel panelEndDate = new JPanel();
		panelEndDate.setLayout(null);
		panelEndDate.setBounds(210, 0, 200, 50);
		panelPhysicianSchedule.add(panelEndDate);
		
		JLabel lblPickEndMonth = new JLabel("Pick end month and day:");
		lblPickEndMonth.setBounds(0, 0, 170, 20);
		panelEndDate.add(lblPickEndMonth);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_3.setBounds(0, 20, 100, 20);
		panelEndDate.add(comboBox_3);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_3.setBounds(110, 20, 50, 20);
		panelEndDate.add(spinner_3);
		
		JPanel panelType = new JPanel();
		panelType.setLayout(null);
		panelType.setBounds(210, 100, 200, 50);
		panelPhysicianSchedule.add(panelType);
		
		JLabel lblNewLabel_2_2 = new JLabel("Pick appointment type");
		lblNewLabel_2_2.setBounds(0, 0, 200, 20);
		panelType.add(lblNewLabel_2_2);
		
		JComboBox comboBox_4_1 = new JComboBox();
		comboBox_4_1.setModel(new DefaultComboBoxModel(new String[] {"Vacation", "Conference", "Other"}));
		comboBox_4_1.setBounds(0, 20, 150, 20);
		panelType.add(comboBox_4_1);
		
		JPanel panelPatientSchedule = new JPanel();
		panelPatientSchedule.setLayout(null);
		tabbedPane.addTab("Schedule patient appointment", null, panelPatientSchedule, null);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(0, 50, 450, 5);
		panelPatientSchedule.add(separator_1_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(0, 100, 450, 5);
		panelPatientSchedule.add(separator_1_2);
		
		JPanel panelDate_1 = new JPanel();
		panelDate_1.setLayout(null);
		panelDate_1.setBounds(0, 0, 200, 50);
		panelPatientSchedule.add(panelDate_1);
		
		JLabel lblNewLabel_4 = new JLabel("Pick a month and day:");
		lblNewLabel_4.setBounds(0, 0, 170, 20);
		panelDate_1.add(lblNewLabel_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Jauary", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_2.setBounds(0, 20, 100, 20);
		panelDate_1.add(comboBox_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_2.setBounds(110, 20, 50, 20);
		panelDate_1.add(spinner_2);
		
		JPanel panelStartTime_1 = new JPanel();
		panelStartTime_1.setLayout(null);
		panelStartTime_1.setBounds(0, 50, 200, 50);
		panelPatientSchedule.add(panelStartTime_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Pick start time:");
		lblNewLabel_1_2.setBounds(0, 0, 170, 20);
		panelStartTime_1.add(lblNewLabel_1_2);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setBounds(0, 20, 50, 20);
		panelStartTime_1.add(spinner_1_2);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setBounds(50, 20, 50, 20);
		panelStartTime_1.add(comboBox_1_2);
		
		JPanel panelEndTime_1 = new JPanel();
		panelEndTime_1.setLayout(null);
		panelEndTime_1.setBounds(210, 50, 200, 50);
		panelPatientSchedule.add(panelEndTime_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Pick end time:");
		lblNewLabel_1_1_1.setBounds(0, 0, 170, 20);
		panelEndTime_1.add(lblNewLabel_1_1_1);
		
		JSpinner spinner_1_1_1 = new JSpinner();
		spinner_1_1_1.setBounds(0, 20, 50, 20);
		panelEndTime_1.add(spinner_1_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBounds(50, 20, 50, 20);
		panelEndTime_1.add(comboBox_1_1_1);
		
		JPanel panelPhysician_1 = new JPanel();
		panelPhysician_1.setLayout(null);
		panelPhysician_1.setBounds(0, 100, 200, 50);
		panelPatientSchedule.add(panelPhysician_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pick a physician:");
		lblNewLabel_2_1.setBounds(0, 0, 200, 20);
		panelPhysician_1.add(lblNewLabel_2_1);
		
		JComboBox comboBox_4_1_2 = new JComboBox();
		comboBox_4_1_2.setBounds(10, 20, 150, 20);
		panelPhysician_1.add(comboBox_4_1_2);
		
		JPanel panelType_1 = new JPanel();
		panelType_1.setLayout(null);
		panelType_1.setBounds(210, 100, 200, 50);
		panelPatientSchedule.add(panelType_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pick appointment type:");
		lblNewLabel_3_1.setBounds(0, 0, 200, 20);
		panelType_1.add(lblNewLabel_3_1);
		
		JComboBox comboBox_4_1_1 = new JComboBox();
		comboBox_4_1_1.setModel(new DefaultComboBoxModel(new String[] {"Routine", "Urgent Care", "Folow-up"}));
		comboBox_4_1_1.setBounds(10, 20, 150, 20);
		panelType_1.add(comboBox_4_1_1);
		
		JPanel panelButton_1 = new JPanel();
		panelButton_1.setLayout(null);
		panelButton_1.setBounds(210, 154, 200, 50);
		panelPatientSchedule.add(panelButton_1);
		
		JButton btnNewButton_1 = new JButton("Book appointment");
		btnNewButton_1.setBounds(0, 0, 200, 20);
		panelButton_1.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("none");
		textField.setColumns(10);
		textField.setBounds(100, 20, 100, 20);
		panelButton_1.add(textField);
		
		JLabel lblNewLabel_3_2 = new JLabel("Result:");
		lblNewLabel_3_2.setBounds(0, 20, 100, 20);
		panelButton_1.add(lblNewLabel_3_2);
		
		JPanel panelReport = new JPanel();
		tabbedPane.addTab("Generate report", null, panelReport, null);
		panelReport.setLayout(null);
		
		JButton btnGenerateDailyReport = new JButton("Generate Daily Report");
		btnGenerateDailyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SCHED_DailyReport newDailyReport = new SCHED_DailyReport();
			
			}
		});
		btnGenerateDailyReport.setBounds(10, 10, 184, 21);
		panelReport.add(btnGenerateDailyReport);
		
		JButton btnGenerateWeeklyReport = new JButton("Generate Weekly Report");
		btnGenerateWeeklyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SCHED_WeeklyReport newWeeklyReport = new SCHED_WeeklyReport();
			
			}
		});
		btnGenerateWeeklyReport.setBounds(10, 41, 184, 21);
		panelReport.add(btnGenerateWeeklyReport);
		
	}//End of initialize method
}//End of SCHED class
