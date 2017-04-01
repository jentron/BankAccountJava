/*******************
 * Bank Account Project for CS1400
 * Operation11 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This is the custom exception class for BankAccount
 *  
 * 27 Mar 2017
 * @author Ronald Jensen
 *******************/

// Credit: http://stackoverflow.com/a/8423743/4504607

public class BankAccountException extends Exception {
	private static final long serialVersionUID = 1L;  // eclipse wanted this

	public BankAccountException () {

    }

    public BankAccountException (String message) {
        super (message);
    }

    public BankAccountException (Throwable cause) {
        super (cause);
    }

    public BankAccountException (String message, Throwable cause) {
        super (message, cause);
    }
}