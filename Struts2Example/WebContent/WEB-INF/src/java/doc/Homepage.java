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
	private int uid, fid, currentfid;
	private String option;

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

				if (option != null && option.compareToIgnoreCase("newfolder") == 0) // Creating new folder
				{
					// to do call createnewfolder
					currentfid = (int) session.get("usercurrentdirid");
					Directory.createNewFolder("New Folder", currentfid, uid);
				}
				if (option != null && option.compareToIgnoreCase("changedirectory") == 0)
				{
					// System.out.println(newfid);
					session.put("usercurrentdirid", currentfid);
				}
				else
				{
					currentfid = (int) session.get("usercurrentdirid");
				}
				directories = Directory.getDirListByFolderId(currentfid, uid);
				files = UserFile.getFileListByFolderId(currentfid, uid);
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

	public int getCurrentfid()
	{
		return currentfid;
	}

	public void setCurrentfid(int currentfid)
	{
		this.currentfid = currentfid;
	}

	public String getOption()
	{
		return option;
	}

	public void setOption(String option)
	{
		this.option = option;
	}

	public void addFolder()
	{

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
