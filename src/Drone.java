package finalproject;

/**
 * Drone.java
 * @author Lovejit Kharod
 * Last edited: October 31st, 2018
 * Purpose: attributes and methods of the drone, which will be controlled by the user.
 * 			works in conjunction with the timer class in order to update the position of the drone.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Drone extends JLabel {
	private int w, h, x, y, dx, dy;
	private Image image; //the drone picture
	private ArrayList<Missile> missiles;

	/**
	 * Drone()
	 * creates a new arraylist to store the missiles, creates an image icon, inits w,h,x and y
	 */
	public Drone() {
		missiles = new ArrayList<>();
		ImageIcon ii = new ImageIcon("src/resources/DroneSprite.png");
		image = ii.getImage();
		w = image.getWidth(null);
		h = image.getHeight(null);
		x = 50;
		y = 50;
	}

	/**
	 * move()
	 * changes the x and y position of the drone
	 */
	public void move() {
		x += dx;
		y += dy;
	}

	/**
	 * fire()
	 * creates a new missile and adds it to the list.
	 */
	public void fire() {
		missiles.add(new Missile(x, y));
	}

	/**
	 * keyPressed()
	 * @param e
	 * as long as the user is holding down a key, it will continue to change the 
	 * x or y position in the right direction.
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT: //if the user presses the left key
				dx = -2;
			case KeyEvent.VK_RIGHT: //if the user presses the right key
				dx = 2;
			case KeyEvent.VK_UP: //if the user presses the up arrow
				dy = -2;
			case KeyEvent.VK_DOWN: //if the user presses the down arrow
				dy = 2;
		}
	}

	/**
	 * keyReleased()
	 * @param e
	 * once the key is released, it will stop moving the drone.
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				dx = 0;
			case KeyEvent.VK_RIGHT:
				dx = 0;
			case KeyEvent.VK_UP:
				dy = 0;
			case KeyEvent.VK_DOWN:
				dy = 0;
		}
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
