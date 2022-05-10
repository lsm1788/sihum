<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 상세내용</h2><br>
    <div>
		<table>
		     제목 <input style="margin-bottom:7px" value="${board.title}" readonly><br>
		     내용 <input type="text" rows="4" style="margin-bottom:7px; height:100px;" value="${board.content}" readonly><br>
		     작성자 <input style="margin-bottom:7px" value="${board.writer}" readonly><br>
		     <br>
		</table>
		<input type="button" value="글 수정"
			onclick="location.href='BoardServlet?command=board_update_form&num=${board.num}'">
		<input type="button" value="글 삭제"
			onclick="location.href='BoardServlet?command=board_delete&num=${board.num}'">
		<input type="button" value="목록으로"
			onclick="location.href='BoardServlet?command=board_list'">
    </div>
</body>
</html>