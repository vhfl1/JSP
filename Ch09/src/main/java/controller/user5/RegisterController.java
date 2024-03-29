package controller.user5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User5Dao;
import vo.User5Vo;

@WebServlet("/user5/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//view forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/user5/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//POST 요청
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		String hp = req.getParameter("hp");
		
		User5Vo vo = new User5Vo();
		vo.setUid(uid);
		vo.setName(name);
		vo.setBirth(birth);
		vo.setAge(age);
		vo.setAddress(address);
		vo.setHp(hp);
		
		User5Dao.getInstance().insertUser(vo);
		
		//리다이렉트
		resp.sendRedirect("/Ch09/user5/list.do");
	}
}
