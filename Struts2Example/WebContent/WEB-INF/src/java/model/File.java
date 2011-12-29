package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import myutil.DB;

public class File
{
	String filename, filetype;
	int fileid, filesize;

	public static ArrayList<File> getFileListByFolderId(int folderid, int uid)
	{

		ArrayList<File> filelist = new ArrayList<File>();
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
				sqlQuery = "select * from user_files where parentfolderid=" + folderid + " and userid='" + uid + "'";
				rs = stmt.executeQuery(sqlQuery);
				while (rs.next())
				{
					File file = new File();
					file.filename = rs.getString("filename");
					file.filesize = rs.getInt("filesize");
					file.filetype = rs.getString("filetype");
					file.fileid = rs.getInt("fileid");
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
}
