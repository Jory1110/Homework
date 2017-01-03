/**
 * Class: BankCreditLine
 * 
 * @author Robert Jory Alexander, worked with Kyle Brooks and Estephanie Gonzalez
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: March 16, 2016
 * 
 * 
 * This class: contains instructions to run both the deposit class and the withdraw class and output the results
 * creates w threads
 * 
 * Purpose: to test the functionality of the deposit, withdraw and BankCreditLine classes
 *         
 *
 */
public class CreditTester {
	
	/*
	 * Method main()
	 * 
	 * the main method that executes the code
	 * 
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		//creates a bankCreditLine object and sets limit to 500
		BankCreditLine creditLine = new BankCreditLine(500);
		//creates final int Trys that runs the program 50 times
		final int TRYS = 50;

		//creates a deposit object deposit passing it the creditLine object and the trys variable
		Deposit deposit = new Deposit(creditLine, TRYS);
		//creates a withdraw object withdraw passing it the creditLine object and the trys variable
		Withdraw withdraw = new Withdraw(creditLine, TRYS);

		//creates a thread depositThread and passes it the deposit object deposit
		Thread depositThread = new Thread(deposit);
		//creates a thread withDrawTherad and passes it the withdraw object withdraw
		Thread withdrawThread = new Thread(withdraw);
		//outputs the credit limit
		System.out.println("Your credit Limit is: " + String.format( "%.2f", creditLine.getCreditLimit()));
		System.out.println();
		//starts the wtihdrawThread thread followed by the depositThread thread
		withdrawThread.start();
		depositThread.start();
	}

}
