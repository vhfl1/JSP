<%@page import="kr.co.jBoard1.dao.ArticleDAO"%>
<%@page import="kr.co.jBoard1.bean.ArticleBean"%>
<%@page import="kr.co.jBoard1.db.Sql"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.co.jBoard1.db.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	String pg = request.getParameter("pg");
	
	//DAO 객체 가져오기
	ArticleDAO dao = ArticleDAO.getInstance();
	
	//글 조회수 카운트 +1
	dao.updateArticleHit(no);
	
	//글 가져오기
	ArticleBean article = dao.selectArticle(no);
	
	
%>
<%@ include file="./_header.jsp" %>
<main id="board" class="view">
    <table>
        <caption>글보기</caption>
        <tr>
            <th>제목</th>
            <td>
                <input type="text" name="title" value="<%= article.getTitle()%>" readonly/>
            </td>
        </tr>
        <%if(article.getFile() > 0){ %>
        <tr>
            <th>파일</th>
            <td>
                <a href="/jBoard1/proc/download.jsp?fno=<%= article.getFno() %>"><%= article.getOriName() %></a>
                <span><%= article.getDownload() %></span>회 다운로드
            </td>
        </tr>
        <%} %>
        <tr>
            <th>내용</th>
            <td>
                <textarea name="content" readonly><%= article.getContent() %></textarea>
            </td>
        </tr>
    </table>
    <div>
    <%if(sessUser.getUid().equals(article.getUid())){ %>
        <a href="/jBoard1/proc/deleteProc.jsp?no=<%= article.getNo() %>&pg=<%= pg %>" class="btn btnRemove">삭제</a>
        <a href="/jBoard1/modify.jsp?no=<%= article.getNo() %>&pg=<%= pg %>" class="btn btnModify">수정</a>
        <%} %>
        <a href="/jBoard1/list.jsp?pg=<%= pg %>" class="btn btnList">목록</a>
    </div>
    <!--댓글 목록-->
    <section class="commentList">
        <h3>댓글목록</h3>
        <article>
            <span class="nick">길동이</span>
            <span class="date">20-05-13</span>
            <p class="content">댓글 샘플입니다.</p>
            <%if(sessUser.getUid().equals(anObject)){ %>
            <div>
                <a href="#" class="Remove">삭제</a>
                <a href="#" class="Modify">수정</a>
            </div>
            <%} %>
        </article>
        <p class="empty">등록된 댓글이 없습니다.</p>
    </section>
    <!--댓글 쓰기-->
    <section class="commentForm">
        <h3>댓글쓰기</h3>
        <form action="#">
            <textarea name="content" placeholder="댓글내용 입력"></textarea>
            <div>
                <a href="#" class="btn btnCancel">취소</a>
                <input type="submit" class="btn btnComplete" value="작성완료"/>
            </div>
        </form>
    </section>
</main>
<%@ include file="./_footer.jsp" %>