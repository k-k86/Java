package ex19;

public class ResourceB implements AutoCloseable {
	
	public ResourceB() {
		System.out.println("B create");
	}
	
	@Override
	public void close() throws Exception{
		System.out.println("B close");
	}

}
