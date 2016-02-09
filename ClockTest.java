

import java.util.Scanner;

public class ClockTest{
	
	
	public static void main(String[] args){
		
		
		while(true){
			
			bool isMilitary = false;
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Clock Menu");
			System.out.println("----------");
			isMilitary = setFormat();
			
			
			//Initialize clock
			Clock myClock = new Clock(isMilitary);
			myClock.setHour(setHours(isMilitary));
			myClock.setMinute(setMinutes());
			myClock.setSecond(setSeconds());
			
			//run clock
			myClock.updateTime();
			
			
			
			
			
			/**
			String option = optionInput.next();
			
			switch(option){
				case "a":
					System.out.println("a selected");
					setTime();
					break;
				case "b":
					System.out.println("b selected");
					break;
				case "c":
					System.out.println("c selected");
					break;
				case "d":
					System.out.println("d selected");
					break;
				default:
					System.out.println("Invalid");
					break;
				*/
			}
		}
	}
	/** Doesn't work in this context
	protected static void printMenu(){
		System.out.println("Clock Menu:");
		System.out.println("Type \"a\" to set the time");
		System.out.println("Type \"b\" to set the format to 12 hours");
		System.out.println("Type \"c\" to set the format to 24 hours");
		System.out.println("Type \"d\" to launch\n");
		System.out.print("Select one option: ");
	}
	*/
	/** I have all the set methods returning ints now with validation happening within the methods
	protected static void setTime(){
		while(!setFormat()){
			System.out.println("Invalid");
		}
		
		while(!setHours()){
			System.out.println("Invalid");
		}
		
		while(!setMinutes()){
			System.out.println("Invalid");
		}
		
		while(!setSeconds()){
			System.out.println("Invalid");
		}
	}
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
	
	public static int setHours(bool isMilitary){
		int maxHours = isMilitary ? 24 : 12;
		
		System.out.print("Set the hours: ");
		
		Scanner hoursInput = new Scanner(System.in);
		int hours = hoursInput.nextInt();
		
		if(((hours == 0 && isMilitary == false)||(hours <0)) && hours < maxHours){
			hours = hoursInput.nextInt();
		}
		return hours;
	}
	
	public static int setMinutes(){
		System.out.print("Set the minutes: ");
		
		Scanner minutesInput = new Scanner(System.in);
		int minutes = minutesInput.nextInt();
		
		if(minutes > 0 && minutes < 60){
			minutes = minutesInput.nextInt();
		}
		rreturn minutes;
	}
	
	public static int setSeconds(){
		System.out.print("Set the seconds: ");
		
		Scanner secondsInput = new Scanner(System.in);
		int seconds = secondsInput.nextInt();
		
		if(seconds > 0 && seconds < 60){
			seconds = secondsInput.nextInt();
		}
		
		return seconds;
	}
	
	
	
	
/**	These instance variables aren't really useful in the context of a multiclass program
	protected static int m_hours = 24;
	protected static int m_minutes = 60;
	protected static int m_seconds = 60;
	protected static boolean m_isMilitary = false;
*/
}