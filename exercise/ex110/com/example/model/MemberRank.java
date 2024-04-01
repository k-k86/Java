package exercise.ex110.com.example.model;

public class MemberRank {
	
	private  String rankName;
	private  int pointPercent;
	
	
	public MemberRank(String rankName, int pointPercent) {
		
		this.rankName = rankName;
		this.pointPercent = pointPercent;
	}
	
	public String getRankName() {
		return rankName;
	}
	
	public int getPointPercent() {
		return pointPercent;
	}
	/**
	 * 獲得ポイントを取得する
	 * 
	 * @param salePrice
	 * @return 買い物金額 × 会員ランクごとのポイント率の値(小数点以下切り捨て)
	 */
	public int getPoint(int salePrice) {
		return salePrice / 100 * pointPercent;
	}
	
	public String toString() {
		return rankName + "(" + pointPercent + ")";
	}

}
