/**
 * Missile.java
 *
 * @author Lovejit Kharod
 * Last edited: November 19, 2018
 * Purpose: Allows for creation of missiles to shoot at the planes.
 */

class Missile extends FlyingObject {
	private static final int MISSILE_SPEED = 10;

	Missile(int x, int y) {
		super("src/resources/Missile.png", 50, 10, x, y);
		dx = MISSILE_SPEED;
	}
}