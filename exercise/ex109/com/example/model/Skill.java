package exercise.ex109.com.example.model;
/**
 * 取得スキルを登録するためのクラス
 */
public class Skill {
	
	private String name;
	private String level;
/**
 * フィールド変数二つに値をセットするためのコンストラクタ
 * @param title
 * @param level
 */
	public Skill(String title, String level) {
		this.name = title;
		this.level = level;
	}
/**
 * 	呼び出し元へname(level)の形式で返す為のメソッド
 * @return スキル名(レベル)を返す。name(level)
 */
	public String getInfo() {
		return name + "(" + level + ")";
	}
}
