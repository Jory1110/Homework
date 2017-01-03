package Classes;

import java.util.ArrayList;

public class Class {
	
	ArrayList<Student> students;
	
	public Class()
	{
		students = new ArrayList<>();
	}
	
	public void add(Student s)
	{
		this.students.add(s);
	}
	
	public void delete(Student s)
	{
		if(students.contains(s))
		{
			students.remove(s);
		}
	}
}
