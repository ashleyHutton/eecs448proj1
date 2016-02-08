public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public Time()
	{
		hour = 0;
		minute = 0;
		second = 0;
	}

	public Time(int hour, int minute, int second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getsecond() {
		return second;
	}

	public void setsecond(int second) {
		this.second = second;
	}
	public void updateSeconds()
	{
		if (second == 59)
		{
			second = 0;
		}
		else 
		{
			second++;
		}
	}

	public void updateMinutes()
	{
		if (minute == 59)
		{
			minute = 0;
		}
		else
		{
			minute++;
		}
	}

	public void updateHours(int type)
	{
		if (type == 12)
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
		if (type == 24)
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