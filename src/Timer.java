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
	private static final int FRAME_RATE = 60;
	private static final int SPEED = 3;
	private final Airplane[] planes;
	private final PlanePanel panel;
	private final Stopwatch sw;

	/**
	 * ctor
	 *
	 * @param planes - array of Airplanes to be handled and moved
	 * @param panel  - JPanel holding the content of the game
	 */
	Timer(Airplane[] planes, PlanePanel panel, Stopwatch sw) {
		this.planes = planes;
		this.panel = panel;
		this.sw = sw;
	}

	/**
	 * airplaneTimer()
	 */
	private void airplaneTimer() {
		while (!interrupted()) {
			int index = (int) (Math.random() * 6);
			if (planes[index].getX() < -200 && Math.random() < 0.5 / FRAME_RATE) {   // Check if off screen + RNG chance
				planes[index].setX(1000);                                        // Move off right side of screen
				planes[index].setSpeed(-(int) (Math.random() * SPEED) - 2);      // Change speed to new random value
			}
			for (Component c : panel.getComponents()) {
				FlyingObject fo = (FlyingObject) c;
				fo.move();    // Update all FlyingObject locations
				if (fo != panel.getComponent(0) && c.getBounds().intersects(panel.getComponent(0).getBounds()))
					sw.stopGame(false);
			}

			panel.paintComponent();

			try {
				Thread.sleep(1000 / FRAME_RATE);
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
