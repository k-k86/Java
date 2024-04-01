package exercise.ex44;

public class FizzBuzz {

	public static void main(String[] args) {
		
		String err = "";
		String err2 = "";
		if(args.length != 1) {
			
			err = "コマンドライン引数の数が不正です。";
			err2 = "Usage  :  java FizzBuzz <number>" ;
			System.out.println(err);
			System.out.println(err2);
			
			return;
		}
		
		int num = Integer.parseInt(args[0]);
		if(num <= 0) {
			
			err = "1以上の整数を指定してください。";
			err2 = "java FizzBuzz <max_number>";
		}
		
		
		for(int i = 1; i <= num; i++) {
			
			if(i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if(i % 5 ==0) {
				System.out.println("Buzz");
			} else if(i % 3 == 0) {
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}
		}
		
		
		System.out.println(err);
		System.out.println(err2);
		
	}

}
