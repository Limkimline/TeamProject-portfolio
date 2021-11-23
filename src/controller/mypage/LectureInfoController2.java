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
import javax.servlet.http.HttpSession;

import dao.interest.InterestDao;
import dao.interest.InterestDaoImpl;
import dao.lecture_info.LectureInfoDao;
import dao.lecture_info.LectureInfoDaoImpl;
import dao.lecture_info.Sql;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Interest;
import model.Lecture_Info2;
import model.Member;
import page.PageGroupResult;
import page.PageManager;
import page.PageRowResult;

@WebServlet(name = "LectureInfoController2", urlPatterns= {"/lectureInfoSearch2","/myLecture_List","/deleteLectureInfo"})
public class LectureInfoController2 extends HttpServlet {

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
		
		

		HttpSession session = req.getSession();

		
		int userno = 0;
		if(session.getAttribute("member") != null) {

			 Member member = (Member) session.getAttribute("member");
			 userno = member.getUserno();
		}
		
		
		
		
		String uri = req.getRequestURI();
		int lastindex = uri.lastIndexOf("/");
		String action = uri.substring(lastindex+1);
		
		List<Lecture_Info2> lectureInfoList = null;
		int cnt = 0;
		int requestpage = 1;
		
		if(req.getParameter("reqPage")!=null) {
			requestpage = Integer.parseInt(req.getParameter("reqPage"));
			
		}
		
		String startdate = req.getParameter("startdate");
		//System.out.println("startdate : " +startdate);
		
		String enddate =  req.getParameter("enddate");
		//System.out.println("enddate "+enddate);
		
		String lectureName = "";
		if(req.getParameter("lectureName")!=null) {
			lectureName  =  req.getParameter("lectureName").toUpperCase();
			
		}
		//System.out.println("lectureName"+lectureName);
		
		if(action.equals("lectureInfoSearch2")) {
			
			
			LectureInfoDao lectureInfoDao = new LectureInfoDaoImpl();
			lectureInfoDao.updateProgress();
			
			if(startdate==null && enddate==null) {
				cnt = lectureInfoDao.selectByLectureName(userno, lectureName).size();
				lectureInfoList = lectureInfoDao.selectByLectureName2(userno, lectureName, requestpage);
				
				
			}else if(startdate.isEmpty() &&enddate.isEmpty()) {
				cnt = lectureInfoDao.selectByLectureName(userno, lectureName).size();
				lectureInfoList = lectureInfoDao.selectByLectureName2(userno, lectureName, requestpage);
				
				
			}else if(startdate.isEmpty() && !enddate.isEmpty()) {
				cnt = lectureInfoDao.selectByEnddateLectureName(userno, enddate, lectureName).size();
				lectureInfoList = lectureInfoDao.selectByEnddateLectureName2(userno, enddate, lectureName, requestpage);
				
			} else if(!startdate.isEmpty() && enddate.isEmpty()) {
				cnt = lectureInfoDao.selectByStartdateLectureName(userno, startdate, lectureName).size();
				lectureInfoList = lectureInfoDao.selectByStartdateLectureName2(userno, startdate, lectureName, requestpage);
				
			} else {
				cnt = lectureInfoDao.selectByStartdateEnddateLectureName(userno, startdate, enddate, lectureName).size();
				lectureInfoList = lectureInfoDao.selectByStartdateEnddateLectureName2(userno, startdate, enddate, lectureName, requestpage);
			
			}		
			
			List<Member> teacherNameList = new ArrayList<>();
			Member member = null;
			
			MemberDao memberDao = new MemberDaoImpl();
			
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
			
			req.setAttribute("teacherNameList", teacherNameList);
			
			
		} else if(action.equals("myLecture_List")){
			
			LectureInfoDao lectureInfoDao = new LectureInfoDaoImpl();
			lectureInfoDao.updateProgress();
			
			if(startdate==null && enddate==null) {
				cnt = lectureInfoDao.selectMyLectureByLectureName(userno, lectureName).size();
				lectureInfoList = lectureInfoDao.selectMyLectureByLectureName2(userno, lectureName, requestpage);
				
			}else if(startdate.isEmpty() &&enddate.isEmpty()) {
				cnt = lectureInfoDao.selectMyLectureByLectureName(userno, lectureName).size();
				lectureInfoList = lectureInfoDao.selectMyLectureByLectureName2(userno, lectureName, requestpage);
				
			}else if(startdate.isEmpty() && !enddate.isEmpty()) {
				cnt = lectureInfoDao.selectMyLectureByLectureNameEnddate(userno, lectureName, enddate).size();
				lectureInfoList = lectureInfoDao.selectMyLectureByLectureNameEnddate2(userno, lectureName, enddate, requestpage);
				
			} else if(!startdate.isEmpty() && enddate.isEmpty()) {
				cnt = lectureInfoDao.selectMyLectureByLectureNameStartdate(userno, lectureName, startdate).size();
				lectureInfoList = lectureInfoDao.selectMyLectureByLectureNameStartdate2(userno, lectureName, startdate, requestpage);
				
			} else {
				cnt = lectureInfoDao.selectMyLectureByLectureNameStartdateEnddate(userno, lectureName, startdate, enddate).size();
				lectureInfoList = lectureInfoDao.selectMyLectureByLectureNameStartdateEnddate2(userno, lectureName, startdate, enddate, requestpage);
				
			}
			for (Lecture_Info2 lecture_Info2 : lectureInfoList) {
				//System.out.println("lectureno "+lecture_Info2.getLecture().getLectureno());
			}
			
			
		} else if(action.equals("deleteLectureInfo")){
			int getinfono = Integer.parseInt(req.getParameter("deleteInfono"));
			LectureInfoDao lectureInfoDao = new LectureInfoDaoImpl();
			lectureInfoDao.delete(getinfono);
			
		}
		
		//------------------------------------------------
		
		req.setAttribute("startdate", startdate);
		req.setAttribute("enddate", enddate);
		req.setAttribute("lectureName", lectureName);
		
		
		
		InterestDao interestDao = new InterestDaoImpl();
		List<Interest> interestList = interestDao.selectAll();
		
		
		req.setAttribute("lectureInfoList", lectureInfoList);
		req.setAttribute("interestList", interestList);
		
		//System.out.println("cnt" + cnt);
		PageManager pm = new PageManager(requestpage);
		PageGroupResult pgr = pm.getPageGroupResult(cnt);

		req.setAttribute("pageGroupResult", pgr);
		
		//---------------------------------------------경로이동
		String dispatcherURL = null;
		
		
		if(action.equals("lectureInfoSearch2")) {
			dispatcherURL = "/JSP/mypage/lectureInfoList2.jsp";
			
		}else if(action.equals("myLecture_List")){
			dispatcherURL = "/JSP/mypage/myLectureList.jsp";
			
		}else if(action.equals("deleteLectureInfo")){
			dispatcherURL = "/lectureInfoSearch2";
			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherURL);
		dispatcher.forward(req, resp);
	}
	
	
}
