
public class Test {
	
	public static void main(String [] args)
	{
		for (int i = 1; i < 10; i++)
		{
			for(int j = i;j< i +10; j++)
			{
				if( j % 10 == 0)
				{
					break;
				}
				else{
					System.out.print(j % 10);
				}			
			}
			System.out.println();
		}
	}

}
