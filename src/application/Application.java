package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Application {

	private JFrame frame;

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
		
		JPanel panelRegister = new JPanel();
		tabbedPane.addTab("Registrera", null, panelRegister, null);
		panelRegister.setLayout(null);
		
		JPanel panelReport = new JPanel();
		tabbedPane.addTab("Rapport", null, panelReport, null);
		panelReport.setLayout(null);
		
		JPanel panelSupplier = new JPanel();
		tabbedPane.addTab("Leverant\u00F6rer", null, panelSupplier, null);
		panelSupplier.setLayout(null);
		
		JPanel panelSearchInvoice = new JPanel();
		tabbedPane.addTab("S\u00F6k faktura", null, panelSearchInvoice, null);
		panelSearchInvoice.setLayout(null);
	}
}
