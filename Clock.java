/**
* @file: Clock.java
* @author: Dravid Joseph
* @date: 2/10/16
* @brief: Implementation file for Clock class
*/

public class Clock{
	
	/**
	* PRIVATE MEMBER VARIABLES
	*/
	
	
	/**
	* @brief: Responsible for handling the time attributes
	*/
	private Time displayTime;
	
	
	/**
	* @brief: Not directly used, but passed on to time class
	*/
	private boolean isMilitary;
	
	
	
	/**
	* @pre :  valid boolean and valid time attributes for type of time needed
	* @post : Initialize instance variables
	* @return : None
	*/
	public Clock(boolean isMilitary,int hours, int minutes, int seconds){
		
		displayTime = new Time(isMilitary,hours,minutes,seconds);
		this.isMilitary = isMilitary;
		
	}
	
	/**
	* @pre : None
	* @post : display updating time to the console
	* @return : void
	*/
	public void displayClock(){
		
		
		while(true){
			
			//Newlines enough to clear the screen
			System.out.print("\033[H\033[2J");
			
			//prints a string containing the current time
			constructClock();
		
		
			//Delays the program by 1000 ms (1 sec).  
			try{
					Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			//Updates the time.  Details handled by Time class
			displayTime.updateSeconds();
			
		}	
	}
	
	
	
	/**
	* @pre : None
	* @post : display time string to the console, prefixing zeros as needed
	* @return : void
	**/
	public void constructClock(){
		if(displayTime.getHour() < 10 && displayTime.getMinute() < 10 && displayTime.getSecond() >= 10){
			System.out.println("0"+displayTime.getHour()+":"+0+displayTime.getMinute()+":"+displayTime.getSecond());
		}
		else if(displayTime.getHour() < 10 && displayTime.getMinute() >= 10 && displayTime.getSecond() < 10){
			System.out.println("0"+displayTime.getHour()+":"+displayTime.getMinute()+":"+0+displayTime.getSecond());
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
			System.out.println("0"+displayTime.getHour()+":"+displayTime.getMinute()+":"+displayTime.getSecond());
		}
		else if(displayTime.getHour() >= 10 && displayTime.getMinute() >= 10 && displayTime.getSecond() >= 10){
			System.out.println(displayTime.getHour()+":"+displayTime.getMinute()+":"+displayTime.getSecond());
		}
		else{
			System.out.println("0"+displayTime.getHour()+":"+"0"+displayTime.getMinute()+":"+"0"+displayTime.getSecond());
		}
	}
}	