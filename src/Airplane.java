/**
 * Airplane.java
 *
 * @author Sebrianne Ferguson
 * Last edited: November 17th, 2018
 * Purpose: an airplane which will serve as an obstacle to the user while playing the game.
 * 			In addition, users can use the drone to shoot down airplanes with missiles.
 * picture from yopriceville.com
 */

class Airplane extends FlyingObject {
	/**
	 * Airplane()
	 * ctor
	 */
	public Airplane(int index) {
		super("resources/AirplanePic.png", 200, 100, -500, 50 + 80 * index);
	}

	void setSpeed(int speed) {
		dx = speed;
	}
}
