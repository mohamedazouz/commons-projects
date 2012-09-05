import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass {

	/**
	 * Main class of the program
	 */
	public static void main(String[] args) {
		JFrame frame=new JFrame("This is my first JFrame");
		frame.setSize(300,200);
		
		JButton button=new JButton("Button A");
		button.setPreferredSize(new Dimension(120,50));
		button.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.blue));
		
		JPanel panel=new JPanel();
		panel.setBackground(Color.orange);
		
		panel.add(button);
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
