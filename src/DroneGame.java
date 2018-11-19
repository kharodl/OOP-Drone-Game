import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * DroneGame.java
 *
 * @author Sebrianne Ferguson, Lovejit Kharod, Adham Kamel
 * Last edited: October 31st, 2018
 * Purpose: runs the drone game.
 */

public class DroneGame extends JFrame implements KeyListener{
	
	Background b;
	JPanel background;
	JPanel instructions;
	Stopwatch s;
	JLabel start;
	Airplane[] planes;
	Drone d;
	PlanePanel action;
	Timer[] timers;
	Scores score;
	
	public DroneGame() {
		this.setTitle("CS 151 Drone Game | Sebrianne, Adham, and Lovejit");
		this.setSize(new Dimension(900, 660));
		this.setBackground(Color.WHITE);
		
		// create the background
		b = new Background();
		// create a jpanel to hold the background
		background = new JPanel();
		background.setBackground(Color.WHITE);
		background.setSize(900, 600);
		s = new Stopwatch();
		background.add(s);
		background.add(b);
		
		// will change to a popup with instructions on how to play the game
		/**start = new JLabel("Press SPACE to start");
		start.setFont(start.getFont().deriveFont(30.0f));
		background.add(start);*/
		
		Scores score = new Scores();
		background.add(score);

		// create the airplanes and set their position
		planes = new Airplane[6];
		for (int i = 0; i < 6; i++) {
			planes[i] = new Airplane();
			planes[i].setX(planes[i].getX() * 14);
			planes[i].setY(planes[i].getY() + (80 * i));
			
		}
		
		// create the drone
		d = new Drone();
		// create the planepanel and add the drone and airplanes to it
		action = new PlanePanel(d, planes);
		action.setBackground(Color.WHITE);
		action.paintComponent();
		
		//added so the game starts and everything starts moving when you press the space key
		this.addKeyListener(this);
		action.addKeyListener(this);
		s.addKeyListener(this);
		
		timers = new Timer[planes.length];
		
		for (int i = 0; i < planes.length; i++) {
			timers[i] = new Timer(planes[i], s, action);
			//Thread object = new Thread(timers[i]);
			//object.start();
		}	
		
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
		this.getLayeredPane().add(action, JLayeredPane.PALETTE_LAYER);
		this.getLayeredPane().add(instructions, JLayeredPane.POPUP_LAYER);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		DroneGame frame = new DroneGame();
		
	}

	//not working
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE: //if the user presses the down arrow
				instructions.setVisible(false);
				Thread sw = new Thread(s);
				sw.start();
				for (int i = 0; i < planes.length; i++) {
					Thread object = new Thread(timers[i]);
					object.start();
				}
					
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
