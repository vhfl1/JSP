<%@page import="java.io.File"%>
<%@page import="kr.co.jBoard1.dao.ArticleDAO"%>
<%@page import="kr.co.jBoard1.bean.ArticleBean"%>
<%@page import="kr.co.jBoard1.db.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String pg = request.getParameter("pg");
	String no = request.getParameter("no");
	
	ArticleDAO dao = ArticleDAO.getInstance();
	
	//글삭제 + 댓글삭제
	dao.deleteArticle(no);
	
	//파일삭제(테이블)
	String fileName = dao.deleteFile(no);
	
	//파일삭제(디렉토리)
	if(fileName != null){
		
		String path = application.getRealPath("/file");
		
		File file = new File(path, fileName);
		
		if(file.exists()){
			file.delete();
		}	
	}
	response.sendRedirect("/jBoard1/list.jsp?pg="+pg);
%>