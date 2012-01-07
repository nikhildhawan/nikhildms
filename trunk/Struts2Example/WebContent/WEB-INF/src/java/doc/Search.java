package doc;

import java.util.ArrayList;
import java.util.Map;

import model.UserFile;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Search extends ActionSupport
{
	String searchtext;
	int uid;
	Map session;
	ArrayList searchfilelist;

	@Override
	public String execute()
	{
		if (searchtext == null)
		{
			searchtext = "";
		}
		session = ActionContext.getContext().getSession();
		uid = (int) session.get("uid");
		searchfilelist = UserFile.getFileListBySearch(searchtext, uid);
		return SUCCESS;
	}

	public ArrayList getSearchfilelist()
	{
		return searchfilelist;
	}

	public void setSearchfilelist(ArrayList searchfilelist)
	{
		this.searchfilelist = searchfilelist;
	}

	public String getSearchtext()
	{
		return searchtext;
	}

	public void setSearchtext(String searchtext)
	{
		this.searchtext = searchtext;
	}

	public int getUid()
	{
		return uid;
	}

	public void setUid(int uid)
	{
		this.uid = uid;
	}

}
