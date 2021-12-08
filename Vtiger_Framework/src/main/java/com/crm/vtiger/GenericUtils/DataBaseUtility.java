package com.crm.vtiger.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods to read data from database
 * @author HP
 */
public class DataBaseUtility 
{
	Connection con=null;
	ResultSet result=null;
	Driver driverRef;
	
	/**
	 * Connection with database is established
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
	}
	/**
	 * DB connection is closed
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
		
	}
	/**
	 * this method returns the data wrt to column index
	 * @param query
	 * @param Columnindex
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromDB(String query,int Columnindex) throws Throwable
	{
		String value=null;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			value=result.getString(Columnindex);
		}
		
		return value;
		
	}
	
	/**
	 * get data from DB and verify.
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromDB(String query,int columnName,String expData) throws Throwable
	{
		boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnName).equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData +"DATA VERIFIED INDATABASE");
			return expData;
		}
		else
		{
			System.out.println(expData +"DATA NOT VERIFIED");
		return expData;
		}
	}
}
