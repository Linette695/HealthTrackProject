import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

public class IB_PatientBasedReport {

	private JFrame frmGeneratingAPatient;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IB_PatientBasedReport window = new IB_PatientBasedReport();
					window.frmGeneratingAPatient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IB_PatientBasedReport() {
		initialize();
		frmGeneratingAPatient.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingAPatient = new JFrame();
		frmGeneratingAPatient.setTitle("Generating A Patient Report");
		frmGeneratingAPatient.setBounds(100, 100, 450, 300);
		frmGeneratingAPatient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingAPatient.getContentPane().setLayout(null);
		
		JLabel lblTypeOfReport = new JLabel("Type of report:");
		lblTypeOfReport.setBounds(10, 10, 107, 13);
		frmGeneratingAPatient.getContentPane().add(lblTypeOfReport);
		
		JComboBox cbMonthIn = new JComboBox();
		cbMonthIn.setModel(new DefaultComboBoxModel(new String[] {"List all delinquent invoices", "Copy of their last invoice "}));
		cbMonthIn.setBounds(127, 10, 198, 21);
		frmGeneratingAPatient.getContentPane().add(cbMonthIn);
		
		JLabel lblEnterPatientId = new JLabel("Enter patient ID: ");
		lblEnterPatientId.setBounds(10, 36, 108, 13);
		frmGeneratingAPatient.getContentPane().add(lblEnterPatientId);
		
		textField = new JTextField();
		textField.setText("Enter ID #");
		textField.setColumns(10);
		textField.setBounds(127, 41, 113, 19);
		frmGeneratingAPatient.getContentPane().add(textField);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenerateReport.setBounds(101, 67, 179, 28);
		frmGeneratingAPatient.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 97, 436, 166);
		frmGeneratingAPatient.getContentPane().add(scrollPane);
	}

}
