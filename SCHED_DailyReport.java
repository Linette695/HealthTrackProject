import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SCHED_DailyReport {

	private JFrame frmGeneratingDailyReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCHED_DailyReport window = new SCHED_DailyReport();
					window.frmGeneratingDailyReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SCHED_DailyReport() {
		initialize();
		frmGeneratingDailyReport.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingDailyReport = new JFrame();
		frmGeneratingDailyReport.setTitle("Generating Daily Report");
		frmGeneratingDailyReport.setBounds(100, 100, 450, 300);
		frmGeneratingDailyReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingDailyReport.getContentPane().setLayout(null);
		
		JLabel lblPickMonthAnd = new JLabel("Pick month & day:");
		lblPickMonthAnd.setBounds(10, 13, 118, 13);
		frmGeneratingDailyReport.getContentPane().add(lblPickMonthAnd);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_2_1.setBounds(138, 10, 75, 19);
		frmGeneratingDailyReport.getContentPane().add(comboBox_2_1);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_4.setBounds(223, 10, 41, 20);
		frmGeneratingDailyReport.getContentPane().add(spinner_4);
		
		JLabel lblSpecifyPhysician = new JLabel("Pick a Physician:");
		lblSpecifyPhysician.setBounds(20, 43, 106, 13);
		frmGeneratingDailyReport.getContentPane().add(lblSpecifyPhysician);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"All"}));
		comboBox_5.setBounds(145, 40, 88, 19);
		frmGeneratingDailyReport.getContentPane().add(comboBox_5);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateReport.setBounds(290, 39, 136, 21);
		frmGeneratingDailyReport.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 416, 183);
		frmGeneratingDailyReport.getContentPane().add(scrollPane);
	}

}
