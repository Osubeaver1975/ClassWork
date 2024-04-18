package com.frank.model.Gambler;

/*****************************************************************************************************************
 * Implement methods for manipulating are returning data from the Gambler table
 * At minimum, implement the methods required by the GamblerDao interface
 
    Gambler table as defined in the database
  	
 	+----------------+--------------+------+-----+---------+----------------+
    | Field          | Type         | Null | Key | Default | Extra          |
    +----------------+--------------+------+-----+---------+----------------+
    | id             | smallint     | NO   | PRI | NULL    | auto_increment |
    | gambler_name   | char(20)     | NO   |     | NULL    |                |
    | address        | char(20)     | YES  |     | NULL    |                |
    | birth_date     | date         | NO   |     | NULL    |                |
    | monthly_salary | decimal(9,2) | NO   |     | NULL    |                |
    +----------------+--------------+------+-----+---------+----------------+

 *****************************************************************************************************************/

import java.util.ArrayList;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcGamblerDao implements GamblerDao {
	
	// define a reference to the JdbcTemplate object we will use to access Spring DAO Framework
	private JdbcTemplate theDataBase;

	// constructor for the class which takes the dataSource as a parameter
	// dataSource will be provided when this DAO is instantiated (from application program)
	public JdbcGamblerDao(DataSource dataSource) {
		// Instantiate a JdbcTemplate object with the dataSource give and assign it to our reference
		this.theDataBase = new JdbcTemplate(dataSource);
	}


	@Override  // Ask Java  to be  sure we are correctly providing the methods define in the interface
	public List<Gambler> getAllGamblers() {
		List<Gambler> allGamblers = new ArrayList();
		
		// Define a string with the SQL to access the data base
		String selectAllGamblersSql = "select * from gambler";
		
		
		// Send the SQL string to the database using the jdbcTemplate methods
		// for a select - store the result in an SQLROWSET object
		
		//The SqlRowSet object containts all the rows returned by the select
		// ...each row has the columnst specified in the select
	    SqlRowSet allGamblerRows = theDataBase.queryForRowSet(selectAllGamblersSql);

	    
	    // Convert each row returned to a Java POJO for the row
	    // Loop through the SqlRowSet positioning at the next row with .next()
        while(allGamblerRows.next()) {
            allGamblers.add(MapRowToGambler(allGamblerRows));	//Call method to create POJO
        }														// and add the POJO to out list
		
		return allGamblers;
	}

	@Override
	// This method receives a Gambler object containing the Gambler info to be added
	public boolean addGambler(Gambler gamblerToAdd) {
		
		Gambler aNewGambler = new Gambler();
		
		// Define a string with the SQL statement to send to the database
		// Using '?' as a placeholder for values stored in program variables
		//       .. that we want to use in SQL statement 
		String addAGamblerSql = "INSERT INTO gambler "
				              + " (gambler_name, address, birth_date, monthly_salary) "
				              + " VALUES (?, ?, ?, ?)"; // VALUES contains the values to be inserted in to database
		
		int numRowsAdded = 0;
		
		// We enclose the call to the database mgr in a "try" block 
		// ... in case an exception is thrown
		// We want to continue if there is an exception (exception handling take-over if exception happens)
		
		// Send the SQL statement to the database manage with the program variable values
		// ...that reeplace the '?' in the SQL statment
		try {	        
			numRowsAdded = theDataBase.update(addAGamblerSql
					                         ,gamblerToAdd.getName() 			//replace 1st '?' with name
					                         ,gamblerToAdd.getAddress()			// Replace 2nd '?' with address
					                         ,gamblerToAdd.getBirthDate()		// Replace 3rd '?' with birthdate
					                         ,gamblerToAdd.getMonthlySalary()	// replace 4th '?' with salary
				                             );
		}
		// The only exception the JbbcTemplates throw is a DataAccessException
		catch (DataAccessException excpetionInfo) {
			System.out.println("!!!!! Error adding new Gambler to Database !!!!");
			return false;
		 }	
		if (numRowsAdded == 1) {
			return true;
		}
		return false;
		
	}

	@Override
	public Gambler findGamblerById(long id) {
	
		String selectAGamblerByIdSql = "select * from gambler where id = ?";
		
	    SqlRowSet aGamblerRow = theDataBase.queryForRowSet(selectAGamblerByIdSql, id);
	    	// Define an object to be returned
	    Gambler aGambler = null;
	   
	    
	    // If at least one row was returned from SELECT SQL statment
	    //Convert it to a POJO
	    if(aGamblerRow.next()) {
         aGambler = MapRowToGambler(aGamblerRow);
	    }
	    
	    // Return the object with the values from row in the data set
		return aGambler;
	}

	@Override
	public List<Gambler> findGamblerByName(String name) {
		
		// Define an object hold the return value
		List<Gambler> gamblersFound = new ArrayList();	
		
		// Construct the LIKE string with '%' where needed
		String likeString = "%" + name + "%"; // find any row containing the name passed 
		
		// Define String with SQL statement to be run with placeholder '?' if needed
		String selectByNameSql = " Select * from gambler "
				                +" where gambler_name like ?";
				               // + "Where gambler_name = ?";
		
		// Send the SQL statemtn String  to the database mgr with any program variables
		SqlRowSet rowsFromDataBase = theDataBase.queryForRowSet(selectByNameSql, likeString);
		
		// Convert all rows received from database to POJOs and add to List to return
		  while(rowsFromDataBase.next()) {
	            gamblersFound.add(MapRowToGambler(rowsFromDataBase));
	        }
				
				                      
		return gamblersFound;
	}

	@Override
	
	// This Method receives a Gambler object with changed and unchanged data
	// We do this so we don't have to worry about what has changed
	//     The app is what worries about what has changed
	//     all we do is send and receive data to the data base
	// Application logic does not belong in a DOA
	public void update(Gambler gamblerPassed) {
		
		String updateGamblerSql = " update gambler "
				                + " set gambler_name = ? "
				                + "            ,address = ?"
				                + "            ,birth_date = ?"
				                + "            ,monthly_salary = ?"
				                + " where id = ?";
		
		try {		
			theDataBase.update(updateGamblerSql, gamblerPassed.getName()
					                           , gamblerPassed.getAddress()
					                           , gamblerPassed.getBirthDate()
					                           , gamblerPassed.getMonthlySalary()
					                           , gamblerPassed.getId()
					
							  );
		}
		catch (DataAccessException excpetionInfo) {
			System.out.println("!!!!! Error adding new Gambler " + gamblerPassed.getName() + " to Database !!!!");	 }	
			
	}

	@Override
	public void delete(long id) {
		
		String deleteByIdSql = "delete from gambler where id = ?";
		
		try {
			theDataBase.update(deleteByIdSql, id);
		}
		catch (DataAccessException excpetionInfo) {
			System.out.println("!!!!! Error deleting Gambler Id " + id + " from to Database !!!!");
		 }	
	}		
	
	
	// Create a gampler POJO from a row in the SqlRowSet
	// Be sure all columns expected by the methods
	//     ...were included in the select
	Gambler MapRowToGambler(SqlRowSet aRow) {
		// Define a POJO to be returned
        Gambler aGambler = new Gambler();

        // Use the setters for the POJO to set the values from the SqlRowSet
        aGambler.setId(aRow.getInt("id"));
        //Note: conversion of data base Date type to Java LocalDate type
        aGambler.setBirthDate(aRow.getDate("birth_date").toLocalDate());
        aGambler.setAddress(aRow.getString("address"));
        aGambler.setName(aRow.getString("gambler_name"));
        aGambler.setMonthlySalary(aRow.getDouble("monthly_salary"));

        // Send the completed POJO back to where this method was called
        return aGambler;
    }
	
} // End of class
