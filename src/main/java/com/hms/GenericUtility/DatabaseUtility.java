package com.hms.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con=null;
	/** this is method is used to connect Database
	 * @author Shivamma A
	 * @throws SQLException
	 */
	public void connectionToDB() throws SQLException
	{
	
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(Ipathconstants.dbURL, Ipathconstants.dbUsername, Ipathconstants.dbPassword);
	}
	
	public String executeQueryAndGetData(String query, int ColumnNo, String ExpData) throws SQLException
	{
		/** This method is used to Execute query and get the data
		 * @author Shivamma A
		 */
		 ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data = result.getString(ColumnNo);
			if(data.equalsIgnoreCase(ExpData))
			{
				flag=true;
				break;
				
			}
		}
		if(flag)
		{
			System.out.println("...data is verified");
			return ExpData;
		}
		else
		{
			System.out.println("...data is not Present");
			return "";

		}	
		
	}
	public void closeDB() throws SQLException
	{
		con.close();
	}

}

