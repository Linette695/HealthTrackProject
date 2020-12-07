import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class LT_UrgentMessageToPhysician {

	private JFrame frmSendingAnUrgent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LT_UrgentMessageToPhysician window = new LT_UrgentMessageToPhysician();
					window.frmSendingAnUrgent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LT_UrgentMessageToPhysician() {
		initialize();
		frmSendingAnUrgent.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSendingAnUrgent = new JFrame();
		frmSendingAnUrgent.setTitle("Sending An Urgent Message To Physician");
		frmSendingAnUrgent.setBounds(100, 100, 450, 300);
		frmSendingAnUrgent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSendingAnUrgent.getContentPane().setLayout(null);
		
		JLabel lblPlease = new JLabel("The physician specified will be sent the lab result that have been updated.\r\n");
		lblPlease.setBounds(0, 0, 436, 13);
		frmSendingAnUrgent.getContentPane().add(lblPlease);
		
		JLabel lblPleaseEnterAny = new JLabel("Please enter any further information or comments to be sent with the");
		lblPleaseEnterAny.setBounds(0, 10, 436, 13);
		frmSendingAnUrgent.getContentPane().add(lblPleaseEnterAny);
		
		JLabel lblImmediateAttentionMessage = new JLabel("urgent message.");
		lblImmediateAttentionMessage.setBounds(0, 23, 416, 13);
		frmSendingAnUrgent.getContentPane().add(lblImmediateAttentionMessage);
		
		JTextArea txtrEnterMessage = new JTextArea();
		txtrEnterMessage.setText("Enter Message");
		txtrEnterMessage.setBounds(56, 63, 331, 81);
		frmSendingAnUrgent.getContentPane().add(txtrEnterMessage);
		
		JLabel lblEnterMessageFor = new JLabel("Enter Message For Physician:");
		lblEnterMessageFor.setForeground(Color.DARK_GRAY);
		lblEnterMessageFor.setBounds(10, 50, 197, 13);
		frmSendingAnUrgent.getContentPane().add(lblEnterMessageFor);
		
		JButton btnSendUrgentMessage = new JButton("Send Urgent Message");
		btnSendUrgentMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSendUrgentMessage.setBounds(133, 181, 160, 21);
		frmSendingAnUrgent.getContentPane().add(btnSendUrgentMessage);
	}

}
