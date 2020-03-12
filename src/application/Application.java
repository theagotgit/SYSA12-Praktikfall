package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

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

		JLabel lblRegisterProduct = new JLabel("Vara");
		lblRegisterProduct.setBounds(10, 215, 87, 14);
		panelNewInvoice.add(lblRegisterProduct);

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

		JSpinner spinnerRegisterNewInvoiceAmount = new JSpinner();
		spinnerRegisterNewInvoiceAmount.setBounds(107, 237, 96, 20);
		panelNewInvoice.add(spinnerRegisterNewInvoiceAmount);

		JComboBox comboBoxRegisterInvoiceProduct = new JComboBox();
		comboBoxRegisterInvoiceProduct.setBounds(107, 213, 96, 18);
		panelNewInvoice.add(comboBoxRegisterInvoiceProduct);

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
		btnRegisterInvoice.setBounds(10, 280, 193, 23);
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
		panelRemoveInvoice.setLayout(null);

		JLabel lblInvoiceNumber = new JLabel("Fakturanummer");
		lblInvoiceNumber.setBounds(10, 11, 102, 14);
		panelRemoveInvoice.add(lblInvoiceNumber);

		JComboBox comboBoxRemoveInvoice = new JComboBox();
		comboBoxRemoveInvoice.setBounds(133, 11, 102, 18);
		panelRemoveInvoice.add(comboBoxRemoveInvoice);

		JButton btnRemoveInvoice = new JButton("Ta Bort");
		btnRemoveInvoice.setBounds(10, 51, 89, 23);
		panelRemoveInvoice.add(btnRemoveInvoice);

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

		JPanel panel = new JPanel();
		tabbedPaneInsideSuppliers.addTab("Ta Bort Leverant\u00F6r", null, panel, null);
		panel.setLayout(null);

		JLabel lblNamn = new JLabel("Namn");
		lblNamn.setBounds(10, 11, 48, 14);
		panel.add(lblNamn);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(68, 11, 117, 18);
		panel.add(comboBox);

		JButton btnRemoveSupplier = new JButton("Ta Bort Leverant\u00F6r");
		btnRemoveSupplier.setBounds(10, 40, 178, 23);
		panel.add(btnRemoveSupplier);

		JPanel panelCategory = new JPanel();
		tabbedPane.addTab("Kategorier och Varor", null, panelCategory, null);
		panelCategory.setLayout(null);

		JTabbedPane tabbedPaneInsideCategory = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneInsideCategory.setBounds(10, 11, 822, 489);
		panelCategory.add(tabbedPaneInsideCategory);

		JPanel panelRegisterNewCategory = new JPanel();
		tabbedPaneInsideCategory.addTab("Ny Kategori eller Vara", null, panelRegisterNewCategory, null);
		panelRegisterNewCategory.setLayout(null);

		JLabel lblNewCategory = new JLabel("Ny kategori: ");
		lblNewCategory.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		lblNewProduct.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewProduct.setBounds(10, 120, 48, 14);
		panelRegisterNewCategory.add(lblNewProduct);

		JLabel lblNewProductName = new JLabel("Namn");
		lblNewProductName.setBounds(10, 145, 48, 14);
		panelRegisterNewCategory.add(lblNewProductName);

		JLabel lblNewProductCategory = new JLabel("Kategori");
		lblNewProductCategory.setBounds(10, 221, 48, 14);
		panelRegisterNewCategory.add(lblNewProductCategory);

		JComboBox comboBoxNewProductCategory = new JComboBox();
		comboBoxNewProductCategory.setBounds(78, 219, 96, 18);
		panelRegisterNewCategory.add(comboBoxNewProductCategory);

		textFieldNewProductName = new JTextField();
		textFieldNewProductName.setBounds(78, 142, 96, 20);
		panelRegisterNewCategory.add(textFieldNewProductName);
		textFieldNewProductName.setColumns(10);

		JButton btnAddProduct = new JButton("L\u00E4gg till vara");
		btnAddProduct.setBounds(10, 258, 164, 23);
		panelRegisterNewCategory.add(btnAddProduct);

		textFieldNewProductNumber = new JTextField();
		textFieldNewProductNumber.setBounds(78, 167, 96, 20);
		panelRegisterNewCategory.add(textFieldNewProductNumber);
		textFieldNewProductNumber.setColumns(10);

		JLabel lblVarunummer = new JLabel("Varunummer");
		lblVarunummer.setBounds(10, 170, 79, 14);
		panelRegisterNewCategory.add(lblVarunummer);

		JLabel lblNewProductSupplier = new JLabel("Leverant\u00F6r");
		lblNewProductSupplier.setBounds(10, 196, 79, 14);
		panelRegisterNewCategory.add(lblNewProductSupplier);

		JComboBox comboBoxNewProductSupplier = new JComboBox();
		comboBoxNewProductSupplier.setBounds(78, 195, 96, 18);
		panelRegisterNewCategory.add(comboBoxNewProductSupplier);

		JPanel panelRemoveCategory = new JPanel();
		tabbedPaneInsideCategory.addTab("Ta Bort Kategori eller Vara", null, panelRemoveCategory, null);
		panelRemoveCategory.setLayout(null);

		JLabel lblRemoveCategory = new JLabel("Kategori: ");
		lblRemoveCategory.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRemoveCategory.setBounds(17, 11, 99, 14);
		panelRemoveCategory.add(lblRemoveCategory);

		JLabel lblRemoveCategoryName = new JLabel("Namn");
		lblRemoveCategoryName.setBounds(17, 36, 48, 14);
		panelRemoveCategory.add(lblRemoveCategoryName);

		JComboBox comboBoxRemoveCategoryName = new JComboBox();
		comboBoxRemoveCategoryName.setBounds(85, 36, 99, 18);
		panelRemoveCategory.add(comboBoxRemoveCategoryName);

		JLabel lblRemoveProduct = new JLabel("Vara:");
		lblRemoveProduct.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRemoveProduct.setBounds(17, 99, 73, 14);
		panelRemoveCategory.add(lblRemoveProduct);

		lblRemoveProductName = new JLabel("Namn");
		lblRemoveProductName.setBounds(17, 124, 48, 14);
		panelRemoveCategory.add(lblRemoveProductName);

		JComboBox comboBoxRemoveProductName = new JComboBox();
		comboBoxRemoveProductName.setBounds(85, 124, 99, 18);
		panelRemoveCategory.add(comboBoxRemoveProductName);

		JButton btnTaBort_1 = new JButton("Ta Bort");
		btnTaBort_1.setBounds(17, 153, 89, 23);
		panelRemoveCategory.add(btnTaBort_1);

		JLabel lblEller = new JLabel("Eller");
		lblEller.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEller.setBounds(17, 74, 48, 14);
		panelRemoveCategory.add(lblEller);

		JPanel panelReport = new JPanel();
		tabbedPane.addTab("Rapport", null, panelReport, null);
		panelReport.setLayout(null);

		JScrollPane scrollPaneReport = new JScrollPane();
		scrollPaneReport.setBounds(388, 11, 444, 489);
		panelReport.add(scrollPaneReport);

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

		JLabel lblReportRequiredField = new JLabel("*Obligatoriskt f\u00E4lt");
		lblReportRequiredField.setForeground(Color.RED);
		lblReportRequiredField.setBounds(10, 158, 118, 14);
		panelReport.add(lblReportRequiredField);

		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(2, 17, 49, 14);
		panelReport.add(label);
	}
}
