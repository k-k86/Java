package exercise.ex110.com.example;

import exercise.ex110.com.example.model.Member;

public class PointProgram {

	public static void main(String[] args) {
		
		Member[] members = {
			new Member("Suzuki", "regular"),  new Member("Ueda", "silver"),
			new Member("Tanaka", "gold"), new Member("Kato", "????"), 
		};
		
		for(Member member : members) {
			int point = member.getPoint(3000);
			System.out.println(member.getName() + "\t さん" + "3000円の買い物:獲得ポイント= " + point);
			member.addPoint(point);
			
			point = member.getPoint(7000);
			System.out.println(member.getName() + "\t さん" + "7000円の買い物:獲得ポイント= " + point);
			member.addPoint(point);
		}
		System.out.println();
		
		for(Member member : members) {
			System.out.println(member);
		}
		
	}

}
