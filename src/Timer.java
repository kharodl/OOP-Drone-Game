/**
 * Timer.java
 *
 * @author Sebrianne Ferguson
 * Last Edited: 11/1/2018
 * Purpose: To change the position of the airplanes increment the x positions for the
 * airplanes every certain milliseconds.
 */

public class Timer {
	private long time;
	private long currentTime;

	/**
	 * airplaneTimer()
	 *
	 * @param resume - if this argument is true, then the timer knows to move the plane
	 *               if it's false, then the methods will recheck the condition and stop the movement
	 *               this would be useful in the case where the stopwatch has timed out.
	 */
	public void airplaneTimer(PlaneShape p, boolean resume) {
		time = System.currentTimeMillis();
		while (resume) {
			currentTime = System.currentTimeMillis();
			if (((currentTime - time) / 1000) % 60 == 0) { //a whole second has gone by
				if (p.getX() > 200) { //arbitrary number for the end of the screen, can change later
					p = new PlaneShape(0, p.getY(), p.getIconWidth()); //will draw a new plane
				}
				else { //in the middle of the screen
					p = new PlaneShape(p.getX() + 10, p.getY(), p.getIconWidth()); //will draw a new plane
				}
			}
		}


	}


}
