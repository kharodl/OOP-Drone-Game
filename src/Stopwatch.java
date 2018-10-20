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
 * 2 airplanes during the time, then the game finishes, the user’s score is incremented by one, 
 * and the time is reset.
 */

public class Stopwatch {
	
	boolean endGame;
	long time;
	int timeEllapsed;
	
	public Stopwatch() {
		time = System.currentTimeMillis(); //gets the current time in milliseconds
		timeEllapsed = 0;
		endGame = false;
	}
	
	public void begin() { //this would be the main timer but it's crappy rn
		while (System.currentTimeMillis() - time < 90) {// for a min and a 1/2
			timeEllapsed++;
		}
		
		endGame = true;
		gameEnded();
	}
	
	//because Lovejit's method is looking for a gameEnded() method
	public boolean gameEnded() {
		return endGame;
	}
	

}
