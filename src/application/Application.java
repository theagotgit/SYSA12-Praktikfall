package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;


import controller.Controller;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.DateLabelFormatter;


import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;

public class Application {

	private JFrame frame;
	private JTextField textFieldRegisterInvoiceNumber;
	private JTextField textFieldFindInvoiceByInvoiceNumber;
	private JTextField textFieldNewSupplierName;
	private JTextField textFieldNewSupplierFax;
	private JTextField textFieldNewSupplierNumber;
	private JTextField textFieldNewSupplierSite;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private Controller controller;

	private JTable tableReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controller = new Controller();
		frame = new JFrame();
		frame.setBounds(100, 100, 879, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 847, 539);
		frame.getContentPane().add(tabbedPane);

		JPanel panelStart = new JPanel();
		tabbedPane.addTab("Start", null, panelStart, null);
		panelStart.setLayout(null);

		JPanel panelInvoice = new JPanel();
		tabbedPane.addTab("Faktura", null, panelInvoice, null);
		panelInvoice.setLayout(null);

		JTabbedPane tabbedPaneInsideInvoice = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneInsideInvoice.setBounds(10, 11, 822, 489);
		panelInvoice.add(tabbedPaneInsideInvoice);

		JPanel panelNewInvoice = new JPanel();
		tabbedPaneInsideInvoice.addTab("Ny Faktura", null, panelNewInvoice, null);
		panelNewInvoice.setLayout(null);

