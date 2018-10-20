import java.awt.*;

/**
 * A shape that can be moved around.
 */
public interface MoveableShape {
	/**
	 * Draws the shape.
	 * 
	 * @param g2
	 *            the graphics context
	 */
	void draw(Graphics2D g2);

	/**
	 * Moves the shape. It is up to the shape to move itself, for example by
	 * tracking the time since its last movement, its position, and velocity.
	 */
	void move();
	
	/**
	 * Gets the current x coordinate of the shape based on left most line
	 * @return the x coordinate
	 */
	int getX();
	
	/**
	 * Sets the x coordinate of the shape based on left most line
	 * @param newX the new x coordinate
	 */
	void setX(int newX);
}