/* Class: Pet
 * 
 * @author Robert Jory Alexander 
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: January 09, 2016
 * 
 * 
 * This class: This class describes the common attributes and methods
 * of a pet being collected into a client list
 * 
 * Purpose: This class is intended to serve a parent class only for
 * all different types of pets
 * 
 */


public class Pet {
	
	
	private String petName;
	private String ownerName;
	private int age;
	private String petType;
	
	/*
	 * Method:Pet()
	 * 
	 * No argument constructor method.
	 * 
	 */
	
	public Pet()
	{
		
	}
	
	/*
	 * Method:Pet()
	 * 
	 * Constructor method that accepts values for all the attributes and sets them.
	 * 
	 * @param: petName
	 * @param: ownerName
	 * @param: age
	 * @param: petType
	 */

	public Pet(String petName, String ownerName, int age, String petType)
	{
		
		this.petName = petName;
		this.ownerName = ownerName;
		this.age = age;
		this.petType = petType;
		
	}
	
	/*
	 * Method: getPetName()
	 * 
	 * Getter Method for the petName attribute
	 * 
	 * @return petName
	 */
	
	public String getPetName()
	{
		return petName;
	}
	
	/*
	 * Method: getOwnerName()
	 * 
	 * Getter Method for the ownerName attribute
	 * 
	 * @return ownerName
	 */
	
	public String getOwnerName()
	{
		return ownerName;
	}
	
	/*
	 * Method: getAge()
	 * 
	 * Getter Method for the age attribute
	 * 
	 * @return age
	 */
	
	public int getAge()
	{
		return age;
	}
	
	/*
	 * Method: getPetType()
	 * 
	 * Getter Method for the petType attribute
	 * 
	 * @return petType
	 */
	
	public String getPetType()
	{
		return petType;
	}
	
	/*
	 * Method: setPetName()
	 * 
	 * Setter Method for the petName attribute
	 * 
	 * @param petName
	 */
	
	public void setPetName(String petName)
	{
		this.petName = petName;
	}
	
	/*
	 * Method: setOwnerName()
	 * 
	 * Setter Method for the ownerName attribute
	 * 
	 * @param ownerName
	 */
	
	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}
	
	/*
	 * Method: setAge()
	 * 
	 * Setter Method for the age attribute
	 * 
	 * @param age
	 */
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/*
	 * Method: setPetType()
	 * 
	 * Setter Method for the petType attribute
	 * 
	 * @param petType
	 */
	
	public void setPetType(String petType)
	{
		this.petType = petType;
	}
	
	/**
     * Method:toString()
     * 
     * Converts attributes of class to a String
     * 
     * @return String
     */
	
	public String toString()
	{
		return "Pet Type " + petType + ", Pet name: " + petName + ", Owner Name: " + ownerName + ", Age:"  + age;
	}
	
	
	
}
