<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user::modify</title>
	</head>
	<body>
		<h3>user 수정하기</h3>
		
		<a href="/Ch09/user5/list.do">user 목록</a>
		
		<form action="/Ch09/user5/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" readonly value="${vo.uid}"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${requestScope.vo.name}"/></td>
				</tr>
				<tr>
					<td>생일</td>
					<td><input type="text" name="name" value="${requestScope.vo.birth}"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${vo.age}"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="age" value="${vo.address}"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="${vo.hp}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="등록하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>