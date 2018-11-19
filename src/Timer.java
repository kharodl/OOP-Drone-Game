import static java.lang.Thread.interrupted;

/**
 * Timer.java
 *
 * @author Sebrianne Ferguson
 * Last Edited: 11/17/2018
 * Purpose: To change the position of the airplanes increment the panel positions for the
 * airplanes every certain milliseconds.
 */

public class Timer implements Runnable {
	private final int DELAY = 100;
	private final int SPEED = 20;
	private Airplane[] planes;
	private PlanePanel panel; //for updating the appearance

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
	public void airplaneTimer() {
		while (!interrupted()) {
			for (Airplane p : planes) {
				// in the middle of the screen
				//will move a random distance, this way the planes are not in sync
				int index = (int) (Math.random() * 6);
				if (planes[index].getX() < -200 && Math.random() < 0.5 / DELAY) {
					planes[index].setX(700);
					planes[index].setSpeed(-(int) (Math.random() * SPEED) - 1);
				}
				p.move();
				panel.paintComponent();
			}

			//wait a little while before they move
			try {
				Thread.sleep((int) (Math.random() * DELAY));
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
