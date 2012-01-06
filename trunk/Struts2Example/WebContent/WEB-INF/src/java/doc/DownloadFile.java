package doc;

import java.io.InputStream;
import java.sql.*;
import java.util.Map;

import model.UserFile;
import myutil.DB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadFile extends ActionSupport
{
	private ResultSet rs;
	private Connection conn;
	private String sqlQuery;
	private Statement stmt;
	private String fileid, shareduid;
	private int intfileid;
	private Blob fileblob;
	private int uid;

	private InputStream inputStream;
	private String contentDisposition, contentType;
	private Map session;

	@Override
	public String execute()
	{
		if (fileid != null)
		{
			System.out.println("File id got from jsp before downloading is:" + fileid);
			try
			{
				intfileid = Integer.parseInt(fileid);
			}
			catch (NumberFormatException e1)
			{
				e1.printStackTrace();
				addActionError("Invalid Request for Download");
				return ERROR;
			}
			session = ActionContext.getContext().getSession();
			if (shareduid != null)
			{
				try
				{
					uid = Integer.parseInt(shareduid);
				}
				catch (Exception ex)
				{
					addActionError("Invalid Request for Download");
					return ERROR;
				}
			}
			else
			{
				uid = (int) session.get("uid");
			}
			System.out.println(uid + " uid recieved from jsp before downloading it.");
			fileblob = UserFile.getFileAsBlob(intfileid);
			if (fileblob == null)
			{
				System.out.println("Null fileblob recieved");
				addActionError("Invalid Request for Download");
				return ERROR;
			}
			UserFile ufile = UserFile.getFileMetadata(intfileid);
			if (ufile == null)
			{
				System.out.println("Null userfile object was recieved");
				addActionError("Invalid Request for Download");
				return ERROR;
			}
			if (uid == ufile.getUserid())
			{
				System.out.println("Userid of downloaded file doesnt match with userid in session");
				addActionError("Invalid Request for Download");
				return ERROR;
			}

			contentDisposition = "attachment;filename=" + ufile.getFilename();
			contentType = ufile.getFiletype();
			try
			{
				inputStream = fileblob.getBinaryStream();

			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}
		else
		{
			System.out.println("No fileid was recieved");
			addActionError("Invalid Request for Download");
			return ERROR;
		}
	}

	public String getShareduid()
	{
		return shareduid;
	}

	public void setShareduid(String shareduid)
	{
		this.shareduid = shareduid;
	}

	public String getFileid()
	{
		return fileid;
	}

	public void setFileid(String fileid)
	{
		this.fileid = fileid;
	}

	public InputStream getInputStream()
	{
		return inputStream;
	}

	public String getContentDisposition()
	{
		return contentDisposition;
	}

	public String getContentType()
	{
		return contentType;
	}
}
