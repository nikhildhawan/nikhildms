package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB
{

	public static Connection getConnection()
	{
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "dms";
		String userName = "root";
		String password = "hello";

		try
		{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			// System.out.println("Connected to the database");
			// conn.close();
			// System.out.println("Disconnected from database");
			return conn;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}
}
