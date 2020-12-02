import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LT {

	private JFrame frmLabOrderTracking;
	private JTextField txtEnterId;
	private JTextField txtEnterId_1;
	private JTextField txtEnterId_2;
	
	
	/*GUI Variables*/
	JTabbedPane tabbedPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LT window = new LT();
					window.frmLabOrderTracking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LT() {
		initialize();
	} //end of constructor
	
	
	/*METHODS*/
	/*NOTES: The index for each tab are  
	 *		New Lab Order tab   == 0
	 *		Update A Lab Oder tab == 1
	 *		Create New Report  == 2
	 *		Available Lab Tests == 3
	 *		
	 */

	//Method invoked when user wants to create a new report
	public void LTcreateNewReport() {
		frmLabOrderTracking.setVisible(true);					
		
		tabbedPane.setEnabledAt(2, true);			//Make sure the create new report tab is enabled
		tabbedPane.setSelectedIndex(2);				//Make sure the create new report tab is the one being displayed
		tabbedPane.setEnabledAt(0, false);			//Make sure the new lab order tab is not enabled
		tabbedPane.setEnabledAt(1, false);			//Make sure the update a lab order tab is not enabled
		tabbedPane.setEnabledAt(3, false);			//Make sure the available lab tests list tab is not visible
	}//end of LTcreateNewReport
	
	//Method invoked when user wants to update a lab order
	public void LTupdateAOrder() {
		frmLabOrderTracking.setVisible(true);					
		
		tabbedPane.setEnabledAt(1, true);			//Make sure the update a lab order tab is enabled
		tabbedPane.setSelectedIndex(1);				//Make sure the update a lab order is the one being displayed
		tabbedPane.setEnabledAt(0, false);			//Make sure the new lab order tab is not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the create new report tab is not enabled
		tabbedPane.setEnabledAt(3, false);			//Make sure the available lab tests list tab is not visible
	}//end of LTupdateAOrder
	
	//Method invoked when user wants to request a new lab order
	public void LTRequestNewOrder() {
		frmLabOrderTracking.setVisible(true);					
		
		tabbedPane.setEnabledAt(0, true);			//Make sure the request new lab order tab is enabled
		tabbedPane.setSelectedIndex(0);				//Make sure the request new lab order is the one being displayed
		tabbedPane.setEnabledAt(1, false);			//Make sure the update new lab tab is not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the create new report tab is not enabled
		tabbedPane.setEnabledAt(3, true);			//Make sure the available lab tests list tab is visible
	}//end of LTRequestNewOrder	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLabOrderTracking = new JFrame();
		frmLabOrderTracking.setTitle("Lab Order Tracking");
		frmLabOrderTracking.setBounds(100, 100, 450, 300);
		frmLabOrderTracking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLabOrderTracking.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 10, 426, 253);
		frmLabOrderTracking.getContentPane().add(tabbedPane);
		
		JPanel CreateNewLabOrderPanel = new JPanel();
		tabbedPane.addTab("New Lab Order", null, CreateNewLabOrderPanel, null);
		CreateNewLabOrderPanel.setLayout(null);
		
		JLabel lblEneterPhysicianId = new JLabel("Eneter physician ID:");
		lblEneterPhysicianId.setBounds(10, 10, 119, 13);
		CreateNewLabOrderPanel.add(lblEneterPhysicianId);
		
		txtEnterId = new JTextField();
		txtEnterId.setText("Enter ID #");
		txtEnterId.setBounds(139, 7, 96, 19);
		CreateNewLabOrderPanel.add(txtEnterId);
		txtEnterId.setColumns(10);
		
		JLabel lblEnterPatientId = new JLabel("Enter patient ID: ");
		lblEnterPatientId.setBounds(10, 33, 108, 13);
		CreateNewLabOrderPanel.add(lblEnterPatientId);
		
		txtEnterId_1 = new JTextField();
		txtEnterId_1.setText("Enter ID #");
		txtEnterId_1.setBounds(139, 30, 96, 19);
		CreateNewLabOrderPanel.add(txtEnterId_1);
		txtEnterId_1.setColumns(10);
		
		JLabel lblEnterTheId = new JLabel("Enter the ID of the lab test to be done: ");
		lblEnterTheId.setBounds(10, 58, 225, 13);
		CreateNewLabOrderPanel.add(lblEnterTheId);
		
		txtEnterId_2 = new JTextField();
		txtEnterId_2.setText("Enter ID #");
		txtEnterId_2.setBounds(245, 55, 96, 19);
		CreateNewLabOrderPanel.add(txtEnterId_2);
		txtEnterId_2.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Enter today's date:");
		lblNewLabel_10.setBounds(10, 81, 119, 13);
		CreateNewLabOrderPanel.add(lblNewLabel_10);
		
		JSpinner spinnerYearIn = new JSpinner();
		spinnerYearIn.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerYearIn.setBounds(90, 104, 50, 20);
		CreateNewLabOrderPanel.add(spinnerYearIn);
		
		JComboBox cbMonthIn = new JComboBox();
		cbMonthIn.setModel(new DefaultComboBoxModel(new String[] {"Jauary", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonthIn.setBounds(10, 103, 70, 21);
		CreateNewLabOrderPanel.add(cbMonthIn);
		
		JSpinner spinnerDayIn = new JSpinner();
		spinnerDayIn.setBounds(148, 104, 40, 20);
		CreateNewLabOrderPanel.add(spinnerDayIn);
		
		JButton btnRequestNewOrder = new JButton("Request New Order");
		btnRequestNewOrder.setBounds(139, 178, 154, 21);
		CreateNewLabOrderPanel.add(btnRequestNewOrder);
		
		JPanel UpdateLabOrderpanel = new JPanel();
		tabbedPane.addTab("Update A Lab Order", null, UpdateLabOrderpanel, null);
		UpdateLabOrderpanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 347, 171);
		UpdateLabOrderpanel.add(scrollPane);
		
		JButton btnSelectOrder = new JButton("Select Order");
		btnSelectOrder.setBounds(0, 182, 132, 21);
		UpdateLabOrderpanel.add(btnSelectOrder);
		
		JPanel GenerateReportPanel = new JPanel();
		tabbedPane.addTab("Create New Report", null, GenerateReportPanel, null);
		GenerateReportPanel.setLayout(null);
		
		JButton btnReportForA = new JButton("Create A New Report For A Specific Patient");
		btnReportForA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LT_SpecificPatientReport newPatientReport = new LT_SpecificPatientReport();
			}
		});
		btnReportForA.setHorizontalAlignment(SwingConstants.LEFT);
		btnReportForA.setBounds(10, 10, 346, 21);
		GenerateReportPanel.add(btnReportForA);
		
		JButton btnNewButton = new JButton("Create A New Report Based On A Specified Physician");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LT_PhysicianSpecificReport newPhysicianBasedReport = new LT_PhysicianSpecificReport();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(10, 41, 346, 21);
		GenerateReportPanel.add(btnNewButton);
		
		JPanel AvailableLabsListPanel = new JPanel();
		AvailableLabsListPanel.setLayout(null);
		tabbedPane.addTab("Available Lab Tests", null, AvailableLabsListPanel, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 380, 180);
		AvailableLabsListPanel.add(scrollPane_1);
		
		JButton btnDeletePatient = new JButton("Delete patient");
		btnDeletePatient.setBounds(20, 250, 200, 21);
		AvailableLabsListPanel.add(btnDeletePatient);
		
		JButton btnRefresh = new JButton("Refresh List");
		btnRefresh.setBounds(10, 190, 200, 21);
		AvailableLabsListPanel.add(btnRefresh);
	}
}
