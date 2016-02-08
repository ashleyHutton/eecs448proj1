public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public time()
	{
		hour = 0;
		minute = 0;
		second = 0;
	}

	public time(int hour, int minute, int second)
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
}