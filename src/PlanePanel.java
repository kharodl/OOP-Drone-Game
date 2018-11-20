import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * PlanePanel.java
 *
 * @author Sebrianne Ferguson
 * for the moving components of the game
 */

class PlanePanel extends JPanel implements KeyListener {

	private final Drone drone;

	/**
	 * ctor
	 *
	 * @param drone
	 * @param planes
	 */
	PlanePanel(Airplane[] planes, Drone drone) {
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
	 * @param e once the key is released, it will stop moving the drone.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
			drone.dy = 0;
	}

	/**
	 * keyPressed()
	 *
	 * @param e as long as the user is holding down a key, it will continue to change the
	 *          x or y position in the right direction.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN: //if the user presses the down arrow
				drone.dy = 5;
				break;
			case KeyEvent.VK_UP: //if the user presses the up arrow
				drone.dy = -5;
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
