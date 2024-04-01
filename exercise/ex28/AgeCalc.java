package exercise.ex28;

public class AgeCalc {
	public static void main (String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);

		System.out.println("あなたの誕生日を4桁(YYYYMMDD)で入力してください。");
		int birth = scan.nextInt();

		System.out.println("本日の日付を4桁(YYYYMMDD)で入力してください。");
		int today = scan.nextInt();

		System.out.println("birthday(yyyymmdd) : " + birth);
		System.out.println("today   (yyyymmdd) : " + today);


		System.out.println();
		
		if( birth > today) {
			
			System.out.println("年齢月日に未来の日付は指定できません。");
		} else {
			
		System.out.println("age = " + (today - birth) / 10000);
		}
	}
}