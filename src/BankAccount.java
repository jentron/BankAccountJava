import java.text.DecimalFormat;

/*******************
 * Bank Account Project for CS1400
 * Operation11 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This Class was supplied by the project. RJensen modified it to throw exceptions
 *  
 * 27 Mar 2017
 * @author Ronald Jensen
 * @author Faith Satterthwaite
 *******************/

public class BankAccount
{
	private String name;
	private int accountNum;
	private double balance;
	
	//Constructor that sets the customer name and account number when account is created
	public BankAccount (String n, int a)
	{
		this.name = n;
		this.accountNum = a;
	}
	
	//Increases the account balance by the amount of the deposit
	public void deposit (double amount) throws BankAccountException
	{
		if(amount < 0 ) throw new BankAccountException("Deposit Can NOT be less than 0");
		this.balance += amount; // changed ambiguous reference to balance
	}
	
	//Reduces the account balance by the amount of the withdrawal
	public void withdraw (double amount) throws BankAccountException
	{
		if(amount < 0 ) throw new BankAccountException("Withdrawl Can NOT be less than 0");
		if(this.balance < amount) throw new BankAccountException("Insufficient funds - Account currently " + getBalanceString());
		this.balance -= amount; // changed ambiguous reference to balance
	}
	
	//Returns the account balance
	public double getBalance ()
	{
		return this.balance;
	}
	
	public String getBalanceString()
	{
		DecimalFormat df = new DecimalFormat("$#.00");
	    return df.format(this.balance);
	}
	
	//Returns the account holder's name
	public String getName ()
	{
		return this.name;
	}
	
	//Returns the account holder's account number
	public int getAccountNum ()
	{
		return this.accountNum;
	}
	
}