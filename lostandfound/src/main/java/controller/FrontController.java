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
import services.masterfunction.MasterFunction;

@WebServlet({"/CenterCreate","/GroupDupCheck","/MemberJoin", 

	"/StoreDupCheck","/RegStore", "/RegEmp" , 
	
	"/LoginMove","/Login" ,"/Logout",
	
	"/MovePage"
})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontController() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String jobcode = req.getRequestURI().substring(req.getContextPath().length()+1);
		ActionBean action=null;
		int jobkey = 
				jobcode.equals("MovePage") ? -1 :
					
				 -99;
		switch (jobkey) {
		case 1: {
			action = new MasterFunction(req).backController(jobkey);
			break;
		}
		case 100:
			action = new Auth(req).backController(jobkey);
			break;
		}
		if(action.isRedirect())
		{
			res.sendRedirect(action.getPage());
		}else 
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher(action.getPage());
			dispatcher.forward(req, res);
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String jobcode = req.getRequestURI().substring(req.getContextPath().length()+1);
		ActionBean action=null;
		
		int jobkey = 
				jobcode.equals("CenterCreate") ? 1 :
			 -99;				
		
		switch (jobkey) {
		
		case 1:
		{
			action=new MasterFunction(req).backController(jobkey);
			break;
		}
		case 101: case 102:
		{
			action=new Auth(req).backController(jobkey);
			break;
		}

		}
		if(action.isRedirect())
		{
			res.sendRedirect(action.getPage());
		}else
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher(action.getPage());
			dispatcher.forward(req, res);
		}
	}
}
