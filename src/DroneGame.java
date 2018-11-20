import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

/**
 * DroneGame.java
 *
 * @author Sebrianne Ferguson, Lovejit Kharod, Adham Kamel
 * Last edited: October 31st, 2018
 * Purpose: runs the drone game.
 */

public class DroneGame extends JFrame implements KeyListener {

	private JPanel background;
	private JPanel instructions;
	private Stopwatch stopwatch;
	private Airplane[] planes;
	private PlanePanel action;
	private Timer timer;
	private Scores score;
	private Thread sw, t;
	JLabel start;
	Drone d;

	public DroneGame() {
		this.setTitle("CS 151 Drone Game | Sebrianne, Adham, and Lovejit");
		this.setSize(new Dimension(900, 660));
		this.setBackground(Color.WHITE);

		// will change to a popup with instructions on how to play the game
		/**start = new JLabel("Press SPACE to start");
		 start.setFont(start.getFont().deriveFont(30.0f));
		 background.add(start);*/

		// create the drone
		d = new Drone();
		planes = new Airplane[6];
		for (int i = 0; i < 6; i++)
			planes[i] = new Airplane(i); // i = index top to bottom


		// create PlanePanel and add the drone and airplanes to it
		PlanePanel gamePanel = new PlanePanel(planes, d);

		// create timer and stopwatch, and relevant threads
		timer = new Timer(planes, gamePanel);
		t = new Thread(timer);
		stopwatch = new Stopwatch(t);
		sw = new Thread(stopwatch);

		gamePanel.setBackground(Color.WHITE);
		gamePanel.paintComponent();

		// create the background and JPanel to hold it
		background = new JPanel();
		background.setBackground(Color.WHITE);
		background.setSize(900, 600);
		background.add(stopwatch);
		background.add(new Background());
		score = new Scores();
		background.add(score);

		//popup instruction window
		instructions = new JPanel();
		instructions.setBackground(Color.PINK);
		JTextArea ins = new JTextArea("INSTRUCTIONS");
		ins.setFont(ins.getFont().deriveFont(55.0f));
		ins.setForeground(Color.BLACK);
		ins.setBorder(null);
		ins.setOpaque(false);

		JTextArea rules = new JTextArea("\n\nOBJECTIVE: DODGE THE AIRPLANES USING UP AND DOWN ARROWS. \nIF YOU HIT AN AIRPLANE, YOU LOSE. \nIF YOU DON'T GET HIT FOR 1.5 MINUTES, YOU WIN. \n\n\n\nUSE THE W KEY TO FIRE UP \n\nUSE THE S KEY TO FIRE DOWN. \n\n\n\n\n\nPRESS THE SPACE KEY TO START");
		rules.setSize(100, 550);
		rules.setFont(ins.getFont().deriveFont(15.0f));
		rules.setForeground(Color.BLACK);
		rules.setBorder(null);
		rules.setOpaque(false);

		instructions.add(ins);
		instructions.add(rules);
		instructions.setSize(600, 550);
		instructions.setLocation((this.getWidth() / 2) - (instructions.getWidth() / 2) - 20, (this.getHeight() / 2) - (instructions.getHeight() / 2) - 20);
		instructions.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.DARK_GRAY));
		instructions.setLayout(new FlowLayout());
		instructions.setVisible(true);


		this.getLayeredPane().add(background, JLayeredPane.DEFAULT_LAYER);
		this.getLayeredPane().add(gamePanel, JLayeredPane.PALETTE_LAYER);
		this.getLayeredPane().add(instructions, JLayeredPane.POPUP_LAYER);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//added so the game starts and everything starts moving when you press the space key
		gamePanel.addKeyListener(this);
	}

	public static void main(String[] args) {
		new DroneGame();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) { //if the user presses the down arrow
			instructions.setVisible(false);
			if (t.isInterrupted()) {
				sw.run();
				t.run();
			}
			else if (!sw.isAlive() && !t.isAlive()) {
				sw.start();
				t.start();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
