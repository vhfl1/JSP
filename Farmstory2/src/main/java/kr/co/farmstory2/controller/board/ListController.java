
package kr.co.farmstory2.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.vo.ArticleVO;

@WebServlet("/board/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ArticleService service = ArticleService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String pg = req.getParameter("pg");
		String search = req.getParameter("search");
		
		int currentPage = service.getCurrentPage(pg);//현재 페이지 번호
		int total = 0;//전체 게시물 개수
		if(search == null) {
			total = service.selectCountTotal();
		}else {
			total = service.selectCountTotalForSearch(search);
		}
		
		int lastPageNum = service.getLastPageNum(total);//마지막 페이지 번호
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);//페이지 그룹번호
		int pageStartNum = service.getPageStartNum(total, currentPage);//페이지 시작번호
		int start = service.getStartNum(currentPage);//시작 인덱스
		
		//글 가져오기
		List<ArticleVO> articles = null;
		if(search == null) {
			articles = service.selectArticles(start);
		}else {
			articles = service.selectArticleByKeyword(search, start);
		}
		
		req.setAttribute("articles", articles);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum +1);
		req.setAttribute("search", search);
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/list.jsp");
		dispatcher.forward(req, resp);		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}