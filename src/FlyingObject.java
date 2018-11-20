import javax.swing.*;
import java.awt.*;

abstract class FlyingObject extends JLabel {
	private final int w, h;
	private int x, y;
	int dx, dy;

	FlyingObject(String iconImage, int w, int h, int x, int y) {
		//resize the image and create the icon
		this.w = w;
		this.h = h;
		this.x = x;
		this.y = y;
		ImageIcon ii = new ImageIcon(new ImageIcon(getClass().getResource(iconImage)).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		//this will draw the image as the icon for this jlabel
		this.setIcon(ii);
	}

	/**
	 * move()
	 * changes the x and y position of the drone
	 */
	void move() {
		x += dx;
		y += dy;
	}

	void setX(int x) {
		this.x = x;
	}

	void setY(int y) {
		this.y = y;
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