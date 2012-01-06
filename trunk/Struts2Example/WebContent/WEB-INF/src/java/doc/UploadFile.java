package doc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Map;

import myutil.DB;
import model.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadFile extends ActionSupport
{
	private File upload;
	private String uploadContentType; // The content type of the file
	private String uploadFileName; // The uploaded file name
	private ResultSet rs;
	private Connection conn;
	private String sqlQuery;
	private Statement stmt;
	private Map session;
	private PreparedStatement pstmt;

	@Override
	public String execute()
	{
		int uid, fid, rootdirid, curdirid, fileid;
		float usage;

		session = ActionContext.getContext().getSession();
		if (session == null)
		{
			System.out.println("Session is null");
		}
		else
		{
			System.out.println("Session is not null");
		}
		if (upload == null)
		{
			System.out.println("No file was selected");
			addActionError("Please select a file to upload");
			return ERROR;

		}
		if (upload.length() > 50000000)
		{
			System.out.println("File selected is greater than 50MB");
			addActionError("File selected can not be greater than 50 MB");
			return ERROR;
		}
		uid = (int) session.get("uid");
		curdirid = (int) session.get("usercurrentdirid");
		System.out.println(" file being uploaded by uid:" + uid + ", to curdirid" + curdirid);
		usage = (float) session.get("usage");
		if (usage + (upload.length() / (1024 * 1024)) > 50.00)
		{
			System.out.println("Usage has been increased more than 50 limit and will become:" + usage + (upload.length() / (1024 * 1024)));
			addActionError("You have reached the quota limit for the account,file can not be uploaded");
			addActionError("Space left in account  is " + (50 - usage) + " MB");
			return ERROR;
		}
		fileid = UserFile.saveFileMetadata(uid, uploadFileName, uploadContentType, upload.length(), curdirid);
		UserFile.saveFile(fileid, upload);
		return SUCCESS;
	}

	public File getUpload()
	{
		return upload;
	}

	public void setUpload(File upload)
	{
		this.upload = upload;
	}

	public String getUploadContentType()
	{
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName()
	{
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}

}
