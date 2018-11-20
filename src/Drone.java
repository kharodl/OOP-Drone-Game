import java.util.ArrayList;

/**
 * Drone.java
 *
 * @author Lovejit Kharod
 * Last edited: October 31st, 2018
 * Purpose: attributes and methods of the drone, which will be controlled by the user.
 * works in conjunction with the timer class in order to update the position of the drone.
 */

class Drone extends FlyingObject {
	private ArrayList<Missile> missiles;

	/**
	 * Drone()
	 * creates a new arraylist to store the missiles, creates an image icon, inits w,h,x and y
	 */
	public Drone() {
		super("resources/DroneSprite.png", 80, 50, 50, 90);
		missiles = new ArrayList<>();
		//this will draw the image as the icon for this jlabel
	}

	public void move() {
		if (getY() + dy < 500 && getY() + dy > 60)
			super.move();
	}

	/**
	 * fire()
	 * creates a new missile and adds it to the list.
	 */
	public void fire() {
		missiles.add(new Missile(getX(), getY()));
	}
}
