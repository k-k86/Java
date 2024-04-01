package exercise.ex35;

public class DateValidator {
	
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		System.out.println("生年月日を８桁で入力してください");
		int date = scan.nextInt();
		
		int year = date / 10000;
		int month = date / 100 % 100;
		int day = date % 100;
		
		boolean year_judg = false;
		if ( year >= 1) {
			year_judg = true;
		}
		
		boolean month_judg = false;
		if ( month >= 1 && month <= 12) {
			month_judg = true;
		}
		
		boolean leap_judg = false;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) {
			leap_judg = true;
		}
		
		boolean day_judg = false;
		//int last_day = 0;
		switch(month){
			
		case 4,6,9,11:
			if(day >= 1 && day <= 30) {
				day_judg = true;
				
			}
			break;
		
		case 2:
			if(leap_judg) {
				System.out.println("うるう年です");
				if(day >= 1 && day <= 29) {
					day_judg = true;
					
				}
				
				
			} else {
				System.out.println("平年です");
				
			}
			break;
		case 1,3,5,7,8,10,12:
			
			if(day >= 1 && day <= 31) {
				day_judg = true;
			}
				
			break;
			
		}
		
		
		System.out.println(year  + "年 : " + year_judg);
		System.out.println(month + "月 : " + month_judg);
		System.out.println(day   + "日 : " + day_judg);
		
	}

}