		UtilDateModel dateModel = new UtilDateModel();
		DateLabelFormatter dateLabelFormatter = new DateLabelFormatter();
		Properties p = new Properties();
		p.put("text.today", "Idag");
		p.put("text.month", "MÃ¥nad");
		p.put("text.year", "Ã…r");

		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);

		JDatePickerImpl datePickerReceived = new JDatePickerImpl(datePanel, dateLabelFormatter);
		datePickerReceived.setBounds(107, 76, 202, 29);
		panelNewInvoice.add(datePickerReceived);

		JDatePickerImpl datePickerPrinted = new JDatePickerImpl(datePanel, dateLabelFormatter);
		datePickerPrinted.setBounds(107, 36, 202, 29);
		panelNewInvoice.add(datePickerPrinted);

		JDatePickerImpl datePickerExpiryDate = new JDatePickerImpl(datePanel, dateLabelFormatter);
		datePickerExpiryDate.setBounds(107, 116, 202, 29);
		panelNewInvoice.add(datePickerExpiryDate);

		JDatePickerImpl datePickerDelivery = new JDatePickerImpl(datePanel, dateLabelFormatter);
		datePickerDelivery.setBounds(107, 156, 202, 29);
		panelNewInvoice.add(datePickerDelivery);

		JLabel lblRegisterAmount = new JLabel("Antal");
		lblRegisterAmount.setBounds(10, 342, 25, 14);
		panelNewInvoice.add(lblRegisterAmount);

		JLabel lblRegisterProduct = new JLabel("Vara");
		lblRegisterProduct.setBounds(10, 317, 87, 14);
		panelNewInvoice.add(lblRegisterProduct);

		JLabel lblRegisterInvoiceCopy = new JLabel("Bifoga kopia");

		lblRegisterInvoiceCopy.setBounds(10, 223, 87, 14);
		panelNewInvoice.add(lblRegisterInvoiceCopy);

		JLabel lblRegisterSupplier = new JLabel("Leverant\u00F6r");
		lblRegisterSupplier.setBounds(10, 198, 87, 14);

		panelNewInvoice.add(lblRegisterSupplier);

		JLabel lblRegisterPrintedDate = new JLabel("Utskriftsdatum");
		lblRegisterPrintedDate.setBounds(10, 36, 87, 14);
		panelNewInvoice.add(lblRegisterPrintedDate);

		JLabel lblRegisterInvoiceNumber = new JLabel("Fakturanummer");
		lblRegisterInvoiceNumber.setBounds(10, 11, 87, 14);
		panelNewInvoice.add(lblRegisterInvoiceNumber);

		textFieldRegisterInvoiceNumber = new JTextField();
		textFieldRegisterInvoiceNumber.setBounds(107, 8, 96, 20);
		panelNewInvoice.add(textFieldRegisterInvoiceNumber);
		textFieldRegisterInvoiceNumber.setColumns(10);

		JComboBox comboBoxRegisterNewInvoiceSupplier = new JComboBox();
		comboBoxRegisterNewInvoiceSupplier.setBounds(107, 196, 96, 18);
		panelNewInvoice.add(comboBoxRegisterNewInvoiceSupplier);

		JButton btnRegisterInvoiceChooseFile = new JButton("V\u00E4lj fil...");
		btnRegisterInvoiceChooseFile.setBounds(107, 221, 96, 19);
		panelNewInvoice.add(btnRegisterInvoiceChooseFile);

		JSpinner spinnerRegisterNewInvoiceAmount = new JSpinner();
		spinnerRegisterNewInvoiceAmount.setBounds(107, 339, 96, 20);
		panelNewInvoice.add(spinnerRegisterNewInvoiceAmount);

		JComboBox comboBoxRegisterInvoiceProduct = new JComboBox();
		comboBoxRegisterInvoiceProduct.setBounds(107, 315, 96, 18);
		panelNewInvoice.add(comboBoxRegisterInvoiceProduct);

		JLabel lblRegisterReceivedDate = new JLabel("Mottaget datum");

		lblRegisterReceivedDate.setBounds(10, 78, 87, 14);
		panelNewInvoice.add(lblRegisterReceivedDate);

		JLabel lblRegisterExpirationDate = new JLabel("F\u00F6rfallodatum");
		lblRegisterExpirationDate.setBounds(10, 119, 96, 14);

		panelNewInvoice.add(lblRegisterExpirationDate);

		JButton btnRegisterInvoice = new JButton("Registrera");
		btnRegisterInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRegisterInvoice.setBounds(10, 382, 193, 23);
		panelNewInvoice.add(btnRegisterInvoice);


		JLabel lblLeveransdatum = new JLabel("Leveransdatum");
		lblLeveransdatum.setBounds(10, 158, 87, 14);
		panelNewInvoice.add(lblLeveransdatum);

		JPanel panelSearchInvoice = new JPanel();
		tabbedPaneInsideInvoice.addTab("S\u00F6k Faktura", null, panelSearchInvoice, null);
		panelSearchInvoice.setLayout(null);

		JScrollPane scrollPaneFindInvoice = new JScrollPane();
		scrollPaneFindInvoice.setBounds(371, 5, 446, 456);
		panelSearchInvoice.add(scrollPaneFindInvoice);

		JTextArea textAreaSearchInvoice = new JTextArea();
		scrollPaneFindInvoice.setViewportView(textAreaSearchInvoice);

		JLabel lblFIndInvoiceNumber = new JLabel("Fakturanummer");
		lblFIndInvoiceNumber.setBounds(10, 9, 89, 14);
		panelSearchInvoice.add(lblFIndInvoiceNumber);

		JLabel lblFindInvoiceByCategory = new JLabel("Kategori");
		lblFindInvoiceByCategory.setBounds(10, 34, 48, 14);
		panelSearchInvoice.add(lblFindInvoiceByCategory);

		JComboBox comboBoxFindInvoiceByCategory = new JComboBox();
		comboBoxFindInvoiceByCategory.setBounds(108, 32, 96, 18);
		panelSearchInvoice.add(comboBoxFindInvoiceByCategory);

		textFieldFindInvoiceByInvoiceNumber = new JTextField();
		textFieldFindInvoiceByInvoiceNumber.setBounds(109, 6, 96, 20);
		panelSearchInvoice.add(textFieldFindInvoiceByInvoiceNumber);
		textFieldFindInvoiceByInvoiceNumber.setColumns(10);

		JButton btnFindInvoice = new JButton("Hitta Faktura");
		btnFindInvoice.setBounds(10, 59, 194, 23);
		panelSearchInvoice.add(btnFindInvoice);
		btnFindInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String invoiceNumber = textFieldFindInvoiceByInvoiceNumber.getText();
				String category = (String)comboBoxFindInvoiceByCategory.getSelectedItem();
				if (!invoiceNumber.equals("") && category == null) {
					if (controller.getInvoiceRegister().findInvoice(invoiceNumber) == null) {
						//Felmeddelande
					} else {
						String print = "Hittade faktura nummer " + invoiceNumber + "\nLadda ner fil...\nFörfallodatum: " + controller.getInvoiceRegister().findInvoice(invoiceNumber).getExpiryDate() + "\nSumma:" + controller.findSum(invoiceNumber) + " SEK";
						textAreaSearchInvoice.setText(print);
					}
				} else if (category != null && invoiceNumber.equals("")) {
					textAreaSearchInvoice.setText(controller.searchCategory(category));
				} else {
					//felmeddelande till anvï¿½ndaren
				}
			}
		});

		JPanel panelSupplier = new JPanel();
		tabbedPane.addTab("Leverant\u00F6rer", null, panelSupplier, null);
		panelSupplier.setLayout(null);

		JTabbedPane tabbedPaneInsideSuppliers = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneInsideSuppliers.setBounds(10, 11, 822, 489);
		panelSupplier.add(tabbedPaneInsideSuppliers);

		JPanel panelRegisterNewSupplier = new JPanel();
		tabbedPaneInsideSuppliers.addTab("Ny Leverant\u00F6r", null, panelRegisterNewSupplier, null);
		panelRegisterNewSupplier.setLayout(null);

		JLabel lblNewSupplierName = new JLabel("Namn");
		lblNewSupplierName.setBounds(10, 11, 48, 14);
		panelRegisterNewSupplier.add(lblNewSupplierName);

		JLabel lblNewSupplierFax = new JLabel("Faxnummer");
		lblNewSupplierFax.setBounds(10, 36, 77, 14);
		panelRegisterNewSupplier.add(lblNewSupplierFax);

		JLabel lblNewSupplierPhone = new JLabel("Telefonnummer");
		lblNewSupplierPhone.setBounds(10, 61, 88, 14);
		panelRegisterNewSupplier.add(lblNewSupplierPhone);

		JLabel lblNewSupplierSite = new JLabel("Webbadress");
		lblNewSupplierSite.setBounds(10, 86, 77, 14);
		panelRegisterNewSupplier.add(lblNewSupplierSite);

		textFieldNewSupplierName = new JTextField();
		textFieldNewSupplierName.setBounds(107, 8, 128, 20);
		panelRegisterNewSupplier.add(textFieldNewSupplierName);
		textFieldNewSupplierName.setColumns(10);

		textFieldNewSupplierFax = new JTextField();
		textFieldNewSupplierFax.setBounds(107, 33, 128, 20);
		panelRegisterNewSupplier.add(textFieldNewSupplierFax);
		textFieldNewSupplierFax.setColumns(10);

		textFieldNewSupplierNumber = new JTextField();
		textFieldNewSupplierNumber.setBounds(108, 58, 127, 20);
		panelRegisterNewSupplier.add(textFieldNewSupplierNumber);
		textFieldNewSupplierNumber.setColumns(10);

		textFieldNewSupplierSite = new JTextField();
		textFieldNewSupplierSite.setBounds(107, 83, 128, 20);
		panelRegisterNewSupplier.add(textFieldNewSupplierSite);
		textFieldNewSupplierSite.setColumns(10);

		JButton btnNewSupplier = new JButton("L\u00E4gg till leverant\u00F6r");
		btnNewSupplier.setBounds(10, 124, 227, 23);
		panelRegisterNewSupplier.add(btnNewSupplier);

		JPanel panelSearchSupplier = new JPanel();
		tabbedPaneInsideSuppliers.addTab("S\u00F6k Leverant\u00F6r", null, panelSearchSupplier, null);
		panelSearchSupplier.setLayout(null);

		JButton btnSortSupplier = new JButton("Sortera");
		btnSortSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSortSupplier.setBounds(10, 71, 80, 23);
		panelSearchSupplier.add(btnSortSupplier);

		JLabel lblSupplierChoice = new JLabel("eller");
		lblSupplierChoice.setBounds(100, 75, 48, 14);
		panelSearchSupplier.add(lblSupplierChoice);

		JButton btnSearchAllSuppliers = new JButton("Visa alla");
		btnSearchAllSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchAllSuppliers.setBounds(136, 71, 89, 23);
		panelSearchSupplier.add(btnSearchAllSuppliers);

		JLabel lblSearchSupplierByCategory = new JLabel("Kategori");
		lblSearchSupplierByCategory.setBounds(10, 11, 48, 14);
		panelSearchSupplier.add(lblSearchSupplierByCategory);

		JLabel lblSearchSupplierByProduct = new JLabel("Vara");
		lblSearchSupplierByProduct.setBounds(10, 36, 48, 14);
		panelSearchSupplier.add(lblSearchSupplierByProduct);

		JComboBox comboBoxSearchSupplierByProduct = new JComboBox();
		comboBoxSearchSupplierByProduct.setBounds(89, 34, 136, 18);
		panelSearchSupplier.add(comboBoxSearchSupplierByProduct);

		JComboBox comboBoxSearchSupplierByCategory = new JComboBox();
		comboBoxSearchSupplierByCategory.setBounds(89, 9, 136, 18);
		panelSearchSupplier.add(comboBoxSearchSupplierByCategory);

		JScrollPane scrollPaneSearchSuppliers = new JScrollPane();
		scrollPaneSearchSuppliers.setBounds(280, 11, 527, 439);
		panelSearchSupplier.add(scrollPaneSearchSuppliers);

		JTextArea textAreaSearchSuppliers = new JTextArea();
		scrollPaneSearchSuppliers.setViewportView(textAreaSearchSuppliers);

		JPanel panelCategory = new JPanel();
		tabbedPane.addTab("Kategorier och Varor", null, panelCategory, null);
		panelCategory.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 817, 461);
		panelCategory.add(panel);

		JLabel label_1 = new JLabel("Ny kategori: ");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 11, 79, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Namn");
		label_2.setBounds(10, 36, 48, 14);
		panel.add(label_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(78, 33, 96, 20);
		panel.add(textField);
		
		JLabel lblAddCategoryResponse = new JLabel("");
		lblAddCategoryResponse.setBounds(202, 65, 448, 14);
		panel.add(lblAddCategoryResponse);
		
		JLabel lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(10, 292, 280, 14);
		panel.add(lblErrorMessage);

		JButton button = new JButton("L\u00E4gg till kategori");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String categoryName = textField.getText();
				if (categoryName.equals("")) {
					lblErrorMessage.setText("Vänligen ange ett namn.");
					lblAddCategoryResponse.setText("");
				} else if (controller.getCategoryRegister().findCategory(categoryName) != null) {
					lblErrorMessage.setText("Kategorin " + categoryName + " finns redan.");
					lblAddCategoryResponse.setText("");
				} else {
					controller.addCategory(categoryName);
					lblAddCategoryResponse.setText("Kategori " + categoryName + " har nu lagts till.");
					lblErrorMessage.setText("");
				}
			}
		});
		button.setBounds(10, 61, 164, 23);
		panel.add(button);

		JLabel label_3 = new JLabel("Ny vara:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 120, 48, 14);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Namn");
		label_4.setBounds(10, 145, 48, 14);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Kategori");
		label_5.setBounds(10, 221, 48, 14);
		panel.add(label_5);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 219, 96, 18);
		panel.add(comboBox);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 142, 96, 20);
		panel.add(textField_1);

		JButton button_1 = new JButton("L\u00E4gg till vara");
		button_1.setBounds(10, 258, 164, 23);
		panel.add(button_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 167, 96, 20);
		panel.add(textField_2);

		JLabel label_6 = new JLabel("Varunummer");
		label_6.setBounds(10, 170, 79, 14);
		panel.add(label_6);

		JLabel label_7 = new JLabel("Leverant\u00F6r");
		label_7.setBounds(10, 196, 79, 14);
		panel.add(label_7);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(78, 195, 96, 18);
		panel.add(comboBox_1);
		
		

		JPanel panelReport = new JPanel();
		tabbedPane.addTab("Rapport", null, panelReport, null);
		panelReport.setLayout(null);

		JDatePickerImpl datePickerReportStartDate = new JDatePickerImpl(datePanel, dateLabelFormatter);
		datePickerReportStartDate.setBounds(92, 11, 202, 29);
		panelReport.add(datePickerReportStartDate);

		JDatePickerImpl datePickerReportEndDate = new JDatePickerImpl(datePanel, dateLabelFormatter);
		datePickerReportEndDate.setBounds(92, 51, 202, 29);
		panelReport.add(datePickerReportEndDate);

		JScrollPane scrollPaneReport = new JScrollPane();
		scrollPaneReport.setBounds(388, 11, 444, 489);
		panelReport.add(scrollPaneReport);

		tableReport = new JTable();
		scrollPaneReport.setViewportView(tableReport);

		JLabel lblReportChooseDate = new JLabel("V\u00E4lj datum");
		lblReportChooseDate.setBounds(10, 17, 72, 14);
		panelReport.add(lblReportChooseDate);

		JLabel lblReportDateTo = new JLabel("till");
		lblReportDateTo.setBounds(10, 62, 41, 14);
		panelReport.add(lblReportDateTo);

		JLabel lblReportCategory = new JLabel("Kategori");
		lblReportCategory.setBounds(10, 94, 48, 14);
		panelReport.add(lblReportCategory);

		JLabel lblReportSupplier = new JLabel("Leverant\u00F6r");
		lblReportSupplier.setBounds(10, 123, 72, 14);
		panelReport.add(lblReportSupplier);

		JComboBox comboBoxReportSupplier = new JComboBox();
		comboBoxReportSupplier.setBounds(92, 123, 105, 18);
		panelReport.add(comboBoxReportSupplier);

		JComboBox comboBoxReportCategory = new JComboBox();
		comboBoxReportCategory.setBounds(92, 91, 105, 19);
		panelReport.add(comboBoxReportCategory);

		JButton btnMakeReport = new JButton("Framst\u00E4ll rapport");
		btnMakeReport.setBounds(10, 173, 187, 23);
		panelReport.add(btnMakeReport);

		JLabel lblReportRequiredField = new JLabel("*Obligatoriskt f\u00E4lt");
		lblReportRequiredField.setForeground(Color.RED);
		lblReportRequiredField.setBounds(10, 207, 118, 14);
		panelReport.add(lblReportRequiredField);

		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(2, 17, 49, 14);
		panelReport.add(label);
	}
}
