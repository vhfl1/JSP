<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>고객수정</h3>
		
		<a href="/Bookstore2/index.jsp">처음으로</a>
		<a href="/Bookstore2/customer/list.do">고객목록</a>
		
		<form action="/Bookstore2/customer/modify.do" method="post">
			<table border="1">
				<tr>
					<th>고객번호</th>
					<td><input type="text" name="custId" value="${vo.custId}"/></td>
				</tr>
				<tr>
					<th>고객명</th>
					<td><input type="text" name="name" value="${vo.name}"/></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" value="${vo.address}"/></td>
				</tr>
				<tr>
					<th>휴대폰</th>
					<td><input type="text" name="phone" value="${vo.phone}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>