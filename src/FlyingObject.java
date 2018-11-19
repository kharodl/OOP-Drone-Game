import javax.swing.*;
import java.awt.*;

public abstract class FlyingObject extends JLabel {
	private int w, h, x, y;
	int dx, dy;

	public FlyingObject(String iconImage, int w, int h, int x, int y) {
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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
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