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
	private String fileid;
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
			intfileid = Integer.parseInt(fileid);
			session = ActionContext.getContext().getSession();
			uid = (int) session.get("uid");
			System.out.println(uid + " uid recieved from jsp before downloading it.");
			fileblob = UserFile.getFileAsBlob(intfileid);
			UserFile ufile = UserFile.getFileMetadata(intfileid, uid);
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
			return ERROR;
		}
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
