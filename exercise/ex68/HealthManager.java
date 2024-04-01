package exercise.ex68;

public class HealthManager {

	public static void main(String[] args) {
		
if (args.length > 2) {
			
			String name = args[0];
			double height = Double.parseDouble(args[1]);
			double weight = Double.parseDouble(args[2]);
			
			Healthcare healthcare = new Healthcare(name, height, weight);
			
			System.out.println("あなたは" + healthcare.getName() + "さんですね。");
			System.out.print("あなたのbmiは");
			System.out.print(healthcare.getBmi());
			System.out.println("です。");
			
		} else {
			System.out.println("java MusicPlayer <name> <height> <weight>");
		}


	}

}
