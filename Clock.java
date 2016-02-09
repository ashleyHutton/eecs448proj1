

public class Clock{
	
	private Time displayTime;
	boolean isMilitary;
	
	public Clock(bool isMilitary,int hours, int minutes, int seconds){
		
		displayTime = new Time(isMilitary,hours,minutes,seconds);
		this.isMilitary = isMilitary;
		
	}
	
	public void displayClock(){
		
		
		while(true){
			
			String hours = (String)displayTime.getHour();
			String minutes = (String)displayTime.getMinute();
			String seconds = (String)displayTime.getSecond();
			
			if(displayTime.getHour() < 10){
				hours = new String("0"+displayTime.getHours());
			}
			if(displayTime.getMinute() < 10){
				hours = new String("0"+displayTime.getMinutes());
			}
			if(displayTime.getSecond() < 10){
				hours = new String("0"+displayTime.getSeconds());
			}
			
			System.out.println(hours+":"+minutes+":"seconds);
			try{
					Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			
			System.out.print("\033[H\033[2J");
		}
		
		
		
	}
	public void setHour(int hour){
		displayTime.setHour(hour);
	}
	public void setMinute(int minute){
		displayTime.setMinute(minute);
	}
	public void setSecond(int second){
		displayTime.setSecond(second);
	}
}	
	
	
	
	
	
}