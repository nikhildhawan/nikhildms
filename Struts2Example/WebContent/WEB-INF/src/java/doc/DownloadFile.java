package doc;

import java.io.InputStream;
import java.sql.*;

import myutil.DB;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadFile extends ActionSupport
{
	private ResultSet rs;
	private Connection conn;
	private String sqlQuery;
	private Statement stmt;
	private String fileid;
	private Blob fileblob;
	private InputStream inputStream;

	@Override
	public String execute()
	{
		conn = DB.getConnection();
		if (conn == null)
		{
			return ERROR;
		}
		sqlQuery = "select * from filedata where fileid=1";
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			if (rs.next())
			{
				fileblob = rs.getBlob("file");
				inputStream = fileblob.getBinaryStream();
				return SUCCESS;
			}
			else
			{
				return ERROR;
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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

}
