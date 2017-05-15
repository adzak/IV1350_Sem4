package se.kth.iv1350.inspectcar.util.logger;

import java.io.*; 
import java.util.Date;

/**
 * Logs all caught exceptions in a file.
 */
public class Logger 
{
   private PrintWriter fileLogger;
   private Date date;
   
   /**
    * Creates a new instance of Logger.
    */
   public Logger() throws FileNotFoundException
   {
       fileLogger  = new PrintWriter(new FileOutputStream(new File("error.txt"),true));
       date = new Date();
   }
   
   /**
    * Updates the logger with information about the caught exception.
    * 
    * @param message contains the exception that was thrown.
    */
   public void caughtException(String message)
   {
       fileLogger.println(date.toLocaleString() + "- Exception was thrown: " + message);
       fileLogger.flush();
   }
}
