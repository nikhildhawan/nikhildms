package doc;

import java.sql.*;
import java.util.Map;

import model.Directory;
import myutil.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport
{
	private String message, username, password;

	private ResultSet rs;
	private Connection conn;
	private String sqlQuery;
	private Statement stmt;
	private Map session;

	@Override
	public String execute()
	{
		int uid, userRootDir;
		session = ActionContext.getContext().getSession();
		conn = DB.getConnection();
		if (conn == null)
		{
			System.out.println("Connection is null");
			return ERROR;
		}
		sqlQuery = "select * from users where username='" + username + "' and password='" + password + "'";
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			System.out.println(sqlQuery);
			if (rs.next())
			{
				if (rs.getString("Password").compareTo(password) == 0) // checking case for password.
				{
					message = "Welcome to Login Screen" + username;
					uid = rs.getInt("id");
					session.put("uid", uid);
					session.put("userkey", username);
					userRootDir = Directory.getUserRootDir(uid);
					session.put("userrootdirid", userRootDir);
					session.put("usercurrentdirid", userRootDir);
					return SUCCESS;
				}
				else
				{
					message = "Incorrect password for user " + username + "Act pass is:" + password;
					return ERROR;
				}
			}
			else
			{
				message = "Login Failed for user " + username;
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

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
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
