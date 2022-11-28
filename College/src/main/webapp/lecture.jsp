<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.College.bean.LectureBean"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.co.College.db.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	List<LectureBean> lectures = new ArrayList<>();

	try{
		Connection conn = DBCP.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from `lecture`");
		
		while(rs.next()){
			LectureBean lt = new LectureBean();
			lt.setLecNo(rs.getInt(1));
			lt.setLecName(rs.getString(2));
			lt.setLecCredit(rs.getInt(3));
			lt.setLecTime(rs.getInt(4));
			lt.setLecClass(rs.getString(5));
			
			lectures.add(lt);
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
		<title>lecture</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			$(function(){
				
				$('.btnRegister').click(function(){
					$('section').show();
				});
				
				$('.btnClose').click(function(){
					$('section').hide();
				});
				
				$('input[type=submit]').click(function(){
					
					let lecNo = $('input[name=lecNo]').val();
					let lecName = $('input[name=lecName]').val();
					let lecCredit = $('input[name=lecCredit]').val();
					let lecTime = $('input[name=lecTime]').val();
					let lecClass = $('input[name=lecClass]').val();
					
					let jsonData = {
							"lecNo":lecNo,
							"lecName":lecName,
							"lecCredit":lecCredit,
							"lecTime":lecTime,
							"lecClass":lecClass
					};
					
					$.ajax({
						url:'./lectureProc.jsp',
						type:'post',
						data:jsonData,
						dataType:'json',
						success:function(data){
							if(data.result == 1){
								alert('등록완료');
							}else{
								alert('등록실패');
							}
						}	
					});
				});
			});
		</script>
	</head>
	<body>
		<h3>강좌관리</h3>
		
		<a href="./lecture.jsp">강좌관리</a>
		<a href="./register.jsp">수강관리</a>
		<a href="./student.jsp">학생관리</a>
		
		<h4>강좌현황</h4>
		
		<button class="btnRegister">등록</button>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>강좌명</th>
				<th>학점</th>
				<th>시간</th>
				<th>강의장</th>
			</tr>
			<%for(LectureBean lt : lectures){ %>
			<tr>
				<td><%= lt.getLecNo() %></td>
				<td><%= lt.getLecName() %></td>
				<td><%= lt.getLecCredit() %></td>
				<td><%= lt.getLecTime() %></td>
				<td><%= lt.getLecClass() %></td>
			</tr>
			<%} %>
		</table>
		
		<section style="display: none">
			<h4>강좌등록</h4>
			
			<button class="btnClose">닫기</button>
			<table border="1">
				<tr>
					<th>번호</th>
					<td><input type="text" name="lecNo"/></td>
				</tr>
				<tr>
					<th>강좌명</th>
					<td><input type="text" name="lecName"/></td>
				</tr>
				<tr>
					<th>학점</th>
					<td><input type="text" name="lecCredit"/></td>
				</tr>
				<tr>
					<th>시간</th>
					<td><input type="text" name="lecTime"/></td>
				</tr>
				<tr>
					<th>강의장</th>
					<td><input type="text" name="lecClass"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="추가"/></td>
				</tr>
			</table>
		</section>
	</body>
</html>