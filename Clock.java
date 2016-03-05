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

	// create frame
	private JFrame f;

	// create panels for different views
	private JPanel panelCont;
	private JPanel p;
	private JPanel stopWatchPanel;
	private JPanel timerPanel;
	private JPanel clearScreenPanel;

	// create layout
	CardLayout c1 = new CardLayout();

	// create text fields for time, timer, and stopwatch
	JTextField timeF;
	JTextField timerF;
	JTextField stopWatchF;
	JTextField dateF;
	//	JTextField timeS;

	// create buttons
	private JButton changeTime;
	private JButton stopWatch;
	private JButton timer;
	private JButton clearScreen;
	private JButton changeDate;
	private JButton zoomIn;
	private JButton zoomOut;
	private JButton switchToClock1;
	private JButton switchToClock2;
	private JButton redisplayScreen;

	private JLabel clockTime;

	// create objects for time, timer and stopwatch
	public Time timeClock = new Time();
	public Time stopwatch = new Time();
	public Time timerClock = new Time();
	public DayOfWeek week = new DayOfWeek();

	// default zoom and calendar date
	private int m_zoomCounter = 3;
	private int m_month = 1;
	private int m_day = 3;

	private Boolean isEnable;

	public Clock(){

		gui();

	}

	public int getZoomCounter() {
		return m_zoomCounter;
	}

	public void setZoomCounter(int counter) {
		m_zoomCounter = counter;
	}


	public void gui(){

		clockTime = new JLabel("Hey. Here's our Label.");

		// Create window
		f = new JFrame("Clock");
		f.setVisible(true);
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program stops when x clicked

		panelCont = new JPanel();
		panelCont.setLayout(c1);
		// add panel to the frame
		f.add(panelCont);

		// Create panel and make background white
		p = new JPanel();
		p.setBackground(Color.WHITE);

		// Create buttons and button action
		changeTime = new JButton("Change Time");
		stopWatch = new JButton("Stopwatch");
		timer = new JButton("Timer");
		clearScreen = new JButton("Clear Screen");
		changeDate = new JButton("Change Date");
		zoomIn = new JButton("Zoom In");
		zoomOut = new JButton("Zoom Out");
		switchToClock1 = new JButton("Back to Clock");
		switchToClock2 = new JButton("Back to Clock");
		redisplayScreen = new JButton("Redisplay Screen");

		// Create clock text field
		timeF = new JTextField(10);
		timeF.setEditable(false);
		timeF.setFont(new Font("Arial", Font.PLAIN, 30));

		// Create timer text field
		timerF = new JTextField(10);
		timerF.setEditable(false);
		timerF.setFont(new Font("Arial", Font.PLAIN, 30));

		// Create stopwatch text field
		stopWatchF = new JTextField(10);
		stopWatchF.setEditable(false);
		stopWatchF.setFont(new Font("Arial", Font.PLAIN, 30));

		// Create a calendar text field
		dateF = new JTextField(10);
		dateF.setEditable(false);
		dateF.setFont(new Font("Arial", Font.PLAIN, 30));

		// add button to panel
		p.add(changeTime);
		p.add(stopWatch);
		p.add(timer);
		p.add(clearScreen);
		p.add(changeDate);
		p.add(zoomIn);
		p.add(zoomOut);

		p.add(timeF);
		p.add(dateF);
		//p.add(timeS);

		// add clock text field
		p.add(clockTime);

		// create stopwatch panel and add necessary fields and buttons
		stopWatchPanel = new JPanel();
		stopWatchPanel.setBackground(Color.WHITE);

		stopWatchPanel.add(switchToClock1);
		stopWatchPanel.add(stopWatchF);

		// create timer panel and add necessary fields and buttons
		timerPanel = new JPanel();
		timerPanel.setBackground(Color.WHITE);

		timerPanel.add(switchToClock2);
		timerPanel.add(timerF);

		// create panel to hide the display
		clearScreenPanel = new JPanel();
		clearScreenPanel.add(redisplayScreen);

		// add panels to card layout
		panelCont.add(p, "1");
		panelCont.add(stopWatchPanel, "2");
		panelCont.add(timerPanel, "3");
		panelCont.add(clearScreenPanel, "4");
		c1.show(panelCont, "1");


//		timeS = new JTextField(10);
	//	timeS.setEditable(false);
		//.setFont(new Font("Arial", Font.PLAIN, 30));


		switchToClock1.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e){
					// return to main page
					c1.show(panelCont, "1");
				}
		});

		switchToClock2.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e){
					// return to main page
					c1.show(panelCont, "1");
				}
		});
		redisplayScreen.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e){
					// return to main page
					c1.show(panelCont, "1");
				}
		});

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

				stopWatchF.setText(stopwatch.getHour() + ":" +stopwatch.getMinute() +":" + stopwatch.getSecond());

				// go to stopwatch page
				c1.show(panelCont, "2");

				//JOptionPane.showInputDialog(null, "working!");
			}
		});
		timer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String userTimer = JOptionPane.showInputDialog("Enter the time:");

			    /** regular expression looking for the format "##:##:## in 24hr */
			    String timerPattern = "(^[01]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

			    // Create a Pattern object
			    Pattern r = Pattern.compile(timerPattern);

			      // Now create matcher object.
			    Matcher m = r.matcher(userTimer);


		    	if (m.find( )) {
		        	System.out.println("Found value: " + m.group(0) );
		        	System.out.println("Found value: " + m.group(1) );
		        	System.out.println("Found value: " + m.group(2) );
		       		System.out.println("Found value: " + m.group(3) );

		       		timerClock.setSecond(Integer.parseInt(m.group(3)));
					timerClock.setMinute(Integer.parseInt(m.group(2)));
					timerClock.setHour(Integer.parseInt(m.group(1)));

					timerClock.updateSecondsTimer();

					timerF.setText(timerClock.getHour() + ":" +timerClock.getMinute() +":" + timerClock.getSecond());

					// go to timer page
					c1.show(panelCont, "3");


		      	}
		        else {
		        	System.out.println("NO MATCH");
				}
			}
		});


		clearScreen.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				c1.show(panelCont, "4");
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

					// Set member variables in DayOfWeek object and call calculateDayOfWeek
					week.setMonth(m_month);
					week.setDay(m_day);

					week.calculateDayOfWeek();
					dateF.setText(week.getDayOfWeek());
			    }

			    else{

			    	System.out.println("No match");
			    }
			}
		});
		zoomIn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				int counter = getZoomCounter();

				if(counter == 1) {
					setZoomCounter(2);
					timeF.setFont(new Font("Arial", Font.PLAIN, 20));
				}
				else if(counter == 2) {
					setZoomCounter(3);
					timeF.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				else if(counter == 3) {
					setZoomCounter(4);
					timeF.setFont(new Font("Arial", Font.PLAIN, 40));
				}
				else if(counter == 4) {
					setZoomCounter(5);
					timeF.setFont(new Font("Arial", Font.PLAIN, 50));
				}
				else if(counter == 5) {
					setZoomCounter(6);
					timeF.setFont(new Font("Arial", Font.PLAIN, 60));
				}


			}
		});
		zoomOut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				int counter = getZoomCounter();

				if(counter == 2) {
					setZoomCounter(1);
					timeF.setFont(new Font("Arial", Font.PLAIN, 10));
				}
				else if(counter == 3) {
					setZoomCounter(2);
					timeF.setFont(new Font("Arial", Font.PLAIN, 20));
				}
				else if(counter == 4) {
					setZoomCounter(3);
					timeF.setFont(new Font("Arial", Font.PLAIN, 30));
				}
				else if(counter == 5) {
					setZoomCounter(4);
					timeF.setFont(new Font("Arial", Font.PLAIN, 40));
				}
				else if(counter == 6) {
					setZoomCounter(5);
					timeF.setFont(new Font("Arial", Font.PLAIN, 50));
				}

			}
		});

		//Initialize timer
		Timer t = new Timer(1000, new Listener());
		t.start();

		Timer sw = new Timer(1000, new stopwatchListener());
		sw.start();

		Timer ti = new Timer(1000, new timerListener());
		ti.start();

	}

	class DayOfWeekListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			week.calculateDayOfWeek();
			dateF.setText(week.getDayOfWeek());
		}
	}




	class stopwatchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stopwatch.updateSeconds();
			stopWatchF.setText(stopwatch.getHour() + ":" +stopwatch.getMinute() +":" + stopwatch.getSecond());
		}
	}

	class timerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			timerClock.updateSecondsTimer();
			timerF.setText(timerClock.getHour() + ":" + timerClock.getMinute() + ":" + timerClock.getSecond());
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
