package Classes;

public class Student {
	private String firstname;
	private String lastname;
	
	public Student(String firstName, String lastName)
	{
		this.firstname = firstName;
		this.lastname = lastName;
	}
	public String fullName(String first, String last)
	{
		return first+last;
	}

}
