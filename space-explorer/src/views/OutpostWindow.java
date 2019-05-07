package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPanel;

public class OutpostWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutpostWindow window = new OutpostWindow();
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
	public OutpostWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCoins = new JLabel("Coins Available:");
		lblCoins.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 18));
		lblCoins.setBounds(73, 461, 136, 15);
		frame.getContentPane().add(lblCoins);
		
		JComboBox ItemsCombo = new JComboBox();
		ItemsCombo.setBounds(73, 161, 283, 24);
		frame.getContentPane().add(ItemsCombo);
		
		JButton InventoryButton = new JButton("View Inventory");
		InventoryButton.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		InventoryButton.setBounds(73, 501, 180, 25);
		frame.getContentPane().add(InventoryButton);
		
		JLabel lblItemsAvailableIn = new JLabel("See what is available in this outpost!");
		lblItemsAvailableIn.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 16));
		lblItemsAvailableIn.setBounds(73, 112, 283, 15);
		frame.getContentPane().add(lblItemsAvailableIn);
		
		JPanel panel = new JPanel();
		panel.setBounds(425, 112, 326, 310);
		frame.getContentPane().add(panel);
		
		JLabel lblItemInfo = new JLabel("About this item");
		lblItemInfo.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 16));
		panel.add(lblItemInfo);
		
		JButton PurchaseButton = new JButton("PURCHASE");
		PurchaseButton.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 19));
		PurchaseButton.setBounds(73, 317, 283, 49);
		frame.getContentPane().add(PurchaseButton);
		
		JButton btnBackToShip = new JButton("Back to Ship");
		btnBackToShip.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 14));
		btnBackToShip.setBounds(571, 501, 180, 25);
		frame.getContentPane().add(btnBackToShip);
		
		JLabel lblWelcomeToOutpost = new JLabel("Welcome to Space Outpost!");
		lblWelcomeToOutpost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 25));
		lblWelcomeToOutpost.setBounds(234, 24, 331, 47);
		frame.getContentPane().add(lblWelcomeToOutpost);
	}
}
