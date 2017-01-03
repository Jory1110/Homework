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
        String initialSet[] = {"Romeo", "Juliet", "Adam", "Eve", "Homer", "Marge", "Bart", "Eve"};
        HashSetUser aSet = new HashSetUser(initialSet);
        
        // YOUR CODE GOES HERE
        // using the instance of HashSetUser named aSet, add code that 
        // 1.   prints the contents of the hashset to console- DO NOT 
        // JUST PRINT THE SET - Iterate through the set and print individual names each on their own line
        Iterator x = aSet.getIterator();
        System.out.println("These are the names from the has set:");
        while(x.hasNext())
        {
        	System.out.println(x.next());
        	
        	
        }
        Iterator y = aSet.getIterator();
        // 2.  Find the name in the hashSet that is alphabetically the highest and print it to console (Note:  Don't just 
        // print "Romeo" from the initialSet above.  Do it by checking each element in the HashSetUser hashset
        String highest = "";
        String compareMe = "";
        while(y.hasNext())
        {
        	compareMe = (String) y.next();
        	if(highest == "")
        	{
        		highest = compareMe;
        	}
        	else if (highest.compareTo(compareMe) < 0)
        	{
        		highest = compareMe;
        	}
        }
        System.out.println();
        System.out.println("Highest Name is " + highest);
    }

}
