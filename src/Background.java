import javax.swing.*;
import java.awt.*;

/**
 * Background.java
 *
 * @author Adham Kamel
 * Last edited: October 31st, 2018 (Sebrianne changed it from a JFrame to a JPanel)
 * Purpose: make a sky background for the game.
 */

public class Background extends JPanel {

	/**
	 * ctor that will set the bounds of the JPanel, create the image, and add it to the JPanel
	 */
	public Background() {
		//this.setBounds(50, 50, 600, 300);
		this.setPreferredSize(new Dimension(900, 500));

		// Having the image to be the size of the JPanel
		/*BufferedImage img = null;
		try {
			img = //ImageIO.read(new File("resources/background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		*/
		ImageIcon picture = new ImageIcon(getClass().getResource("newbackground.jpg"));
		Image bigger_picture = picture.getImage();
		Image new_image = bigger_picture.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_SMOOTH);
		picture = new ImageIcon(new_image);
		JLabel image = new JLabel(picture);

		this.setLayout(new FlowLayout());
		this.add(image);
		//panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	//public static void main(String[] args){
	//Background background = new Background();
	//}
}
