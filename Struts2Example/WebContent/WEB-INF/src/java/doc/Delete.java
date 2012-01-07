package doc;

import model.UserFile;

import com.opensymphony.xwork2.ActionSupport;

public class Delete extends ActionSupport
{
	String fileid;
	int intfileid;

	@Override
	public String execute()
	{
		if (fileid != null)
		{
			intfileid = Integer.parseInt(fileid);
			UserFile.deleteFile(intfileid);
			return SUCCESS;
		}
		return ERROR;
	}

	public String getFileid()
	{
		return fileid;
	}

	public void setFileid(String fileid)
	{
		this.fileid = fileid;
	}

}
