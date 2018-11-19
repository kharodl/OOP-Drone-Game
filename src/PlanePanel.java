import java.awt.*;

import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * PlanePanel.java
 * @author Sebrianne Ferguson
 * for the moving components of the game
 */

public class PlanePanel extends JPanel implements KeyListener{
	
	Drone d; //will draw the Drone

	/**
	 * ctor
	 * @param d
	 * @param planes
	 */
	public PlanePanel(Airplane[] planes, Drone d) {
		this.setFocusable(true);
		this.setSize(900, 600);
		this.setLayout(null);
		this.setOpaque(false);
		this.addKeyListener(this);
		this.d = d;
		this.add(d);
		for (Airplane p : planes)
			this.add(p);
	}
	
	/**
	 * paintComponent()
	 */
	public void paintComponent()
	{
		for (Component c: this.getComponents()) {
			c.setBounds(c.getX(), c.getY(), c.getWidth(), c.getHeight());
		}
	}
	
	/**
	 * keyReleased()
	 * @param e once the key is released, it will stop moving the drone.
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				d.dy = 0;
			case KeyEvent.VK_DOWN:
				d.dy = 0;
		}
	}
	
	/**
	 * keyPressed()
	 * @param e as long as the user is holding down a key, it will continue to change the
	 *          x or y position in the right direction.
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN: //if the user presses the down arrow
				d.dy = 5;
				if (d.getY() < 490) {
					d.move();
					d.setLocation(d.getX(), d.getY());
					this.paintComponent();
				}
				break;
				//this.repaint();
			case KeyEvent.VK_UP: //if the user presses the up arrow
				d.dy = -5;
				if (d.getY() > 60) {
					d.move();
					d.setLocation(d.getX(), d.getY());
					this.paintComponent();
				}
				break;
		}
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
