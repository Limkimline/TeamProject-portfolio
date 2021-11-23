package controller.main;

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
import dao.lecture.LectureDao;
import dao.lecture.LectureDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Interest;
import model.Lecture;
import model.Member;
import page.PageDao;
import page.PageDaoImlp;
import page.PageGroupResult;
import page.PageManager;
import page.PageSql;

@WebServlet(name="MainController", urlPatterns= {"/mainPage","/logout","/lecture_name_search","/lecture_interest_search","/paging","/lecture_clickcountUp"})
public class MainController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		int lastIndex= uri.lastIndexOf("/");
		System.out.println(lastIndex);
		
		String action= uri.substring(lastIndex+1);
		System.out.println(action);
		

		if(action.equals("mainPage")) {
			HttpSession session = req.getSession();
			
			InterestDao intersetDao= new InterestDaoImpl();
			List<Interest> interestList = intersetDao.selectAll();
			List<List> ListInList= new ArrayList<>();
			req.setAttribute("interestList", interestList);
			for (Interest interest : interestList) {
				LectureDao lectureDao = new LectureDaoImpl();
				List<Lecture> Lectureint_no =lectureDao.selectByInt_no2(interest.getInt_no());
				ListInList.add(Lectureint_no);
			}
			req.setAttribute("ListInList", ListInList);
			
			if(session.getAttribute("member")!=null) {
				
				Member user= (Member)session.getAttribute("member");
				LectureDao lectureDao = new LectureDaoImpl();
				List<Lecture> lectureListUserno=lectureDao.selectByUserno(user.getUserno());
				req.setAttribute("lectureListUserno", lectureListUserno);
				MemberDao memberDao= new MemberDaoImpl();
				Member member=memberDao.selectByUserno(user.getUserno());
				req.setAttribute("membername",member.getName());
				int int_no= member.getInt_no();
				int int_no2= member.getInt_no2();
				List<Lecture> lectureListInterest= lectureDao.selectByUserInterest(int_no, int_no2);
				req.setAttribute("lectureListInterest",  lectureListInterest);
			}
			
			LectureDao lectureDao = new LectureDaoImpl();
			List<Lecture> lectureListPopularity= lectureDao.selectByPopularity();
			req.setAttribute("lectureListPopularity", lectureListPopularity);
			
			
			
		}else if(action.equals("logout")) {
			HttpSession session = req.getSession();
			session.removeAttribute("member");
			
			InterestDao intersetDao= new InterestDaoImpl();
			List<Interest> interestList = intersetDao.selectAll();
			List<List> ListInList= new ArrayList<>();
			req.setAttribute("interestList", interestList);
			for (Interest interest : interestList) {
				LectureDao lectureDao = new LectureDaoImpl();
				List<Lecture> Lectureint_no =lectureDao.selectByInt_no2(interest.getInt_no());
				ListInList.add(Lectureint_no);
			}
			req.setAttribute("ListInList", ListInList);
			
			LectureDao lectureDao = new LectureDaoImpl();
			List<Lecture> lectureListPopularity= lectureDao.selectByPopularity();
			req.setAttribute("lectureListPopularity", lectureListPopularity);
			
			
		}else if(action.equals("lecture_name_search")) {
			
			int requestPage= Integer.parseInt(req.getParameter("reqPage"));
			String lecturename=req.getParameter("lecturename").trim();
			
			LectureDao lectureDao= new LectureDaoImpl();
			if(lecturename.equals("")) {
				List<Lecture> lectureList=null;
				req.setAttribute("lectureList", lectureList);
				String SearchName=null;
				int cnt=0;
				PageManager pm= new PageManager(requestPage);
				PageGroupResult pgr= pm.getLecturePageGroupResult(cnt);
				req.setAttribute("SearchName", SearchName);
				req.setAttribute("PageGroupResult", pgr);
				req.setAttribute("requestPage", requestPage);
				req.setAttribute("lectureList", lectureList);
			}else{
				String SearchName=req.getParameter("lecturename");	
				List<Lecture> lectureList=lectureDao.selectByName(lecturename,requestPage);
				if(lectureList.size()==0) {
					lectureList=null;
				}
				PageDao pageDao= new PageDaoImlp();
				int cnt= pageDao.getCount(PageSql.LECTURE_COUNT_SQL,lecturename);
			
				PageManager pm= new PageManager(requestPage);
				PageGroupResult pgr= pm.getLecturePageGroupResult(cnt);
				
				
				req.setAttribute("SearchName", SearchName);
				req.setAttribute("PageGroupResult", pgr);
				req.setAttribute("requestPage", requestPage);
				req.setAttribute("lectureList", lectureList);
	
			}
			
			
			HttpSession session = req.getSession();
			
			InterestDao intersetDao= new InterestDaoImpl();
			List<Interest> interestList = intersetDao.selectAll();
			List<List> ListInList= new ArrayList<>();
			req.setAttribute("interestList", interestList);
			
			for (Interest interest : interestList) {
				List<Lecture> Lectureint_no =lectureDao.selectByInt_no2(interest.getInt_no());
				ListInList.add(Lectureint_no);
			}
			req.setAttribute("ListInList", ListInList);
			
			
			if(session.getAttribute("member")!=null) {
				
				Member member= (Member)session.getAttribute("member");
				int userno= member.getUserno();
				
				List<Lecture> lectureListUserno=lectureDao.selectByUserno(userno);
				
				req.setAttribute("lectureListUserno", lectureListUserno);
				
				
				req.setAttribute("membername",member.getName());
				
			}
			
		}else if(action.equals("lecture_interest_search")) {
			
			int requestPage= Integer.parseInt(req.getParameter("reqPage"));
			int int_no= Integer.parseInt(req.getParameter("int_no"));
			LectureDao lectureDao= new LectureDaoImpl();
			List<Lecture> lectureList=lectureDao.selectByInt_no2(int_no, requestPage);
			
			PageDao pageDao= new PageDaoImlp();
			int cnt= pageDao.getCount(PageSql.LECTURE_COUNT_SQL,int_no);
			
			PageManager pm= new PageManager(requestPage);
			PageGroupResult pgr= pm.getLecturePageGroupResult(cnt);
			
			req.setAttribute("int_no", int_no);
			req.setAttribute("PageGroupResult", pgr);
			req.setAttribute("requestPage", requestPage);
			req.setAttribute("lectureList", lectureList);
	
			HttpSession session = req.getSession();
			
			InterestDao intersetDao= new InterestDaoImpl();
			List<Interest> interestList = intersetDao.selectAll();
			List<List> ListInList= new ArrayList<>();
			req.setAttribute("interestList", interestList);
			
			for (Interest interest : interestList) {
				List<Lecture> Lectureint_no =lectureDao.selectByInt_no2(interest.getInt_no());
				ListInList.add(Lectureint_no);
			}
			req.setAttribute("ListInList", ListInList);
			
			
			if(session.getAttribute("member")!=null) {
				
				Member member= (Member)session.getAttribute("member");
				int userno= member.getUserno();
				
				List<Lecture> lectureListUserno=lectureDao.selectByUserno(userno);
				
				req.setAttribute("lectureListUserno", lectureListUserno);
				
				req.setAttribute("membername",member.getName());
				
				
			}	
			int activaInt_no=int_no-1;
			req.setAttribute("activaInt_no", activaInt_no);
			
		}else if(action.equals("lecture_clickcountUp")) {
			int lectureno=Integer.parseInt(req.getParameter("lectureno"));
			LectureDao lectureDao= new LectureDaoImpl();
			lectureDao.selectClcikcount(lectureno);
			req.setAttribute("lectureno", lectureno);
		}
		
		String dispatcherUrl =null;
		
		if(action.equals("mainPage")) {
			dispatcherUrl ="JSP/main/mainForm2.jsp";
		}else if(action.equals("logout")) {
			dispatcherUrl ="JSP/main/mainForm2.jsp";
		}else if(action.equals("lecture_name_search")) {
			dispatcherUrl ="JSP/main/lectureNameSearch.jsp";
		}else if(action.equals("lecture_interest_search")) {
			dispatcherUrl ="JSP/main/lectureInterestSearch.jsp";
		}else if(action.equals("lecture_clickcountUp")) {
			dispatcherUrl ="detail_init";
		}
		
		
		RequestDispatcher dispatcher= req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}