
public class PythagorieanTriplets {
	
	public static void pythag()
	{
		int a = 0;
		int b = 0;
		double c = 0;
		for(int i = 1; i < 1000; i++)
		{
			b = i;
			for(int j = 1; j < 1000; j++)
			{
				a = j;
				c = (Math.sqrt(Math.pow(a, 2)+ Math.pow(b, 2)));
				if((a + b + c == 1000) && (a < b) && (b < c))
				{
					System.out.println("a: " + a + " b: " + b + " c: " + c);
					System.out.println("The product is: " +(int)(a*b*c));
					break;
				}
			}
			
		}
	 
	}

	public static void main(String[] args) {
		
		pythag();

	}

}
