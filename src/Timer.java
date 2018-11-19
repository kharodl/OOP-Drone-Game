import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Timer.java
 *
 * @author Sebrianne Ferguson
 * Last Edited: 11/17/2018
 * Purpose: To change the position of the airplanes increment the x positions for the
 * airplanes every certain milliseconds.
 */

public class Timer implements Runnable{
	Airplane p;
	//boolean resume;
	Stopwatch s;
	PlanePanel x; //for updating the appearance
	
	/**
	 * ctor
	 * @param p
	 * @param s
	 * @param x
	 */
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
		int minus = s.getTime() -1;

		while (time != 0) {
				if (p.getX() < -80) { // arbitrary number for the end of the screen, can change later
					p.setX(700);
					p.setLocation(p.getX(), p.getY());
					x.paintComponent();
				} 
				else { // in the middle of the screen
					//will move a random distance, this way the planes are not in sync
					Random r = new Random();
					p.move(-r.nextInt(100));
					p.setLocation(p.getX(), p.getY());
					x.paintComponent();
				}
			
			time = s.getTime();
			
			//wait a little while before they move
			try {
				Random r = new Random();
			    Thread.sleep(r.nextInt(600));
			}
			catch(InterruptedException e){
			    Thread.currentThread().interrupt();
			}
		}

	}

	//for multi-threading
	@Override
	public void run() {
		this.airplaneTimer();
		
	}


}
