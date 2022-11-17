<%@page import="kr.co.farmstory1.dao.ArticleDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String group = request.getParameter("group");
	String cate = request.getParameter("cate");
	String pg = request.getParameter("pg");
	
	int start = 0;
	int total = 0;
	int lastPageNum = 0;
	int currentPage =1;
	int currentPageGroup = 1;
	int pageGroupStart = 0;
	int pageGroupEnd = 0;
	int pageStartNum = 0;
	
	if(pg != null){
		currentPage = Integer.parseInt(pg);
	}
	
	start = (currentPage -1) * 10;
	currentPageGroup = (int)Math.ceil(currentPage / 10.0);
	pageGroupStart = (currentPageGroup - 1) * 10 + 1;
	pageGroupEnd = currentPageGroup * 10;
	
	ArticleDAO dao = ArticleDAO.getInstance();
	
	//전체 게시물 개수
	total = dao.selectCountTotal(cate);
	
	//마지막 페이지 번호
	

	pageContext.include("./_"+group+".jsp");
 %>
		<main id="board" class="list">
		    <table border="0">
		        <caption>글목록</caption>
		        <tr>
		            <th>번호</th>
		            <th>제목</th>
		            <th>글쓴이</th>
		            <th>날짜</th>
		            <th>조회</th>
		        </tr>
		        <tr>
		            <td>1</td>
		            <td><a href="./view.jsp?group=<%= group %>&cate=<%= cate %>">테스트 제목입니다. [3]</a>
		            </td>
		            <td>길동이</td>
		            <td>20-05-12</td>
		            <td>12</td>
		        </tr>
		    </table>
		    <div class="page">
		        <a href="#" class="prev">이전</a>
		        <a href="#" class="num current">1</a>
		        <a href="#" class="num">2</a>
		        <a href="#" class="num">3</a>
		        <a href="#" class="next">다음</a>
		    </div>
		
		    <a href="./write.jsp?group=<%= group %>&cate=<%= cate %>" class="btnWrite">글쓰기</a>
		</main>
	        </article>
    </section>
</div>
<%@ include file="../_footer.jsp" %>
