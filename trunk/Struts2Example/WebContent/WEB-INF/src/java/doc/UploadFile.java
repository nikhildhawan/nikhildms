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
		System.out.println(uploadContentType + "   " + uploadFileName);
		int uid, fid, rootdirid, curdirid, fileid;

		session = ActionContext.getContext().getSession();
		if (session == null)
		{

			System.out.println("Session is null");
		}
		else
		{
			System.out.println("Session is not null");
		}
		uid = (int) session.get("uid");
		curdirid = (int) session.get("usercurrentdirid");
		System.out.println("uid:" + uid + "curdirid" + curdirid);
//		getUploadContentType();
//		getUploadfile();
//		getUploadFileName();
//		System.out.println("lenght" + uploadfile.length());
		fileid = UserFile.saveFileMetadata(uid, uploadFileName, uploadContentType, upload.length(), curdirid);
		System.out.println("fileid generated and returned is " + fileid);
		return SUCCESS;
//		conn = DB.getConnection();

//		try
//		{
//
////			pstmt = conn.prepareStatement("insert into filedata(file) values(?)");
//			// pstmt.setInt(1, 2); changed column to autoincrement;
////			pstmt.setBlob(1, new FileInputStream(uploadfile), uploadfile.length());
////			pstmt.executeUpdate();
//			return SUCCESS;
//		}
//		catch (Exception e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return ERROR;
//		}
//		finally
//		{
//			try
//			{
//				conn.close();
//			}
//			catch (SQLException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
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
