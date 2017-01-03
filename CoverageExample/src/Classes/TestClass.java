package Classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {

	Class myClass = new Class();
	@Test
	public void testAdd() {
		Student s = new Student("Tom","Hanks");
		myClass.add(s);
		assertTrue(myClass.students.contains(s));
		
	}
	
	@Test
	public void testDelete()
	{
		Student s = new Student("Tom","Hanks");
		myClass.add(s);
		
		if(myClass.students.contains(s))
		{
			myClass.delete(s);
			assertFalse(myClass.students.contains(s));
		}
	}

}
