<%@page import="bean.CustomerBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<CustomerBean> cust = null;

	try{
		Connection conn = DBCP.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `customer`");
		
		cust = new ArrayList<>();
		
		while(rs.next()){
			
			CustomerBean c1 = new CustomerBean();
			
			c1.setCustId(rs.getString(1));
			c1.setName(rs.getString(2));
			c1.setAddress(rs.getString(3));
			c1.setPhone(rs.getString(4));
			
			cust.add(c1);
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
		<title>고객목록</title>
	</head>
	<body>
		<h3>고객목록</h3>
		
		<a href="../index.jsp">처음으로</a>
		<a href="./register.jsp">고객등록</a>
		
		<table border="1">
			<tr>
				<th>고객번호</th>
				<th>고객명</th>
				<th>주소</th>
				<th>휴대폰</th>
				<th>관리</th>
			</tr>
			
			<% for(CustomerBean c1 : cust){ %>
			<tr>
				<td><%=c1.getCustId() %></td>
				<td><%=c1.getName() %></td>
				<td><%=c1.getAddress() %></td>
				<td><%=c1.getPhone() %></td>
				<td>
					<a href="./modify.jsp?custId=<%= c1.getCustId() %>">수정</a>
					<a href="./delete.jsp?custId=<%= c1.getCustId() %>">삭제</a>
				</td>
			</tr>
			<% } %>
		</table>
	</body>
</html>