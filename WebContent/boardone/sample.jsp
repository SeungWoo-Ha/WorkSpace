<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="boardone.BoardDAO" %>
<%
   BoardDAO dao = BoardDAO.getInstance();
   dao.mytest();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
커넥션 생성
</body>
</html>