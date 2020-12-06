import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EQ_DefectiveEquipmentReport {

	private JFrame frmDefectiveEquipmentReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EQ_DefectiveEquipmentReport window = new EQ_DefectiveEquipmentReport();
					window.frmDefectiveEquipmentReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EQ_DefectiveEquipmentReport() {
		initialize();
		frmDefectiveEquipmentReport.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDefectiveEquipmentReport = new JFrame();
		frmDefectiveEquipmentReport.setTitle("Defective Equipment Report");
		frmDefectiveEquipmentReport.setBounds(100, 100, 450, 300);
		frmDefectiveEquipmentReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDefectiveEquipmentReport.getContentPane().setLayout(null);
		
		JLabel lblTheFollowingAre = new JLabel("The following are all the defective equipments in the clinic:");
		lblTheFollowingAre.setBounds(10, 10, 416, 13);
		frmDefectiveEquipmentReport.getContentPane().add(lblTheFollowingAre);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setToolTipText("");
		scrollPane_2.setBounds(10, 43, 416, 190);
		frmDefectiveEquipmentReport.getContentPane().add(scrollPane_2);
		
		JLabel lblAllListedEquipment = new JLabel("( All listed equipment has a problem status of \"open\" )");
		lblAllListedEquipment.setForeground(Color.GRAY);
		lblAllListedEquipment.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAllListedEquipment.setBounds(20, 22, 261, 13);
		frmDefectiveEquipmentReport.getContentPane().add(lblAllListedEquipment);
		
		JButton btnCloseReport = new JButton("Close Report");
		btnCloseReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDefectiveEquipmentReport.dispose();
			}
		});
		btnCloseReport.setBounds(163, 232, 118, 21);
		frmDefectiveEquipmentReport.getContentPane().add(btnCloseReport);
	}

}
