package controller.makeLecture;

import java.io.IOException;
import java.util.List;

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
import dao.review.ReviewDao;
import dao.review.ReviewDaoImpl;
import model.Lecture;
import model.Member;
import model.ViewReviewSelect;

@WebServlet(name = "LectureDetailController", urlPatterns = {"/detail_init"})
public class LectureDetailController extends HttpServlet {
	
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

		if (action.equals("detail_init")) {	
				LectureDao lDao = new LectureDaoImpl();
				// int no = Integer.parseInt(req.getParameter("lecNo")); 1027 厘悼林 : 抛胶飘 林家 贸府
				int no = Integer.parseInt(req.getParameter("lectureno"));
				Lecture lecture = lDao.selectByLectureno(no);
				String interest = lDao.selectInterestByno(no);
				//System.out.println(interest);
				String userName = lDao.selectMemberByno(no); 
				Member teacher = lDao.selectTeacherByno(no); 
				
				String[] splitStart = lecture.getStartdate().split(" "); 
				String[] splitEnd = lecture.getEnddate().split(" "); 
				
				String[] RecsplitStart = lecture.getRec_startdate().split(" "); 
				String[] RecsplitEnd = lecture.getRec_enddate().split(" "); 
				
				req.setAttribute("lecture", lecture);
				req.setAttribute("splitStart", splitStart[0]);
				req.setAttribute("splitEnd", splitEnd[0]);
				req.setAttribute("recSplitStart", splitStart[0]);
				req.setAttribute("recSplitEnd", splitEnd[0]);
				req.setAttribute("interest", interest);
				req.setAttribute("userName", userName);
				req.setAttribute("teacher", teacher);

				ReviewDao reviewDao =new ReviewDaoImpl();
				List<ViewReviewSelect> reviewList = null;
				reviewList = reviewDao.selectReviewByLectureNoToDetail(1, no);
				req.setAttribute("reviewList", reviewList);
				req.setAttribute("lectureno", no);

				
		} 

		String dispatcherUrl = null;

		if (action.equals("detail_init")) {
			dispatcherUrl = "JSP/makeLecure/lectureDetail.jsp";
		} 

		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
