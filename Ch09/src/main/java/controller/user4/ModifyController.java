package controller.user4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User1Dao;
import dao.User4Dao;
import vo.User1Vo;
import vo.User4Vo;

@WebServlet("/user4/modify.do")
public class ModifyController extends HttpServlet{

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		User1Vo vo = User1Dao.getInstance().selectUser(seq);
		
		req.setAttribute("vo", vo);
		
		//포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/user4/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		User4Vo vo = new User4Vo();
		vo.setName(name);
		vo.setGender(gender);
		vo.setAge(age);
		vo.setAddr(addr);
		
		User4Dao.getInstance().updateUser(vo);
		
		//리다이렉트
		resp.sendRedirect("/Ch09/user1/list.do");
	}
}
