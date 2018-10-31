import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Drone extends JLabel {
	private int w, h, x, y, dx, dy;
	private Image image;
	private ArrayList<Missile> missiles;

	public Drone() {
		missiles = new ArrayList<>();
		ImageIcon ii = new ImageIcon("src/resources/DroneSprite.png");
		image = ii.getImage();
		w = image.getWidth(null);
		h = image.getHeight(null);
		x = 50;
		y = 50;
	}

	public void move() {
		x += dx;
		y += dy;
	}

	public void fire() {
		missiles.add(new Missile(x, y));
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				dx = -2;
			case KeyEvent.VK_RIGHT:
				dx = 2;
			case KeyEvent.VK_UP:
				dy = -2;
			case KeyEvent.VK_DOWN:
				dy = 2;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				dx = 0;
			case KeyEvent.VK_RIGHT:
				dx = 0;
			case KeyEvent.VK_UP:
				dy = 0;
			case KeyEvent.VK_DOWN:
				dy = 0;
		}
	}

	public Image getImage() {
		return image;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}
}
