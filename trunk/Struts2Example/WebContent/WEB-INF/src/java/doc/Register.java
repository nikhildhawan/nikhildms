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
	private String sqlQuery1, sqlQuery2;
	int rows, newGeneratedUId;
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
		sqlQuery1 = "insert into users (username,password,emailid) values ('" + username + "','" + password + "','" + email + "')";

		try
		{
			stmt = conn.createStatement();
			rows = stmt.executeUpdate(sqlQuery1, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			if (rs.next())
			{
				newGeneratedUId = rs.getInt(1);
			}
			sqlQuery2 = "insert into user_folders(foldername,userid) values('root', " + newGeneratedUId + " ) ";
			rows = stmt.executeUpdate(sqlQuery2);
			session.put("userkey", username);
			session.put("uid", newGeneratedUId);
			return SUCCESS;
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