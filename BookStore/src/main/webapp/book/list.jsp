<%@page import="bean.BookBean"%>
<%@page import="config.DBCP"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<BookBean> book = null;

	try{
		Connection conn = DBCP.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `book`");
		
		book = new ArrayList<>();
		
		while(rs.next()){
			
			BookBean b1 = new BookBean();
			
			b1.setBookId(rs.getString(1));
			b1.setBookName(rs.getString(2));
			b1.setPublisher(rs.getString(3));
			b1.setPrice(rs.getString(4));
			
			book.add(b1);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서목록</title>
	</head>
	<body>
		<h3>도서목록</h3>
		
		<a href="../index.jsp">처음으로</a>
		<a href="./register.jsp">도서등록</a>
		
		<table border="1">
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>출판사</th>
				<th>가격</th>
				<th>관리</th>
			</tr>
			
			<% for(BookBean b1 : book){ %>
			<tr>
				<td><%=b1.getBookId() %></td>
				<td><%=b1.getBookName() %></td>
				<td><%=b1.getPublisher() %></td>
				<td><%=b1.getPrice() %></td>
				<td>
					<a href="./modify.jsp?bookId=<%= b1.getBookId() %>">수정</a>
					<a href="./delete.jsp?bookId=<%= b1.getBookId() %>">삭제</a>
				</td>
			</tr>
			<% } %>
		</table>
	</body>
</html>