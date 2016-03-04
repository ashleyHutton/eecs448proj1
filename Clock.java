/**
* @file: Clock.java
* @author: Ashley Hutton, Hannah Johnson, and Rabel Marte
* @date: 2/10/16
* @brief: Implementation file for Clock class
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clock{

	private JFrame f;
	private JPanel p;
	JTextField timeF;
//	JTextField timeS;


	private JButton changeTime;
	private JButton stopWatch;
	private JButton timer;
	private JButton clearScreen;
	private JButton changeDate;
	private JButton zoomIn;
	private JButton zoomOut;

	private JLabel clockTime;
	public Time timeClock = new Time();
	public Time stopwatch = new Time();
	public Time timerClock = new Time();

	private int m_month = 1;
	private int m_day = 3;

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

		// Create clock text field
		timeF = new JTextField(10);
		timeF.setEditable(false);
		timeF.setFont(new Font("Arial", Font.PLAIN, 30));

//		timeS = new JTextField(10);
	//	timeS.setEditable(false);
		//.setFont(new Font("Arial", Font.PLAIN, 30));

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

				String userTime = JOptionPane.showInputDialog("Enter the time:");

				/** regular expression looking for the format "##:##:## AM/PM in 12hr */
			    String timePattern_12hr = "(^[1-9]|1[0-2]):([0-5][0-9]):([0-5][0-9])[ ]?(?i)(am|pm)$";
			    /** regular expression looking for the format "##:##:## in 24hr */
			    String timePattern_24hr = "(^[01]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

			    // Create a Pattern object
			    Pattern r = Pattern.compile(timePattern_24hr);

			      // Now create matcher object.
			    Matcher m = r.matcher(userTime);


		    	if (m.find( )) {
		        	System.out.println("Found value: " + m.group(0) );
		        	System.out.println("Found value: " + m.group(1) );
		        	System.out.println("Found value: " + m.group(2) );
		       		System.out.println("Found value: " + m.group(3) );

							timeClock.setSecond(Integer.parseInt(m.group(3)));
							timeClock.setMinute(Integer.parseInt(m.group(2)));
							timeClock.setHour(Integer.parseInt(m.group(1)));
		      	}
		        else {
		        	System.out.println("NO MATCH");
				}
			}
		});

		stopWatch.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				stopwatch.setSecond(0);
				stopwatch.setMinute(0);
				stopwatch.setHour(0);

				stopwatch.updateSeconds();

					timeF.setText(stopwatch.getHour() + ":" +stopwatch.getMinute() +":" + stopwatch.getSecond());

				//JOptionPane.showInputDialog(null, "working!");
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

				String userDate = JOptionPane.showInputDialog("Enter the Date (MM/DD):");

				// regular expression to find the date in the format MM/DD
				String datePattern = "(^0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])$";

				// Create a Pattern object
			    Pattern r = Pattern.compile(datePattern);

			    // Now create matcher object.
			    Matcher m = r.matcher(userDate);

			    if (m.find()){

			    	System.out.println(m.group(0));
			    	System.out.println(m.group(1));
			    	System.out.println(m.group(2));

			    	// set the month and day to the given input
			    	m_month = Integer.parseInt(m.group(1));
			    	m_day = Integer.parseInt(m.group(2));

			    }

			    else{

			    	System.out.println("No match");
			    }
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
		p.add(timeF);
		//p.add(timeS);

		p.add(clockTime);

		// add panel to the frame
		f.add(p);

		// Initialize timer
		Timer t = new Timer(1000, new Listener());
		t.start();

		//Timer sw = new Timer(1000, new stopwatchListener());
		//sw.start();

	}


	class stopwatchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stopwatch.updateSeconds();
			timeF.setText(stopwatch.getHour() + ":" +stopwatch.getMinute() +":" + stopwatch.getSecond());
		}

	}

	class Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

				timeClock.updateSeconds();

				// print time to Screen
				timeF.setText(timeClock.getHour() + ":" + timeClock.getMinute() + ":" + timeClock.getSecond());
			}
		}


	public static void main(String[] args){

			new Clock();


	}

}
