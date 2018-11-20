import java.util.ArrayList;

/**
 * Drone.java
 *
 * @author Lovejit Kharod, Sebrianne Ferguson
 * Last edited: November 19, 2018
 * Purpose: Attributes and methods of the drone, which will be controlled by the user.
 * 			Handled by the timer class in order to update the visual position of the drone.
 */

class Drone extends FlyingObject {
	private ArrayList<Missile> missiles;

	/**
	 * Drone()
	 * Creates a new ArrayList to store the missiles, and passes the appropriate values to FlyingObject constructor
	 */
	public Drone() {
		super("resources/DroneSprite.png", 80, 50, 50, 90);
		missiles = new ArrayList<>();
		//this will draw the image as the icon for this jlabel
	}

	/**
	 * move()
	 * Updates the location of the object using current dy value
	 */
	public void move() {
		if (getY() + dy < 500 && getY() + dy > 60)
			super.move();
		for (Missile m : missiles)
			m.move();
	}

	/**
	 * fire()
	 * Creates a new missile and adds it to the ArrayList missiles
	 */
	public void fire() {
		missiles.add(new Missile(getX() + 100, getY()));
	}
	
	/**
	 * used to add the missile to the gamepanel
	 * @return the last missile fired
	 */
	public Missile getMissile() {
		return missiles.get(missiles.size() -1);
	}
}
