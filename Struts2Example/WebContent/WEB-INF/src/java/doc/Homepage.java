package doc;

import java.util.*;

import model.Directory;
import model.UserFile;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Homepage extends ActionSupport
{
	private ArrayList directories, files, sharedfiles;
	private Map session;
	private String username, newfoldername, foldername;
	private int uid, fid, currentfid;
	private String option;
	float usage;
	int percent;

	@Override
	public String execute()
	{

		session = ActionContext.getContext().getSession();
		if (session != null)
		{
			username = (String) session.get("userkey");
			if (username != null) // Invalid Session redirect to login
			{
				System.out.println("Username is not null and is " + username);
				uid = (int) session.get("uid");
				fid = Directory.getUserRootDir(uid);
				usage = UserFile.getUserUsage(uid);
				session.put("usage", usage);
				percent = (int) (usage * 2);
				session.put("percent", percent);
				if (option != null && option.compareToIgnoreCase("newfolder") == 0) // Creating new folder
				{
					// to do call createnewfolder
					currentfid = (int) session.get("usercurrentdirid");
					Directory.createNewFolder(newfoldername, currentfid, uid);
				}
				if (option != null && option.compareToIgnoreCase("changedirectory") == 0) // Changing directory
				{
					// System.out.println(newfid);
					session.put("usercurrentdirid", currentfid);
				}
				if (option != null && option.compareToIgnoreCase("parentdirectory") == 0) // Go to parent directory
				{
					// System.out.println(newfid);
					currentfid = Directory.getParentFolderId(currentfid);
					session.put("usercurrentdirid", currentfid);
				}
				else
				{
					currentfid = (int) session.get("usercurrentdirid"); // no options recieved set current direcetory to root directory of user.
				}
				foldername = Directory.getFolderName(currentfid);
				directories = Directory.getDirListByFolderId(currentfid, uid);
				files = UserFile.getDistinctFileListByFolderId(currentfid, uid);
				sharedfiles = UserFile.getSharedFilesByUserID(uid);
				System.out.println(files.size() + " is size of files ");
				System.out.println(sharedfiles.size() + " is size of shared files ");
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

	public String getFoldername()
	{
		return foldername;
	}

	public void setFoldername(String foldername)
	{
		this.foldername = foldername;
	}

	public String getNewfoldername()
	{
		return newfoldername;
	}

	public void setNewfoldername(String newfoldername)
	{
		this.newfoldername = newfoldername;
	}

	public ArrayList getSharedfiles()
	{
		return sharedfiles;
	}

	public void setSharedfiles(ArrayList sharedfiles)
	{
		this.sharedfiles = sharedfiles;
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
