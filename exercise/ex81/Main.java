package exercise.ex81;

public class Main {

	public static void main(String[] args) {
		
		int x = 100;
		int y = 200;
		
		Calc calc = new Calc();
		
		System.out.println("max: " + calc.max(x,y));
		System.out.println("even: " + calc.isEven(x));
		
	}

}
