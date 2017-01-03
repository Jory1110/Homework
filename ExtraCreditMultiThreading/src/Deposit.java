/**
 * Class: BankCreditLine
 * 
 * @author Robert Jory Alexander, worked with Kyle Brooks and Estephanie Gonzalez
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: March 16, 2016
 * 
 * 
 * This class: contains the instructions to  creates a runnable that deposits money into a BankCreditLine object
 * 
 * Purpose: to complete the above task
 *         
 *
 */

import java.util.Random;

public class Deposit implements Runnable{

	 private static final int DELAY = 2000; 
	   private BankCreditLine credit;
	   private int count;
	   private Random x;

	   /**
	    *  Method Deposit()
	    *  
	    *  constructor that creates a Deposit object
	    *  
	    *  @param newLine: the BankCreditLine object that should have a deposit made to
	    *  @param count: number of times to make a deposit
	    */
	   public Deposit(BankCreditLine newLine, int nCount)
	   {
	      credit = newLine;
	      count = nCount;
	      x = new Random();
	   }
	   
	   /**
	    * Method: run()
	    * 
	    * 
	    * creates a random number between 0 and 500 and attempts to deposit the money into the credit object.
	    * sleeps for 2 seconds each pass
	    */
	   public void run()
	   {
	      try
	      {
	         for (int i = 1; i <= count; i++)
	         { 
	            credit.payment(x.nextDouble() * 500);
	            Thread.sleep(DELAY);
	         }
	      }
	      catch (InterruptedException exception) {}
	   }
	

}
