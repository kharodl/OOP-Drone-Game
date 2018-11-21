/**
 * Airplane.java
 *
 * @author Lovejit Kharod
 * Last edited: November 19, 2018
 * Purpose: An airplane which will serve as an obstacle to the user while playing the game.
 * In addition, users can use the drone to shoot down airplanes with missiles.
 * picture from yopriceville.com
 */

class Airplane extends FlyingObject {
	/**
	 * Airplane()
	 * Passes the appropriate values to the FlyingObject constructor
	 */
	public Airplane(int index) {
		super("resources/airplane.png", 200, 100, -500, 50 + 80 * index);
	}

	/**
	 * setSpeed()
	 * Sets a new speed for this Airplane to travel across the screen
	 *
	 * @param speed - the speed value passed into the Airplane
	 */
	void setSpeed(int speed) {
		dx = speed;
	}
}
