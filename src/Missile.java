/**
 * Missile.java
 *
 * @author Lovejit Kharod
 * Last edited: October 31st, 2018
 * Purpose: class that enables the drone to shoot at airplanes.
 */

class Missile extends FlyingObject {
	private static final int MISSILE_SPEED = 10;

	Missile(int x, int y) {
		super("src/resources/Missile.png", 50, 10, x, y);
		dx = MISSILE_SPEED;
	}
}