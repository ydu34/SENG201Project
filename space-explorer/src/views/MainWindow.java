package views;

import java.awt.EventQueue;
import main.GameEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;

public class MainWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Create the application.
	 */
	public MainWindow(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		game.closeMainWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if (game.gameOver()) {
			finishedWindow();
			game.launchGameOverWindow();
		} 
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("SPACE EXPLORERS");
		frame.getContentPane().setFont(new Font("L M Mono Prop Lt10", Font.PLAIN, 12));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnOutpost = new JButton("Visit outpost");
		btnOutpost.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				game.launchOutpostWindow();
			}
		});
		btnOutpost.setBounds(20, 495, 170, 35);
		frame.getContentPane().add(btnOutpost);

		JButton btnCrew = new JButton("View Crew");
		btnCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchCrewMemberWindow();
			}
		});
		btnCrew.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnCrew.setBounds(210, 495, 170, 35);
		frame.getContentPane().add(btnCrew);

		JLabel lblPlanetImage = new JLabel();
		lblPlanetImage.setBounds(28, 76, 400, 350);
		frame.getContentPane().add(lblPlanetImage);
		ImageIcon imageIcon = new ImageIcon(
				StartingPlanetWindow.class.getResource("/resources/planet-2398343_1920.jpg"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(-1, 400, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		lblPlanetImage.setIcon(imageIcon);

		JButton btnNextDay = new JButton("Next day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = game.nextDay();
				if (!(message.isEmpty())) {
					JOptionPane.showMessageDialog(frame, message);
				}
				finishedWindow();
				if (game.gameOver()) {
					game.launchGameOverWindow();
				} else {
					game.launchMainWindow();
				}

			}
		});
		btnNextDay.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 15));
		btnNextDay.setBounds(400, 495, 170, 35);
		frame.getContentPane().add(btnNextDay);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(440, 76, 312, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(12, 23, 137, 31);
		panel.add(lblDay);
		lblDay.setFont(new Font("Dialog", Font.BOLD, 18));

		JLabel lblDayValue = new JLabel(game.getCurrentDay() + "/" + game.getGameDuration());
		lblDayValue.setBounds(161, 23, 151, 31);
		panel.add(lblDayValue);
		lblDayValue.setText(game.getCurrentDay() + "/" + game.getGameDuration());
		lblDayValue.setFont(new Font("Dialog", Font.PLAIN, 18));

		JLabel lblShip = new JLabel("Ship: \r\n");
		lblShip.setBounds(12, 239, 137, 31);
		panel.add(lblShip);
		lblShip.setFont(new Font("Dialog", Font.BOLD, 18));

		JLabel lblShipName = new JLabel(game.getShip().getName());
		lblShipName.setBounds(161, 239, 151, 31);
		panel.add(lblShipName);
		lblShipName.setFont(new Font("Dialog", Font.PLAIN, 18));

		JLabel lblPiecesFound = new JLabel("Pieces found:");
		lblPiecesFound.setBounds(12, 77, 137, 31);
		panel.add(lblPiecesFound);
		lblPiecesFound.setFont(new Font("Dialog", Font.BOLD, 18));

		JLabel lblPiecesFoundValue = new JLabel(
				game.getShip().getPiecesFound() + "/" + game.getShip().getPiecesNeeded());
		lblPiecesFoundValue.setBounds(161, 77, 151, 31);
		panel.add(lblPiecesFoundValue);
		lblPiecesFoundValue.setFont(new Font("Dialog", Font.PLAIN, 18));

		JLabel lblShieldLevel = new JLabel("Shield Level:");
		lblShieldLevel.setBounds(12, 293, 137, 31);
		panel.add(lblShieldLevel);
		lblShieldLevel.setFont(new Font("Dialog", Font.BOLD, 18));

		JLabel lblShipLevelValue = new JLabel(
				game.getShip().getShieldLevel() + "/" + game.getShip().getMaxShieldLevel());
		lblShipLevelValue.setBounds(161, 293, 151, 31);
		panel.add(lblShipLevelValue);
		lblShipLevelValue.setFont(new Font("Dialog", Font.PLAIN, 18));

		JLabel lblPlanet = new JLabel("Planet:");
		lblPlanet.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPlanet.setBounds(12, 131, 137, 31);
		panel.add(lblPlanet);

		JLabel lblPlanetName = new JLabel(game.getCrew().getCurrentLocation().getName());
		lblPlanetName.setBounds(161, 131, 151, 31);
		panel.add(lblPlanetName);
		lblPlanetName.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JLabel lblPieceDetected = new JLabel("Piece detected:");
		lblPieceDetected.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPieceDetected.setBounds(12, 185, 151, 31);
		panel.add(lblPieceDetected);
		
		JLabel lblPieceDetectedValue = new JLabel(game.getCrew().getCurrentLocation().planetPieceDetected());
		lblPieceDetectedValue.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPieceDetectedValue.setBounds(161, 185, 151, 31);
		panel.add(lblPieceDetectedValue);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(12, 115, 288, 2);
		panel.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(12, 232, 288, 2);
		panel.add(separator2);

		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Game",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					System.exit(0);
				}
			}
		});
		btnExitGame.setFont(new Font("Dialog", Font.BOLD, 15));
		btnExitGame.setBounds(590, 495, 170, 35);
		frame.getContentPane().add(btnExitGame);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 466, 740, 16);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 34, 740, 16);
		frame.getContentPane().add(separator_1);
	}
}
