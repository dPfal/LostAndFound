package services.registration;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.ActionBean;
import beans.MemberBean;

public class Registration {

	private HttpServletRequest req;

	public Registration(HttpServletRequest req) {
		this.req = req;
	}

	public ActionBean backController(int jobkey) {
		ActionBean action = null;
		switch (jobkey) {
		case 100:
			System.out.println("reg의 case100으로 들어왔어요.");
			action = this.memberJoin();
			break;

		}
		return action;
	}

	private ActionBean memberJoin() {
		ActionBean action = new ActionBean();
		MemberBean member = new MemberBean();
		RegDataAccessObject dao = new RegDataAccessObject();

		member.setMM_ID(this.req.getParameter("id"));
		member.setMM_PW(this.req.getParameter("password"));
		member.setMM_NAME(this.req.getParameter("userName"));
		member.setMM_EMAIL(this.req.getParameter("email1") + this.req.getParameter("email2"));
		member.setMM_PHONE("010"+this.req.getParameter("phone1") + this.req.getParameter("phone2"));
		member.setMM_ADDRESS(this.req.getParameter("address"));
		member.setMM_ADDRDETAIL(this.req.getParameter("addressDetail"));

		System.out.println("id:" + member.getMM_ID());
		System.out.println("password:" + member.getMM_PW());
		System.out.println("userName:" + member.getMM_NAME());
		System.out.println("MM_EMAIL:" + member.getMM_EMAIL());
		System.out.println("MM_PHONE:" + member.getMM_PHONE());
		System.out.println("MM_ADDRESS:" + member.getMM_ADDRESS());
		System.out.println("MM_ADDRDETAIL:" + member.getMM_ADDRDETAIL());

		Connection connection = dao.openConnection();
		dao.modifyTranStatus(connection, false);
		if (!this.convertToBoolean(dao.selDupIdCheck(connection,member))) {
			//아이디 중복확인 
			System.out.println("사용가능한 아이디임을 확인했습니다.");
			if(this.convertToBoolean(dao.insMember(connection,member))) {
				//회원가입
				System.out.println("회원정보 등록완료.");
			}
			else {
				//회원가입 실패 ... 
			}
		}
		else {
			//아이디 중복됨
			System.out.println("중복된 아이디 또는 센터 아이디임을 확인했습니다");
		}
		dao.setTransaction(true, connection);
		dao.modifyTranStatus(connection, true);
		dao.closeConnection(connection);
		action.setPage("g-loginStep0.jsp");
		action.setRedirect(true);
		return action;
	}

	private ActionBean MovePage() {
		ActionBean action = new ActionBean();
		String page = this.req.getParameter("target");

		action.setPage(page);
		action.setRedirect(true);

		return action;
	}

	private boolean convertToBoolean(int value) {
		return value > 0 ? true : false;
	}

	/* Referer Page 추출 */
	private String getRefererPage() {
		// group-step1.jsp?message=%EC%9D%B4%EB%AF%B8+%EC%82%AC%EC%9A%A9%EC%A4%91%EC%9D%B8+%EA%B7%B8%EB%A3%B9%EB%AA%85%EC%9E%85%EB%8B%88%EB%8B%A4.
		return this.req.getHeader("referer").substring(this.req.getHeader("referer").lastIndexOf('/') + 1);
	}
}