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
	long startingTime;
	long currentTime;
	
	/**
	 * ctor for the class
	 * sets the flag to see if the game is done to false
	 */
	public Stopwatch() {
		endGame = false;
	}
	
	/**
	 * begin()
	 * sets the startingTime and the currentTime
	 * each time it goes through this loop, current time will be updated, and 
	 * the loop will stop once 90 seconds have ellapsed (a minute and 1/2)
	 * then it will set endGame to true, signaling the end of the game
	 */
	public void begin() { //this would be the main timer but it's crappy rn
		startingTime = System.currentTimeMillis();
		currentTime = System.currentTimeMillis();
		while (currentTime - startingTime < 90) {// for a min and a 1/2
			currentTime = System.currentTimeMillis(); //update the current time
		}
		endGame = true;
		gameEnded();
	}
	
	//because Lovejit's method is looking for a gameEnded() method
	public boolean gameEnded() {
		return endGame;
	}
	

}
