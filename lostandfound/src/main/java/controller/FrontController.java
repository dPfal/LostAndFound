package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ActionBean;
import services.auth.Auth;
import services.center.Center;
import services.generalfunction.GeneralFunction;
import services.masterfunction.MasterFunction;

@WebServlet({ "/CalPercentage", "/CenterCreate", "/CenterCall", "/CenterSelect", "/CallLostList", "/CallFoundList",
		"/LFProcessComplete",

		"/LFMatching", "/RegLost", "/RegFound",

		"/LoginMove", "/Login", "/Logout",

		"/MovePage" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("enter doGet");
		req.setCharacterEncoding("UTF-8");
		String jobcode = req.getRequestURI().substring(req.getContextPath().length() + 1);
		ActionBean action = null;
		int jobkey = jobcode.equals("MovePage") ? -1
				: jobcode.equals("CalPercentage") ? 0
						: jobcode.equals("CenterCall") ? 2
								: jobcode.equals("CenterSelect") ? 3
										: jobcode.equals("CallLostList") ? 4
												: jobcode.equals("CallFoundList") ? 5
														: jobcode.equals("LFProcessComplete") ? 6
																: jobcode.equals("LFMatching") ? 11 : -99;
		switch (jobkey) {
		case -1:
		case 0:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6: {
			action = new MasterFunction(req).backController(jobkey);
			break;
		}
		
		case 11:
			action = new Center(req).backController(jobkey);
			break;
		}
		if (action.isRedirect()) {
			res.sendRedirect(action.getPage());
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher(action.getPage());
			dispatcher.forward(req, res);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("enter doPost");
		req.setCharacterEncoding("UTF-8");
		String jobcode = req.getRequestURI().substring(req.getContextPath().length() + 1);
		ActionBean action = null;


		int jobkey = jobcode.equals("CenterCreate") ? 1 : jobcode.equals("RegLost") ? 7 : jobcode.equals("RegFound")? 8 : jobcode.equals("Login")? 101 : -99;


		switch (jobkey) {

		case 1: {
			action = new MasterFunction(req).backController(jobkey);
			break;
		}
		case 7: case 8: {
			System.out.println("enter reg");
			action = new GeneralFunction(req).backController(jobkey);
			System.out.println(action.getPage());
			System.out.println(action.isRedirect());
			break;
		}

		case 101:{
			System.out.println("enter case 101 (auth)");
			action = new Auth(req).backController(jobkey);
			break;
		}

		case 102: {
			action = new Auth(req).backController(jobkey);
			break;
		}

		}
		if (action.isRedirect()) {
			res.sendRedirect(action.getPage());
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher(action.getPage());
			dispatcher.forward(req, res);
		}
	}
}
