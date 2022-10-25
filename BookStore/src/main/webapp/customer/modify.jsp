<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="config.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@page import="bean.CustomerBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String custId = request.getParameter("custId");
	
	CustomerBean c1 = null;
	
 	try{
 		Connection conn = DBCP.getConnection();
 		String sql = "SELECT * FROM `customer` WHERE `custId`=?";
 		PreparedStatement psmt = conn.prepareStatement(sql);
 		psmt.setString(1, custId);
		
 		ResultSet rs = psmt.executeQuery();
		
 		if(rs.next()){
 			c1 = new CustomerBean();
 			
 			c1.setCustId(rs.getString(1));
 			c1.setName(rs.getString(2));
 			c1.setAddress(rs.getString(3));
 			c1.setPhone(rs.getString(4));
 		}
		
 		rs.close();
 		psmt.close();
 		conn.close();
		
 	}catch(Exception e){
 		e.printStackTrace();
 	}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>고객수정</title>
	</head>
	<body>
		<h3>고객수정</h3>
		
		<a href="../index.jsp">처음으로</a>
		<a href="./list.jsp">고객목록</a>
		
		<form action="./modifyProc.jsp" method="post">
			<table border="1">
				<tr>
					<td>고객번호</td>
					<td><input type="text" name="custId" value="<%= c1.getCustId() %>"/></td>
				</tr>
				<tr>
					<td>고객명</td>
					<td><input type="text" name="name" value="<%= c1.getName() %>"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="<%= c1.getAddress() %>"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="phone" value="<%= c1.getPhone() %>"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="수정"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>