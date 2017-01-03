/**
 * Class: AnimalHomeWork
 * 
 * @author Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: February 01, 2016
 * 
 * 
 * This class: Reads in animal objects adds the objects into an array list then reads their names into a hashset before printing
 * the hashSet and writing out the names to a binary file called names.dat
 * 
 * Purpose: Contains the instructions necessary to carry out the above task
 *         
 *
 */

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class AnimalHomeWork {

	//main method that executes program
	public static void main(String[] args) {
		
		//creates an arrayList of type animal to hold the read in animal objects
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		
		try {
			//ObjectInputStream object used to read in objects from a binary file
			
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("animal.dat"));
			
			try {
				//while loop that runs as long as there is a subsequent animal object in the binary file to be read
				while(true)
				{
					//creates the animal object and then adds it to animalList
					Animal a1 = (Animal) input.readObject();
					animalList.add(a1);
				}
				
				
			} catch (ClassNotFoundException e) {
				//prints out File Read Error if Class Not Found Exception occurs
				e.printStackTrace();
				System.out.println("File Read Error");
			}
			catch(EOFException e)
			{
				
				//breaks out at end of file and closes the ObjectInputStream object input
				input.close();
			}
		} catch (FileNotFoundException e) {
			//prints out a warning when the request file is not found
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			//prints out a warning when the request file is incorrect
			e.printStackTrace();
			System.out.println("File not found");
		}
		
		//creates a HashSet of type String called names to hold animal names
		HashSet<String> names = new HashSet<String>();
		
		//for loop that iterates through the animalList arrayList and adds the animal names to the HashSet names
		for(int i = 0; i < animalList.size();i++)
		{
			names.add(animalList.get(i).getAnimalName());
		}
		
		//enhanced for loop that goes through the HashSet names printing out each String item in the HashSet
		for(String s: names)
		{
			System.out.println(s);
		}
		
		try {
			//creates an DataOutputStream object called out that writes to a file called names.dat
			DataOutputStream out = new DataOutputStream(new FileOutputStream("names.dat"));
			
			//enhanced for loop that iterates through the HashSet names writing each element of the set to the file names.dat
			for(String s: names)
			{
				out.writeUTF(s);
			}
			
			//closes the DataOutputStream object out
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		

	}

}
