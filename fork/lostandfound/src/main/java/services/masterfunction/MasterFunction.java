package services.masterfunction;


import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.ActionBean;
import beans.CenterBean;
import beans.FoundArticleBean;
import beans.LostArticleBean;
import beans.MasterBean;

public class MasterFunction {

	private HttpServletRequest req;
	public MasterFunction(HttpServletRequest req)
	{
		this.req = req;
	}
	
	public ActionBean backController(int jobkey)
	{
		ActionBean action = null;
		switch (jobkey) {
		case -1:
			action=this.MovePage();
			break;
		case 0:
			action=this.CalPercentage();
			break;
		case 1: 
			action=this.CenterCreate();
			break;
		case 2: 
			action=this.CenterCall();
			break;
		case 3: 
			action=this.CenterSelect();
			break;
		case 4:
			action=this.CallLostList();
			break;
		case 5:
			action=this.CallFoundList();
			break;
		case 6:
			action=this.LFProcessingComplete();
			break;
		}
		return action;
	}
	private ActionBean CalPercentage() {
		MfDataAccessObject dao= null;
		String page = "m-centerPerformance.jsp";
		boolean isRedirect = false;
		ActionBean action = new ActionBean();
		MasterBean master = new MasterBean();
		
		dao = new MfDataAccessObject();
		Connection connection = dao.openConnection();
		
		master=dao.calculateAllPerformance(connection,master);
		master=dao.calculateCenterByPerformance(connection,master);
		
		dao.closeConnection(connection);
		
		this.req.setAttribute("CalPerformance",makeMessage(master));
		
		action.setPage(page);
		action.setRedirect(isRedirect);
		return action;
	}
	private ActionBean LFProcessingComplete() {
		MfDataAccessObject dao= null;
		String page = "m-centerManagement.jsp";
		boolean isRedirect = false;
		ActionBean action = new ActionBean();
		CenterBean center= new CenterBean();
		
		if(this.req.getParameter("Ctnum").split(":")[0].equals("L"))
		{
			ArrayList<LostArticleBean> list = new ArrayList<LostArticleBean>();
			LostArticleBean lost = new LostArticleBean();
			lost.setLaControlNumber(
					this.req.getParameter("Ctnum").split(":")[1]);
			list.add(lost);
			center.setLAlist(list);
		}
		else
		{
			ArrayList<FoundArticleBean> list = new ArrayList<FoundArticleBean>();
			FoundArticleBean found= new FoundArticleBean();
			found.setFaControlNumber(
					this.req.getParameter("Ctnum").split(":")[1]);
			list.add(found);
			center.setFAlist(list);
		}
		
		dao = new MfDataAccessObject();
		Connection connection = dao.openConnection();
		dao.modifyTranStatus(connection, isRedirect);
		
		if(convertToBoolean(dao.completeProcessing(connection,center)))
		{
			page="m-centerManagement.jsp";
			isRedirect = true;
		}
		else
			
		dao.setTransaction(true, connection);
		dao.modifyTranStatus(connection, true);
		dao.closeConnection(connection);
		
		action.setPage(page);
		action.setRedirect(isRedirect);
		
		return action;
	}
	private ActionBean CallLostList() {
		MfDataAccessObject dao= null;
		String page = "m-centerManagement.jsp";
		boolean isRedirect = false;
		ActionBean action = new ActionBean();
		CenterBean center= new CenterBean();
		
		center.setCenterCode(this.req.getParameter("selectCode"));
		
		Connection connection = dao.openConnection();
		ArrayList<LostArticleBean> Lalist = null;
		Lalist=dao.getCenterLostList(connection,center);
		if(Lalist != null)
		{
			center.setLAlist(Lalist);
			this.req.setAttribute("laList",this.makeHTMLSelectBox(center));
			this.req.setAttribute("center",center);
		}
		else
		{
			//센터에 보관중인 분실물 목록이 없을 때
		}
		
		action.setPage(page);
		action.setRedirect(isRedirect);
		return action;
	}
	private ActionBean CallFoundList() {
		MfDataAccessObject dao= null;
		String page = "m-centerManagement.jsp";
		boolean isRedirect = false;
		ActionBean action = new ActionBean();
		CenterBean center= new CenterBean();
		
		center.setCenterCode(this.req.getParameter("selectCode"));
		
		Connection connection = dao.openConnection();
		ArrayList<FoundArticleBean> Falist = null;
		Falist=dao.getCenterFoundList(connection,center);
		
		if(Falist != null)
		{
			center.setFAlist(Falist);
			this.req.setAttribute("faList",this.makeHTMLSelectBox(center));
			this.req.setAttribute("center",center);
		}
		else
		{
			//센터에 보관중인 분실물 목록이 없을 때
		}
		
		action.setPage(page);
		action.setRedirect(isRedirect);
		return action;
	}
	private ActionBean CenterSelect()
	{
		MfDataAccessObject dao= null;
		ActionBean action = new ActionBean();
		CenterBean center= new CenterBean();
		
		
		center.setCenterName(this.req.getParameter("selectName"));
		center.setCenterCode(this.req.getParameter("selectCode"));
		
		Connection connection = dao.openConnection();
		center=dao.getCenterInfo(connection,center);
		
		if(center != null)
		{
			action.setPage("m-centerManagement.jsp");
			action.setRedirect(false);
			this.req.setAttribute("message",makeMessage(center));
			this.req.setAttribute("centerCode", center.getCenterCode());
			
		}
		dao.closeConnection(connection);
		return action;
	}
	private ActionBean CenterCall()
	{
		MfDataAccessObject dao= null;
		ActionBean action = new ActionBean();
		MasterBean master = null;
		
		Connection connection = dao.openConnection();
		master=dao.getCenterList(connection,master);
		if(master != null)
		{
			action.setPage("m-centerManagement.jsp");
			this.req.setAttribute("centerName", makeHTMLSelectBox(master));
			
			action.setRedirect(false);
		}
		dao.closeConnection(connection);
		return action;
	}
	private String makeHTMLSelectBox(CenterBean obj) {
		StringBuffer select = new StringBuffer();
		
		if(obj.getFAlist() != null)
		{
			select.append("<select name=\"faList\" onchange=\"chageFaSelect(${center})\" class=\"gtxt faList\">");
			
			select.append("<option value=\"\">"+"등록날짜 : 습득날짜 "+"</option>");
			for(FoundArticleBean f : obj.getFAlist())
			{
				select.append("<option value=\""+f.getFaPostDate()+":"+f.getFaDate()+"\">"
						+f.getFaName()
						+"</option>");
			}
			select.append("</select>");
		}
		else if(obj.getLAlist() != null)
		{
			select.append("<select name=\"laList\" onchange=\"chageLaSelect(${center})\" class=\"gtxt laList\">");
			
			select.append("<option value=\"\">"+"등록날짜 : 분실날짜 "+"</option>");
			for(LostArticleBean l : obj.getLAlist())
			{
				select.append("<option value=\""+l.getLaPostDate()+":"+l.getLaDate()+"\">"
						+l.getLaName()
						+"</option>");
			}
			select.append("</select>");
		}
		else
		{
			
		}
		return select.toString();
	}
	private String makeMessage(MasterBean obj) {
		StringBuffer message = new StringBuffer();
		MasterBean master = obj;
		
		message.append("All Performance: \\n");
		message.append("[LOST Processed Number] - " + master.getNprocessedLa() +"\\n");
		message.append("[FOUND Processed Number] - " + master.getNprocessedFa()+"\\n");
		message.append("[LOST Performance] - " + master.getPerformanceLa()+"\\n");
		message.append("[FOUND Performance] - " + master.getPerformanceFa()+"\\n");
		message.append("Center Performance: \\n");
		for(CenterBean c : master.getCenterList())
		{
			message.append("[Center Name] - "+c.getCenterName()+"\\n");
			message.append("[LOST Processed Number] - " + c.getNprocessedLa() +"\\n");
			message.append("[FOUND Processed Number] - " + c.getNprocessedFa()+"\\n");
			message.append("[LOST Performance] - " + c.getPerformanceLa()+"\\n");
			message.append("[FOUND Performance] - " + c.getPerformanceFa()+"\\n\\n");
		}
		return message.toString();
	}
	private String makeMessage(CenterBean obj) {
		StringBuffer message = new StringBuffer();
		CenterBean center = obj;
		
		message.append("Center Infomation:");
		message.append("[센터코드] - " + center.getCenterCode() +"\\n");
		message.append("[센터이름] - " + center.getCenterName()+"\\n");
		message.append("[센터주소] - " + center.getCenterAddress()+"\\n");
		message.append("[센터번호] - " + center.getCenterPhone()+"\\n");
		message.append("[센터지역코드] - " + center.getCenterLocationcode()+":5");
		
		return message.toString();
	}
	private String makeHTMLHiddenBox(String name,String value) {
		StringBuffer hidden = new StringBuffer();
		
		hidden.append("<input type=hidden name=\""+name+"\""+
										"value=\""+value+"\">"+"</hidden>");
		
		return hidden.toString();
	}
	private String makeHTMLSelectBox(MasterBean obj) {
		StringBuffer select = new StringBuffer();
		select.append("<select name=\"centerInfo\" class=\"gtxt centerInfo\">");
		
		select.append("<option value=\"\">"+"센터를 선택해주세요. "+"</option>");
		for(CenterBean c : obj.getCenterList())
		{
			select.append("<option value=\""+c.getCenterName()+"\">"
					+c.getCenterCode()
					+"</option>");
		}
		select.append("</select>");
		
		return select.toString();
	}
	private ActionBean CenterCreate()
	{
		MfDataAccessObject dao= null;
		ActionBean action = new ActionBean();
		
		CenterBean center = new CenterBean();
		
		center.setCenterAddress(this.req.getParameter("CenterAddr"));
		center.setCenterCode(this.req.getParameter("CenterCode"));
		center.setCenterLocationcode(this.req.getParameter("CenterLocode"));
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