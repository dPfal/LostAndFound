package services.registration;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.ActionBean;

public class Registration {

	private HttpServletRequest req;
	public Registration(HttpServletRequest req)
	{
		this.req = req;
	}
	public ActionBean backController(int jobkey)
	{
		ActionBean action = null;
		switch (jobkey) {
		case -1:
			break;
		case 1: 
			break;
		case 2: case 10:
			break;
		case 3: 
//			action=this.memberJoinCtl();
			break;
		case 11: 
			break;
		case 12:
			break;
		}
		return action;
	}
}