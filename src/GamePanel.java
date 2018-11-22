import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import javax.swing.*;

/**
 * GamePanel.java
 *
 * @author Sebrianne Ferguson
 * Last edited: November 19, 2018
 * Purpose: Contains the moving components of the game in a JPanel.
 */

class GamePanel extends JPanel implements KeyListener {

	private final static int MISSILE_MAX = 5; // Number of missiles that can be on screen at once
	private final Drone drone;
	private final Lock _mutex;
	final LinkedList<Component> missiles;
	int fireDelayState; // 0 - free to fire, 1 - fired, 2 - waiting

	/**
	 * GamePanel
	 *
	 * @param drone  - the drone to be added to the panel
	 * @param planes - list of planes to be added to the panel
	 */
	GamePanel(Drone drone, Airplane[] planes, Lock _mutex) {
		this.drone = drone;
		add(drone);
		for (Airplane p : planes)
			add(p);
		missiles = new LinkedList<>();
		this._mutex = _mutex;
		fireDelayState = 0;
		setFocusable(true);
		setSize(900, 600);
		setLayout(null);
		setOpaque(false);
		addKeyListener(this);
	}

	/**
	 * paintComponent()
	 */
	void paintComponent() {
		_mutex.lock();
		for (Component c : getComponents()) {
			c.setBounds(c.getX(), c.getY(), c.getWidth(), c.getHeight());
		}
		_mutex.unlock();
	}

	/**
	 * keyReleased()
	 *
	 * @param e - once the key is released, it will stop moving the drone.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN: // down arrow
				drone.ddown = 0;
				break;
			case KeyEvent.VK_UP: // up arrow
				drone.dup = 0;
				break;
			case KeyEvent.VK_RIGHT: // right arrow
				drone.dright = 0;
				break;
			case KeyEvent.VK_LEFT: // left arrow
				drone.dleft = 0;
				break;
		}
	}

	/**
	 * keyPressed()
	 *
	 * @param e - once the key is pressed, the direction is set to up or down.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN: // down arrow
				drone.ddown = 5;
				break;
			case KeyEvent.VK_UP: // up arrow
				drone.dup = -5;
				break;
			case KeyEvent.VK_RIGHT: // right arrow
				drone.dright = 5;
				break;
			case KeyEvent.VK_LEFT: // left arrow
				drone.dleft = -5;
				break;
			case KeyEvent.VK_W:
				if (missiles.size() < MISSILE_MAX && fireDelayState == 0) {
					_mutex.lock();
					missiles.push(new Missile(drone.getX() + 100, drone.getY(), -1));
					this.add(missiles.peek());
					_mutex.unlock();
					fireDelayState = 1;
				}
				break;
			case KeyEvent.VK_S:
				if (missiles.size() < MISSILE_MAX && fireDelayState == 0) {
					_mutex.lock();
					missiles.push(new Missile(drone.getX() + 100, drone.getY(), 0));
					this.add(missiles.peek());
					_mutex.unlock();
					fireDelayState = 1;
				}
				break;
			case KeyEvent.VK_X:
				if (missiles.size() < MISSILE_MAX && fireDelayState == 0) {
					_mutex.lock();
					missiles.push(new Missile(drone.getX() + 100, drone.getY(), 1));
					this.add(missiles.peek());
					_mutex.unlock();
					fireDelayState = 1;
				}
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
