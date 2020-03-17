package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.Controller;
import controller.DateLabelFormatter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Application {

	private JFrame frame;
	private JTextField textFieldRegisterInvoiceNumber;
	private JTextField textFieldFindInvoiceByInvoiceNumber;
	private JTextField textFieldNewSupplierName;
	private JTextField textFieldNewSupplierFax;
	private JTextField textFieldNewSupplierNumber;
	private JTextField textFieldNewSupplierSite;
	private JTextField textField;

	private JTextField textFieldProductName;
	private JTextField textFieldProductNumber;
	private JComboBox comboBoxRegisterNewInvoiceSupplier;
	private JComboBox comboBoxAddProductSupplier;
	private JComboBox comboBoxReportSupplier;
	private JComboBox comboBoxRegisterInvoiceProduct;
	private JComboBox comboBoxSearchSupplierByProduct;
	private JComboBox comboBoxFindInvoiceByCategory;
	private JComboBox comboBoxSearchSupplierByCategory;
	private JComboBox comboBoxAddProductCategory;
	private JComboBox comboBoxReportCategory;

	private Controller controller;

	private JTable tableReport;
	private JTable tableSearchSuppliers;
	
	public void updateComboBoxes(Controller controller) {
		ArrayList<DefaultComboBoxModel> comboBoxContent = controller.updateComboBoxes();
		/*	Supplier comboboxes: comboBoxRegisterNewInvoiceSupplier, comboBoxAddProductSupplier, comboBoxReportSupplier
		 * 	Product comboboxes: comboBoxRegisterInvoiceProduct, comboBoxSearchSupplierByProduct
		 * 	Category comboboxes: comboBoxFindInvoiceByCategory, comboBoxSearchSupplierByCategory, comboBoxAddProductCategory, comboBoxReportCategory
		 * */
		comboBoxRegisterNewInvoiceSupplier.setModel(comboBoxContent.get(0));
		comboBoxAddProductSupplier.setModel(comboBoxContent.get(0));
		comboBoxReportSupplier.setModel(comboBoxContent.get(0));
		comboBoxRegisterInvoiceProduct.setModel(comboBoxContent.get(1));
		comboBoxSearchSupplierByProduct.setModel(comboBoxContent.get(1));
		comboBoxFindInvoiceByCategory.setModel(comboBoxContent.get(2));
		comboBoxSearchSupplierByCategory.setModel(comboBoxContent.get(2));
		comboBoxAddProductCategory.setModel(comboBoxContent.get(2));
		comboBoxReportCategory.setModel(comboBoxContent.get(2));
	}


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
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setFont(new Font("Arial Black", Font.PLAIN, 11));
		frame.setBounds(100, 100, 879, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 165, 0));
		tabbedPane.setFont(new Font("Arial Black", Font.BOLD, 11));
		tabbedPane.setBounds(10, 11, 847, 539);
		frame.getContentPane().add(tabbedPane);

		JPanel panelStart = new JPanel();
		panelStart.setBorder(new LineBorder(new Color(255, 165, 0), 2));
		panelStart.setBackground(new Color(0, 0, 0));
		panelStart.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 11));
		tabbedPane.addTab("Start", null, panelStart, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane.setBackgroundAt(0, Color.ORANGE);
		panelStart.setLayout(null);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Users\\Vicky\\Downloads\\Copy of CompanyLogo.png"));
		label_8.setBounds(311, 161, 241, 165);
		panelStart.add(label_8);

		JPanel panelInvoice = new JPanel();
		panelInvoice.setBorder(new LineBorder(Color.ORANGE, 2));
		panelInvoice.setBackground(new Color(0, 0, 0));
		panelInvoice.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 11));
		tabbedPane.addTab("Faktura", null, panelInvoice, null);
		tabbedPane.setBackgroundAt(1, new Color(255, 165, 0));
		panelInvoice.setLayout(null);

		JTabbedPane tabbedPaneInsideInvoice = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneInsideInvoice.setBorder(null);
		tabbedPaneInsideInvoice.setOpaque(true);
		tabbedPaneInsideInvoice.setBackground(Color.BLACK);
		tabbedPaneInsideInvoice.setFont(new Font("Arial Black", Font.PLAIN, 11));
		tabbedPaneInsideInvoice.setBounds(10, 11, 822, 489);
		panelInvoice.add(tabbedPaneInsideInvoice);

		JPanel panelNewInvoice = new JPanel();
		panelNewInvoice.setForeground(new Color(255, 165, 0));
		panelNewInvoice.setBackground(new Color(0, 0, 0));
		panelNewInvoice.setBorder(new LineBorder(Color.ORANGE, 2));
		panelNewInvoice.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 11));
		tabbedPaneInsideInvoice.addTab("Ny Faktura", null, panelNewInvoice, null);
		tabbedPaneInsideInvoice.setForegroundAt(0, Color.BLACK);
		tabbedPaneInsideInvoice.setEnabledAt(0, true);
		tabbedPaneInsideInvoice.setBackgroundAt(0, Color.ORANGE);
		panelNewInvoice.setLayout(null);


		DateLabelFormatter dateLabelFormatter = new DateLabelFormatter();
		Properties p = new Properties();
		p.put("text.today", "Idag");
		p.put("text.month", "Månad");
		p.put("text.year", "År");

		UtilDateModel dateModelReceived = new UtilDateModel();
		JDatePanelImpl datePanelReceived = new JDatePanelImpl(dateModelReceived, p);
		JDatePickerImpl datePickerReceived = new JDatePickerImpl(datePanelReceived, dateLabelFormatter);
		datePickerReceived.setBounds(130, 101, 202, 29);
		panelNewInvoice.add(datePickerReceived);

		UtilDateModel dateModelPrinted = new UtilDateModel();
		JDatePanelImpl datePanelPrinted = new JDatePanelImpl(dateModelPrinted, p);
		JDatePickerImpl datePickerPrinted = new JDatePickerImpl(datePanelPrinted, dateLabelFormatter);
		datePickerPrinted.setBounds(130, 56, 202, 29);
		panelNewInvoice.add(datePickerPrinted);

		UtilDateModel dateModelExpiryDate = new UtilDateModel();
		JDatePanelImpl datePanelExpiryDate = new JDatePanelImpl(dateModelExpiryDate, p);
		JDatePickerImpl datePickerExpiryDate = new JDatePickerImpl(datePanelExpiryDate, dateLabelFormatter);
		datePickerExpiryDate.setBounds(130, 141, 202, 29);
		panelNewInvoice.add(datePickerExpiryDate);

		UtilDateModel dateModelDelivery = new UtilDateModel();
		JDatePanelImpl datePanelDelivery = new JDatePanelImpl(dateModelDelivery, p);
		JDatePickerImpl datePickerDelivery = new JDatePickerImpl(datePanelDelivery, dateLabelFormatter);
		datePickerDelivery.setBounds(130, 181, 202, 29);

		panelNewInvoice.add(datePickerDelivery);

		JLabel lblRegisterAmount = new JLabel("Antal");
		lblRegisterAmount.setForeground(Color.WHITE);
		lblRegisterAmount.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblRegisterAmount.setBounds(10, 342, 59, 14);
		panelNewInvoice.add(lblRegisterAmount);

		JLabel lblRegisterProduct = new JLabel("Vara");
		lblRegisterProduct.setForeground(Color.WHITE);
		lblRegisterProduct.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblRegisterProduct.setBounds(10, 317, 87, 14);
		panelNewInvoice.add(lblRegisterProduct);

		JLabel lblRegisterInvoiceCopy = new JLabel("Bifoga kopia");

		lblRegisterInvoiceCopy.setForeground(Color.WHITE);
		lblRegisterInvoiceCopy.setFont(new Font("Arial Black", Font.PLAIN, 12));

		lblRegisterInvoiceCopy.setBounds(10, 252, 87, 14);
		panelNewInvoice.add(lblRegisterInvoiceCopy);

		JLabel lblRegisterSupplier = new JLabel("Leverant\u00F6r");
		lblRegisterSupplier.setForeground(Color.WHITE);
		lblRegisterSupplier.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblRegisterSupplier.setBounds(10, 227, 87, 14);


		panelNewInvoice.add(lblRegisterSupplier);

		JLabel lblRegisterPrintedDate = new JLabel("Utskriftsdatum");
		lblRegisterPrintedDate.setForeground(Color.WHITE);
		lblRegisterPrintedDate.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblRegisterPrintedDate.setBounds(10, 59, 110, 26);
		panelNewInvoice.add(lblRegisterPrintedDate);

		JLabel lblRegisterInvoiceNumber = new JLabel("Fakturanummer");
		lblRegisterInvoiceNumber.setForeground(Color.WHITE);
		lblRegisterInvoiceNumber.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblRegisterInvoiceNumber.setBounds(10, 21, 110, 26);
		panelNewInvoice.add(lblRegisterInvoiceNumber);

		textFieldRegisterInvoiceNumber = new JTextField();
		textFieldRegisterInvoiceNumber.setBounds(130, 25, 96, 20);
		panelNewInvoice.add(textFieldRegisterInvoiceNumber);
		textFieldRegisterInvoiceNumber.setColumns(10);

		comboBoxRegisterNewInvoiceSupplier = new JComboBox();
		comboBoxRegisterNewInvoiceSupplier.setBackground(Color.WHITE);
		comboBoxRegisterNewInvoiceSupplier.setBounds(130, 221, 96, 18);

		panelNewInvoice.add(comboBoxRegisterNewInvoiceSupplier);

		JButton btnRegisterInvoiceChooseFile = new JButton("V\u00E4lj fil...");
		btnRegisterInvoiceChooseFile.setBorderPainted(false);
		btnRegisterInvoiceChooseFile.setBackground(Color.ORANGE);
		btnRegisterInvoiceChooseFile.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnRegisterInvoiceChooseFile.setBounds(130, 250, 96, 19);
		panelNewInvoice.add(btnRegisterInvoiceChooseFile);

		JSpinner spinnerRegisterNewInvoiceAmount = new JSpinner();
		spinnerRegisterNewInvoiceAmount.setBounds(130, 339, 96, 20);
		panelNewInvoice.add(spinnerRegisterNewInvoiceAmount);


		comboBoxRegisterInvoiceProduct = new JComboBox();
		comboBoxRegisterInvoiceProduct.setBounds(130, 315, 96, 18);

		panelNewInvoice.add(comboBoxRegisterInvoiceProduct);

		JLabel lblRegisterReceivedDate = new JLabel("Mottaget datum");

		lblRegisterReceivedDate.setForeground(Color.WHITE);
		lblRegisterReceivedDate.setFont(new Font("Arial Black", Font.PLAIN, 12));

		lblRegisterReceivedDate.setBounds(10, 101, 110, 29);
		panelNewInvoice.add(lblRegisterReceivedDate);

		JLabel lblRegisterExpirationDate = new JLabel("F\u00F6rfallodatum");
		lblRegisterExpirationDate.setForeground(Color.WHITE);
		lblRegisterExpirationDate.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblRegisterExpirationDate.setBounds(10, 141, 96, 29);


		panelNewInvoice.add(lblRegisterExpirationDate);

		JButton btnRegisterInvoice = new JButton("Registrera");
		btnRegisterInvoice.setBorderPainted(false);
		btnRegisterInvoice.setBackground(Color.ORANGE);
		btnRegisterInvoice.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnRegisterInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnRegisterInvoice.setBounds(130, 382, 193, 23);
		panelNewInvoice.add(btnRegisterInvoice);

		JLabel lblLeveransdatum = new JLabel("Leveransdatum");
		lblLeveransdatum.setForeground(Color.WHITE);
		lblLeveransdatum.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblLeveransdatum.setBounds(10, 181, 110, 29);
		panelNewInvoice.add(lblLeveransdatum);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\Users\\Vicky\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\5HHUSZ1C\\icons8-document-50[1].png"));
		label_9.setBounds(740, 349, 50, 86);
		panelNewInvoice.add(label_9);

		JPanel panelSearchInvoice = new JPanel();
		panelSearchInvoice.setBackground(Color.BLACK);
		panelSearchInvoice.setBorder(new LineBorder(Color.ORANGE, 2));
		tabbedPaneInsideInvoice.addTab("S\u00F6k Faktura", null, panelSearchInvoice, null);
		tabbedPaneInsideInvoice.setBackgroundAt(1, Color.ORANGE);
		panelSearchInvoice.setLayout(null);

		JScrollPane scrollPaneFindInvoice = new JScrollPane();
		scrollPaneFindInvoice.setBounds(371, 5, 446, 456);
		panelSearchInvoice.add(scrollPaneFindInvoice);

		JTextArea textAreaSearchInvoice = new JTextArea();
		scrollPaneFindInvoice.setViewportView(textAreaSearchInvoice);

		JLabel lblFIndInvoiceNumber = new JLabel("Fakturanummer");
		lblFIndInvoiceNumber.setForeground(Color.WHITE);
		lblFIndInvoiceNumber.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblFIndInvoiceNumber.setBounds(32, 33, 107, 14);
		panelSearchInvoice.add(lblFIndInvoiceNumber);

		JLabel lblFindInvoiceByCategory = new JLabel("Kategori");
		lblFindInvoiceByCategory.setForeground(Color.WHITE);
		lblFindInvoiceByCategory.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblFindInvoiceByCategory.setBounds(32, 63, 68, 14);
		panelSearchInvoice.add(lblFindInvoiceByCategory);


		comboBoxFindInvoiceByCategory = new JComboBox();
		comboBoxFindInvoiceByCategory.setBounds(137, 62, 96, 18);

		panelSearchInvoice.add(comboBoxFindInvoiceByCategory);

		textFieldFindInvoiceByInvoiceNumber = new JTextField();
		textFieldFindInvoiceByInvoiceNumber.setBounds(137, 31, 96, 16);
		panelSearchInvoice.add(textFieldFindInvoiceByInvoiceNumber);
		textFieldFindInvoiceByInvoiceNumber.setColumns(10);

		JButton btnFindInvoice = new JButton("Hitta Faktura");
		btnFindInvoice.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnFindInvoice.setBorderPainted(false);
		btnFindInvoice.setBackground(Color.ORANGE);
		btnFindInvoice.setBounds(39, 91, 194, 23);
		panelSearchInvoice.add(btnFindInvoice);
		
		JLabel lblAddInvoiceResponse = new JLabel("");
		lblAddInvoiceResponse.setIcon(new ImageIcon("C:\\Users\\Vicky\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\9PKCFHM7\\icons8-search-50[1].png"));
		lblAddInvoiceResponse.setBounds(251, 74, 96, 49);
		panelSearchInvoice.add(lblAddInvoiceResponse);
		
		JLabel lblErrorMessageInvoice = new JLabel("");
		lblErrorMessageInvoice.setForeground(Color.RED);
		lblErrorMessageInvoice.setBounds(49, 124, 167, 13);
		panelSearchInvoice.add(lblErrorMessageInvoice);
		btnFindInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String invoiceNumber = textFieldFindInvoiceByInvoiceNumber.getText();
				String category = (String)comboBoxFindInvoiceByCategory.getSelectedItem();
				if (!invoiceNumber.equals("") && category == null) {
					if (controller.getInvoiceRegister().findInvoice(invoiceNumber) == null) {
						lblErrorMessageInvoice.setText("Ingen faktura med det inskrivna fakturanummret");
						lblAddInvoiceResponse.setText("");
					} else {
						String print = "Hittade faktura nummer " + invoiceNumber + "\nLadda ner fil...\nF�rfallodatum: " + controller.getInvoiceRegister().findInvoice(invoiceNumber).getExpiryDate() + "\nSumma:" + controller.findSum(invoiceNumber) + " SEK";
						textAreaSearchInvoice.setText(print);
						lblErrorMessageInvoice.setText("");
						lblAddInvoiceResponse.setText("Faktura hittad!");
					}
				} else if (category != null && invoiceNumber.equals("")) {
					textAreaSearchInvoice.setText(controller.searchCategory(category));
					lblErrorMessageInvoice.setText("");
					lblAddInvoiceResponse.setText("Fakturor inom kategori " + category + " hittade!");
				} else {
					lblErrorMessageInvoice.setText("Välj mellan att söka faktura genom vald kategori ELLER specifikt fakturanummer");
					lblAddInvoiceResponse.setText("");
				}
				
			}
		});

		JPanel panelSupplier = new JPanel();
		panelSupplier.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 11));
		tabbedPane.addTab("Leverant\u00F6rer", null, panelSupplier, null);
		panelSupplier.setLayout(null);

		JTabbedPane tabbedPaneInsideSuppliers = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneInsideSuppliers.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 11));
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
		
		JLabel lblErrorMessageSupplier = new JLabel("");
		lblErrorMessageSupplier.setForeground(Color.RED);
		lblErrorMessageSupplier.setBounds(12, 157, 256, 13);
		panelRegisterNewSupplier.add(lblErrorMessageSupplier);
		
		JLabel lblAddSupplierResponse = new JLabel("");
		lblAddSupplierResponse.setBounds(247, 129, 269, 13);
		panelRegisterNewSupplier.add(lblAddSupplierResponse);

		JButton btnNewSupplier = new JButton("L\u00E4gg till leverant\u00F6r");
		btnNewSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldNewSupplierName.getText();
				String fax = textFieldNewSupplierFax.getText();
				String number = textFieldNewSupplierNumber.getText();
				String site = textFieldNewSupplierSite.getText();
				
				///Felmeddelande om man inte fyller i något
				if (name.equals("") || fax.equals("") || number.equals("") || site.contentEquals("")) {
					lblErrorMessageSupplier.setText("ERROR! Vänligen fyll i alla rutor");
					lblAddSupplierResponse.setText("");
				}
				else if (controller.searchSupplier(name) == null) {
					lblErrorMessageSupplier.setText("");
					controller.addSupplier(name, fax, number, site);
					lblAddSupplierResponse.setText("Leverantören " + name + "är tillagd i databasen");
					textFieldNewSupplierName.setText("");
					textFieldNewSupplierFax.setText("");
					textFieldNewSupplierNumber.setText("");
					textFieldNewSupplierSite.setText("");
				}// felmeddlande om supplier redan finns i databaserna 
				else {
					lblErrorMessageSupplier.setText("ERROR! Leverantören är redan registrerad");
					lblAddSupplierResponse.setText("");
				}
			}
		});
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
				tableSearchSuppliers.setModel(controller.viewAllSuppliers());
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

		comboBoxSearchSupplierByProduct = new JComboBox();
		comboBoxSearchSupplierByProduct.setBounds(89, 34, 136, 18);
		panelSearchSupplier.add(comboBoxSearchSupplierByProduct);

		comboBoxSearchSupplierByCategory = new JComboBox();
		comboBoxSearchSupplierByCategory.setBounds(89, 9, 136, 18);
		panelSearchSupplier.add(comboBoxSearchSupplierByCategory);

		JScrollPane scrollPaneSearchSuppliers = new JScrollPane();
		scrollPaneSearchSuppliers.setBounds(280, 11, 527, 439);
		panelSearchSupplier.add(scrollPaneSearchSuppliers);
		
		tableSearchSuppliers = new JTable();
		scrollPaneSearchSuppliers.setViewportView(tableSearchSuppliers);

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
					lblErrorMessage.setText("V�nligen ange ett namn.");
					lblAddCategoryResponse.setText("");
				} else if (controller.getCategoryRegister().findCategory(categoryName) != null) {
					lblErrorMessage.setText("Kategorin " + categoryName + " finns redan.");
					lblAddCategoryResponse.setText("");
				} else {
					controller.addCategory(categoryName);
					lblAddCategoryResponse.setText("Kategori " + categoryName + " har nu lagts till.");
					lblErrorMessage.setText("");
					textField.setText("");
				}
				updateComboBoxes(controller);
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


		comboBoxAddProductCategory = new JComboBox();
		comboBoxAddProductCategory.setBounds(78, 219, 96, 18);
		panel.add(comboBoxAddProductCategory);

		textFieldProductName = new JTextField();
		textFieldProductName.setColumns(10);
		textFieldProductName.setBounds(78, 142, 96, 20);
		panel.add(textFieldProductName);

		JButton buttonAddProduct = new JButton("L\u00E4gg till vara");
		buttonAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productName = textFieldProductName.getText();
				String productNumber = textFieldProductNumber.getText();
				String supplier = (String) comboBoxAddProductSupplier.getSelectedItem();
				String category = (String) comboBoxAddProductSupplier.getSelectedItem();
				
			}
		});
		buttonAddProduct.setBounds(10, 258, 164, 23);
		panel.add(buttonAddProduct);

		textFieldProductNumber = new JTextField();
		textFieldProductNumber.setColumns(10);
		textFieldProductNumber.setBounds(78, 167, 96, 20);
		panel.add(textFieldProductNumber);

		JLabel label_6 = new JLabel("Varunummer");
		label_6.setBounds(10, 170, 79, 14);
		panel.add(label_6);

		JLabel label_7 = new JLabel("Leverant\u00F6r");
		label_7.setBounds(10, 196, 79, 14);
		panel.add(label_7);


		comboBoxAddProductSupplier = new JComboBox();
		comboBoxAddProductSupplier.setBounds(78, 195, 96, 18);
		panel.add(comboBoxAddProductSupplier);




		JPanel panelReport = new JPanel();
		tabbedPane.addTab("Rapport", null, panelReport, null);
		panelReport.setLayout(null);

		UtilDateModel dateModelReportStartDate = new UtilDateModel();
		JDatePanelImpl datePanelReportStartDate = new JDatePanelImpl(dateModelReportStartDate, p);
		JDatePickerImpl datePickerReportStartDate = new JDatePickerImpl(datePanelReportStartDate, dateLabelFormatter);
		datePickerReportStartDate.setBounds(92, 11, 202, 29);
		panelReport.add(datePickerReportStartDate);

		UtilDateModel dateModelReportEndDate = new UtilDateModel();
		JDatePanelImpl datePanelReportEndDate = new JDatePanelImpl(dateModelReportEndDate, p);
		JDatePickerImpl datePickerReportEndDate = new JDatePickerImpl(datePanelReportEndDate, dateLabelFormatter);
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

		comboBoxReportSupplier = new JComboBox();
		comboBoxReportSupplier.setBounds(92, 123, 105, 18);
		panelReport.add(comboBoxReportSupplier);

		comboBoxReportCategory = new JComboBox();
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
