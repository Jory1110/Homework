/**
 * Class: BankCreditLine
 * 
 * @author Robert Jory Alexander, worked with Kyle Brooks and Estephanie Gonzalez
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: March 16, 2016
 * 
 * 
 * This class: contains information and methods required to establish a line of credit and to make payments and make withdraws
 * 
 * Purpose: Contains the instructions necessary to carry out the above task
 *         
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankCreditLine {
	//creates a double creditLimit to contain the value of the credit limit
	private double creditLimit;
	//creates a double creditbalance to contain the current balance to the credit line
	private double creditBalance;
	//creates a lock object bankLock
	Lock bankLock;
	
	/**
	 * Method BankCreditLine()
	 * 
	 * constructor that creates a BankCreditLine object
	 * 
	 * @param x the value for the creditlimit
	 * 
	 */
	public BankCreditLine(double x)
	{
		creditBalance = 0;
		creditLimit = x;
		bankLock = new ReentrantLock();
	}
	
	/**
	 * Method payment()
	 * 
	 * method that attempts to makes a payment to the account will not over pay the account and will only take
	 * add up to the credit limit
	 * 
	 * @param amount: amount of the payment to be made
	 * 
	 */
	public void payment(double amount)
	{
		//locks the thread
		bankLock.lock();
		try
		{
			//creates variable newBalance that will hold the credit blanace - amount
			double newBalance;
			if ((creditBalance - amount) < 0)
			{
				//informs customer that they attempted to pay to much sets new balance to 0 and tells how much was actually taken 
				System.out.print("You paid to much, only takking: " + String.format( "%.2f", creditBalance) + " of your $" + String.format( "%.2f", amount));
				newBalance = 0;
			} else
			{
				//informs customer the amount being deposited
				System.out.print("Depositing " + String.format( "%.2f",amount));
				newBalance = creditBalance - amount;
			}
			//informs user of their current balance
			System.out.println(", your new balance is " + String.format( "%.2f", newBalance));
			//sets creditBalance to newBalance
			creditBalance = newBalance;
		} 
		finally
		{
			//unlocks thread
			bankLock.unlock();
		}
	}

	/**
	 * Method: withdraw()
	 * 
	 * method that attempts to withdraw money from the credit line will not allow customer to over draw account
	 * @param amount: the amount to withdraw
	 */
	public void withdraw(double amount) throws InterruptedException
	{
		//locks the thread
		bankLock.lock();
		try
		{
			if ((creditBalance + amount) > creditLimit)
			{
				//if the customer is attempting to withdraw more money than is available customer is informed of insufficient funds
				// and wont allow withdrawal
				System.out.println("Insuficient Funds attempting to withdraw: " + String.format( "%.2f", amount) + " current balance is: " + String.format( "%.2f", creditBalance));
			}
			else
			{
				//informs user of amount being withdrawn
				System.out.print("Withdrawing " + String.format( "%.2f", amount));
				//creats a new balance that is equal to the creditBalance plus the amount
				double newBalance = creditBalance + amount;
				//informs user of their new balance
				System.out.println(", your new balance is " + String.format( "%.2f", newBalance));
				//sets creditBalance equal to newBalance
				creditBalance = newBalance;
			}
		} 
		finally
		{
			//unlocks thread
			bankLock.unlock();
		}
	}

	/**
	 * Method: getBalance()
	 * 
	 * returns the balance of the creditBalance instance variable
	 * 
	 * @return creditBalance
	 */
	public double getBalance()
	{
		return creditBalance;
	}
	
	/**
	 * Method: getCreditLimit()
	 * 
	 * returns the creditLimit instance variable
	 * 
	 * @return creditLimit
	 */
	public double getCreditLimit()
	{
		return creditLimit;
	}
}


