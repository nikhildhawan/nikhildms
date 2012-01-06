package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import myutil.DB;

public class Comment
{
	int fileid, userid;
	String comment, username;
	String timestamp;

	public static void saveComment(int fileid, int userid, String comment, String username)
	{
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery = "insert into comments values(" + fileid + "," + userid + ",'" + comment + "', now(),'" + username + "' )";
		conn = DB.getConnection();
		try
		{
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlQuery);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
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

	public static ArrayList<Comment> getComment(int fileid)
	{
		ArrayList<Comment> commentlist = new ArrayList<Comment>();
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sqlQuery = "select * from comments where fileid=" + fileid + "";
		conn = DB.getConnection();
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			while (rs.next())
			{
				Comment comment = new Comment();
				comment.fileid = rs.getInt("fileid");
				comment.userid = rs.getInt("userid");
				comment.comment = rs.getString("comment");
				comment.username = rs.getString("username");
				comment.timestamp = rs.getString("timestamp");
				commentlist.add(comment);

			}
			return commentlist;

		}
		catch (SQLException e)
		{
			e.printStackTrace();
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
		return commentlist;
	}

	public int getFileid()
	{
		return fileid;
	}

	public void setFileid(int fileid)
	{
		this.fileid = fileid;
	}

	public int getUserid()
	{
		return userid;
	}

	public void setUserid(int userid)
	{
		this.userid = userid;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}
}
