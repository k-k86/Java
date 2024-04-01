package exercise.ex123.com.example.model;

public class Company {
	
	private String companyName;
	private String address;
	
	public Company(){
		
	}
	
	public Company(String name, String address) {
	
		this.companyName = name;
		this.address = address;
		
	}
	/**
	public String getName() {
		
	}
	*/
	@Override
	public String toString() {
		
		return "Company[" + companyName + ",　住所=" + address + "]";
		
	}
	
	

}
