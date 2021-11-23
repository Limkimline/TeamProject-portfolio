package controller.mypage;

import java.io.IOException;
import java.util.ArrayList;
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
import dao.lecture_info.LectureInfoDao;
import dao.lecture_info.LectureInfoDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Interest;
import model.Lecture_Info2;
import model.Member;

@WebServlet(name = "MypageController", urlPatterns = { "/checkPw","/myProfile","/deleteMember","/memberUpdate" })
@MultipartConfig
public class MypageController extends HttpServlet {

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
		String action = uri.substring(lastindex + 1);
		
		HttpSession session = req.getSession();
		Member member = null;
		int userno = 0;
		Member member2 = null;
		if(session.getAttribute("member") != null) {
			
			member2 = (Member) session.getAttribute("member");
			
		}
		
		
		if (action.equals("myProfile")) {
			
			userno = member2.getUserno();
			MemberDao memberDao = new MemberDaoImpl();
			member = memberDao.selectByUserno(userno);
			req.setAttribute("member", member);
			System.out.println(member.toString());
			
		} else if(action.equals("deleteMember")) {
			userno = Integer.parseInt(req.getParameter("userno"));
			MemberDao memberDao = new MemberDaoImpl();
			memberDao.delete(userno);
			session.removeAttribute("member");
			
		}else if(action.equals("memberUpdate")) {
			Part part= req.getPart("imagename");
			String fileName= getFileName(part);
			
			System.out.println(fileName +"ÀÇ ÆÄÀÏ");
			String imagename = req.getParameter("imagenamebe");
			//System.out.println("imagename" +imagename);
			
			if(fileName != null && !fileName.isEmpty()) {
				part.write("D:/fileserver/"+fileName);
				String imagePath="D:\\"+"fileserver\\"+fileName;
				req.setAttribute("imagePath", imagePath);
				imagename = fileName;
			} else {
				//imagename = req.getParameter("imagenamebe");
			}
			
			
			userno = Integer.parseInt(req.getParameter("userno"));
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String pwd = req.getParameter("password1");
			String gender = req.getParameter("sex");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			String certification = req.getParameter("certification");
			
			
			int int_no = Integer.parseInt(req.getParameter("interest1"));
			int int_no2 = Integer.parseInt(req.getParameter("interest2"));
			
			Member memberget = new Member(userno,id, pwd, name, gender, phone, email,
					certification, imagename, int_no, int_no2);
			//System.out.println(memberget.toString());
			MemberDao memberDao = new MemberDaoImpl();
			memberDao.update(memberget);
			
		}else if(action.equals("checkPw")) {
			userno = member2.getUserno();
			MemberDao memberDao = new MemberDaoImpl();
			member = memberDao.selectByUserno(userno);
			
			req.setAttribute("memberPw", member.getPwd());
			
		}

		String dispatcherURL = null;

		if (action.equals("myProfile")) {
			dispatcherURL = "/JSP/mypage/profile.jsp";
			
		}else if(action.equals("deleteMember")) {
			dispatcherURL = "/mainPage";
			
		}else if(action.equals("memberUpdate")) {
			dispatcherURL = "/myProfile";
			
		}else if(action.equals("checkPw")) {
			dispatcherURL = "/JSP/mypage/checkPw.jsp";
			
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherURL);
		dispatcher.forward(req, resp);
	}

	private String getFileName(Part part) {
		String contentDispositionHeader =part.getHeader("content-disposition");
		String[] elements= contentDispositionHeader.split(";");
		for (String element : elements) {
			if(element.trim().startsWith("filename")) {
				return element.substring(element.indexOf("=")+2, element.length()-1).trim();
			}
		}
		return null;
	}
	
}
