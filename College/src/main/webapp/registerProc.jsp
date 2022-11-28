<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.College.db.DBCP"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String stdNo = request.getParameter("stdNo");
	String stdName = request.getParameter("stdName");
	String lecName = request.getParameter("lecName");
	String regMidScore = request.getParameter("regMidScore");
	String regFinalScore = request.getParameter("regFinalScore");
	String regTotalScore = request.getParameter("regTotalScore");
	String regGrade = request.getParameter("regGrade");
	
	int result = 0;
	
	try{
		Connection conn = DBCP.getConnection();
		String sql = "insert into `register` values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, stdNo);
		psmt.setString(2, stdName);
		psmt.setString(3, lecName);
		psmt.setString(4, regMidScore);
		psmt.setString(5, regFinalScore);
		psmt.setString(6, regTotalScore);
		psmt.setString(7, regGrade);
		
		result = psmt.executeUpdate();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	JsonObject json = new JsonObject();
	json.addProperty("result", result);
	
	String jsonData = json.toString();
	out.print(jsonData);

%>