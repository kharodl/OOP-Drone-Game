import static java.lang.Thread.interrupted;
import java.awt.*;
import java.util.ArrayList;

/**
 * Timer.java
 *
 * @author Sebrianne Ferguson, Lovejit Kharod
 * Last edited: November 19, 2018
 * Purpose: Moves and updates the positions of the components of GamePanel.
 * Handles collision between said components.
 */

class Timer implements Runnable {
	private static final int FRAME_RATE = 60;
	private static final int SPEED = 3;
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
	Timer(Airplane[] planes, GamePanel panel, Stopwatch sw, Scores s) {
		this.planes = planes;
		this.panel = panel;
		this.sw = sw;
		this.s = s;
	}

	/**
	 * airplaneTimer()
	 * Iterates through the existing airplanes in a random manner, sometimes moving them to the right side
	 * Handles moving and refreshing locations of components in the panel
	 */
	@SuppressWarnings("deprecation")
	private void airplaneTimer() {
		int lives = 3;
		s.updateLives(lives--);
		while (!interrupted() && lives >= 0) {
			int index = (int) (Math.random() * 6);
			if (planes[index].getX() < -200 && Math.random() < 0.5 / FRAME_RATE) {   // Check if off screen + RNG chance
				planes[index].setX(1000);                                        // Move off right side of screen
				planes[index].setSpeed(-(int) (Math.random() * SPEED) - 2);      // Change speed to new random value
			}
			for (Component c : panel.getComponents()) {
				FlyingObject fo = (FlyingObject) c;
				if (!fo.isDisabled()) {
					fo.move();    // Update all FlyingObject locations
				}
				if (c != panel.getComponent(0)) {
					if (c.getBounds().intersects(panel.getComponent(0).getBounds())) {
						s.updateLives(lives--);
						fo.setX(-200);
					}
					
				ArrayList<Missile> toRemove = new ArrayList<Missile>();
				for (Component missile : panel.missiles) {
					Missile m = (Missile) missile;
						if (c.getBounds().intersects(m.getBounds()) && !c.getClass().equals(m.getClass())) {
							fo.setX(-200);
							m.setVisible(false);
							m.disable();
							toRemove.add(m);
							//panel.remove(missile);
							//panel.missiles.remove(missile);
						}
				}
				
				panel.missiles.removeAll(toRemove);

				}
			}

			panel.paintComponent();

			try {
				Thread.sleep(1000 / FRAME_RATE);
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
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
