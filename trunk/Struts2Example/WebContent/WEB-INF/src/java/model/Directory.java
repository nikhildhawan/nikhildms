package model;

import java.sql.*;
import java.util.*;

import myutil.DB;

public class Directory
{
	private int folderid, parentfolderid, userid;
	private String foldername;

	public static int getUserRootDir(int uid)
	{
		ArrayList<Directory> dirlist = new ArrayList<Directory>();
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery;
		conn = DB.getConnection();
		int fid = -1;
		if (conn == null)
		{
			return -1;
		}
		else
		{
			try
			{
				System.out.println(uid + " has been recieved in model");
				stmt = conn.createStatement();
				sqlQuery = "select folderid from user_folders where userid=" + uid + " and foldername='root'";
				rs = stmt.executeQuery(sqlQuery);
				if (rs.next())
				{
					fid = rs.getInt("folderid");
				}
				// dirlist = getDirListByFolderId(fid, uid);

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
					e.printStackTrace();
				}
			}
		}
		return fid;
	}

	public static ArrayList<Directory> getDirListByFolderId(int folderid, int uid)
	{
		ArrayList<Directory> dirlist = new ArrayList<Directory>();
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
				sqlQuery = "select * from user_folders where parentfolderid=" + folderid + " and userid='" + uid + "'";
				rs = stmt.executeQuery(sqlQuery);
				while (rs.next())
				{
					Directory directory = new Directory();
					directory.folderid = rs.getInt("folderid");
					directory.foldername = rs.getString("foldername");
					directory.parentfolderid = rs.getInt("parentfolderid");
					directory.userid = rs.getInt("userid");
					dirlist.add(directory);
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
			return dirlist;
		}
	}

	public static int createNewFolder(String foldername, int parentfolderid, int userid)
	{
		int newGeneratedFolderId = -1;
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery;
		conn = DB.getConnection();
		if (conn == null)
		{
			return newGeneratedFolderId;
		}
		else
		{
			try
			{
				stmt = conn.createStatement();
				sqlQuery = " insert into user_folders (foldername,parentfolderid,userid) values ( '" + foldername + "', " + parentfolderid + " , " + userid + ") ";
				stmt.executeUpdate(sqlQuery);
				return 1;
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
		return -1;
	}

	public static int getParentFolderId(int folderid)
	{
		int parentId = -1;
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery;
		conn = DB.getConnection();
		if (conn == null)
		{
			return parentId;
		}
		else
		{
			try
			{
				stmt = conn.createStatement();
				sqlQuery = "select parentfolderid from user_folders where folderid=" + folderid;
				rs = stmt.executeQuery(sqlQuery);
				if (rs.next())
				{
					parentId = rs.getInt("parentfolderid");
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
		return parentId;
	}

	public static String getFolderName(int folderid)
	{
		String foldername = "";
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery;
		conn = DB.getConnection();
		if (conn == null)
		{
			return foldername;
		}
		else
		{
			try
			{
				stmt = conn.createStatement();
				sqlQuery = "select foldername from user_folders where folderid=" + folderid;
				rs = stmt.executeQuery(sqlQuery);
				if (rs.next())
				{
					foldername = rs.getString("foldername");
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
		return foldername;

	}

	public static int deleteFolder(int folderid)
	{
		int result = -1;
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery = "delete from user_folders where folderid=" + folderid;
		conn = DB.getConnection();
		try
		{
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sqlQuery);
			return result;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return result;
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

	public int getFolderid()
	{
		return folderid;
	}

	public void setFolderid(int folderid)
	{
		this.folderid = folderid;
	}

	public int getParentfolderid()
	{
		return parentfolderid;
	}

	public void setParentfolderid(int parentfolderid)
	{
		this.parentfolderid = parentfolderid;
	}

	public int getUserid()
	{
		return userid;
	}

	public void setUserid(int userid)
	{
		this.userid = userid;
	}

	public String getFoldername()
	{
		return foldername;
	}

	public void setFoldername(String foldername)
	{
		this.foldername = foldername;
	}
}
