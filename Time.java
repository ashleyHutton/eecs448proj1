/**
* @file: Time.java
* @author: Ashley Hutton, Hannah Johnson, and Rabel Marte
* @date: 2/10/16
* @brief: Implementation file for Time class
*/

import java.util.Calendar;

public class Time {

	private int hour;
	private int minute;
	private int second;
	private boolean isMilitary = true;
	private int militaryHour;
	// true is pm false is am
	private boolean amPm;
	private boolean isMidnight = false;
	/**
	* @pre  None
	* @post Creates a Time object with defalut values of 0 for the variables hour, minute, and second.
	* @return None
	*/

	public Time()
	{
		Calendar currentTime = Calendar.getInstance();
		hour = 0;
		minute = 0;
		second = 0;
	}


	/**
	* @pre  Valid boolean and three ints.  Validity of those determined by client
	* @post Creates a Time object whose variable values are set to the three passed in ints.  Boolean determines military time
	* @return None
	*/
	public Time(boolean isMilitary, int hour, int minute, int second)
	{
		this.isMilitary = isMilitary;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	/**
	* @pre None
	* @post None
	* @return return amPm
	*/
	public boolean getAmPm() {
		return  amPm;
	}

	/**
	* @pre None
	* @post None
	* @return return isMidnight
	*/
	public boolean getIsMidnight() {
		return  isMidnight;
	}

	/**
	* @pre passed in boolean midnight
	* @post sets this.isMidnight to passed in midnight
	* @return none
	*/
	public void setIsMidnight(boolean midnight) {
		isMidnight = midnight;
	}

	/**
	* @pre Valid boolean hourMode
	* @post sets this.amPm to passed in hourMode
	* @return None
	*/
	public void setAmPm(boolean hourMode) {
		this.amPm = hourMode;
	}

	/**
	* @pre None
	* @post None
	* @return return isMilitary
	*/
	public boolean getIsMilitary() {
		return  isMilitary;
	}

	/**
	* @pre Valid int mode passed in
	* @post sets this.isMilitary to mode passed in
	* @return None
	*/
	public void setIsMilitary(boolean militaryMode) {
		this.isMilitary = militaryMode;
	}

	/**
	* @pre None
	* @post None
	* @return Return hour
	*/
	public int getHour() {
		return hour;
	}


	/**
	* @pre Valid hour integer passed in
	* @post Sets this.hour to the passed in value
	* @return None
	*/
	public void setHour(int hour) {
		this.hour = hour;
	}


	/**
	* @pre None
	* @post None
	* @return minute
	*/
	public int getMinute() {
		return minute;
	}

	/**
	* @pre Valid int milHour passed in
	* @post Sets this.militaryHour to passed in milHour
	* @return none
	*/
	public void setMilitaryHour(int milHour) {
		this.militaryHour = milHour;
	}

	/**
	* @pre None
	* @post None
	* @return military hour
	*/
	public int getMilitaryHour() {
		return militaryHour;
	}

	/**
	* @pre Valid integer minute passed in
	* @post Sets this.minute to passed in minute
	* @return None
	*/
	public void setMinute(int minute) {
		this.minute = minute;
	}


	/**
	* @pre None
	* @post None
	* @return Return second
	*/
	public int getSecond() {
		return second;
	}


	/**
	* @pre Valid integer second passed in
	* @post Sets this.second to passed in second
	* @return None
	*/
	public void setSecond(int second) {
		this.second = second;
	}

	/**
	* @pre None
	* @post Updates the value for the variable "second". Takes into consideration that the numbers restart from 59 to 0.
	* @return None
	*/
	public void updateSeconds()
	{
		if (second == 59)
		{
			second = 0;
			updateMinutes();
		}
		else
		{
			second++;
		}
	}

	public void updateSecondsTimer() {

		if (second == 0) {
			second = 59;
			updateMinutesTimer();
		}
		else {
			second--;
		}
	}


	/**
	* @pre None
	* @post Updates the value for the variable "minute". Takes into consideration that the numbers restart from 59 to 0.
	* @return None
	*/
	public void updateMinutes()
	{
		if (minute == 59)
		{
			minute = 0;
			updateHours();
		}
		else
		{
			minute++;
		}
	}

	public void updateMinutesTimer() {

		if(minute == 0)
		{
			minute = 59;
			updateHoursTimer();
		}
		else {
			minute--;
		}


	}

	/**
	* @pre Have to pass in an boolean to determine the updates for the hour
	* @post Updates the value for the variable "hour". Takes into consideration that the numbers restart from 12 to 1 for the 12 hour clock, and from 23 to 0 for the 24 hour clock.
	* @return None
	*/
	public void updateHours()
	{
		militaryHour += hour;
		// 12 Hour
		if (!isMilitary)
		{
			//System.out.println("In 12 hour");
			// account for AM/PM by incrementing military hour
			// and then checking changing AM/PM variable
			if(militaryHour == 23) { militaryHour = 0; }
			else { militaryHour++; }

			if(militaryHour >= 12) { amPm = true; }
			else { amPm = false; }

			// if time switched from 24, it needs to be converted
			if(hour > 12) {
				//System.out.println("Inside the check");
				hour -= 12;
			}
			// increment hour accordingly
			if (hour == 12) { hour = 1; }
			else { hour++; }

			// switch am/pm at midnight or noon
			if(hour == 12 && minute == 0 && second == 0) {
				if(amPm == false) {
					amPm = true;
				}
				else if(amPm == true) {
					amPm = false;
					isMidnight = true;
					//System.out.println("Changed midnight to true");
					// here's where increment day is
				//	System.out.println(m_dayOfWeekOb.getDayOfWeek());
					//m_dayOfWeekOb.incrementDayOfWeek();
				}
			}

		}
		// 24 hour
		if (isMilitary)
		{
			// increment military hour in case user switches to 12 hour
			if(militaryHour == 23) { militaryHour = 0; }
			else { militaryHour++; }

			if(militaryHour >= 12) { amPm = true; }
			else { amPm = false; }

			// increment hour accordingly
			if (hour == 23) { hour = 0; }
			else { hour++; }

			if (hour == 0 && minute == 0 && second == 0){
				isMidnight = true;
			}
		}
	}

	public void updateHoursTimer() {
		if (!isMilitary)
		{
			if (hour == 1)
			{
				hour = 12;
			}
			else
			{
				hour--;
			}
		}
		if (isMilitary)
		{
			if (hour == 0)
			{
				hour = 23;
			}
			else
			{
				hour--;
			}
		}
	}
}
