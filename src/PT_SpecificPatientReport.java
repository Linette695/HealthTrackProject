import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class PT_SpecificPatientReport {

	private JFrame frmGeneratingAReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PT_SpecificPatientReport window = new PT_SpecificPatientReport();
					window.frmGeneratingAReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PT_SpecificPatientReport() {
		initialize();
		frmGeneratingAReport.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingAReport = new JFrame();
		frmGeneratingAReport.setTitle("Generating A Report For A Patient");
		frmGeneratingAReport.setBounds(100, 100, 496, 300);
		frmGeneratingAReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingAReport.getContentPane().setLayout(null);
		
		JLabel lblSelectAPatient = new JLabel("Select a patient & specify a period of time, to list all of their ");
		lblSelectAPatient.setForeground(Color.BLACK);
		lblSelectAPatient.setBackground(Color.WHITE);
		lblSelectAPatient.setBounds(0, 0, 509, 18);
		frmGeneratingAReport.getContentPane().add(lblSelectAPatient);
		
		JLabel lblFilledPrescriptionsFor = new JLabel("filled prescriptions for that specific period.");
		lblFilledPrescriptionsFor.setForeground(Color.BLACK);
		lblFilledPrescriptionsFor.setBackground(Color.GRAY);
		lblFilledPrescriptionsFor.setBounds(0, 17, 485, 18);
		frmGeneratingAReport.getContentPane().add(lblFilledPrescriptionsFor);
		
		JLabel lblPickStartDate = new JLabel("Pick start date:");
		lblPickStartDate.setForeground(Color.DARK_GRAY);
		lblPickStartDate.setBounds(10, 40, 170, 20);
		frmGeneratingAReport.getContentPane().add(lblPickStartDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(10, 60, 81, 20);
		frmGeneratingAReport.getContentPane().add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(102, 60, 40, 21);
		frmGeneratingAReport.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinner_1.setBounds(152, 61, 50, 20);
		frmGeneratingAReport.getContentPane().add(spinner_1);
		
		JLabel lblPickEndDate = new JLabel("Pick end date:");
		lblPickEndDate.setForeground(Color.DARK_GRAY);
		lblPickEndDate.setBounds(237, 40, 170, 20);
		frmGeneratingAReport.getContentPane().add(lblPickEndDate);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_3.setBounds(237, 60, 81, 20);
		frmGeneratingAReport.getContentPane().add(comboBox_3);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_3.setBounds(328, 60, 40, 21);
		frmGeneratingAReport.getContentPane().add(spinner_3);
		
		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinner_3_1.setBounds(378, 61, 50, 20);
		frmGeneratingAReport.getContentPane().add(spinner_3_1);
		
		JLabel lblPickAPatient = new JLabel("Pick a patient:");
		lblPickAPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickAPatient.setForeground(Color.DARK_GRAY);
		lblPickAPatient.setBounds(0, 98, 106, 13);
		frmGeneratingAReport.getContentPane().add(lblPickAPatient);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Patient #1", "Patient #2", "..."}));
		comboBox_5.setBounds(116, 95, 88, 19);
		frmGeneratingAReport.getContentPane().add(comboBox_5);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(292, 90, 133, 28);
		frmGeneratingAReport.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 475, 144);
		frmGeneratingAReport.getContentPane().add(scrollPane);
	}

}
