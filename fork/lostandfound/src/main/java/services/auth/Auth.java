package services.auth;
import javax.servlet.http.HttpServletRequest;

import beans.ActionBean;

public class Auth {

	private HttpServletRequest rq;
	public Auth(HttpServletRequest rq)
	{
		this.rq = rq;
	}
	
	public ActionBean backController(int jobkey)
	{
		ActionBean action= null;
		
		return action;
	}
}