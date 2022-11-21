<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서수정</title>
	</head>
	<body>
		<h3>도서수정</h3>
		
		<a href="/Bookstore2/index.jsp">처음으로</a>
		<a href="/Bookstore2/book/list.do">도서목록</a>
		
		<form action="/Bookstore2/book/modify.do" method="post">
			<table border="1">
				<tr>
					<th>도서번호</th>
					<td><input type="text" name="bookId" value="${vo.bookId}"/></td>
				</tr>
				<tr>
					<th>도서명</th>
					<td><input type="text" name="bookName" value="${vo.bookName}"/></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" name="publisher" value="${vo.publisher}"/></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price" value="${vo.price}"/></td>
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