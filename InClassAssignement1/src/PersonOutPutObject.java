import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Class: PersonOutPut
 * 
 * @author Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: January 21, 2016
 * 
 * 
 * This class: Write out 3 person objects using the ObjectOutputStream
 * 
 * Purpose: To demonstrate understanding of ObjectOUtputStream
 *         
 *
 * This is Part 2 of in class assignment 1
 */

public class PersonOutPutObject {
	
public static void main(String[] args) throws IOException {
		
		//create 3 instances of person
		
		Person Fred = new Person("Fred","Savage",8,"Paris");
		Person Alice = new Person("Alice", "Cooper", 10, "Atlanta");
		Person Adam = new Person ("Adam", "Savage", 88, "Auburn");
		
		ObjectOutputStream output;
		
		try {
			 output = new ObjectOutputStream(new FileOutputStream("peopleOutput.dat"));
			 
			 output.writeObject(Fred);
			 output.writeObject(Alice);
			 output.writeObject(Adam);
			 
			 output.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
