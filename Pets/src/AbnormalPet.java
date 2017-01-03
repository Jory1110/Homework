/**
 * Class: Dog
 * 
 * @author Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: January 09, 2016
 * 
 * 
 * This class: This class describes a subclass of Pet called AbnormalPet
 * 
 * Purpose: Contains the attributes specific to a type of Pet that would be considered abnormal (neither a cat or dog)
 *         
 *
 */

public class AbnormalPet extends Pet {
	
	private boolean specialHandleing;
	
	/*
	 * Method AbnormalPet()
	 * 
	 * Constructor method that sets the attributes for the
	 * AbnormalPet class
	 * 
	 * @param petName
	 * @param ownerName
	 * @param age
	 * @param petType
	 * @param specialHandleing
	 */
	
	public AbnormalPet(String petName, String ownerName, int age, String petType, boolean specialHandleing)
	{
		super(petName, ownerName, age, petType);
		this.specialHandleing = specialHandleing;
	}

	/**
	 * Method isSpecialHandleing()
	 * 
	 * getter method for specialHandleing attribute
	 * 
	 * @return the specialHandleing
	 */
	
	public boolean isSpecialHandleing() {
		return specialHandleing;
	}

	/**
	 * Method setSpecialHandleing
	 * 
	 * setter method for specialHandleing attribute
	 * 
	 * @param specialHandleing
	 */
	
	public void setSpecialHandleing(boolean specialHandleing) {
		this.specialHandleing = specialHandleing;
	}
	
	/*
	 * Method toString()
	 * 
	 * returns the attributes of the AbnormalPet class to 
	 * a readable format
	 * 
	 * @return String
	 */
	
	public String toString()
	{
		return super.toString() + ", Requires Special Handleing: " + specialHandleing;
	}

}
