package doc;

import java.sql.*;
import java.util.Map;

import myutil.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport
{
	private String message, userId, password;
	private ResultSet rs;
	private Connection conn;
	private String sqlQuery;
	private Statement stmt;
	private Map session;

	@Override
	public String execute()
	{
		session = ActionContext.getContext().getSession();
		conn = DB.getConnection();
		if (conn == null)
		{
			return ERROR;
		}
		sqlQuery = "select * from users where userid='" + userId + "' and password='" + password + "'";
		try
		{

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			if (rs.next())
			{
				if (rs.getString("Password").compareTo(password) == 0) // checking case for password.
				{
					message = "Welcome to Login Screen" + userId;
					session.put("userkey", userId);
					return SUCCESS;
				}
				else
				{
					message = "Incorrect password for user " + userId + "Act pass is:" + password;
					return ERROR;
				}
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
