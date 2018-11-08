import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Drone.java
 *
 * @author Lovejit Kharod
 * Last edited: October 31st, 2018
 * Purpose: attributes and methods of the drone, which will be controlled by the user.
 * works in conjunction with the timer class in order to update the position of the drone.
 */

public class Drone extends JLabel {
	private int w, h, x, y;
	public int dx, dy;
	private Image image; //the drone picture
	private ArrayList<Missile> missiles;

	/**
	 * Drone()
	 * creates a new arraylist to store the missiles, creates an image icon, inits w,h,x and y
	 */
	public Drone() {
		missiles = new ArrayList<>();
		x = 50;
		y = 50;
		//resize the image and create the icon
		ImageIcon ii = new ImageIcon(getClass().getResource("DroneSprite.png"));
		image = ii.getImage();
		w = 80;
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
		//x += dx;
		y += dy;
		for (Missile m: missiles)
			m.move();
	}

	/**
	 * fire()
	 * creates a new missile and adds it to the list.
	 */
	public void fire() {
		missiles.add(new Missile(x, y));
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
	
	//just for testing
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
