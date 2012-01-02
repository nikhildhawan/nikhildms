package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import myutil.DB;

public class UserFile
{
	String filename, filetype;
	int fileid, filesize;
	int folderid, parentFolderId;

	public static ArrayList<UserFile> getFileListByFolderId(int folderid, int uid)
	{

		ArrayList<UserFile> filelist = new ArrayList<UserFile>();
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery;
		conn = DB.getConnection();
		if (conn == null)
		{
			return null;
		}
		else
		{
			try
			{
				System.out.println(uid + " has been recieved in model func 2");
				stmt = conn.createStatement();
				sqlQuery = "select * from user_files where parentfolderid=" + folderid + " and userid=" + uid + "";
				System.out.println(sqlQuery);
				rs = stmt.executeQuery(sqlQuery);
				while (rs.next())
				{
					System.out.println("Resultset files has data ");
					UserFile file = new UserFile();
					file.filename = rs.getString("filename");
					file.filesize = rs.getInt("filesize");
					file.filetype = rs.getString("filetype");
					file.fileid = rs.getInt("fileid");
					filelist.add(file);
				}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
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
			return filelist;
		}

	}

	public static int saveFileMetadata(int uid, String fileName, String fileType, long fileSize, int parentfolderid)
	{
		System.out.println("hello from savefilemetadata");
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery;
		conn = DB.getConnection();
		int newGeneratedFileid = -1;
		if (conn == null)
		{
//			return null;
			System.out.println("Connection is null in userfile..java");
		}
		else
		{
			System.out.println("Connection succesful");
			try
			{
				sqlQuery = "insert into user_files (userid,filename,filetype,filesize,parentfolderid) values (" + uid + " , '" + fileName + "' , '" + fileType + "' , " + fileSize + " , " + parentfolderid + " ) ";
				stmt = conn.createStatement();
				System.out.println(sqlQuery);
				stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
				rs = stmt.getGeneratedKeys();
				if (rs.next())
				{
					newGeneratedFileid = rs.getInt(1);
					System.out.println("New generated key is " + newGeneratedFileid);

				}
				else
				{
					System.out.println("no key generated");
				}

			}
			catch (Exception ex)
			{
				ex.getStackTrace();
			}
		}
		return newGeneratedFileid;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getFiletype()
	{
		return filetype;
	}

	public void setFiletype(String filetype)
	{
		this.filetype = filetype;
	}

	public int getFileid()
	{
		return fileid;
	}

	public void setFileid(int fileid)
	{
		this.fileid = fileid;
	}

	public int getFilesize()
	{
		return filesize;
	}

	public void setFilesize(int filesize)
	{
		this.filesize = filesize;
	}

	public int getFolderid()
	{
		return folderid;
	}

	public void setFolderid(int folderid)
	{
		this.folderid = folderid;
	}

	public int getParentFolderId()
	{
		return parentFolderId;
	}

	public void setParentFolderId(int parentFolderId)
	{
		this.parentFolderId = parentFolderId;
	}
}
