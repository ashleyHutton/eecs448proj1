

public class Clock{
	
	private Time displayTime;
	boolean isMilitary;
	
	public Clock(boolean isMilitary,int hours, int minutes, int seconds){
		
		displayTime = new Time(isMilitary,hours,minutes,seconds);
		this.isMilitary = isMilitary;
		
	}
	
	public void displayClock(){
		
		
		while(true){
			/*
			String hours = (String)displayTime.getHour();
			String minutes = (String)displayTime.getMinute();
			String seconds = (String)displayTime.getSecond();
			
			if(displayTime.getHour() < 10){
				hours = new String("0"+displayTime.getHour());
			}
			if(displayTime.getMinute() < 10){
				hours = new String("0"+displayTime.getMinute());
			}
			if(displayTime.getSecond() < 10){
				hours = new String("0"+displayTime.getSecond());
			}
			*/
			System.out.print("\033[H\033[2J");
			System.out.println(displayTime.getHour()+":"+displayTime.getMinute()+":"+displayTime.getSecond());
			try{
					Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			
			
		}	
	}
}	