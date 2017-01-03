import java.util.ArrayList;

public class LargestPrime {
	public static void main(String[] args)
	{
		
	long b = 600851475143l;
	long a = 600851475143l;
	ArrayList<Long> prime = new ArrayList<Long>();
	ArrayList<Long> factors = new ArrayList<Long>();
	prime.add(2l);
	prime.add(3l);
	
	for(long i = 1;i<a;i++)
	{
		if(a % i == 0)
		{
			factors.add(i);
			factors.add(a/(long)i);
			a = factors.get(factors.size()-1);
		}
		
	}
	
	System.out.println("the factors are " + factors);
	long highPrime = 0;
	
	for(int i = 0; i < factors.size(); i++)
	{
		if(factors.get(i) != b)
		{
			for(int j = 3; j < factors.get(i);j++)
			{
				if(j % factors.get(i) == 0)
				{
					break;
				}
				else
				{
					if(factors.get(i) > highPrime)
					{
						highPrime = factors.get(i);
					}
				}
			}
		}
	}
	System.out.println("the highest prime factor is " + highPrime);
	 
	 
	 
	 
	}
}
