package doc;

import java.util.*;

import model.Directory;
import model.UserFile;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Homepage extends ActionSupport
{
	private ArrayList directories, files;
	private Map session;
	private String username;
	private int uid, fid;

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
				uid = (int) session.get("uid");
				fid = Directory.getUserRootDir(uid);
				directories = Directory.getDirListByFolderId(fid, uid);
				files = UserFile.getFileListByFolderId(fid, uid);
				System.out.println(files.size() + " is size of files ");
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
