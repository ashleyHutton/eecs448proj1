

public class Clock{
	
	private Time displayTime;
	
	public Clock(){
		
		displayTime = new Time();
		
	}
	
	public void displayClock(){
		
		
		while(true){
			
			String hours;
			String minutes;
			String seconds;
			
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
		}
		
		
		
	}
	
	
	
	
	
	
	
	
}