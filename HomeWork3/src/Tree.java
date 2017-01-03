/**
 * InterFace: Tree
 * 
 * @author Robert Jory Alexander, Whoever originally wrote this interface Robert just added appropriate comments 
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: February 23, 2016
 * 
 * 
 * This interface contains the methods required to implement a tree
 * 
 * Purpose: to force any class that implements this interface to use these methods
 *         
 *
 */

public interface Tree<E> extends Iterable<E> {
	/**
	 * Method hash()
	 * 
	 * returns true i the element is in the tree
	 * 
	 * @return boolean
	 * @param E 
	 */
  
  public boolean search(E e);

  /**
	 * Method insert()
	 * 
	 * hashes the animal object to a value within the hash map
	 * 
	 * @return int
	 * @param hashCode
	 */
  /** Insert element o into the binary tree
   * Return true if the element is inserted successfully */
  public boolean insert(E e);
  /**
	 * Method hash()
	 * 
	 * hashes the animal object to a value within the hash map
	 * 
	 * @return int
	 * @param hashCode
	 */
  /** Delete the specified element from the tree
   * Return true if the element is deleted successfully */
  public boolean delete(E e);
  /**
	 * Method hash()
	 * 
	 * inorder traversal from the root
	 * 
	 * 
	 */
  
  public void inorder();
  /**
	 * Method postorder()
	 * 
	 * Postorder traversal from the root
	 * 
	 */
  
  public void postorder();
  /**
	 * Method preorder()
	 * 
	 * Preorder traversal from the root
	 * 
	 */
  public void preorder();
  /**
	 * Method getSize()
	 * 
	 * Get the number of nodes in the tree
	 * 
	 * @return int
	 */
  public int getSize();
  /**
	 * Method isEmpty()
	 * 
	 * return true if the tree is empty
	 * 
	 * @return boolean
	 */
 
  public boolean isEmpty();
}
