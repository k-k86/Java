package exercise.ex92.com.exemple.model;
/**
 * 誕生日を表すクラス
 * @version 1.0
 * @author i-Learning
 */
public class Birthday {

	/**
	 * 誕生日を意味する8桁(yyyymmdd:西暦4桁,月2桁,日2桁)のint型の整数
	 */
	private int birthday;
	
	/**
	 * 指定された誕生日をもつBirthdayオブジェクトを作成する。
	 * 引数として誕生日を受け取り、フィールドbirthdayにセットする。
	 * @param birthday 誕生日を意味する8桁(yyyymmdd：西暦年4桁,月2桁,日2桁)の整数
	 */
	public Birthday(int birthday){
		this.birthday = birthday;
	}
	/**
	 * 指定された日付の時点の年齢を取得する。引数として今日の日付を受け取り、誕生日との差から年齢を算出する。
	 * なお、年齢の妥当性(負の値、生存できない年齢など)のチェックは行わない。
	 * @param today 今日の日付を意味する8桁の整数
	 * @return 求めた年齢
	 */
	public int getAge(int today) {
		
		int age = (today - birthday) / 10000;
		return age;
	}
	/**
	 * オブジェクトの文字列表現を取得する。
	 * @return "yyyy年mm月dd日生"の形式の文字列
	 */
	@Override
	public String toString() {
		
		int year = birthday / 10000;
		int mounth = birthday / 100 % 100;
		int day = birthday % 100;
		
		return year + "年" + mounth + "月" + day + "日生";
	}
	
}
