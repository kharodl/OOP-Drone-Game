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
	private int w, h, x, y;
	public int dx, dy;
	private Image image; //the airplane picture
	boolean shotAt; //a boolean value to decide whether or not we should display airplane

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
		w = 200;
		h = 100;
		Image newImage = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		image = newImage;
		ii = new ImageIcon(image);
		//this will draw the image as the icon for this jlabel
		this.setIcon(ii);
		this.shotAt = false; //not yet shot at when first created
	}

	/**
	 * move()
	 * changes the x and y position of the drone
	 */
	public void move() {
		x += dx;
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
	
	/**
	 * changeState()
	 * will change the shotAt value to false if its true
	 * and true if it's false
	 */
	public void changeState() {
		if (this.shotAt) {
			this.shotAt = false;
		}
		else {
			this.shotAt = true;
		}
	}
	
	//just testing
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
