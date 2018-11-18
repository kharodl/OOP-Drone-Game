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
	private int dx, dy;
	private boolean shotAt; //a boolean value to decide whether or not we should display airplane

	/**
	 * Airplane()
	 * ctor
	 */
	public Airplane() {
		x = 50;
		y = 50;
		//resize the image and create the icon
		w = 200;
		h = 100;
		ImageIcon ii = new ImageIcon(new ImageIcon(getClass().getResource("resources/AirplanePic.png")).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		//this will draw the image as the icon for this jlabel
		this.setIcon(ii);
		this.shotAt = false; //not yet shot at when first created
	}

	/**
	 * move()
	 * changes the x and y position of the drone
	 */
	public void move(int dx) {
		x += dx;
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
		shotAt = !shotAt;
	}
	
	//just testing
	void setX(int x) {
		this.x = x;
	}
	
	void setY(int y) {
		this.y = y;
	}
}
