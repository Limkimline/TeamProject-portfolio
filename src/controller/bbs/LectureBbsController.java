
package controller.bbs;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import dao.lecture_qna.LectureQnaDao;
import dao.lecture_qna.LectureQnaDaoImpl;
import dao.manager.ManagerDao;
import dao.manager.ManagerDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.Lecture;
import model.Lecture_Info;
import model.Lecture_Info2;
import model.Lecture_Qna;
import model.Member;
import page.PageGroupResult;
import page.PageManager;

@WebServlet(name ="LectureBbsController" , urlPatterns= {"/lecture_qna_list", "/lecture_qna_register_form",
		"/lecture_qna_register", "/lecture_qna_return_detail", "/lecture_qna_detail"  } )
public class LectureBbsController extends HttpServlet{


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

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = pickUri(req);

		if ((action.equals("lecture_qna_list"))) {
			
			int lectureno = Integer.parseInt(req.getParameter("lectureno"));
			setLQList(req,lectureno);

		} else if (action.equals("lecture_qna_register_form")) {
			HttpSession session = req.getSession();
			if (session.getAttribute("member") != null) {
				Member loginMember = (Member) session.getAttribute("member");
				req.setAttribute("member", loginMember);
			}
			
			int lectureno= Integer.parseInt(req.getParameter("lectureno"));
			LectureDao lectureDao = new LectureDaoImpl();
			Lecture lecture = lectureDao.selectByLectureno(lectureno);
			req.setAttribute("lecture", lecture);
			
		} else if (action.equals("lecture_qna_register")) {
			
			int lectureno = Integer.parseInt(req.getParameter("lectureno"));
			insertLQ(req);
			setLQList(req,lectureno);
			
			
		} else if (action.equals("lecture_qna_detail")) {
			String isInstructor = null;
			String isWriter = null;
			String loginId = null;
			int loginserno = 0;
			HttpSession session = req.getSession();
			if (session.getAttribute("member") != null) {
				Member loginMember = (Member) session.getAttribute("member");
				loginId = loginMember.getId();
				loginserno = loginMember.getUserno();
			} else {
				loginId = "비로그인회원";
			
			}
			
			
			
			int qnaNo = Integer.parseInt(req.getParameter("qnano"));
			LectureQnaDao gqDao = new LectureQnaDaoImpl();
			MemberDao memberDao = new MemberDaoImpl();

			Lecture_Qna lq = gqDao.LectureQnaSelectByQnaNo(qnaNo);
			lq.getClickCount().incrementAndGet();
			gqDao.updateClickCount(lq);

			//Manager manager = managerDao.ManagerSelectByManagerNo(gq.getManagerno()); 강사  부분
			String writerId = null;
			if (lq.getUserno() != 0) {
				Member Writermember = memberDao.selectByUserno(lq.getUserno());
				writerId = Writermember.getId();
			} else {
				writerId = "비회원";
			}

			if (loginId.equals(writerId)) {
				isWriter = "1";
			} else {
				isWriter = "0";
			}
			
			int lectureno = lq.getLectureno();
			LectureDao lectureDao = new LectureDaoImpl();
			Lecture lecture = lectureDao.selectByLectureno(lectureno);
			
			int instructorno = lecture.getUserno();
			
			
			if (loginserno ==instructorno) { //강사체크
				isInstructor = "1";
			} else {
				isInstructor = "0";
			}

			req.setAttribute("lq", lq);
			req.setAttribute("writerId", writerId);
			req.setAttribute("isWriter", isWriter);
			req.setAttribute("isInstructor", isInstructor);
			req.setAttribute("lecture",lecture);
			
		} else if (action.equals("lecture_qna_return_detail")) {
			LectureQnaDao lqDao = new LectureQnaDaoImpl();
			int qnaNo = Integer.parseInt(req.getParameter("qnano"));
			Lecture_Qna lq = lqDao.LectureQnaSelectByQnaNo(qnaNo);
			int lectureno = lq.getLectureno();
			String receiveSubject = req.getParameter("subject");
			String receiveContent = req.getParameter("content");
			String receiveAnswer = req.getParameter("answer");
			String receiveOpen = req.getParameter("open");
			lq.setSubject(receiveSubject);
			lq.setContent(receiveContent);
			lq.setAnswer(receiveAnswer);
			lq.setOpen(receiveOpen);

			String request = null;
			request = req.getParameter("requestsubmit");

			if (request.equals("수정")) {
				lqDao.LectureQnaUpdateByQnaNo(lq);
			} else if (request.equals("삭제")) {
				lqDao.LectureQnaDeleteByQnano(qnaNo);
			} else if (request.equals("답변등록")) {
				lqDao.LectureQnaUpdateByQnaNo(lq);
			}

			setLQList(req,lectureno);
		}

		String dispatcherUrl = null;

