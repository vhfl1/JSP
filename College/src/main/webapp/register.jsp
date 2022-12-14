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
								alert('????????????');
							}else{
								alert('????????????');
							}
						}	
					});
				});
			});
		</script>
	</head>
	<body>
		<h3>????????????</h3>
		
		<a href="./lecture.jsp">????????????</a>
		<a href="./register.jsp">????????????</a>
		<a href="./student.jsp">????????????</a>
		
		<h4>????????????</h4>
		
		<button>??????</button>
		<button class="btnRegister">????????????</button>
		<table border="1">
			<tr>
				<th>??????</th>
				<th>??????</th>
				<th>?????????</th>
				<th>????????????</th>
				<th>????????????</th>
				<th>????????????</th>
				<th>??????</th>
				<th>??????</th>
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
			<h4>????????????</h4>
			
			<button class="btnClose">??????</button>
			<table border="1">
				<tr>
					<th>??????</th>
					<td><input type="text" name="stdNo"/></td>
				</tr>
				<tr>
					<th>??????</th>
					<td><input type="text" name="stdName"/></td>
				</tr>
				<tr>
					<th>????????????</th>
					<td>
						<select name="lecName">
							<option value="1">????????????</option>
							<option value="2">???????????????</option>
							<option value="3">????????????</option>
							<option value="4">????????????</option>
							<option value="5">???????????? ??????</option>
							<option value="6">?????????????????? ??????</option>
							<option value="7">???????????? ?????????</option>
							<option value="8">????????? ?????????</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="??????"/></td>
				</tr>
			</table>
		</section>
	</body>
</html>