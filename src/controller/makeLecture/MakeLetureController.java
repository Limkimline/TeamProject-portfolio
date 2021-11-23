package controller.makeLecture;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.interest.InterestDao;
import dao.interest.InterestDaoImpl;
import dao.lecture.LectureDao;
import dao.lecture.LectureDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Interest;
import model.Lecture;
import model.Member;


@WebServlet(name="MakeLetureController", urlPatterns= {"/lecture_input","/lecture_reInput","/lecture_insert","/lecture_reInsert","/daycheck"})
@MultipartConfig
public class MakeLetureController extends HttpServlet{
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
		//System.out.println(uri);
		
		int lastIndex= uri.lastIndexOf("/");
		//System.out.println(lastIndex);
		
		String action= uri.substring(lastIndex+1);
		//System.out.println(action);
		
		
		if(action.equals("lecture_input")) {
			HttpSession session = req.getSession();
			
			Member member= (Member)session.getAttribute("member");
			MemberDao memberDao = new MemberDaoImpl();
			Member member2= memberDao.selectById(member.getId());
			req.setAttribute("user", member2);
			InterestDao interesdao= new InterestDaoImpl();
			List<Interest> interestList=interesdao.selectAll();
			req.setAttribute("interestList", interestList);
			
		}else if(action.equals("lecture_reInput")) {
			HttpSession session = req.getSession();
			Member member= (Member)session.getAttribute("member");
			MemberDao memberDao = new MemberDaoImpl();
			Member member2= memberDao.selectById(member.getId());
			req.setAttribute("user", member2);
			LectureDao lectureDao= new LectureDaoImpl();
			int lectureno= Integer.parseInt(req.getParameter("lectureno"));
			Lecture lecture = lectureDao.selectByLectureno(lectureno);
			InterestDao interesdao= new InterestDaoImpl();
			List<Interest> interestList=interesdao.selectAll();
			req.setAttribute("lecture", lecture);
			req.setAttribute("interestList", interestList);
			
			
		}else if(action.equals("lecture_insert")) {
			Part part= req.getPart("imagename");
			String fileName= getFileName(part);
			
			if(fileName != null && !fileName.isEmpty()) {

				part.write("D:/fileserver/"+fileName);
				String imagePath="D:\\"+"fileserver\\"+fileName;
				req.setAttribute("imagePath", imagePath);
			}
			
			
			
			LectureDao lectureDao= new LectureDaoImpl();
			Lecture lecture= new Lecture();
		
			String name=req.getParameter("name");
			String content= req.getParameter("content");
			String startdate=req.getParameter("startdate");
			String starttime= req.getParameter("starttime");
			String enddate= req.getParameter("enddate");
			String endtime= req.getParameter("endtime");
			String rec_startdate= req.getParameter("rec_startdate");
			String rec_enddate= req.getParameter("rec_enddate");
			String imagename= fileName;
			int rec_cnt= Integer.parseInt(req.getParameter("rec_cnt"));
			int int_no= Integer.parseInt(req.getParameter("int_no"));
			int userno= Integer.parseInt(req.getParameter("userno"));
			lecture.setName(name);
			lecture.setContent(content);
			lecture.setStartdate(startdate);
			lecture.setEnddate(enddate);
			lecture.setStarttime(starttime);
			lecture.setEndtime(endtime);
			lecture.setRec_startdate(rec_startdate);
			lecture.setRec_enddate(rec_enddate);
			lecture.setImagename(imagename);
			lecture.setRec_cnt(rec_cnt);
			lecture.setInt_no(int_no);
			lecture.setUserno(userno);
			lectureDao.insert(lecture);
			
			
		}else if(action.equals("lecture_reInsert")) {
			Part part= req.getPart("imagename");
			String fileName= getFileName(part);
			
			if(fileName != null && !fileName.isEmpty()) {
				
				part.write("D:/fileserver/"+fileName);
				String imagePath="D:\\"+"fileserver\\"+fileName;
				req.setAttribute("imagePath", imagePath);
			}
	
			LectureDao lectureDao= new LectureDaoImpl();
			Lecture lecture= new Lecture();
		
			String name=req.getParameter("name");
			String content= req.getParameter("content");
			String startdate=req.getParameter("startdate");
			String starttime= req.getParameter("starttime");
			String enddate= req.getParameter("enddate");
			String endtime= req.getParameter("endtime");
			String rec_startdate= req.getParameter("rec_startdate");
			String rec_enddate= req.getParameter("rec_enddate");
			String imagename= fileName;
			int rec_cnt= Integer.parseInt(req.getParameter("rec_cnt"));
			int int_no= Integer.parseInt(req.getParameter("int_no"));
			int userno= Integer.parseInt(req.getParameter("userno"));
			int lectureno= Integer.parseInt(req.getParameter("lectureno"));
			lecture.setName(name);
			lecture.setContent(content);
			lecture.setStartdate(startdate);
			lecture.setEnddate(enddate);
			lecture.setStarttime(starttime);
			lecture.setEndtime(endtime);
			lecture.setRec_startdate(rec_startdate);
			lecture.setRec_enddate(rec_enddate);
			lecture.setImagename(imagename);
			lecture.setRec_cnt(rec_cnt);
			lecture.setInt_no(int_no);
			lecture.setUserno(userno);
			lecture.setLectureno(lectureno);
			lectureDao.update(lecture);
			
		}else if(action.equals("daycheck")) {
			
			String startdate = req.getParameter("startdate_value");
			String enddate = req.getParameter("enddate_value");
			String starttime = req.getParameter("starttime_value");
			String endtime = req.getParameter("endtime_value");
			int userno =Integer.parseInt(req.getParameter("userno"));
			LectureDao lectureDao = new LectureDaoImpl();
			int cnt=0;
			int cnt1=lectureDao.dateSeach(startdate,enddate, starttime,endtime,userno);
			int cnt2=lectureDao.lectureInfoDateSeach(startdate, enddate, starttime, endtime, userno);
			cnt=cnt1+cnt2;
			
			if(cnt>0) {
				req.setAttribute("useTF", false);
			}else {
				req.setAttribute("useTF", true); 
			}
		}
		
		
		
		String dispatcherUrl =null;
		
		if(action.equals("lecture_input")) {
			dispatcherUrl ="JSP/makeLecure/makeForm.jsp";
		}else if(action.equals("lecture_reInput")) {
			dispatcherUrl ="JSP/makeLecure/makeReForm.jsp";
		}else if(action.equals("lecture_insert")) {
			dispatcherUrl ="mainPage";
		}else if(action.equals("lecture_reInsert")) {
			dispatcherUrl ="mainPage";
		}else if(action.equals("daycheck")) {
			dispatcherUrl="JSP/makeLecure/daycheck.jsp";
		}
		
		
		
		RequestDispatcher dispatcher= req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
	

	private String getFileName(Part part) {
		//파트의 header 중에서 괄호 안의 정보를 가져온다.
		String contentDispositionHeader =part.getHeader("content-disposition");
		String[] elements= contentDispositionHeader.split(";");
		for (String element : elements) {
			//filename은 heard 이름 중 하나이다. 
			if(element.trim().startsWith("filename")) {
				return element.substring(element.indexOf("=")+2, element.length()-1).trim();
			}
		}
		
		return null;
	}
}
