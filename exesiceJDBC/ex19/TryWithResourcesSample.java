package ex19;

public class TryWithResourcesSample {

	public static void main(String[] args) {
		
		System.out.println("- Start");
		
		try (ResourceA ra = new ResourceA();
			ResourceB rb = new ResourceB();) {
			System.out.println("> try");
			throw new Exception();
			
		} catch (Exception e) {
			System.out.println("> catch");
		}
		System.out.println("- Stop");
		
	}

}
