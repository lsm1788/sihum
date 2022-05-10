<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<h2>글 등록</h2><br>
    <div>
		<form name="frm" method="post" action="BoardServlet" >
		<input type="hidden" name="command" value="board_write">
	        <table>
			     제목 <input style="margin-bottom:7px" type="text" name="title"><br>
			     내용 <textarea rows="4" style="margin-bottom:7px" name="content"></textarea><br>
			     작성자 <input style="margin-bottom:7px" type="text" name="writer"><br>
			     <br>
			</table>
			<input type="submit" value="글쓰기"
				onclick="return boardCheck()">
			<input type="reset" value="다시작성">
			<input type="button" value="목록으로"
				onclick="location.href='BoardServlet?command=board_list'">
        </form>
    </div>
</body>
</html>