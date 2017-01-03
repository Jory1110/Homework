
public class Star {
	
	public static double sumTo(int x)
	{
	   
	    if(x == 0)
	    {
	        return 0.0;
	    }
	    else if(x == 1)
	    {
	        return 1;
	    }
	    else
	    {
	        return (1/x + sumTo(x-1));
	    }
	}

	public static void main(String[] args) {
		System.out.println(sumTo(2));

	}

}
