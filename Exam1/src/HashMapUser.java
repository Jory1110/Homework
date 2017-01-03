
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;


public class HashMapUser
{
    
    public static void main(String[] args)
    {
       // create instance
        String initialSet[] = {"Romeo", "Juliet", "Adam", "Eve", "Homer", "Marge", "Bart", "Eve"};
       
        Random randomGenerator = new Random();
        
        // create a random double number between 0 and 60
        double random = randomGenerator.nextDouble() * 60;
        
        HashMap<String,Double> names = new HashMap<String,Double>();
        for (int i = 0; i < initialSet.length; i++) 
        {
			names.put(initialSet[i], randomGenerator.nextDouble() * 60);
		}
        System.out.println("The keys and values of the HashMap names are:");
        for(Map.Entry<String, Double> x: names.entrySet())
        {
        	System.out.println(x.getKey() + " " + x.getValue());
        }
        

    }

}
