package services.masterfunction;


import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.ActionBean;
import beans.CenterBean;

public class MasterFunction {

	private HttpServletRequest req;
	public MasterFunction(HttpServletRequest req)
	{
		this.req = req;
	}
	
	public ActionBean backController(int jobkey/*0*/)
	{
		ActionBean action = null;
		switch (jobkey) {
		case -1:
			action=this.MovePage();
			break;
		case 0:
			break;
		case 1: 
			action=this.CenterCreate();
			break;
		case 2: 
			break;
		case 3: 
			break;
			
		}
		return action;
	}
	private ActionBean CenterCreate()
	{
		MfDataAccessObject dao= null;
		ActionBean action = new ActionBean();
		
		CenterBean center = new CenterBean();
		
		center.setCenterAddress(this.req.getParameter("CenterAddr"));
		center.setCenterCode(this.req.getParameter("CenterCode"));
		center.setCenterLocationcode(this.req.getParameter("CenterLocode"));
		center.setCenterMasterId(this.req.getParameter("CenterId"));
		center.setCenterMasterPw(this.req.getParameter("CenterPw"));
		center.setCenterName(this.req.getParameter("CenterName"));
		center.setCenterPhone(this.req.getParameter("CenterPhone"));
		
		Connection connection = dao.openConnection();
		dao.modifyTranStatus(connection, false);
		if(convertToBoolean(dao.insCenter(connection,center)))
		{
			action.setPage("masterCtl.jsp");
			action.setRedirect(true);
		}
		
		dao.setTransaction(true, connection);
		dao.modifyTranStatus(connection, true);
		dao.closeConnection(connection);
		
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
	
	private boolean convertToBoolean(int value) {
		return value>0 ? true : false;
	}
	/* Referer Page 추출 */
	private String getRefererPage() {
		//group-step1.jsp?message=%EC%9D%B4%EB%AF%B8+%EC%82%AC%EC%9A%A9%EC%A4%91%EC%9D%B8+%EA%B7%B8%EB%A3%B9%EB%AA%85%EC%9E%85%EB%8B%88%EB%8B%A4.
		return this.req.getHeader("referer").substring(this.req.getHeader("referer").lastIndexOf('/')+1);
	}
}