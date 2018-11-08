import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * DroneGame.java
 *
 * @author Sebrianne Ferguson
 * Last edited: October 31st, 2018
 * Purpose: runs the drone game.
 */

public class DroneGame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("CS 151 Drone Game | Sebrianne, Adham, and Lovejit");
		frame.setSize(new Dimension(900, 700));

		//create the background
		Background b = new Background();
		//create a jpanel to hold the background
		JPanel background = new JPanel();
		background.setSize(900,600);
		Stopwatch s = new Stopwatch();
		background.add(s);
		background.add(b);
		
		//will change to a popup with instructions on how to play the game
		JLabel start = new JLabel("Press SPACE to start");
		start.setFont(start.getFont().deriveFont(30.0f));
		background.add(start);

		//create the airplanes and set their position
		Airplane[] planes = new Airplane[6];
		for (int i = 0; i < 6; i++) {
			planes[i] = new Airplane();
			planes[i].setX(planes[i].getX() * 14);
			planes[i].setY(planes[i].getY() + (80 * i));
		}
		
		//create the drone
		Drone d = new Drone();
		d.setY(90);
		//create the planepanel and add the drone and airplanes to it
		PlanePanel action = new PlanePanel(d, planes);
		action.paintComponent();
		
		
		//add the layers to the jpanel in the correct order
		frame.getLayeredPane().add(background, JLayeredPane.DEFAULT_LAYER);
		frame.getLayeredPane().add(action, JLayeredPane.PALETTE_LAYER);
	

		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
		//s.begin();
		
		/**
		Random r = new Random();
		int time = s.getTime();
		while (time != 0) {
			for (Airplane p: planes) {
				p.dx = r.nextInt(20);
				p.move();
				p.setLocation(p.getX(), p.getY());
				action.paintComponent();
			}
			time = s.getTime();
		}
		*/
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
