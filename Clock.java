

public class Clock{
	
	private Time displayTime;
	boolean isMilitary;
	
	public Clock(boolean isMilitary,int hours, int minutes, int seconds){
		
		displayTime = new Time(isMilitary,hours,minutes,seconds);
		this.isMilitary = isMilitary;
		
	}
	
	public void displayClock(){
		
		
		while(true){
			
			String hours;
			String minutes;
			String seconds;
			
			
			System.out.print("\033[H\033[2J");
			
			if(displayTime.getHour() < 10 && displayTime.getMinute() < 10 && displayTime.getSecond() >= 10){
				System.out.println(0+displayTime.getHour()+":"+0+displayTime.getMinute()+":"+displayTime.getSecond());
			}
			else if(displayTime.getHour() < 10 && displayTime.getMinute() >= 10 && displayTime.getSecond() < 10){
				System.out.println(0+displayTime.getHour()+":"+displayTime.getMinute()+":"+0+displayTime.getSecond());
			}
			else if(displayTime.getHour() >= 10 && displayTime.getMinute() < 10 && displayTime.getSecond() < 10){
				System.out.println(displayTime.getHour()+":"+0+displayTime.getMinute()+":"+0+displayTime.getSecond());
			}
			else if(displayTime.getHour() >= 10 && displayTime.getMinute() >= 10 && displayTime.getSecond() < 10){
				System.out.println(displayTime.getHour()+":"+displayTime.getMinute()+":"+0+displayTime.getSecond());
			}
			else if(displayTime.getHour() >= 10 && displayTime.getMinute() < 10 && displayTime.getSecond() >= 10){
				System.out.println(displayTime.getHour()+":"+0+displayTime.getMinute()+":"+displayTime.getSecond());
			}
			else if(displayTime.getHour() < 10 && displayTime.getMinute() >= 10 && displayTime.getSecond() >= 10){
				System.out.println(0+displayTime.getHour()+":"+displayTime.getMinute()+":"+displayTime.getSecond());
			}
			else{
				System.out.println("0"+displayTime.getHour()+":"+0+displayTime.getMinute()+":"+0+displayTime.getSecond());
			}
		
			try{
					Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			
			
		}	
	}
}	