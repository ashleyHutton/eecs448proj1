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