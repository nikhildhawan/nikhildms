package doc;

import java.util.*;

import model.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Comment extends ActionSupport
{
	String fileid, filename, filetype, username, commenttext;
	int intfileid, filesize, uid;
	UserFile ufile;
	ArrayList<UserFile> filemetadata = new ArrayList<UserFile>();
	ArrayList<model.Comment> commentlist = null;
	Map session;

	@Override
	public String execute()
	{
		if (fileid != null)
		{
			intfileid = Integer.parseInt(fileid);
			ufile = UserFile.getFileMetadata(intfileid);
			filename = ufile.getFilename();
			filesize = ufile.getFilesize() / (1024);
			ufile.setFilesize(filesize);
			System.out.println("before conversion" + ufile.getFilesize() + ": after conversion:" + filesize);
			filetype = ufile.getFiletype();
			filemetadata.add(ufile);
			commentlist = model.Comment.getComment(intfileid);
			return SUCCESS;
		}
		else
		{
			session = ActionContext.getContext().getSession();
			uid = (int) session.get("uid");
			username = (String) session.get("userkey");
			System.out.println("Inserting comment as " + intfileid + " " + uid + " " + username + " " + commenttext);
			model.Comment.saveComment(intfileid, uid, commenttext, username);
			ufile = UserFile.getFileMetadata(intfileid);
			filename = ufile.getFilename();
			filesize = ufile.getFilesize() / (1024);
			ufile.setFilesize(filesize);
			System.out.println("before conversion" + ufile.getFilesize() + ": after conversion:" + filesize);
			filetype = ufile.getFiletype();
			filemetadata.add(ufile);
			commentlist = model.Comment.getComment(intfileid);
			Collections.reverse(commentlist);
			System.out.println(commentlist.size() + " is the size of comment list");
			return SUCCESS;
		}

	}

	public String getCommenttext()
	{
		return commenttext;
	}

	public void setCommenttext(String commenttext)
	{
		this.commenttext = commenttext;
	}

	public ArrayList<UserFile> getFilemetadata()
	{
		return filemetadata;
	}

	public void setFilemetadata(ArrayList<UserFile> filemetadata)
	{
		this.filemetadata = filemetadata;
	}

	public ArrayList<model.Comment> getCommentlist()
	{
		return commentlist;
	}

	public void setCommentlist(ArrayList<model.Comment> commentlist)
	{
		this.commentlist = commentlist;
	}

	public int getIntfileid()
	{
		return intfileid;
	}

	public void setIntfileid(int intfileid)
	{
		this.intfileid = intfileid;
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

	public int getFilesize()
	{
		return filesize;
	}

	public void setFilesize(int filesize)
	{
		this.filesize = filesize;
	}

	public String getFileid()
	{
		return fileid;
	}

	public void setFileid(String fileid)
	{
		this.fileid = fileid;
	}
}
