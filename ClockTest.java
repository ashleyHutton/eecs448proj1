import java.util.Scanner;

public class ClockTest{
	
	
	public static void main(String[] args){
		
		int i = 0;
		
		while(true){
			System.out.print("\033[H\033[2J");
			printMenu();
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			i++;
			
			
		}
		
		
		
	}
	
	protected static void printMenu(){
		System.out.println("Clock Menu:\n");
		System.out.println("Type \"a\" to set the time");
		System.out.println("Type \"b\" to set the format to 12 hours");
		System.out.println("Type \"c\" to set the format to 24 hours");
		System.out.println("Type \"d\" to launch\n");
		System.out.println("Select one option:");
	}
	
	
	
	
}