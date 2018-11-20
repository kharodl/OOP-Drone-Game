import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

	/**
	 * GamePanel
	 *
	 * @param drone - the drone to be added to the panel
	 * @param planes - list of planes to be added to the panel
	 */
	GamePanel(Drone drone, Airplane[] planes) {
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
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
			drone.dy = 0;
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
				drone.dy = 5;
				break;
			case KeyEvent.VK_UP: // up arrow
				drone.dy = -5;
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
