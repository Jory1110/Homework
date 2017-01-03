import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A hash set stores an unordered collection of objects, using
   a hash table.
*/
public class HashSet extends AbstractSet
{
   private Node[] buckets;
   private int size;

   /**
      Constructs a hash table.
      @param bucketsLength the length of the buckets array
   */
   public HashSet(int bucketsLength)
   {
      buckets = new Node[bucketsLength];
      size = 0;
   }

   /**
      Tests for set membership.
      @param x an object
      @return true if x is an element of this set
   */
   public boolean contains(Object x)
   {
      int h = x.hashCode();
      if (h < 0) h = -h;
      h = h % buckets.length;
      
      Node current = buckets[h];
      while (current != null)
      {
         if (current.data.equals(x)) return true;
         current = current.next;
      }
      return false;
   }

   /**
      Adds an element to this set.
      @param x an object
      @return true if x is a new object, false if x was
      already in the set
   */
   public boolean add(Object x)
   {
      int h = x.hashCode();
      if (h < 0) h = -h;
      h = h % buckets.length;
      
      Node current = buckets[h];
      while (current != null)
      {
         if (current.data.equals(x)) 
            return false; // Already in the set
         current = current.next;
      }
      Node newNode = new Node();
      newNode.data = x;
      newNode.next = buckets[h];
      buckets[h] = newNode;
      size++;
      return true;
   }

   /**
      Removes an object from this set.
      @param x an object
      @return true if x was removed from this set, false
      if x was not an element of this set
   */
   public boolean remove(Object x)
   {
      int h = x.hashCode();
      if (h < 0) h = -h;
      h = h % buckets.length;
      
      Node current = buckets[h];
      Node previous = null;
      while (current != null)
      {
         if (current.data.equals(x)) 
         {
            if (previous == null) buckets[h] = current.next;
            else previous.next = current.next;
            size--;
            return true;
         }
         previous = current;
         current = current.next;
      }
      return false;
   }

   /**
      Gets the number of elements in this set.
      @return the number of elements
   */
   public int size()
   {
      return size;
   }

   class Node
   {
      public Object data;
      public Node next;
   }

@Override
public Iterator iterator() {
	// TODO Auto-generated method stub
	return null;
}
}
