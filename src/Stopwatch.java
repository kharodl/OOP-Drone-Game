import javax.swing.JLabel;
import java.util.concurrent.TimeUnit;

/**
 * Stopwatch.java
 *
 * @author Sebrianne Ferguson
 * Last edited: November 17th, 2018
 * Purpose: to keep track of time for the drone game. Gets displayed at the top of the
 * screen. Once the time in the stopwatch has reached a certain number, it will signal the game
 * to be over.
 * <p>
 * From the instructions:  time for the game is 1:30 minutes. If the drone does not hit more than
 * 2 airplanes during the time, then the game finishes, the user'stopwatch score is incremented by one,
 * and the time is reset.
 */

public class Stopwatch extends JLabel implements Runnable {
	private int seconds;
	private Scores s;
	private Thread timer;

	/**
	 * ctor
	 * initializes the original text of the jlabel
	 * initializes timePassed and seconds
	 */
	public Stopwatch(Thread timer) {
		s = new Scores();
		this.timer = timer;
		seconds = 0;
		this.setFont(this.getFont().deriveFont(30.0f)); //sets font size
		this.setText("Time: " + (90 - seconds++));
	}

	/**
	 * begin()
	 * the method that actually does the countdown
	 */
	public void begin() {
		while (seconds <= 90) { //for a minute and 1/2
			try {
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e) {
				System.err.println("Exception in stopwatch: " + e.getMessage());
			}
			this.setText("Time: " + (90 - seconds++));
			this.updateUI();
		}
		// Time up
		stopGame(true); // True when ended by time out = win

	}

	@Override // Runnable
	public void run() {
		this.begin();
	}

	public void stopGame(boolean win) {
		s.gameEnded(win);
		timer.interrupt();
		seconds = 0;

	}

}
