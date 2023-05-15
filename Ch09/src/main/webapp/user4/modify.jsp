<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user::modify</title>
	</head>
	<body>
		<h3>user 수정하기</h3>
		
		<a href="/Ch09/user4/list.do">user 목록</a>
		
		<form action="/Ch09/user4/modify.do" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" readonly value="${vo.name}"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="radio" name="gender" value="1"/>여자</td>
					<td><input type="radio" name="gender" value="2"/>남자</td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${vo.age }"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${vo.addr }"/></td>
				</tr>
					<td colspan="2" align="right">
						<input type="submit" value="등록하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>