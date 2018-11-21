import javax.swing.JLabel;
import java.util.concurrent.TimeUnit;

/**
 * Stopwatch.java
 *
 * @author Sebrianne Ferguson, Lovejit Kharod
 * Last edited: November 19, 2018
 * Purpose: to keep track of time for the drone game. Gets displayed at the top of the
 * screen. Once the time in the stopwatch has reached a certain number, it will signal the game
 * to be over.
 * <p>
 * From the instructions:  time for the game is 1:30 minutes. If the drone does not hit more than
 * 2 airplanes during the time, then the game finishes, the user'stopwatch score is incremented by one,
 * and the time is reset.
 */

class Stopwatch extends JLabel implements Runnable {
	private int seconds;
	private final Scores s;
	private Thread timerThread;
	boolean gameOver;

	/**
	 * Stopwatch()
	 * Initializes the text of the JLabel with seconds = 0
	 */
	public Stopwatch(Scores s) {
		this.s = s;
		gameOver = false;
		this.setFont(this.getFont().deriveFont(30.0f)); //sets font size
		this.setText("Time: " + (90 - seconds++));
	}

	void setTimerThread(Thread timerThread) {
		this.timerThread = timerThread;
	}

	/**
	 * begin()
	 * Handles the countdown timerThread
	 */
	private void begin() {
		seconds = 0;
		gameOver = false;
		this.setText("Time: " + (90 - seconds++));
		this.updateUI();
		while (!gameOver && seconds <= 90) { //for a minute and 1/2
			try {
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e) {
				System.err.println("Exception in stopwatch: " + e.getMessage());
			}
			if (gameOver)
				break;
			this.setText("Time: " + (90 - seconds++));
			this.updateUI();
		}
		if (!gameOver) // Time up
			timerThread.interrupt();

		System.out.println("sw ended");
		s.gameEnded(!gameOver); // gameOver is false only if time is up
	}

	@Override // Runnable
	public void run() {
		this.begin();
	}

}
