import javax.swing.*;
import java.awt.*;

/**
 * Airplane.java
 *
 * @author Sebrianne Ferguson
 * Last edited: November 4th, 2018
 * Purpose: an airplane which will serve as an obstacle to the user while playing the game.
 * 			In addition, users can use the drone to shoot down airplanes with missiles.
 * picture from yopriceville.com
 */

public class Airplane extends JLabel {
	private int w, h, x, y, dx, dy;
	private Image image; //the airplane picture

	/**
	 * Airplane()
	 * ctor
	 */
	public Airplane() {
		x = 50;
		y = 50;
		//resize the image and create the icon
		ImageIcon ii = new ImageIcon(getClass().getResource("AirplanePic.png"));
		image = ii.getImage();
		w = 100;
		h = 50;
		Image newImage = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		image = newImage;
		ii = new ImageIcon(image);
		//this will draw the image as the icon for this jlabel
		this.setIcon(ii);
	}

	/**
	 * move()
	 * changes the x and y position of the drone
	 */
	public void move() {
		x += dx;
		y += dy;
	}

	
	public Image getImage() {
		return image;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}
}
