import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

/**
 * DroneGame.java
 *
 * @author Sebrianne Ferguson, Lovejit Kharod, Adham Kamel
 * Last edited: November 19, 2018
 * Purpose: Runs the drone game.
 */

public class DroneGame extends JFrame implements KeyListener {

	private final JPanel instructions;
	private final Timer timer;
	private final Stopwatch stopwatch;
	private Thread swThread, timerThread;

	private DroneGame() {
		this.setTitle("CS 151 Drone Game | Sebrianne, Adham, and Lovejit");
		this.setSize(new Dimension(900, 660));
		this.setBackground(Color.WHITE);

		// create the drone
		Drone drone = new Drone();
		Airplane[] planes = new Airplane[6];
		for (int i = 0; i < 6; i++)
			planes[i] = new Airplane(i); // i = index top to bottom

		// create the background and JPanel to hold it
		JPanel background = new JPanel();
		Scores score = new Scores();

		// create GamePanel and add the drone and airplanes to it
		GamePanel gamePanel = new GamePanel(drone, planes);

		// create timer and stopwatch, and relevant threads
		stopwatch = new Stopwatch(score);
		timer = new Timer(planes, gamePanel, stopwatch, score);

		background.setBackground(Color.WHITE);
		background.setSize(900, 600);
		background.add(stopwatch);
		background.add(new Background());
		background.add(score);

		gamePanel.setBackground(Color.WHITE);
		gamePanel.paintComponent();

		//popup instruction window
		instructions = new JPanel();
		instructions.setBackground(Color.PINK);
		JTextArea ins = new JTextArea("INSTRUCTIONS");
		ins.setFont(ins.getFont().deriveFont(55.0f));
		ins.setForeground(Color.BLACK);
		ins.setBorder(null);
		ins.setOpaque(false);

		JTextArea rules = new JTextArea("\n\nOBJECTIVE: DODGE THE AIRPLANES USING THE ARROW KEYS. \nIF YOU HIT AN AIRPLANE, YOU LOSE A LIFE AND ARE FROZEN FOR 5 SECONDS. \nYOU HAVE A TOTAL OF 3 LIVES. \nIF YOU DON'T GET HIT FOR 1.5 MINUTES, YOU WIN. \n\n\n\nUSE THE W KEY TO FIRE UP \nUSE THE X KEY TO FIRE DOWN.\nUSE THE S KEY TO FIRE STRAIGHT.\nONCE THE GAME IS OVER, PRESS THE SPACE KEY TO PLAY AGAIN. \n\n\n\nPRESS THE SPACE KEY TO START (GAME STARTS IMMEDIATELY)");
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

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) { //if the user presses the down arrow
			if (timerThread == null || !timerThread.isAlive()) {
				instructions.setVisible(false);
				timerThread = new Thread(timer);
				stopwatch.setTimerThread(timerThread);
				swThread = new Thread(stopwatch);
				timerThread.start();
				swThread.start();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		new DroneGame();
	}
}
