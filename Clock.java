/**
* @file: Clock.java
* @author: Dravid Joseph
* @date: 2/10/16
* @brief: Implementation file for Clock class
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Clock{

	private JFrame f;
	private JPanel p;
	private JButton b1;

	public Clock(){

		gui();

	}

	public void gui(){

		// Create window
		f = new JFrame("Clock");
		f.setVisible(true);
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program stops when x clicked

		// Create panel and make background white
		p = new JPanel();
		p.setBackground(Color.WHITE);

		// Create button and button action
		b1 = new JButton("Start Clock");
		b1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				JOptionPane.showMessageDialog(null, "working!");

			}

		});

		// add button to panel
		p.add(b1);

		// add panel to the frame
		f.add(p);

	}


	public static void main(String[] args){

			new Clock();

	}

}
