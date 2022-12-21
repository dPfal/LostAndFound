package services.center;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.ActionBean;
import beans.CenterBean;
import beans.FoundArticleBean;
import beans.LostArticleBean;
import beans.MasterBean;
import beans.MemberBean;
public class Center {
	private HttpServletRequest req;
	public Center(HttpServletRequest req){
		this.req = req;
	}
	public ActionBean backController(int jobkey)
	{
		ActionBean action = null;
		switch (jobkey) {
		case -1:
			action=this.MovePage();
			break;
		case 11:
			action = this.LFMatching();
			break;
		case 1: 
			break;
		case 2: 
			break;
		case 3: 
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}
		return action;
	}
	private ActionBean LFMatching() {
		CenterDataAccessObject dao= null;
		String page = "c-matching.jsp";
		boolean isRedirect = false;
		boolean tran=false;
		ActionBean action = new ActionBean();
		
		ArrayList<CenterBean> clist = new ArrayList<CenterBean>();
		CenterBean center= new CenterBean();
		center.setCenterCode(this.req.getParameter("centerCode")); 
		
		dao= new CenterDataAccessObject();
		Connection connection = dao.openConnection();
		
		clist.add(dao.lfMatching(connection,center,-1));
		clist.add(dao.lfMatching(connection,center,0));
		clist.add(dao.lfMatching(connection,center,1));
		clist.add(dao.lfMatching(connection,center,2));

		dao.closeConnection(connection);
		
		this.req.setAttribute("mathcingResult",makeMessage(clist));
		action.setPage(page);
		action.setRedirect(isRedirect);
		return action;
	}
	private String makeMessage(Object obj) {
		StringBuffer message = new StringBuffer();
		ArrayList<CenterBean> list = (ArrayList<CenterBean>)obj;
		
		int count=0;
		for(CenterBean c : list)
		{
			if(count==0) message.append("가능성 높음 : <br>");
			else if(count==1) message.append("가능성 낮음 : <br>");
			else if(count==2) message.append("가능성 중간 : <br>");
			else if(count==3) message.append("가능성 높음 : <br>");
			for(int i=0; i<c.getLAlist().size();i++)
			{
				LostArticleBean l = c.getLAlist().get(i);
				FoundArticleBean f = c.getFAlist().get(i);
				MemberBean m = c.getmList().get(i);
				String foundlostperson = (f.getFaPerson()==null)?"분실자명 없음":f.getFaPerson();
				message.append(i+1+".[lost]"+l.getLaColor()+l.getLaControlNumber()+l.getLaDate()+l.getLaLocation()+l.getLaMainCategoryCode()+l.getLaName()+l.getLaPlace()+l.getLaPostDate()+l.getLaPostId()+l.getLaStatus()+l.getLaSubCategoryCode()
							+"<br>"+"[found]"+f.getFaColor()+f.getFaControlNumber()+f.getFaDate()+f.getFaLocation()+f.getFaMainCategoryCode()+f.getFaName()+f.getFaPlace()+f.getFaPostDate()+f.getFaPostId()+f.getFaStatus()+f.getFaSubCategoryCode()
							+foundlostperson
							+"<br>"+"[lostperson]"+m.getMM_PHONE()+m.getMM_NAME());
				message.append("<br>");
			}
			count++;
		}
		return message.toString();
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
