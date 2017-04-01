
/*******************
 * Bank Account Project for CS1400
 * Operation11 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This is main() Driver and Gui Class
 *  
 * 27 Mar 2017
 * @author Ronald Jensen
 *******************/

public class BankGuiDriver {

	public static EventLogger logger = new EventLogger(); // Singleton pattern. Good enough for this project
	
	// Entry point
	public static void main(String [] args)
	{
		BankAccountGUI gui = new BankAccountGUI(); // if I do it in main everything has to be static, so just farm it out to here

		gui.guiMain(); 
	}
	
}
