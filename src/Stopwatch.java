//package finalproject;

import javax.swing.JLabel;

/**
 * Stopwatch.java
 * @author Sebrianne Ferguson
 * Last edited: October 20th, 2018
 * Purpose: to keep track of time for the drone game. Gets displayed at the top of the 
 * screen. Once the time in the stopwatch has reached a certain number, it will signal the game
 * to be over.
 * 
 * From the instructions:  time for the game is 1:30 minutes. If the drone does not hit more than 
 * 2 airplanes during the time, then the game finishes, the user�s score is incremented by one, 
 * and the time is reset.
 */

public class Stopwatch extends JLabel {
	long startTime;
	long timeRN;
	int seconds;
	Scores s;
	
	/**
	 * ctor
	 * initializes the original text of the jlabel
	 * initializes timePassed and seconds
	 * 
	 */
	public Stopwatch() {
		this.setText("Time: ");
		this.setFont(this.getFont().deriveFont(25.0f)); //sets font size
		timeRN = 0;
		seconds = 1;
		s = new Scores(); //works with lovejit's class
	}
	
	/**
	 * begin()
	 * the method that actually does the countdown
	 */
	public void begin() {
		startTime = System.currentTimeMillis(); //finds the current time
		while (seconds <= 90) { //for a minute and 1/2
			timeRN = System.currentTimeMillis(); //find the time right now
			//logic for the while loop condition:
			//the (timeRN - startTime) / 1000) % 60 extracts the second value 
			//asking if it's equal to seconds checks to see if a full second has passed
			//however, it would stop right when a full minute passed, so i had to change
			//the right side of the equation to seconds % 60.
			while (((timeRN - startTime) / 1000) % 60 != (seconds % 60)) {
				timeRN = System.currentTimeMillis(); 
				//so basically, while a whole second has not passed, keep updating the time
			}
			//once a second has passed, update the label text and increment seconds
			updateLabel();
			seconds++; 
		}
		
		//once the time is up, we update the score
		//in corralation with Lovejit's score code
		s.gameEnded(true); // calls with false if game lost, true if won
		
	}
	
	/**
	 * updateLabel()
	 * changes the text of the jlabel.
	 */
	public void updateLabel() {
		this.setText(null);
		this.setText("Time: " + (90 - seconds));
		this.updateUI();
	}

}
