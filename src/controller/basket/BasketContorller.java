package controller.basket;

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
import model.Basket;
import model.Lecture;
import model.Member;
import page.PageDao;
import page.PageDaoImlp;
import page.PageGroupResult;
import page.PageManager;

@WebServlet(name="BasketContorller", urlPatterns= {"/basket_list","/basket_delete","/basket_DateDelete","/basket_Insert"})
public class BasketContorller extends HttpServlet{

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
		
		if(action.equals("basket_list")) {
			int requestPage=0;
			if(req.getParameter("reqPage")==null) {
				requestPage= 1;
			}else if(req.getParameter("reqPage")!=null){
				requestPage= Integer.parseInt(req.getParameter("reqPage"));
			}
			
			HttpSession session = req.getSession();
			Member user= (Member)session.getAttribute("member");
			
			BasketDao basketDao = new BasketDaoImpl();
			PageDao pageDao= new PageDaoImlp();
			int cnt= pageDao.getCount(user.getUserno());
			PageManager pm= new PageManager(requestPage);
			PageGroupResult pgr= pm.getBasketPageGroupResult(cnt);
			
			List<Lecture> basketList= basketDao.selectByUserno(user.getUserno(), requestPage);
			
			req.setAttribute("PageGroupResult", pgr);
			req.setAttribute("requestPage", requestPage);
			req.setAttribute("basketList", basketList);
			
			
		}else if(action.equals("basket_delete")) {
			
			BasketDao basketDao = new BasketDaoImpl();
			
			HttpSession session = req.getSession();
			Member user= (Member)session.getAttribute("member");
			int userno=user.getUserno();
			String[] lecturenoList= req.getParameterValues("checkbox");
			
			for (String lectureno : lecturenoList) {
				basketDao.delete(userno, Integer.parseInt(lectureno));
			}
			
		}else if(action.equals("basket_DateDelete")) {
			
			BasketDao basketDao = new BasketDaoImpl();

			HttpSession session = req.getSession();
			Member user= (Member)session.getAttribute("member");
			int userno=user.getUserno();
			basketDao.deleteDate(userno);
			
		}else if(action.equals("basket_Insert")) {
			
			BasketDao basketDao = new BasketDaoImpl();

			HttpSession session = req.getSession();
			Member user= (Member)session.getAttribute("member");
			int userno=user.getUserno();
			int lectureno= Integer.parseInt(req.getParameter("lectureno"));
			
			Basket basket= new Basket();
			basket.setLectureno(lectureno);
			basket.setUserno(userno);
			basketDao.insert(basket);
			
			
		}
		
		
		String dispatcherUrl =null;
		
		
		if(action.equals("basket_list")) {
			
			dispatcherUrl ="JSP/basket/basket.jsp";
			
		}else if(action.equals("basket_delete")) {
			
			dispatcherUrl ="basket_list";
			
		}else if(action.equals("basket_DateDelete")) {
			
			dispatcherUrl ="basket_list";
			
		}else if(action.equals("basket_Insert")) {
			
			dispatcherUrl ="basket_list";
		}
		
		
		RequestDispatcher dispatcher= req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
		
	}
}
