package exercise.ex110.com.example.model;

public class MemberRankParty {
	
	private static final MemberRank[] ranks = {
		new MemberRank("quest", 0), new MemberRank("regular", 3),
		new MemberRank("silver", 5), new MemberRank("gold", 7)
	};
	
	/**
	 * 指定した会員ランクのインスタンスを取得する
	 * @return 会員ランク名が一致する会員ランクインスタンス。
	 * 一致する会員ランクがなければ、会員ランク"guest"のインスタンスを返す。
	 */
	public static MemberRank getMemberRank(String rank) {
		
		for(MemberRank memberRank : ranks) {
			
			if(memberRank.getRankName().equals(rank)) {
				return memberRank;
			}
		}
		return ranks[0];
		
	}
}
