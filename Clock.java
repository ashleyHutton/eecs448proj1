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

	private JButton changeTime;
	private JButton stopWatch;
	private JButton timer;
	private JButton clearScreen;
	private JButton changeDate;
	private JButton zoomIn;
	private JButton zoomOut;

	private JLabel clockTime;

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

		clockTime = new JLabel("Hey. Here's our Label.");

		// Create buttons and button action
		changeTime = new JButton("Change Time");
		stopWatch = new JButton("Stopwatch");
		timer = new JButton("Timer");
		clearScreen = new JButton("Clear Screen");
		changeDate = new JButton("Change Date");
		zoomIn = new JButton("Zoom In");
		zoomOut = new JButton("Zoom Out");

		changeTime.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				JOptionPane.showInputDialog("Enter the time:");
			}
		});
		stopWatch.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				JOptionPane.showInputDialog(null, "working!");
			}
		});		
		timer.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				JOptionPane.showMessageDialog(null, "working!");
			}
		});		
		clearScreen.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				JOptionPane.showMessageDialog(null, "working!");
			}
		});		
		changeDate.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				JOptionPane.showInputDialog("Enter the Date:");
			}
		});
		zoomIn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				JOptionPane.showMessageDialog(null, "working!");
			}
		});
		zoomOut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				JOptionPane.showMessageDialog(null, "working!");
			}
		});

		// add button to panel
		p.add(changeTime);
		p.add(stopWatch);
		p.add(timer);
		p.add(clearScreen);
		p.add(changeDate);
		p.add(zoomIn);
		p.add(zoomOut);

		p.add(clockTime);

		// add panel to the frame
		f.add(p);

	}


	public static void main(String[] args){

			new Clock();

	}

}
