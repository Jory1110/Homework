import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/* Class: Client
 * 
 * @author Robert Jory Alexander 
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: January 12, 2016
 * 
 * 
 * This class: Describes the client data used to contain the Pet data. It also
 * contains the main method that runs the program.
 * 
 * Purpose: Methods and attributes used to describe Client list of Pet type items.
 * This Class also has the 
 * 
 */

public class Client {
	
	//ArrayList to hold actual Pet data
	private ArrayList<Pet> PetData = new ArrayList<Pet>();
	
	
	/*
	 * Method: printClientList
	 * 
	 * This method prints out the Client data in a readable format. This relies on the toString() method of the Pet class
	 * and subclasses
	 */
	
	public void printClientList()
	{
		for(int i = 0; i < PetData.size(); i++)
		{
			Pet temp = PetData.get(i);
			System.out.println(temp);
		}
	}
	
	public void outputClientList(String fileName)
	{
		PrintWriter out = null;
		try 
		{
			out = new PrintWriter(fileName);
			//out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < PetData.size(); i++)
		{
			
			
			//Write to file all things common to each game type
			
			out.println(PetData.get(i).getPetName());
			out.println(PetData.get(i).getOwnerName());
			out.println(PetData.get(i).getAge());
			out.println(PetData.get(i).getPetType());
			
			//if statement that looks at the pet type and determines what attributes need to be written.
			
			if(PetData.get(i).getPetType().equalsIgnoreCase("dog"))
			{
				// cast to the dog object
				
				Dog dog = (Dog) PetData.get(i);
				
				//output the dog related attributes
				
				out.println(dog.getBreed());
				out.println(dog.getColor());
				
			}
			else if(PetData.get(i).getPetType().equalsIgnoreCase("cat"))
			{
				// cast to the cat object
				
				Cat cat = (Cat) PetData.get(i);
				
				//output the cat related attributes
				
				out.println(cat.isLongHair());
				out.println(cat.isDeclawed());
				out.println(cat.getColor());
				
			}else
			{
				//cast to the abnormal pet type
				AbnormalPet strange = (AbnormalPet) PetData.get(i);
				
				//output the abnormal pet attributes
				
				out.println(strange.isSpecialHandleing());
				
			}
		}
		
		out.close();
	}
	
	/*
	 * Method: findByPetName
	 * 
	 * This method finds a pet in the array list by the pets name
	 * 
	 * @parameter petName
	 * @return Pet
	 */
	
	public Pet findByPetName(String petName)
	{
		
		Pet temp = null;
		for(int i = 0; i < PetData.size(); i++)
		{
			if(PetData.get(i).getPetName().equalsIgnoreCase(petName))
			{
				temp = PetData.get(i);
			}
			
		}
		return temp;
		
	}
	
	/*
	 * Method: RemoveClient
	 * 
	 * This method removes a client based on the pet name
	 * 
	 * @parameter petName
	 */
	
	public void removeClient(String petName)
	{
		for(int i = 0; i < PetData.size(); i++)
		{
			if(PetData.get(i).getPetName().equalsIgnoreCase(petName))
			{
				PetData.remove(i);
			}
		}
	}
	
	/*
	 * Method: addClient
	 * 
	 * this method adds a client to the system
	 * 
	 * @parameter Pet
	 */
	
	public void addClient(Pet addMe)
	{
		PetData.add(addMe);
	}

	//This is the main method that executes the program
	
	public static void main(String[] args)
	{
		//creates a client list
		
		Client MyClientList = new Client();
		
		//open a file
		
		File ClientFile = new File("ClientList.txt");
		
		//opens a scanner object
		
		Scanner ClientReader;
		
		
		//attempts to read in the client file and break it into its parts
		
		try
		{
			ClientReader = new Scanner(ClientFile);
			
			//a for loop that runs while while there is a next line in the file
			
			while(ClientReader != null && ClientReader.hasNext())
			{
				//Separates the lines into different attributes pertaining to all pets
				
				String petName = ClientReader.nextLine();
				String ownerName = ClientReader.nextLine();
				String ageString = ClientReader.nextLine();
				int age = Integer.parseInt(ageString);
				String petType  = ClientReader.nextLine();
				
				if(petType.equalsIgnoreCase("cat"))
				{
					//Separates the line into different attributes specific to cats
					
					String declawedString = ClientReader.nextLine();
					boolean declawed = Boolean.parseBoolean(declawedString);
					String  longHairString = ClientReader.nextLine();
					boolean longHair = Boolean.parseBoolean(longHairString);
					String color = ClientReader.nextLine();
					
					// creates a cat object with all recorded attributes
					
					Cat temp = new Cat(petName,ownerName,age,petType,declawed,longHair,color);
					
					// adds the Cat Object to MyClientList
					
					MyClientList.addClient(temp);
					
				}
				else if(petType.equalsIgnoreCase("dog"))
				{
					//separates the line into different attributes specific to dogs
					
					String breed = ClientReader.nextLine();
					String color = ClientReader.nextLine();
					
					// creates a dog object with all recorded attributes
					
					Dog temp = new Dog(petName,ownerName,age,petType,breed,color);
					
					//adds the dog object to MyClientLIst
					
					MyClientList.addClient(temp);
					
				}
				else
				{
					//separates the lines into different attributes specific to non dog and cat pets
					
					String specialHandleingString = ClientReader.nextLine();
					boolean specialHandleing = Boolean.parseBoolean(specialHandleingString);
					
					// creates an AbnormalPet object  with all recorded attributes
					
					AbnormalPet temp = new AbnormalPet(petName,ownerName,age,petType,specialHandleing);
					
					//adds the abnormalpet object to myClientList
					
					MyClientList.addClient(temp);
				}
			}
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("No clients are found. The client list is empty!");
		}
		
		
		
		// creates a scanner object for keyboard input
		
		Scanner keyboard = new Scanner(System.in);
		
		// boolean that will be used to determine if the user had indicated they are finished with the program
		
		boolean finished = false;
		
		// while loop that runs until the user indicates they are finished
		
		while(finished != true)
		{
			
			//Prompts to user for input
			
			System.out.println("Welcome to the Veternary Client Information System!");
			System.out.println();
			System.out.println("Would you like to: ");
			System.out.println("1. Search the inventory for a specific pet?");
			System.out.println("2. Remove a pet from the System");
			System.out.println("3. Add a client to the System");
			System.out.println("4. See the Client list");
			System.out.println("5. Exit");
			
			//records the users input
			
			int input = keyboard.nextInt();
			
			//if statement that determines the input of the user
			
			if(input == 1)
			{
				//prints out a request for the pet name
				
				System.out.println("What is the name of the pet you are looking for?");
				
				//records pet name from the scanner 
				
				String petName = keyboard.next();
				
				if(MyClientList.findByPetName(petName) != null)
				{
					//outputs the pet information
					
					System.out.println(MyClientList.findByPetName(petName));
				}
				else
				{
					//outputs a message in case the pet is not found
					
					System.out.println("These are not the pets you're looking for.");
					System.out.println("We're sorry but we were unable to find your pet");
				}
					
			}
			else if(input == 2)
			{
				//prompts user for the name of the pet they would like to remove
				
				System.out.println("What is the name of the pet you would like to remove?");
				
				// records user input into petName
				
				String petName = keyboard.next();
				
				if(MyClientList.findByPetName(petName) != null)
				{
					//removes the pet from the system
					
					MyClientList.removeClient(petName);
					
					//outputs message letting person know that the client has been removed
					System.out.println(petName + " has been removed");
				}
				else
				{
					//outputs a message if the client is not found
					
					System.out.println("These are not the pets you're looking for.");
					System.out.println("We're sorry but we were unable to find your pet");
					System.out.println("No clients were removed from the system");
				}
				
			}
			else if(input == 3)
			{
				//prompts user for the type of pet they would like to add
				
				System.out.println("What kind of pet would you like to add");
				
				//stores the input in a String called petType
				String petType = keyboard.next();
				
				//if statement to determine if the user input a cat dog or other
				
				if(petType.equalsIgnoreCase("dog"))
				{
					//asks user for the dogs name and stores information in a String called petName
					
					System.out.println("What is the dogs name?");
					String petName = keyboard.next();
					
					//asks user for the owners name and stores information in the string called ownerName
					
					System.out.println("What is the owners name?");
					String ownerName = keyboard.next();
					
					//asks user for the dogs age and store the information in the int called age
					
					System.out.println("What is the age of the dog?");
					int age = keyboard.nextInt();
					
					//asks the user for the breed of the dog and store the information in the string breed
					
					System.out.println("What is the dogs breed?");
					String breed = keyboard.next();
					
					//asks the user for the color of the dog and store the information in the string color
					
					System.out.println("What color is the dog?");
					String color = keyboard.next();
					
					//creates a dog object from the gathered information
					
					Dog addMe = new Dog(petName, ownerName, age, petType, breed, color);
					
					// adds the dog object to MyClientList
					
					MyClientList.addClient(addMe);
					
					//outputs a message letting the user know that the client has been added
					
					System.out.println(petName + " has been added to the system.");
				}
				else if(petType.equalsIgnoreCase("cat"))
				{
					//asks user for the cat name and stores information in a String called petName
					
					System.out.println("What is the cat's name?");
					String petName = keyboard.next();
					
					//asks user for the owners name and stores information in the string called ownerName
					
					System.out.println("What is the owner's name?");
					String ownerName = keyboard.next();
					
					//asks user for the cat age and store the information in the int called age
					
					System.out.println("What is the age of the cat?");
					int age = keyboard.nextInt();
					
					//asks user if the the cat has long hair then stores the data in a string called longHairString and then parses the information 
					//to a boolean called longHair
					
					System.out.println("The cat has long hair? True/False?");
					String longHairString = keyboard.next();
					boolean longHair = Boolean.parseBoolean(longHairString);
					
					//asks the user if the cat is declawed then stores the data in a string called declawedString then parses the information
					//to a boolean called declawed
					
					System.out.println("The cat is declawed? True/False");
					String declawedString = keyboard.next();
					boolean declawed =  Boolean.parseBoolean(declawedString);
					
					//asks the user what the cats color is then stores the information in a String called color
					
					System.out.println("What is the color of the cat's fur?");
					String color = keyboard.next();
					
					//store the gathered attributes into a Cat item called addMe
					
					Cat addMe = new Cat(petName, ownerName, age, petType, longHair, declawed, color);
					
					//adds the cat item addme into MyclientList
					
					MyClientList.addClient(addMe);
					
					//lets user know that their cat has been added to the client list
					
					System.out.println(petName + " has been added to the system.");
					
				}
				else
				{
                    //asks user for the pets name and stores information in a String called petName
					
					System.out.println("What is the "  + petType+ " name?");
					String petName = keyboard.next();
					
					//asks user for the owners name and stores information in the string called ownerName
					
					System.out.println("What is the owner's name?");
					String ownerName = keyboard.next();
					
					//asks user for the pets age and store the information in the int called age
					
					System.out.println("What is the age of the " + petType + "?");
					int age = keyboard.nextInt();
					
					//asks the user if the pet requires any special handling then store the input in a string called specialHandleingString
					//the String is then parsed into a boolean called specialHandleing
					
					System.out.println(petType + " requires special handling? True/False");
					String specialHandleingString = keyboard.next();
					boolean specialHandleing = Boolean.parseBoolean(specialHandleingString);
					
					// creates an Abnormal pet object with the gathered attributes
					
					AbnormalPet addMe = new AbnormalPet(petName, ownerName, age, petType, specialHandleing);
					
					//adds the AbnormalPet object into MyClientList
					
					MyClientList.addClient(addMe);
					
					//Tells user that the pet has been added
					
					System.out.println(petName + " has been added to the system.");
					
				}
			}
			else if(input == 4)
			{
				
				//print out the client list
				
				MyClientList.printClientList();
			}
			else if(input == 5)
			{
				//lets user know that the session has ended and sets finished to true ending the program
				
				System.out.println("Session has ended.");
				MyClientList.outputClientList("ClientList.txt");
				finished = true;
				
                
			}
			else
			{
				
				
				System.out.println("You have entered an invaled command. Please try agian.");
				System.out.println();
				
				
			}
			
		}
		
		keyboard.close();
		
	}
}

	
