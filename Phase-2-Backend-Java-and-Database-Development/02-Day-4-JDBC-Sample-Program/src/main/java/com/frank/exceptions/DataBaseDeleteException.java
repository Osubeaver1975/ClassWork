package com.frank.exceptions;

// This is a custom exception used when there is a database delete error
//
// We wanted to provide more granularity to a problem than the generic
// ... DataAccessException provided byt Spring JDBC
// To define a custom exception:
// 
// 1. Make it a subclass of exception
// 2.  Provide a default ctor that calls the exception ctor (super())
// 3. Provide a ctor that takes a string param (error message)
//     . . . and pass it to super ctor
// 4. Anything else you think you want in the custom exception

public class DataBaseDeleteException extends Exception {

	public DataBaseDeleteException() {
		super();
	}
	
	public DataBaseDeleteException(String message) {
		super(message);
		
		// Display a message to user that problem happened (exception thrown)
		System.out.println("Problem deleting data in database:");
		System.out.println(message);
	}
}

