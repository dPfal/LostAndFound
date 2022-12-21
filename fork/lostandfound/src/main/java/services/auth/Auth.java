package services.auth;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

//import beans.AccessLogBean;
import beans.ActionBean;
import beans.MemberBean;

public class Auth {

	private HttpServletRequest req;
	private AuthDataAccessObject dao;
	private Connection connect;

	public Auth(HttpServletRequest req) {
		this.req = req;
	}

	public ActionBean backController(int jobkey) {
		ActionBean action = null;
		switch (jobkey) {
		case -1:
			action = this.MovePage();
			break;
		case 100:
			action = this.moveLoginPage();
			break;
		case 101:
			action = this.login();
//		case 102:
//			action = this.logoutctl();
		}
		return action;
	}

	private ActionBean login() {
		ActionBean action = new ActionBean();
		MemberBean member = new MemberBean();
		String page = "g-lostArticle.jsp";

		AuthDataAccessObject dao = new AuthDataAccessObject();
		Connection connection = dao.openConnection();

		member.setMM_ID(req.getParameter("MM_ID"));
		member.setMM_PW(req.getParameter("MM_PW"));

		ArrayList<MemberBean> memberlist = new ArrayList<MemberBean>();
		memberlist.add(member);

		dao.modifyTranStatus(connection, false);
		if (this.convertToBoolean(dao.LoginCheck(connection, member))) {
			if (this.convertToBoolean(dao.PasswordCheck(connection, member))) {
				System.out.println("로그인이 완료되었습니다!");
				action.setPage(page);
			}
		}
		else {
			action.setPage("loginfail.jsp");
		}

		dao.setTransaction(true, connection);
		dao.modifyTranStatus(connection, true);
		dao.closeConnection(connection);

		
		action.setRedirect(true);

		return action;
	}

	private ActionBean moveLoginPage() {
		ActionBean action = new ActionBean();

		String page = "loginStep0.jsp?previous=" + getRefererPage();
		boolean isRedirect = true;

		action.setPage(page);
		action.setRedirect(isRedirect);

		return action;

	}
	private ActionBean MovePage()
	{
		ActionBean action = new ActionBean();
		String page=this.req.getParameter("target");	
		
		action.setPage(page);
		action.setRedirect(true);
		
		return action;
	}
//	private ActionBean logoutctl() {
//
//		ActionBean action = new ActionBean();
//		MemberBean member = new MemberBean();
//		ArrayList<AccessLogBean> login = new ArrayList<AccessLogBean>();
//		AccessLogBean log = new AccessLogBean();
//		String page = "index.jsp";
//		boolean isForward = false, tran = false;
//		
//		this.dao = new AuthDataAccessObject();
//		this.connect = this.dao.openConnection();
//		this.dao.modifyTranStatus(connect, false);
//		
//		
//		log.setAccessType("-1");
//		login.add(log);
//		
//		member.getMM_ID();
//		member.getMM_PW();
//		member.setAccessInfo(login);
//		
//		
//
//		/*DAO 연s결*/
//		
//		AuthDataAccessObject dao = new AuthDataAccessObject();
//		Connection connection = dao.openConnection();
//		dao.modifyTranStatus(connection, false);
//		
//	
//		
//		this.dao.setTransaction(tran, connect);
//		this.dao.modifyTranStatus(connect, true);
//		this.dao.closeConnection(connect);
//		this.dao = null;
//		
//		action.setPage(page);
//		action.setRedirect(isForward);
//
//		return action;
//
//	}
	
	
//	boolean isAccess(MemberBean member) {
//		boolean isAccess =false,
//				isDao= this.dao !=null?true:false;
//		
//		if(!isDao) {
//			this.dao = new AuthDataAccessObject();
//			this.connect =this.dao.openConnection();
//			
//			isAccess = this.convertToBoolean(dao.isAccess(connect,member));
//			
//			this.dao.closeConnection(connect);
//			this.dao = null;
//		}
//		
//		 return isAccess;
//	}

	
	private String getRefererPage() {
		String Ref = "";
		try {
			Ref = this.req.getHeader("referer").substring(this.req.getHeader("referer").lastIndexOf('/') + 1)
					.split("\\?")[0];

		} catch (Exception e) {
			Ref = this.req.getHeader("referer").substring(this.req.getHeader("referer").lastIndexOf('/') + 1);

		}
		return Ref;
	}

	private boolean convertToBoolean(int n) {
		return n > 0 ? true : false;
	}

	private ActionBean makeErrorSet(String page, String message, boolean isredirect) {
		ActionBean action = new ActionBean();
		try {
			action.setPage(page + "?message=" + URLEncoder.encode("error : " + message + ":1", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		action.setRedirect(isredirect);

		return action;

	}

	private boolean convertTOboolean(int value) {
		return (value>0)? true:false;

}
	

}