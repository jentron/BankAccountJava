import java.time.LocalDateTime;

/*******************
 * Bank Account Project for CS1400
 * Operation11 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This is simple console event logger, it could easily be replaced by a file based logger
 *  
 * 27 Mar 2017
 * @author Ronald Jensen
 *******************/
public class EventLogger {
	EventLogger(){
		System.out.println("Console Logger Started");
	}

// I wanted to put a constructor/destructor pair, but apparently
// Java doesn't do destructors 
//	~EventLogger(){ System.out.println("Console Logger Stopped")};

	public void logEvent(String userName, int accountNumber, String event)
	{
		System.out.println(LocalDateTime.now() + "\t" + userName + "\t" + accountNumber + "\t" + event);
	}
}
