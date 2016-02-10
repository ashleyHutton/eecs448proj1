private class Time {
	
	
	private int hour;
	private int minute;
	private int second;
	private boolean isMilitary;
	
	public Time()  //@pre None @post Creates a Time object with defalut values of 0 for the variables hour, minute, and second. @return None
	{
		hour = 0;
		minute = 0;
		second = 0;
	}

	public Time(boolean isMilitary, int hour, int minute, int second)  //@pre Have to pass in three ints. @post Creates a Time object whose variable values are set to the three passed in ints. @return None
	{
		this.isMilitary = isMilitary;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public int getHour() {  //@pre None @post None @return Returns the value for the variable "hour".
		return hour;
	}

	public void setHour(int hour) {  //@pre Have to pass in an int @post Sets the variable "hour" to the passed in value @return None
		this.hour = hour;
	}

	public int getMinute() {  //@pre None @post None @return Returns the value for the variable "minute".
		return minute;
	}

	public void setMinute(int minute) {  //@pre Have to pass in an int @post Sets the variable "minute" to the passed in value @return None 
		this.minute = minute;
	}

	public int getSecond() {  //@pre None @post None @return Returns the value for the variable "second". 
		return second;
	}

	public void setSecond(int second) {  //@pre  Have to pass in an int @post Sets the variable "second" to the passed in value @return None
		this.second = second;
	}
	public void updateSeconds()  //@pre None @post Updates the value for the variable "second". Takes into consideration that the numbers restart from 59 to 0. @return None 
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

	public void updateMinutes()  //@pre None @post Updates the value for the variable "minute". Takes into consideration that the numbers restart from 59 to 0. @return None
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

	public void updateHours()  //@pre Have to pass in an boolean to determine the updates for the hour @post Updates the value for the variable "hour". Takes into consideration that the numbers restart from 12 to 1 for the 12 hour clock, and from 23 to 0 for the 24 hour clock. @return None
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
	
	public void updateTime(){
		updateSeconds();
		
		
	}
}