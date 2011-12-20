package doc;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class Logout extends ActionSupport
{
	private Map session;

	@Override
	public String execute()
	{
		session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}

}
