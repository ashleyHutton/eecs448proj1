/**
* @file Time.java
* @author Francinaldo de Almeida Pereira
* @date 2/10/16
* @brief Implementation file for Time class
*/

import java.util.Scanner;

public class ClockTest{
	
	/**
	* @pre none
	* @post Driver for Clock class
	* @return void
	*/
	
	public static void main(String[] args){
		
		
		while(true){
			
			boolean isMilitary = false;
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Clock Menu");
			System.out.println("----------");
			isMilitary = setFormat();
			
			
			//Initialize clock
			
			
			int hours = setHours(isMilitary);
			int minutes = setMinutes();
			int seconds = setSeconds();
			
			Clock myClock = new Clock(isMilitary,hours,minutes,seconds);
			
			//run clock
			myClock.displayClock();
		
		}
				
	}
	
	/**
	* @pre None
	* @post Determine if user wants military time
	* @return boolean
	*/
	
	public static boolean setFormat(){
		System.out.print("Would you like 24 hours clock (y/n)?  If you do not type a \"y\", we will default to 12 hours: ");
		
		Scanner formatInput = new Scanner(System.in);
		String format = formatInput.next();
		
		switch(format){
			case "y":
				return true;
			default:
				return false;
		}
	}
	/**
	* @pre valid boolean
	* @post Receives hours valid for specific type of clock (12- or 24-hour)
	* @return int
	*/
	public static int setHours(boolean isMilitary){
		int maxHours = isMilitary ? 23 : 12;
		
		System.out.print("Set the hours: ");
		
		Scanner hoursInput = new Scanner(System.in);
		int hours = hoursInput.nextInt();
		
		while((hours < 0 || hours > maxHours) || ((hours < 1 || 12 < hours)&& isMilitary == false)){
			System.out.print("Invalid entry.  Input the hours: ");
			hours = hoursInput.nextInt();
		}
		return hours;
	}
	
	/**
	* @pre  None
	* @post Receives minutes from user and validates to ensure valid minutes
	* @return int
	*/
		
	public static int setMinutes(){
		System.out.print("Set the minutes: ");
		
		Scanner minutesInput = new Scanner(System.in);
		int minutes = minutesInput.nextInt();
		
		while(minutes < 0 || minutes > 59){
			System.out.print("Invalid entry.  Input the minutes: ");
			minutes = minutesInput.nextInt();
		}
		return minutes;
	}
	
	/**
	* @pre  None
	* @post Receives seconds from user, determines validity.
	* @return int
	*/
	public static int setSeconds(){
		System.out.print("Set the seconds: ");
		
		Scanner secondsInput = new Scanner(System.in);
		int seconds = secondsInput.nextInt();
		
		while(seconds < 0 || seconds > 59){
			System.out.print("Invalid entry.  Input the seconds: ");
			seconds = secondsInput.nextInt();
		}
		
		return seconds;
	}
}
