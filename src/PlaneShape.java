import java.awt.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.Icon;

/**
 * @author Adham Kamel
 * Last edited 11/1/2018
 * A car that can be moved around.
 * Purpose: creates the plane
 */
public class PlaneShape implements MoveableShape {
	/**
	 * Constructs a car item.
	 * 
	 * @param x
	 *            the left of the bounding rectangle
	 * @param y
	 *            the top of the bounding rectangle
	 * @param width
	 *            the width of the bounding rectangle
	 */
	public PlaneShape(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
	}

	public void move() {
		x+=10;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getIconWidth(){
		return width;
	}
	
	public void setX(int newX){
		x = newX;
	}

	public void draw(Graphics2D g2) {
		Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 6, width - 1, width / 3);
		// The bottom of the top vertical wing
		Point2D.Double r1 = new Point2D.Double(x + width * 5 / 6, y + width / 6);
		// The top point of top wing
		Point2D.Double r2 = new Point2D.Double(x + width * 5 / 6, y);
		// The bottom of the diagonal of the top wing
		Point2D.Double r3 = new Point2D.Double(x + width / 3, y + width / 6);
		// The top of the bottom wing vertical
		Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 2);
		// The bottom point of the bottom wing
		Point2D.Double r5 = new Point2D.Double(x + width * 5 / 6, y + width * 2 / 3);
		// The top point of the bottom diagonal wing
		Point2D.Double r6 = new Point2D.Double(x + width / 3, y + width / 2);
		// Top left corner of body
		Point2D.Double r7 = new Point2D.Double(x, y + width / 6);
		// The tip of the nose
		Point2D.Double r8 = new Point2D.Double(x - width / 3, y + width / 3);
		// The bottom left corner of the body
		Point2D.Double r9 = new Point2D.Double(x, y + width / 2);
		Line2D.Double topWingVertical = new Line2D.Double(r1, r2);
		Line2D.Double topWingDiagonal = new Line2D.Double(r2, r3);
		Line2D.Double bottomWingDiagonal = new Line2D.Double(r4, r5);
		Line2D.Double bottomWingVertical = new Line2D.Double(r5, r6);
		Line2D.Double topNose = new Line2D.Double(r7, r8);
		Line2D.Double bottomNose = new Line2D.Double(r8, r9);

		g2.draw(body);
		g2.draw(topWingVertical);
		g2.draw(topWingDiagonal);
		g2.draw(bottomWingDiagonal);
		g2.draw(bottomWingVertical);
		g2.draw(topNose);
		g2.draw(bottomNose);

	}
	

	private int x;
	private int y;
	private int width;
	

}
