import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinaryFileIO
{
   

    public static void main(String[] args)
    {
       // create instance
        Pet[] pets = new Pet[3];
        pets[0] = new Pet("Mr. Jones", "A001", "Fluffy", 6);
        pets[1] = new Pet("Ms. Smith", "B001", "Spot", 1);
        pets[2] = new Pet("Mr. Simpson", "A002", "Peanut", 3);
        
        ObjectOutputStream output;
        // YOUR CODE GOES HERE
        // Write code to create a binary file in the default directory 
        try {
			output = new ObjectOutputStream(new FileOutputStream("Petss.dat"));
			
			for(int i = 0; i < pets.length;i++)
			{
				output.writeObject(pets[i]);
			}
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        // named "Petss.dat" using ObjectOutputStream
        
        //   write the contents of the string array named petst to the file you just opened
        
        
        // close the file
        
        
        
    }

}