		if ((action.equals("lecture_qna_list"))) {
			dispatcherUrl = "JSP/bbs/lecture_qna_list.jsp";

		} else if (action.equals("lecture_qna_register_form")) {
			dispatcherUrl = "JSP/bbs/lecture_qna_registerform.jsp";

		} else if (action.equals("lecture_qna_register")) {
			dispatcherUrl = "JSP/bbs/lecture_qna_list.jsp";

		} else if (action.equals("lecture_qna_detail")) {
			dispatcherUrl = "JSP/bbs/lecture_qna_detail.jsp";

		} else if (action.equals("lecture_qna_return_detail")) {
			dispatcherUrl = "JSP/bbs/lecture_qna_list.jsp";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);

	}

	String pickUri(HttpServletRequest req) {

		String uri = req.getRequestURI();
		System.out.println(uri);

		int lastIndex = uri.lastIndexOf("/");
		return uri.substring(lastIndex + 1);

	}

	void setLQList(HttpServletRequest req ,int lectureno) {

		
		
		
		String listKeyword = req.getParameter("listKeyword");
		String btnName = req.getParameter("btnName");
		System.out.println("버튼이름은: " + btnName);
		Lecture lecture = null;
		if(req.getParameter("lectureno") != null) {
		LectureDao lectureDao = new LectureDaoImpl();
		lecture = lectureDao.selectByLectureno(lectureno);
		}else
		{
			int qnano= Integer.parseInt(req.getParameter("qnano"));	
			LectureQnaDao lectureQnaDao = new LectureQnaDaoImpl();
			Lecture_Qna lq = lectureQnaDao.LectureQnaSelectByQnaNo(qnano);
			LectureDao lectureDao = new LectureDaoImpl();
			lecture = lectureDao.selectByLectureno(lectureno);
		}
		

		
		
		LectureQnaDao dao = new LectureQnaDaoImpl();

		int requestPage = 0;
		String receivePage = req.getParameter("reqPage");
		System.out.println("요청페이지" + receivePage);
		String test = req.getParameter("test");
		System.out.println("테스트:" + test);

		if (receivePage != null) {
			requestPage = Integer.parseInt(receivePage);
		} else {
			requestPage = 1;
		}

		int rowCount = 0;
		List<Lecture_Qna> lqList = null;
		PageGroupResult pgr;
		if (btnName == null) {

			if (listKeyword == null) {
				lqList = dao.selectByLectureNoToPage(requestPage, lectureno);
				rowCount = dao.LectureQnaCntByLectureno(lectureno);

			} else if (listKeyword.equals("myQna")) {
				HttpSession session = req.getSession();
				String id = session.getAttribute("id").toString();
				MemberDao memberDao = new MemberDaoImpl();
				Member member = memberDao.selectById(id);
				
				int userno = member.getUserno();
				lqList = dao.selectByLecturenoAndUsernoToPage(requestPage,lectureno ,userno);
				rowCount = dao.LectureQnaCntByLecturenoAndUserno(lectureno,userno);
			} else {
				lqList = dao.selectByLecturenoAndSubjectToPage(requestPage, lectureno,listKeyword);
				rowCount = dao.LectureQnaCntByLecturenoAndSubject(lectureno,listKeyword);
			}
		} else {
			if (btnName.equals("내 글")) {
				HttpSession session = req.getSession();
				Member member = (Member) session.getAttribute("member");
				String id = member.getId();
				int userno = member.getUserno();
				lqList = dao.selectByLecturenoAndUsernoToPage(requestPage,lectureno, userno);
				rowCount = dao.LectureQnaCntByLecturenoAndUserno(lectureno,userno);
				listKeyword = "myQna";
			} else if (btnName.equals("검색")) {

				String searchSubject = req.getParameter("searchsubject");
				lqList = dao.selectByLecturenoAndSubjectToPage(requestPage, lectureno,searchSubject);
				rowCount = dao.LectureQnaCntByLecturenoAndSubject(lectureno,searchSubject);
				listKeyword = searchSubject;
			} else {
				lqList = dao.selectByLectureNoToPage(requestPage, lectureno);
				rowCount = dao.LectureQnaCntByLectureno(lectureno);
			}
		}
		
		
		PageManager pm = new PageManager(requestPage);
		pgr = pm.getQnaPageGroupResult(rowCount);

		for (Lecture_Qna item : lqList) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime writeTime = LocalDateTime.parse(item.getWriteDate(), formatter);

			int diffDay = now.getDayOfYear() - writeTime.getDayOfYear();
			int diffHour = now.getHour() - writeTime.getHour();
			int diffMin = now.getMinute() - writeTime.getMinute();
			if (diffDay == 0) { // 같은 날에 작성 시
				if (diffHour > 0) {
					item.setWriteDate(diffHour + "시간 전");
				} else {
					item.setWriteDate(diffMin + "분 전");
				}

			} else if (diffDay == 1) {
				item.setWriteDate("하루전");
			} else {

				String[] splits = item.getWriteDate().split(" ");

				item.setWriteDate(splits[0].substring(5));
			}
		}

		System.out.println(pgr.getGroupStartNumber());
		System.out.println(pgr.getGroupEndNumber());
		req.setAttribute("pageGroupResult", pgr);
		req.setAttribute("listKeyword", listKeyword);
		req.setAttribute("lqList", lqList);
		req.setAttribute("lecture", lecture);
	}

	void insertLQ(HttpServletRequest req) {
		LectureQnaDao lectureQnaDao = new LectureQnaDaoImpl();
		Member member = null;

		HttpSession session = req.getSession();
		int lectureno = Integer.parseInt( req.getParameter("lectureno"));
		if (session.getAttribute("member") != null) {
			member = (Member) session.getAttribute("member");
		}
		
		
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String open = req.getParameter("open");

		Lecture_Qna lq = new Lecture_Qna();

		lq.setSubject(subject);
		lq.setContent(content);
		lq.setOpen(open);
		lq.setAnswer(null);
		lq.setLectureno(lectureno);
		if (member != null) {
			lq.setUserno(member.getUserno());
			lectureQnaDao.LecturelQnaInsert(lq);
		} else {
			lectureQnaDao.LectureQnaInsertByNoMember(lq);
		}
	}


	
	

}

