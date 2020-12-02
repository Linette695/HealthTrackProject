import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class LT_PhysicianSpecificReport {

	private JFrame frmGeneratingNewReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LT_PhysicianSpecificReport window = new LT_PhysicianSpecificReport();
					window.frmGeneratingNewReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LT_PhysicianSpecificReport() {
		initialize();
		frmGeneratingNewReport.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingNewReport = new JFrame();
		frmGeneratingNewReport.setTitle("Generating New Report");
		frmGeneratingNewReport.setBounds(100, 100, 450, 300);
		frmGeneratingNewReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingNewReport.getContentPane().setLayout(null);
		
		JLabel lblPickAPhysician = new JLabel("Pick a physician:");
		lblPickAPhysician.setHorizontalAlignment(SwingConstants.LEADING);
		lblPickAPhysician.setForeground(Color.BLACK);
		lblPickAPhysician.setBounds(0, 13, 106, 13);
		frmGeneratingNewReport.getContentPane().add(lblPickAPhysician);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Physician #1", "Physician #2", "All"}));
		comboBox_5.setBounds(116, 10, 106, 19);
		frmGeneratingNewReport.getContentPane().add(comboBox_5);
		
		JLabel lblPickAType = new JLabel("Pick a type of lab tests:");
		lblPickAType.setForeground(Color.BLACK);
		lblPickAType.setBounds(0, 39, 137, 13);
		frmGeneratingNewReport.getContentPane().add(lblPickAType);
		
		JComboBox comboBox_5_1 = new JComboBox();
		comboBox_5_1.setModel(new DefaultComboBoxModel(new String[] {"All types", "Lab test type #1", "Lab test type #2"}));
		comboBox_5_1.setBounds(147, 36, 123, 19);
		frmGeneratingNewReport.getContentPane().add(comboBox_5_1);
		
		JLabel lblSpecifyAPeriod = new JLabel("Specify a period of time:");
		lblSpecifyAPeriod.setForeground(Color.BLACK);
		lblSpecifyAPeriod.setBounds(0, 62, 323, 13);
		frmGeneratingNewReport.getContentPane().add(lblSpecifyAPeriod);
		
		JLabel lblPickStartDate = new JLabel("Pick start date:");
		lblPickStartDate.setForeground(Color.DARK_GRAY);
		lblPickStartDate.setBounds(10, 80, 170, 20);
		frmGeneratingNewReport.getContentPane().add(lblPickStartDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(10, 100, 81, 20);
		frmGeneratingNewReport.getContentPane().add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(102, 100, 40, 21);
		frmGeneratingNewReport.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinner_1.setBounds(152, 101, 50, 20);
		frmGeneratingNewReport.getContentPane().add(spinner_1);
		
		JLabel lblPickEndDate = new JLabel("Pick end date:");
		lblPickEndDate.setForeground(Color.DARK_GRAY);
		lblPickEndDate.setBounds(237, 80, 170, 20);
		frmGeneratingNewReport.getContentPane().add(lblPickEndDate);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_3.setBounds(237, 100, 81, 20);
		frmGeneratingNewReport.getContentPane().add(comboBox_3);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_3.setBounds(328, 100, 40, 21);
		frmGeneratingNewReport.getContentPane().add(spinner_3);
		
		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinner_3_1.setBounds(378, 101, 50, 20);
		frmGeneratingNewReport.getContentPane().add(spinner_3_1);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(280, 13, 148, 39);
		frmGeneratingNewReport.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 130, 436, 133);
		frmGeneratingNewReport.getContentPane().add(scrollPane);
	}

}
