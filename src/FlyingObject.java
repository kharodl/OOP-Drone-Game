import javax.swing.*;
import java.awt.*;

/**
 * FlyingObject.java
 *
 * @author Lovejit Kharod, Sebrianne Ferguson
 * Last edited: November 19, 2018
 * Purpose: Provides a general use class for all the flying objects,
 * 			handling image setup and implementations for JLabel.
 */

abstract class FlyingObject extends JLabel {
	private final int w, h;
	private int x, y;
	int dx, dy;
	private boolean disabled;

	/**
	 * FlyingObject()
	 * Takes a series of parameters to construct a JLabel of the given specs
	 *
	 * @param iconImage - Address of the image to be used
	 * @param w         - width of the image
	 * @param h         - height of the image
	 * @param x         - the initial x value of the object
	 * @param y         - the initial y value of the object
	 */
	FlyingObject(String iconImage, int w, int h, int x, int y) {
		//resize the image and create the icon
		this.w = w;
		this.h = h;
		this.x = x;
		this.y = y;
		ImageIcon ii = new ImageIcon(new ImageIcon(getClass().getResource(iconImage)).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		//this will draw the image as the icon for this jlabel
		this.setIcon(ii);
		disabled = false;
	}

	/**
	 * move()
	 * updates the location of the object
	 */
	void move() {
		x += dx;
		y += dy;
	}

	void setX(int x) {
		this.x = x;
	}

	void setY(int y) {
		this.y = y;
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
	
	public boolean isDisabled() {
		return disabled;
	}
	
	public void disable() {
		disabled = true;
	}
	
	
}