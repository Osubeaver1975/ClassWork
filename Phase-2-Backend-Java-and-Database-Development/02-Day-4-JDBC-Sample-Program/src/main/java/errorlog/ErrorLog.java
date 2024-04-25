package errorlog;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
/***************************************************************************************
 * Define a error logging process
 */
public class ErrorLog {

	// Object required to define a disk file and processes to add to the end of the file not ...
	// ... just overwrite the whole file
	
	// All variables are static so every instance of the class shares  the file information
	// So we don't get multiple error logs with diff info
	
    private static File           logFile;			// File object 
    private static FileWriter     aFileWriter;		// File Writer object for the file object
    private static BufferedWriter aBufferedWriter;	// Buffered writer obj
    private static PrintWriter    logWriter;		// Print Writer for buffered Writer

    private static String logFileName;				// Name of the log file	

    private static boolean isFileDefined = false;	// Remember: If file is already defined

    
    // Constructor will instantiate and initialize all variables
    public ErrorLog(String prefix) throws IOException {

        if (!isFileDefined) {  												//If file is not defined
            String currentDateTime = LocalDate.now().toString();			// Get current Date and time as String	
            logFileName 		= prefix+"errorLog-" + currentDateTime + ".log"; 	// Generate the filename with prefix and date
            logFile 			= new File(logFileName);
            aFileWriter 		= new FileWriter(logFile, true);
            aBufferedWriter 	= new BufferedWriter(aFileWriter);
            logWriter 			= new PrintWriter(aBufferedWriter);

            isFileDefined = true;
        }
    }
    // write the message passed to error log file with date and time
     public void writeToLog(String message) {
    	// replace the "T" in front of Time with a space
        logWriter.println(LocalDateTime.now().toString().replace("T"," ") 
                         + " - "
                         + message);
        logWriter.flush();	// Write the message from the file buffer to the disk now 
        					//    ... Rather than wait for buffer to be full
        					// Because if unhandled exception occurs, the application terminates and buffer is lost. 
    }

}
