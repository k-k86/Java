package exercise.ex95.com.example.service;

public class DateService {
	
	private static final int[] MONTH_DAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private static boolean isValidYear(int year) {
		
		if(year >= 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean isValidMonth(int month) {
		
		if(month >= 1 && month <= 12 ) {
			
			return true;
			
		} else {
			return false;
		}
		
	}
	
	public static boolean isLeapYear(int year) {
		
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) {
			return true;
			
		} else {
			
			return false;
		}
		
	}
	
	public static int getEndOfMonth (int year, int month) {
		int last_day = 0;
		
		if(!isValidYear(year) && !isValidMonth(month)) {
			return 0;
		}
		
		last_day = MONTH_DAY[month - 1];
		if(month == 2 && isLeapYear(year)) {
			last_day = MONTH_DAY[1 + 1]++;
		}
		return last_day;
		
	}
	
	public static boolean isValidDate(int date) {
		
		int year = date / 10000;
		int month = date / 100 % 100;
		int day = date % 100;
		
		if(!isValidYear(year) || !isValidMonth(month)) {
			return false;
		
		}
		int last_day = getEndOfMonth(year, month);
		if(day < 1 || day > last_day) {
			
			return false;
			
		}
		return true;
		
	}
	
	
}
