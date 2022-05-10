<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 글 수정</h2><br>
	<div>
		<form name="frm" method="post" action="BoardServlet" >
		<input type="hidden" name="command" value="board_update">
		<input type="hidden" name="num" value="${board.num}">
	        <table>
			     제목 <input style="margin-bottom:7px" type="text" name="title"
			     		value="${board.title}"><br>
			     내용 <textarea rows="4" style="margin-bottom:7px" name="content">${board.content}</textarea><br>
			     작성자 <input style="margin-bottom:7px" name="writer"
			     		value="${board.writer}"><br>
			     <br>
			</table>
			<br>
			<br><input type="submit" value="수정완료"
					onclick="return boardCheck()">
				<input type="button" value="목록으로"
					onclick="location.href='BoardServlet?command=board_list'">
        </form>
    </div>
</body>
</html>