import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class PT_PhysicianSpecificReport {

	private JFrame frmGeneratingPhysicianBased;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PT_PhysicianSpecificReport window = new PT_PhysicianSpecificReport();
					window.frmGeneratingPhysicianBased.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PT_PhysicianSpecificReport() {
		initialize();
		frmGeneratingPhysicianBased.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingPhysicianBased = new JFrame();
		frmGeneratingPhysicianBased.setTitle("Generating Physician Based Report");
		frmGeneratingPhysicianBased.setBounds(100, 100, 450, 300);
		frmGeneratingPhysicianBased.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingPhysicianBased.getContentPane().setLayout(null);
		
		JLabel lblPickAPhysician = new JLabel("Pick a physician:");
		lblPickAPhysician.setHorizontalAlignment(SwingConstants.LEADING);
		lblPickAPhysician.setForeground(Color.BLACK);
		lblPickAPhysician.setBounds(10, 39, 106, 13);
		frmGeneratingPhysicianBased.getContentPane().add(lblPickAPhysician);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Physician #1", "Physician #2", "..."}));
		comboBox_5.setBounds(126, 36, 106, 19);
		frmGeneratingPhysicianBased.getContentPane().add(comboBox_5);
		
		JLabel lblSpecifyAPeriod = new JLabel("Specify a period of time:");
		lblSpecifyAPeriod.setForeground(Color.BLACK);
		lblSpecifyAPeriod.setBounds(10, 62, 248, 13);
		frmGeneratingPhysicianBased.getContentPane().add(lblSpecifyAPeriod);
		
		JLabel lblPickStartDate = new JLabel("Pick start date:");
		lblPickStartDate.setForeground(Color.DARK_GRAY);
		lblPickStartDate.setBounds(10, 80, 170, 20);
		frmGeneratingPhysicianBased.getContentPane().add(lblPickStartDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(10, 100, 81, 20);
		frmGeneratingPhysicianBased.getContentPane().add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(102, 100, 40, 21);
		frmGeneratingPhysicianBased.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinner_1.setBounds(152, 101, 50, 20);
		frmGeneratingPhysicianBased.getContentPane().add(spinner_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_3.setBounds(237, 100, 81, 20);
		frmGeneratingPhysicianBased.getContentPane().add(comboBox_3);
		
		JLabel lblPickEndDate = new JLabel("Pick end date:");
		lblPickEndDate.setForeground(Color.DARK_GRAY);
		lblPickEndDate.setBounds(237, 80, 170, 20);
		frmGeneratingPhysicianBased.getContentPane().add(lblPickEndDate);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_3.setBounds(328, 100, 40, 21);
		frmGeneratingPhysicianBased.getContentPane().add(spinner_3);
		
		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinner_3_1.setBounds(378, 101, 50, 20);
		frmGeneratingPhysicianBased.getContentPane().add(spinner_3_1);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(278, 39, 148, 39);
		frmGeneratingPhysicianBased.getContentPane().add(btnGenerateReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 130, 436, 133);
		frmGeneratingPhysicianBased.getContentPane().add(scrollPane);
		
		JLabel lblPickAPhysician_2 = new JLabel("Pick a physician & a period of time, to display all of the ");
		lblPickAPhysician_2.setHorizontalAlignment(SwingConstants.LEADING);
		lblPickAPhysician_2.setForeground(Color.BLACK);
		lblPickAPhysician_2.setBounds(0, 0, 428, 13);
		frmGeneratingPhysicianBased.getContentPane().add(lblPickAPhysician_2);
		
		JLabel lblPickAPhysician_2_1 = new JLabel("prescriptions ordered by that physician during that period.");
		lblPickAPhysician_2_1.setHorizontalAlignment(SwingConstants.LEADING);
		lblPickAPhysician_2_1.setForeground(Color.BLACK);
		lblPickAPhysician_2_1.setBounds(0, 13, 428, 13);
		frmGeneratingPhysicianBased.getContentPane().add(lblPickAPhysician_2_1);
	}

}
