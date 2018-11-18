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
	
	Timer(Airplane p, Stopwatch s){
		this.p = p;
		this.s = s;
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
			if (p.getX() < 100) { // arbitrary number for the end of the screen, can change later
				p.setVisible(false);
				p.setBounds(50 * 14, p.getY(), p.getWidth(), p.getHeight());
				p.setVisible(true);
			} else { // in the middle of the screen
				p.setBounds(p.getX() + 10, p.getY(), p.getWidth(), p.getHeight());
			}
			
			time = s.getTime();
		}

	}

	@Override
	public void run() {
		this.airplaneTimer();
		
	}


}
