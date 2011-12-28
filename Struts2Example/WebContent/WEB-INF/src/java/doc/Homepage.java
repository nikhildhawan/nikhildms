package doc;

import java.util.*;

import model.Directory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Homepage extends ActionSupport
{
	private ArrayList directories, files;
	private Map session;
	private String username;
	private int id;

	@Override
	public String execute()
	{
		session = ActionContext.getContext().getSession();
		if (session != null)
		{
			username = (String) session.get("userkey");
			if (username != null)
			{
				System.out.println("Username is not null and is " + username);
				id = (int) session.get("id");
				directories = Directory.getUserRootDirs(username);
				return SUCCESS;
			}
			else
			{
				System.out.println("Username is null and is " + username);
				return LOGIN;
			}
		}
		else
		{
			return LOGIN;
		}
	}

	public ArrayList getDirectories()
	{
		return directories;
	}

	public void setDirectories(ArrayList directories)
	{
		this.directories = directories;
	}

	public ArrayList getFiles()
	{
		return files;
	}

	public void setFiles(ArrayList files)
	{
		this.files = files;
	}

}
