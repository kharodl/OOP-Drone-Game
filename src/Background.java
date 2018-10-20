import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Background {

	public Background(){
		JFrame frame = new JFrame();
		frame.setBounds(50, 50, 600, 300);
		
		// Having the image to be the size of the JFrame
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon picture = new ImageIcon(dimg);
		JLabel image = new JLabel(picture);
		
		frame.setLayout(new FlowLayout());
		frame.add(image);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		Background background = new Background();
	}
}
