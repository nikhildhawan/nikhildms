package doc;

import model.Directory;
import model.UserFile;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteFolder extends ActionSupport
{
	String folderid;
	int intfolderid;

	@Override
	public String execute()
	{
		if (folderid != null)
		{
			intfolderid = Integer.parseInt(folderid);
			Directory.deleteFolder(intfolderid);
			return SUCCESS;
		}
		return ERROR;
	}

	public String getFolderid()
	{
		return folderid;
	}

	public void setFolderid(String folderid)
	{
		this.folderid = folderid;
	}

}
