package doc;

import java.util.Map;

import model.User;
import model.UserFile;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShareFile extends ActionSupport
{
	String fileid, filename, shareuser, sharedfileid;
	int uid, intfileid, shareuid, result;
	Map session;

	@Override
	public String execute()
	{
		if (sharedfileid != null)
		{
			System.out.println("File id is not null:" + sharedfileid);
			session = ActionContext.getContext().getSession();
			uid = (int) session.get("uid");
			// intfileid = Integer.parseInt(sharedfileid);
			// System.out.println(intfileid + "this is integer of fileid");
			if (shareuser != null)
			{
				shareuid = User.getUserIdByName(shareuser);
				System.out.println("Shareid of user that was entered is:" + shareuid);
				System.out.println("id of user sharing file is:" + uid);
				System.out.println("File that has been shared is :" + sharedfileid);
				intfileid = Integer.parseInt(sharedfileid);
				result = UserFile.shareFile(uid, intfileid, shareuid);
				if (result == 1)
				{
					return SUCCESS;
				}
				else
				{
					return ERROR;
				}
			}
			else
			{
				System.out.println("Shareuser name is null");
			}
			// UserFile ufile = UserFile.getFileMetadata(intfileid, uid);
			// filename = ufile.getFilename();
			return SUCCESS;
		}
		else
		{
			System.out.println("File id is null:" + fileid);
			return ERROR;
		}

	}

	public String getSharedfileid()
	{
		return sharedfileid;
	}

	public void setSharedfileid(String sharedfileid)
	{
		this.sharedfileid = sharedfileid;
	}

	public String getShareuser()
	{
		return shareuser;
	}

	public void setShareuser(String shareuser)
	{
		this.shareuser = shareuser;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
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
