package com.struts2crud.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager
{
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Crud;user=sa;password=dhaval8951";

	static Connection getConnection() throws SQLException
	{
		java.sql.Connection conn = null;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(URL);
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (conn != null)
		{
			return conn;
		}
		else
		{
			// log.info("Unable to acquired the DB connection");
			throw new SQLException("Unable to acquired the DB connection");
		}

	}

	static void releaseConnection(Connection conn) throws SQLException
	{
		if (conn != null)
		{
			conn.close();
		}
	}

}
