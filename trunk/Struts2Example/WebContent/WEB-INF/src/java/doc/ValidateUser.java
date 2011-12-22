package doc;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.sql.*;
import java.util.*;

import myutil.DB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ValidateUser extends ActionSupport
{
	private String username;
	private String option;
	private InputStream inputStream;

	@SuppressWarnings("deprecation")
	@Override
	public String execute()
	{
		if (option != null)
		{
			String name = findExistingUser(username);
			inputStream = new StringBufferInputStream(name);
			return "ajaxCall";
		}
		else
		{
			// to do other things.
			return SUCCESS;
		}
	}

	String findExistingUser(String name)
	{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery = "select * from users where userid='" + name + "'";
		conn = DB.getConnection();
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			if (rs.next())
			{
				return "Exists";
			}
			else
			{
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

	public InputStream getInputStream()
	{
		return inputStream;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getOption()
	{
		return option;
	}

	public void setOption(String option)
	{
		this.option = option;
	}

}
