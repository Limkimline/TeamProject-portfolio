package controller.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import util.MailSend;
import util.SHA256;

@WebServlet(name = "FindController", urlPatterns = {"/valid_account","/find_init","/auth_email","/chg_pwd","/find_ID"})
public class FindController extends HttpServlet {
	
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

		if (action.equals("find_init")) {
				
		} else if (action.equals("valid_account")) {
			String id = req.getParameter("id");
			String email = req.getParameter("email");
			
			MemberDao mDao = new MemberDaoImpl();
			String result = mDao.selectByIDEmail(id, email);
			
			if(result.equals("Y")) {
				String hash = new SHA256().getSHA256(email);
				mDao.hashUpdate(id, hash);
				
				MailSend.gmailSend(email, hash);
				req.setAttribute("email_message", "작성하신 이메일로 인증메일이 전송되었습니다.");
			} else {
				System.out.println("인증 실패");
				req.setAttribute("email_message", "유효하지 않는 계정입니다. 다시 입력해주세요");
			}
				
		} else if (action.equals("auth_email")) {
			String code = req.getParameter("code");
			
			System.out.println(code);
			
			MemberDao mDao = new MemberDaoImpl();
			String result = mDao.hashSearch(code);
			
			if(result.equals("Y")) {
				//System.out.println("인증가능");
				req.setAttribute("status", "yes");
				req.setAttribute("code", code);
				//mDao.hashDelete(code);
			} else {
				//System.out.println("인증불가");
				req.setAttribute("status", "no");
			}
			
				
		} else if (action.equals("chg_pwd")) {
			String pwd = req.getParameter("password");
			String pwdConfirm = req.getParameter("passwordConfirm");
			String code = req.getParameter("code");
			
			//System.out.println(pwd + "  " + pwdConfirm + "  " + code);
			
			if(pwd.equals(pwdConfirm)) {
				MemberDao mDao = new MemberDaoImpl();
				mDao.updatePwd(pwd, code);
				mDao.hashDelete(code);
				req.setAttribute("message", "정상적으로 변경되었습니다. 재 로그인 바랍니다.");
				
				String dispatcherUrl = null;
				dispatcherUrl = "login_init";
				RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
				dispatcher.forward(req, resp);
			} else {
				req.setAttribute("error", "비밀번호가 일치하지 않습니다.");
				
				String dispatcherUrl = null;
				dispatcherUrl = "auth_email";
				RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
				dispatcher.forward(req, resp);
			}
		} else if (action.equals("find_ID")) {
			String userName = req.getParameter("userName");
			String email = req.getParameter("email");
						
			MemberDao mDao = new MemberDaoImpl();
			List<String> IDresult = mDao.selectIdList(userName, email);
			
			
			req.setAttribute("IDresult", IDresult);
			req.setAttribute("size", IDresult.size());
//			String id = mDao.selectByNameEmail(userName, email);
//			req.setAttribute("id_message", "찾으시는 계정의 아이디는 "+ id + "입니다.");
		} 
		
		String dispatcherUrl = null;

		if (action.equals("find_init")) {
			dispatcherUrl = "JSP/login/findForm.jsp";
		} else if (action.equals("valid_account")) {
			dispatcherUrl = "find_init";
		} else if (action.equals("auth_email")) {
			dispatcherUrl = "JSP/login/emailCheckAction.jsp";
		} else if (action.equals("find_ID")) {
			dispatcherUrl = "JSP/login/IDFindResult.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
