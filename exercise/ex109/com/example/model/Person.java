package exercise.ex109.com.example.model;

public class Person {
	/**
	 * 保有スキルの上限をあらかじめ3で設定
	 */
	private static final int MAX_COUNT = 3;
	/**
	 * 登録する社員の名前
	 */
	private String name;
	/**
	 * 登録する社員が持つスキル
	 */
	private Skill skills[];
	/**
	 * 社員が持つ保有スキルの数
	 */
	private int skillCount = 0;
	
	
	/** 
	 * new Person()した時に実行され、配列Skillの要素数を定数MAX_COUNTで設定する。
	 * 引数で受け取った社員名を変数nameに入れる
	 * 
	 * @param name
	 */
	public Person(String name) {
		this.name = name;
		skills = new Skill[MAX_COUNT];
	}
	/**
	 * 保有スキルを追加する。
	 * もし保有スキルが3より多い場合はエラーを表示する。3より少ない場合は保有スキルを追加する。
	 * @param skill
	 */
	public void addSkill(Skill skill) {
		
		if(skillCount >= MAX_COUNT) {
			System.err.println("Person:" + name + " skill overflow!");
			return;
		}
		
		skills[skillCount++] = skill;
	}
	/**
	 * 保有スキルを文字列で取得する
	 * @return 保有スキルを表す文字列
	 */
	public String getSkill() {
		String skillsStr = "[";
		for (int i = 0; i < skillCount; i++) {
			skillsStr += " " + skills[i].getInfo();
		}
		skillsStr += " ]";
		return skillsStr;
	}
	
	public String toString() {
		return name + ",保有スキル" + getSkill();
	}

}
