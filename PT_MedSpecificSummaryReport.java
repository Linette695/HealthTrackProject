import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class PT_MedSpecificSummaryReport {

	private JFrame frmGeneratingNewSummary;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PT_MedSpecificSummaryReport window = new PT_MedSpecificSummaryReport();
					window.frmGeneratingNewSummary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PT_MedSpecificSummaryReport() {
		initialize();
		frmGeneratingNewSummary.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingNewSummary = new JFrame();
		frmGeneratingNewSummary.setTitle("Generating Summary Report For A Specific Medication");
		frmGeneratingNewSummary.setBounds(100, 100, 450, 300);
		frmGeneratingNewSummary.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingNewSummary.getContentPane().setLayout(null);
		
		JLabel lblMedicationId = new JLabel("Medication ID:");
		lblMedicationId.setBounds(28, 47, 83, 13);
		frmGeneratingNewSummary.getContentPane().add(lblMedicationId);
		
		textField = new JTextField();
		textField.setText("Enter ID #");
		textField.setColumns(10);
		textField.setBounds(121, 44, 96, 19);
		frmGeneratingNewSummary.getContentPane().add(textField);
		
		JLabel lblPleaseSpecifiyA = new JLabel("Please specifiy a specific medication to create a summary report of the");
		lblPleaseSpecifiyA.setBounds(0, 0, 426, 13);
		frmGeneratingNewSummary.getContentPane().add(lblPleaseSpecifiyA);
		
		JLabel lblSummaryReportOf = new JLabel("number of prescriptions filled for that medication.");
		lblSummaryReportOf.setBounds(0, 16, 426, 13);
		frmGeneratingNewSummary.getContentPane().add(lblSummaryReportOf);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(259, 43, 133, 21);
		frmGeneratingNewSummary.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 73, 436, 180);
		frmGeneratingNewSummary.getContentPane().add(scrollPane);
	}

}
