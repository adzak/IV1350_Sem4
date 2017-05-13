package se.kth.iv1350.inspectcar.util.logger;

import java.io.*; 
import java.util.Date;

public class Logger 
{
   private PrintWriter fileLogger;
   private Date date;
   
   public Logger() throws FileNotFoundException
   {
       fileLogger  = new PrintWriter(new FileOutputStream(new File("error.txt"),true));
       date = new Date();
   }
   
   public void caughtException(String message)
   {
       fileLogger.println(date.toLocaleString() + "- Exception was thrown: " + message);
       fileLogger.flush();
   }
}
