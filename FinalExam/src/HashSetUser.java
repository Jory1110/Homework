// Jory Alexander
import java.util.HashSet;
import java.util.Iterator;


public class HashSetUser
{
    private HashSet<String> mySet = new HashSet<String>();
    
    
    public HashSetUser(String[] initialValues)
    {
        for (int i=0; i< initialValues.length; i++)
        {
            mySet.add(initialValues[i]);
        }
    }
    
    public HashSetUser()
    {
        // initially an empty hash set
    }
    
    public Iterator<String> getIterator()
    {
        return mySet.iterator();
    }
   
    public void add(String data)
    {
        mySet.add(data);
    }
    
    public void remove(String data)
    {
        mySet.remove(data);
    }

    public static void main(String[] args)
    {
       // create instance
        String initialSet[] = {"Meredith", "Cristina", "Alex", "George", "Miranda", "Richard", "Callie", "Owen"};
        HashSetUser aSet = new HashSetUser(initialSet);
        
        // YOUR CODE GOES HERE
        // using the instance of HashSetUser named aSet, add code that 
        // 1.   prints the contents of the hashset to console- DO NOT 
        // JUST PRINT THE SET - Iterate through the set and print individual names each on their own line

        Iterator fred = aSet.getIterator();
        
        while(fred.hasNext())
        {
        	String allen = (String) fred.next();
        	System.out.println(allen);
        }
        
      
        
        

    }

}
