import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

public class EQ_StatisticalReport {

	private JFrame frmGeneratingAStatistical;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EQ_StatisticalReport window = new EQ_StatisticalReport();
					window.frmGeneratingAStatistical.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EQ_StatisticalReport() {
		initialize();
		frmGeneratingAStatistical.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingAStatistical = new JFrame();
		frmGeneratingAStatistical.setTitle("Generating A Statistical Report Of Equipment Problems");
		frmGeneratingAStatistical.setBounds(100, 100, 521, 353);
		frmGeneratingAStatistical.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingAStatistical.getContentPane().setLayout(null);
		
		JLabel lblSpecifyAPeriod = new JLabel("Specify a period of time to create a statistical summary report of the number of \r\n");
		lblSpecifyAPeriod.setBounds(0, 10, 497, 13);
		frmGeneratingAStatistical.getContentPane().add(lblSpecifyAPeriod);
		
		JLabel lblProblemsReportedDuring = new JLabel("equipment problems reported during that period.");
		lblProblemsReportedDuring.setBounds(0, 22, 497, 13);
		frmGeneratingAStatistical.getContentPane().add(lblProblemsReportedDuring);
		
		JLabel lblPickStartDate = new JLabel("Pick start date:");
		lblPickStartDate.setForeground(Color.DARK_GRAY);
		lblPickStartDate.setBounds(22, 38, 170, 20);
		frmGeneratingAStatistical.getContentPane().add(lblPickStartDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jauary", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(22, 58, 81, 20);
		frmGeneratingAStatistical.getContentPane().add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(114, 58, 40, 21);
		frmGeneratingAStatistical.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinner_1.setBounds(164, 59, 50, 20);
		frmGeneratingAStatistical.getContentPane().add(spinner_1);
		
		JLabel lblPickEndDate = new JLabel("Pick end date:");
		lblPickEndDate.setForeground(Color.DARK_GRAY);
		lblPickEndDate.setBounds(249, 38, 170, 20);
		frmGeneratingAStatistical.getContentPane().add(lblPickEndDate);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Jauary", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_3.setBounds(249, 58, 81, 20);
		frmGeneratingAStatistical.getContentPane().add(comboBox_3);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_3.setBounds(340, 58, 40, 21);
		frmGeneratingAStatistical.getContentPane().add(spinner_3);
		
		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinner_3_1.setBounds(390, 59, 50, 20);
		frmGeneratingAStatistical.getContentPane().add(spinner_3_1);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenerateReport.setBounds(124, 89, 198, 21);
		frmGeneratingAStatistical.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setToolTipText("");
		scrollPane_2.setBounds(0, 120, 497, 186);
		frmGeneratingAStatistical.getContentPane().add(scrollPane_2);
	}

}
