import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

public class EQ_CompleteInventoryReport {

	private JFrame frmGeneratingAComplete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EQ_CompleteInventoryReport window = new EQ_CompleteInventoryReport();
					window.frmGeneratingAComplete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EQ_CompleteInventoryReport() {
		initialize();
		frmGeneratingAComplete.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingAComplete = new JFrame();
		frmGeneratingAComplete.setTitle("Generating A Complete Inventory Report");
		frmGeneratingAComplete.setBounds(100, 100, 484, 300);
		frmGeneratingAComplete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingAComplete.getContentPane().setLayout(null);
		
		JLabel lblSpecifyADepartment = new JLabel("Specify a department, to generate their complete equipment inventory report.");
		lblSpecifyADepartment.setBounds(0, 10, 460, 13);
		frmGeneratingAComplete.getContentPane().add(lblSpecifyADepartment);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(26, 36, 93, 13);
		frmGeneratingAComplete.getContentPane().add(lblDepartment);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Department #1", "Department #2", "...", "All"}));
		comboBox_5.setBounds(116, 32, 129, 19);
		frmGeneratingAComplete.getContentPane().add(comboBox_5);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenerateReport.setBounds(284, 33, 142, 29);
		frmGeneratingAComplete.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setToolTipText("");
		scrollPane_2.setBounds(0, 72, 460, 181);
		frmGeneratingAComplete.getContentPane().add(scrollPane_2);
	}

}
