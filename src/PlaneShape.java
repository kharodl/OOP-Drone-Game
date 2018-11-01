package finalproject;

/**
 * PlaneShape.java
 * @author Adhman Kamel
 * Last Edited: 10/31/2018
 * Purpose of the class: provides method to draw the general shape of an airplane.
 */

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class PlaneShape { //take out implements MoveableShape
	
	private int x;
	private int y;
	private int width;
	
	/**
	 * Constructs a plane.
	 * @param x the left of the bounding rectangle
	 * @param y the top of the bounding rectangle
	 * @param width the width of the bounding rectangle
	 */
	public PlaneShape(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
	}

	/**
	 * move()
	 * changes the x position by 10
	 */
	public void move() {
		x+=10;
	}
	
	/**
	 * getX()
	 * @return x
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * setX()
	 * @param newX - the new value to set x to
	 */
	public void setX(int newX){
		x = newX;
	}

	/**
	 * draw()
	 * @param g2
	 */
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
		Point2D.Double r5 = new Point2D.Double(x + width * 5 / 6, y + width *2 / 3);
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
}