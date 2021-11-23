package controller.review;

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


import dao.lecture.LectureDao;
import dao.lecture.LectureDaoImpl;
import dao.lecture_info.LectureInfoDao;
import dao.lecture_info.LectureInfoDaoImpl;
import dao.review.ReviewDao;
import dao.review.ReviewDaoImpl;
import model.Lecture;
import model.Member;
import model.Review;
import model.ViewReviewSelect;
import page.PageGroupResult;
import page.PageManager;

@WebServlet(name ="ReviewController" , urlPatterns={ "/review_list", "/review_register_form", "/review_register" } )
public class ReviewController extends HttpServlet {

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
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		System.out.println(action);
		
		
		
		if(action.equals("review_register_form")) {
			HttpSession session = req.getSession();
			
			int lectureno = Integer.parseInt(req.getParameter("lectureno"));
			Member member =(Member)session.getAttribute("member"); 
			int userno = member.getUserno();
			
			LectureDao lectureDao = new LectureDaoImpl();
			Lecture lecture = lectureDao.selectByLectureno(lectureno);
			req.setAttribute("lecture", lecture);
			
			
			
			
		}else if(action.equals("review_register")){
			ReviewDao reviewDao = new ReviewDaoImpl();
			Review review = new Review();
			LectureInfoDao lectureInfoDao = new LectureInfoDaoImpl();
			
			int lectureno = Integer.parseInt(req.getParameter("lectureno"));
			int userno = Integer.parseInt(req.getParameter("userno"));
			int infono = lectureInfoDao.selectInfonoByUsernoAndLectureno(userno, lectureno);
			String score = req.getParameter("score");
			System.out.println("점수는:" + score);
			String content = req.getParameter("content");
			System.out.println("내용은" + content);
			
			review.setInfono(infono);
			review.setScore(Double.parseDouble(score));
			review.setContent(content);
			reviewDao.reviewInsertByInfoNo(review);
			
			LectureDao lectureDao = new LectureDaoImpl();
			Lecture lecture = lectureDao.selectByLectureno(lectureno);
			String btnName = req.getParameter("btnName");
			System.out.println("버튼이름은: " + btnName);
			
			int requestPage= 0;
			String receivePage =req.getParameter("reqPage");
			System.out.println("요청페이지" +receivePage );
			String test =req.getParameter("test");
			System.out.println("테스트:" + test );
			
			if(  receivePage != null){
				requestPage = Integer.parseInt(receivePage);
			}else {
				requestPage = 1;
			}
			
			int rowCount = 0;
			List<ViewReviewSelect> reviewList = null;
			PageGroupResult pgr;
			

			reviewList = reviewDao.selectReviewByLectureNoToPage(requestPage, lectureno);
			rowCount =  reviewDao.ReviewCntByLectureno(lectureno);
			
			PageManager pm = new PageManager(requestPage);
			pgr= pm.getQnaPageGroupResult(rowCount);
			
			//req.setAttribute("lecture", lecture);
			req.setAttribute("pageGroupResult", pgr);
			req.setAttribute("reviewList", reviewList);
			req.setAttribute("lecture", lecture);
		
		
		
		
		
		
		
		
		}else if(action.equals("review_list")){
			
			LectureDao lectureDao = new LectureDaoImpl();
			
			String  inputDate = req.getParameter("lectureno");
			int lectureno =Integer.parseInt(req.getParameter("lectureno"));
			Lecture lecture = lectureDao.selectByLectureno(lectureno);


			String btnName = req.getParameter("btnName");
			System.out.println("버튼이름은: " + btnName);
			
			ReviewDao reviewDao = new ReviewDaoImpl(); 
			int requestPage= 0;
			String receivePage =req.getParameter("reqPage");
			System.out.println("요청페이지" +receivePage );
			String test =req.getParameter("test");
			System.out.println("테스트:" + test );
			
			if(  receivePage != null){
				requestPage = Integer.parseInt(receivePage);
			}else {
				requestPage = 1;
			}
			
			int rowCount = 0;
			List<ViewReviewSelect> reviewList = null;
			PageGroupResult pgr;
			

			reviewList = reviewDao.selectReviewByLectureNoToPage(requestPage, lectureno);
			rowCount =  reviewDao.ReviewCntByLectureno(lectureno);
			
			PageManager pm = new PageManager(requestPage);
			pgr= pm.getQnaPageGroupResult(rowCount);			
			//req.setAttribute("lecture", lecture);
			req.setAttribute("pageGroupResult", pgr);
			req.setAttribute("reviewList", reviewList);
			req.setAttribute("lecture", lecture);
		}
		
		
		
		String dispatcherUrl = null;
		if((action.equals("review_register_form"))) {
			dispatcherUrl ="JSP/review/review_registerform.jsp";
			
		}else if(action.equals("review_register") ) {
			dispatcherUrl ="JSP/review/review_list.jsp";
		}
		else if(action.equals("review_list") ) {
			dispatcherUrl ="JSP/review/review_list.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
		
		
	}
	
}
