import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonInPutObject {
	
	public static void main(String [] args) throws IOException
	{
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("peopleOutput.dat"));
			
			Person p1 = (Person) input.readObject();
			Person p2 = (Person) input.readObject();
			Person p3 = (Person) input.readObject();
			
			
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			System.out.println(p3.toString());
			
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
