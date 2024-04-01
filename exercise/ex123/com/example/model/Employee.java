package exercise.ex123.com.example.model;

public class Employee extends Person {
	
	private String id;
	private int hireDate;
	Company company = new Company();
	
	public Employee(){
		
	}
	
	public Employee(String name, String id, int hireDate, Company company){
		
		super(name);
		this.id = id;
		this.hireDate = hireDate;
		this.company = company;
		
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "Employee[id=" + id + ", 入社日=" + hireDate + "," + company.toString();
		
	}

}
