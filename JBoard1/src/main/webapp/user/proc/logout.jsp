<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	session.invalidate();
	response.sendRedirect("/jBoard1/user/login.jsp?success=201");
%>