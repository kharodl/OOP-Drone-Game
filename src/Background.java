import javax.swing.*;
import java.awt.*;

/**
 * Background.java
 *
 * @author Adham Kamel, Lovejit Kharod
 * Last edited: November 19, 2018
 * Purpose: make a sky background for the game.
 */

class Background extends JPanel {

	/**
	 * Background()
	 * Sets the size of the JPanel, creates the image, and adds it to the JPanel
	 */
	Background() {
		this.setPreferredSize(new Dimension(900, 500));
		ImageIcon image = new ImageIcon(getClass().getResource("resources/background.jpg"));
		this.add(new JLabel(new ImageIcon(image.getImage().getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH))));
	}
}
