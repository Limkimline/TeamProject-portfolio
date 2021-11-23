package controller.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Member;

@WebServlet(name = "JoinController", urlPatterns = {"/join_init","/join"} )
@MultipartConfig
public class JoinController extends HttpServlet {
	
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

		if (action.equals("join_init")) {	
				
		} else if (action.equals("join")) {
			
			String password = req.getParameter("password");
			String password_confirm = req.getParameter("password_confirm");
			
			//if(password.equals(password_confirm)) {
				Part part= req.getPart("imagename");
				String fileName= getFileName(part);
				
				System.out.println(fileName +"의 파일");
				
				if(fileName != null && !fileName.isEmpty()) {
					part.write("D:/fileserver/"+fileName);
					String imagePath="D:\\"+"fileserver\\"+fileName;
					req.setAttribute("imagePath", imagePath);
				}
				
				System.out.println("드디어 나오는건가;;");
				
				String id = req.getParameter("id");
				String pwd = req.getParameter("password");
				String name = req.getParameter("name");
				String gender = req.getParameter("sex");
				String phone = req.getParameter("phone");
				String email = req.getParameter("email");
				String cert = req.getParameter("authYN");
				String imageName = fileName;
				int int_no = Integer.parseInt(req.getParameter("interest1"));
				int int_no2 = Integer.parseInt(req.getParameter("interest2"));
				
				Member member = new Member(id, pwd, name, gender, phone, email, cert ,imageName, int_no, int_no2);
				MemberDao mDao = new MemberDaoImpl();
				mDao.insert(member);
				
				req.setAttribute("message", "정상적으로 등록되었습니다.");
				
			//} else {
				
			//	req.setAttribute("error","패스워드가 일치하지 않습니다." );
				
			//}
		} 

		String dispatcherUrl = null;

		if (action.equals("join_init")) {
			dispatcherUrl = "JSP/login/joinForm.jsp";
		} else if (action.equals("join")) {
			dispatcherUrl = "JSP/login/joinResult.jsp";
		} 

		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
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
