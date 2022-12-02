package kr.co.farmstory2.controller.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.dao.ArticleDAO;
import kr.co.farmstory2.vo.ArticleVO;

@WebServlet("/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String pg = req.getParameter("pg");
		String no = req.getParameter("no");
		
		ArticleDAO dao = ArticleDAO.getInstance();
		
		dao.deleteArticle(no);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/view.jsp");
		dispatcher.forward(req, resp);		
		
		// 파일삭제(테이블)
		String fileName = dao.deleteFile(no);
		
		// 파일삭제(디렉토리)
		if(fileName != null){
			
			String path = req.getServletContext().getRealPath("/file");
			
			File file = new File(path, fileName);
			
			if(file.exists()){
				file.delete();
			}
		}
		resp.sendRedirect("/Farmstory1/board/list.jsp?group="+group+"&cate="+cate+"&pg="+pg);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
