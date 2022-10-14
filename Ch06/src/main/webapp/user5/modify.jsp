<%@page import="config.DBCP"%>
<%@page import="bean.User5Bean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
  	request.setCharacterEncoding("UTF-8");
 	String uid = request.getParameter("uid");

 	User5Bean user5 = null;
	
 	try{
 		Connection conn = DBCP.getConnection("dbcp_java1db");
 		String sql = "SELECT * FROM `user5` WHERE `uid`=?";
 		PreparedStatement psmt = conn.prepareStatement(sql);
 		psmt.setString(1, uid);
		
 		ResultSet rs = psmt.executeQuery();
		
 		if(rs.next()){
 			user5 = new User5Bean();
 			user5.setName(rs.getString(2));
 			user5.setBirth(rs.getString(3));
 			user5.setAge(rs.getString(4));
 			user5.setAddr(rs.getString(5));
 			user5.setHp(rs.getString(6));
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
		<title>user5::modify</title>
	</head>
	<body>
		<h3>user5 수정</h3>
		
		<a href="../2_DBCPTest.jsp">처음으로</a>
		<a href="./list.jsp">user5 목록</a>
		
		<form action="./modifyProc.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" value="<%= uid %>" readonly /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value=""/></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" name="birth" value=""/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value=""/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value=""/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value=""/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="수정"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>