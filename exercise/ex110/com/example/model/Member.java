package exercise.ex110.com.example.model;

public class Member {
	
	private static int counter = 0;
	private int id;
	private String name;
	private int totalPoint;
	private MemberRank memberRank;
	
	public Member(String name, String rank) {
		this.id = ++counter;
		this.name = name;
		this.totalPoint = 0;
		this.memberRank = MemberRankParty.getMemberRank(rank);
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getTotalPoint() {
		return totalPoint;
	}
	
	/**
	 * 買い物金額に対する獲得ポイントを取得する。
	 * @param salePrice 買い物金額
	 */
	public int getPoint(int salePrice) {
		return memberRank.getPoint(salePrice);
	}
	/**
	 * 指定したポイントを保有ポイントに加算する。
	 * @param point
	 */
	public void addPoint(int point) {
		totalPoint += point;
	}
	
	/**
	 * 指定した会員ランクをセットする。
	 * @param rank 会員ランクを表す文字列
	 */
	public void setMemberRank(String rank) {
		this.memberRank = MemberRankParty.getMemberRank(rank);
	}
	
	public String toString() {
		return "会員 ID=" + id + ", 会員名=" + name + ", 保有ポイント=" + totalPoint + ", 会員ランク= [" + memberRank + "]";
	}
	
	

}
