package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Member;

@WebServlet(name = "LoginController", urlPatterns = {"/login_init", "/login","/user_logout"})
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);

		if (action.equals("login_init")) {	
				
		} else if (action.equals("login")) {	
			String id = req.getParameter("id");
			String pwd = req.getParameter("password");
			
			MemberDao mDao = new MemberDaoImpl();
			Member result = mDao.selectUser(id, pwd);
			
			if(result != null) {
				HttpSession session = req.getSession();
				session.setAttribute("member", result); 
				req.setAttribute("message", "로그인 되었습니다.");
				System.out.println("세션 설정 완료");
			} else {
				req.setAttribute("message", "찾을 수 없는 계정입니다.");
			}
			
			/*if (result != null) {
				HttpSession session = req.getSession();
				session.setAttribute("member", result.getId());
				
				String dispatcherUrl = "board_main";
				
				RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
				dispatcher.forward(req, resp);
				
			} else {
				req.setAttribute("message", "찾을 수 없는 계정입니다.");
				
				String dispatcherUrl = "login_main";
				
				RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
				dispatcher.forward(req, resp);
			}*/
			
		} else if (action.equals("user_logout")) {	
			HttpSession session = req.getSession();
			session.removeAttribute("member");
			
			if(session.getAttribute("member") == null) {
				req.setAttribute("message", "정상 로그아웃 되었습니다");
			}
		} 

		String dispatcherUrl = null;

		if (action.equals("login_init")) {
			dispatcherUrl = "JSP/login/loginForm.jsp";
		} else if (action.equals("login")) {
			HttpSession session = req.getSession();

			if (session.getAttribute("member") != null) {
				dispatcherUrl = "mainPage";
			} else {
				dispatcherUrl = "login_init";
			}
			
		} else if (action.equals("user_logout")) {
			dispatcherUrl = "JSP/login/loginResult.jsp";
		} 

		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}

}
