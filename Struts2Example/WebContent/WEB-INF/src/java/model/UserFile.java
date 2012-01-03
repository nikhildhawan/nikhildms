package model;

import java.io.*;
import java.sql.*;
import java.util.*;

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
				System.out.println("user id" + uid + " has been recieved in model userfile func getfilelistbyfolderid");
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
		return newGeneratedFileid;
	}

	public static int saveFile(int fileid, File file)
	{
		int result = -1;
		Connection conn;
		Statement stmt;
		PreparedStatement pstmt;
		ResultSet rs;
		String sqlQuery;
		conn = DB.getConnection();
		if (conn == null)
		{
			return result;
		}
		else
		{
			try
			{
				sqlQuery = "insert into filedata values( ?,? ) ";
				System.out.println(sqlQuery);
				pstmt = conn.prepareStatement(sqlQuery);
				pstmt.setInt(1, fileid);
				pstmt.setBlob(2, new FileInputStream(file), file.length());
				pstmt.executeUpdate();
				result = 1;
			}
			catch (Exception ex)
			{
				System.out.println("Error in inserting filedata");
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
		}

		return result;
	}

	public static Blob getFileAsBlob(int fileid)
	{
		File file = null;
		Connection conn;
		Statement stmt;
		PreparedStatement pstmt;
		Blob fileblob;
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
				stmt = conn.createStatement();
				sqlQuery = "select * from filedata where fileid=" + fileid + "";
				rs = stmt.executeQuery(sqlQuery);
				if (rs.next())
				{
					fileblob = rs.getBlob("file");
					return fileblob;
				}
				else
				{
					return null;
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
		}

		return null;
	}

	public static UserFile getFileMetadata(int fileid, int userid)
	{
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
				sqlQuery = "select * from user_files where fileid= " + fileid + " and userid= " + userid + " ";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlQuery);
				if (rs.next())
				{
					UserFile file = new UserFile();
					file.fileid = rs.getInt("fileid");
					file.filename = rs.getString("filename");
					file.filetype = rs.getString("filetype");
					file.filesize = rs.getInt("filesize");
					return file;
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
		}

		return null;
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