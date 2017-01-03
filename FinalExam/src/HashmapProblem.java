// Jory Alexander

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class HashmapProblem {
	
	public static void main(String [] args)
	{
		String[] names = {"Homer","Marge","Lisa","Bart","Maggie"};
		Integer[] num = {51,10,27,222,96};
		ArrayList<String> remove = new ArrayList<>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(int i = 0; i < names.length;i++)
		{
			map.put(names[i], num[i]);
		}
		
		Set<String> aSet = map.keySet();
		
		for(String x : aSet)
		{
			System.out.println(x + " corresponds with " + map.get(x));
		}
		
		for(String x : aSet)
		{
			if(map.get(x)< 50)
			{
				remove.add(x);
			}
		}
		
		
		for(int i = 0; i < remove.size();i++)
		{
			map.remove(remove.get(i));
		}
		Set<String> aSet2 = map.keySet();
		System.out.println();
		System.out.println("I removed values less than 50");
		for(String x : aSet2)
		{
			System.out.println(x + " corresponds with " + map.get(x));
		}
		
	}

}
