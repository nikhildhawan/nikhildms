package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import myutil.DB;

public class User
{
	String username;
	int uid;

	public static int getUserIdByName(String username)
	{
		int uid = -1;
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery;
		conn = DB.getConnection();
		if (conn == null)
		{
			return uid;
		}
		else
		{
			try
			{
				// System.out.println(uid + " has been recieved in model func 2");
				stmt = conn.createStatement();
				sqlQuery = "select id from users where username='" + username + "' ";
				rs = stmt.executeQuery(sqlQuery);
				while (rs.next())
				{
					uid = rs.getInt("id");
					return uid;
				}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return uid;
	}

	public static String findExistingUser(String name)
	{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery = "select * from users where username='" + name + "'";
		conn = DB.getConnection();
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			if (rs.next())
			{
				System.out.println("Inside db function username exists");
				return "Exists";
			}
			else
			{
				System.out.println("Inside db function username does not exists");
				return "Doesnt Exist";
			}

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Doesnt Exist";
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}