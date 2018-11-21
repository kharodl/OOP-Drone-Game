import javax.swing.*;

/**
 * Scores.java
 *
 * @author Lovejit Kharod
 * Last Edited: 10/31/2018
 * Purpose: Keeps track of how many matches the user has won out of total games.
 */

class Scores extends JLabel {
	private int total, won;

	/**
	 * Scores()
	 * Sets and displays the initial score as 0
	 */
	Scores() {
		super(0 + " / " + 0, CENTER);
		super.setFont(super.getFont().deriveFont(30.0f));
		total = won = 0;
	}

	/**
	 * gameEnded()
	 *
	 * @param win - boolean value defining if the game was won (true) or lost (false)
	 */
	void gameEnded(boolean win) {
		if (win)
			this.setText(++won + " / " + ++total);
		else
			this.setText(won + " / " + ++total);
		System.out.println(won + " / " + total);
		this.updateUI();
	}
}
