/**
 * Missile.java
 *
 * @author Lovejit Kharod, Sebrianne Ferguson
 * Last edited: November 19, 2018
 * Purpose: Allows for creation of missiles to shoot at the planes.
 */

class Missile extends FlyingObject {
	private static final int MISSILE_SPEED = 5;

	Missile(int x, int y) {
		super("resources/missile.png", 50, 30, x, y);
		dx = MISSILE_SPEED;
		dy = MISSILE_SPEED;
	}
	
}