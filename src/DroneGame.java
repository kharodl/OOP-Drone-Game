import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
		//frame.add(b);

		PlaneShape shape = new PlaneShape(100,0,100);
		ShapeIcon icon = new ShapeIcon(shape, 400, 100);
		JLabel plane = new JLabel(icon);

		frame.add(plane);
		plane.setVisible(true);

		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
