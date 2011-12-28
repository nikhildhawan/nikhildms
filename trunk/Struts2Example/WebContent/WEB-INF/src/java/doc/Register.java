package doc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import myutil.DB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport
{
	private String username, email, password;

	private ResultSet rs;
	private Connection conn;
	private String sqlQuery;
	int rows;
	private Statement stmt;
	private Map session;

	@SuppressWarnings("unchecked")
	@Override
	public String execute()
	{
		session = ActionContext.getContext().getSession();
		conn = DB.getConnection();
		if (conn == null)
		{
			return ERROR;
		}
		System.out.println("being inserted: " + username + " " + password + " " + email + " 000000000000000000000000000000000000000");
		sqlQuery = "insert into users (userid,password,emailid) values ('" + username + "','" + password + "','" + email + "')";
		try
		{
			stmt = conn.createStatement();
			rows = stmt.executeUpdate(sqlQuery);
			if (rows == 1)
			{
				session.put("userkey", username);
				return SUCCESS;

			}
			else
			{
				System.out.println("Rows effected not 1 for sqlQuery" + sqlQuery);
				return SUCCESS;
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
