import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

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
		frame.setSize(new Dimension(900, 600));

		//create the background
		Background b = new Background();
		JPanel background = new JPanel();
		background.setSize(900,600);
		background.add(b);

		//create the plane -- 1 for now
		/**PlaneShape shape = new PlaneShape(200,0,100);
		ShapeIcon icon = new ShapeIcon(shape, 400, 100);
		JLabel plane = new JLabel(icon);*/
		Airplane plane = new Airplane();
		
		
		//create the planepanel, where the moving components will be
		JPanel planePanel = new JPanel();
		planePanel.setLayout(null);
		planePanel.setSize(900,600); //set the size of the panel
		Drone d = new Drone();
		planePanel.add(d, -1); //add the drone to the background
		planePanel.add(plane, 1); //add the plane in the foreground

		planePanel.setOpaque(false); //see through


		//add the layers to the jpanel in the correct order
		frame.getLayeredPane().add(background, JLayeredPane.DEFAULT_LAYER);
		frame.getLayeredPane().add(planePanel, JLayeredPane.PALETTE_LAYER);

		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
