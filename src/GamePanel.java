import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import javax.swing.JPanel;

/**
 * GamePanel.java
 *
 * @author Sebrianne Ferguson
 * Last edited: November 19, 2018
 * Purpose: Contains the moving components of the game in a JPanel.
 */

class GamePanel extends JPanel implements KeyListener {

	private final Drone drone;
	HashSet<Component> missiles;

	/**
	 * GamePanel
	 *
	 * @param drone - the drone to be added to the panel
	 * @param planes - list of planes to be added to the panel
	 */
	GamePanel(Drone drone, Airplane[] planes) {
		missiles = new HashSet<>();
		this.drone = drone;
		add(drone);
		for (Airplane p : planes)
			add(p);
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
		for (Component c : getComponents()) {
			c.setBounds(c.getX(), c.getY(), c.getWidth(), c.getHeight());
		}
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
		Missile m;
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
				drone.dleft = -5 ;
				break;
			case KeyEvent.VK_W:
				m = new Missile(drone.getX() + 100, drone.getY(), -1);
				this.add(m);
				missiles.add(m);
				break;
			case KeyEvent.VK_S:
				m = new Missile(drone.getX() + 100, drone.getY(), 0);
				this.add(m);
				missiles.add(m);
				break;
			case KeyEvent.VK_X:
				m = new Missile(drone.getX() + 100, drone.getY(), 1);
				this.add(m);
				missiles.add(m);
				break;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
