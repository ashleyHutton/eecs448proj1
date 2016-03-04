/**
* @file: Time.java
* @author: Richard Aviles and Jinuk Park
* @date: 2/10/16
* @brief: Implementation file for Time class
*/

import java.util.Calendar;

public class Time {

	private int hour;
	private int minute;
	private int second;
	private boolean isMilitary;

	/**
	* @pre  None
	* @post Creates a Time object with defalut values of 0 for the variables hour, minute, and second.
	* @return None
	*/

	public Time()
	{
		Calendar currentTime = Calendar.getInstance();
		hour = currentTime.get(Calendar.HOUR_OF_DAY);
		minute = currentTime.get(Calendar.MINUTE);
		second = currentTime.get(Calendar.SECOND);
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
	* @post Return hour
	* @return hour
	*/

	public int getHour() {
		return hour;
	}


	/**
	* @pre Have to pass in an int
	* @post Sets the variable "hour" to the passed in value
	* @return None
	*/
	public void setHour(int hour) {
		this.hour = hour;
	}


	/**
	* @pre None
	* @post None
	* @return the value for the variable "minute"
	*/
	public int getMinute() {
		return minute;
	}


	/**
	* @pre Have to pass in an int
	* @post Sets the variable "minute" to the passed in value
	* @return None
	*/
	public void setMinute(int minute) {
		this.minute = minute;
	}


	/**
	* @pre None
	* @post None
	* @return the value for the variable "second".
	*/
	public int getSecond() {
		return second;
	}


	/**
	* @pre Have to pass in an int
	* @post Sets the variable "second" to the passed in value
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


	/**
	* @pre Have to pass in an boolean to determine the updates for the hour
	* @post Updates the value for the variable "hour". Takes into consideration that the numbers restart from 12 to 1 for the 12 hour clock, and from 23 to 0 for the 24 hour clock.
	* @return None
	*/
	public void updateHours()
	{
		if (!isMilitary)
		{
			if (hour == 12)
			{
				hour = 1;
			}
			else
			{
				hour++;
			}
		}
		if (isMilitary)
		{
			if (hour == 23)
			{
				hour = 0;
			}
			else
			{
				hour++;
			}
		}
	}
}
