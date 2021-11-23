package controller.mypage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interest.InterestDao;
import dao.interest.InterestDaoImpl;
import dao.lecture_info.LectureInfoDao;
import dao.lecture_info.LectureInfoDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Interest;
import model.Lecture_Info2;
import model.Member;
import page.PageGroupResult;
import page.PageManager;
import page.PageRowResult;

@WebServlet(name = "LectureInfoController", urlPatterns= {"/lectureinfo_List","/lectureInfoSearch"})
public class LectureInfoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		process(req, resp);
	}
	
	void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		int lastindex = uri.lastIndexOf("/");
		String action = uri.substring(lastindex+1);
		
		List<Lecture_Info2> lectureInfoList = null;
		int cnt = 0;
		int requestpage = 1;
		
		if(req.getParameter("reqPage")!=null) {
			requestpage = Integer.parseInt(req.getParameter("reqPage"));
			
		}
		
		
		
		if(action.equals("lectureinfo_List")) {
			LectureInfoDao lectureInfoDao = new LectureInfoDaoImpl();
			///**세션에서 내 유저넘버를 가져와서 넣기!
			//cnt = lectureInfoDao.selectByUserno(3).size();
			//lectureInfoList = lectureInfoDao.selectByUserno2(3, requestpage);
			
			
			
		} else if(action.equals("lectureInfoSearch")) {
			String startdate = req.getParameter("startdate");
			String enddate =  req.getParameter("enddate");
			String lectureName  =  req.getParameter("lectureName").toUpperCase();
			
			
			LectureInfoDao lectureInfoDao = new LectureInfoDaoImpl();
			
			///**세션에서 내 유저넘버를 가져와서 넣기! 3대신
			if(startdate.isEmpty() &&enddate.isEmpty()) {
				//lectureInfoList = lectureInfoDao.selectByLectureName(3, lectureName);
				
				
			} else if(startdate.isEmpty() && !enddate.isEmpty()) {
				lectureInfoList = lectureInfoDao.selectByEnddateLectureName(3, enddate, lectureName);
				
			} else if(!startdate.isEmpty() && enddate.isEmpty()) {
				lectureInfoList = lectureInfoDao.selectByStartdateLectureName(3, startdate, lectureName);
				
			} else {
				lectureInfoList = lectureInfoDao.selectByStartdateEnddateLectureName(3, startdate, enddate, lectureName);
			
			}			
			req.setAttribute("startdate", startdate);
			req.setAttribute("enddate", enddate);
			req.setAttribute("lectureName", lectureName);
			
		}
		
		MemberDao memberDao = new MemberDaoImpl();
		
		List<Member> teacherNameList = new ArrayList<>();
		Member member = null;
		
		
		for (Lecture_Info2 lecture_Info2 : lectureInfoList) {
			int teacherno = lecture_Info2.getLecture().getUserno();
			member = memberDao.selectByUserno(teacherno);
			
			int i = 0;
			
			for (Member member2 : teacherNameList) {
				if(member2.getUserno()!=(member.getUserno())) {
					i++;
				}
			}
			
			if(teacherNameList.size()==i) {
				teacherNameList.add(member);
			}
			
		}
		
		//-------------------------------------------------
		InterestDao interestDao = new InterestDaoImpl();
		List<Interest> interestList = interestDao.selectAll();
		
		
		req.setAttribute("lectureInfoList", lectureInfoList);
		req.setAttribute("interestList", interestList);
		req.setAttribute("teacherNameList", teacherNameList);
		
		System.out.println("cnt" + cnt);
		PageManager pm = new PageManager(requestpage);
		PageGroupResult pgr = pm.getPageGroupResult(cnt);

		System.out.println(pgr.getGroupStartNumber());
		System.out.println(pgr.getGroupEndNumber());
		req.setAttribute("pageGroupResult", pgr);
		
		//---------------------------------------------경로이동
		String dispatcherURL = null;
		
		
		if(action.equals("lectureinfo_List")) {
			dispatcherURL = "/JSP/mypage/lectureInfoList.jsp";
			
		} else if(action.equals("lectureInfoSearch")) {
			dispatcherURL = "/JSP/mypage/lectureInfoList.jsp";
			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherURL);
		dispatcher.forward(req, resp);
	}
	
	
}
