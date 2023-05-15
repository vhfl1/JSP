package controller.user2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User2Dao;
import vo.User2Vo;

@WebServlet("/user2/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User2Vo> users = User2Dao.getInstance().selectUsers();
		
		//View에서 데이터 출력을 위한 request Scope 데이터 설정
		req.setAttribute("users", users);
		
		//forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/user2/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
