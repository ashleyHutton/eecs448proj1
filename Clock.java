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
 	private JButton switchHourMode;
 	private JButton resetStopWatch;
 	private JButton pauseStopWatch;
 	private JButton pauseTimer;
 	private JButton resetTimer;

  	// create objects for time, timer and stopwatch
  	public Time timeClock = new Time();
 	public Time stopwatch = new Time();
 	public Time timerClock = new Time();
 	public DayOfWeek week = new DayOfWeek();

 	// default zoom and calendar date
 	private int m_zoomCounter = 3;
 	private int m_month = 1;
 	private int m_day = 3;
	private String m_dayOfWeek;

 	private Boolean isEnable;
 	private Boolean timerSet = false;
 	private Boolean isStopWatchPaused = false;
 	private Boolean stopWatchRunning = false;

 	private Boolean goodTimeInput = false;
 	private Boolean goodTimerInput = false;
 	private Boolean goodCalendarInput = false;

 	private Boolean isTimerPaused = false;

 	public Clock(){

 		gui();

 	}

 	public int getZoomCounter() {
 		return m_zoomCounter;
 	}

 	public void setZoomCounter(int counter) {
 		m_zoomCounter = counter;
 	}

	public String getClockDayOfWeek() {
		return m_dayOfWeek;
	}


 	public void gui(){

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
 		switchHourMode = new JButton("Switch Hour Mode");
 		pauseStopWatch = new JButton("Pause/Resume");
 		resetStopWatch = new JButton("Reset");
 		pauseTimer = new JButton("Pause/Resume");
 		resetTimer = new JButton("Reset");

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
 		p.add(switchHourMode);

  		p.add(timeF);
  		p.add(dateF);
 		//p.add(timeS);//

 		// set default day
  		week.setMonth(m_month);
  		week.setDay(m_day);

 		// calculate day of week from set month/day
  		week.calculateDayOfWeek();
			m_dayOfWeek = week.getDayOfWeek();
			System.out.println(week.getDayOfWeek());
  		dateF.setText(week.getDayOfWeek());

 		// create stopwatch panel and add necessary fields and buttons
 		stopWatchPanel = new JPanel();
 		stopWatchPanel.setBackground(Color.WHITE);

 		stopWatchPanel.add(switchToClock1);
 		stopWatchPanel.add(stopWatchF);
 		stopWatchPanel.add(resetStopWatch);
 		stopWatchPanel.add(pauseStopWatch);

 		// create timer panel and add necessary fields and buttons
 		timerPanel = new JPanel();
 		timerPanel.setBackground(Color.WHITE);

 		timerPanel.add(switchToClock2);
 		timerPanel.add(pauseTimer);
 		timerPanel.add(resetTimer);
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

 		pauseStopWatch.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){

 				if (isStopWatchPaused){
 					isStopWatchPaused = false;
 				}
 				else{
 					isStopWatchPaused = true;
 				}

 			}
 		});

 		resetStopWatch.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){

 				stopwatch.setHour(0);
 				stopwatch.setMinute(0);
 				stopwatch.setSecond(0-1);

 			}
 		});

 		pauseTimer.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){

 				if (isTimerPaused){
 					isTimerPaused = false;
 				}
 				else{
 					isTimerPaused = true;
 				}

 			}
 		});

 		resetTimer.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){

 				timerSet = false;
 				timer.doClick();

 			}
 		});

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

  				/** regular expression looking for the format "##:##:## AM/PM in 12hr */
  			    String timePattern_12hr = "(^[1-9]|1[0-2]):([0-5][0-9]):([0-5][0-9])[ ]?(?i)(am|pm)$";
  			    /** regular expression looking for the format "##:##:## in 24hr */
  			    String timePattern_24hr = "(^[01]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

 			    Pattern r;
 			    Matcher m;

 					// Check if military time

 			    // Create a Pattern object for appropriate hour Mode
 			    while (!goodTimeInput){

 					if(timeClock.getIsMilitary()) {
 						String userTime = JOptionPane.showInputDialog("Enter the time (24 Hour):");

 						// if user clicks cancel, return
 						if (userTime ==  null){
								return;
	 					}

 						r = Pattern.compile(timePattern_24hr);
 						// Now create matcher object.
 						m = r.matcher(userTime);
 					}
 					else {
 						String userTime = JOptionPane.showInputDialog("Enter the time (12 Hour):");

 						// if user clicks cancel, return
 						if (userTime ==  null){
							return;
	 					}

 						r = Pattern.compile(timePattern_12hr);
 						// Now create matcher object.
						m = r.matcher(userTime);
 					}

 					// if it's 12 hour mode, also set AM/PM
 					if(!timeClock.getIsMilitary()) {
 						if (m.find()){
 							goodTimeInput = true;

 							String ampm = m.group(4);

 							System.out.println("Found value: " + m.group(0) );
 							System.out.println("Found value: " + m.group(1) );
 							System.out.println("Found value: " + m.group(2) );
 							System.out.println("Found value: " + m.group(3) );
 							System.out.println("Found value: " + m.group(4) );

 							timeClock.setSecond(Integer.parseInt(m.group(3))-1);
 							timeClock.setMinute(Integer.parseInt(m.group(2)));
 							timeClock.setHour(Integer.parseInt(m.group(1)));


							if(ampm.equals("pm") || ampm.equals("PM")) {
								System.out.println("here");
 								timeClock.setAmPm(true);

                timeClock.setMilitaryHour(Integer.parseInt(m.group(1)) + 12);
 							}
 							else if(ampm.equals("am") || ampm.equals("AM")) {
 								timeClock.setAmPm(false);

                timeClock.setMilitaryHour(Integer.parseInt(m.group(1)));
 							}

 						}

					}
 					else {
 						if (m.find( )) {
 								goodTimeInput = true;

 								System.out.println("Found value: " + m.group(0) );
 								System.out.println("Found value: " + m.group(1) );
 								System.out.println("Found value: " + m.group(2) );
 								System.out.println("Found value: " + m.group(3) );


 								timeClock.setSecond(Integer.parseInt(m.group(3))-1);
 								timeClock.setMinute(Integer.parseInt(m.group(2)));
 								timeClock.setHour(Integer.parseInt(m.group(1)));
                timeClock.setMilitaryHour(Integer.parseInt(m.group(1)));
							}
 						}
 					}

 					// automatically popup change date prompt
 					changeDate.doClick();

 					goodTimeInput = false;
 				}


  		});

  		stopWatch.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){

 				if (!stopWatchRunning){

	 				stopwatch.setSecond(0);
	 				stopwatch.setMinute(0);
	 				stopwatch.setHour(0);

	 				stopWatchRunning = true;
	 			}



 				stopWatchF.setText(stopwatch.getHour() + ":" +String.format("%02d", stopwatch.getMinute()) +":" + String.format("%02d",stopwatch.getSecond()));

 				// go to stopwatch page
 				c1.show(panelCont, "2");

 				//JOptionPane.showInputDialog(null, "working!");
 			}
 		});
 		timer.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){

 				if (timerSet == false){

 					timerSet = true;

 					while (!goodTimerInput){

	 					String userTimer = JOptionPane.showInputDialog("Enter the time:");

	 					if (userTimer == null){
	 						timerSet = false;
	 						return;
	 					}

	 				    /** regular expression looking for the format "##:##:## in 24hr */
	 				    String timerPattern = "(^[0-9]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

	 				    // Create a Pattern object
	 				    Pattern r = Pattern.compile(timerPattern);

	 				      // Now create matcher object.
	 				    Matcher m = r.matcher(userTimer);

	 			    	if (m.find( )) {

	 			    		goodTimerInput = true;

	 			        	System.out.println("Found value: " + m.group(0) );
	 			        	System.out.println("Found value: " + m.group(1) );
	 			        	System.out.println("Found value: " + m.group(2) );
	 			       		System.out.println("Found value: " + m.group(3) );

 			       		timerClock.setSecond(Integer.parseInt(m.group(3)));
 						timerClock.setMinute(Integer.parseInt(m.group(2)));
 						timerClock.setHour(Integer.parseInt(m.group(1)));




 						timerF.setText(timerClock.getHour() + ":" +String.format("%02d",timerClock.getMinute()) +":" + String.format("%02d",timerClock.getSecond()));

	 			      	}
	 				}

	 				goodTimerInput = false;
 				}

 					// go to timer page
 					c1.show(panelCont, "3");

 			}
 		});

 		clearScreen.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){

 				c1.show(panelCont, "4");
 			}
 		});
 		changeDate.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){

 				while (!goodCalendarInput){

	 				String userDate = JOptionPane.showInputDialog("Enter the Date (MM/DD):");

	 				if (userDate == null){
	 					return;
	 				}

	 				// regular expression to find the date in the format MM/DD
	 				String datePattern = "(^0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])$";

	 				// Create a Pattern object
	 			    Pattern r = Pattern.compile(datePattern);

	 			    // Now create matcher object.
	 			    Matcher m = r.matcher(userDate);

	 			    if (m.find()){

	 			    	goodCalendarInput = true;

	 			    	System.out.println(m.group(0));
	 			    	System.out.println(m.group(1));
	 			    	System.out.println(m.group(2));

	 			    	// set the month and day to the given input
	 			    	m_month = Integer.parseInt(m.group(1));
	 			    	m_day = Integer.parseInt(m.group(2));

	 			    	if (( m_month == 2 && (m_day == 30 || m_day == 31)) ||
	 			    		( m_month == 4 && m_day == 31 ) ||
	 			    		( m_month == 6 && m_day == 31 ) ||
	 			    		( m_month == 9 && m_day == 31 ) ||
	 			    		( m_month == 11 && m_day == 31)){

	 			    		System.out.println("Bad Input");
	 			    	}
	 			    	else {

	 						// Set member variables in DayOfWeek object and call calculateDayOfWeek
	 						week.setMonth(m_month);
	 						week.setDay(m_day);

	 						week.calculateDayOfWeek();
	 						dateF.setText(week.getDayOfWeek());
	 					}
	 				}
	 			}

	 			goodCalendarInput = false;
 			}
 		});
 		zoomIn.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
 				int counter = getZoomCounter();

 				if(counter == 1) {
 					setZoomCounter(2);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 25));
 				}
 				else if(counter == 2) {
 					setZoomCounter(3);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 30));
 				}
 				else if(counter == 3) {
 					setZoomCounter(4);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 35));
 				}
 				else if(counter == 4) {
 					setZoomCounter(5);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 40));
 				}
 				else if(counter == 5) {
 					setZoomCounter(6);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 45));
 				}
 			}
 		});
 		zoomOut.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){

 				int counter = getZoomCounter();

 				if(counter == 2) {
 					setZoomCounter(1);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 20));
 				}
 				else if(counter == 3) {
 					setZoomCounter(2);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 25));
 				}
 				else if(counter == 4) {
 					setZoomCounter(3);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 30));
 				}
 				else if(counter == 5) {
 					setZoomCounter(4);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 35));
 				}
 				else if(counter == 6) {
 					setZoomCounter(5);
 					timeF.setFont(new Font("Arial", Font.PLAIN, 40));
 				}

  			}
  		});

 		switchHourMode.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e){
				// 24 hour
 				if(timeClock.getIsMilitary()) {
					// convert hours back to 12 hour mode
          System.out.println("Hour: " + timeClock.getHour());
          System.out.println("Military Hour: " + timeClock.getMilitaryHour());
					if(timeClock.getHour() > 12) {
						timeClock.setHour(timeClock.getHour() - 12);
            timeClock.setAmPm(true);
            timeClock.setMilitaryHour(timeClock.getMilitaryHour() - 12);
					}
          // noon case
          else if(timeClock.getHour() == 12) {
            timeClock.setMilitaryHour(12);
            timeClock.setAmPm(true);
          }
          else if(timeClock.getHour() == 0) {
            timeClock.setMilitaryHour(0);
            timeClock.setAmPm(false);
            timeClock.setHour(12);
          }
          else {
            timeClock.setAmPm(false);
          }
 					timeClock.setIsMilitary(false);
					System.out.println("Set military to false");
 				}
        // 12 hour
 				else {
					// convert hours back to 24 hour mode
          System.out.println("Hour: " + timeClock.getHour());
          System.out.println("Military Hour: " + timeClock.getMilitaryHour());
					if(timeClock.getAmPm() == true) {
					  timeClock.setHour(timeClock.getHour()+12);
            timeClock.setMilitaryHour(timeClock.getMilitaryHour() + 12);
					}
          else {
            if(timeClock.getHour() == 12) {
              timeClock.setHour(0);
              timeClock.setMilitaryHour(0);
            }
          }
 					timeClock.setIsMilitary(true);
					System.out.println("Set miliary to true");
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

 	class stopwatchListener implements ActionListener {
 		public void actionPerformed(ActionEvent e) {
 			// check if stopwatch should be paused or not
 			if (!isStopWatchPaused){
	 			stopwatch.updateSeconds();
	 			stopWatchF.setText(stopwatch.getHour() + ":" +String.format("%02d",stopwatch.getMinute()) +":" + String.format("%02d",stopwatch.getSecond()));
 			}
 		}
 	}

 	class timerListener implements ActionListener {
 		public void actionPerformed(ActionEvent e) {

 			// check that timer isn't at 0

 			if ( timerClock.getHour() == 0 &&
 				 timerClock.getMinute() == 0 &&
 				 timerClock.getSecond() == 0 ){

 				timerSet = false;

 			}
 			else {

 				if (!isTimerPaused){

 					timerClock.updateSecondsTimer();
 					timerF.setText(timerClock.getHour() + ":" + String.format("%02d",timerClock.getMinute()) + ":" + String.format("%02d",timerClock.getSecond()));
 				}
 			}
 		}
 	}


 	class Listener implements ActionListener {
  		public void actionPerformed(ActionEvent e) {
  				timeClock.updateSeconds();
  				// print time to Screen
 				// if 24 hour
 				if(timeClock.getIsMilitary()) {
					if(timeClock.getIsMidnight()) {
						week.incrementDayOfWeek();
						timeClock.setIsMidnight(false);
						System.out.println("Incremented day of week");
					}
					dateF.setText(week.getDayOfWeek());
 					timeF.setText(timeClock.getHour() + ":" + String.format("%02d",timeClock.getMinute()) + ":" + String.format("%02d",timeClock.getSecond()));
 				}
 				// if 12 hour
 				else {
					if(timeClock.getIsMidnight()) {
						week.incrementDayOfWeek();
						timeClock.setIsMidnight(false);
						System.out.println(timeClock.getIsMidnight());
						System.out.println("Incremented day of week");
					}
					dateF.setText(week.getDayOfWeek());
 					// if pm
 					if(timeClock.getAmPm()) {
 						timeF.setText(timeClock.getHour() + ":" + String.format("%02d",timeClock.getMinute()) + ":" + String.format("%02d",timeClock.getSecond())
 						+ " " + "PM");
 					}
					// if am
					else {
 						timeF.setText(timeClock.getHour() + ":" + String.format("%02d",timeClock.getMinute()) + ":" + String.format("%02d",timeClock.getSecond())
 						+ " " + "AM");
 					}

 				}
  			}


}


 	public static void main(String[] args){
		new Clock();
 	}

 }
