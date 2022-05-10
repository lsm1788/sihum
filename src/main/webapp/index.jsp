<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//커맨드 요청 -> 프론트로 이동
	response.sendRedirect("BoardServlet?command=board_list");
%>
</body>
</html>