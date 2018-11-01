package finalproject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestClass {

	JFrame frame;
	JPanel pane;
	Stopwatch s;
	
	public TestClass() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(400,400));
		s = new Stopwatch();
		pane = new JPanel();
		pane.setPreferredSize(new Dimension(400,400));
		pane.add(s);
		frame.add(pane);
	}
	
	public static void main(String[] args) {
		TestClass t = new TestClass();
		
		
		t.frame.setLayout(new FlowLayout());
		t.frame.setVisible(true);
		t.s.begin();
		
	}
	
}
