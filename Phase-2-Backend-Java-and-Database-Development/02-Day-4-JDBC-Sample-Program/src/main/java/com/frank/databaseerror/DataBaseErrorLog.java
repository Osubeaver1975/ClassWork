package com.frank.databaseerror;

import errorlog.ErrorLog;

import java.io.IOException;
/********************************************************************
 * Provide the functionality to log details for a database error
 * 
 *  Youre typcial human user does notwant to see a bunch of technical info when there is an error
 *  
 *   Developers need the details to help debug the error
 *   
 *   When an Exception is thrown the catch block receives an Exception object 
 *   ... containing details on the reason for the exception
 *   
 *   Having the exception block information available when debugging an exception is invaluable
 *   
 *   Logging that information to a file rather than just displaying it on the screen 
 *   ... makes the information persistent 
 *   (usually people clear the screen when there is an error and info go ByeBye! ! ! 
 *   
 */
public class DataBaseErrorLog {

	// Define a reference to an errolog for use in thisclass
    private static ErrorLog theErrorLog;

    public DataBaseErrorLog(String filePrefix) throws IOException {
    	// Instatiate an ErrorLog obj to log our database errors with the file prefix passed
        theErrorLog = new ErrorLog(filePrefix);
    }
    public void writeToDatabaseErrorLog(String message){
        theErrorLog.writeToLog(message);
    }
    // Write the Exception Obj information to the error log
    public void writeExceptionInfoToDatabaseErrorLog(Exception exceptionObject) {
        theErrorLog.writeToLog("-".repeat(75));
        // 						type of information   data from Exception object
        theErrorLog.writeToLog("Exception Object: " + exceptionObject.toString());
        theErrorLog.writeToLog("Message: " + exceptionObject.getMessage());
        theErrorLog.writeToLog("LocalizedMessage: " + exceptionObject.getLocalizedMessage());
        theErrorLog.writeToLog("Cause: " + exceptionObject.getCause().toString());
        
        // The StackTrace is a record of how we got to the line of code that caused the exception
        // Get the stack trace as an array
        StackTraceElement stackTraceEntries[] = exceptionObject.getStackTrace();
        // Loop through the stack trace entries writing them to the error log
        for(StackTraceElement stackTraceElement : stackTraceEntries) {
            theErrorLog.writeToLog(stackTraceElement.toString());
        }
    }

}
