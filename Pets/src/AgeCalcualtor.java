import java.util.Scanner;

public class AgeCalcualtor {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x;
		int y;
		
		System.out.println("Enter two integer values: ");
		x = input.nextInt();
		y = input.nextInt();
		
		int sum = x + y;
		
		System.out.println("The sum of " + x +" and " + y + " is " + (x+y));
		
		
		input.close();
		
		
	}

}
