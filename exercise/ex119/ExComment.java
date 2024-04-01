package exercise.ex119;

public class ExComment extends Comment {
	
	private String signature;
	
	public ExComment(String signature) {
		this.signature = signature;
		
	}
	
	@Override
	public void addComment(String message) {
		super.addComment(message);
		System.out.println(signature);
	}
	
	
}
