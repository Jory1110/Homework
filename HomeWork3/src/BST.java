/**
 * Class: AnimalHash
 * 
 * @author Robert Jory Alexander, Whoever originally wrote this class Robert just added appropriate comments 
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: February 23, 2016
 * 
 * 
 * This Class: Describes the methods necessary to create a binary search tree
 * 
 * Purpose: to give appropriate code that when implemented creates a binary search tree. 
 *         
 *
 */

public class BST<E extends Comparable<E>> 
    extends AbstractTree<E> {
  protected TreeNode<E> root;
  protected int size = 0;
 
  /**
	 * Method BST()
	 * 
	 * Constructor method that creates a default binary tree
	 * 
	 */
  public BST() {
  }
  /**
	 * Method BST()
	 * 
	 * Constructor that creates a binary tree from an array of objects
	 * 
	 * @param objects
	 */
  
  public BST(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      insert(objects[i]);
  }

  /**
	 * Method search()
	 * 
	 * Returns true if the element is in the tree
	 * 
	 * @return boolean
	 * @param e
	 */
  @Override /** Returns true if the element is in the tree */
  public boolean search(E e) {
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else // element matches current.element
        return true; // Element is found
    }

    return false;
  }
  /**
	 * Method insert()
	 * 
	 * inserts element e into the binary tree
	 * returns true if the element is inserted successfully
	 * 
	 * @return boolean
	 * @param e
	 */
  @Override 
  public boolean insert(E e) {
    if (root == null)
      root = createNewNode(e); // Create a new root
    else {
      // Locate the parent node
      TreeNode<E> parent = null;
      TreeNode<E> current = root;
      while (current != null)
        if (e.compareTo(current.element) < 0) {
          parent = current;
          current = current.left;
        }
        else if (e.compareTo(current.element) > 0) {
          parent = current;
          current = current.right;
        }
        else
          return false; // Duplicate node not inserted

      // Create the new node and attach it to the parent node
      if (e.compareTo(parent.element) < 0)
        parent.left = createNewNode(e);
      else
        parent.right = createNewNode(e);
    }

    size++;
    return true; // Element inserted successfully
  }

  protected TreeNode<E> createNewNode(E e) {
    return new TreeNode<E>(e);
  }

  /**
	 * Method inorder()
	 * 
	 * Inorder traversal from the root 
	 * 
	 * @param hashCode
	 */
  @Override 
  public void inorder() {
    inorder(root);
  }
  /**
	 * Method inorder()
	 * 
	 * in order traversal from a subtree
	 * 
	 * @param root
	 */
  protected void inorder(TreeNode<E> root) {
    if (root == null) return;
    inorder(root.left);
    System.out.println(root.element + " ");
    inorder(root.right);
  }

  /**
	 * Method postorder()
	 * 
	 * postorder traversal fromt he root
	 * 
	 */
  @Override 
  public void postorder() {
    postorder(root);
  }

  /**
	 * Method postorder()
	 * 
	 * postorder traversal from a subtree
	 * 
	 * @param root
	 */
  protected void postorder(TreeNode<E> root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.element + " ");
  }

  /**
	 * Method preorder()
	 * 
	 * preorder traversal from the root
	 * 
	 */
  @Override 
  public void preorder() {
    preorder(root);
  }

  /**
	 * Method preorder()
	 * 
	 * preorder traversal from a subtree
	 * 
	 * 
	 * @param root
	 */
  protected void preorder(TreeNode<E> root) {
    if (root == null) return;
    System.out.print(root.element + " ");
    preorder(root.left);
    preorder(root.right);
  }

  /** This inner class is static, because it does not access 
      any instance members defined in its outer class */
  public static class TreeNode<E extends Comparable<E>> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    /**
	 * Method TreeNode()
	 * 
	 * Constructor for a tree node that sets up a single element
	 * 
	 * 
	 * @param e
	 */
    public TreeNode(E e) {
      element = e;
    }
  }

  /**
	 * Method getSize()
	 * 
	 * get the number of nodes in the tree
	 * 
	 * @return int
	 */
  @Override
  public int getSize() {
    return size;
  }

  /**
	 * Method getRoot()
	 * 
	 * returns the root of the tree
	 * 
	 * @return TreeNode<E>
	 * @param hashCode
	 */
  public TreeNode<E> getRoot() {
    return root;
  }

  /**
	 * Method path()
	 * 
	 * returns the path from the root leading to the specified element
	 * 
	 * @return java.util.ArrayList<TreeNode<E>>
	 */
  public java.util.ArrayList<TreeNode<E>> path(E e) {
    java.util.ArrayList<TreeNode<E>> list =
      new java.util.ArrayList<TreeNode<E>>();
    TreeNode<E> current = root; // Start from the root

    while (current != null) {
      list.add(current); // Add the node to the list
      if (e.compareTo(current.element) < 0) {
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        current = current.right;
      }
      else
        break;
    }

    return list; // Return an array list of nodes
  }

  /**
	 * Method delete()
	 * 
	 * Delete an element from the binary tree
	 * return true if the element is deleted successfully
	 * return false if the element is not in the tree
	 * 
	 * @return boolean
	 * @param e
	 */
  @Override
  public boolean delete(E e) {
    // Locate the node to be deleted and also locate its parent node
    TreeNode<E> parent = null;
    TreeNode<E> current = root;
    while (current != null) {
      if (e.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      }
      else
        break; // Element is in the tree pointed at by current
    }

    if (current == null)
      return false; // Element is not in the tree

    // Case 1: current has no left child
    if (current.left == null) {
      // Connect the parent with the right child of the current node
      if (parent == null) {
        root = current.right;
      }
      else {
        if (e.compareTo(parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
    }
    else {
      // Case 2: The current node has a left child
      // Locate the rightmost node in the left subtree of
      // the current node and also its parent
      TreeNode<E> parentOfRightMost = current;
      TreeNode<E> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; // Keep going to the right
      }

      // Replace the element in current by the element in rightMost
      current.element = rightMost.element;

      // Eliminate rightmost node
      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else
        // Special case: parentOfRightMost == current
        parentOfRightMost.left = rightMost.left;     
    }

    size--;
    return true; // Element deleted successfully
  }

  /**
	 * Method iterator()
	 * 
	 * Obtains an iterator. use inorder
	 * 
	 * @return java.util.Iterator<E>
	 */
  @Override
  public java.util.Iterator<E> iterator() {
    return new InorderIterator();
  }

  // Inner class InorderIterator
  private class InorderIterator implements java.util.Iterator<E> {
    // Store the elements in a list
    private java.util.ArrayList<E> list =
      new java.util.ArrayList<E>();
    private int current = 0; // Point to the current element in list

    /**
	 * Method InorderIterator()
	 * 
	 * Constructor that creates an inorder iterator
	 * 
	 */
    public InorderIterator() {
      inorder(); // Traverse binary tree and store elements in list
    }

    /**
	 * Method inorder()
	 * 
	 * inorder traversal from the root
	 * 
	 */
    
    private void inorder() {
      inorder(root);
    }

    /**
	 * Method inorder()
	 * 
	 * inorder traversal from a subtree
	 * 
	 * @param root
	 */
    private void inorder(TreeNode<E> root) {
      if (root == null)return;
      inorder(root.left);
      list.add(root.element);
      inorder(root.right);
    }

    /**
	 * Method hasNext()
	 * 
	 * returns true if there are more elements for traversing
	 * 
	 * @return boolean
	 */
    @Override
    public boolean hasNext() {
      if (current < list.size())
        return true;

      return false;
    }

    /**
	 * Method next()
	 * 
	 * Get the current element and move to the next
	 * 
	 * @return E
	 */
    @Override
    public E next() {
      return list.get(current++);
    }

    /**
	 * Method InorderIterator()
	 * 
	 * Remove the current element
	 * 
	 */
    @Override 
    public void remove() {
      delete(list.get(current)); // Delete the current element
      list.clear(); // Clear the list
      inorder(); // Rebuild the list
    }
  }

  /**
	 * Method clear()
	 * 
	 * remove all elements from the tree
	 * 
	 */
  public void clear() {
    root = null;
    size = 0;
  }
}
