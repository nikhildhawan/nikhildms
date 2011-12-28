package model;

import java.sql.*;
import java.util.*;

import myutil.DB;

public class Directory
{
	private int folderid, parentfolderid, userid;
	private String foldername;

	public static ArrayList<Directory> getUserRootDirs(String username)
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
				System.out.println(username + " has been recieved in model");
				stmt = conn.createStatement();
				sqlQuery = "select * from user_folders where userid=1 and parentfolderid=1";
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
		}
		return dirlist;
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
