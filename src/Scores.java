package finalproject;

/**
 * Scores.java
 * @author Lovejit Kharod
 * Last Edited: 10/31/2018
 * Purpose: to keep track of how many matches the user has won and also how many games they have played.
 */

import javax.swing.*;

public class Scores extends JLabel
{
	private int total, won;

	/**
	 * ctor
	 * sets the initial scores and initial display
	 */
	public Scores()
	{
		super(0 + " / " + 0, CENTER);
		total = won = 0;
		//super.setAlignmentY(TOP);
	}

	/**
	 * gameEnded()
	 * @param win - only true if the user played for 1.5 minutes and didn't hit anything
	 */
	public void gameEnded(boolean win)
	{
		if (win)
			won++;
		total++;
		super.setText(won + " / " + total);
	}
}
