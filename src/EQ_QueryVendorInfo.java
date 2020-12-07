import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class EQ_QueryVendorInfo {

	private JFrame frmVendorListInformation;
	private JTextField txtEnterId;
	private JTextField txtEnterVendorName;
	
	/*GUI Variables*/
	private JTabbedPane tabbedPane;
	private JTextField txtEnterName;
	private JTextField txtEnterAddress;
	private JTextField txtEnterTheTypes;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EQ_QueryVendorInfo window = new EQ_QueryVendorInfo();
					window.frmVendorListInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EQ_QueryVendorInfo() {
		initialize();
		
	}
	
	
	
	/*METHODS*/
	/*NOTES: The index for each tab are  
	 *		Query Vendor Info == 0
	 *		Add new vendor == 1
	 *		
	 */

	//Method invoked when user wants to query the vendor list information
	public void eqQueryVendorList() {
		frmVendorListInformation.setVisible(true);					
		
		tabbedPane.setEnabledAt(0, true);			//Make sure the query vendor info tab is enabled
		tabbedPane.setSelectedIndex(0);				//Make sure the query vendor info tab is the one being displayed
		//tabbedPane.setEnabledAt(1, false);			//Make sure the add new vendor tab is not enabled
		
	}//end of eqQueryVendorList
	
	//Method invoked when user wants to add a new vendor
	public void eqNewVendor() {
		frmVendorListInformation.setVisible(true);					
		
		tabbedPane.setEnabledAt(1, true);			//Make sure the new vendor tab is enabled
		tabbedPane.setSelectedIndex(1);				//Make sure the new vendor tab is the one being displayed
		//tabbedPane.setEnabledAt(0, false);			//Make sure the query vendor info tab is not enabled
		
	}//end of eqNewVendor

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVendorListInformation = new JFrame();
		frmVendorListInformation.setTitle("Vendor List Information");
		frmVendorListInformation.setBounds(100, 100, 477, 336);
		frmVendorListInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVendorListInformation.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 463, 299);
		frmVendorListInformation.getContentPane().add(tabbedPane);
		
		JPanel QueryVendorInfoPanel = new JPanel();
		tabbedPane.addTab("Query Vendor List Information\r\n", null, QueryVendorInfoPanel, null);
		QueryVendorInfoPanel.setLayout(null);
		
		JLabel lblVendorId = new JLabel("Vendor ID:");
		lblVendorId.setBounds(29, 28, 69, 13);
		QueryVendorInfoPanel.add(lblVendorId);
		
		txtEnterId = new JTextField();
		txtEnterId.setBounds(102, 25, 96, 19);
		QueryVendorInfoPanel.add(txtEnterId);
		txtEnterId.setText("Enter ID #\r\n");
		txtEnterId.setColumns(10);
		
		JLabel lblPatientId_1 = new JLabel("Vendor name:");
		lblPatientId_1.setBounds(29, 54, 84, 13);
		QueryVendorInfoPanel.add(lblPatientId_1);
		
		txtEnterVendorName = new JTextField();
		txtEnterVendorName.setBounds(115, 51, 133, 19);
		QueryVendorInfoPanel.add(txtEnterVendorName);
		txtEnterVendorName.setText("Enter Vendor's Name\r\n");
		txtEnterVendorName.setColumns(10);
		
		JLabel lblPatientId_1_1 = new JLabel("Equitpment type:");
		lblPatientId_1_1.setBounds(256, 28, 119, 13);
		QueryVendorInfoPanel.add(lblPatientId_1_1);
		lblPatientId_1_1.setForeground(Color.DARK_GRAY);
		
		JComboBox comboBox_5_2 = new JComboBox();
		comboBox_5_2.setBounds(290, 48, 139, 19);
		QueryVendorInfoPanel.add(comboBox_5_2);
		comboBox_5_2.setModel(new DefaultComboBoxModel(new String[] {"Equipment type #1", "Equipment type #2", ".."}));
		
		JLabel lblSpecifyTheFollowing = new JLabel("Specify the following information to query the vendor list information.");
		lblSpecifyTheFollowing.setBounds(10, 10, 438, 13);
		QueryVendorInfoPanel.add(lblSpecifyTheFollowing);
		
		JButton btnQueryVendorInformation = new JButton("Query Vendor Information");
		btnQueryVendorInformation.setBounds(124, 89, 228, 23);
		QueryVendorInfoPanel.add(btnQueryVendorInformation);
		btnQueryVendorInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 438, 140);
		QueryVendorInfoPanel.add(scrollPane);
		
		JPanel AddNewVendorPanel = new JPanel();
		tabbedPane.addTab("Add New Vendor ", null, AddNewVendorPanel, null);
		AddNewVendorPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("You are now creating a new vendor, please enter their information below.");
		lblNewLabel_1.setBounds(10, 10, 448, 13);
		AddNewVendorPanel.add(lblNewLabel_1);
		
		JLabel lblEnterVendorsName = new JLabel("Enter vendor's name:");
		lblEnterVendorsName.setBounds(21, 31, 141, 13);
		AddNewVendorPanel.add(lblEnterVendorsName);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("Enter name");
		txtEnterName.setColumns(10);
		txtEnterName.setBounds(163, 28, 114, 19);
		AddNewVendorPanel.add(txtEnterName);
		
		JLabel lblEnterVendorsAddress = new JLabel("Enter vendor's address:");
		lblEnterVendorsAddress.setBounds(21, 57, 160, 13);
		AddNewVendorPanel.add(lblEnterVendorsAddress);
		
		txtEnterAddress = new JTextField();
		txtEnterAddress.setText("Enter address");
		txtEnterAddress.setColumns(10);
		txtEnterAddress.setBounds(177, 54, 271, 19);
		AddNewVendorPanel.add(txtEnterAddress);
		
		JLabel lblTypesOfEquipment = new JLabel("Type(s) of equipment they provide:");
		lblTypesOfEquipment.setBounds(21, 81, 328, 13);
		AddNewVendorPanel.add(lblTypesOfEquipment);
		
		txtEnterTheTypes = new JTextField();
		txtEnterTheTypes.setText("Enter the type(s) of equipment they provide (seperated by a comma)");
		txtEnterTheTypes.setColumns(10);
		txtEnterTheTypes.setBounds(55, 104, 373, 19);
		AddNewVendorPanel.add(txtEnterTheTypes);
		
		JLabel lblSelectOne = new JLabel("Type of vendor to the clinic:");
		lblSelectOne.setBounds(21, 132, 211, 13);
		AddNewVendorPanel.add(lblSelectOne);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Preferred Vendor", "Not Preferred Vendor"}));
		comboBox_3.setBounds(123, 155, 167, 20);
		AddNewVendorPanel.add(comboBox_3);
		
		JButton btnSubmitNewVendor = new JButton("Submit New Vendor");
		btnSubmitNewVendor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubmitNewVendor.setBounds(99, 194, 250, 21);
		AddNewVendorPanel.add(btnSubmitNewVendor);
	}

}
