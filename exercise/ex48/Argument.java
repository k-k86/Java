package exercise.ex48;

class Argument {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage : java Argument <string>...");
			return;
		}
		for (String arg : args) {
			if(arg.equals(".")){
				System.out.println();
			} else {
				System.out.print(arg + " ");
			}
		}
		System.out.println();
	}
}
