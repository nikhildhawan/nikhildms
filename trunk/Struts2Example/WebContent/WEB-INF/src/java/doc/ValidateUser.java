package doc;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.sql.*;

import model.User;
import myutil.DB;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("deprecation")
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
			String name = User.findExistingUser(username);
			System.out.println("checking user" + username + " which returned" + name + "");
			inputStream = new StringBufferInputStream(name);
			return "ajaxCall";
		}
		else
		{
			return SUCCESS;
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
