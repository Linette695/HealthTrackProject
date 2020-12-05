import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class IB {

	private JFrame frmInsuranceBilling;
	private JTextField txtEnterPatientOr;
	
	/*GUI Variables*/
	private JButton btnSubmitBill;
	private JButton btnBackToDash;
	private JTextField textField;
	private JTabbedPane tabbedPane;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IB window = new IB();
					window.frmInsuranceBilling.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IB() {
		initialize();
	}
	
	
	
	
	/*METHODS*/
	/*NOTES: The index for each tab are  
	 *		Bill A Service  == 0
	 *		Available Services == 1
	 *		Generate Monthly Invoice == 2
	 *		Generate New Report == 3
	 *		
	 */

	//Method invoked when user wants to create a new bill
	public void IBNewBill() {
		frmInsuranceBilling.setVisible(true);					
		
		tabbedPane.setEnabledAt(0, true);			//Make sure the Bill A Service tab is enabled
		tabbedPane.setSelectedIndex(0);				//Make sure the Bill A Service tab is the one being displayed
		tabbedPane.setEnabledAt(1, false);			//Make sure the Available services tab is not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the Generate monthly invoice tab is  not enabled
		tabbedPane.setEnabledAt(3, false);			//Make sure the generate new report tab is not enabled
		
	}//end of IBNewBill

	//Method invoked when user wants to look at the information of available clinic services
	public void IBAvailableServices() {
		frmInsuranceBilling.setVisible(true);					
		
		tabbedPane.setEnabledAt(1, true);			//Make sure the Available Services tab is enabled
		tabbedPane.setSelectedIndex(1);				//Make sure the Available Services tab is the one being displayed
		tabbedPane.setEnabledAt(0, false);			//Make sure the Bill A Service tab is not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the Generate monthly invoice tab is  not enabled
		tabbedPane.setEnabledAt(3, false);			//Make sure the generate new report tab is not enabled
		
	}//end of IBAvailableServices

	//Method invoked when user wants to generate a new monthly invoice
	public void IBNewMonthlyInvoice() {
		frmInsuranceBilling.setVisible(true);					
		
		tabbedPane.setEnabledAt(2, true);			//Make sure the Generate monthly invoice tab is enabled
		tabbedPane.setSelectedIndex(2);				//Make sure the Generate monthly invoice tab is the one being displayed
		tabbedPane.setEnabledAt(0, false);			//Make sure the Bill A Service tab is not enabled
		tabbedPane.setEnabledAt(1, false);			//Make sure the Available Services tab is  not enabled
		tabbedPane.setEnabledAt(3, false);			//Make sure the generate new report tab is not enabled
		
	}//end of IBNewMonthlyInvoice

	//Method invoked when user wants to generate a new report
	public void IBGenerateNewReport() {
		frmInsuranceBilling.setVisible(true);					
		
		tabbedPane.setEnabledAt(3, true);			//Make sure the Generate new report tab is enabled
		tabbedPane.setSelectedIndex(3);				//Make sure the Generate new report tab is the one being displayed
		tabbedPane.setEnabledAt(0, false);			//Make sure the Bill A Service tab is not enabled
		tabbedPane.setEnabledAt(1, false);			//Make sure the Available Services tab is  not enabled
		tabbedPane.setEnabledAt(2, false);			//Make sure the Generate monthly invoice tab is not enabled
		
	}//end of IBGenerateNewReport
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInsuranceBilling = new JFrame();
		frmInsuranceBilling.setTitle("Insurance Billing");
		frmInsuranceBilling.setBounds(100, 100, 464, 330);
		frmInsuranceBilling.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInsuranceBilling.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 450, 283);
		frmInsuranceBilling.getContentPane().add(tabbedPane);
		
		JPanel BillAServicePanel = new JPanel();
		tabbedPane.addTab("Bill A Service", null, BillAServicePanel, null);
		BillAServicePanel.setLayout(null);
		
		JLabel lblSelectTheType = new JLabel("Select the type of transaction:");
		lblSelectTheType.setBounds(10, 10, 156, 13);
		BillAServicePanel.add(lblSelectTheType);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Patient Bill", "Insurance Carrier Bill"}));
		comboBox_5.setBounds(176, 10, 131, 19);
		BillAServicePanel.add(comboBox_5);
		
		JLabel lblIdOfWho = new JLabel("ID of who is being charged:  ");
		lblIdOfWho.setHorizontalAlignment(SwingConstants.LEADING);
		lblIdOfWho.setForeground(Color.BLACK);
		lblIdOfWho.setBounds(10, 36, 172, 13);
		BillAServicePanel.add(lblIdOfWho);
		
		txtEnterPatientOr = new JTextField();
		txtEnterPatientOr.setText("Enter patient or insurance ID");
		txtEnterPatientOr.setBounds(186, 33, 199, 19);
		BillAServicePanel.add(txtEnterPatientOr);
		txtEnterPatientOr.setColumns(10);
		
		JLabel lblServiceId = new JLabel("Service being charged:");
		lblServiceId.setBounds(10, 62, 156, 13);
		BillAServicePanel.add(lblServiceId);
		
		JComboBox comboBox_5_1 = new JComboBox();
		comboBox_5_1.setModel(new DefaultComboBoxModel(new String[] {"Patient Appointment", "Lab Work", "Prescription"}));
		comboBox_5_1.setBounds(163, 59, 144, 19);
		BillAServicePanel.add(comboBox_5_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 112, 300, 114);
		BillAServicePanel.add(scrollPane);
		
		JButton btnReviewTransaction = new JButton("Review Transaction");
		btnReviewTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSubmitBill.setVisible(true);
			}
		});
		btnReviewTransaction.setBounds(116, 91, 191, 21);
		BillAServicePanel.add(btnReviewTransaction);
		
		btnSubmitBill = new JButton("Submit Bill");
		btnSubmitBill.setVisible(false);
		btnSubmitBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSubmitBill.setVisible(false);
				btnBackToDash.setVisible(true);
			}
		});
		btnSubmitBill.setBounds(331, 205, 100, 21);
		BillAServicePanel.add(btnSubmitBill);
		
	    btnBackToDash = new JButton("Back To DASH");
	    btnBackToDash.setVisible(false);
	    btnBackToDash.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		frmInsuranceBilling.setVisible(false);
	    		
	    	}
	    });
		btnBackToDash.setBounds(310, 158, 121, 21);
		BillAServicePanel.add(btnBackToDash);
		
		JPanel AvailableServicesPanel = new JPanel();
		tabbedPane.addTab("Available Services", null, AvailableServicesPanel, null);
		AvailableServicesPanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 0, 425, 180);
		AvailableServicesPanel.add(scrollPane_1);
		
		JButton btnRefresh = new JButton("Refresh List");
		btnRefresh.setBounds(112, 184, 200, 21);
		AvailableServicesPanel.add(btnRefresh);
		
		JPanel GenerateMonthlyInvoicePanel = new JPanel();
		tabbedPane.addTab("Generate Monthly Invoice", null, GenerateMonthlyInvoicePanel, null);
		GenerateMonthlyInvoicePanel.setLayout(null);
		
		JLabel lblWhoIsThe = new JLabel("Who is the invoice for? ");
		lblWhoIsThe.setBounds(10, 10, 156, 13);
		GenerateMonthlyInvoicePanel.add(lblWhoIsThe);
		
		JComboBox comboBox_5_2 = new JComboBox();
		comboBox_5_2.setModel(new DefaultComboBoxModel(new String[] {"Patient", "Insurance Carrier"}));
		comboBox_5_2.setBounds(176, 10, 131, 19);
		GenerateMonthlyInvoicePanel.add(comboBox_5_2);
		
		JLabel lblIdOfWho_1 = new JLabel("ID of who is being charged:  ");
		lblIdOfWho_1.setHorizontalAlignment(SwingConstants.LEADING);
		lblIdOfWho_1.setForeground(Color.BLACK);
		lblIdOfWho_1.setBounds(10, 36, 172, 13);
		GenerateMonthlyInvoicePanel.add(lblIdOfWho_1);
		
		textField = new JTextField();
		textField.setText("Enter patient or insurance ID");
		textField.setColumns(10);
		textField.setBounds(186, 33, 199, 19);
		GenerateMonthlyInvoicePanel.add(textField);
		
		JLabel lblNewLabel_10 = new JLabel("Enter the month for the invoice:");
		lblNewLabel_10.setBounds(10, 59, 199, 13);
		GenerateMonthlyInvoicePanel.add(lblNewLabel_10);
		
		JComboBox cbMonthIn = new JComboBox();
		cbMonthIn.setModel(new DefaultComboBoxModel(new String[] {"Jauary", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonthIn.setBounds(36, 72, 70, 21);
		GenerateMonthlyInvoicePanel.add(cbMonthIn);
		
		JSpinner spinnerYearIn = new JSpinner();
		spinnerYearIn.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinnerYearIn.setBounds(116, 73, 50, 20);
		GenerateMonthlyInvoicePanel.add(spinnerYearIn);
		
		JButton btnGenerateInvoice = new JButton("Generate Invoice");
		btnGenerateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateInvoice.setBounds(98, 103, 240, 21);
		GenerateMonthlyInvoicePanel.add(btnGenerateInvoice);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setToolTipText("");
		scrollPane_2.setBounds(0, 134, 435, 135);
		GenerateMonthlyInvoicePanel.add(scrollPane_2);
		
		JLabel lblNewLabel_10_1 = new JLabel("Enter today's date:");
		lblNewLabel_10_1.setBounds(219, 59, 119, 13);
		GenerateMonthlyInvoicePanel.add(lblNewLabel_10_1);
		
		JComboBox cbMonthIn_1 = new JComboBox();
		cbMonthIn_1.setModel(new DefaultComboBoxModel(new String[] {"Jauary", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonthIn_1.setBounds(242, 72, 70, 21);
		GenerateMonthlyInvoicePanel.add(cbMonthIn_1);
		
		JSpinner spinnerYearIn_1 = new JSpinner();
		spinnerYearIn_1.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerYearIn_1.setBounds(322, 73, 40, 20);
		GenerateMonthlyInvoicePanel.add(spinnerYearIn_1);
		
		JSpinner spinnerDayIn = new JSpinner();
		spinnerDayIn.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinnerDayIn.setBounds(372, 73, 48, 20);
		GenerateMonthlyInvoicePanel.add(spinnerDayIn);
		
		JPanel GenerateNewReportPanel = new JPanel();
		tabbedPane.addTab("Generate New Report", null, GenerateNewReportPanel, null);
		GenerateNewReportPanel.setLayout(null);
		
		JButton btnCrearteANew = new JButton("Crearte A New Report For A Specific Patient");
		btnCrearteANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IB_PatientBasedReport newPatientReport = new IB_PatientBasedReport();
			}
		});
		btnCrearteANew.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearteANew.setBounds(0, 10, 381, 21);
		GenerateNewReportPanel.add(btnCrearteANew);
		
		JButton btnCreateANew = new JButton("Create A New Report For A Specific Insurance Carrier");
		btnCreateANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IB_InsuranceCarrierReport newInsuranceReport = new IB_InsuranceCarrierReport();
			}
		});
		btnCreateANew.setHorizontalAlignment(SwingConstants.LEADING);
		btnCreateANew.setBounds(0, 41, 381, 21);
		GenerateNewReportPanel.add(btnCreateANew);
	}

}
