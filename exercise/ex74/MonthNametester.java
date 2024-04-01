package exercise.ex74;

public class MonthNametester {

	public static void main(String[] args) {
		
		System.out.println("*** MonthName test start ***");
		
		for (int i = 0; i < 14; i++) {
			
			String name = MonthName.getName(i);
			if(name == null) {
				System.out.println(i + "月:" + "月の指定が範囲外");
			} else {
				System.out.println(i + "月:" + name);
			}
		}
		System.out.println("*** MounthName test stop ***");

	}

}
