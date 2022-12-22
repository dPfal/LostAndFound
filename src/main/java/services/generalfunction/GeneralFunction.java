package services.generalfunction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import beans.ActionBean;
import beans.FoundArticleBean;
import beans.LostArticleBean;
import beans.MemberBean;

public class GeneralFunction {
	private HttpServletRequest req;

	public GeneralFunction(HttpServletRequest req) {
		this.req = req;
	}

	public ActionBean backController(int jobkey) {
		System.out.println("enter backController");
		ActionBean action = null;
		switch (jobkey) {
		case 7:
			System.out.println("enter backController.case7");
			action = this.RegLost();
			break;
		case 8:
			System.out.println("enter backController case 8");
			action = this.RegFound();
			break;
		}
		return action;
	}

	private ActionBean RegFound() {
		System.out.println("enter RegLost");
		ActionBean action = new ActionBean();
		GeneralDataAccessObject dao = null;
		String page = "g-foundArticle.jsp";
		FoundArticleBean fa = new FoundArticleBean();

		dao = new GeneralDataAccessObject();

		fa.setFaCenterCode(this.req.getParameter("center"));

		fa.setFaLocation(this.req.getParameter("location"));
//		System.out.println(this.req.getParameter("location"));

		fa.setFaPlace(this.req.getParameter("place"));
//		System.out.println(this.req.getParameter("place"));

		fa.setFaPlaceDetail(this.req.getParameter("placeDetail"));
//		System.out.println("placeDetail:" + this.req.getParameter("placeDetail"));

		fa.setFaDate(this.req.getParameter("foundDate").replace("-", ""));
		System.out.println(fa.getFaDate());

		fa.setFaTitle(this.req.getParameter("title"));
//		System.out.println("title:" + this.req.getParameter("title"));
//
		fa.setFaMainCategoryCode(this.req.getParameter("MainCategories"));
//		System.out.println("MainCategories:" + this.req.getParameter("MainCategories"));

		fa.setFaSubCategoryCode(this.req.getParameter("SubCategories"));
//		System.out.println("SubCategories:" + this.req.getParameter("SubCategories"));

		fa.setFaColor(this.req.getParameter("color"));
//		System.out.println("color:" + this.req.getParameter("color"));

		fa.setFaName(this.req.getParameter("articleName"));
//		System.out.println("articleName:" + this.req.getParameter("articleName"));

		fa.setFaDetail(this.req.getParameter("detail"));
//		System.out.println("detail:" + this.req.getParameter("detail"));
//		아이디 가져와야함
		fa.setFaPerson(this.req.getParameter("loserName"));
//		System.out.println("loserName:" + this.req.getParameter("loserName"));
		fa.setFaPostId("DPFLA");

// 		img 파일 가져오는 작업 생략
		Connection connection = dao.openConnection();
		dao.modifyTranStatus(connection, false); // 오토커밋 해제
		if (this.convertToBoolean(dao.insRegFound(connection, fa))) {
			System.out.println("삽입완료");
			action.setRedirect(true);
			action.setPage(page);
		}
		dao.setTransaction(true, connection); // commit
		dao.modifyTranStatus(connection, true); // 오토커밋설정
		dao.closeConnection(connection);
		return action;
	}

	private ActionBean RegLost() {
		System.out.println("enter RegLost");
		ActionBean action = new ActionBean();
		GeneralDataAccessObject dao = null;
		String page = "g-lostArticle.jsp";
		LostArticleBean la = new LostArticleBean();

		dao = new GeneralDataAccessObject();

		la.setLaCenterCode(this.req.getParameter("center"));

		la.setLaLocation(this.req.getParameter("location"));
		System.out.println(this.req.getParameter("location"));

		la.setLaPlace(this.req.getParameter("place"));
		System.out.println(this.req.getParameter("place"));

		la.setLaPlaceDetail(this.req.getParameter("placeDetail"));
		System.out.println("placeDetail:" + this.req.getParameter("placeDetail"));
		System.out.println(this.req.getParameter("date"));
		la.setLaDate(this.req.getParameter("date").replace("-", ""));
		System.out.println(la.getLaDate());
//		System.out.println("date:"+this.req.getParameter("date"));

		la.setLaTitle(this.req.getParameter("title"));
		System.out.println("title:" + this.req.getParameter("title"));

		la.setLaMainCategoryCode(this.req.getParameter("MainCategories"));
		System.out.println("MainCategories:" + this.req.getParameter("MainCategories"));

		la.setLaSubCategoryCode(this.req.getParameter("SubCategories"));
		System.out.println("SubCategories:" + this.req.getParameter("SubCategories"));

		la.setLaColor(this.req.getParameter("color"));
		System.out.println("color:" + this.req.getParameter("color"));

		la.setLaName(this.req.getParameter("articleName"));
		System.out.println("articleName:" + this.req.getParameter("articleName"));

		la.setLaDetail(this.req.getParameter("detail"));
		System.out.println("detail:" + this.req.getParameter("detail"));
//		아이디 가져와야함
		la.setLaPostId("DPFLA");

// 		img 파일 가져오는 작업 생략
		Connection connection = dao.openConnection();
		dao.modifyTranStatus(connection, false); // 오토커밋 해제
		if (this.convertToBoolean(dao.insRegLost(connection, la))) {
			System.out.println("삽입완료");
			action.setRedirect(true);
			action.setPage(page);
		}
		dao.setTransaction(true, connection); // commit
		dao.modifyTranStatus(connection, true); // 오토커밋설정
		dao.closeConnection(connection);
		this.req.setAttribute("message", "regComplete");
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