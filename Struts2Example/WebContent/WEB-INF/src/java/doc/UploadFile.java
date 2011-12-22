package doc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Map;

import myutil.DB;

import com.opensymphony.xwork2.ActionSupport;

public class UploadFile extends ActionSupport
{
	private File uploadfile;
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
		conn = DB.getConnection();
		if (conn == null)
		{
			return ERROR;
		}

		try
		{
			pstmt = conn.prepareStatement("insert into files values(?,?)");
			pstmt.setInt(1, 1);
			pstmt.setBlob(2, new FileInputStream(uploadfile), uploadfile.length());
			pstmt.executeUpdate();
			return SUCCESS;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public File getUploadfile()
	{
		return uploadfile;
	}

	public void setUploadfile(File uploadfile)
	{
		this.uploadfile = uploadfile;
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
