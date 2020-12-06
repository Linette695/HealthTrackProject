import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

public class IB_InsuranceCarrierReport {

	private JFrame frmGeneratingAnInsurance;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IB_InsuranceCarrierReport window = new IB_InsuranceCarrierReport();
					window.frmGeneratingAnInsurance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IB_InsuranceCarrierReport() {
		initialize();
		frmGeneratingAnInsurance.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingAnInsurance = new JFrame();
		frmGeneratingAnInsurance.setTitle("Generating An Insurance Carrier Report");
		frmGeneratingAnInsurance.setBounds(100, 100, 450, 300);
		frmGeneratingAnInsurance.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingAnInsurance.getContentPane().setLayout(null);
		
		JLabel lblSpecifiyAnInsurance = new JLabel("Specifiy an insurance carrier to display all of their deliquent invoices.");
		lblSpecifiyAnInsurance.setBounds(0, 0, 436, 13);
		frmGeneratingAnInsurance.getContentPane().add(lblSpecifiyAnInsurance);
		
		JLabel lblEnterPatientId = new JLabel("Enter patient ID: ");
		lblEnterPatientId.setBounds(10, 23, 108, 13);
		frmGeneratingAnInsurance.getContentPane().add(lblEnterPatientId);
		
		textField = new JTextField();
		textField.setText("Enter ID #");
		textField.setColumns(10);
		textField.setBounds(93, 34, 113, 19);
		frmGeneratingAnInsurance.getContentPane().add(textField);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGenerateReport.setBounds(262, 33, 134, 20);
		frmGeneratingAnInsurance.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 63, 436, 190);
		frmGeneratingAnInsurance.getContentPane().add(scrollPane);
	}

}
