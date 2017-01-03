/**
 * Runs a simulation  10000000 times to see the likely hood of an ant landing on a particular set of squares on a grid. 
 */

package ant;

import java.util.Random;

public class Ant {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		double RUNS = 1000000.00;
		int MOVES = 15;
		int MOVES2 = 60 * 60;
		double total = 0;
		
		
		
		
		
		for(int i = 0; i < RUNS;i++)
		{
			int pointX = 3;
			int pointY = 3;
			for(int j = 0; j < MOVES; j++)
			{
				int direction = r.nextInt(5)+1;
				
				if(direction == 1)
				{
					//standing still
				}
				else if(direction == 2)
				{
					pointX = pointX + 1;
					if(pointX > 5)
					{
						pointX = 5;
					}
				}
				else if(direction == 3)
				{
					pointX = pointX - 1;
					if(pointX < 1)
					{
						pointX = 1;
					}
				}
				else if(direction == 4)
				{
					pointY = pointY + 1;
					if(pointY > 5)
					{
						pointY = 5;
					}
				}else if(direction == 5)
				{
					pointY = pointY -1;
					if(pointY < 1)
					{
						pointY = 1;
					}
				}
				else
				{
					System.out.println("invalid move request figure it out");
				}
			}
			if(pointX == 3 && pointY == 3)
			{
				total = total + 1;
			}
			
			
			
		}
		System.out.println("The probability of landing in t0he middle after 15 moves is : " + total/RUNS);
		total = 0;
		
		
		
		for(int i = 0; i < RUNS;i++)
		{
			int pointX = 3;
			int pointY = 3;
			for(int j = 0; j < MOVES2; j++)
			{
				int direction = r.nextInt(5)+1;
				
				if(direction == 1)
				{
					//standing still
				}
				else if(direction == 2)
				{
					pointX = pointX + 1;
					if(pointX > 5)
					{
						pointX = 5;
					}
				}
				else if(direction == 3)
				{
					pointX = pointX - 1;
					if(pointX < 1)
					{
						pointX = 1;
					}
				}
				else if(direction == 4)
				{
					pointY = pointY + 1;
					if(pointY > 5)
					{
						pointY = 5;
					}
				}else if(direction == 5)
				{
					pointY = pointY -1;
					if(pointY < 1)
					{
						pointY = 1;
					}
				}
				else
				{
					System.out.println("invalid move request figure it out");
				}
			}
			if((pointX == 1 && pointY == 1) ||(pointX == 1 && pointY == 2) ||(pointX == 1 && pointY == 3) ||(pointX == 1 && pointY == 4)
					||(pointX == 1 && pointY == 5) ||(pointX == 2 && pointY == 1) ||(pointX == 3 && pointY == 1) ||(pointX == 4 && pointY == 1) ||(pointX == 5 && pointY == 1)
					||(pointX == 5 && pointY == 2)|| (pointX == 5 && pointY == 3) ||(pointX == 5 && pointY == 4) ||(pointX == 5 && pointY == 5) ||(pointX == 4 && pointY == 5)
					||(pointX == 3 && pointY == 5) || (pointX == 2 && pointY == 5))
			{
				total = total + 1;
			}
			}
			
		


		System.out.println("The probability of landing on the outside after " + (60*60) +" moves is : " + total/RUNS);
}
	}
