package doc;

import java.util.ArrayList;
import java.util.Map;

import model.Directory;
import model.UserFile;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AllVersion extends ActionSupport
{
	private ArrayList allversions;
	private Map session;
	private String foldername, filename;
	private int fileid = -1, uid, fid, currentfid;

	@Override
	public String execute()
	{
		session = ActionContext.getContext().getSession();
		if (fileid != -1)
		{
			currentfid = (int) session.get("usercurrentdirid");
			foldername = Directory.getFolderName(currentfid);
			UserFile ufile = UserFile.getFileMetadata(fileid);
			filename = ufile.getFilename();
			allversions = UserFile.getAllVersions(filename, currentfid);
			System.out.println(allversions.size() + "size of all versions");
			return SUCCESS;
		}
		return ERROR;

	}

	public int getFileid()
	{
		return fileid;
	}

	public void setFileid(int fileid)
	{
		this.fileid = fileid;
	}

	public ArrayList getAllversions()
	{
		return allversions;
	}

	public void setAllversions(ArrayList allversions)
	{
		this.allversions = allversions;
	}

	public String getFoldername()
	{
		return foldername;
	}

	public void setFoldername(String foldername)
	{
		this.foldername = foldername;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public int getCurrentfid()
	{
		return currentfid;
	}

	public void setCurrentfid(int currentfid)
	{
		this.currentfid = currentfid;
	}
}
