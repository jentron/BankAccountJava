import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*******************
 * Bank Account Project for CS1400
 * Operation11 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This Class is the main LOOP GUI for the project
 *  
 * 27 Mar 2017
 * @author Ronald Jensen
 *******************/

public class BankAccountGUI {
	BankAccount currentAccount;
	EventLogger logger; // Use a common logger
	

	public BankAccountGUI() // Look, a constructor
	{
		logger = BankGuiDriver.logger; // Use the singleton logger from the main class
	} // end of constructor


	private void myButtonLogoffListener() {
		logger.logEvent(currentAccount.getName(), currentAccount.getAccountNum(), "Logging out");
		currentAccount = null; //throw the account away
		return;
	}


	private void myButtonInfoListener() {
		logger.logEvent(currentAccount.getName(), currentAccount.getAccountNum(), "request info");
		JOptionPane.showMessageDialog(null, 
				"Name: "+ currentAccount.getName() + 
			  "\nAccount #: " + currentAccount.getAccountNum() + 
			  "\nBalance: " + currentAccount.getBalanceString());
	}


	private void myButtonWithdrawListener() {
		try{
			String strAmount = JOptionPane.showInputDialog("Please enter withdrawl amount: ");
			double amount = Double.parseDouble(strAmount);
			currentAccount.withdraw(amount);
			logger.logEvent(currentAccount.getName(), currentAccount.getAccountNum(),
					"Withdraw of " + amount + " final balance " + currentAccount.getBalance());
		}
		catch(BankAccountException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		catch(java.lang.NumberFormatException e){
			JOptionPane.showMessageDialog(null, "I did not understand your input");
		}
		catch(java.lang.NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Input cancelled");			
		}
		 
		return;
	}


	private void myButtonDepositListener() {
		// 
		try{
			String strAmount = JOptionPane.showInputDialog("Please enter deposit amount: ");
			double amount = Double.parseDouble(strAmount);
			currentAccount.deposit(amount);
			logger.logEvent(currentAccount.getName(), currentAccount.getAccountNum(),
					"Deposit of " + amount + " final balance " + currentAccount.getBalance());
		}
		catch(BankAccountException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		catch(java.lang.NumberFormatException e){
			JOptionPane.showMessageDialog(null, "I did not understand your input");
		}
		catch(java.lang.NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Input cancelled");			
		}
		return;
	}


	// guiMain takes care of logging in the user
	public void guiMain()
	{
		String userName;

		logger.logEvent("System",0,"Gui Startup");
		
		do{
			userName = JOptionPane.showInputDialog(null, "Please enter your name: ");
			if(userName == null) break;
			if(!userName.equals("")) // only process this loop if the user actually logged in
			{
				int accountNumber = 12345; 
				logger.logEvent(userName, accountNumber, "Logging in");
				currentAccount = new BankAccount(userName, accountNumber);
			}else{
				logger.logEvent("System",0,"Invalid Login Attempt!");
			}
			
			guiUserPanel();

			currentAccount = null; // destroy the current account
			
		}while(true); // this loop is exited by a break; call inside the loop;
		
		logger.logEvent("System",0,"Gui Shut Down");
	} // guiMain
	
	// guiUserPanel puts up the JPanel with buttons
	private void guiUserPanel()
	{
	    String[] options = new String[] {"Deposit", "Withdraw", "Account Information", "Log Off"};
	    int response;
	    while(currentAccount != null) {
	    	// http://stackoverflow.com/a/1257612/4504607
	    	response = JOptionPane.showOptionDialog(null, "Please Choose an Option", "Ron's CS1400 Faith Bank",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
	    	switch(response)
	    	{
	    	case 0:
	    		myButtonDepositListener();
	    		break;
	    	case 1:
	    		myButtonWithdrawListener();
	    		break;
	    	case 2:
	    		myButtonInfoListener();
	    		break;
	    	case 3:
	    		myButtonLogoffListener();
	    		break;
	    	default:
	    		break;
	    	}
	    };
	}
}
