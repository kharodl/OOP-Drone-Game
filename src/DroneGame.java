import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * DroneGame.java
 *
 * @author Sebrianne Ferguson, Lovejit Kharod
 * Last edited: October 31st, 2018
 * Purpose: runs the drone game.
 */

public class DroneGame extends JFrame implements KeyListener{
	
	Background b;
	JPanel background;
	Stopwatch s;
	JLabel start;
	Airplane[] planes;
	Drone d;
	PlanePanel action;
	Timer timer;
	
	public DroneGame() {
		this.setTitle("CS 151 Drone Game | Sebrianne, Adham, and Lovejit");
		this.setSize(new Dimension(900, 700));
		
		// create the background
		b = new Background();
		// create a jpanel to hold the background
		background = new JPanel();
		background.setSize(900, 600);
		s = new Stopwatch();
		background.add(s);
		background.add(b);
		
		// will change to a popup with instructions on how to play the game
		start = new JLabel("Press SPACE to start");
		start.setFont(start.getFont().deriveFont(30.0f));
		background.add(start);

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
		action.paintComponent();
		
		timer = new Timer(planes[1], s);
		
		this.addKeyListener(this);
		
		this.getLayeredPane().add(background, JLayeredPane.DEFAULT_LAYER);
		this.getLayeredPane().add(action, JLayeredPane.PALETTE_LAYER);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {

		DroneGame frame = new DroneGame();
		//frame.s.run();
		Thread object = new Thread(frame.s);
		object.start();
		Thread object2 = new Thread(frame.timer);
		object2.start();
		
		
		
	}

	//not working
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE: //if the user presses the down arrow
				//s.run(); //not working
				
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
