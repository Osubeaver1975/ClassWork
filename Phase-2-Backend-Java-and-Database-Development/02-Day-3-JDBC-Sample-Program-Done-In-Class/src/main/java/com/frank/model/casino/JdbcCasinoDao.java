package com.frank.model.casino;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
// Implementation of the DAO interface methods
//   (and any other methods required to access the data base)
public class JdbcCasinoDao implements CasinoDao {
	
	// Define a reference to a JdbcTemplateObject we can use to access the tables in the database
	private JdbcTemplate theMoneyBar;
	
	
	public JdbcCasinoDao(DataSource aDataSource) {
		this.theMoneyBar = new JdbcTemplate(aDataSource);
	}
	@Override
	public List<Casino> getAllCasino() {
		// Design a String with SQL to be run
		String allCasinos = "select * from casino";
		
		// Send the String to the data base manager and store results in an SqlRowSet
		SqlRowSet roseSet = theMoneyBar.queryForRowSet(allCasinos)
				
		//Define the object containing all Casinos
		List<Casino> casinoRoyale = new ArrayList();
		
		// "Parse the results" - convert the rows from select into casino objects
		//						using a method to retrieve each row, create a casino
		//						then add the casino object to the list
		
		return null;
	} 

	@Override
	public Casino getCasinoByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCasino(Casino casino) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateCasino(Casino aCasino) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void trashCasino(String name) {
		// TODO Auto-generated method stub
		
	}



}
