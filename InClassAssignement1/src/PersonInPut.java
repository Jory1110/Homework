import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class: PersonOutPut
 * 
 * @author Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: January 19, 2016
 * 
 * 
 * This class: Reads in data from the person.dat file and puts this information into the data 
 * for 3 Person objects then outputs the objects using the toString() method
 * 
 * Purpose: creates 3 person objects using the person.dat file and then outputs the data using toString()
 *         
 *
 * This is Part 1 of in class assignment 1
 */
public class PersonInPut {
	
	public static void main(String [] args) throws IOException
	{
		try {
			DataInputStream input = new DataInputStream(new FileInputStream("people.dat"));
			
			Person p1 = new Person(input.readUTF(),input.readUTF(),input.readInt(),input.readUTF());
			Person p2 = new Person(input.readUTF(),input.readUTF(),input.readInt(),input.readUTF());
			Person p3 = new Person(input.readUTF(),input.readUTF(),input.readInt(),input.readUTF());
			
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			System.out.println(p3.toString());
			
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
