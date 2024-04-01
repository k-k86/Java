package exercise.ex32;

public class Sales {

	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
			
		double com = 0.03;
			
		System.out.println("販売金額を入力してください。");
		int price = scan.nextInt();
			
		System.out.println("分割回数を入力してください。");
		int splitPrice = scan.nextInt();
			
		System.out.println("販売金額(円)  :  " + price);
		System.out.println("分割回数(1～12)  :  " + splitPrice);
		System.out.println();
			
		if(splitPrice < 1 || splitPrice > 12) {
			System.out.println("指定された回数での分割は出来ません。");
				
		}
		if ( splitPrice == 1) {
			
			System.out.println("支払総額(円) = " + price + "円");
		}
			
		if(splitPrice > 1 && splitPrice < 13) {
				
			int comPrice =  (int) (price * com);
			System.out.println("分割手数料" + comPrice + "円");
			int totalPrice = comPrice + price;
			System.out.println("支払総額" + totalPrice + "円");
			
			int firstPay = totalPrice / splitPrice + (totalPrice % splitPrice);
			System.out.println("１回目支払額 = " + firstPay + "円");
			int secondPay = totalPrice / splitPrice;
			System.out.println("２回目支払額 = " + secondPay + "円");
		}
	}
}
