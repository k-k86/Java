package exercise.ex74;

public class MonthName {
	
	private static final String[] NAMES = {
			"January", "Februry", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December",	
	};
	
	public static String getName(int month) {
		if(month < 1 || month > 12) {
			return null;
		}
		return NAMES[month - 1];
	}

}
