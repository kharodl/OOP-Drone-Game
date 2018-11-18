/**
 * Timer.java
 *
 * @author Sebrianne Ferguson
 * Last Edited: 11/1/2018
 * Purpose: To change the position of the airplanes increment the x positions for the
 * airplanes every certain milliseconds.
 */

public class Timer implements Runnable{
	private long time;
	private long currentTime;
	Airplane p;
	//boolean resume;
	Stopwatch s;
	PlanePanel x;
	
	Timer(Airplane p, Stopwatch s, PlanePanel x){
		this.p = p;
		this.s = s;
		this.x = x;
	}

	/**
	 * airplaneTimer()
	 *
	 * @param resume - if this argument is true, then the timer knows to move the plane
	 *               if it's false, then the methods will recheck the condition and stop the movement
	 *               this would be useful in the case where the stopwatch has timed out.
	 */
	public void airplaneTimer() {
		
		int time = s.getTime();

		while (time != 0) {
			if (p.getX() < -80) { // arbitrary number for the end of the screen, can change later
				p.setLocation(700, p.getY());
				x.paintComponent();
			} 
			else { // in the middle of the screen
				p.move(-30);
				p.setLocation(p.getX(), p.getY());
				x.paintComponent();
			}
			
			time = s.getTime();
		}

	}

	@Override
	public void run() {
		this.airplaneTimer();
		
	}


}
