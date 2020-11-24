import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;

public class SCHED_WeeklyReport {

	private JFrame frmGeneratingWeeklyReport;
	private SpringLayout springLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SCHED_WeeklyReport window = new SCHED_WeeklyReport();
					window.frmGeneratingWeeklyReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SCHED_WeeklyReport() {
		initialize();
		frmGeneratingWeeklyReport.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratingWeeklyReport = new JFrame();
		frmGeneratingWeeklyReport.setTitle("Generating Weekly Report");
		frmGeneratingWeeklyReport.setBounds(100, 100, 450, 300);
		frmGeneratingWeeklyReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGeneratingWeeklyReport.getContentPane().setLayout(null);
		
		JLabel lblSpecifyPhysician = new JLabel("Pick a Physician:");
		lblSpecifyPhysician.setBounds(10, 13, 106, 13);
		frmGeneratingWeeklyReport.getContentPane().add(lblSpecifyPhysician);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"All"}));
		comboBox_5.setBounds(135, 10, 88, 19);
		frmGeneratingWeeklyReport.getContentPane().add(comboBox_5);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(290, 34, 136, 21);
		frmGeneratingWeeklyReport.getContentPane().add(btnGenerateReport);
		
		JLabel lblNewLabel_10 = new JLabel("Week of :");
		lblNewLabel_10.setBounds(10, 36, 100, 17);
		frmGeneratingWeeklyReport.getContentPane().add(lblNewLabel_10);
		
		JSpinner spinnerYearIn = new JSpinner();
		spinnerYearIn.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerYearIn.setBounds(86, 55, 50, 20);
		frmGeneratingWeeklyReport.getContentPane().add(spinnerYearIn);
		
		JComboBox cbMonthIn = new JComboBox();
		cbMonthIn.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonthIn.setBounds(10, 55, 70, 21);
		frmGeneratingWeeklyReport.getContentPane().add(cbMonthIn);
		
		JSpinner spinnerDayIn = new JSpinner();
		spinnerDayIn.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2020), null, new Integer(1)));
		spinnerDayIn.setBounds(146, 55, 57, 20);
		frmGeneratingWeeklyReport.getContentPane().add(spinnerDayIn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 416, 175);
		frmGeneratingWeeklyReport.getContentPane().add(scrollPane);
		
		//TRYING TO USE JDatePicker
//		UtilDateModel model = new UtilDateModel();
//		Properties props = new Properties();
//		props.put("text.today", "Today");
//		props.put("text.month", "Month");
//		props.put("text.year", "Year");
//		JDatePanelImpl datePanel = new JDatePanelImpl(model,props);
//		
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
//		datePicker.setBounds(262, 40, 164, 58);
//		
//		frmGeneratingWeeklyReport.getContentPane().add(datePicker);
//		datePicker.add(datePicker.getJFormattedTextField());
//		
//		System.out.println(datePicker.getJFormattedTextField().getText());
	}

}
