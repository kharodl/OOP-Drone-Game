import java.awt.Dimension;
import java.awt.FlowLayout;

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
		frame.setSize(new Dimension(900, 600));
		//frame.setPreferredSize(new Dimension(600, 400));

		Background b = new Background();
		JPanel background = new JPanel();
		background.setSize(900,600);
		background.add(b);

		PlaneShape shape = new PlaneShape(200,0,100);
		ShapeIcon icon = new ShapeIcon(shape, 400, 100);
		JLabel plane = new JLabel(icon);
		
		//plane.setOpaque(false); //sebrianne trying this
		JPanel planePanel = new JPanel();
		planePanel.add(plane);
		planePanel.setSize(200,100);

		//frame.add(plane);
		frame.getLayeredPane().add(background, JLayeredPane.DEFAULT_LAYER);
		frame.getLayeredPane().add(planePanel, JLayeredPane.PALETTE_LAYER);

		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
