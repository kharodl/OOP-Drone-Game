import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * PlanePanel.java
 * @author Sebrianne Ferguson
 * for the moving components of the game
 */

public class PlanePanel extends JPanel implements KeyListener{
	
	Drone d; //will draw the Drone
	Airplane[] planes;
	
	public PlanePanel(Drone d, Airplane[] planes) {
		this.setFocusable(true);
		
		this.setSize(900, 600);
		this.setLayout(null);
		this.setOpaque(false);
		this.d = d;
		this.addKeyListener(this);
		this.planes = planes;
		
		this.add(d);
		
		for (Airplane plane: planes) {
			this.add(plane, -1);
		}
	}
	
	
	/**
	 * paintComponent()
	 * @param d - the drone
	 * @param planes - all the planes we want to draw
	 */
	public void paintComponent()
	{
	
		d.setBounds(d.getX(), d.getY(), d.getWidth(), d.getHeight());
		for (Airplane plane: planes) {
			plane.setBounds(plane.getX(), plane.getY(), plane.getWidth(), plane.getHeight());
			
		}
		
		
		
	}
	
	/**
	 * keyReleased()
	 *
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
	 *
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
		//repaint();
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
