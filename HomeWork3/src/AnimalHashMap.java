/**
 * Class: AnimalHashMap
 * 
 * @author Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: February 19, 2016
 * 
 * 
 * This class: This class contains all the methods necessary to create a HashMap of animal objects. 
 * 
 * Purpose: gives instructions on how to create a hash map with an array of Node objects acting as a linked list.
 *         
 *
 */


import java.util.HashSet;
import java.util.Set;


public class AnimalHashMap implements MyMap<Animal, Double> {
	
	//creates an arry of node objects called buckets
	private Node[] buckets;
	// creates an int final that acts as the default size for the hash map
	private final int DEFAULT_SIZE = 30;
	// in value that stores the size of the hash map initiallyh set to 0
	private int size = 0;

	/**
	 * Method AnimalHashMap()
	 * 
	 * no arg constructor for the AnimalHashMap class sets the size of the Node array to the Default size
	 * 
	 * 
	 */
	public AnimalHashMap() {
		buckets = new Node[DEFAULT_SIZE];

	}

	/**
	 * Method size()
	 * 
	 * returns the current size of the hash map
	 * 
	 * @return size
	 */
	public int size() {
		return size;
	}

	/**
	 * Method containsKey()
	 * 
	 * checks to see if the hash map contains a particular key
	 * 
	 * @return boolean
	 * @param key
	 */
	@Override
	public boolean containsKey(Animal key) {
		
		int index = hash(key.hashCode());
		
			Node bucket = buckets[index];

			while (bucket != null) {
				if (key.equals(bucket.data.key)) {
					return true;
				}
				bucket = bucket.next;
			}
		
		return false;
	}

	/**
	 * Method containsValue()
	 * 
	 * method that checks to see if a particular value is stored within the hash map
	 * 
	 * @return boolean
	 * @param value
	 */
	@Override
	public boolean containsValue(Double value) {
		for (int i = 0; i < buckets.length; i++) {
			Node bucket = buckets[i];

			while (bucket != null) {
				if (value.equals(bucket.data.value)) {
					return true;
				}
				bucket = bucket.next;
			}
		}
		return false;
	}

	/**
	 * Method entrySet()
	 * 
	 * returns a set of Entry Objects
	 * 
	 * @return Set<MyMap.Entry<Animal, Double>>
	 */
	@Override
	public Set<MyMap.Entry<Animal, Double>> entrySet() {
		Set<MyMap.Entry<Animal, Double>> set = new HashSet<MyMap.Entry<Animal, Double>>();

		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				Node bucket = buckets[i];
				while (bucket != null) {
					set.add(bucket.data);
					bucket = bucket.next;
				}

			}
		}

		return set;
	}

	/**
	 * Method get()
	 * 
	 * get the value associated with the specific animal object key
	 * 
	 * @return Double
	 * @param key
	 */
	@Override
	public Double get(Animal key) {
		int index = hash(key.hashCode());

		Node current = buckets[index];
		if (current != null) {

			return current.data.getValue();
		}

		return null;
	}

	/**
	 * Method keySet()
	 * 
	 * returns all the key objects in  the hash set
	 * 
	 * @return Set<Animal>
	 */
	@Override
	public Set<Animal> keySet() {
		Set<Animal> set = new HashSet<Animal>();

		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				Node bucket = buckets[i];
				while (bucket != null) {
					set.add(bucket.data.getKey());
					bucket = bucket.next;
				}

			}
		}

		return set;
	}

	/**
	 * Method put()
	 * 
	 * adds keys and values to the hash map
	 * 
	 * @return Double
	 * @param key
	 * @param value
	 */
	
	@Override
	public Double put(Animal key, Double value) {
		
		
		
		if (key != null) {

			int index = hash(key.hashCode());

			Node current = buckets[index];
			while (current != null) {

				if (current.data.getKey().equals(key)) {

					// Replace old value with new value
					current.data.value = value;

					// Return the old value for the key
					return value;
				}
				current = current.next;

			}
			// not contained need to add
			Entry<Animal, Double> newEntry = new Entry<Animal, Double>(key, value);
			Node newNode = new Node();

			newNode.data = newEntry;
			newNode.next = buckets[index];
			buckets[index] = newNode;
		}

		return null;
	}

	/**
	 * Method remove()
	 * 
	 * removes Animal keys and their associated values from the hash map
	 * 
	 * @param Animal key
	 */
	@Override
	public void remove(Animal key) {
		int bucketIndex = key.hashCode();

		// Remove the first entry that matches the key from a bucket
		if (buckets[bucketIndex] != null) {
			Node bucket = buckets[bucketIndex];
			while(bucket != null)
				if (bucket.data.getKey().equals(key)) {
					bucket.data = null;
					size--; // Decrease size
					break; // Remove just one entry that matches the key
				}
		}

	}

	/**
	 * Method values()
	 * 
	 * returns a set of the values 
	 * 
	 * @return Set<Double>
	 */
	@Override
	public Set<Double> values() {
		java.util.Set<Double> set = new java.util.HashSet<Double>();

		for (int i = 0; i < buckets.length; i++) {
			
				Node bucket = buckets[i];
				while (bucket != null) {
					set.add(bucket.data.getValue());
					bucket = bucket.next;
				}
			
		}
		return set;
	}

	/**
	 * Method clear()
	 * 
	 * clears out the hash map
	 * 
	 */
	@Override
	public void clear() {

		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
		size = 0;

	}

	/**
	 * Method isEmpty()
	 * 
	 * returns true if the map is empty
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method hash()
	 * 
	 * hashes the animal object to a value within the hash map
	 * 
	 * @return int
	 * @param hashCode
	 */
	private int hash(int hashCode) {
		return supplementalHash(hashCode) & (DEFAULT_SIZE - 1);
	}

	/**
	 * Method suplementalHash()
	 * 
	 * makes sure the hash code for the object is within the size of the hash map
	 * 
	 * @param h
	 */
	private static int supplementalHash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	//creates a node class containing an array object and another Node
	class Node {
		public Entry<Animal, Double> data;
		public Node next;
	}
}
