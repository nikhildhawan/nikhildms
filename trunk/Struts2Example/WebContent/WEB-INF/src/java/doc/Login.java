package doc;

import java.sql.*;

import util.*;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport
{
	private String message, userId, password;
	ResultSet rs;
	private Connection conn;
	String sqlQuery;
	Statement stmt;

	@Override
	public String execute()
	{
		conn = DB.getConnection();
		sqlQuery = "select * from users where userid='" + getUserId() + "' and password='" + getPassword() + "'";
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			if (rs.next())
			{
				message = "Welcome to Login Screen" + getUserId();
				return SUCCESS;
			}
			else
			{
				message = "Login Failed for user " + userId;
				return ERROR;
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
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

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
