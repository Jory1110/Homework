//Jory Alexander
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AnimalReader {

	public static void main(String[] args){
		ArrayList<Animal> aList = new ArrayList<Animal>();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("animal.dat"));
			
			while(true)
			{
				Animal fred = (Animal) in.readObject();
				aList.add(fred);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
		
		for(int i = 0; i < aList.size();i++)
		{
			System.out.println(aList.get(i));
		}

	}

}
