import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class SCHED_WeeklyReport {

	private JFrame frmGeneratingWeeklyReport;

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

	/**
	 * Create the application.
	 */
	public SCHED_WeeklyReport() {
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
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"All"}));
		comboBox_5.setBounds(135, 10, 88, 19);
		frmGeneratingWeeklyReport.getContentPane().add(comboBox_5);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(290, 9, 136, 21);
		frmGeneratingWeeklyReport.getContentPane().add(btnGenerateReport);
	}

}
