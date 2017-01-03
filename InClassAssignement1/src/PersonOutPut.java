import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
 * This class: This class creates 3 instances of the class Person and then outputs the attributes to a file named people.data
 * 
 * Purpose: creates a file called people.dat that contains information for 3 person objects
 *         
 * this is for part 1 of assignment 1 
 */
public class PersonOutPut {

	public static void main(String[] args) throws IOException {
		
		//create 3 instances of person
		
		Person Fred = new Person("Fred","Savage",8,"Paris");
		Person Alice = new Person("Alice", "Cooper", 10, "Atlanta");
		Person Adam = new Person ("Adam", "Savage", 88, "Auburn");
		
		DataOutputStream output;
		
		try {
			 output = new DataOutputStream(new FileOutputStream("people.dat"));
			 
			 output.writeUTF(Fred.getFirstName());
			 output.writeUTF(Fred.getLastName());
			 output.writeInt(Fred.getIdNum());
			 output.writeUTF(Fred.getCity());
			 
			 output.writeUTF(Alice.getFirstName());
			 output.writeUTF(Alice.getLastName());
			 output.writeInt(Alice.getIdNum());
			 output.writeUTF(Alice.getCity());
			 
			 output.writeUTF(Adam.getFirstName());
			 output.writeUTF(Adam.getLastName());
			 output.writeInt(Adam.getIdNum());
			 output.writeUTF(Adam.getCity());
			 
			 
			 output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
