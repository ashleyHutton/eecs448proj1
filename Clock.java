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

		f = new JFrame("Clock");
		f.setVisible(true);
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p = new JPanel();
		p.setBackground(Color.WHITE);

		b1 = new JButton("Start Clock");
		b1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				JOptionPane.showMessageDialog(null, "working!");

			}

		});

		p.add(b1);

		f.add(p);
		
	}


	public static void main(String[] args){

			new Clock();

	}

}	