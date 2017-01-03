/**
 * Class: AbstractTree<E>
 * 
 * @author Robert Jory Alexander, Whoever originally wrote this class Robert just added appropriate comments 
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: February 23, 2016
 * 
 * 
 * This Class: this calss adds more methods required for an tree
 * 
 * Purpose: to force any class that extends this abstract class to use these methods
 *         
 *
 */


public abstract class AbstractTree<E> implements Tree<E> {
	/**
	 * Method inorder()
	 * 
	 * In order traversal from the root
	 * 
	 */
  @Override 
  public void inorder() {
  }

  /**
	 * Method postorder()
	 * 
	 * Post order traversal from the root
	 */
  @Override 
  public void postorder() {
  }
  /**
	 * Method preorder()
	 * 
	 * Preorder travers from the root
	 * 
	 */
  @Override 
  public void preorder() {
  }
  /**
	 * Method isEmpty()
	 * 
	 * returns true if the tree is empty
	 * 
	 * @return boolean
	 */
  @Override
  public boolean isEmpty() {
    return getSize() == 0;
  }
}
