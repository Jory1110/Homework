/**
 * Class: Cat
 * 
 * @author Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: January 09, 2016
 * 
 * 
 *This class: This class describes a subclass of Pet called Cat
 * 
 *Purpose: Contains the attributes specific to a type of Pet called
 *Cat.
 *
 */

public class Cat extends Pet {
	
	private boolean longHair;
	private boolean declawed;
	private String color;
	
	/*
	 * Method: Cat()
	 * 
	 * Constructor method that accepts the values for all the attributes
	 * and sets them
	 * 
	 * @param petName
	 * @param ownerName
	 * @param age
	 * @param petType
	 * @param longHair
	 * @param declawed
	 * @param color
	 * 
	 */
	
	public Cat(String petName, String ownerName, int age, String petType, boolean longHair, boolean declawed, String color)
	{
		super(petName, ownerName, age, petType);
		this.setLongHair(longHair);
		this.setDeclawed(declawed);
		this.setColor(color);
	}

	/**
	 * Method isLongHair()
	 * 
	 * Getter method for longHair attribute
	 * 
	 * @return the longHair
	 */
	
	public boolean isLongHair() {
		return longHair;
	}

	/**
	 * Method setLongHiar()
	 * 
	 * Setter method for the longHair attribute
	 * 
	 * @param longHair
	 */
	
	public void setLongHair(boolean longHair) {
		this.longHair = longHair;
	}

	/**
	 * Method isDeclawed()
	 * 
	 * Getter Method for declawed attribute
	 * 
	 * @return declawed
	 */
	
	public boolean isDeclawed() {
		return declawed;
	}

	/**
	 * Method setDeclawed
	 * 
	 * Setter method for the declawed attribute
	 * 
	 * @param declawed
	 */
	
	public void setDeclawed(boolean declawed) {
		this.declawed = declawed;
	}

	/**
	 * Method: getColor()
	 * 
	 * Getter method for the color attribute
	 * 
	 * @return the color
	 */
	
	public String getColor() {
		return color;
	}

	/**
	 * Method setColor()
	 * 
	 * Setter Method for the color attribute
	 * 
	 * @param color
	 */
	
	public void setColor(String color) {
		this.color = color;
	}
	
	/*
	 * Method toString()
	 * 
	 * converts the attributes of the class to a readable format
	 * 
	 * @return String
	 */
	
	public String toString()
	{
		return super.toString() + ", LongHair: " + longHair + ", Declawed: " + declawed + ", Color " + color;
	}

}
