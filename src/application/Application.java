package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Application {

	private JFrame frame;
	private JTextField textFieldRegisterInvoiceNumber;
	private JTextField textFieldRegisterNewInvoiceProductNumber;
	private JTextField textFieldNewCategoryName;
	private JTextField textFieldNewProductName;
	private JTextField textFieldFindInvoiceByInvoiceNumber;
	private JTextField textFieldNewSupplierName;
	private JTextField textFieldNewSupplierFax;
	private JTextField textFieldNewSupplierNumber;
	private JTextField textFieldNewSupplierSite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JLabel lblRegisterAmount = new JLabel("Antal");
		lblRegisterAmount.setBounds(10, 240, 25, 14);
		panelNewInvoice.add(lblRegisterAmount);
		
		JLabel lblRegisterProductNumber = new JLabel("Varunummer");
		lblRegisterProductNumber.setBounds(10, 215, 87, 14);
		panelNewInvoice.add(lblRegisterProductNumber);
		
		JLabel lblRegisterProductName = new JLabel("Namn");
		lblRegisterProductName.setBounds(10, 265, 48, 14);
		panelNewInvoice.add(lblRegisterProductName);
		
		JLabel lblRegisterInvoiceCopy = new JLabel("Bifoga kopia");
		lblRegisterInvoiceCopy.setBounds(10, 138, 87, 14);
		panelNewInvoice.add(lblRegisterInvoiceCopy);
		
		JLabel lblRegisterSupplier = new JLabel("Leverant\u00F6r");
		lblRegisterSupplier.setBounds(10, 113, 87, 14);
		panelNewInvoice.add(lblRegisterSupplier);
		
		JLabel lblRegisterSentDate = new JLabel("Skickat datum");
		lblRegisterSentDate.setBounds(10, 36, 87, 14);
		panelNewInvoice.add(lblRegisterSentDate);
		
		JLabel lblRegisterInvoiceNumber = new JLabel("Fakturanummer");
		lblRegisterInvoiceNumber.setBounds(10, 11, 87, 14);
		panelNewInvoice.add(lblRegisterInvoiceNumber);
		
		textFieldRegisterInvoiceNumber = new JTextField();
		textFieldRegisterInvoiceNumber.setBounds(107, 8, 96, 20);
		panelNewInvoice.add(textFieldRegisterInvoiceNumber);
		textFieldRegisterInvoiceNumber.setColumns(10);
		
		JComboBox comboBoxRegisterNewInvoiceSupplier = new JComboBox();
		comboBoxRegisterNewInvoiceSupplier.setBounds(107, 111, 96, 18);
		panelNewInvoice.add(comboBoxRegisterNewInvoiceSupplier);
		
		JButton btnRegisterInvoiceChooseFile = new JButton("V\u00E4lj fil...");
		btnRegisterInvoiceChooseFile.setBounds(107, 136, 96, 19);
		panelNewInvoice.add(btnRegisterInvoiceChooseFile);
		
		textFieldRegisterNewInvoiceProductNumber = new JTextField();
		textFieldRegisterNewInvoiceProductNumber.setBounds(107, 212, 96, 20);
		panelNewInvoice.add(textFieldRegisterNewInvoiceProductNumber);
		textFieldRegisterNewInvoiceProductNumber.setColumns(10);
		
		JSpinner spinnerRegisterNewInvoiceAmount = new JSpinner();
		spinnerRegisterNewInvoiceAmount.setBounds(107, 237, 96, 20);
		panelNewInvoice.add(spinnerRegisterNewInvoiceAmount);
		
		JComboBox comboBoxRegisterInvoiceProductName = new JComboBox();
		comboBoxRegisterInvoiceProductName.setBounds(107, 263, 96, 18);
		panelNewInvoice.add(comboBoxRegisterInvoiceProductName);
		
		JLabel lblRegisterReceivedDate = new JLabel("Mottaget datum");
		lblRegisterReceivedDate.setBounds(10, 63, 87, 14);
		panelNewInvoice.add(lblRegisterReceivedDate);
		
		JLabel lblRegisterExpirationDate = new JLabel("F\u00F6rfallodatum");
		lblRegisterExpirationDate.setBounds(10, 88, 96, 14);
		panelNewInvoice.add(lblRegisterExpirationDate);
		
		JButton btnRegisterInvoice = new JButton("Registrera");
		btnRegisterInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegisterInvoice.setBounds(10, 314, 193, 23);
		panelNewInvoice.add(btnRegisterInvoice);
		
		JPanel panelSearchInvoice = new JPanel();
		tabbedPaneInsideInvoice.addTab("S\u00F6k Faktura", null, panelSearchInvoice, null);
		panelSearchInvoice.setLayout(null);
		
		JScrollPane scrollPaneFindInvoice = new JScrollPane();
		scrollPaneFindInvoice.setBounds(371, 5, 446, 456);
		panelSearchInvoice.add(scrollPaneFindInvoice);
		
		JTextArea textAreaSearchInvoice = new JTextArea();
		scrollPaneFindInvoice.setViewportView(textAreaSearchInvoice);
		
		JLabel lblFindInvoiceByProduct = new JLabel("Vara");
		lblFindInvoiceByProduct.setBounds(10, 59, 48, 14);
		panelSearchInvoice.add(lblFindInvoiceByProduct);
		
		JLabel lblFIndInvoiceNumber = new JLabel("Fakturanummer");
		lblFIndInvoiceNumber.setBounds(10, 9, 89, 14);
		panelSearchInvoice.add(lblFIndInvoiceNumber);
		
		JLabel lblFindInvoiceByCategory = new JLabel("Kategori");
		lblFindInvoiceByCategory.setBounds(10, 34, 48, 14);
		panelSearchInvoice.add(lblFindInvoiceByCategory);
		
		JComboBox comboBoxFindInvoiceByProduct = new JComboBox();
		comboBoxFindInvoiceByProduct.setBounds(108, 56, 96, 20);
		panelSearchInvoice.add(comboBoxFindInvoiceByProduct);
		
		JComboBox comboBoxFindInvoiceByCategory = new JComboBox();
		comboBoxFindInvoiceByCategory.setBounds(108, 32, 96, 18);
		panelSearchInvoice.add(comboBoxFindInvoiceByCategory);
		
		textFieldFindInvoiceByInvoiceNumber = new JTextField();
		textFieldFindInvoiceByInvoiceNumber.setBounds(109, 6, 96, 20);
		panelSearchInvoice.add(textFieldFindInvoiceByInvoiceNumber);
		textFieldFindInvoiceByInvoiceNumber.setColumns(10);
		
		JButton btnFindInvoice = new JButton("Hitta Faktura");
		btnFindInvoice.setBounds(10, 92, 194, 23);
		panelSearchInvoice.add(btnFindInvoice);
		btnFindInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panelRemoveInvoice = new JPanel();
		tabbedPaneInsideInvoice.addTab("Ta Bort Faktura", null, panelRemoveInvoice, null);
		
		JPanel panelCategory = new JPanel();
		tabbedPane.addTab("New tab", null, panelCategory, null);
		
		JPanel panelRegister = new JPanel();
		tabbedPane.addTab("Registrera", null, panelRegister, null);
		panelRegister.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 11, 822, 489);
		panelRegister.add(tabbedPane_1);
		
		JPanel panelRegisterNewCategory = new JPanel();
		tabbedPane_1.addTab("Ny Kategori eller Vara", null, panelRegisterNewCategory, null);
		panelRegisterNewCategory.setLayout(null);
		
		JLabel lblNewCategory = new JLabel("Ny kategori: ");
		lblNewCategory.setBounds(10, 11, 79, 14);
		panelRegisterNewCategory.add(lblNewCategory);
		
		JLabel lblNewCategoryName = new JLabel("Namn");
		lblNewCategoryName.setBounds(10, 36, 48, 14);
		panelRegisterNewCategory.add(lblNewCategoryName);
		
		textFieldNewCategoryName = new JTextField();
		textFieldNewCategoryName.setBounds(78, 33, 96, 20);
		panelRegisterNewCategory.add(textFieldNewCategoryName);
		textFieldNewCategoryName.setColumns(10);
		
		JButton btnAddCategory = new JButton("L\u00E4gg till kategori");
		btnAddCategory.setBounds(10, 61, 164, 23);
		panelRegisterNewCategory.add(btnAddCategory);
		
		JLabel lblNewProduct = new JLabel("Ny vara:");
		lblNewProduct.setBounds(10, 120, 48, 14);
		panelRegisterNewCategory.add(lblNewProduct);
		
		JLabel lblNewProductName = new JLabel("Namn");
		lblNewProductName.setBounds(10, 145, 48, 14);
		panelRegisterNewCategory.add(lblNewProductName);
		
		JLabel lblNewProductCategory = new JLabel("Kategori");
		lblNewProductCategory.setBounds(10, 170, 48, 14);
		panelRegisterNewCategory.add(lblNewProductCategory);
		
		JComboBox comboBoxNewProductCategory = new JComboBox();
		comboBoxNewProductCategory.setBounds(78, 170, 96, 18);
		panelRegisterNewCategory.add(comboBoxNewProductCategory);
		
		textFieldNewProductName = new JTextField();
		textFieldNewProductName.setBounds(78, 142, 96, 20);
		panelRegisterNewCategory.add(textFieldNewProductName);
		textFieldNewProductName.setColumns(10);
		
		JButton btnAddProduct = new JButton("L\u00E4gg till vara");
		btnAddProduct.setBounds(10, 195, 164, 23);
		panelRegisterNewCategory.add(btnAddProduct);
		
		JPanel panelRegisterNewSupplier = new JPanel();
		tabbedPane_1.addTab("Ny Leverant\u00F6r", null, panelRegisterNewSupplier, null);
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
		
		JPanel panelReport = new JPanel();
		tabbedPane.addTab("Rapport", null, panelReport, null);
		panelReport.setLayout(null);
		
		JScrollPane scrollPaneReport = new JScrollPane();
		scrollPaneReport.setBounds(388, 11, 444, 489);
		panelReport.add(scrollPaneReport);
		
		JTextArea textAreaReport = new JTextArea();
		scrollPaneReport.setViewportView(textAreaReport);
		
		JLabel lblReportChooseDate = new JLabel("V\u00E4lj datum");
		lblReportChooseDate.setBounds(10, 17, 72, 14);
		panelReport.add(lblReportChooseDate);
		
		JLabel lblReportDateTo = new JLabel("till");
		lblReportDateTo.setBounds(165, 17, 16, 14);
		panelReport.add(lblReportDateTo);
		
		JLabel lblReportCategory = new JLabel("Kategori");
		lblReportCategory.setBounds(10, 45, 48, 14);
		panelReport.add(lblReportCategory);
		
		JLabel lblReportSupplier = new JLabel("Leverant\u00F6r");
		lblReportSupplier.setBounds(10, 74, 72, 14);
		panelReport.add(lblReportSupplier);
		
		JComboBox comboBoxReportSupplier = new JComboBox();
		comboBoxReportSupplier.setBounds(92, 74, 105, 18);
		panelReport.add(comboBoxReportSupplier);
		
		JComboBox comboBoxReportCategory = new JComboBox();
		comboBoxReportCategory.setBounds(92, 42, 105, 19);
		panelReport.add(comboBoxReportCategory);
		
		JButton btnMakeReport = new JButton("Framst\u00E4ll rapport");
		btnMakeReport.setBounds(10, 124, 187, 23);
		panelReport.add(btnMakeReport);
		
		JPanel panelSupplier = new JPanel();
		tabbedPane.addTab("Leverant\u00F6rer", null, panelSupplier, null);
		panelSupplier.setLayout(null);
		
		JLabel lblSearchSupplierByCategory = new JLabel("Kategori");
		lblSearchSupplierByCategory.setBounds(10, 17, 48, 14);
		panelSupplier.add(lblSearchSupplierByCategory);
		
		JComboBox comboBoxSearchSupplierByCategory = new JComboBox();
		comboBoxSearchSupplierByCategory.setBounds(66, 15, 136, 18);
		panelSupplier.add(comboBoxSearchSupplierByCategory);
		
		JScrollPane scrollPaneSearchSuppliers = new JScrollPane();
		scrollPaneSearchSuppliers.setBounds(345, 11, 487, 489);
		panelSupplier.add(scrollPaneSearchSuppliers);
		
		JTextArea textAreaSearchSuppliers = new JTextArea();
		scrollPaneSearchSuppliers.setViewportView(textAreaSearchSuppliers);
		
		JButton btnSortSupplier = new JButton("Sortera");
		btnSortSupplier.setBounds(10, 98, 89, 23);
		panelSupplier.add(btnSortSupplier);
		
		JLabel lblSupplierChoice = new JLabel("eller");
		lblSupplierChoice.setBounds(111, 102, 48, 14);
		panelSupplier.add(lblSupplierChoice);
		
		JButton btnSearchAllSuppliers = new JButton("Visa alla");
		btnSearchAllSuppliers.setBounds(143, 98, 89, 23);
		panelSupplier.add(btnSearchAllSuppliers);
		
		JLabel lblSearchSupplierByProduct = new JLabel("Vara");
		lblSearchSupplierByProduct.setBounds(10, 42, 48, 14);
		panelSupplier.add(lblSearchSupplierByProduct);
		
		JComboBox comboBoxSearchSupplierByProduct = new JComboBox();
		comboBoxSearchSupplierByProduct.setBounds(66, 42, 136, 18);
		panelSupplier.add(comboBoxSearchSupplierByProduct);
	}
}
