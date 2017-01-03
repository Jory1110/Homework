/**
 * Class: Dog
 * 
 * @author Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: January 09, 2016
 * 
 * 
 * This class: This class describes a subclass of Pet called Dog
 * 
 * Purpose: Contains the attributes specific to a type of Pet called
 * Dog.
 *
 */

public class Dog extends Pet {
	
	String breed;
	String color;
	
	/*
	 * Method: Dog()
	 * 
	 * Constructor method that accepts the values for all the attributes
	 * and sets them
	 * 
	 * @param petName
	 * @param ownerName
	 * @param age
	 * @param petType
	 * @param breed
	 * @param color
	 * 
	 */
	
	public Dog(String petName, String ownerName, int age, String petType, String breed, String color)
	{
		super(petName, ownerName, age, petType);
		this.breed = breed;
		this.color = color;
	}
	
	/*
	 * Method: setBreed()
	 * 
	 * Setter Method for the breed attribute
	 * 
	 * @param breed
	 */
	
	public void setBreed(String breed)
	{
		this.breed = breed;
	}
	
	/*
	 * Method: setColor()
	 * 
	 * Setter Method for the color attribute
	 * 
	 * @param color
	 */
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	/*
	 * Method: getBreed()
	 * 
	 * Getter Method for the breed attribute
	 * 
	 * @return String
	 */
	
	public String getBreed()
	{
		return breed;
	}
	
	/*
	 * Method: setColor()
	 * 
	 * Setter Method for the color attribute
	 * 
	 * @return String
	 */
	
	public String getColor()
	{
		return color;
	}
	
	/*
	 * Method: toString()
	 * 
	 * Converts the attributes of the class to a readable format
	 * 
	 * @return String
	 */
	
	public String toString()
	{
		return super.toString() + ", Breed: " + breed + ", Color: " + color;
	}

}
