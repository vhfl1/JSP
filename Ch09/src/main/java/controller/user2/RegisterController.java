package controller.user2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User2Dao;
import vo.User2Vo;

@WebServlet("/user2/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//view forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/user2/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//POST 요청
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		String age = req.getParameter("age");
		
		User2Vo vo = new User2Vo();
		vo.setUid(uid);
		vo.setPass(pass);
		vo.setName(name);
		vo.setHp(hp);
		vo.setAge(age);
		
		User2Dao.getInstance().insertUser(vo);
		
		//리다이렉트
		resp.sendRedirect("/Ch09/user2/list.do");
	}
}
