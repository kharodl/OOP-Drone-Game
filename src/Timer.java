import java.awt.*;

import static java.lang.Thread.interrupted;

/**
 * Timer.java
 *
 * @author Sebrianne Ferguson
 * Last Edited: 11/17/2018
 * Purpose: To change the position of the airplanes increment the panel positions for the
 * airplanes every certain milliseconds.
 */

class Timer implements Runnable {
	private static final int FRAMERATE = 60;
	private static final int SPEED = 3;
	private final Airplane[] planes;
	private final PlanePanel panel; //for updating the appearance

	/**
	 * ctor
	 *
	 * @param planes - array of Airplanes to be handled and moved
	 * @param panel  -
	 */
	Timer(Airplane[] planes, PlanePanel panel) {
		this.planes = planes;
		this.panel = panel;
	}

	/**
	 * airplaneTimer()
	 */
	private void airplaneTimer() {
		while (!interrupted()) {
			int index = (int) (Math.random() * 6);
			if (planes[index].getX() < -200 && Math.random() < 0.5 / FRAMERATE) {   // Check if off screen + RNG chance
				planes[index].setX(1000);                                        // Move off right side of screen
				planes[index].setSpeed(-(int) (Math.random() * SPEED) - 2);      // Change speed to new random value
			}
			for (Component c : panel.getComponents()) {
				FlyingObject fo = (FlyingObject) c;
				fo.move();	// Update all FlyingObject locations
			}

			panel.paintComponent();

			try {
				Thread.sleep(1000/FRAMERATE);
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	//for multi-threading
	@Override
	public void run() {
		this.airplaneTimer();
	}
}
