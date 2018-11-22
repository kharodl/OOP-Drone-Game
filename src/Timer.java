import static java.lang.Thread.interrupted;

import java.awt.*;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;

/**
 * Timer.java
 *
 * @author Sebrianne Ferguson, Lovejit Kharod
 * Last edited: November 19, 2018
 * Purpose: Moves and updates the positions of the components of GamePanel.
 * Handles collision between said components.
 */

class Timer implements Runnable {
	private static final int FRAME_RATE = 60;			// Frames per second
	private static final int SPEED = 3;					// Pixels per frame of Airplanes
	private static final int RANDOM_SPEED = 2;			// Pixels per frame over base speed randomized
	private static final int MISSILE_DELAY = 10;		// Firing delay in frames of Missiles
	private static final int DRONE_FREEZE_TIME = 300;	// Drone freeze time in frames when hit by an Airplane
	private final Lock _mutex;
	private final Airplane[] planes;
	private final GamePanel panel;
	private final Stopwatch sw;
	private final Scores s;

	/**
	 * Timer()
	 * Constructs a timer
	 *
	 * @param planes - array of Airplanes to be moved every tick
	 * @param panel  - JPanel holding the game play content
	 * @param sw     - Stopwatch object to allow for game end handling
	 */
	Timer(Airplane[] planes, GamePanel panel, Stopwatch sw, Scores s, Lock _mutex) {
		this.planes = planes;
		this.panel = panel;
		this.sw = sw;
		this.s = s;
		this._mutex = _mutex;
	}

	/**
	 * airplaneTimer()
	 * Iterates through the existing airplanes in a random manner, sometimes moving them to the right side
	 * Handles moving and refreshing locations of components in the panel
	 */
	private void airplaneTimer() {
		int lives = 3;
		s.updateLives(lives--);
		int droneFrozen = 0;
		int fireDelayed = 0;
		HashSet<Component> toRemove = new HashSet<>();
		while (!interrupted() && lives >= 0) {
			int index = (int) (Math.random() * 6);
			if (planes[index].getX() < -200 && Math.random() < 0.5 / FRAME_RATE) {   // Check if off screen + RNG chance
				planes[index].setX(1000);                                        // Move off right side of screen
				planes[index].setSpeed(-(int) (Math.random() * SPEED) - RANDOM_SPEED);      // Change speed to new random value
			}
			if (panel.fireDelayState == 1) {
				fireDelayed = MISSILE_DELAY; // Frames per second * seconds
				panel.fireDelayState = 2;
			}
			else if (--fireDelayed <= 0) {
				panel.fireDelayState = 0;
			}
			for (Component c : panel.getComponents()) {
				FlyingObject fo = (FlyingObject) c;
				if (fo.getClass() != Drone.class || --droneFrozen <= 0)
					fo.move();    // Update all FlyingObject locations
				if (c.getClass() != Drone.class && c.getClass() != Missile.class) {
					if (c.getBounds().intersects(panel.getComponent(0).getBounds())) {
						droneFrozen = DRONE_FREEZE_TIME; // Frames per second * seconds
						s.updateLives(lives--);
						fo.setX(-200);
					}
					try {
						_mutex.lock();
						for (Component missile : panel.missiles) {
							if (missile.getX() > 1000 || missile.getY() < 50 || missile.getY() > 525) {
								toRemove.add(missile);
							}
							if (c.getBounds().intersects(missile.getBounds()) && !c.getClass().equals(missile.getClass())) {
								fo.setX(-200);
								toRemove.add(missile);
							}
						}
					}
					catch (Exception e) {
						System.err.println("Exception collecting missiles: " + e.getMessage());
					}
					finally {
						_mutex.unlock();
					}
				}
			}
			for (Component missile : toRemove) {
				missile.setVisible(false);
				try {
					_mutex.lock();
					panel.remove(missile);
					panel.missiles.remove(missile);
				}
				catch (Exception e) {
					System.err.println("Exception clearing missiles: " + e.getMessage());
				}
				finally {
					_mutex.unlock();
				}
			}
			toRemove.clear();

			panel.paintComponent();

			try {
				Thread.sleep(1000 / FRAME_RATE);
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		try {
			_mutex.lock();
			for (Component missile : panel.missiles) {
				missile.setVisible(false);
				panel.remove(missile);
			}
			panel.missiles.clear();
		}
		catch (Exception e) {
			System.err.println("Exception clearing missiles at end of game: " + e.getMessage());
		}
		finally {
			_mutex.unlock();
		}
		for (Component c : panel.getComponents()) {
			FlyingObject fo = (FlyingObject) c;
			if (fo != panel.getComponent(0))
				fo.setX(-200);
		}
		if (lives <= 0)
			sw.gameOver = true;
	}

	//for multi-threading
	@Override
	public void run() {
		this.airplaneTimer();
	}
}
