package controller.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.lecture_info.LectureInfoDao;
import dao.lecture_info.LectureInfoDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Member;
import util.MailSend;

@WebServlet(name = "AuthController", urlPatterns= {"/auth_init","/auth_check","/join_auth"})
public class AuthController extends HttpServlet{
	
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
		
		HttpSession session = req.getSession();

		if (action.equals("auth_init")) {
			
				Member curMember = (Member)session.getAttribute("member");
				
				String email = curMember.getEmail();
				String code = MailSend.gmailAuthSend(email);
				
				String id = curMember.getId();
				
				LectureInfoDao lDao = new LectureInfoDaoImpl();
				lDao.codeUpdate(id, code);
				
		} else if (action.equals("auth_check")) {
			Member curMember = (Member)session.getAttribute("member");
			
			String id = curMember.getId();
			String authcode = req.getParameter("authcode");
			
			LectureInfoDao lDao = new LectureInfoDaoImpl();
			String result = lDao.codeSearch(id, authcode);
			
			if(result.equals("Y")) {
				lDao.updateAuthYN(id);
				req.setAttribute("message", "인증이 완료되었습니다.");
			} else {
				req.setAttribute("error", "인증코드가 일치하지 않습니다.");
			}
		} else if(action.equals("join_auth")) {
			
			String email = req.getParameter("email");
			System.out.println(email);
			String code = MailSend.gmailAuthSend(email);
			
			MemberDao mDao = new MemberDaoImpl();
			mDao.insertCode(email, code);
			
			//String id = curMember.getId();
			
			//LectureInfoDao lDao = new LectureInfoDaoImpl();
			//lDao.codeUpdate(id, code);
		}
			
		String dispatcherUrl = null;

		if (action.equals("auth_init")) {
			dispatcherUrl = "JSP/register/myAuth.jsp";
		} else if (action.equals("join_auth")) {
			dispatcherUrl = "JSP/register/myAuth.jsp";
		} 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}

}
