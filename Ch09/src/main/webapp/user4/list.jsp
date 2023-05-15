<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user::list</title>
	</head>
	<body>
		<h3>user 목록</h3>
		<a href="./register.do">user 등록하기</a>
		<table border="1">
			<tr>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.name}</td>
					<td>${user.gender}</td>
					<td>${user.age}</td>
					<td>${user.addr}</td>
					<td>
						<a href="/Ch09/user4/modify.do?seq=${user.seq}">수정</a>
						<a href="/Ch09/user4/delete.do?seq=${user.seq}">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>