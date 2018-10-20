import javax.swing.*;

public class Scores extends JLabel
{
	private int total, won;

	public Scores()
	{
		super(0 + " / " + 0, CENTER);
		total = won = 0;
		//super.setAlignmentY(TOP);
	}

	public void gameEnded(boolean win)
	{
		if (win)
			won++;
		total++;
		super.setText(won + " / " + total);
	}
}
