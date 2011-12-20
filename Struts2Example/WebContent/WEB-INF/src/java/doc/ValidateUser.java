package doc;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ValidateUser extends ActionSupport
{

	private Map session;
	private String username;

	@Override
	public String execute()
	{
		session = ActionContext.getContext().getSession();
		username = (String) session.get("userkey");
		if (username != null)
		{
			return SUCCESS;
		}
		else
		{
			return LOGIN;
		}
	}
}
