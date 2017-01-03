/**
 * Class: AnimalHash
 * 
 * @author Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: February 19, 2016
 * 
 * 
 * This class: This class contains the main method that reads in the file animal.dat reads the animal objects into a hash map
 * with corresponding double values representing amounts owed. Then prints out the information in a user friendly purpose. The
 * names of the animals are then stored into a binary tree and printed out in alphabetical order
 * 
 * Purpose: to read in a binary file add the objects into a hash map and print out the information stored in the hash map in
 * a user friend way. then to store the name instance variable of the binary object into a binary tree and print out the contents
 * in alphabetical order
 *         
 *
 */



import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Random;

public class AnimalHash {
	/*
	 * Method main()
	 * 
	 * main method that contains the information on how read in information for a file
	 * add it to both a hashmap and binary tree then print out the data in a useful format
	 * 
	 * @param args
	 */
	public static void main(String [] args)
	{
		//creates an AnimalHashMap object called animals
		AnimalHashMap animals = new AnimalHashMap();
		
		
		//creates a Random object call x that is used to randomly populate the value in the hash map
		Random x = new Random();
		
		//try catch statement that reads in the file animal.dat and adds the objects into
		//a hash map
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("animal.dat"))){
			
			while(true)
			{
				Animal fred = (Animal) input.readObject();
				animals.put(fred, x.nextDouble()*1000);
			}
			
			
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(EOFException e)
		{
			
			//breaks out at end of file and closes the ObjectInputStream object input
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//hash set x1 that contains the animal objects 
		HashSet<Animal> x1 = (HashSet<Animal>) animals.keySet();
		
		
		System.out.println("Amount Owed:");
		
		//iterates through the hash set x1 and prints out the animal object and then gets the value associated
		for(Animal s: x1)
		{
			System.out.println(s.getAnimalName() + " owes $" + String.format( "%.2f", animals.get(s )));
		}
		
		System.out.println();
		// creates a tree object
		BST<String> tree = new BST<String>();
		//populates the tree with animal names
		for(Animal s: x1)
		{
			tree.insert(s.getAnimalName());
		}
		//prints out the tree in using inorder traversal
		System.out.println("The animals names read from a tree are");
		tree.inorder();
		
		
		
	}

}
