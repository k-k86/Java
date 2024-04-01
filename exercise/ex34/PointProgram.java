package exercise.ex34;

public class PointProgram {

	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		System.out.println("会員ランク種別 { regular | silver | gold }");
		String rank = scan.nextLine();
		
		System.out.println("お買い物した金額を入力してください。");
		int pay_price = scan.nextInt();
		
		String rankX;
		int point;
		
		switch(rank) {
		
		case "regular":
			
			rankX = "regular";
			point = (int) (pay_price * 0.03);
			
			break;
			
		case "silver":
			
			rankX = "silver";
			point = (int) (pay_price * 0.05);
			
			break;
			
		case "gold":
			
			rankX = "gold";
			point = (int) (pay_price * 0.07);
			
			break;
			
		default:
			
			System.out.println("会員ランク  :  " + rank);
			System.out.println("会員ランクを識別できません");
			return;
		}
		
		System.out.println("会員ランク   :  " + rankX);
		System.out.println("お買い物金額 : " + pay_price);
		System.out.println("獲得ポイント = " + point);
		

	}

}
