import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Review {
	public static void main(String[] args)
	{
		String[] presidents = {"Obama","Bush Jr","Clinton","Bush Sr","Reagan"};
		int[] year ={2009,2001,1993,1989,1981};
		
		HashMap<String,Integer> pres = new HashMap<String,Integer>();
		
		for(int i = 0; i < year.length;i++)
		{
			pres.put(presidents[i], year[i]);
		}
		
		Set<String> keys = pres.keySet();
		
		for(String x : keys)
		{
			System.out.println("President " + x + " was elected in " + pres.get(x));
		}
	}
}
