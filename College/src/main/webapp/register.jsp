<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.College.bean.RegisterBean"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.co.College.db.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	List<RegisterBean> register = new ArrayList<>();

	try{
		Connection conn = DBCP.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT c.`stdNo`, c.`stdName`, a.`lecName`, a.`lecNo`, b.`regMidScore`, b.`regFinalScore`, b.`regTotalScore`, b.`regGrade` ";
			   sql += "FROM `lecture` AS a JOIN `register` AS b ON a.lecNo = b.regLecNo ";
			   sql += "JOIN `student` AS c ON b.regStdNo = c.stdNo";
					  
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			RegisterBean rb = new RegisterBean();
			rb.setStdNo(rs.getString(1));
			rb.setStdName(rs.getString(2));
			rb.setLecName(rs.getString(3));
			rb.setLecNo(rs.getString(4));
			rb.setRegMidScore(rs.getInt(5));
			rb.setRegFinalScore(rs.getInt(6));
			rb.setRegTotalScore(rs.getInt(7));
			rb.setRegGrade(rs.getString(8));
			
			register.add(rb);
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
		<title>register</title>
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
					
					let stdNo = $('input[name=stdNo]').val();
					let stdName = $('input[name=stdName]').val();
					let lecName = $('select[name=lecName]').val();
					
					let jsonData = {
							"stdNo":stdNo,
							"stdName":stdName,
							"lecName":lecName
					};
					
					$.ajax({
						url:'./registerProc.jsp',
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
		<h3>수강관리</h3>
		
		<a href="./lecture.jsp">강좌관리</a>
		<a href="./register.jsp">수강관리</a>
		<a href="./student.jsp">학생관리</a>
		
		<h4>수강현황</h4>
		
		<button>검색</button>
		<button class="btnRegister">수강신청</button>
		<table border="1">
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>강좌명</th>
				<th>강좌코드</th>
				<th>중간시험</th>
				<th>기말시험</th>
				<th>총점</th>
				<th>등급</th>
			</tr>
			<%for(RegisterBean rb : register){ %>
			<tr>
				<td><%= rb.getStdNo()%></td>
				<td><%= rb.getStdName()%></td>
				<td><%= rb.getLecName()%></td>
				<td><%= rb.getLecNo()%></td>
				<td><%= rb.getRegMidScore()%></td>
				<td><%= rb.getRegFinalScore()%></td>
				<td><%= rb.getRegTotalScore()%></td>
				<td><%= rb.getRegGrade()%></td>
			</tr>
			<%} %>
		</table>
		
		<section style="display: none">
			<h4>수강신청</h4>
			
			<button class="btnClose">닫기</button>
			<table border="1">
				<tr>
					<th>학번</th>
					<td><input type="text" name="stdNo"/></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="stdName"/></td>
				</tr>
				<tr>
					<th>신청강좌</th>
					<td>
						<select name="lecName">
							<option value="1">강좌선택</option>
							<option value="2">운영체제론</option>
							<option value="3">무역영문</option>
							<option value="4">세법개론</option>
							<option value="5">빅데이터 개론</option>
							<option value="6">컴퓨팅사고와 코딩</option>
							<option value="7">사회복지 마케팅</option>
							<option value="8">컴퓨터 구조론</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="신청"/></td>
				</tr>
			</table>
		</section>
	</body>
</html>