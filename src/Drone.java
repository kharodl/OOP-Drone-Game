/**
 * Drone.java
 *
 * @author Lovejit Kharod, Sebrianne Ferguson
 * Last edited: November 19, 2018
 * Purpose: Attributes and methods of the drone, which will be controlled by the user.
 * Handled by the timer class in order to update the visual position of the drone.
 */

class Drone extends FlyingObject {
	int ddown, dup, dleft, dright;

	/**
	 * Drone()
	 * Creates a new ArrayList to store the missiles, and passes the appropriate values to FlyingObject constructor
	 */
	public Drone() {
		super("resources/drone.png", 80, 50, 100, 90);
		dx = 1;
		ddown = dup = dleft = dright = 0;
		//this will draw the image as the icon for this JLabel
	}

	/**
	 * move()
	 * Updates the location of the object using current dy value
	 */
	public void move() {
		dy = ddown + dup;
		dx = dleft + dright;
		if (dx == 0)
			dx = 1;
		if (getY() + dy < 500 && getY() + dy > 60 && getX() + dx < 700 && getX() + dx > 50)
			super.move();
	}
}
