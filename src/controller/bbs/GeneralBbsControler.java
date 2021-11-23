package controller.bbs;

import java.io.IOException;
import java.time.LocalDate;
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

import dao.general_qna.GeneralQnaDao;
import dao.general_qna.GeneralQnaDaoImpl;
import dao.interest.InterestDao;
import dao.interest.InterestDaoImpl;
import dao.manager.ManagerDao;
import dao.manager.ManagerDaoImpl;
import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.General_Qna;
import model.Interest;
import model.Manager;
import model.Member;
import page.PageGroupResult;
import page.PageManager;

@WebServlet(name = "GeneralBbsController", urlPatterns = { "/general_qna_list", "/general_qna_register_form",
		"/general_qna_register", "/general_qna_return_detail", "/general_qna_detail" })
public class GeneralBbsControler extends HttpServlet {

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

		if ((action.equals("general_qna_list"))) {

			setGQList(req);

		} else if (action.equals("general_qna_register_form")) {
			HttpSession session = req.getSession();
			if (session.getAttribute("member") != null) {
				Member loginMember = (Member) session.getAttribute("member");
				req.setAttribute("member", loginMember);
			}
			
			
		} else if (action.equals("general_qna_register")) {
			insertGQ(req);
			setGQList(req);
		} else if (action.equals("general_qna_detail")) {
			String isManager = null;
			String isWriter = null;
			String loginId = null;
			HttpSession session = req.getSession();
			if (session.getAttribute("member") != null) {
				Member loginMember = (Member) session.getAttribute("member");
				loginId = loginMember.getId();
			} else {
				loginId = "비로그인회원";
			}
			int qnaNo = Integer.parseInt(req.getParameter("qnano"));
			GeneralQnaDao gqDao = new GeneralQnaDaoImpl();
			ManagerDao managerDao = new ManagerDaoImpl();
			MemberDao memberDao = new MemberDaoImpl();

			General_Qna gq = gqDao.GeneralQnaSelectByQnaNo(qnaNo);
			gq.getClickCount().incrementAndGet();
			gqDao.updateClickCount(gq);

			Manager manager = managerDao.ManagerSelectByManagerNo(gq.getManagerno());
			String writerId = null;
			if (gq.getUserno() != 0) {
				Member Writermember = memberDao.selectByUserno(gq.getUserno());
				writerId = Writermember.getId();
			} else {
				writerId = "비회원";
			}

			if (loginId.equals(writerId)) {
				isWriter = "1";
			} else {
				isWriter = "0";
			}

			if (loginId.equals(manager.getId())) {
				isManager = "1";
			} else {
				isManager = "0";
			}

			req.setAttribute("gq", gq);
			req.setAttribute("writerId", writerId);
			req.setAttribute("isWriter", isWriter);
			req.setAttribute("isManager", isManager);

		} else if (action.equals("general_qna_return_detail")) {
			GeneralQnaDao gqDao = new GeneralQnaDaoImpl();
			int qnaNo = Integer.parseInt(req.getParameter("qnano"));

			General_Qna gq = gqDao.GeneralQnaSelectByQnaNo(qnaNo);
			String receiveSubject = req.getParameter("subject");
			String receiveContent = req.getParameter("content");
			String receiveAnswer = req.getParameter("answer");
			String receiveOpen = req.getParameter("open");
			gq.setSubject(receiveSubject);
			gq.setContent(receiveContent);
			gq.setAnswer(receiveAnswer);
			gq.setOpen(receiveOpen);

			String request = null;
			request = req.getParameter("requestsubmit");

			if (request.equals("수정")) {
				gqDao.GeneralQnaUpdateByQnaNo(gq);
			} else if (request.equals("삭제")) {
				gqDao.GeneralQnaDeleteByQnano(qnaNo);
			} else if (request.equals("답변등록")) {
				gqDao.GeneralQnaUpdateByQnaNo(gq);
			}

			setGQList(req);
		}

		String dispatcherUrl = null;

		if ((action.equals("general_qna_list"))) {
			dispatcherUrl = "JSP/bbs/general_qna_list.jsp";

		} else if (action.equals("general_qna_register_form")) {
			dispatcherUrl = "JSP/bbs/general_qna_registerform.jsp";

		} else if (action.equals("general_qna_register")) {
			dispatcherUrl = "JSP/bbs/general_qna_list.jsp";

		} else if (action.equals("general_qna_detail")) {
			dispatcherUrl = "JSP/bbs/general_qna_detail.jsp";

		} else if (action.equals("general_qna_return_detail")) {
			dispatcherUrl = "JSP/bbs/general_qna_list.jsp";
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

	void setGQList(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		
		String listKeyword = req.getParameter("listKeyword");
		String btnName = req.getParameter("btnName");
		System.out.println("버튼이름은: " + btnName);

		GeneralQnaDao dao = new GeneralQnaDaoImpl();

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
		List<General_Qna> gqList = null;
		PageGroupResult pgr;
		if (btnName == null) {

			if (listKeyword == null) {
				gqList = dao.selectAllToPage(requestPage);
				rowCount = dao.GeneralQnaCntAll();

			} else if (listKeyword.equals("myQna")) {
				int userno = member.getUserno();
				gqList = dao.selectByUsernoToPage(requestPage, userno);
				rowCount = dao.GeneralQnaCntByUserno(userno);
			} else {
				gqList = dao.selectBySubjectToPage(requestPage, listKeyword);
				rowCount = dao.GeneralQnaCntBySubject(listKeyword);
			}
		} else {
			if (btnName.equals("내 글")) {
				
				String id = member.getId();
				int userno = member.getUserno();
				gqList = dao.selectByUsernoToPage(requestPage, userno);
				rowCount = dao.GeneralQnaCntByUserno(userno);
				listKeyword = "myQna";
			} else if (btnName.equals("검색")) {

				String searchSubject = req.getParameter("searchsubject");
				gqList = dao.selectBySubjectToPage(requestPage, searchSubject);
				rowCount = dao.GeneralQnaCntBySubject(searchSubject);
				listKeyword = searchSubject;
			} else {
				gqList = dao.selectAllToPage(requestPage);
				rowCount = dao.GeneralQnaCntAll();
			}
		}
		PageManager pm = new PageManager(requestPage);
		pgr = pm.getQnaPageGroupResult(rowCount);
		

		for (General_Qna item : gqList) {
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
		req.setAttribute("gqList", gqList);
		req.setAttribute("member",member);
	}

	void insertGQ(HttpServletRequest req) {
		GeneralQnaDao generalQnaDao = new GeneralQnaDaoImpl();
		Member member = null;

		HttpSession session = req.getSession();
		if (session.getAttribute("member") != null) {
			member = (Member) session.getAttribute("member");
		}

		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String open = req.getParameter("open");

		General_Qna gq = new General_Qna();

		gq.setSubject(subject);
		gq.setContent(content);
		gq.setOpen(open);
		gq.setAnswer(null);
		gq.setManagerno(1);
		if (member != null) {
			gq.setUserno(member.getUserno());
			generalQnaDao.GeneralQnaInsert(gq);
		} else {
			generalQnaDao.GeneralQnaInsertByNoMember(gq);
		}
	}


}

