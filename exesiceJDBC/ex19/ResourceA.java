package ex19;

public class ResourceA implements AutoCloseable {
	
	public ResourceA() {
		System.out.println("A create");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("A close");
	}

}
