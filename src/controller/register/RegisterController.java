package controller.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.basket.BasketDao;
import dao.basket.BasketDaoImpl;
import dao.lecture.LectureDao;
import dao.lecture.LectureDaoImpl;
import dao.lecture_info.LectureInfoDao;
import dao.lecture_info.LectureInfoDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Lecture;
import model.Member;

@WebServlet(name = "RegisterController", urlPatterns = {"/register_init", "/register"})
public class RegisterController extends HttpServlet {
	

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

		if (action.equals("register_init")) {
				HttpSession session = req.getSession();
				LectureDao lDao = new LectureDaoImpl();		
				
				Member curMember = (Member)session.getAttribute("member");
				int lectureno = Integer.parseInt(req.getParameter("lectureno"));
				
				Lecture lecture = lDao.selectByLectureno(lectureno);
				
				String[] splitStart = lecture.getStartdate().split(" "); 
				String[] splitEnd = lecture.getEnddate().split(" "); 
				String[] RecsplitStart = lecture.getRec_startdate().split(" "); 
				String[] RecsplitEnd = lecture.getRec_enddate().split(" "); 
				
				if(curMember.getCertification().equals("Y")) {
					req.setAttribute("authYN", "Y");
				}
				
				req.setAttribute("curMember", curMember);
				req.setAttribute("lecture", lecture);
				req.setAttribute("splitStart", splitStart[0]);
				req.setAttribute("splitEnd", splitEnd[0]);
				req.setAttribute("recSplitStart", RecsplitStart[0]);
				req.setAttribute("recSplitEnd", RecsplitEnd[0]);
				
				
				
		} else if (action.equals("register")) {
			HttpSession session = req.getSession();
			Member now = (Member)session.getAttribute("member");
			
			int lectureNo = Integer.parseInt(req.getParameter("lectureno"));
			int userNo = now.getUserno();
			
			LectureDao lecDao = new LectureDaoImpl();
			BasketDao bDao = new BasketDaoImpl();
			LectureInfoDao lDao = new LectureInfoDaoImpl();
			
			lDao.insert(userNo, lectureNo);
			lecDao.updateReqCnt(lectureNo);
			bDao.delete(userNo, lectureNo);
			
			req.setAttribute("message", "강의 신청이 완료되었습니다.");
		}
		
		String dispatcherUrl = null;

		if (action.equals("register_init")) {
			dispatcherUrl = "JSP/register/registerForm.jsp";
		} else if (action.equals("register")) {
			dispatcherUrl = "JSP/register/registerResult.jsp";
		} 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}

}
